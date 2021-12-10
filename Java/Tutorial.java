public class Tutorial { // il nome della classe deve essere lo stesso del nome del file
    public Tutorial() {

        // il simbolo // serve per creare un commento su una sigola riga

        // DICHIARAZIONE DELLE VARIABILI E TIPI

        byte numero8;           //variabile che contiene numero intero a 8 bit
        short numero16;         //variabile che contiene numero intero a 16 bit
        int numero32 = 10;      //variabile che contiene numero intero a 32 bit inizializzata a 10
        long numero64;          //variabile che contiene numero intero a 64 bit

        float decimale32 = 0;   // variabile che contiene numero decimale a virgola mobile 32 bit
        double decimale64 = 0;  // variabile che contiene numero decimale a virgola mobile 64 bit

        boolean booleano;       // variabile che può assumero solo 2 valori: true o false

        char carattere;         // variabile che contiene un solo carattere

        // _______________________________________________________________________________________________________________________________________________

        // ARRAY

        int[] arrayDiInteri = new int[50];          // array di lunghezza 5 contenente interi
        char[] arrayDiCaratteri = new char[50];     // array di lunghezza 5 contenente caratteri

        // <tipo>[] <nome variabile> = new <tipo>[lunghezza array]

        // per sapere la lungezza di un array di usa <nome array>.length
        // gli indici dell'array partono da 0 e non da 1

        numero32 = arrayDiCaratteri.length; // nella variabile intero3 viene inserita la lunghezza dell'array

        // _______________________________________________________________________________________________________________________________________________

        // ARRAY BIDIMENSIONALI
        int[][] arrayBidimensionale = new int[3][]; // dichiaro l'array bidimensionale con righe vuote
        // di altezza 3

        // Il numero di coppie di [] è pari alla dimensione dell'array
        /*
         * in questo caso l'array sarà inizializzato come:
         * 
         * null
         * null
         * null
         * 
         */

        arrayBidimensionale[0] = new int[2]; 
        arrayBidimensionale[1] = new int[4]; // dichiaro le righe dell'array
        arrayBidimensionale[2] = new int[3]; 

        // Le righe di un array bidimensionale possono avere lunghezze diverse

        /*
         * In fase di creazione di un array bidimensionale, è possibile specificare un
         * valore numerico anche dentro la seconda coppia di []:
         * 
         * int [][] a1 = new int [3][2];
         * 
         * In tal caso viene dichiarato un identificatore a1 per riferire un array
         * bidimensionli di interi avente 3 righe, tutte di lunghezza pari a 2
         * (ovvero,una matrice 3x2).
         */

        int[][] b = { { 1, 2, 3 }, { 5, 6, 7, 9 }, { -2, -5 } }; // creazione per enumerazione

        // _______________________________________________________________________________________________________________________________________________

        // STRINGHE

        String stringa = "parola";
        String stringa2 = "Ciao";
        String t;

        // metodo length
        numero32 = stringa.length();         // restituisce in intero3 il numeoro di caratteri nella stringa

        // metodo equals
        booleano = stringa.equals(stringa2); // se le due stringhe sono uguali la variabile bool sarà true altrimenti false
                                             // le stringe non si confrontano con l'operatore di uguaglianza ==

        // concatenzione di stringhe
        t = stringa.concat(stringa2);        // la stringa t conterrà le due stringhe concatenate
                                             // concat non funziona per concatenare una stringa 
                                             // char, int ecc con dati di altri tipi

        t = stringa + 'A';                   // non da errore a differenza di concat ache se i tipi sono diversi

        // estrazione id caratteri
        carattere = stringa.charAt(2);       // restituisce il carattere di s presente alla posizione 2

        // estrazione di sottostringhe
        t = stringa.substring(2);            // prende il testo dalla posizione 2 fino alla fine della stringa

        t = stringa.substring(0, 2);         // prende il testo dalla dalla posizione 0 fino alla posizione 2 inclusa

        // _______________________________________________________________________________________________________________________________________________

        // COSTANTI ==> si può fare un solo assegnamento, successivamente non possono
        // essere cambiate
        // ==> il nome di una costante simbolica contiene tutte lettere maiuscole. In
        // caso di più parole nel nome, queste sono separate da un trattino basso _

        final int COSTANTE_INTERA = 2;       // costante di tipo intero
        final double PI_GRECO = 3.14;        // costante decimale a 64 bit a virgola mobile

        // _______________________________________________________________________________________________________________________________________________

        // OPERATORI ARITMETICI

        numero32++; // ++ autoincremento ==> intero3=intero3+1
        numero32--; // -- autodecremento ==> intero3=intero3-1

        /*
         * 
         * + ==> somma
         * - ==> sottrazione
         * ==> prodotto
         * / ==> divisione
         * % ==> modulo
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
          > (maggiore di)
          < (minore di)
          >= (maggiore o uguale)
          <= (minore o uguale)
          == (uguale a)
          != (diverso da)
        */

        // _______________________________________________________________________________________________________________________________________________

        // COSTRUTTO ITERATIVO

        // ciclo WHILE
        /*
            while(condizione) {
                istruzioni...
            } 
        */
        while (booleano) { // nella condizione possiamo controllare qualsiasi variabile o espressione
            // codice da eseguire
        }

        // ***********

        // ciclo FOR
        /*
            for(inizilizzazione,condizione,incremento){
                istruzioni
            }
        */

        for (int i = 0; i < 10; i++) { // il ciclo eseguirà per 10 volte
            // codice da eseguire
        }

        // _______________________________________________________________________________________________________________________________________________

        // CONVERSIONI DI TIPO
        int x = Integer.parseInt("10");          // covertiamo la stringa contenuta nel vettore args in un numero intero, che
                                                 // andremo a posizionare nella variabile x
        decimale64 = Double.parseDouble("3.14"); // covertiamo la stringa contenuta nel vettore args in un numero
                                                 // decimale, che andremo a posizionare nella variabile b

        numero8 = (byte) numero32;               // cast di variabile ==> forzo l'assegnazione ad una variabile di tipo byte una
                                                 // variabile di tipo int (forzare il tipo di una variabile ad un tipo diverso)
        numero32 = (int) decimale32;             // cast di variabile da double a int ==> perdita della parte decimale

        // METODI PER STAMPARE A SCHERMO
        System.out.println("ciao");              // stampa una stringa con scritto ==> ciao e va a capo
        System.out.print("ciao");                // stampa una stringa con scritto ==> ciao
        System.out.println(numero32);            // stampa a schermo la variabile a (può essere di qualsiasi tipo int, double
        // ecc..)
        System.out.println("ab" + "cd");         // il + viene usato per concatenare due stringhe
        System.out.println(1 + 1);               // il + viene usato per fare la somma di due numeri

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

        if (booleano) { // il controllo si può fare tra due int, bool ed ecc..
            // codice da eseguire
        } else {
            // altro codice da eseguire
        }

        // possiamo anche annidare uno dentro l'altro gli if
        if (booleano) {
            if (x >= numero32) {
                // codice da eseguire
            }
        }

        // _______________________________________________________________________________________________________________________________________________

        // CASI PARTICOLARI
        byte b1 = 1, b2 = 2;
        /*
            byte b3 = b1 + b2;
            FORMA ERRATA nella somma b1+b2, in quanto i risultati
            parziali del alcolo di espressioni vengono memorizzati in variabili implicite
            di tipo int
        */
        byte b3 = (byte) (b1 + b2); // <== forma corretta per fare la somma, usando quidi il cast di variabili

        // _______________________________________________________________________________________________________________________________________________

        // I METODI

        int parametro1 = 7, parametro2 = 5;

        metodo1(parametro1, parametro2); // chiamiamo il metodo passandogli i valori richiesti (in questo caso int)

        // _______________________________________________________________________________________________________________________________________________

        // RICORSIONE

    }

    // _______________________________________________________________________________________________________________________________________________

    // I METODI

    // public class <nome> { ==> inserire se vogliamo creare un metodo in un altro
    // file

    public static int metodo1(int x, int y) { // ==> definizione del metodo all'interno dello stesso file
        int valore = 0;

        valore = x + y;

        return valore; // restituisce un valore di tipo intero contenente nella variabile Val
    }

    /*
     * Se un metodo non restituisce alcun risultato, ovvero è un metodo nella cui
     * intestazione compare la parola riservata void prima del
     * nome del metodo, allora la sintassi dell'istruzione di uscita è data
     * solamente dalla parola riservata return seguita da ;.
     * 
     * La semantica dell'istruzione return; consiste nell'uscire dal metodo
     * completando la sua esecuzione e nel restituire il controllo al metodo
     * chiamante.
     * 
     * Se l'uscita da un metodo di tipo void coincide con la fine del corpo del
     * metodo, allora non è necessario mettere return;.
     */

    // _______________________________________________________________________________________________________________________________________________

}