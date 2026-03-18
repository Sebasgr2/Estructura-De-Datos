import java.util.Stack;

public class ExplicacionPila {
    
    public static void main(String[] args) {
        
        //Creacion del objeto pila
        Stack<String> obpila = new Stack<>();
        
        //Ingresar elementos a la pila
        obpila.push("Camilo");
        obpila.push("Danielo");
        obpila.push("Francisco");
        obpila.push("Andea");  
        obpila.push("Dario");

        //Mostrar el elemento que se encuentra en la pila
        System.out.println(obpila);
    }
}