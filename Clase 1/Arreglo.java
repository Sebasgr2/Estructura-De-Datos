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
      }
    
       
}