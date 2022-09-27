public class Esercizio2e3 {
    public static void main(String[] args) {
        /*
            Scrivere un metodo che, dati un array bidimensionale a di interi ed un intero
            k, restituisce un array monodimensionale b di booleani tale che l’elemento b[i] di b vale true
            se nella riga a[i] di a esiste almeno un intero maggiore di k, altrimenti b[i] vale false. Ad
            esempio, dati a = {{3,5,7,9},{4,-1},{-9,21,5}} e k = 6, il metodo restituisce l’array b = {true,false,true}
        */

        int[][] a = {{3,5,7,9},{4,-1},{-9,21,5}};
        int k = 6;
        boolean[] b;

        System.out.println("METODO ITERATIVO:");
        b=maggiore(a,k);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }

        System.out.println("\nMETODO RICORSIVO:");
        b=maggiore(a,k);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }

    // I T E R A Z I O N E 
    public static boolean[] maggiore(int[][] a, int k){
        boolean[] b = new boolean[a.length];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length && !b[i];j++){
                if(a[i][j]>k) b[i]=true;
            }
        }

        return b;
    }

    //R I C O R S I O N E 
    public static boolean[] maggioreRicorsivo(int[][] a,int k){
        boolean[] b = new boolean[a.length];
        return maggioreRicorsivo(a, k, b, 0, 0);
    }

    public static boolean[] maggioreRicorsivo(int[][] a, int k, boolean[] b, int i, int j){
        if(i>=a.length) return b;
        if(j>=a[i].length || b[i]) return maggioreRicorsivo(a, k, b, i+1, 0);
        if(a[i][j]>k) b[i]=true;
        return maggioreRicorsivo(a, k, b, i, j+1);


    }
    
}
