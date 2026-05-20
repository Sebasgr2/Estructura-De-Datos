import java.util.LinkedList;

public class Profesor extends Persona {

    // Atruibutos
    private String departamento;
    private double salario;

    // Lista de materias que imparte el profesor
    private LinkedList<Materia> materias;

    // Constructores
    public Profesor() {
        this.materias = new LinkedList<>();
    }

    public Profesor(String nombre, String id, String email, String departamento, double salario) {
        super(nombre, id, email); // Inicializa atributos de Persona
        this.departamento = departamento;
        this.salario = salario;
        this.materias = new LinkedList<>();
    }

    // Agega una materia al profesor
    public void agregarMateria(Materia materia) {
        materias.add(materia);
        System.out.println("Materia " + materia.getNombre() + " asignada a " + nombre);
    }

    // Elimina una materia del profesor
    public void eliminarMateria(Materia materia) {
        materias.remove(materia);
        System.out.println("Materia " + materia.getNombre() + " eliminada de " + nombre);
    }

    // Muestra las materias que dicta
    public void mostrarMaterias() {
        System.out.println("=== Materias de " + nombre + " ===");
        for (Materia m : materias) {
            System.out.println("  - " + m.getNombre());
        }
    }

    // Implementación del método abstracto para mostrar la información del profesor
    @Override
    public void mostrarInfo() {
        System.out.println("=== Informacion del Profesor ===");
        System.out.println("Nombre      : " + nombre);
        System.out.println("ID          : " + id);
        System.out.println("Email       : " + email);
        System.out.println("Departamento: " + departamento);
        System.out.println("Salario     : " + salario);
        System.out.println("Materias    : " + materias.size());
    }

    // Getters y setters

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;

    }

    public LinkedList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(LinkedList<Materia> materias) {
        this.materias = materias;
    }salario;

    public LinkedList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(LinkedList<Materia> materias) {
        this.materias = materias;
    }


    // Método toString
     @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", departamento='" + departamento + '\'' +
                ", salario=" + salario +
                '}';
    }
}
