import java.util.Scanner;

public class Taller {
    public static void main(String[] args) {
    
        Scanner teclado = new Scanner(System.in);

    // Ejercicio 1    
       int[] numeros = new int[4];
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

    //Ejervcicio 2
    int[] a = {10, 20, 15, 8, 12};
    int[] b = {2,   3,  5, 1,  3};
    int[] c = {3,   3,  5, 3,  1};

    int[] t = new int[5]; 
    //reserva en memoria un arreglo de tamaño 5 para almacenar
    // la operacion del calculo de cada trabajador

    for(int i = 0; i < a.length; i++){
        t[i] = a[i] + b[i] - c[i];
        //Almacena en el arreglo t la operacion establecida en el pdf

    for(int i = 0; i < a.length; i++){
        System.out.print("t[" + i + "]" + t[i]);

    }


        } 

   }

}