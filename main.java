package Hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<reserva> listaReservas = new ArrayList<>();

		// Menú principal
		int op;
		do {
			System.out.println("\nBienvenido al sistema de gestión del hotel");
			System.out.println("1. Realizar reserva");
			System.out.println("2. Datos del cliente");
			System.out.println("3. Salir");
			System.out.print("Ingrese una opcion: ");
			op = scanner.nextInt();
			scanner.nextLine();

			switch (op) {
			case 1:
				realizarReserva(listaReservas);
				break;
			case 2:
				datosCliente(listaReservas);
				break;
			case 3:
				System.out.println("Saliendo del sistema. . .");
				break;
			default:
				System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
			}
		} while (op != 3);

		scanner.close(); // Cerrar el Scanner al final del método main
	}

	private static void realizarReserva(List<reserva> listaReservas) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Por favor, ingrese los detalles de la reserva\n");

		System.out.print("Nombre del cliente: ");
		String nombreCliente = scanner.nextLine();

		System.out.print("DNI del cliente: ");
		long dniCliente = scanner.nextLong();

		// Consumir el salto de línea pendiente
		scanner.nextLine();

		System.out.print("Tipo de habitación (matrimonial, familiar, lujosa, singular): ");
		String tipoHabitacion = scanner.nextLine();

		System.out.print("Número de habitación (1-100): ");
		int numeroHabitacion = scanner.nextInt();
		if (numeroHabitacion < 1 || numeroHabitacion > 100) {
			System.out.println("Número de habitación inválido. Debe estar en el rango de 1 a 100.");
			return;
		}

		// Consumir el salto de línea pendiente
		scanner.nextLine();

		System.out.print("Fecha de inicio de la reserva (dd/mm/yyyy): ");
		String fechaInicioStr = scanner.nextLine();

		System.out.print("Fecha de fin de la reserva (dd/mm/yyyy): ");
		String fechaFinStr = scanner.nextLine();

		// Convertir cadenas de fecha a objetos Date
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaInicio = null;
		Date fechaFin = null;
		try {
			fechaInicio = dateFormat.parse(fechaInicioStr);
			fechaFin = dateFormat.parse(fechaFinStr);
		} catch (ParseException e) {
			System.out.println("Error al parsear las fechas.");
			return;
		}

		// Crear cliente
		cliente cliente = new cliente(nombreCliente, dniCliente);

		// Crear habitación
		hotel habitacion = new hotel(tipoHabitacion, numeroHabitacion);

		// Crear reserva
		reserva reserva = new reserva(fechaInicio, fechaFin, cliente);

		// Establecer fecha de fin
		reserva.setFechaFin(fechaFin);

		// Establecer habitación en la reserva
		reserva.setHabitacion(habitacion);

		// Agregar la reserva a la lista
		listaReservas.add(reserva);

		System.out.println("Reserva realizada con éxito");

	}


	private static void datosCliente(List <reserva> listaReservas) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el nombre del cliente: ");
		String nombreCliente = scanner.nextLine();

		// Buscar reserva por nombre del cliente
		boolean encontrado = false;
		for (reserva reserva : listaReservas) {
			if (reserva.getCliente().getName().equalsIgnoreCase(nombreCliente)) {
				encontrado = true;
				System.out.println("Datos del cliente:");
				System.out.println("Nombre: " + reserva.getCliente().getName());
				System.out.println("CI: " + reserva.getCliente().getDni());
				System.out.println("Datos de la reserva:");
				System.out.println(reserva);
				break;
			}
		}

		if (!encontrado) {
			System.out.println("No se encontró ninguna reserva para el cliente con nombre: " + nombreCliente);
		}

	}
}
