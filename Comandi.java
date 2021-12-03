public class Comandi { // il nome della classe deve essere lo stesso del nome del file
    public static void main(String[] args) { // String[] argv ==> immissione input in un array

        // il simbolo // serve per comenare il codice su una sigola riga

        // DICHIARAZIONE DELLE VARIABILI E TIPI

        byte Intero1; // variabile che contiene numero intero a 8 bit
        short Intero2; // variabile che contiene numero intero a 16 bit
        int Intero3 = 0; // variabile che contiene numero intero a 32 bit inizializzata con un valore
        long Intero4; // variabile che contiene numero intero a 64 bit

        float Decimale1 = 0; // variabile che contiene numero decimale a virgola mobile 32 bit
        double Decimale2 = 0; // variabile che contiene numero decimale a virgola mobile con maggiore
                              // precisione 64 bit

        boolean YesOrNot; // variabile che può assumero solo 2 valori: true o false

        char Carattere; // variabile che contiene un solo carattere

        // _______________________________________________________________________________________________________________________________________________

        // ARRAY

        int[] Intero = new int[50]; // array di lunghezza 5 contenente interi
        char[] ACarattere = new char[50]; // array di lunghezza 5 contenente caratteri

        // <tipo>[] <nome> = new <tipo>[m]

        // un array è composto da un insieme di m variabili
        // l'indice dell'array va da 0 a m-1

        // per sapere la lungezza di un array di usa <nome array>.lenght

        Intero3 = ACarattere.length; // nella variabile Intero3 viene inserita la lunghezza dell'array

        // _______________________________________________________________________________________________________________________________________________

        //ARRAY BIDIMENSIONALI

        int [][] a = new int[3][];  //dichiaro il l'array monodimensionale

        //Il numero di coppie di [] è pari alla dimensione dell'array

        /*
            in questo caso l'array sarà inizializzato come:

            null
            null
            null

        */

        a[0] = new int[2];      //
        a[1] = new int[4];      //dichiaro le righe dell'array
        a[2] = new int[3];      //

        //Le righe di un array bidim. possono avere lunghezze diverse


        /*In fase di creazione di un array bidim., è possibile specificare un valore numerico anche dentro la seconda coppia di []:

            int [][] a1 = new int [3][2];

            In tal caso viene dichiarato un identificatore a1 per riferire un array bidimensionli di interi avente 3 righe, tutte di lunghezza pari a 2 (ovvero,una matrice 3x2).
        */

        int [][] b = {{1 ,2 ,3} ,{5 ,6 ,7 ,9} ,{ -2 , -5}}; //creazione per enumerazione


        // _______________________________________________________________________________________________________________________________________________

        // STRINGHE

        String s = "parola";
        String s1 = "Ciao";
        String t;
        
        // metodo lenght
        Intero3 = s.length(); // restituisce in Intero3 il numeoro di caratteri nella stringa

        // metodo equals
        YesOrNot = s1.equals(s); // se le due stringhe sono uguali la variabile bool sarà true altrimenti false
        // le stringe non si confrontano con l'operatore di uguaglianza (==)

        // concatenzione di stringhe
        t = s.concat(s1); // la stringa t conterrà le due stringhe concatenate
        // concat non funziona per concatenare una stringa con dati di altri tipi tipo
        // char, int ecc

        t = s + 't'; // non da errore a differenza di concat ache se i tipi sono diversi

        //estrazione id caratteri
        Carattere = s.charAt(i); //restituisce il carattere di s presente alla posizione i (i>=0)

        //estrazione di sottostringhe
        t = s.substring(i); //nuova stringa uguale alla sottostringa di s dalla posizione i fino alla fine di s

        t = s.substring(i,j);   //nuova stringa uguale alla sottostringa di s dalla posizione i fino alla posizione j-1 inclusa

        // _______________________________________________________________________________________________________________________________________________

        // COSTANTI ==> si può fare un solo assegnamento, successivamente non possono
        // essere cambiate
        // ==> il nome di una costante simbolica contiene tutte lettere maiuscole. In
        // caso di più parole nel nome, queste sono separate da un trattino basso _

        final int COSTANTE_INTERA = 2; // costante di tipo intero
        final double COSTANTE_DECIMALE = 3.14; // costante decimale a 64 bit a virgola mobile

        // _______________________________________________________________________________________________________________________________________________

        // OPERATORI ARITMETICI

        Intero3++; // ++ autoincremento ==> Intero3=Intero3+1
        Intero3--; // -- autodecremento ==> Intero3=Intero3-1

        /*
         * 
         * + ==> somma - ==> differenza ==> prodotto / ==> divisione % ==> modulo
         * 
         * = ==> assegnamento
         * 
         */

        // _______________________________________________________________________________________________________________________________________________

        // OPERATORI LOGICI O BOOLEANI

        /*
         * 
         * ! ==> not (negazione)
         * 
         * && ==> and
         * 
         * || ==> or
         * 
         */

        // _______________________________________________________________________________________________________________________________________________

        // OPERATORI RELAZIONARI

        /*
         * > (maggiore di), < (minore di) >= (maggiore o uguale) <= (minore o uguale) ==
         * (uguale a) != (diverso da)
         * 
         */

        // _______________________________________________________________________________________________________________________________________________

        // COSTRUTTO ITERATIVO

        // ciclo WHILE
        /*
         * while(condizione) { istruzioni }
         * 
         */
        while (YesOrNot == true) { // nella condizione possiamo controllare qualsiasi variabile
            // codice da eseguire
        }

        // ***********

        // ciclo FOR
        /*
         * for(inizilizzazione,condizione,incremento){
         * 
         * istruzioni }
         * 
         */

        for (int i; Intero3 < 10; i++) { // il ciclo continuerà ad iterare finchè la variabile Intero3 è minore di 10

            Intero3++;
            // oppure altro codice

        }

        // ***********

        // ciclo do-while

        do{

        }while();

        /*
         * 
         * do{
         * 
         * istruzioni
         * 
         * }while(condizione)
         * 
         * 
         * il ciclo avviene per forza una volta e il controllo avviene alla fine dove
         * presente il while
         * 
         */

        // _______________________________________________________________________________________________________________________________________________

        // CONVERSIONI DI TIPO
        int x = Integer.parseInt(args[0]); // covertiamo la stringa contenuta nel vettore args in un numero intero, che
                                           // andremo a posizionare nella variabile x
        Decimale2 = Double.parseDouble(args[1]); // covertiamo la stringa contenuta nel vettore args in un numero
                                                 // decimale, che andremo a posizionare nella variabile b

        Intero1 = (byte) Intero3; // cast di variabile ==> forzo l'assegnazione ad una variabile di tipo byte una
                                  // variabile di tipo int (forzare il tipo di una variabile ad un tipo diverso)
        Intero3 = (int) Decimale2; // cast di variabile da double a int ==> perdita della parte decimale

        // METODI PER STAMPARE A SCHERMO
        System.out.println("ciao"); // stampa una stringa con scritto ==> ciao e va a capo
        System.out.print("ciao"); // stampa una stringa con scritto ==> ciao
        System.out.println(a); // stampa a schermo la variabile a (può essere di qualsiasi tipo int, double
                               // ecc..)
        System.out.println("ab" + "cd"); // il + viene usato per concatenare due stringhe
        System.out.println(1 + 1); // il + viene usato per fare la somma di due numeri

        // _______________________________________________________________________________________________________________________________________________

        // COSTRUTTO CONDIZIONALE (if)

        /*
         * if(condizione) {codice da eseguire} else { codice da eseguire}
         * 
         * se la condizione all'interno dell'if non si avvera viene eseguito il codice
         * all'interno dell'else
         */

        /*
         * if(condizione) {codice da eseguire}
         * 
         * se la condizione è vera viene eseguito il codice, sennò il programma lo
         * ignora e continua l'esecuzione
         * 
         */

        if (YesOrNot == true) { // il controllo si può fare tra due int, bool ed ecc..
            // codice da eseguire
        } else {
            // altro codice da eseguire
        }

        // possiamo anche annidare uno dentro l'altro gli if
        if (YesOrNot == true) {
            if (x >= Intero3) {
                // codice da eseguire
            }
        }

        // _______________________________________________________________________________________________________________________________________________

        // CASI PARTICOLARI
        byte b1 = 1, b2 = 2;
        byte b3 = b1 + b2; // <== FORMA ERRATA nella somma b1+b2, in quanto i risultati parziali del
                           // calcolo di espressioni vengono memorizzati in variabili implicite di tipo int
        byte b3 = (byte) (b1 + b2); // <== forma corretta per fare la somma, usando quidi il cast di variabili

        // _______________________________________________________________________________________________________________________________________________

        //I METODI

        int funz1=7, funz2=5;

        metodo1(funz1,funz2);   //chiamiamo il metodo passandogli i valori richiesti (in questo caso int)

        Intero3=metodo1();  //chiamiamo il metodo SENZA passargli i valori richiesti ma inserendo il risultato del passato del return in Intero3


        // _______________________________________________________________________________________________________________________________________________

        //RICORSIONE
        


    }



    // _______________________________________________________________________________________________________________________________________________

    // I METODI

    // public class <nome> { ==> inserire se vogliamo creare un metodo in un altro
    // file

    public static int metodo1(int x, int y) { // ==> definizione del metodo all'interno dello stesso file
        int Val = 0;

        //altro codice

        return Val; // restituisce un valore di tipo intero contenente nella variabile Val
    }


    /*
        Se un metodo non restituisce alcun risultato, ovvero è un metodo nella cui intestazione compare la parola riservata void prima del
        nome del metodo, allora la sintassi dell'istruzione di uscita è data solamente dalla parola riservata return seguita da ;.

        La semantica dell'istruzione return; consiste nell'uscire dal metodo completando la sua esecuzione e nel restituire il controllo al metodo chiamante.

        Se l'uscita da un metodo di tipo void coincide con la fine del corpo  del metodo, allora non è necessario mettere return;.
    */

    // _______________________________________________________________________________________________________________________________________________

}