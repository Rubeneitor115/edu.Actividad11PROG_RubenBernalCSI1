/**
 * Ruben Bernal Ramos, CSI1
 */

package controladores;

import java.util.Scanner;

import dtos.TareaDto;

/**
 * Clase controladora de la aplicacion
 * @author rbr - 131224
 *
 */
public class Inicio {

	/**
	 * Metodo de entrada de la aplicacion
	 * rbr - 131224
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
        TareaDto tarea = null;
        boolean cerrar = true;

        //Mensaje de bienvenida
        System.out.println("Bienvenido al sistema de gestión de tareas\n");

        while (cerrar) {
        	//Muestro el menu por consola
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar una nueva tarea");
            System.out.println("2. Iniciar el trabajo en una tarea");
            System.out.println("3. Añadir tiempo");
            System.out.println("4. Finalizar una tarea");
            System.out.println("5. Cancelar una tarea");
            System.out.println("6. Ver el estado de la tarea");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            //Recojo la opcion selecionada por el usuario
            int opcion = sc.nextInt();
            System.out.println();

            //Accedo a la opcion seleccionada por el usuario
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la tarea: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese el tiempo estimado en horas: ");
                    int tiempoEstimado = sc.nextInt();
                    tarea = new TareaDto(nombre, tiempoEstimado);
                    System.out.println("Tarea agregada exitosamente. Estado inicial: pendiente\n");
                    break;
                case 2:
                    if (tarea == null) {
                        System.out.println("No hay ninguna tarea para iniciar. Agregue una nueva tarea primero.\n");
                    } else if (!tarea.getEstado().equals("pendiente")) {
                        System.out.println("La tarea ya no está pendiente. Estado actual: " + tarea.getEstado() + "\n");
                    } else {
                        tarea.setEstado("en progreso");
                        System.out.println("Tarea iniciada. Estado: en progreso\n");
                    }
                    break;
                case 3:
                    if (tarea == null || !tarea.getEstado().equals("en progreso")) {
                        System.out.println("No hay ninguna tarea en progreso para añadir tiempo.\n");
                    } else {
                        System.out.print("Ingrese el tiempo trabajado en horas: ");
                        int tiempoTrabajado = sc.nextInt();
                        tarea.anyadirTiempo(tiempoTrabajado);
                        System.out.println("Tiempo añadido exitosamente. Tiempo total trabajado: " + tarea.getTiempoTotalTrabajado() + " horas\n");
                    }
                    break;
                case 4:
                    if (tarea == null || !tarea.getEstado().equals("en progreso")) {
                        System.out.println("No hay ninguna tarea en progreso para finalizar.\n");
                    } else {
                        tarea.setEstado("completada");
                        System.out.println("Tarea completada. Estado: completada\n");
                        if (tarea.getTiempoTotalTrabajado() > tarea.getTiempoEstimado()) {
                            System.out.println("Aviso: El tiempo total dedicado (" + tarea.getTiempoTotalTrabajado() + " horas) excede el tiempo estimado (" + tarea.getTiempoEstimado() + " horas).\n");
                        }
                    }
                    break;
                case 5:
                    if (tarea == null) {
                        System.out.println("No hay ninguna tarea para cancelar.\n");
                    } else {
                        tarea.setEstado("cancelada");
                        tarea.reiniciarTiempo();
                        System.out.println("Tarea cancelada. Estado: cancelada. Tiempo trabajado: 0 horas\n");
                    }
                    break;
                case 6:
                    if (tarea == null) {
                        System.out.println("No hay ninguna tarea registrada.\n");
                    } else {
                        System.out.println("Estado de la tarea:");
                        System.out.println("Nombre: " + tarea.getNombre());
                        System.out.println("Estado: " + tarea.getEstado());
                        System.out.println("Tiempo estimado: " + tarea.getTiempoEstimado() + " horas");
                        System.out.println("Tiempo trabajado: " + tarea.getTiempoTotalTrabajado() + " horas\n");
                    }
                    break;
                case 7:
                    System.out.println("Gracias por usar el sistema de gestión de tareas. ¡Hasta luego!");
                    cerrar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.\n");
            }
        }

        sc.close();

	}

}
