public class LunghezzeStringBiArray {
    public static void main(String[] args) {

        /*
         * 
         * Scrivere un metodo che, dato un array bidimensionale di stringhe a,
         * restituisce
         * un array bidimensionale di interi b contenente le lunghezze degli elementi di
         * a nelle posizioni
         * corrispondenti. Ad esempio, se a =
         * {{"abcd","ab","kzz"},{"cde","","hkkhh","a"},{"pprs","lp"}}, il metodo
         * restituisce l’array b = {{4,2,3},{3,0,5,1},{4,2}}.
         * 
         * 
         */

        String[][] a = { { "abcd", "ab", "kzz" }, { "cde", "", "hkkhh", "a" }, { "pprs", "lp" } };
        int[][] num;

        num = sostituzione(a);

        System.out.println("Metodo iterativo: ");
        for (int i = 0; i < num.length; i++) { // output del programma iterazione
            for (int j = 0; j < num[i].length; j++) {
                System.out.println(num[i][j]);
            }
        }

        System.out.println("******************************");

        num = sostituzioneRicorsivo(a);
        System.out.println("Metodo ricorsivo: ");
        stampaArray(num);

    }

    public static void stampaArray(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print((i + 1) + ") ");
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] sostituzione(String[][] a) { // iterativo con metodo

        int b[][] = new int[a.length][];

        for (int i = 0; i < a.length; i++) {

            b[i] = new int[a[i].length];

            for (int j = 0; j < a[i].length; j++) {
                b[i][j] = a[i][j].length();
            }
        }

        return b;
    }

    public static int[][] sostituzioneRicorsivo(String[][] in) { // ricorsivo con metodo iniziale A

        int[][] out = new int[in.length][];
        return sostituzioneRicorsivo(in, out, 0, 0);
    }

    public static int[][] sostituzioneRicorsivo(String[][] in, int[][] out, int i, int j) { // B
        if (j == in[i].length) { // quando finisce di iterare la riga dell'array
            j = 0;
            i++;
        }
        if (i == in.length)
            return out; // quando finisce di iterare l'array
        if (j == 0) {
            out[i] = new int[in[i].length];
        }
        out[i][j] = in[i][j].length();
        j++;

        return sostituzioneRicorsivo(in, out, i, j);
    }

}