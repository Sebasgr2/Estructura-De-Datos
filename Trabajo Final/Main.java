//java -cp bin Main

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    // Estructuras principales del sistema
    static HashMap<String, Estudiante> estudiantes = new HashMap<>();
    static HashMap<String, Materia> materias = new HashMap<>();
    static HashMap<String, Profesor> profesores = new HashMap<>();

    // Clases auxiliares
    static Aula aula = new Aula("Aula 101", 30);
    static Rutas rutas = new Rutas();
    static SistemaDeshacer sistema = new SistemaDeshacer();
    static ReporteAcademico reporte = new ReporteAcademico();
    static ProcesadorLotes lotes = new ProcesadorLotes();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion = 0;

        while (opcion != 22) {

            System.out.println("\n============================================================");
            System.out.println("  PLANIFICACION ACADEMICA - SISTEMA UNIVERSITARIO");
            System.out.println("============================================================");
            System.out.println("=== GESTION DE ESTUDIANTES ===");
            System.out.println("1.  Registrar estudiante");
            System.out.println("2.  Buscar estudiante por ID");
            System.out.println("3.  Listar todos los estudiantes");
            System.out.println("4.  Eliminar estudiante");
            System.out.println("=== GESTION DE MATERIAS ===");
            System.out.println("5.  Crear materia");
            System.out.println("6.  Agregar pre-requisito");
            System.out.println("7.  Mostrar pre-requisitos");
            System.out.println("8.  Inscribir estudiante");
            System.out.println("9.  Cancelar inscripcion");
            System.out.println("10. Mostrar cola de espera");
            System.out.println("=== GESTION DE HORARIOS ===");
            System.out.println("11. Reservar horario en aula");
            System.out.println("12. Liberar horario");
            System.out.println("13. Consultar disponibilidad");
            System.out.println("=== RUTAS ENTRE EDIFICIOS ===");
            System.out.println("14. Agregar conexion entre edificios");
            System.out.println("15. Calcular ruta mas corta");
            System.out.println("=== REPORTES ACADEMICOS ===");
            System.out.println("16. Registrar nota");
            System.out.println("17. Ver reporte academico");
            System.out.println("18. Navegador de reportes (atras)");
            System.out.println("=== SISTEMA DESHACER/REHACER ===");
            System.out.println("19. Deshacer ultima operacion");
            System.out.println("20. Rehacer ultima operacion");
            System.out.println("=== PROCESAMIENTO POR LOTES ===");
            System.out.println("21. Procesar archivo CSV");
            System.out.println("=== SALIR ===");
            System.out.println("22. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("--- REGISTRO DE ESTUDIANTE ---");
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Semestre: ");
                    int semestre = scanner.nextInt();
                    scanner.nextLine();
                    Estudiante estudiante = new Estudiante(nombre, id, email, semestre);
                    estudiantes.put(id, estudiante);
                    sistema.guardarOperacion("Registrar estudiante: " + nombre);
                    System.out.println("Estudiante registrado exitosamente.");
                    break;

                case 2:
                    System.out.println("--- BUSCAR ESTUDIANTE ---");
                    System.out.print("ID: ");
                    String buscar = scanner.nextLine();
                    try {
                        if (!estudiantes.containsKey(buscar)) {
                            throw new EstudianteNoEncontradoException("No existe estudiante con ID: " + buscar);
                        }
                        estudiantes.get(buscar).mostrarInfo();
                    } catch (EstudianteNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("--- LISTA DE ESTUDIANTES ---");
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    }
                    for (Estudiante e : estudiantes.values()) {
                        e.mostrarInfo();
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("--- ELIMINAR ESTUDIANTE ---");
                    System.out.print("ID: ");
                    String eliminar = scanner.nextLine();
                    try {
                        if (!estudiantes.containsKey(eliminar)) {
                            throw new EstudianteNoEncontradoException("No existe estudiante con ID: " + eliminar);
                        }
                        Estudiante eliminado = estudiantes.remove(eliminar);
                        sistema.guardarOperacion("Eliminar estudiante: " + eliminado.getNombre());
                        System.out.println("Estudiante eliminado exitosamente.");
                    } catch (EstudianteNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("--- CREAR MATERIA ---");
                    System.out.print("Codigo: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombreMateria = scanner.nextLine();
                    System.out.print("Cupos: ");
                    int cupos = scanner.nextInt();
                    System.out.print("Creditos: ");
                    int creditos = scanner.nextInt();
                    System.out.print("Dia (1=Lunes...7=Sabado): ");
                    int dia = scanner.nextInt();
                    System.out.print("Hora (0-23): ");
                    int hora = scanner.nextInt();
                    scanner.nextLine();
                    Materia materia = new Materia(codigo, nombreMateria, cupos, creditos, dia, hora);
                    materias.put(codigo, materia);
                    System.out.println("Materia creada exitosamente.");
                    break;

                case 6:
                    System.out.println("--- AGREGAR PRE-REQUISITO ---");
                    System.out.print("Codigo materia: ");
                    String codMat = scanner.nextLine();
                    System.out.print("Codigo pre-requisito: ");
                    String pre = scanner.nextLine();
                    if (materias.containsKey(codMat)) {
                        materias.get(codMat).agregarPreRequisito(pre);
                    } else {
                        System.out.println("Materia no encontrada.");
                    }
                    break;

                case 7:
                    System.out.println("--- PRE-REQUISITOS ---");
                    System.out.print("Codigo materia: ");
                    String mostrar = scanner.nextLine();
                    if (materias.containsKey(mostrar)) {
                        materias.get(mostrar).mostrarPreRequisitos();
                    } else {
                        System.out.println("Materia no encontrada.");
                    }
                    break;

                case 8:
                    System.out.println("--- INSCRIBIR ESTUDIANTE ---");
                    System.out.print("ID estudiante: ");
                    String idEst = scanner.nextLine();
                    System.out.print("Codigo materia: ");
                    String codInsc = scanner.nextLine();
                    if (estudiantes.containsKey(idEst) && materias.containsKey(codInsc)) {
                        materias.get(codInsc).inscribirEstudiante(estudiantes.get(idEst));
                        sistema.guardarOperacion("Inscribir " + idEst + " en " + codInsc);
                    } else {
                        System.out.println("Estudiante o materia no encontrada.");
                    }
                    break;

                case 9:
                    System.out.println("--- CANCELAR INSCRIPCION ---");
                    System.out.print("ID estudiante: ");
                    String idCan = scanner.nextLine();
                    System.out.print("Codigo materia: ");
                    String matCan = scanner.nextLine();
                    if (estudiantes.containsKey(idCan) && materias.containsKey(matCan)) {
                        materias.get(matCan).cancelarInscripcion(estudiantes.get(idCan));
                        sistema.guardarOperacion("Cancelar inscripcion " + idCan + " en " + matCan);
                    } else {
                        System.out.println("Estudiante o materia no encontrada.");
                    }
                    break;

                case 10:
                    System.out.println("--- COLA DE ESPERA ---");
                    System.out.print("Codigo materia: ");
                    String cola = scanner.nextLine();
                    if (materias.containsKey(cola)) {
                        materias.get(cola).mostrarCola();
                    } else {
                        System.out.println("Materia no encontrada.");
                    }
                    break;

                case 11:
                    System.out.println("--- RESERVAR HORARIO ---");
                    System.out.print("Dia (0=Dom, 1=Lun...6=Sab): ");
                    int diaRes = scanner.nextInt();
                    System.out.print("Hora (0-23): ");
                    int horaRes = scanner.nextInt();
                    System.out.print("Duracion (horas): ");
                    int durRes = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        if (!aula.reservar(diaRes, horaRes, durRes)) {
                            throw new HorarioConflictivoException("Horario ya reservado.");
                        }
                        sistema.guardarOperacion("Reservar horario dia " + diaRes + " hora " + horaRes);
                    } catch (HorarioConflictivoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 12:
                    System.out.println("--- LIBERAR HORARIO ---");
                    System.out.print("Dia (0=Dom, 1=Lun...6=Sab): ");
                    int diaLib = scanner.nextInt();
                    System.out.print("Hora (0-23): ");
                    int horaLib = scanner.nextInt();
                    System.out.print("Duracion (horas): ");
                    int durLib = scanner.nextInt();
                    scanner.nextLine();
                    aula.liberar(diaLib, horaLib, durLib);
                    sistema.guardarOperacion("Liberar horario dia " + diaLib + " hora " + horaLib);
                    break;

                case 13:
                    System.out.println("--- CONSULTAR DISPONIBILIDAD ---");
                    System.out.print("Dia (0=Dom, 1=Lun...6=Sab): ");
                    int diaCon = scanner.nextInt();
                    System.out.print("Hora (0-23): ");
                    int horaCon = scanner.nextInt();
                    scanner.nextLine();
                    if (aula.consultarDisponibilidad(diaCon, horaCon)) {
                        System.out.println("Horario disponible.");
                    } else {
                        System.out.println("Horario no disponible.");
                    }
                    break;

                case 14:
                    System.out.println("--- AGREGAR CONEXION ---");
                    System.out.println("0. Ingenieria");
                    System.out.println("1. Biblioteca");
                    System.out.println("2. Cafeteria");
                    System.out.println("3. Rectoria");
                    System.out.println("4. Laboratorios");
                    System.out.print("Origen: ");
                    int origen = scanner.nextInt();
                    System.out.print("Destino: ");
                    int destino = scanner.nextInt();
                    System.out.print("Distancia (metros): ");
                    int distancia = scanner.nextInt();
                    scanner.nextLine();
                    rutas.conectar(origen, destino, distancia);
                    break;

                case 15:
                    System.out.println("--- RUTA MAS CORTA ---");
                    System.out.println("0. Ingenieria");
                    System.out.println("1. Biblioteca");
                    System.out.println("2. Cafeteria");
                    System.out.println("3. Rectoria");
                    System.out.println("4. Laboratorios");
                    System.out.print("Origen: ");
                    int origenRuta = scanner.nextInt();
                    System.out.print("Destino: ");
                    int destinoRuta = scanner.nextInt();
                    scanner.nextLine();
                    rutas.mostrarRuta(origenRuta, destinoRuta);
                    break;

                case 16:
                    System.out.println("--- REGISTRAR NOTA ---");
                    System.out.print("ID estudiante: ");
                    String notaId = scanner.nextLine();
                    System.out.print("Semestre (0-9): ");
                    int notaSem = scanner.nextInt();
                    System.out.print("Posicion (0-19): ");
                    int notaPos = scanner.nextInt();
                    System.out.print("Nota (0.0 - 5.0): ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        if (!estudiantes.containsKey(notaId)) {
                            throw new EstudianteNoEncontradoException("No existe estudiante con ID: " + notaId);
                        }
                        estudiantes.get(notaId).registrarNota(notaSem, notaPos, nota);
                        sistema.guardarOperacion("Registrar nota " + nota + " a " + notaId);
                        System.out.println("Nota registrada exitosamente.");
                    } catch (EstudianteNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 17:
                    System.out.println("--- REPORTE ACADEMICO ---");
                    System.out.print("ID estudiante: ");
                    String repId = scanner.nextLine();
                    try {
                        if (!estudiantes.containsKey(repId)) {
                            throw new EstudianteNoEncontradoException("No existe estudiante con ID: " + repId);
                        }
                        reporte.mostrarReporte(estudiantes.get(repId));
                    } catch (EstudianteNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 18:
                    System.out.println("--- NAVEGADOR DE REPORTES ---");
                    reporte.atras();
                    break;

                case 19:
                    System.out.println("--- DESHACER ---");
                    sistema.deshacer();
                    break;

                case 20:
                    System.out.println("--- REHACER ---");
                    sistema.rehacer();
                    break;

                case 21:
                    System.out.println("--- PROCESAMIENTO POR LOTES ---");
                    LinkedList<String> solicitudes = new LinkedList<>();
                    System.out.print("Cuantas solicitudes desea agregar: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < cantidad; i++) {
                        System.out.print("Solicitud " + (i + 1) + " (idEstudiante,codigoMateria): ");
                        solicitudes.add(scanner.nextLine());
                    }
                    lotes.cargarSolicitudes(solicitudes);
                    lotes.procesarCola(estudiantes, materias);
                    break;

                case 22:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
        scanner.close();
    }
}