public class Parcial extends Evaluacion {

    private int numeroParcial;

    public Parcial() {
    }

    public Parcial(String nombre, double nota, double porcentaje, int numeroParcial) {
        super(nombre, nota, porcentaje);
        this.numeroParcial = numeroParcial;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== Parcial ===");
        System.out.println("Nombre      : " + getNombre());
        System.out.println("Nota        : " + getNota());
        System.out.println("Porcentaje  : " + getPorcentaje() + "%");
        System.out.println("Num. Parcial: " + numeroParcial);
        System.out.println("Aporte final: " + calcularAporte());
    }

    public int getNumeroParcial() {
        return numeroParcial;
    }

    public void setNumeroParcial(int numeroParcial) {
        this.numeroParcial = numeroParcial;
    }

     @Override
    public String toString() {
        return "Parcial{" +
                "nombre='" + getNombre() + '\'' +
                ", nota=" + getNota() +
                ", porcentaje=" + getPorcentaje() +
                ", numeroParcial=" + numeroParcial +
                '}';
    }
}
