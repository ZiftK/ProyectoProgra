package pio;

import java.util.Scanner;
import java.util.ArrayList;

public class Msg {

	private Scanner scan = new Scanner(System.in);

	private ArrayList<String> levels = new ArrayList<>();

	public void ph(String message) {

		String str1 = repeatChar('*', message.length() + 2);
		message += "*";
		message = "*" + message;

		System.out.printf("%s\n%s\n%s\n\n", str1, message, str1);

	}

	String repeatChar(char charac, int count) {

		return new String(new char[count]).replace('\0', charac);
	}

	public Double getDoubleFromInput(String message) {
		System.out.printf("%s> ", message);

		double cap = scan.nextDouble();

		return cap;

	}

	public int getIntFromInput(String message) {
		System.out.printf("%s> ", message);

		int cap = scan.nextInt();

		return cap;
	}

	public String getStringFromInput(String message) {
		System.out.printf("%s> ", message);

		String c = scan.next();

		return c;
	}

	public String prompt() {
		String rtn = "";

		return rtn;
	}

	public void UpLevel(String level) {

	}

	public void DownLevel() {

	}
}
