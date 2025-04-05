package com.coudevi.service;

import com.coudevi.model.Categoria;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class CategoriaService {
    private final EntityManagerFactory emf;

    public CategoriaService() {
        this.emf = Persistence.createEntityManagerFactory("manyToOnePU");
    }

    public void crearCategoria(Categoria categoria) {
        var em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
            log.info("Categoría persistida con id: " + categoria.getId());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            log.error("Error al persistir categoría: " + e.getMessage(), e);
            throw e;
        } finally {
            em.close();
        }
    }

    // Recuperar categorías con productos usando JOIN FETCH
    public List<Categoria> obtenerCategoriasConProductos() {
        var em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT DISTINCT c FROM Categoria c LEFT JOIN FETCH c.productos", Categoria.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
