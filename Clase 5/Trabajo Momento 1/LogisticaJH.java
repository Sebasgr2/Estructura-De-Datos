import java.util.Scanner;

public class LogisticaJH {

    public static void main(String[] args) {

        Buque[] buque = new Buque[10];
        Contenedor[][] areaContenedores = new Contenedor[10][10];

        Scanner leer = new Scanner(System.in);
        int opcion = 0;

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
                    System.out.println("\n--- MAPA DE DISPONIBILIDAD (X=Ocupado, .=Libre) ---");
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            System.out.print(areaContenedores[i][j] == null ? " . " : " X ");
                        }
                        System.out.println();
                    }

                    System.out.println("Ingrese el ID del contenedor:");
                    String idContenedor = leer.next();

                    System.out.println("Ingrese el peso del contenedor:");
                    double pesoContenedor = leer.nextDouble();

                    System.out.println("Ingrese el origen del contenedor:");
                    String origenContenedor = leer.next();

                    System.out.println("Ingrese la columna donde desea ubicarlo:");
                    int columna = leer.nextInt();

                    boolean agregadoContenedor = false;

                    for (int fila = 9; fila >= 0; fila--) {
                        if (areaContenedores[fila][columna] == null) {
                            areaContenedores[fila][columna] = new Contenedor(idContenedor, pesoContenedor,
                                    origenContenedor);

                            System.out.println("Contenedor agregado en fila " + fila + ", columna " + columna);
                            agregadoContenedor = true;
                            break;
                        }
                    }

                    if (!agregadoContenedor) {
                        System.out.println("La columna está llena.");
                    }
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
