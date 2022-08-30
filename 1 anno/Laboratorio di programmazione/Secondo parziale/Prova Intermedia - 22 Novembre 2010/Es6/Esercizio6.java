public class Esercizio6 {
    public static void main(String[] args) {
        /*
            Scrivere un metodo che, dati un array monodimensionale di caratteri a ed un
            array monodimensionale di interi b, restituisce un array di caratteri c tale che l'elemento c[i]
            è uguale al carattere di a in posizione b[i]. Si assuma che 0 ≤ b[i] ≤ a.length−1 per ogni i.
            Ad esempio, dati a = {'a','b','a','d','b','a','c','d'} e b = {3,4,1,2,3}, il metodo
            restituisce l'array c = {'d','b','b','a','d'}
        */
        
        char[] a = {'a','b','a','d','b','a','c','d'};
        int[] b = {3,4,1,2,3};
        char[] c;

        System.out.println("METODO ITERATIVO:");
        c=scambio(a,b);
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+" ");
        }

        System.out.println("\nMETODO RICORSIVO:");
        c=scambioRicorsivo(a,b);
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+" ");
        }
    }

    // I T E R A T I V O 

    public static char[] scambio(char[] a,int[] b){
        char[] c = new char[b.length];
        for(int i=0;i<b.length;i++){
            c[i]=a[b[i]];
        }
        return c;
    }

    // R I C O R S I V O 

    public static char[] scambioRicorsivo(char[] a,int[] b){
        char[] c = new char[b.length];
        return scambioRicorsivo(a, b, c, 0);
    }

    public static char[] scambioRicorsivo(char[] a, int[] b, char[] c,int i){
        if(i>=b.length) return c;
        c[i]=a[b[i]];
        return scambioRicorsivo(a, b, c, i+1);

    }
}
