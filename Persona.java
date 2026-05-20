public public abstract class Persona {

    //Atributos
    protected String nombre;
    protected String id;
    protected String email;

    // Constructor por defecto
    public Persona() {
    }

    // Constructor
    public Persona(String nombre, int id, String email) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //Metodo toString 
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    // Método abstracto: cada subclase debe implementarlo para mostrar su información específica
    public abstract void mostrarInfo();
}
