public class Arreglo {
      public static void main(String[] args) {
       //Creacion del arrerglo
       int[] a = {2, 6, 8, 1, 20, 40, 7, 3, 5};

       System.out.println("a[4]=" + a[4]);
       System.out.println("a[7]=" + a[7]);
       System.out.println("a[2]=" + a[2]);
       System.out.println("a[0]=" + a[0]);
       System.out.println("a[1]=" + a[1]);

       System.out.println("Tamaño del arreglo a: " + a.length);
       for (int i = 0; i < a.length; i++){
           System.out.println("a[" + i + "]=" + a[i]);
       } 
      
    
      //Ejercicio de sumar todos los elementos 
      int suma1 = 0;
      for (int i = 0; i < a.length; i++){
        suma1 += a[i];
      System.out.println("La suma de todos los elementos del arreglo [a] es:" + suma1);
    
       }

    //Ejercicios
    /*
    Obtener la suma de los numeros pares y los numeros impares
    
    Mostrar los elementos que ha en las posciones pares del arreglo
    */

    int suma = 0;
      for (int i : a){
        if (i % 2 == 0){
          suma += i;
        }
      }
    
    int suma2 = 0;
      for (int i : a){
        if(i % 2 == 1){

        suma2 += i;
        }
      }
      
    System.out.println("La suma de los numeros pares es:" + suma);
    System.out.println("La suma de los numeros impares es:" + suma2);

    
  for(int i = 0; i < a.length; i += 2) {
    System.out.println("Posicion par" + i + ":" + a[i]);
  }



    }   
} 