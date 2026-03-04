public class Contenedor {
    
    private String id;
    private double peso;
    private String origen;
    
    public Contenedor(String id, double peso, String origen) {
        this.id = id;
        this.peso = peso;
        this.origen = origen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        return "Contenedor [id=" + id + ", peso=" + peso + ", origen=" + origen + "]";
    }

    

}
