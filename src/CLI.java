
import java.util.HashMap;
import java.util.TreeSet;

import pio.Msg;

import problemas.prob;

/**
 * 
 * [29 de noviembre del 2023]
 * 
 * @author ZiftK
 */
public class CLI {

	// obtenemos instancia de la clase de mensajería
	static Msg msg = Msg.getInstance();

	static HashMap<String, Command> probDict = new HashMap<>();

	static boolean next;

	public static void main(String[] args) throws InterruptedException {

		// declaramos variable para almacenar input
		String input;

		// declaramos variable para mantener el ciclo
		next = true;

		// imprimir encabezado
		msg.superHeader();

		// cargamos comandos
		LoadCommands();

		do {

			// pedimos entrada
			input = msg.getStringFromInput("");
			// limpiamos entrada
			input = input.replaceAll(" ", "");
			// pasamos a minusculas
			input = input.toLowerCase();

			// ejecutamos comando
			execute(input);

		} while (next);

		// imprimimos pie de despedida
		msg.finalHeader();

	}

	/**
	 * Imprime todos los comandos almacenados y su descripción
	 */
	public void help() {

		// imprimimos encabezado de comandos
		msg.pDownH("\nComandos", '*', 2);

		// ordenamos alfabéticamente las claves de comando
		TreeSet<String> sortDict = new TreeSet<>(probDict.keySet());

		for (String name : sortDict ) {
			/*
			 * Por cada clave de comando, imprimimos la clave
			 * y despues la descripcion del comando dandole formato.
			 */
			System.out.printf(
					"* **[%s]** %s\n", name, probDict.get(name));

			System.out.println("");
		}
	}

	/**
	 * Comando para terminar loop de ejecucion
	 */
	public void leave() {
		next = false;
	}

	/**
	 * Ejecuta el comando especificado, de no encontrarse imprime
	 * un mensaje de error y ayuda.
	 * @param commandName : nombre del comando
	 */
	static void execute(String commandName) {
		try {

			// añadimos el nivel de comando
			msg.UpLevel(commandName);
			// executamos método
			probDict.get(commandName).run();

		} catch (NullPointerException e) {
			// imprimimos error
			msg.Error("Comando desconocido. Escribe '?' para obtener ayuda.");
		} finally {
			// quitamos el nivel de comando
			msg.DownLevel();
		}

	}

	/**
	 * Carga los comandos y sus descripciones
	 */
	static void LoadCommands() {

		//* ---------- Inicialización de comandos ---------- */

		// comando de ayuda
		Command ch = new Command(new CLI()::help, "Imprime los comandos y su descripcion");
		// comando de salida
		Command cl = new Command(new CLI()::leave, "Termina la ejecucion");
		// comando de problema 1
		Command p1 = new Command(prob::problema1, "Ejecuta el algoritmo que determina que paquete se "
				+ String.format("puede comprar una persona con el dinero que recibira en diciembre ![ Problema 1 ]!"));

		Command p3 = new Command(prob::problema3,
				"Algoritmo que calcula el seno de un ángulo *Sen x = (x-x^3/3! + x^5/5! - x^7/7! + ...)* ![Problema 3]!");

		Command p4 = new Command(prob::problema4,
				"Algoritmo que crea un arreglo del tamaño que el usuario quiera, con letras del abecedario");
		
		//* ---------- Claves de comandos ----------

		// claves para comando de ayuda
		String hk = "help,?";
		// claves para comando de salida
		String lk = "leave,quit,q,exit";
		// claves para comando de problema 1
		String p1k = "compag,p1";

		// claves para comando de problema 3
		String p3k = "sin,p3";

		String p4k = "abc,p4";

		//* ---------- Almacenamiento de comandos ---------- */
		
		// asignación de comandos de ayuda
		for (String key : hk.split(",")) {
			probDict.put(key, ch);
		}

		// asignación de comandos de salida
		for (String key : lk.split(",")) {
			probDict.put(key, cl);
		}

		// asignación de comandos de problema 1
		for (String key : p1k.split(",")) {
			probDict.put(key, p1);
		}

		// asignación de comandos de problema 3
		for (String key : p3k.split(",")) {
			probDict.put(key, p3);
		}

		// asignación de comandos de problema 1
		for (String key : p4k.split(",")) {
			probDict.put(key, p4);

		}

	}
}
