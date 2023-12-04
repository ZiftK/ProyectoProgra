
import java.util.HashMap;
import java.util.TreeSet;

import pio.Msg;

import problemas.prob;

/**
 * Esta clase contiene la ejecución principal del cli.
 * A través de ella, el usuario puede ingresar los comandos
 * necesarios para ejecutar procedimientos programados.
 * 
 * [29 de noviembre del 2023]
 * 
 * @author ZiftK
 */
public class CLI {

	// obtenemos instancia de la clase de mensajería
	static Msg msg = Msg.getInstance();

	/**Almacena los comandos */
	static HashMap<String, Command> probDict = new HashMap<>();

	/**Mantiene el loop del cli */
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
		msg.kill();

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
	 * Ejecuta el comando especificado, de no encontrarse ejecuta
	 * un comando de error y ayuda.
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

		// comando de problema 2
		Command p2 = new Command(prob::problema2,
				"Algoritmo que realiza la función exponencial eˣ= 1 + x/1! + x²/2! + x³/3! +...");

		Command p3 = new Command(prob::problema3,
				"Algoritmo que calcula el seno de un ángulo *Sen x = (x-x^3/3! + x^5/5! - x^7/7! + ...)* ![Problema 3]!");

		Command p4 = new Command(prob::problema4,
				"Algoritmo que crea un arreglo del tamaño que el usuario quiera, con letras del abecedario");
		
		Command p5 = new Command(prob::problema5,
				"Algoritmo que muestra el histograma de un arreglo de n elementos con n asteriscos donde n es el valor de cada elemento del arreglo");
		
		Command p6 = new Command(prob::problema6,
				"Algoritmo que solicite valores para un vector de 8 elementos y va cambiando sus posiciones \nel primer elemento con el ultimo, el segundo con el penutimo y así sucesivamente");
		
		Command p7 = new Command(prob::problema7,
				"Algoritmo que crea un arreglo de n elementos y muestra sus valores a la inversa");
		//* ---------- Claves de comandos ----------

		// claves para comando de ayuda
		String hk = "help,?";
		// claves para comando de salida
		String lk = "leave,quit,q,exit";
		// claves para comando de problema 1
		String p1k = "compag,p1";
		// claves para comando de problema 2
		String p2k = "exp,p2";
		// claves para comando de problema 3
		String p3k = "sin,p3";
		// claves para comnado de problema 4
		String p4k = "abc,p4";
		// claves para comando de problema 5
		String p5k = "num,p5";
		// claves para comando de problema 6
		String p6k = "pos,p6";
		// claves para comando de problema 7
		String p7k = "inv,p7";

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

		// asignación de comandos de problema 2
		for (String key : p2k.split(",")) {
			probDict.put(key, p2);
		}

		// asignación de comandos de problema 3
		for (String key : p3k.split(",")) {
			probDict.put(key, p3);
		}

		// asignación de comandos de problema 1
		for (String key : p4k.split(",")) {
			probDict.put(key, p4);
		}
		
		// asignación de comandos de problema 5
		for (String key : p5k.split(",")) {
			probDict.put(key, p5);
		}
		// asignación de comandos de problema 6
		for (String key : p6k.split(",")) {
			probDict.put(key, p6);

		}
		// asignación de comandos de problema 7
		for (String key : p7k.split(",")) {
			probDict.put(key, p7);

		}

	}
}
