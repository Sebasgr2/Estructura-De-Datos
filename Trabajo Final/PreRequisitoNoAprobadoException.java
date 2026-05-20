// Cuando un estudiante no cumple los pre-requisitos
public class PreRequisitoNoAprobadoException extends Exception {
    public PreRequisitoNoAprobadoException(String mensaje) {
        super(mensaje);
    }
}