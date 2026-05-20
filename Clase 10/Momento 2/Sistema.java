import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Sistema {

    public static void llenarManifiesto(Contenedor[] m) {
        m[0] = new Contenedor("C1", 240, 1);
        m[1] = new Contenedor("C2", 120, 2);
        m[2] = new Contenedor("C3", 100, 1);
        m[3] = new Contenedor("C4", 300, 2);
        m[4] = new Contenedor("C5", 150, 1);
        m[5] = new Contenedor("C6", 200, 2);
        m[6] = new Contenedor("C7", 180, 1);
        m[7] = new Contenedor("C8", 220, 2);
        m[8] = new Contenedor("C9", 130, 1);
        m[9] = new Contenedor("C10", 170, 2);
        
    }

    public static double pesoTotal(Contenedor[] m) {
        double total = 0;

        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                total += m[i].getPeso();
            }
        }

        return total;
    }

    public static void ubicarEnPatio(Contenedor[][] patio, Contenedor c) {

        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {

                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    return;
                }
            }
        }

        System.out.println("Puerto Saturado");
    }

    public static void quitarFondo(Stack<Contenedor> pila) {

        Stack<Contenedor> aux = new Stack<>();

        while (pila.size() > 1) {
            aux.push(pila.pop());
        }

        System.out.println("Eliminado: " + pila.pop().getId());

        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }

    public static void main(String[] args) {

        Contenedor[] manifiesto = new Contenedor[10];
        Contenedor[][] patio = new Contenedor[3][3];
        Queue<Contenedor> inspeccion = new LinkedList<>();
        Stack<Contenedor> buque = new Stack<>();

        // 1. Llenar datos
        llenarManifiesto(manifiesto);

        // 2. Mostrar peso total
        System.out.println("Peso total: " + pesoTotal(manifiesto));

        // 3. Procesar contenedores
        for (int i = 0; i < manifiesto.length; i++) {

            Contenedor c = manifiesto[i];

            if (c != null) {

                // Ubicar en patio
                ubicarEnPatio(patio, c);

                // Cola (FIFO) - prioridad alta
                if (c.getPrioridad() == 1) {
                    inspeccion.add(c);
                }

                // Pila (LIFO)
                buque.push(c);
            }
        }

        quitarFondo(buque);

        // 4. Inspección (cola)
        while (!inspeccion.isEmpty()) {
            Contenedor c = inspeccion.poll();
            System.out.println("Inspeccionando: " + c.getId());
        }

        // 5. Buque (pila)
        while (!buque.isEmpty()) {
            Contenedor c = buque.pop();
            System.out.println("Descargando: " + c.getId());
        }
    }
}


//java -cp bin Sistema