public class Esercizio2e3 {
    public static void main(String[] args) {
        /*
            Scrivere un metodo che, dati un array bidimensionale a di stringhe ed un
            intero k > 0, restituisce un array monodimensionale di stringhe b tale che b[i] `e la prima
            stringa di a[i], la cui lunghezza `e un multiplo di k. Se in a[i] non esistono stringhe la
            cui lunghezza `e un multiplo di k, allora b[i] `e la stringa "*". 
            Ad esempio, dati a = {{"treno","tram","bus"},{"scuola","natale"},{"uno","bis","ter"}} e k = 2, 
            il metodo restituisce l’array b = {"tram","scuola","*"}.
        */

        String[][] a ={{"treno","tram","bus"},{"scuola","natale"},{"uno","bis","ter"}};
        int k=2;
        String[] b;

        System.out.println("METODO ITERATIVO:");
        b=lunghezza(a, k);
        for(int i=0;i<b.length;i++){
            System.out.println("\t--> "+b[i]+" ");
        }


        System.out.println("\nMETODO RICORSIVO:");
        b=lunghezzaR(a, k);
        for(int i=0;i<b.length;i++){
            System.out.println("\t--> "+b[i]+" ");
        }
    }

    // I T E R A T I V O
    public static String[] lunghezza(String[][] a,int k){
        String[] b = new String[a.length];
        boolean trovato=false;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length && !trovato;j++){
                if(a[i][j].length()%k==0){
                    b[i]=a[i][j];
                    trovato=true;
                }
            }
            if(trovato==false) b[i]="*";
            else trovato = false;
        }
        return b;
    }

    // R I C O R S I V O 
    public static String[] lunghezzaR(String[][] a,int k){
        String[] b = new String[a.length];
        boolean trovato=false;
        return lunghezzaR(a, k, b, trovato, 0, 0);
    }

    public static String[] lunghezzaR(String[][] a, int k, String[] b,boolean trovato, int i, int j){
        if(i>=a.length) return b;
        if(j>=a[i].length || trovato){
            if(trovato==false) b[i]="*";
            else trovato = false;
            return lunghezzaR(a, k, b, trovato, i+1, 0);
        }
        if(a[i][j].length()%k==0){
            b[i]=a[i][j];
            trovato=true;
        }
        return lunghezzaR(a, k, b, trovato, i, j+1);
    }
}
