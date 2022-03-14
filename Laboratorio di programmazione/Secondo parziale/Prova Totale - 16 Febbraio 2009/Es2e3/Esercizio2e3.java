import javax.swing.text.html.MinimalHTMLWriter;

public class Esercizio2e3 {
    public static void main(String[] args){
        /*
        Scrivere un metodo statico iterativo che, dati due array monodimensionali a e
        b di interi, restituisce un array monodimensionale c di interi dato dall’unione alternata di a
        e b, ovvero gli elementi di c sono gli elementi di a e di b alternati (a partire da a). Nel caso
        in cui a e b abbiano lunghezze diverse, la parte finale di c è data dalla parte finale dell’array
        piu´ lungo tra a e b. Ad esempio, dati a = {3,-1,5,4,-9,14} e b = {7,2,-5}, il metodo
        restituisce l’array c = {3,7,-1,2,5,-5,4,-9,14}.
        */

        int[] a = {3,-1,5,4,-9,14};
        int[] b = {7,2,-5};
        int[] c;

        //System.out.println("risultato: {3,7,-1,2,5,-5,4,-9,14}");
       // System.out.println("a: {3,-1,5,4,-9,14}");
       // System.out.println("b: {7,2,-5}");

        c=unione(a,b);  //chiamata metodo
        for(int i=0;i<c.length;i++){
            System.out.print(" "+c[i]);
        }
    }

    public static int[] unione(int[] a, int[] b){

        int[] c = new int[a.length+b.length];

        int contaA=0,contaB=0, minore;

        if(a.length<b.length) minore=a.length;  //la variabile minore è il valore della lunghezza dell'array più corto 
        else minore=b.length;

        //System.out.println(c.length);

        for (int i = 0; i < c.length; i++) {
            if (i < minore * 2) {   //il minore*2 perchè deve fare 2 cicli per avanzare di una posizione nei 2 array
                if (i % 2 == 0) {
                    c[i] = a[contaA];
                    contaA++;   //contatore esclusivo per array a
                } else {
                    c[i] = b[contaB];
                    contaB++;   //contatore esclusivo per array b
                }
            } else {        //se abbiamo superato le posizioni (i<minore*2) che sono presenti in entrabi gli array entriamo in questo else
                if (a.length > minore) {
                    c[i] = a[contaA];   //in questo caso considero solo l'array più grande di quello con lunghezza minore (la cui lunghezza è memorizzata in "minore")
                    contaA++;
                } else {
                    c[i] = b[contaB];
                    contaB++;
                }
            }
        }
        return c;   
    }
}
