import java.util.Scanner;
import java.util.Random;

public class LogisticaJH {

    public static void main(String[] args) {

        Buque[] buque = new Buque[10];
        Contenedor[][] areaContenedores = new Contenedor[10][10];

        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        Random aleatorio = new Random();

        while (opcion != 5) {
            System.out.println("\n ---- Menu Principal ----");
            System.out.println("1. Agregar Buques");
            System.out.println("2. agregar Contenedores");
            System.out.println("3. Peso total de los contenedores");
            System.out.println("4. Listar por origen");
            System.out.println("5. Salir");

            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del buque:");
                    String nombreBuque = leer.nextLine();

                    boolean agregado = false;
                    for (int i = 0; i < buque.length; i++) {
                        if (buque[i] == null) {
                            buque[i] = new Buque(nombreBuque);
                            System.out.println("Buque agregado: " + buque[i]);
                            agregado = true;
                            break;
                        }
                    }
                    if (!agregado) {
                        System.out.println("No se pueden agregar más buques. Capacidad máxima alcanzada.");
                    }
                    break;

                case 2:
                    String[] paises = { "China", "USA", "Colombia", "España", "Brasil" };
                    for (int f = 0; f < 10; f++) {
                        for (int c = 0; c < 10; c++) {
                            // Solo llena si el espacio está vacío
                            if (areaContenedores[f][c] == null) {
                                String idRand = "ID-" + (aleatorio.nextInt(9000) + 1000);
                                double pesoRand = 5 + (30 * aleatorio.nextDouble()); // Peso entre 5 y 35
                                String origenRand = paises[aleatorio.nextInt(paises.length)];

                                areaContenedores[f][c] = new Contenedor(idRand, pesoRand, origenRand);
                            }
                        }
                    }
                    System.out.println("¡Operación exitosa! El patio de 10x10 está lleno.");
                    break;

                case 3:
                    double pesoTotal = 0;
                    for (int fila = 0; fila < areaContenedores.length; fila++) {
                        for (int col = 0; col < areaContenedores[fila].length; col++) {
                            if (areaContenedores[fila][col] != null) {
                                pesoTotal += areaContenedores[fila][col].getPeso();
                            }
                        }
                    }
                    System.out.println("Peso total de los contenedores: " + pesoTotal);
                    break;

                case 4:
                    System.out.println("Ingrese el origen para listar los contenedores:");
                    String origenBusqueda = leer.next();

                    System.out.println("Contenedores con origen " + origenBusqueda + ":");
                    for (int fila = 0; fila < areaContenedores.length; fila++) {
                        for (int col = 0; col < areaContenedores[fila].length; col++) {
                            if (areaContenedores[fila][col] != null
                                    && areaContenedores[fila][col].getOrigen().equalsIgnoreCase(origenBusqueda)) {
                                System.out.println(areaContenedores[fila][col]);
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
            }

        }
    }

}
