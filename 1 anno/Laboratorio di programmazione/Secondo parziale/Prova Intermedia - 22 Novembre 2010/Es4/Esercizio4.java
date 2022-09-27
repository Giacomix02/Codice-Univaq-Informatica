public class Esercizio4 {
     public static void main(String[] args) {

        /*
            Scrivere un metodo che, dato un array monodimensionale di interi a, restituisce
            un array di interi b tale che ogni elemento b[k] di b (con k = 0, . . . , b.length−1) `e la somma
            a[0] + a[1] + . . . + a[k] dei primi k elementi di a. Ad esempio, se a = {3,-8,1,7,-10,12},
            il metodo restituisce l’array b = {3,-5,-4,3,-7,5}.
        */

        int[] a = {3,-8,1,7,-10,12};
        int[] b;

        System.out.println("METODO ITERATIVO:");
        b=somma(a);
        for(int i=0; i<b.length;i++){
            System.out.print(" "+b[i]);
        }

        System.out.println("\nMETODO RICORSIVO:");
        b=sommaR(a);
        for(int i=0; i<b.length;i++){
            System.out.print(" "+b[i]);
        }
    }

    // I T E R A T I V O 

    public static int[] somma(int[] a){
        int[] b=new int[a.length];

        for(int i=0;i<a.length;i++){
            for(int j=0; j<=i;j++){
                b[i]=b[i]+a[j];
            }
        }


        return b;
    }

    // R I C O R S I V O 

    public static int[] sommaR(int[] a){
        int[] b = new int[a.length];
        return sommaR(a, b, 0, 0);
    }

    public static int[] sommaR(int[] a, int[] b, int i, int j){
        if(i>=a.length) return b;
        if(j>i) return sommaR(a,b,i+1,0);
        b[i]=b[i]+a[j];
        return sommaR(a,b,i,j+1);

    }
    
}
