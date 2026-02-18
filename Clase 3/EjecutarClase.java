public class EjecutarClase {
    
    public static void main(String[] args) {

        Clase[] c = new Clase[4];
        
        c[0] = new Clase(12456, "Fisica", "Profesor Cesar", 25);
        c[1] = new Clase(13457, "Matematicas", "Profesor Juan", 30);
        c[2] = new Clase(14567, "Quimica", "Profesora Ana", 28);
        c[3] = new Clase(15678, "Biologia", "Profesor Luis", 32);
        
        // Calcular total de estudiantes
        int totalEstudiantes = 0;
        for (int i = 0; i < c.length; i++) {
            totalEstudiantes += c[i].getCantidad_de_estudiantes();
        }
        
        System.out.println("Total de estudiantes en todos los cursos: " + totalEstudiantes);
    }
}
