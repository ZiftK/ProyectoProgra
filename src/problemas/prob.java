package problemas;

import pio.Msg;

public class prob {
	private static Msg msg = Msg.getInstance();
	
	public static void problema1(){
		
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

        /* 
         * Primero iniciamos sin = x, puesto que el primer término de la sumatoria es x
         * 
         * Utilizaremos el for para calcular todos los demás términos (-x^3/3! + x^5/5! - x^7/7! + ...).
         * Al iniciar sin = x, estamos obteniendo el primer término.
         * 
         *  ---------------------- Cálculo del signo ----------------------
         * 
         * Es necesario que el signbo de la sumatoria se vaya alternando, el primero es positivo (x),
         * el segundo negativo (-x^3/3!), el tercero positivo (+ x^5/5!) y así
         * sucesivamente.
         * El signo del primer término ya lo consideramos al iniciar sin = x, por lo que
         * lo ignoraremos, y tomaremos como primer término dentro del for a (-x^3/3!).
         * Por lo que el primer signo es negativo, el segundo positivo, el tercero negativo
         * y así sucesivamente.
         *      
         *      ------------------------------------
         *      Término número | 1 | 2 | 3 | 4 | 5 |
         *      ------------------------------------
         *      Signo          | - | + | - | + | - |
         *      ------------------------------------
         * 
         * El patron es que para cada número impar, el signo es negativo.
         * Conseguimos que el signo sea negativo para cada número impar, multiplicando el término calculado
         * por un (-1) elevado al número del término.
         * 
         * Por ejemplo, para (-x^3/3!), tomamos el término (x^3/3!) y lo multiplicamos por (-1)^1 ya que es 
         * el término 1. (-1)^1 = -1, y obtenemos (-x^3/3!).
         * 
         * Para (+ x^5/5!), tomamos el término (x^5/5!) y lo multiplicamos por (-1)^2 ya que es el término #2.
         * (-1)^2 = 1, y obtenemos (+ x^5/5!).
         * 
         * Este razonamiento aplica para todos los términos, ya que (-1) elevado a cualquier numero par será
         * positivo.
         * 
         * Sin embargo, no utilizamos la variable "i" declarada dentro del for para calcular el signo, puesto
         * que esta variable solo tomará valores de numeros impares, como se explica a continuación...
         * 
         * ---------------------- Cálculo de x^i y condición de salida para el FOR ----------------------
         * 
         * La sumatoria (x-x^3/3! + x^5/5! - x^7/7! + ...) requiere que nuestro ciclo for
         * tome solamente valores impares: 3, 5, 7, 9 ...
         * Para esto, iniciamos la variable "i" en 3 (int i = 3) y en cada ciclo la aumentamos en 2,
         * así para el segundo ciclo será 3 + 2 = 5, para el tercero 5 + 2 = 7, para el cuarto
         * 7 + 2 = 9 y así sucesivamente, cumpliendo la condición de generar solamente números impares.
         * 
         * Pero ¿Cómo sabemos cuando terminar el ciclo?
         * 
         * Si usamos la comparación (i < n) para terminar con la iteración, surge un problema, pues
         * si el usuario pide utilizar 3 términos, el ciclo for no se ejecutará, pues la variable i = 3
         * y no se cumple que 3 < 3.
         * 
         * En caso que el usuario ingrese que desea ocupar 4 términos, el ciclo solo se ejecutará una vez, pues
         * para la segunda iteración tendríamos que i = 4 y no se cumple que 5 < 4, por lo que bajo la condición
         * de salida (i < n) el ciclo no se ejecutará las veces necesarias.
         * 
         * Para esto, utilizaremos una variable auxiliar llamada cont, la cual guardará el valor del numero
         * del término actual.
         * 
         * ASí pues, inicializamos la variable en 1 (int cont = 1) y esta se usará para terminar el ciclo.
         * Usaremos la condición (cont <= n) y aumentaremos en 1 la variable cont después de cada iteración.
         * 
         * ESTA MISMA VARIABLE SERÁ LA QUE SE USARÁ PARA CALCULAR EL SIGNO, PUES EL SIGNO SE CALCULA
         * ELEVANDO (-1) AL NÚMERO DEL TÉRMINO
         * 
         *  ---------------------- Cálculo del factorial ----------------------
         * 
         * El último problema que queda, es el de calcular el factorial.
         * Se debe calcular el factorial de i en cada iteración.
         * 
         * Consideremos que el factorial de un numero n es ugual a n*(n-1)*(n-2)*...*(1),
         * por lo que para calcular el factorial de i, debemos multiplicarlo por todos los
         * números hasta i.
         * 
         * En el caso del ciclo, conseguimos el factorial de i, multiplicando por el factorial del
         * i anterior y por (i-1). Inicializamos el factorial en 1.
         * 
         * -----> Primera iteración
         *      fact = i*(i-1)*fact lo que es iugal a fact = 3*2*1
         *      entonces fact = 6
         * 
         * -----> Segunda iteración
         *      fact = i*(i-1)*fact lo que es iugal a fact = 5*4*6
         *      entonces fact = 120
         * 
         * Así conseguimos calcular el factorial
         */
        double sin = x;
        double fact = 1;
        int sign = -1;

        int cont = 1;
        for (int i = 3; cont <= n; i += 2)
        {
            fact *= (i-1)*i;
            
            sin += Math.pow(sign, cont) * (Math.pow(x, i)/fact);
            cont++;
        }

        System.out.println("El resultaod es: " + sin);
	}
}
