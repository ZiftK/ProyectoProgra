
import java.util.HashMap;
import java.util.TreeSet;

import pio.Msg;

import problemas.prob;

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
			input = msg.getStringFromInput("").
			replaceAll(" ","").
			toLowerCase();

			// ejecutamos
			execute(input);

		} while (next);

		msg.finalHeader();

	}

	public void help() {

		msg.pDownH("\nComandos", '*',2);

		for (String name : new TreeSet<>(probDict.keySet())) {
			System.out.printf(
					"* **[%s]** %s\n", name, probDict.get(name));
					
			System.out.println("");
		}
	}

	public void leave() {
		next = false;
	}

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

	static void LoadCommands() {

		// comando de ayuda
		Command ch = new Command(new CLI()::help, "Imprime los comandos y su descripcion");
		// comando de salida
		Command cl = new Command(new CLI()::leave, "Termina la ejecucion");
		// comando de problema 1
		Command p1 = new Command(prob::problema1, "Ejecuta el algoritmo que determina que paquete se "
						+String.format("puede comprar una persona con el dinero que recibira en diciembre ![ Problema 1 ]!"));

		Command p3 = new Command(prob::problema3, 
		"Algoritmo que calcula el seno de un ángulo *Sen x = (x-x^3/3! + x^5/5! - x^7/7! + ...)* ![Problema 3]!");
		
		// claves para comando de ayuda
		String hk = "help,?";
		// claves para comando de salida
		String lk = "leave,quit,q,exit";
		// claves para comando de problema 1
		String p1k = "compag,p1";

		// claves para comando de problema 3
		String p3k = "sin,p3";

		// asignación de comandos de ayuda
		for (String key : hk.split(","))
		{
			probDict.put(key, ch);
		}

		// asignación de comandos de salida
		for (String key : lk.split(","))
		{
			probDict.put(key, cl);
		}

		// asignación de comandos de problema 1
		for (String key : p1k.split(","))
		{
			probDict.put(key, p1);
		}
	}

}
