public class Esercizio6 {
    public static void main(String[] args) {
        /*
            Scrivere un metodo che, dati un array bidimensionale di stringhe a ed un array
            monodimensionale di interi b, restituisce un array bidimensionale di stringhe c tale che la
            riga c[i] contiene le sottostringhe degli elementi a[i][j] costituite dai primi b[i] caratteri di
            a[i][j]. Se b[i] `e maggiore della lunghezza di a[i][j], allora c[i][j] vale "-". 
            Ad esempio, se a = {{"anna","lea","liliana"},{"mario","paolo"},{"enrica","luca","ugo","laura"}}
            e b = {5,3,4}, il metodo restituisce c = {{"-","-","lilia"},{"mar","pao"},{"enri","luca","-","laur"}}
        */

        String[][] a = {{"anna","lea","liliana"},{"mario","paolo"},{"enrica","luca","ugo","laura"}};
        int[] b = {5,3,4};
        String[][] c;


        System.out.println("METODO ITERATIVO:");
        c = sottostringa(a,b);
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[i].length;j++){
                System.out.println(c[i][j]);
            }
        }

        System.out.println("\nMETODO RICORSIVO:");
        c = sottostringaRicorsivo(a,b);
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[i].length;j++){
                System.out.println(c[i][j]);
            }
        }


    }

    // I T E R A Z I O N E
    public static String[][] sottostringa(String[][] a, int[] b){
        String[][] c = new String[a.length][];
        for(int i=0;i<a.length;i++){
            c[i] = new String[a[i].length];
            for(int j=0;j<a[i].length;j++){
                if(b[i]>a[i][j].length()) c[i][j]="-";
                else c[i][j]=a[i][j].substring(0,b[i]);
            }
        }
        return c;
    }

    // R I C O R S I O N E
    public static String[][] sottostringaRicorsivo(String[][] a, int[] b){
        String[][] c = new String[a.length][];
        return sottostringaRicorsivo(a, b, c, 0, 0);
    }

    public static String[][] sottostringaRicorsivo(String[][] a, int[] b, String[][] c, int i, int j){
        if(i>=a.length) return c;
        if(j==0) c[i] = new String[a[i].length];
        if(j>=a[i].length){
            return sottostringaRicorsivo(a, b, c, i+1, 0);
        }
        if(b[i]>a[i][j].length()) c[i][j]="-";
        else c[i][j]=a[i][j].substring(0,b[i]);
        return sottostringaRicorsivo(a, b, c, i, j+1);


    }



}
