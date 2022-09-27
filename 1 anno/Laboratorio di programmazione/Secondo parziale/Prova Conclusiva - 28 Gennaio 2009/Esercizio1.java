public class Esercizio1 {
    public static void main(String[] args){
        /*
            Scrivere un metodo statico ricorsivo che, dato un array bidimensionale a di stringhe ed un carattere c,
            restituisce un array monodimensionale b di stringhe
            tale che b[i] `e la prima stringa di a[i] (considerata da sinistra a destra) che inizia con c.
            Se in a[i] non esistono stringhe il cui primo carattere `e c, allora b[i] vale "-".
            Ad esempio, dati a = {{"ba","acd","af"},{"gf","hgf"},{"aw","s","avv","gh"}} e c = ’a’, 
            il metodo restituisce l’array b = {"acd","-","aw"}. Si assuma che ogni stringa nell’array a abbia
            lunghezza maggiore o uguale ad 1.
        */

        String[][] a = {{"ba","acd","af"},{"gf","hgf"},{"aw","s","avv","gh"}};
        char c = 'a';
        String[] b;

        b = controllaPrimoCarattere(a,c);
        System.out.println("METODO ITERATIVO:");
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }

        b=controlloPrimoCarattereRicorsivo(a, c);
        System.out.println("\nMETODO RICORSIVO:");
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }



    }

    // I T E R A T I V O
    public static String[] controllaPrimoCarattere(String[][] a, char c){
        String[] b = new String[a.length];
        

        for(int i=0 ; i<a.length;i++){
            boolean trovato=false;
            for(int j=0;j<a[i].length && !trovato;j++){
                if(a[i][j].charAt(0)==c) {
                    b[i]=a[i][j];
                    trovato = true;
                }
            }

            if(!trovato) b[i]="-";
        }

        return b;
    }

    // R I C O R S I V O
    public static String[] controlloPrimoCarattereRicorsivo(String[][] a, char c){
        String[] b = new String[a.length];
        boolean trovato=false;
        return controlloPrimoCarattereRicorsivo(a, c, b, 0, 0,trovato);
    }

    public static String[] controlloPrimoCarattereRicorsivo(String[][] a, char c, String[] b, int i, int j, boolean trovato){

        if(i>=a.length){
            return b;
        }
        if(j>=a[i].length || trovato==true){
            if(trovato==false) b[i]="-";
            return controlloPrimoCarattereRicorsivo(a, c, b, i+1, 0, false);
        }

        if(a[i][j].charAt(0)==c){
            trovato=true;
            b[i]=a[i][j];
        }
        return controlloPrimoCarattereRicorsivo(a, c, b, i, j+1, trovato);

    }
}
