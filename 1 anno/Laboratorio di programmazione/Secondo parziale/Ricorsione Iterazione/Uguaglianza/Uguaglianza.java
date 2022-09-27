public class ControlloUguaglianzaCaratteri {
    public static void main(String[] args) {

        /*
         * Scrivere un metodo che, dati un array bidimensionale di caratteri a, un
         * carattere c ed un array monodimensionale di interi b, restituisce true se per
         * ogni riga
         * a[i] di a si ha che in a[i] esistono almeno b[i] elementi uguali al carattere
         * c, altrimenti
         * il metodo restituisce false. Ad esempio, dati a =
         * {{'a','b','a','d'},{'c','a','a'},
         * {'a','a','g','a','w'}}, c = 'a' e b = {2,1,3}, il metodo restituisce true.
         * Si assuma che gli array a e b abbiano la stessa lunghezza
         * 
         */

        boolean out;

        char biChar[][] = { { 'a', 'b', 'a', 'd' }, { 'c', 'a', 'a' }, { 'a', 'a', 'g', 'a', 'w' } };
        char carattere = 'a';
        int num[] = { 2, 1, 3 };

        System.out.print("Metodo iterativo >> ");
        out = Controllo(biChar, carattere, num); // metodo iterativo
        System.out.println(out);

        System.out.println("Metodo ricorsivo >> ");
        out = ControlloRicorsivo(biChar, carattere, num); // metodo iterativo
        System.out.println(out);

    }

    public static boolean Controllo(char biChar[][], char carattere, int num[]) { // metodo iterativo

        boolean finale = false;
        int uguale = 0, k = 0;

        for (int i = 0; i < biChar.length && finale == true; i++) {
            uguale = 0;
            for (int j = 0; j < biChar[i].length; j++) {
                if (biChar[i][j] == carattere)
                    uguale++;
            }

            if (uguale == num[k])
                finale = true;
            k++;
        }

        return finale;

    }

    public static boolean ControlloRicorsivo(char biChar[][], char carattere, int num[]) { // metodo ricorsivo iniziale
        return ControlloRicorsivo(biChar, carattere, num, 0, 0, 0, 0, false);
    }

    public static boolean ControlloRicorsivo(char biChar[][], char carattere, int num[], int i, int j, int k,
            int uguale, boolean finale) { // metodo ricorsivo con l'output
        if (i == biChar.length)
            return finale;

        System.out.println("\t" + biChar[i][j] + "==" + carattere);

        if (biChar[i][j] == carattere) {
            uguale++;
        }
        j++;

        if (j == biChar[i].length) {
            System.out.println("\t" + uguale + "==" + num[k]);
            if (uguale == num[k])
                finale = true;
            else
                return false;
            k++;
            i++;
            j = 0;
            uguale = 0;
        }

        System.out.println("i ==>" + i);

        return ControlloRicorsivo(biChar, carattere, num, i, j, k, uguale, finale);

    }
}
