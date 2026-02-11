import java.util.Scanner;

public class Taller {
    public static void main(String[] args) {
    
        Scanner teclado = new Scanner(System.in);

       int[] numeros = new int[8];
       int suma = 0;

       for(int i = 0; i < numeros.length; i++){
        System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = teclado.nextInt();
       }

       for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
    
         System.out.println("La suma total es: " + suma);
        teclado.close();
        }

    }

}