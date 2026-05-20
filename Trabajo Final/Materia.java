import java.util.LinkedList;
import java.util.Queue;

public class Materia {

    // Atributos
    private String codigo;
    private String nombre;
    private int cupos;
    private int creditos;
    private int dia;
    private int hora;

    private LinkedList<String> preRequisitos;
    private LinkedList<Estudiante> inscritos;
    private Queue<Estudiante> colaEspera;

    // Constructor
    public Materia() {
        this.preRequisitos = new LinkedList<>();
        this.inscritos = new LinkedList<>();
        this.colaEspera = new LinkedList<>();
    }

    // Constructor con parámetros
    public Materia(String codigo, String nombre, int cupos, int creditos, int dia, int hora) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cupos = cupos;
        this.creditos = creditos;
        this.dia = dia;
        this.hora = hora;
        this.preRequisitos = new LinkedList<>();
        this.inscritos = new LinkedList<>();
        this.colaEspera = new LinkedList<>();
    }

    // Agrega un pre-requisito a la lista
    public void agregarPreRequisito(String materia) {
        preRequisitos.add(materia);
        System.out.println("Pre requisito agregado: " + materia);
    }

    // Muestra todos los pre-requisitos
    public void mostrarPreRequisitos() {
        System.out.println("Pre requisitos de " + nombre + ":");
        for (String m : preRequisitos) {
            System.out.println("  - " + m);
        }
    }

    // Verifica si hay cupos
    public boolean tieneCupo() {
        return inscritos.size() < cupos;
    }

    // Inscribe a un estudiante o lo agrega a la cola de espera si no hay cupos
    public void inscribirEstudiante(Estudiante estudiante) {
        if (tieneCupo()) {
            inscritos.add(estudiante);
            estudiante.agregarMateria(this);
            System.out.println("Estudiante inscrito en " + nombre);
        } else {
            colaEspera.offer(estudiante);
            System.out.println("Materia llena. " + estudiante.getNombre() + " agregado a cola.");
        }
    }

    // Cancela la inscripción de un estudiante y mueve al siguiente de la cola si es
    // necesario
    public void cancelarInscripcion(Estudiante estudiante) {
        if (inscritos.remove(estudiante)) {
            estudiante.eliminarMateria(this);
            System.out.println("Inscripcion cancelada.");
            if (!colaEspera.isEmpty()) {
                Estudiante siguiente = colaEspera.poll();
                inscritos.add(siguiente);
                siguiente.agregarMateria(this);
                System.out.println(siguiente.getNombre() + " ingreso desde cola.");
            }
        } else {
            System.out.println("El estudiante no estaba inscrito.");
        }
    }

    // Muestra los estudiantes inscritos
    public void mostrarInscritos() {
        System.out.println("Inscritos en " + nombre + ":");
        for (Estudiante e : inscritos) {
            System.out.println("  - " + e.getNombre());
        }
    }

    // Muestra la cola de espera
    public void mostrarCola() {
        System.out.println("Cola de espera en " + nombre + ":");
        for (Estudiante e : colaEspera) {
            System.out.println("  - " + e.getNombre());
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public LinkedList<String> getPreRequisitos() {
        return preRequisitos;
    }

    public LinkedList<Estudiante> getInscritos() {
        return inscritos;
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cupos=" + inscritos.size() + "/" + cupos +
                ", creditos=" + creditos +
                '}';
    }

}