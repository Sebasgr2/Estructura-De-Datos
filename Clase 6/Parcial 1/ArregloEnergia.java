public class ArregloEnergia {

    public static void main(String[] args) {

        int[] energiaContenedores = new int[12];

        energiaContenedores[0] = 55;
        energiaContenedores[1] = 67;
        energiaContenedores[2] = 87;
        energiaContenedores[3] = 59;
        energiaContenedores[4] = 92;
        energiaContenedores[5] = 112;
        energiaContenedores[6] = 101;
        energiaContenedores[7] = 131;
        energiaContenedores[8] = 135;
        energiaContenedores[9] = 145;
        energiaContenedores[10] = 142;
        energiaContenedores[11] = 123;

        int[] energiaContenedores2 = new int[12];
        energiaContenedores2[0] = 50;
        energiaContenedores2[1] = 60;
        energiaContenedores2[2] = 70;
        energiaContenedores2[3] = 80;
        energiaContenedores2[4] = 90;
        energiaContenedores2[5] = 100;
        energiaContenedores2[6] = 110;
        energiaContenedores2[7] = 120;
        energiaContenedores2[8] = 130;
        energiaContenedores2[9] = 140;
        energiaContenedores2[10] = 150;
        energiaContenedores2[11] = 135;

        for (int i = 0; i < energiaContenedores.length; i++) {
            System.out.println("Contenedor " + (i + 1) + ": " + energiaContenedores[i] + "Unidades de energia");
        }

        int MapaCarga[][] = new int[3][3];
        for (int i = 0; i < MapaCarga.length; i++) {
            for (int j = 0; j < MapaCarga[i].length; j++) {
                MapaCarga[i][j] = 0;
            }

        }
    }
}
