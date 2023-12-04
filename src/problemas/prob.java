package problemas;

import pio.Msg;

/**
 * Esta clase contiene los problemas de proyecto propuestos.
 * Cada problema se encuentra resuelto en un método dado.
 * 
 * ! ****************** IMPORTANTE ******************
 *  LA CLASE MSG IMPLEMENTA MANEJO DE EXCEPCIONES EN SUS METODOS DE CAPTURA
 *  DE DATOS, POR LO QUE SI SE UTILIZA ALGUN METODO DE DICHA CLASE, TAMBIEN SE USA
 *  UNA SENTENCIA TRY-CATCH
 * 
 * [29 de noviembre del 2023]
 * 
 * @author Ximena Viveros Pérez
 */
public class prob {
    private static Msg msg = Msg.getInstance();

    /**
     * Algoritmo que determina qué paquete se puede comprar
     * una persona con el dinero que recibirá en diciembre
     */
    public static void problema1() {

        // Obtenemos instancia global del objeto para mostrar el promt
        Msg msg = Msg.getInstance();

        double aguinaldo; // variable de captura de aguinaldo
        String paquete; // indica el paquete que puede comprarse
        String[] productosElegidos = new String[5]; // almacena los productos de cada paquete


        // imrpimimos encabezado
        System.out.println(
                "Algoritmo que determina qué paquete se puede comprar una persona con el dinero que recibirá en diciembre");
        System.out.println(
                "*********************************************************************************************************\n\n");

        
        while (true) {// ciclamos captura del dato
            
            // pedimos entrada para monto de aguinaldo
            
            aguinaldo = msg.getDoubleFromInput("Ingrese el monto del aguinaldo en diciembre: ");

            if (aguinaldo > 0) // comprobamos que sea un valor posito
            {
                break; // si es un valor positivo, rompemos el ciclo
            }
            else
            {
                msg.Error("El valor debe ser positivo o mayor a cero. Intentalo de nuevo.");
            }
            
        }


        /*
         * realizamos comparaciones de aguinaldo y asginamos el paquete
         * disponible con base en el presupuesto
         */
        if (aguinaldo >= 50000) {

            paquete = "Paquete A";
            productosElegidos = new String[]{"Television", "Bocina", "3 pares de zapatos", "5 camisas", "5 pantalones"};
        } else if (aguinaldo >= 20000) {

            paquete = "Paquete B";
            productosElegidos = new String[] { "Grabadora", "3 pares de zapatos", "5 camisas", "5 pantalones" };
        } else if (aguinaldo >= 10000) {

            paquete = "Paquete C";
            productosElegidos = new String[] { "2 pares de zapatos", "3 camisas", "3 pantalones" };
        } else {

            paquete = "Paquete D";
            productosElegidos = new String[] { "1 par de zapatos", "2 camisas", "2 pantalones" };
        }

        // impresión
        System.out.println("Tabla de compra:");
        System.out.println("Aguinaldo: $" + aguinaldo);
        System.out.println("Paquete: " + paquete);
        System.out.println("Productos elegidos:");

        // impresión de productos
        for (String producto : productosElegidos) {

            System.out.println(producto);

        }

        System.out.println("");
    }


	//****************************************Problema2*****************************************************

    /**
     * Aproxima la función exponencial usando una serie de Taylor
     */
	public static void problema2() {
		
        System.out.println("Algoritmo que realiza la función exponencial eˣ= 1 + x/1! + x²/2! + x³/3! +...");
		System.out.println("*********************************************************************************************************\n\n");
		
		int n; // cantidad te terminos
		double x = msg.getDoubleFromInput("Ingrese el valor de (x): "); // valor a aproximar
        double sm = 1; // valor aproximado
        double factorial = 1; // factorial de iteración

		while (true) {// comprobamos que la cantidad de terminos sea mayor a cero
            
            n = msg.getIntFromInput("Ingrese la cantidad de terminos a calcular (n): ");
            
            if (n >= 1) {// si lo es, rompemos el ciclo
                break; 
            } 
            else {// de lo contrario, imprimimos error
                msg.Error("Cantidad de terminos '"+n+"' NO VALIDA. Intentalo de nuevo.");
            }
        }


        for (int i = 1; i <= n; i++) {// iteramos la cantidad de terminos
            factorial *= i; // calculamos el factorial de la iteracion
            sm += Math.pow(x, i) / factorial; // sumamos a valor aproximado
        }

        System.out.println("Resultado: " + sm);
		
	}
	//****************************************Problema3*****************************************************
	public static void problema3() {
		
        
        /*
         * Primero iniciamos sin = x, puesto que el primer término de la sumatoria es x
         * 
         * Utilizaremos el for para calcular todos los demás términos (-x^3/3! + x^5/5!
         * - x^7/7! + ...).
         * Al iniciar sin = x, estamos obteniendo el primer término.
         * 
         * ---------------------- Cálculo del signo ----------------------
         * 
         * Es necesario que el signbo de la sumatoria se vaya alternando, el primero es
         * positivo (x),
         * el segundo negativo (-x^3/3!), el tercero positivo (+ x^5/5!) y así
         * sucesivamente.
         * El signo del primer término ya lo consideramos al iniciar sin = x, por lo que
         * lo ignoraremos, y tomaremos como primer término dentro del for a (-x^3/3!).
         * Por lo que el primer signo es negativo, el segundo positivo, el tercero
         * negativo
         * y así sucesivamente.
         * 
         * ------------------------------------
         * Término número | 1 | 2 | 3 | 4 | 5 |
         * ------------------------------------
         * Signo | - | + | - | + | - |
         * ------------------------------------
         * 
         * El patron es que para cada número impar, el signo es negativo.
         * Conseguimos que el signo sea negativo para cada número impar, multiplicando
         * el término calculado
         * por un (-1) elevado al número del término.
         * 
         * Por ejemplo, para (-x^3/3!), tomamos el término (x^3/3!) y lo multiplicamos
         * por (-1)^1 ya que es
         * el término 1. (-1)^1 = -1, y obtenemos (-x^3/3!).
         * 
         * Para (+ x^5/5!), tomamos el término (x^5/5!) y lo multiplicamos por (-1)^2 ya
         * que es el término #2.
         * (-1)^2 = 1, y obtenemos (+ x^5/5!).
         * 
         * Este razonamiento aplica para todos los términos, ya que (-1) elevado a
         * cualquier numero par será
         * positivo.
         * 
         * Sin embargo, no utilizamos la variable "i" declarada dentro del for para
         * calcular el signo, puesto
         * que esta variable solo tomará valores de numeros impares, como se explica a
         * continuación...
         * 
         * ---------------------- Cálculo de x^i y condición de salida para el FOR
         * ----------------------
         * 
         * La sumatoria (x-x^3/3! + x^5/5! - x^7/7! + ...) requiere que nuestro ciclo
         * for
         * tome solamente valores impares: 3, 5, 7, 9 ...
         * Para esto, iniciamos la variable "i" en 3 (int i = 3) y en cada ciclo la
         * aumentamos en 2,
         * así para el segundo ciclo será 3 + 2 = 5, para el tercero 5 + 2 = 7, para el
         * cuarto
         * 7 + 2 = 9 y así sucesivamente, cumpliendo la condición de generar solamente
         * números impares.
         * 
         * Pero ¿Cómo sabemos cuando terminar el ciclo?
         * 
         * Si usamos la comparación (i < n) para terminar con la iteración, surge un
         * problema, pues
         * si el usuario pide utilizar 3 términos, el ciclo for no se ejecutará, pues la
         * variable i = 3
         * y no se cumple que 3 < 3.
         * 
         * En caso que el usuario ingrese que desea ocupar 4 términos, el ciclo solo se
         * ejecutará una vez, pues
         * para la segunda iteración tendríamos que i = 4 y no se cumple que 5 < 4, por
         * lo que bajo la condición
         * de salida (i < n) el ciclo no se ejecutará las veces necesarias.
         * 
         * Para esto, utilizaremos una variable auxiliar llamada cont, la cual guardará
         * el valor del numero
         * del término actual.
         * 
         * ASí pues, inicializamos la variable en 1 (int cont = 1) y esta se usará para
         * terminar el ciclo.
         * Usaremos la condición (cont <= n) y aumentaremos en 1 la variable cont
         * después de cada iteración.
         * 
         * ESTA MISMA VARIABLE SERÁ LA QUE SE USARÁ PARA CALCULAR EL SIGNO, PUES EL
         * SIGNO SE CALCULA
         * ELEVANDO (-1) AL NÚMERO DEL TÉRMINO
         * 
         * ---------------------- Cálculo del factorial ----------------------
         * 
         * El último problema que queda, es el de calcular el factorial.
         * Se debe calcular el factorial de i en cada iteración.
         * 
         * Consideremos que el factorial de un numero n es ugual a
         * n*(n-1)*(n-2)*...*(1),
         * por lo que para calcular el factorial de i, debemos multiplicarlo por todos
         * los
         * números hasta i.
         * 
         * En el caso del ciclo, conseguimos el factorial de i, multiplicando por el
         * factorial del
         * i anterior y por (i-1). Inicializamos el factorial en 1.
         * 
         * -----> Primera iteración
         * fact = i*(i-1)*fact lo que es iugal a fact = 3*2*1
         * entonces fact = 6
         * 
         * -----> Segunda iteración
         * fact = i*(i-1)*fact lo que es iugal a fact = 5*4*6
         * entonces fact = 120
         * 
         * Así conseguimos calcular el factorial
         * 
         */
        System.out.println("Algoritmo que calcula el seno de un angulo *Sen x = (x-x^3/3! + x^5/5! - x^7/7! + ...)* ");
        System.out.println("*********************************************************************************************************\n\n");
        
        double x = msg.getDoubleFromInput("Ingrese el valor de x (en radianes)"); // valor a aproximar
        int n; // cantidad de factores
        double sin = x; // valor aproximado
        double fact = 1; // factorial de iteracion
        int sign = -1; // signo de termino
        int cont = 1; // contador de terminos

        while (true) {// ciclamos para asegurarnos que se ingrese un numero

            n = msg.getIntFromInput("Ingrese la cantidad de terminos a utilizar");

            if (n <= 0) // si el valor es negativo o igual a cero
            {// imprimimos error
                msg.Error("La cantidad de terminos debe ser positiva. Intentalo de nuevo.");
            }
            else
            {
                // de lo contrario rompemos el ciclo
                break;
            }
        }
        for (int i = 3; cont <= n; i += 2) { // iteramos desde 3 hasta  la cantidad de terminos

            fact *= (i - 1) * i; // calculamos factorial de i

            sin += Math.pow(sign, cont) * (Math.pow(x, i) / fact); // sumamos a aproximacion
            cont++; // aumentamos el contador de terminos usados
        }

        System.out.println("El resultado es: " + sin);
	}
	//****************************************Problema4*****************************************************
		public static void problema4() {
			
            
            System.out.println("Algoritmo que crea un arreglo del tamaño que el usuario quiera, con las letras del abecedario");
            System.out.println("*********************************************************************************************************\n\n");
            
            int tamArreglo; // tamaño del arreglo
            char[] abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray(); //arreglo con las letras del abecedario
            int[] numeros; // arreglo para numeros; 
            int numero; // captura de numero

            while (true) { //Se valida que el dato que ingrese el usuario sea mayor a 0
                tamArreglo = msg.getIntFromInput("Ingrese la cantidad de elementos:");
                
                if (tamArreglo > 0) { //Validación 
                    break;// rompemos ciclo
                } 
                else { //Validación 
                    msg.Error("La cantidad de numeros debe ser positiva. Ingrese nuevamente.");
                }
            }

            numeros = new int[tamArreglo];// establecemos el tamaño del arreglo

            for (int i = 0; i < tamArreglo; i++) { //Se solicitan valores de acuerdo al número de elementos solicitados por el usuario

                while (true) {// ciclamos para validar numero
                    
                    numero = msg.getIntFromInput("Ingrese el numero " + (i + 1) + " (entre 1 y 27)");

                    if (numero >= 1 && numero <= 27) { //Validación 
                            numeros[i] = numero;// almacenamos numero
                            break;// rompemos ciclo
                    } 
                    else { //Validación 
                            msg.Error("Numero fuera de rango.");
                    }
                }
            }

            System.out.println("Las letras del arreglo son:");
                                    for (int i = 0; i < tamArreglo; i++) { //Se muestran los datos Ingresados por el usuario
                                            char letra = abecedario[numeros[i] - 1];
                                            System.out.println("Numero: " + numeros[i] + " Letra: " + letra);
                                    }
		}
		
		//****************************************Problema5*****************************************************
        
		public static void problema5() {
			int n;
			System.out.println("Algoritmo que muestra el histograma de un arreglo de n elementos con n asteriscos donde n es el valor de cada elemento del arreglo");
            System.out.println("*********************************************************************************************************\n\n");
            
            // Pedir al usuario el tamaño del arreglo
            n = msg.getIntFromInput("Ingrese la cantidad de elementos del arreglo: ");
           

            // Validar que se ingrese un entero no negativo
            while (true) { //Se utiliza ciclo while para solicitar datos al usuario hasta que sean de valor correcto
                try {
                    n = Integer.parseInt(msg.getStringFromInput("Ingrese la cantidad de elementos del arreglo (entero positivo): ")); 
                    if (n > 0) {
                        break;
                    } else {
                        System.out.println("Ingrese un entero valido.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un entero valido.");
                }
            }

            // Crear el arreglo
            int[] arreglo = new int[n];

            // Pedir al usuario los elementos del arreglo
                       for (int i = 0; i < n; i++) {
                            System.out.print("Ingrese el valor del elemento " + (i + 1) + ": ");
                            int elemento = 0;

                // Validar que se ingrese un entero no negativo
                       while (true) {
                              try {
                    	//se convierten los valores ingresados a enteros para poder guardar cada dato del arreglo
                               elemento = Integer.parseInt(msg.getStringFromInput("Ingrese el valor del elemento " + (i + 1) + ": "));
                          if (elemento >= 0) {
                              break;
                          } else {
                               System.out.println("Ingrese un elemento valido.");
                          }
                          } 
                            catch (NumberFormatException e) {
                    	       System.out.println("Ingrese un elemento valido.");
                          }
                       }

                arreglo[i] = elemento;
            }

            // Mostrar el histograma 
            System.out.println("Histograma:");
                                    for (int i = 0; i < n; i++) { //se utiliza un ciclo for para imprimir el arreglo con los valores que usuario proporciono 
                                       System.out.print(arreglo[i] + "->");
                                    for (int j = 0; j < arreglo[i]; j++) { //se utiliza el for para imprimir los '*' dependiendo a los valores que el usuario dio 
                                       System.out.print("*");
                                    }
            System.out.println();
            }
		}
		//****************************************Problema6*****************************************************
        
				
		public static void problema6() {
			
			System.out.println("Algoritmo que solicita valores para un vector de 8 elementos y va cambiando sus posiciones \nel primer elemento con el ultimo, el segundo con el penutimo y asi sucesivamente");
            System.out.println("*********************************************************************************************************\n\n");
            
            //se crea vector con 8 elementos
	        int[] vector = new int[8];

	        System.out.println("Ingrese los 8 elementos del vector:");
	        for (int i = 0; i < 8; i++) { //Se solicitan los valores mediante un for para no solicitar elemento a elemento
	        	vector[i]=msg.getIntFromInput("Elemento " + (i + 1) + ": ");
	            
	        }

	        // Intercambiar las posiciones de los elementos
	        for (int i = 0; i < vector.length / 2; i++) { 
	        	
	         // Se guarda temporalmente el valor del elemento actual
	            int temp = vector[i];
	         // Asignar el valor del elemento opuesto al elemento actual
	            vector[i] = vector[vector.length - 1 - i];
	         // Asignar el valor temporal al elemento opuesto
	            vector[vector.length - 1 - i] = temp;
	        }

	        // Imprimir el vector después del intercambio
	        System.out.println("Vector despues del intercambio:");
	        for (int elemento : vector) {
	            System.out.print(elemento + " ");
	        }
		}
		//****************************************Problema7*****************************************************
        
		
				public static void problema7() {
					int n = 0;
					
			        while (n <= 0) {
			        	String input = msg.getStringFromInput("Ingrese la cantidad de elementos del arreglo (debe ser un numero positivo): ");
			     
			                try {
			                    n = Integer.parseInt(input);
			                    if (n <= 0) {
			                    	System.out.println("Error, ingrese un numero positivo.");
			                    }
			                } catch (NumberFormatException e) {
			                	System.out.println("Ingrese un numero valido.");
			                }
			            }

			            // Crear un arreglo n
			            int[] arreglo = new int[n];

			            // Leer los elementos del usuario
			            System.out.println("Ingrese los elementos del arreglo:");
			            for (int i = 0; i < n; i++) {
			                String inputElemento = msg.getStringFromInput("Elemento " + (i + 1) + ": ");
			                
			                try {
			                    arreglo[i] = Integer.parseInt(inputElemento);
			                } catch (NumberFormatException e) {
			                   System.out.println("Ingrese un numero valido.");
			                    i--; // Decrementar el indice para que se pida el mismo elemento nuevamente
			                }
			            }

			        // Imprimir el arreglo en orden inverso
			        System.out.println("Arreglo en orden inverso:");
			        for (int i = n - 1; i >= 0; i--) {
			            System.out.print(arreglo[i] + " ");
			        }
				
				}
}
