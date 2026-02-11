public class Arreglo2 {
    public static void main(String[] args) {
        //Forma 1 - Definiendo el arreglo directamentre con elementos
        int[] a = {7, 2, 6, 1, 0, 3};

        //El tamaño del arreglo9 se obtiene con la palabra reservada length

        for(int i = 0; i < a.length; i++){
            System.out.println("a[" + i + "]=" + a[i]);
        }

        //sumar todos los elementos de arreglo
        int total = 0;
        for(int i = 0; i < a.length; i++){
            total += a[i];
        }
        System.out.println("ALa suma de los elemtos del arreglo a es:" + total);
    
        /*
           int[] a = {7, 2, 6, 1, 0, 3};

           prueba de escritorio
        i      i < a.length   i++     total += a[i]
        0      0 < 6 true     1       total += 7 => total = 7
               1 < 6 true     2       Total += 2 => total = 9
               2 < 6 true     3       total += 6 => total = 15
               3 < 6 true     4       total += 1 => total = 16 
               4 < 6 true     5       total += 0 => total = 16
               5 < 6 true     6       total += 3 => total = 19 
               6 < 6 false   
               */
    
    }
}
