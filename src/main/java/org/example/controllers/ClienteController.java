package org.example.controllers;

import jakarta.persistence.EntityManager;
import org.example.entities.Cliente;
import org.example.persistence.ClienteJPA;
import org.example.persistence.ConfigJPA;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClienteController {

    // Crear las funciones controladoras que reciben y verifican los datos


    // funcion agregar cliente:
    // Instanciar un cliente

    // pedir cada uno de los datos

    // llamar a la funcion

    static Scanner scanner = new Scanner(System.in);
    private final ClienteJPA clienteJPA = new ClienteJPA();
int salir;

    public void agregarCliente() {
        System.out.println("Ingrese un nombre: ");
        String nombre = scanner.nextLine();
        while (nombre.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            System.out.print("Introduzca 1 para salir: ");
            salir = scanner.nextInt();
            scanner.nextLine();
            if (salir == 1){
                return;
            }

        }
        System.out.println("Ingrese primer apellido: ");
        String primerApellido = scanner.nextLine();
        while (primerApellido.isEmpty()) {
            System.out.println("El primer apellido no puede estar vacío.");
            System.out.print("Introduzca 1 para salir: ");
            salir = scanner.nextInt();
            scanner.nextLine();
            if (salir == 1){
                return;
            }
        }
        System.out.println("Ingrese segundo apellido: ");
        String segundoApellido = scanner.nextLine();
        while (segundoApellido.isEmpty()) {
            System.out.println("El segundo apellido no puede estar vacío.");
            System.out.print("Introduzca 1 para salir: ");
            salir = scanner.nextInt();
            scanner.nextLine();
            if (salir == 1){
                return;
            }
        }

        Cliente.Sexo sexo = null;
        while (sexo == null) {
            System.out.println("Ingrese sexo (HOMBRE/MUJER/OTRO): ");
            try {
                sexo = org.example.entities.Cliente.Sexo.valueOf(scanner.nextLine().toUpperCase()); // Convierte texto a enum
            } catch (Exception e) {
                System.out.println("Sexo no valido, porfavor ingrese HOMBRE O MUJER");
            }
        }

        System.out.println("Ingrese ciudad: ");
        String ciudad = scanner.nextLine();
        while (ciudad.isEmpty()) {
            System.out.println("La ciudad no puede estar vacía.");
            System.out.print("Introduzca 1 para salir: ");
            salir = scanner.nextInt();
            scanner.nextLine();
            if (salir == 1){
                return;
            }
        }
        System.out.println("Ingrese fecha de nacimiento DD/MM/AA:");
        String fechaDeNacimiento = scanner.nextLine();
        while (fechaDeNacimiento.isEmpty()) {
            System.out.println("La fecha de nacimiento no puede estar vacía.");
            System.out.print("Introduzca 1 para salir: ");
            salir = scanner.nextInt();
            scanner.nextLine();
            if (salir == 1){
                return;
            }
        }
        System.out.println("Ingrese telefono: ");
        String telefono = scanner.nextLine();
        while (telefono.isEmpty()) {
            System.out.println("El telefono no puede estar vacío.");
            System.out.print("Introduzca 1 para salir: ");
            salir = scanner.nextInt();
            scanner.nextLine();
            if (salir == 1){
                return;
            }
        }
        System.out.println("Ingrese correo electronico: ");
        String correoElectronico = scanner.nextLine();
        while (correoElectronico.isEmpty()) {
            System.out.println("El correo electronico no puede estar vacío.");
            System.out.print("Introduzca 1 para salir: ");
            salir = scanner.nextInt();
            scanner.nextLine();
            if (salir == 1){
                return;
            }
        }

        Cliente cliente = new Cliente(nombre, primerApellido, segundoApellido, sexo, ciudad, fechaDeNacimiento, telefono, correoElectronico);
        clienteJPA.agregar(cliente);
    }

    public void listarClientes() {

        EntityManager em = ConfigJPA.getEntityManager();
        List<Cliente> clientes = clienteJPA.listar();
        clientes.forEach(System.out::println);// Imprime cada cliente con toString()

    }

    public void actualizarCliente() {

        EntityManager em = ConfigJPA.getEntityManager();
        System.out.println("Ingresa el Id del cliente a actualizar");
        Long id = scanner.nextLong();// Lee ID a buscar
        scanner.nextLine();
        Cliente cliente = em.find(Cliente.class, id);// Busca el cliente por ID

        if (cliente == null) {
            System.out.println("El cliente no se encuentra");
            em.close();
            return;
        }

        String nombre;
        do {
            System.out.println("Ingresa el nuevo nombre");
            nombre = scanner.nextLine();
            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        }
        while (nombre.isEmpty());
        cliente.setNombre(nombre);

        String primerApellido;
        do {
            System.out.println("Ingrese el nuevo primer apellido");
            primerApellido = scanner.nextLine();

            if (primerApellido.isEmpty()) {
                System.out.println("El primer apellido no puede estar vacío.");
            }
        }
        while (primerApellido.isEmpty());
        cliente.setPrimerApellido(primerApellido);

        String segundoApellido;
        do {
            System.out.println("Ingrese el nuevo segundo apellido");
            segundoApellido = scanner.nextLine();
            if (segundoApellido.isEmpty()) {
                System.out.println("El segundo apellido no puede estar vacío.");
                System.out.println("Introduzca 1 para salir");
                int salir = scanner.nextInt();
                if (salir == 1){
                    return;
                }
            }
        }
        while (segundoApellido.isEmpty());
        cliente.setSegundoApellido(segundoApellido);


        Cliente.Sexo sexo = null;
        while (sexo == null) {
            System.out.print("Sexo (" + Arrays.toString(Cliente.Sexo.values()) + "): ");
            try { // Previene errores, si hay algun error salta al catch
                sexo = Cliente.Sexo.valueOf(scanner.nextLine());// Código que puede lanzar un error
            } catch (
                    IllegalArgumentException e) { // captura el error que puede ocurrir si la entrada del usuario no coincide con ninguna opción válida del enum Sexo.
                System.out.println("Sexo no valido, elige HOMBRE, MUJER, OTRO"); // Código que se ejecuta si ocurre un error
                // Cliente.Sexo.valueOf(...):Intenta convertir ese texto en un valor del enum Sexo definido en la clase Cliente
                // Si el usuario escribe algo inválido, esta línea lanzará una excepción del tipo IllegalArgumentException.
                // IllegalArgumentException: es el tipo específico de error que lanza valueOf() si no puede encontrar un valor válido.
            }
        }
        cliente.setSexo(sexo);

        String ciudad;
        do {
            System.out.println("Ingrese la nueva ciudad");
            ciudad = scanner.nextLine();

            if (ciudad.isEmpty()) {
                System.out.println("La ciudad no puede estar vacía.");
            }
        }
        while (ciudad.isEmpty());
        cliente.setCiudad(ciudad);

        String fechaDeNacimiento;
        do {
            System.out.println("Ingrese la nueva fecha de nacimiento DD/MM/AAAA: ");
            fechaDeNacimiento = scanner.nextLine().trim();

            if (fechaDeNacimiento.isEmpty()) {
                System.out.println("La fecha de nacimiento no puede estar vacía.");
            }
        }
        while (fechaDeNacimiento.isEmpty());
        cliente.setFechaDeNacimiento(fechaDeNacimiento);

        String telefono;
        do {
            System.out.println("Ingrese el nuevo telefono:");
            telefono = scanner.nextLine();

            if (telefono.isEmpty()) {
                System.out.println("El telefono no puede estar vacío.");
            }
        }
        while (telefono.isEmpty());
        cliente.setTelefono(telefono);

        String correoElectronico;
        do {
            System.out.println("Ingrese el nuevo correo electronico: ");
            correoElectronico = scanner.nextLine();
            if (correoElectronico.isEmpty()) {
                System.out.println("El correo electronico no puede estar vacío.");
            }
        }
        while (correoElectronico.isEmpty());
        cliente.setCorreoElectronico(correoElectronico);

        ClienteJPA.actualizar(cliente);
        System.out.println("Cliente actualizado correctamente");
    }

    public void eliminarCliente() {
        EntityManager em = ConfigJPA.getEntityManager();
        System.out.println("Ingresa el Id del cliente a eliminar");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Cliente cliente = ConfigJPA.getEntityManager().find(Cliente.class, id);
        if (cliente == null) {
            System.out.println("El cliente no se encuentra");
            em.close();
            return;
        } else {
            ClienteJPA.eliminar(cliente.getId());
            System.out.println("Cliente eliminado correctamente");
        }
    }

    public void buscarPorCiudad() {
        EntityManager em = ConfigJPA.getEntityManager();
        System.out.println("Ingrese la ciudad de los clientes a buscar");
        String ciudad = scanner.nextLine();
        // Consulta todos los clientes de la ciudad buscada
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE LOWER(c.ciudad) = :ciudad", Cliente.class)
                .setParameter("ciudad", ciudad.toLowerCase())
                .getResultList();

        if (clientes.isEmpty()) {
            System.out.println("No se encuentran clientes en esta ciudad");
        } else {
            System.out.println(" Clientes encontrados: ");
            clientes.forEach(System.out::println);
        }
        em.close();
    }
}
