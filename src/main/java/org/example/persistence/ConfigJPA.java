package org.example.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConfigJPA {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiUnidad");
    EntityManager em = emf.createEntityManager();// Crea el EntityManager para interactuar con la BD

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }
}





