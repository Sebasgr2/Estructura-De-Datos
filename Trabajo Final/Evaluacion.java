public abstract class Evaluacion {

    // Atributos
    private String nombre;
    private double nota;
    private double porcentaje;

    // Constructores
    public Evaluacion() {
    }

    public Evaluacion(String nombre, double nota, double porcentaje) {
        this.nombre = nombre;
        this.nota = nota;
        this.porcentaje = porcentaje;
    }

    // Calcula el aporte de esta evaluación al promedio final
    public double calcularAporte() {
        return nota * (porcentaje / 100);
    }

    // Metodo abstracto: cada tipo de evaluacion lo implementa a su manera
    public abstract void mostrarInfo();

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    // Método toString
    @Override
    public String toString() {
        return "Evaluacion{" +
                "nombre='" + nombre + '\'' +
                ", nota=" + nota +
                ", porcentaje=" + porcentaje +
                '}';
    }
}
