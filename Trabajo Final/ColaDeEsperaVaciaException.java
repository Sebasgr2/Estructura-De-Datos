// Cuando se intenta sacar un estudiante de una cola vacia
public class ColaDeEsperaVaciaException extends Exception {
    public ColaDeEsperaVaciaException(String mensaje) {
        super(mensaje);
    }
}