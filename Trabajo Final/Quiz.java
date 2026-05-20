public class Quiz extends Evaluacion {

    private int numeroPregunta;

    // Constructor
    public Quiz() {
    }

    public Quiz(String nombre, double nota, double porcentaje, int numeroPregunta) {
        super(nombre, nota, porcentaje);
        this.numeroPregunta = numeroPregunta;
    }

    //Implementación del método abstracto para mostrar la información del quiz
    @Override
    public void mostrarInfo() {
        System.out.println("=== Quiz ===");
        System.out.println("Nombre          : " + getNombre());
        System.out.println("Nota            : " + getNota());
        System.out.println("Porcentaje      : " + getPorcentaje() + "%");
        System.out.println("Num. Preguntas  : " + numeroPregunta);
        System.out.println("Aporte final    : " + calcularAporte());
    }

    // Getters y setters
    public int getNumeroPregunta() {
        return numeroPregunta;
    }

    public void setNumeroPregunta(int numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    // Método toString
    @Override
    public String toString() {
        return "Quiz{" +
                "nombre='" + getNombre() + '\'' +
                ", nota=" + getNota() +
                ", porcentaje=" + getPorcentaje() +
                ", preguntas=" + numeroPregunta +
                '}';
    }
}