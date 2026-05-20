import java.util.Stack;

public class SistemaDeshacer {

    private Stack<String> pilaDeshacer;
    private Stack<String> pilaRehacer;

    public SistemaDeshacer() {
        pilaDeshacer = new Stack<>();
        pilaRehacer = new Stack<>();

    }

    public void guardarOperacion(String operacion) {
        pilaDeshacer.push(operacion);
        pilaRehacer.clear();
        System.out.println("Operacion guardada: " + operacion);
    }

    // Deshace la ultima operacion
    public void deshacer() {
        try {
            if (pilaDeshacer.isEmpty()) {
                throw new PilaDeshacerVaciaException("No hay operaciones para deshacer.");
            }
            String operacion = pilaDeshacer.pop();
            pilaRehacer.push(operacion);
            System.out.println("Operacion deshecha: " + operacion);
        } catch (PilaDeshacerVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Rehace la ultima operacion deshecha
    public void rehacer() {
        try {
            if (pilaRehacer.isEmpty()) {
                throw new PilaDeshacerVaciaException("No hay operaciones para rehacer.");
            }
            String operacion = pilaRehacer.pop();
            pilaDeshacer.push(operacion);
            System.out.println("Operacion rehecha: " + operacion);
        } catch (PilaDeshacerVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Muestra el historial de operaciones
    public void mostrarHistorial() {
        System.out.println("=== HISTORIAL DE OPERACIONES ===");
        if (pilaDeshacer.isEmpty()) {
            System.out.println("No hay operaciones registradas.");
            return;
        }
        System.out.println("Operaciones guardadas: " + pilaDeshacer.size());
        for (String op : pilaDeshacer) {
            System.out.println("  - " + op);
        }
    }
}
