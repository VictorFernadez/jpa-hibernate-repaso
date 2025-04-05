package com.coudevi.service;
import com.coudevi.model.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.log4j.Log4j2;
import java.util.List;
@Log4j2
public class EstudianteService {
    private final EntityManagerFactory emf;

    public EstudianteService() {
        this.emf = Persistence.createEntityManagerFactory("manyToManyPU");
    }

    public void crearEstudiante(Estudiante estudiante) {
        var em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
            log.info("Estudiante persistido con id: " + estudiante.getId());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            log.error("Error al persistir estudiante: " + e.getMessage(), e);
            throw e;
        } finally {
            em.close();
        }
    }

    // Recuperar estudiantes con cursos usando JOIN FETCH para evitar problemas de lazy loading
    public List<Estudiante> obtenerEstudiantesConCursos() {
        var em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT DISTINCT e FROM Estudiante e LEFT JOIN FETCH e.cursos", Estudiante.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void cerrar() {
        emf.close();
    }
}
