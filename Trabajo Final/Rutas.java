public class Rutas {

    private static final int EDIFICIOS = 5;

    private String[] nombres = {
        "Ingenieria",
        "Biblioteca",
        "Cafeteria",
        "Rectoria",
        "Laboratorios"
    };

    // Matriz de distancias
    private int[][] distancias;

    // Constructor
    public Rutas() {
        distancias = new int[EDIFICIOS][EDIFICIOS];
        // Inicializa todas las distancias en 0
        for (int i = 0; i < EDIFICIOS; i++) {
            for (int j = 0; j < EDIFICIOS; j++) {
                distancias[i][j] = 0;
            }
        }
    }

    public void conectar(int origen, int destino, int distancia) {
        distancias[origen][destino] = distancia;
        distancias[destino][origen] = distancia;
        System.out.println(
                "Conexion agregada: " + nombres[origen] + " <-> " + nombres[destino] + " = " + distancia + "m");
    }

    // Algoritmo de Dijkstra
    public void mostrarRuta(int origen, int destino) {
        int[] distancia = new int[EDIFICIOS];
        boolean[] visitado = new boolean[EDIFICIOS];
        int[] anterior = new int[EDIFICIOS];

        // Inicializa distancias en un valor muy alto
        for (int i = 0; i < EDIFICIOS; i++) {
            distancia[i] = Integer.MAX_VALUE;
            anterior[i] = -1;
        }

        distancia[origen] = 0;

        for (int i = 0; i < EDIFICIOS; i++) {
            int u = -1;
            for (int j = 0; j < EDIFICIOS; j++) {
                if (!visitado[j] && (u == -1 || distancia[j] < distancia[u])) {
                    u = j;
                }
            }

            if (distancia[u] == Integer.MAX_VALUE)
                break;
            visitado[u] = true;

            // Actualiza distancias
            for (int v = 0; v < EDIFICIOS; v++) {
                if (distancias[u][v] > 0) {
                    int nueva = distancia[u] + distancias[u][v];
                    if (nueva < distancia[v]) {
                        distancia[v] = nueva;
                        anterior[v] = u;
                    }
                }
            }
        }

        System.out.println("=== RUTA MAS CORTA ===");
        System.out.println("Origen : "+nombres[origen]);
        System.out.println("Destino: "+nombres[destino]);

        if(distancia[destino]==Integer.MAX_VALUE)
        {
            System.out.println("No hay ruta disponible.");
            return;
        }
        int[] camino = new int[EDIFICIOS];
        int longitud = 0;
        int actual = destino;
        while(actual!=-1)
        {
            camino[longitud++] = actual;
            actual = anterior[actual];
        }

        System.out.print("Ruta: ");
        for (int i = longitud - 1; i >= 0; i--) {
            System.out.print(nombres[camino[i]]);
            if (i > 0) System.out.print(" -> ");
        }
        System.out.println();
        System.out.println("Distancia total: " + distancia[destino] + " metros");
    }


 // Muestra la matriz de distancias
    public void mostrarMatriz() {
        System.out.println("=== MATRIZ DE DISTANCIAS ===");
        System.out.printf("%15s", "");
        for (String n : nombres) {
            System.out.printf("%15s", n);
        }
        System.out.println();
        for (int i = 0; i < EDIFICIOS; i++) {
            System.out.printf("%15s", nombres[i]);
            for (int j = 0; j < EDIFICIOS; j++) {
                System.out.printf("%15d", distancias[i][j]);
            }
            }
            System.out.println();
        }
    }
