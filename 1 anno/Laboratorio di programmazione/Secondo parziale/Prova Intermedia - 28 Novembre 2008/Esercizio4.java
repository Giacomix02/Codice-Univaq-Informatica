public class Esercizio4 {
    public static void main(String[] args){
        /*
        Scrivere un metodo che, dato un array bidimensionale di stringhe a, 
        restituisce un array bidimensionale di interi b contenente le lunghezze degli elementi di a nelle posizioni corrispondenti.
        Ad esempio, se a = {{"abcd","ab","kzz"},{"cde","","hkkhh","a"},{"pprs","lp"}},
        il metodo restituisce l’array b = {{4,2,3},{3,0,5,1},{4,2}}.
        */

        String[][] a = {{"abcd","ab","kzz"},{"cde","","hkkhh","a"},{"pprs","lp"}};
        int[][] b;

        b=lunghezzeStringhe(a);
        System.out.println("METODO ITARATIVO:");
        for(int i=0; i<b.length;i++){
            for(int j=0; j<b[i].length;j++){
                System.out.print(" "+b[i][j]);
            }
            System.out.println();
        }

        b=lunghezzaStringheRicorsivo(a);
        System.out.println("METODO ITARATIVO:");
        for(int i=0; i<b.length;i++){
            for(int j=0; j<b[i].length;j++){
                System.out.print(" "+b[i][j]);
            }
            System.out.println();
        }

    }

    // I T E R A T I V O
    public static int[][] lunghezzeStringhe(String[][] a){
        int[][] b = new int[a.length][];

        for(int i=0; i<a.length;i++){
            b[i] = new int[a[i].length];
            for(int j=0; j<a[i].length;j++){
                b[i][j]=a[i][j].length();
            }
        }

        return b;
    }


    // R I C O R S I V O 
    public static int[][] lunghezzaStringheRicorsivo(String[][] a){
        int [][] b = new int[a.length][];
        return lunghezzaStringheRicorsivo(a, b, 0, 0);
    }

    public static int[][] lunghezzaStringheRicorsivo(String[][] a,int[][] b, int i, int j){
        if(i>=a.length){
            return b;
        }
        if(j==0){
            b[i] = new int[a[i].length];
        }
        if(j>=a[i].length){
            return lunghezzaStringheRicorsivo(a, b, i+1, 0);
        }
        b[i][j]=a[i][j].length();
        return lunghezzaStringheRicorsivo(a, b, i, j+1);
    }

}
