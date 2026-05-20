public class ExamenFinal extends Evaluacion {

    private boolean habilitado;

    public ExamenFinal() {
    }

    // Constructor parametrizado
    public ExamenFinal(String nombre, double nota, double porcentaje, boolean habilitado) {
        super(nombre, nota, porcentaje);
        this.habilitado = habilitado;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== Examen Final ===");
        System.out.println("Nombre      : " + getNombre());
        System.out.println("Nota        : " + getNota());
        System.out.println("Porcentaje  : " + getPorcentaje() + "%");
        System.out.println("Habilitado  : " + (habilitado ? "Si" : "No"));
        System.out.println("Aporte final: " + calcularAporte());
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "ExamenFinal{" +
                "nombre='" + getNombre() + '\'' +
                ", nota=" + getNota() +
                ", porcentaje=" + getPorcentaje() +
                ", habilitado=" + habilitado +
                '}';
    }
}
