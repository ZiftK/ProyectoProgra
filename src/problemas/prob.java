package problemas;

import pio.Msg;

public class prob {

    public static void problema1() {
        Msg msg = Msg.getInstance();

        System.out.println(
                "\nAlgoritmo que determina qué paquete se puede comprar una persona con el dinero que recibirá en diciembre");
        System.out.println(
                "*********************************************************************************************************");
        double aguinaldo = msg.getDoubleFromInput("Ingrese el monto del aguinaldo en diciembre");

        String paquete;
        String[] productosElegidos = new String[5]; //

        if (aguinaldo >= 50000) {
            paquete = "Paquete A";
            productosElegidos = new String[] { "Televisión", "Bocina", "3 pares de zapatos", "5 camisas",
                    "5 pantalones" };
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

        System.out.println("Tabla de compra:");
        System.out.println("Aguinaldo: $" + aguinaldo);
        System.out.println("Paquete: " + paquete);
        System.out.println("Productos elegidos:");
        for (String producto : productosElegidos) {
            System.out.println(producto);

        }

        System.out.println("");
    }

}