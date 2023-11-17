
import java.lang.Runnable;

public class Command {

    Runnable function;
    String description;

    public Command(Runnable function, String description) {
        this.description = description;
        this.function = function;
    }

    public void run() {
        function.run();
    }

    @Override
    public String toString() {
        return description;
    }
}
