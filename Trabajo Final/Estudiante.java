import java.util.LinkedList;

public class Estudiante extends Persona {

    // Atributos
    private int semestre;
    private Double[][] notas;

    // lista de materia y historial de materias
    private LinkedList<Materia> materias;
    private LinkedList<String> historialMaterias;

    // Constructores
    public Estudiante() {
        this.notas = new Double[10][20];
        this.materias = new LinkedList<>();
        this.historialMaterias = new LinkedList<>();
    }

    public Estudiante(String nombre, String id, String email, int semestre) {
        super(nombre, id, email); 
        this.semestre = semestre;
        this.notas = new Double[10][20];
        this.materias = new LinkedList<>();
        this.historialMaterias = new LinkedList<>();
    }

    // Agregar materia
    public void agregarMateria(Materia materia) {
        materias.add(materia);
        historialMaterias.add(materia.getNombre());
    }

    // Eliminar materia
    public void eliminarMateria(Materia materia) {
        materias.remove(materia);

    }

    // Registrar nota
    public void registrarNota(int semestre, int posicion, double nota) {
        notas[semestre][posicion] = nota;
    }

    // Calcula el promedio de un semesqtre específico
    public double calcularPromedio(int semestre) {
        double suma = 0;
        int cantidad = 0;
        for (int i = 0; i < 20; i++) {
            if (notas[semestre][i] != null) {
                suma += notas[semestre][i];
                cantidad++;
            }
        }
        return cantidad == 0 ? 0 : suma / cantidad;
    }

    // Calcula el promedio acumulado de todos los semestres
    public double calcularPromedioAcumulado() {
        double suma = 0;
        int cantidad = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (notas[i][j] != null) {
                    suma += notas[i][j];
                    cantidad++;
                }
            }
        }
        return cantidad == 0 ? 0 : suma / cantidad;
    }

    // Muestra las notas del semestre actual
    public void mostrarNotas() {
        System.out.println("=== Notas semestre " + semestre + " ===");
        for (int i = 0; i < 20; i++) {
            if (notas[semestre - 1][i] != null) {
                System.out.println("Materia " + (i + 1) + ": " + notas[semestre - 1][i]);
            }
        }
        System.out.println("Promedio: " + calcularPromedio(semestre - 1));
    }

    // Implementacion del método abstracto de Persona
    @Override
    public void mostrarInfo() {
        System.out.println("=== Informacion del Estudiante ===");
        System.out.println("Nombre  : " + nombre);
        System.out.println("ID      : " + id);
        System.out.println("Email   : " + email);
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio acumulado: " + calcularPromedioAcumulado());
        System.out.println("Historial: " + historialMaterias);
    }

    // Getters y Setters
    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Double[][] getNotas() {
        return notas;
    }

    public void setNotas(Double[][] notas) {
        this.notas = notas;
    }

    public LinkedList<Materia> getMaterias() {
        return materias;
    }

    public LinkedList<String> getHistorialMaterias() {
        return historialMaterias;
    }

    // Método toString
    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", semestre=" + semestre +
                ", promedio=" + calcularPromedioAcumulado() +
                '}';
    }
}
