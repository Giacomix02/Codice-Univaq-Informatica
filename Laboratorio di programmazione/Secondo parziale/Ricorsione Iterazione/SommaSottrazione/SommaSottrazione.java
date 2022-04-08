public class SommaPaSottrazioneDi {
    public static void main(String[] args) {

        /*
         * 
         * Scrivere un metodo ricorsivo che, dato un array a di interi, restituisce la
         * somma
         * alternante di a, ovvero il valore ottenuto aggiungendo gli elementi di a in
         * posizione pari e sottraendo gli elementi di a in posizione dispari.
         * Ad esempio, dato l’array a = {7,3,4,-6,-11}, il metodo restituisce 3
         * 
         */

        int num[] = { 7, 3, 4, -6, -11 };
        int out;

        out = SommaSottrazione(num);
        System.out.println("\n Risultato==>" + out);

    }

    public static int SommaSottrazione(int[] num) {

        return SommaSottrazione(num, 0, 0);
    }

    public static int SommaSottrazione(int[] num, int i, int risultato) {
        System.out.println("i ==>" + i);

        if (num.length == i)
            return risultato;
        if (i % 2 == 0)
            risultato = risultato + num[i];
        else
            risultato = risultato - num[i];

        i++;

        return SommaSottrazione(num, i, risultato);
    }
}
