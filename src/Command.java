
import java.lang.Runnable;

/**
 * Esta clase está hecha para estructurar
 * la información de métodos que desean usarse como comandos
 * y emparejar con ellos su descripción.
 * 
 * [29 de noviembre del 2023]
 * @author ZiftK
 */
public class Command {

    /** Referencia a método */
    Runnable function;
    /** Descripción del método */
    String description;

    /**
     * Objeto ejecutable que accede al método run() del 
     * Runnable function
     * @param function : referencia a método
     * @param description : descripcióon del método
     */
    public Command(Runnable function, String description) {
        this.description = description;
        this.function = function;
    }

    /**
     * Ejecuta el método guardado en la referencia
     */
    public void run() {
        function.run();
    }

    @Override
    public String toString() {
        return description;
    }
} 