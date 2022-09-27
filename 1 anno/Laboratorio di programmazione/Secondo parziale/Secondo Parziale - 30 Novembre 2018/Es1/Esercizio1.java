public class Esercizio1{
    public static void main(String[] args){
        /*
            Scrivere un metodo che, dati un array bidimensionale di stringhe a ed un array
            monodimensionale di caratteri c, restituisce un array monodimensionale di stringhe b tale
            che b[i] `e la prima stringa nella riga a[i] (letta da sx a dx) il cui primo carattere `e diverso
            da c[i]. Se in a[i] non esiste alcuna stringa che soddisfa tale condizione, allora b[i] `e "::".
            Esempio: se a = {{"dh","stk"},{"jm","qsq","yw"},{"grt","gw","g","gpw"}} e c= {'d','j','g'};
            c, il metodo restituisce l’array b = {"stk","qsq","::"}.
            Si assuma che gli array a e c abbiano la stessa lunghezza e che tutte le stringhe in a siano  non vuote.
        */

        String[][] a = {{"dh","stk"},{"jm","qsq","yw"},{"grt","gw","g","gpw"}};
        char[] c= {'d','j','g'};

        String[] b;

        System.out.println("METODO ITERATIVO:");
        b=controlloPrimoCarattere(a, c);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }

        System.out.println("\nMETODO RICORSIVO:");
        b=controlloPrimoCarattereRicorsivo(a,c);
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }

    }

    // I T E R A T I V O

    public static String[] controlloPrimoCarattere(String[][] a,char[] c){
        String[] b = new String[a.length];

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length && b[i]==null;j++){
                if(a[i][j].charAt(0)!=c[i]) b[i]=a[i][j];
            }
            if(b[i]==null) b[i]="::";
        }
        return b;
    }

    // R I C O R S I V O 

    public static String[] controlloPrimoCarattereRicorsivo(String[][] a,char[] c){ //metodo base
        String[] b = new String[a.length];
        return controlloPrimoCarattereRicorsivo(a, c, b, 0,0);
    }

    public static String[] controlloPrimoCarattereRicorsivo(String[][] a,char[] c, String[] b, int i, int j){
        if(i>=a.length){
            return b;
        }

        if(j>=a[i].length || b[i]!=null){
            if(b[i]==null) b[i]="::";
            return controlloPrimoCarattereRicorsivo(a, c, b, i+1, 0);
        }

        if(a[i][j].charAt(0)!=c[i]) b[i]=a[i][j];
        return controlloPrimoCarattereRicorsivo(a, c, b, i, j+1);
    }
}