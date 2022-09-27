public class Esercizio2e3 {
    public static void main(String[] args) {

        /*
         * 
         * Scrivere un metodo statico iterativo che, dati un array bidimensionale di
         * stringhe a, un array monodimensionale di interi b ed un intero k, restituisce un array
         * monodimensionale di stringhe c tale che c[i]
         * `e la concatenazione delle prime k stringhe nella riga a[i]
         * (letta da sx a dx) la cui lunghezza `e minore di b[i]. Se in a[i] non
         * esistono tali k stringhe,
         * allora c[i] `e la stringa vuota.
         * Esempio: se a =
         * {{"abc","fw","p","hd","w2"},{"gg","p5rw1"},{"by","stop","red","spq"}}, b =
         * {3,5,4} e k = 2,
         * il metodo restituisce l’array c = {"fwp","","byred"}.
         * Si assuma che gli array a e b abbiano lunghezza uguale e k > 0.
         * N.B. Occorre passare alla riga successiva non appena sono state concatenate
         * in c[i] le prime
         * k stringhe che soddisfano la condizione data.
         * 
         */

        String a[][] = { { "abc", "fw", "p", "hd", "w2" }, { "gg", "p5rw1" }, { "by", "stop", "red", "spq" } };
        int[] b = { 3, 5, 4 };
        int k = 2;

        String out[] = new String[a.length];

        System.out.println("METODO ITERATIVO:\n\noutput:\n");
        Confronto(a, b, k);

        System.out.println("\n\nMETODO RICORSIVO:\n");
        out=ConfrontoRicorsivo(a, b, k);

        System.out.println("\noutput:\n");

        for(int i=0;i<out.length;i++) {
            System.out.println("\t-->"+out[i]);
        }

    }

     //I T E R A Z I O N E 

    public static String[] Confronto(String[][] a, int[] b, int k) {   

        String[] c = new String[a.length];

        for (int i = 0; i < c.length; i++) { // "tolgo" il null dall'array e ad ogni posizione ci butto dentro una stringa vuota
            c[i] = "";
        }

        for (int i = 0; i < a.length; i++) {

            int conta = 0; // variabile che conta le stringhe maggiori di b[i]

            for (int j = 0; j < a[i].length && conta < k; j++) {

                if (a[i][j].length() < b[i]) {
                    c[i] = c[i] + a[i][j]; // concateno le stringhe
                    conta++;
                }

            }

            if (conta < k)
                c[i] = ""; // se non ho abbastanza stringhe uso stringa vuota

            System.out.println("\t-->" + c[i]); // da non srivere nel compito
        }

        return c;
    }

    //  R I C O R S I O N E 

    public static String[] ConfrontoRicorsivo(String[][] a, int[] b, int k) { // metodo ricorsivo caso base
        String[] c = new String[a.length];

        for (int i = 0; i < c.length; i++) { // "tolgo" il null dal array ci butto dentro una stringa vuota
            c[i] = ""; // NON ESSENZIALE
        }

        return ConfrontoRicorsivo(a, b, k, c, 0, 0, 0);
    }

    public static String[] ConfrontoRicorsivo(String[][] a, int[] b, int k, String[] c, int i, int j, int conta) {

        if (i == a.length) return c; // se ho letto tutto l'array ritorno l'array c ed esco dalla ricorsione

        System.out.print("i"+i);
        System.out.print("  j"+j);
        


        if(j == a[i].length ){
            
            if (conta < k)   c[i] = ""; // se non ho abbastanza stringhe uso stringa vuota
            System.out.print("  \tsono entrato in==> if(j == a[i].length ) \n");

            i++;
            j=0;
            conta = 0;

            return ConfrontoRicorsivo(a, b, k, c, i, j, conta);
        }

        
        if (a[i][j].length() < b[i]) {

            c[i] = c[i] + a[i][j]; // concateno le stringhe
            conta++;
        }

        System.out.print("  conta"+conta+"\n");

        if (conta == k) {

            if (conta < k)   c[i] = ""; // se non ho abbastanza stringhe uso stringa vuota
            System.out.print("  \t\tsono entrato in==>  if (conta == k)  \n");

            i++;
            j=0;
            conta = 0;

            return ConfrontoRicorsivo(a, b, k, c, i, j, conta);
        }

        return ConfrontoRicorsivo(a, b, k, c, i, j+1, conta);

    }
}
