package problemas;

import pio.Msg;

public class prob {
	private static Msg msg = Msg.getInstance();
	
	public static void problema1(){
		Msg msg = Msg.getInstance();

		
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
	//****************************************Problema4*****************************************************
		public static void problema4() {
			
		int TamañoArreglo = 0;
	    boolean validacion = false;
	        
		System.out.println("Algoritmo que crea un arreglo del tamaño que el usuario quiera, con las letras del abecedario");
		System.out.println("*********************************************************************************************************");
			
		char[] abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray(); //arreglo con las letras del abecedario

	        while (!validacion) { //Se valida que el dato que ingrese el usuario sea mayor a 0
	            TamañoArreglo = msg.getIntFromInput("Ingrese la cantidad de elementos:");
	            
	            if (TamañoArreglo > 0) { //Validación 
	                validacion = true;
	            } 
	            else { //Validación 
	                System.out.println("La cantidad de números debe ser positiva. Ingrese nuevamente.");
	            }
	        }
	    int[] numeros = new int[TamañoArreglo];

	                   for (int i = 0; i < TamañoArreglo; i++) { //Se solicitan valores de acuerdo al número de elementos solicitados por el usuario
	                         boolean numeroValido = false;
   
	                   while (!numeroValido) {
	                	     int numero = msg.getIntFromInput("Ingrese el número " + (i + 1) + " (entre 1 y 27):");
	                        

	                   if (numero >= 1 && numero <= 27) { //Validación 
	                         numeros[i] = numero;
	                         numeroValido = true;
	                   } 
	                   else { //Validación 
	                         System.out.println("Número fuera de rango.");
	                   }
	                   }
	        }

	    System.out.println("Las letras del arreglo son:");
	                             for (int i = 0; i < TamañoArreglo; i++) { //Se muestran los datos Ingresados por el usuario
	                                    char letra = abecedario[numeros[i] - 1];
	                                    System.out.println("Número: " + numeros[i] + " Letra: " + letra);
	                             }
		}
}
		            
		

