package com.coudevi.service;

import com.coudevi.model.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class PersonaService {
    private final EntityManagerFactory managerFactory;

    public PersonaService() {
        this.managerFactory = Persistence.createEntityManagerFactory("oneToOnePU");
    }
    public void crearPersona(Persona persona){
        EntityManager entityManager = managerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(persona);
            entityManager.getTransaction().commit();
            log.info("Persona persistida con id: " + persona.getId());
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            log.error("Erro al persistir persona" + e.getMessage());
            throw  e;
        } finally {
            entityManager.close();
        }
    }

    public List<Persona> obtenerPersonas(){
        EntityManager entityManager = managerFactory.createEntityManager();
        try{
            String jpql = "SELECT p FROM Persona p LEFT JOIN FETCH p.documento";
            return entityManager.createQuery(jpql, Persona.class).getResultList();
        }finally {
            entityManager.close();
        }
    }
    public void cerrar(){
        managerFactory.close();
    }
}
