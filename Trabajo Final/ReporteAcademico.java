import java.util.Stack;

public class ReporteAcademico {

    // Pila para navegacion entre reportes
    private Stack<String> historialReportes;

    // Constructor
    public ReporteAcademico() {
        historialReportes = new Stack<>();
    }

    // Muestra el reporte completo de un estudiante
    public void mostrarReporte(Estudiante estudiante) {

        // Guarda el reporte en la pila de historial
        historialReportes.push(estudiante.getNombre());

        System.out.println("=== REPORTE ACADEMICO ===");
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("ID        : " + estudiante.getId());
        System.out.println("Semestre  : " + estudiante.getSemestre());
        System.out.println();

        Double[][] notas = estudiante.getNotas();
        int materiasAprobadas = 0;
        int materiasReprobadas = 0;

        // Recorre todos los semestres
        for (int i = 0; i < 10; i++) {
            boolean tienNotas = false;

            // Verifica si el semestre tiene notas
            for (int j = 0; j < 20; j++) {
                if (notas[i][j] != null) {
                    tienNotas = true;
                    break;
                }
            }

            if (tienNotas) {
                System.out.println("--- Semestre " + (i + 1) + " ---");
                double suma = 0;
                int cantidad = 0;

                for (int j = 0; j < 20; j++) {
                    if (notas[i][j] != null) {
                        System.out.println("  Materia " + (j + 1) + ": " + notas[i][j]);
                        suma += notas[i][j];
                        cantidad++;

                        // Cuenta aprobadas y reprobadas
                        if (notas[i][j] >= 3.0) {
                            materiasAprobadas++;
                        } else {
                            materiasReprobadas++;
                        }
                    }
                }
                System.out.println("  Promedio semestre: " + (suma / cantidad));
                System.out.println();
            }
        }
        // Resumen final
        System.out.println("=== RESUMEN ===");
        System.out.println("Promedio acumulado  : " + estudiante.calcularPromedioAcumulado());
        System.out.println("Materias aprobadas  : " + materiasAprobadas);
        System.out.println("Materias reprobadas : " + materiasReprobadas);
    }

    // Muestra las materias reprobadas de un estudiante
    public void mostrarReprobadas(Estudiante estudiante) {
        System.out.println("=== MATERIAS REPROBADAS ===");
        Double[][] notas = estudiante.getNotas();
        boolean hayReprobadas = false;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (notas[i][j] != null && notas[i][j] < 3.0) {
                    System.out.println("Semestre " + (i + 1) + " Materia " + (j + 1) + ": " + notas[i][j]);
                    hayReprobadas = true;
                }
            }
        }

        if (!hayReprobadas) {
            System.out.println("No hay materias reprobadas.");
        }
    }

    // Navega al reporte anterior
    public void atras() {
        if (historialReportes.isEmpty()) {
            System.out.println("No hay reportes anteriores.");
            return;
        }
        String reporte = historialReportes.pop();
        System.out.println("Volviendo al reporte de: " + reporte);
    }

    // Muestra cuantos reportes hay en el historial
    public void mostrarHistorial() {
        System.out.println("=== HISTORIAL DE REPORTES ===");
        if (historialReportes.isEmpty()) {
            System.out.println("No hay reportes en el historial.");
            return;
        }
        for (String r : historialReportes) {
            System.out.println("  - " + r);
        }
    }
}