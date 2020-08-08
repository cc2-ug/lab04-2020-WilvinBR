import java.io.*;
import java.util.*;

public class ManageMyParkingLot {

	private static final BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	private static void printMenu() {
		System.out.println("    MENU - PARKEITO: ");
		System.out.println("------------------------");
		System.out.println("1. Desplegar parqueo");
		System.out.println("2. Parquear aleatoriamente");
		System.out.println("3. Parquear en parqueo definido");
		System.out.println("4. Vaciar un parqueo (aleatoriamente)");
		System.out.println("5. Salir\n");
		System.out.print("Ingrese opcion: ");
	}

	public static void printParkingLot(ParkingLot p) {
		onlyprintParkingLot(p);
		System.out.println("Regresando a menu principal ....");
		System.out.println();
		System.out.println();
		try {
			Thread.sleep(500);
		} catch (Exception e) {}
	}

	public static void onlyprintParkingLot(ParkingLot p) {
		System.out.println();
		System.out.println("ESTADO ACTUAL DEL PARQUEO: ");
		System.out.println(p);
		System.out.println();
	}

	public static void randomParking(ParkingLot p) {
		System.out.println();
		System.out.println("Un carro intenta parquearse ....");
		System.out.println("Buscando parqueos disponibles ...");
		int number = p.parkInRandomSpace();
		if (number == -1) {
			System.out.println("PARQUEO LLENO... carro no se pudo parquear...");
		} else {
			System.out.println("CARRO PARQUEADO en parqueo No. " + number);
		}
		printParkingLot(p);
	}

	public static void definedParking(ParkingLot p) throws Exception {
		System.out.println();
		System.out.println("Un carro intenta parquearse ....");
		onlyprintParkingLot(p);
		if (p.isFull()) {
				System.out.println("PARQUEO LLENO!");
		} else {
			boolean parked = false;
			System.out.print("Ingrese numero de parqueo para el carro: ");
			while (!parked) {
				try {
					int space = Integer.parseInt(teclado.readLine());
					boolean ableToPark = p.parkInLot(space);
					if (ableToPark) {
						System.out.println("CARRO PARQUEADO EN espacio elegido");
					} else {
						System.out.println("Parqueo invalido u ocupado");
						System.out.print("Intente de nuevo: ");
					}
					parked = ableToPark;
				} catch (NumberFormatException nfe) {
					System.out.println("Numero de parqueo invalido: No es un numero");
					System.out.print("Intente de nuevo: ");
				}
			}
		}
		printParkingLot(p);
	}

	public static void unparking(ParkingLot p) {
		if (p.isEmpty()) {
			System.out.println("PARQUEO VACIO!!");
			printParkingLot(p);
		} else {
			System.out.println();
			System.out.println("Un carro se esta yendo ....");
			int size = p.size();
			Random r = new Random();
			boolean left = false;
			while (!left) {
				int chosen = r.nextInt(size) + 1;
				if (!p.isEmpty(chosen)) {
					p.emptyLot(chosen);
					left = true;
					System.out.println("CARRO SALIO de parqueo No. " + chosen);
				}
			}
			printParkingLot(p);

			//onlyprintParkingLot(p);
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println("\nInicializando....");
		System.out.println("Creando parqueo de 15 posiciones");
		ParkingLot parqueo = new ParkingLot(15);
		System.out.println("Parqueo creado: ");
		System.out.println(parqueo);
		System.out.println("Terminando inicializacion ...");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		System.out.println("\n\n");
		int response = 0;
		do {
			printMenu();
			try {
				response = Integer.parseInt(teclado.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Opcion invalida... \ndesplegando menu de nuevo ...\n");
			}
			switch (response) {
				case 1:
					printParkingLot(parqueo);
					break;
				case 2:
					randomParking(parqueo);
					break;
				case 3:
					definedParking(parqueo);
					break;
				case 4:
					unparking(parqueo);
					break;
			}

		} while (response != 5);


	}
}
