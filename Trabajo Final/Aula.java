public class Aula {

    private String nombre;
    private int capacidad;

    // Matriz obligatoria: 7 dias x 24 horas
    // false = disponible, true = ocupado
    private boolean[][] horario;

    public Aula() {
        this.horario = new boolean[7][24];
    }

    public Aula(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.horario = new boolean[7][24]; // todas las horas disponibles al inicio
    }

    // Verifica si un bloque de horas esta disponible
    public boolean consultarDisponibilidad(int dia, int hora) {
        return !horario[dia][hora];
    }

    // Reserva un bloque de horas en un dia
    public boolean reservar(int dia, int hora, int duracion) {
        // Primero verifica que todo el bloque este disponible
        for (int i = hora; i < hora + duracion; i++) {
            if (horario[dia][i]) {
                System.out.println("Hora " + i + " del dia " + dia + " ya esta ocupada.");
                return false;
            }
        }

        // Si esta disponible, reserva todo el bloque
        for (int i = hora; i < hora + duracion; i++) {
            horario[dia][i] = true;
        }
        System.out.println("Aula " + nombre + " reservada el dia " + dia + " de " + hora + " a " + (hora + duracion));
        return true;
    }

    // Libera un bloque de horas en un dia
    public boolean liberar(int dia, int hora, int duracion) {
        for (int i = hora; i < hora + duracion; i++) {
            horario[dia][i] = false;
        }
        System.out.println("Aula " + nombre + " liberada el dia " + dia + " de " + hora + " a " + (hora + duracion));
        return true;
    }

    // Muestra el horario completo del aula
    public void mostrarHorario() {
        String[] dias = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
        System.out.println("=== Horario del Aula " + nombre + " ===");
        for (int i = 0; i < 7; i++) {
            System.out.print(dias[i] + ": ");
            for (int j = 0; j < 24; j++) {
                System.out.print(horario[i][j] ? "X" : "O"); // X=ocupado, O=disponible
            }
            System.out.println();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean[][] getHorario() {
        return horario;
    }

    public void setHorario(boolean[][] horario) {
        this.horario = horario;
    }

     @Override
    public String toString() {
        return "Aula{" +
                "nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
