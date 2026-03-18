import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Random r = new Random();

        int[] energiaContenedores = new int[12];
        System.out.println("--- Energias generadas ---");

        int cuantosSonMultiplos = 0;
        for (int i = 0; i < 12; i++) {
            energiaContenedores[i] = r.nextInt(101) + 50;
            System.out.print(energiaContenedores[i] + " ");
            if (energiaContenedores[i] % 10 == 0) {
                cuantosSonMultiplos++;
            }
        }

        int[] filtrados = new int[cuantosSonMultiplos];
        int posicion = 0;
        System.out.println("\n\n--- Valores que sirven (multiplos de 10) ---");
        for (int i = 0; i < 12; i++) {
            if (energiaContenedores[i] % 10 == 0) {
                filtrados[posicion] = energiaContenedores[i];
                System.out.print(filtrados[posicion] + " ");
                posicion++;
            }
        }

        int[][] mapaCarga = new int[3][3];
        int k = 0;

        System.out.println("\n\n--- Matriz de la Nave (3x3) ---");
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (k < filtrados.length && k < 9) {
                    mapaCarga[f][c] = filtrados[k];
                    k++;
                } else {
                    mapaCarga[f][c] = -1;
                }
                System.out.print(mapaCarga[f][c] + "\t");
            }
            System.out.println();
        }

        Suministro[] manifiesto = new Suministro[9];
        int indice = 0;

        System.out.println("\n--- RESULTADO DEL MANIFIESTO ---");
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                int valorMatriz = mapaCarga[f][c];

                if (valorMatriz != -1) {

                    String idSum = "C-" + f + "-" + c;

                    String prio;
                    if (valorMatriz > 100) {
                        prio = "ALTA";
                    } else {
                        prio = "ESTANDAR";
                    }
                    manifiesto[indice] = new Suministro(idSum, valorMatriz, prio);
                    System.out.println("Caja creada en posicion " + indice + ": ID=" + idSum + ", Energia="
                            + valorMatriz + ", Prio=" + prio);
                } else {
                    manifiesto[indice] = null;
                    System.out.println("Posicion " + indice + " quedo vacia (null)");
                }
                indice++;
            }
        }
    }
}