public class Esercizio4e5 {
    public static void main(String[] args){
        /*
         * Scrivere un metodo che, dato un array bidimensionale di stringhe a,
         * restituisce un array bidimensionale di caratteri c
         * tale che ogni elemento c[i][j] `e il primo carattere della stringa a[i][j].
         * Nel caso in cui a[i][j] sia la stringa vuota, allora c[i][j] vale ’-’.
         * Esempio: se a = {{"abc","df",""},{"yy","ffxx"},{"qrjq","","p","hgfq"}}, il
         * metodo restituisce l’array c = {{’a’,’d’,’-’},{’y’,’f’},{’q’,’-’,’p’,’h’}}.
         */

        String[][] a = { { "abc", "df", "" }, { "yy", "ffxx" }, { "qrjq", "", "p", "hgfq" } };
        char[][] c;

        c = primiCaratteri(a);

        System.out.println("METODO ITERATIVO:");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(" " + c[i][j] + " ");
            }
            System.out.println();
        }

        c = primiCaratteriRicorsivo(a);

        System.out.println("\nMETODO RICORSIVO:");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(" " + c[i][j] + " ");
            }
            System.out.println();
        }
    }

    // I T E R A Z I O N E

    public static char[][] primiCaratteri(String[][] a) {

        char[][] out = new char[a.length][]; // creo array mododimensionale che poi diventerà bidimensionale

        for (int i = 0; i < a.length; i++) {

            out[i] = new char[a[i].length]; // out diventa bidimensionale con la stessa lunghezza di a

            for (int j = 0; j < a[i].length; j++) {

                if (a[i][j].equals(""))
                    out[i][j] = '-';
                else
                    out[i][j] = a[i][j].charAt(0);
            }

        }
        return out;
    }

    // R I C O R S I O N E

    public static char[][] primiCaratteriRicorsivo(String[][] a) { // metodo base

        char[][] out = new char[a.length][]; // creo array mododimensionale che poi diventerà bidimensionale

        return primiCaratteriRicorsivo(a, out, 0, 0);
    }

    public static char[][] primiCaratteriRicorsivo(String[][] a,char[][] out,int i, int j){  //metodo ricorsivo

        if(i==a.length) return out;

        if(j==a[i].length) {
            j=0;
            i++;
            //System.out.println("\n"); only for debug
            return primiCaratteriRicorsivo(a, out, i, j);
        }

        if(j==0)
        out[i]=new char[a[i].length];
        /*
        System.out.println(out[i].length);          abilitare per vedere il log
        System.out.println(j);
        */

        if(a[i][j].equals("")) out[i][j]='-';
        else out[i][j]=a[i][j].charAt(0);

        //System.out.println("i==>"+i+"\tj==>"+j);    non stampare al compito, serve per il debug


        j++;
        return primiCaratteriRicorsivo(a, out, i, j);
    }


}
