public class Comandi{               //il nome della classe deve essere lo stesso del nome del file
    public static void main(String[] args) {    //String[] argv ==> immissione input in un array 

        //DICHIARAZIONE DELLE VARIABILI E TIPI 

        byte Intero1;          //variabile che contiene numero intero a 8 bit
        short Intero2;         //variabile che contiene numero intero a 16 bit
        int Intero3=0;         //variabile che contiene numero intero a 32 bit inizializzata con un valore
        long Intero4;         //variabile che contiene numero intero a 64 bit 

        float Decimale1=0;     //variabile che contiene numero decimale a virgola mobile 32 bit
        double Decimale2=0;     //variabile che contiene numero decimale a virgola mobile con maggiore precisione 64 bit

        boolean YesOrNot;      //variabile che può assumero solo 2 valori: true o false


        //CONVERSIONI DI TIPO
        int x = Integer.parseInt(args[0]);  //covertiamo la stringa contenuta nel vettore args in un numero intero, che  andremo a posizionare nella variabile x
        Decimale2 = Double.parseDouble(args[1]);     //covertiamo la stringa contenuta nel vettore args in un numero decimale, che  andremo a posizionare nella variabile b

        Intero1 = (byte)Intero3;    //cast di variabile ==> forzo l'assegnazione ad una variabile di tipo byte una variabile di tipo int (forzare il tipo di una variabile ad un tipo diverso)
        Intero3 = (int)Decimale2;   //cast di variabile da double a int ==> perdita della parte decimale


        //METODI PER STAMPARE A SCHERMO
        System.out.println("ciao");         //stampa una stringa con scritto ==> ciao e va a capo 
        System.out.print("ciao");           //stampa una stringa con scritto ==> ciao 
        System.out.println(a);              //stampa a schermo la variabile a (può essere di qualsiasi tipo int, double ecc..)
        System.out.println("ab"+"cd");      //il + viene usato per concatenare due stringhe
        System.out.println(1+1);            //il + viene usato per fare la somma di due numeri 


        
    }
}