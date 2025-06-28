package org.example.persistence;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;

import java.util.List;
import java.util.regex.Matcher;

public class ClienteJPA {


    // metodos que tocan la BD

    // Funcion que inserta un cliente en la base de datos. ejemplo:
    // Agregar cliente
    // Tiene que recibir un objeto cliente
    // Crear un EntityManager usando el ConfigJPA.getEntityManager
    // Hacer el begin
    // Hacer la accion correspondiente. ejemplo: merge o remove
    // Hacer el commit
    // em.close

    public void agregar(Cliente cliente) {
        EntityManager em = ConfigJPA.getEntityManager();
        em.getTransaction().begin();// Inicia transacción
        em.persist(cliente); // Añade el Cliente a la Base de datos
        em.getTransaction().commit();// Confirma la transacción
        em.close();// Cierra el EntityManager
    }

    public List<Cliente> listar() {
        EntityManager em = ConfigJPA.getEntityManager();
        List<Cliente> clientes = em.createQuery("FROM Cliente", Cliente.class).getResultList(); // Consulta todos los clientes
        em.close();// Cierra el EntityManager
        return clientes;
    }

    public static void actualizar(Cliente cliente) {
        EntityManager em = ConfigJPA.getEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);// Guarda los cambios actualizados
        em.getTransaction().commit();
        em.close();
    }

    public static void eliminar(long id) {
        EntityManager em = ConfigJPA.getEntityManager();
        em.getTransaction().begin();// Inicia transacción
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente != null) {
            em.remove(cliente); // Añade el Cliente a la Base de datos

        }
        em.getTransaction().commit();// Confirma la transacción
        em.close();// Cierra el EntityManager
    }
}