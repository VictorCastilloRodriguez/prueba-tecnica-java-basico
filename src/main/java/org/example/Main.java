package org.example;

import org.example.controllers.ClienteController;

import java.util.Scanner;


public class Main {
    int opcion = 0;

    private static final Scanner scanner = new Scanner(System.in);

    private static final ClienteController controller = new ClienteController();

    public static void main(String[] args) {


        while (true) {


            System.out.println("1. Agregar Cliente");
            System.out.println("2. Listar Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Buscar por ciudad");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");


            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    controller.agregarCliente();
                    break;

                case 2:
                    controller.listarClientes();
                    break;

                case 3:
                    controller.actualizarCliente();
                    break;

                case 4:
                    controller.eliminarCliente();
                    break;

                case 5:
                    controller.buscarPorCiudad();
                    break;

                case 6:
                    System.out.println("Que tenga un buen dia");
                    return;
                default:
                    System.out.println("Opcion no valida");


            }
        }
    }
}
