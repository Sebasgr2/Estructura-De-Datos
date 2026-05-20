// Cuando hay conflicto en el horario de un aula
public class HorarioConflictivoException extends Exception {
    public HorarioConflictivoException(String mensaje) {
        super(mensaje);
    }
}