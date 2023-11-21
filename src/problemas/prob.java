package problemas;

import pio.Msg;

public class prob {
	private static Msg msg = Msg.getInstance();
	
	public static void problema1(){
<<<<<<< HEAD
=======
		Msg msg = Msg.getInstance();
>>>>>>> 2e92fec2b44599837043bdc887c961823d01b659
		
		System.out.println("Algoritmo que determina qué paquete se puede comprar una persona con el dinero que recibirá en diciembre");
		System.out.println("*********************************************************************************************************");
		double aguinaldo = msg.getDoubleFromInput("Ingrese el monto del aguinaldo en diciembre: ");
    
        String paquete;
        String[] productosElegidos = new String[5]; // 

        if (aguinaldo >= 50000) {
            paquete = "Paquete A";
            productosElegidos = new String[]{"Televisión", "Bocina", "3 pares de zapatos", "5 camisas", "5 pantalones"};
        } else if (aguinaldo >= 20000) {
            paquete = "Paquete B";
            productosElegidos = new String[]{"Grabadora", "3 pares de zapatos", "5 camisas", "5 pantalones"};
        } else if (aguinaldo >= 10000) {
            paquete = "Paquete C";
            productosElegidos = new String[]{"2 pares de zapatos", "3 camisas", "3 pantalones"};
        } else {
            paquete = "Paquete D";
            productosElegidos = new String[]{"1 par de zapatos", "2 camisas", "2 pantalones"};
        }

        System.out.println("Tabla de compra:");
        System.out.println("Aguinaldo: $" + aguinaldo);
        System.out.println("Paquete: " + paquete);
        System.out.println("Productos elegidos:");
        for (String producto : productosElegidos) {
            System.out.println(producto);
        }

        System.out.println("");
    }
	//****************************************Problema2*****************************************************
	public static void problema2() {
		
		int n;
		
		System.out.println("Algoritmo que realiza la función exponencial eˣ= 1 + x/1! + x²/2! + x³/3! +...");
		System.out.println("*********************************************************************************************************");
		
		double x = msg.getDoubleFromInput("Ingrese el valor de (x): ");
		while (true) {
            n = msg.getIntFromInput("Ingrese la cantidad de términos a calcular (n): ");
            
            if (n >= 1) {
                break; 
            } 
            else {
                System.out.println("Cantidad de términos '"+n+"' NO VALIDA. Inténtalo de nuevo.");
            }
        }

        double sm = 1, factorial = 1;

        for (int i = 1; i <= n; i++) {
        factorial *= i;
        sm += Math.pow(x, i) / factorial;
    }

        System.out.println("Resultado: " + sm);
		
	}
	//****************************************Problema3*****************************************************
	public static void problema3() {
		
		System.out.println("Algoritmo que calcula el seno de un ángulo *Sen x = (x-x^3/3! + x^5/5! - x^7/7! + ...)* ");
		System.out.println("*********************************************************************************************************");
		
		double x = msg.getDoubleFromInput("Ingrese el valor de x (en radianes)");
        int n = msg.getIntFromInput("Ingrese la cantidad de terminos a utilizar");

        double sin = x;
        double fact = 1;
        int sign = -1;

        int cont = 1;
        for (int i = 3; cont <= n; i += 2)
        {
            fact *= (fact-1)*(fact-2);
            sin += Math.pow(sign, cont) * (Math.pow(x, i)/fact);
            cont++;
        }

        System.out.println("El resultaod es: " + sin);
	}
}
