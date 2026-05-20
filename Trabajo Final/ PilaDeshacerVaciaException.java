// Cuando no hay operaciones para deshacer
public class PilaDeshacerVaciaException extends Exception {
    public PilaDeshacerVaciaException(String mensaje) {
        super(mensaje);
    }
}