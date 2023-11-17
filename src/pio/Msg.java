package pio;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Esta clase está diseñada para agilizar la entrada y salida
 * de datos mediante la linea de comandos.
 * [11/16/2023]
 * 
 * @author ZiftK
 */
public class Msg {

	// scanner para entrada y salida de datos
	private Scanner scan = new Scanner(System.in);

	/** Niveles de comandos */
	private ArrayList<String> levels = new ArrayList<>();
	/** Variable de impresión para niveles de comandos */
	private String level = "cli";

	// singleton
	public static Msg instance;

	/**
	 * Método para obtener la instancia de Msg
	 * 
	 * @return
	 */
	public static Msg getInstance() {
		return (Msg.instance == null) ? new Msg() : Msg.instance;
	}

	/**
	 * Imprime el super encabezado
	 * 
	 * @throws InterruptedException
	 */
	public void superHeader() throws InterruptedException {
		String[] lines = {
				" ____   _     ____            ___     ____    ____  ",
				"| ___| | |   |_  _|  ___     / _ \\   |    |  |    | ",
				"| |__  | |_   _||_  |___|   / /_\\ \\  | ___|  |  __| ",
				"|____| |___| |____|        /_/   \\_\\ |_|     |_|    "
		};

		int delay = 5; // Milisegundos de retardo entre letras

		// Imprime cada letra progresivamente
		for (String line : lines) {
			for (int i = 0; i < line.length(); i++) {
				System.out.print(line.charAt(i));
				Thread.sleep(delay);
			}
			Thread.sleep(5); // Retardo adicional entre líneas
			System.out.println();
		}

		System.out.println();

		String name = "Por: Ximena Viveros Perez y Alvaro Caballero Laguna ";
		int espacios = name.length(); // Espacios a recorrer
		String arrow = ">-----|>";
		String aux = "";

		for (char charac : arrow.toCharArray()) {
			aux += charac;
			System.out.print(aux);
			System.out.print("\r");
		}
		aux = "";
		// Mostrar la flecha
		for (int i = 0; i < espacios; i++) {

			aux += name.toCharArray()[i];
			System.out.print(aux);

			System.out.print(arrow);
			try {
				Thread.sleep(Math.max(i + 1 - 3, 1)); // Retardo para simular movimiento
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("\r"); // Regresar al inicio de la línea
		}

		System.out.println("\n");

	}

	/**
	 * Imprime un mensaje como encabezado
	 * 
	 * @param message : mensaje a imprimir
	 */
	public void ph(String message, char charac) {

		String str1 = repeatChar(charac, message.length() + 2);
		message += charac;
		message = charac + message;

		System.out.printf("%s\n%s\n%s\n\n", str1, message, str1);

	}

	/**
	 * Imprime un mensaje como encabezado subrayado,
	 * con una longitud extra
	 * 
	 * @param message : mensaje a imprimir
	 * @param charac  : caracter para subrayar
	 * @param offset  : extra de longitud
	 */
	public void pDownH(String message, char charac, int offset) {

		String str1 = repeatChar(charac, message.length() + 2);
		str1 += repeatChar(charac, offset);

		System.out.printf("%s\n%s\n\n", message, str1);
	}

	public void pDownH(String message, char charac) {
		pDownH(message, charac, 2);
	}

	/**
	 * Genera un string usando un carácter una cantidad determinada de veces
	 * 
	 * @param charac : carácter a imprimir
	 * @param count  : cantidad de carácteres
	 * @return : string con carácter repetido
	 */
	String repeatChar(char charac, int count) {

		return new String(new char[count]).replace('\0', charac);
	}

	/**
	 * Genera un mensaje por consola y recibe un double para retornarlo
	 * 
	 * @param message : mensaje a imprimir
	 * @return
	 */
	public Double getDoubleFromInput(String message) {
		System.out.printf("%s%s> ", level, message);

		double cap = scan.nextDouble();

		return cap;

	}

	/**
	 * Genera un mensaje por consola y recibe un entero para retornarlo
	 * 
	 * @param message : mensaje a imprimir
	 * @return
	 */
	public int getIntFromInput(String message) {
		System.out.printf("%s%s> ", level, message);

		int cap = scan.nextInt();

		return cap;
	}

	public void Error(String message) {
		System.out.println("\n[Error] " + message + "\n\n");
	}

	/**
	 * Genera un mensaje por consola y recibe un string para retornarlo
	 * 
	 * @param message
	 * @return
	 */
	public String getStringFromInput(String message) {
		System.out.printf("%s%s> ", level, message);

		String c = scan.next();

		return c;
	}

	/**
	 * Agrega un comando al nivel de comandos
	 * 
	 * @param level : nivel de comando
	 */
	public void UpLevel(String level) {
		this.level += ">" + level;
		levels.add(level);
	}

	/**
	 * Remueve el ultimo nivel de comandos
	 */
	public void DownLevel() {

		levels.remove(levels.size() - 1);
		level = "cli";
		for (String lvl : levels) {
			level += ">" + lvl;
		}
	}
}
