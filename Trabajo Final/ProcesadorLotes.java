import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ProcesadorLotes {

    // Cola de procesamiento
    private Queue<String> colaSolicitudes;

    // Constructor
    public ProcesadorLotes() {
        colaSolicitudes = new LinkedList<>();
    }

    // Encola todas las solicitudes del archivo
    public void cargarSolicitudes(LinkedList<String> lineas) {
        for (String linea : lineas) {
            colaSolicitudes.offer(linea);
        }
        System.out.println("Se encolaron " + colaSolicitudes.size() + " solicitudes.");
    }

    // Procesa la cola de solicitudes
    public void procesarCola(
            HashMap<String, Estudiante> estudiantes,
            HashMap<String, Materia> materias) {

        int exitosas = 0;
        int fallidas = 0;
        int total = colaSolicitudes.size();
        int actual = 1;

        System.out.println("Procesando cola...");

        while (!colaSolicitudes.isEmpty()) {
            String solicitud = colaSolicitudes.poll();
            String[] partes = solicitud.split(",");

            try {
                if (partes.length != 2) {
                    throw new ArchivoInvalidoException("Formato invalido: " + solicitud);
                }

                String idEstudiante = partes[0].trim();
                String codigoMateria = partes[1].trim();

                // Busca el estudiante
                if (!estudiantes.containsKey(idEstudiante)) {
                    throw new EstudianteNoEncontradoException("Estudiante no encontrado: " + idEstudiante);
                }

                // Busca la materia
                if (!materias.containsKey(codigoMateria)) {
                    throw new ArchivoInvalidoException("Materia no encontrada: " + codigoMateria);
                }

                Estudiante estudiante = estudiantes.get(idEstudiante);
                Materia materia = materias.get(codigoMateria);

                // Intenta inscribir
                materia.inscribirEstudiante(estudiante);
                System.out.println(
                        "[" + actual + "/" + total + "] " + idEstudiante + " → " + codigoMateria + " → Exitosa");
                exitosas++;

            } catch (EstudianteNoEncontradoException | ArchivoInvalidoException e) {
                System.out.println("[" + actual + "/" + total + "] Fallida → " + e.getMessage());
                fallidas++;
            }
            actual++;
        }

        // Resumen final
        System.out.println("=== RESUMEN ===");
        System.out.println("Exitosas: " + exitosas);
        System.out.println("Fallidas: " + fallidas);
    }

    // Procesa notas desde una lista
    public void procesarNotas(LinkedList<String> datos) {
        System.out.println("Procesando notas...");
        for (String linea : datos) {
            String[] partes = linea.split(",");
            System.out.println("Procesando: " + partes[0] + " → " + partes[1] + " → " + partes[2]);
        }
    }
}
