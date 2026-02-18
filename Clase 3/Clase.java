public class Clase {
    
    private int id;
    private String nombre_del_curso;
    private String profesor;
    private int cantidad_de_estudiantes;
    
    public Clase(int id, String nombre_del_curso, String profesor, int cantidad_de_estudiantes) {
        this.id = id;
        this.nombre_del_curso = nombre_del_curso;
        this.profesor = profesor;
        this.cantidad_de_estudiantes = cantidad_de_estudiantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_del_curso() {
        return nombre_del_curso;
    }

    public void setNombre_del_curso(String nombre_del_curso) {
        this.nombre_del_curso = nombre_del_curso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getCantidad_de_estudiantes() {
        return cantidad_de_estudiantes;
    }

    public void setCantidad_de_estudiantes(int cantidad_de_estudiantes) {
        this.cantidad_de_estudiantes = cantidad_de_estudiantes;
    }

    @Override
    public String toString() {
        return "Clase [id=" + id + ", nombre_del_curso=" + nombre_del_curso + ", profesor=" + profesor
                + ", cantidad_de_estudiantes=" + cantidad_de_estudiantes + "]";
    }

    
}
