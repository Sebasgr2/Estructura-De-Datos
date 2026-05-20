// Cuando el archivo CSV es invalido o tiene errores
public class ArchivoInvalidoException extends Exception {
    public ArchivoInvalidoException(String mensaje) {
        super(mensaje);
    }
}