
/*
Esercizio 1)
    Scrivere un metodo statico iterativo che, dati un array bidimensionale di
    interi a ed un array monodimensionale di interi v, restituisce un array monodimensionale
    di booleani b tale che b[i] vale true se nella riga a[i] esiste almeno una coppia di elementi
    adiacenti la cui somma e uguale a v[i], altrimenti b[i] vale false.
    Si assuma che gli array a e v abbiano lunghezza uguale.

N.B. Occorre passare alla riga successiva non appena e stata trovata la prima coppia di
interi che soddisfa la condizione data.
Input:  
    a = {
            {3,-2,7,4,1,5},
            {4,1,3,-1},
            {3,5,-2}
        }

    v = {5,2,7}

Output:
    {true,true,false}
*/

public class Esercizio1 {
    public static void main(String[] args) {
        int[][] a = {
                { 3, -2, 7, 4, 1, 5 },
                { 4, 1, 3, -1 },
                { 3, 5, -2 }
        };
        int[] v = { 5, 2, 7 };
        boolean[] output;

        System.out.println("METODO ITERATIVO:");
        output = esercizio1(a, v);

        System.out.println("\nMETODO RICORSIVO:");
        output = esercizio1Ricorsivo(a,v);
        for(int i=0;i<output.length;i++){
            System.out.println(output[i]);
        }

    }

    /*
     * Con j = 1 e length normale
     * [j-1, j]
     * 
     * Con j = 0 e length -1
     * [j, j+1]
     */
    public static boolean[] esercizio1(int[][] a, int[] v) {
        boolean[] b = new boolean[a.length];
        for (int i = 0; i < a.length; i++) { // scorre le righe
            boolean trovato = false;
            for (int j = 1; j < a[i].length && !trovato; j++) { // scorre le colonne
                int somma = a[i][j - 1] + a[i][j];
                if (somma == v[i])
                    trovato = true;
            }
            b[i] = trovato;
            System.out.println(trovato);
        }
        return b;
    }


    // I T E R A Z I O N E (potrebbe non funzionare, non è stato compilato e rannato)

    public static boolean[] esercizio1Ricorsivo(int[][] a, int[] v){
        boolean[] b = new boolean[a.length];
        boolean trovato=false;
        int somma=0;
        return esercizio1Ricorsivo(a, v, b, 0, 1, trovato,somma);
    }

    public static boolean[] esercizio1Ricorsivo(int[][] a,int[] v,boolean[] b, int i, int j, boolean trovato, int somma){
        if(i>=a.length) return b;

        if(j>=a[i].length || trovato){
            b[i]=trovato;
            return esercizio1Ricorsivo(a, v, b, i+1, 1, false, 0);
        }

        somma=a[i][j-1]+a[i][j];
        if (somma == v[i]) trovato = true;
        return esercizio1Ricorsivo(a, v, b, i, j+1, trovato, somma);

    }

}
