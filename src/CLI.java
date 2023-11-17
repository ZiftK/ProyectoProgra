
import java.util.HashMap;

import pio.Msg;

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

			// ejecutamos
			execute(input);

		} while (next);

	}

	public void help() {

		msg.pDownH("\nComandos", '-');

		System.out.println("");

		for (String name : probDict.keySet()) {
			System.out.println("");
			System.out.printf(
					"%s : %s\n", name, probDict.get(name));
		}

		System.out.println("");
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
			msg.Error("Comando desconocido");
		} finally {
			// quitamos el nivel de comando
			msg.DownLevel();
		}

	}

	static void LoadCommands() {

		probDict.put(
				"help",
				new Command(new CLI()::help, "Imprime los comandos y su descripcion"));

		probDict.put(
				"?",
				new Command(new CLI()::help, "Imprime los comandos y su descripcion"));

		probDict.put(
				"leave",
				new Command(new CLI()::leave, "Termina la ejecucón"));
	}

}
