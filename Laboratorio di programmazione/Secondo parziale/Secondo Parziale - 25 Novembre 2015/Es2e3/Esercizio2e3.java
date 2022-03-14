public class Esercizio2e3 {
    public static void main(String[] args) {
        /*
        Scrivere un metodo che, dati una stringa (non vuota) s ed un carattere c, restituisce una nuova stringa ottenuta da s inserendo c tra ogni carattere di s ed il suo successore.
        Esempio: se s = "alloro" e c = ’-’, il metodo restituisce la stringa "a-l-l-o-r-o".
        */
        String s="alloro";
        char c='-';
        String out;

        System.out.println("METODO ITERATIVO:");
        out=separaCaratteri(s,c);
        System.out.println(out);    //da non mettere nel compito

        System.out.println("\nMETODO RICORSIVO:");
        out=separaCaratteriRicorsivo(s,c);
        System.out.println(out);    //da non mettere nel compito

    }
    
        // I T E R A Z I O N E 
    public static String separaCaratteri(String s,char c){

        String s1="";

        for(int i=0;i<s.length();i++){
            s1=s1+s.charAt(i);
            if(i<(s.length()-1))s1=s1+"-";  //faccio si che il "-" non venga messo dopo l'ultimo carattere
        }

        return s1;
    }

        // R I C O R S I O N E 

    public static String separaCaratteriRicorsivo(String s,char c){     //metodo di base
        String s1="";

        return separaCaratteriRicorsivo(s,c,s1,0);
    }

    public static String separaCaratteriRicorsivo(String s, char c, String s1,int i){
        if(i==s.length()) return s1;
        s1=s1+s.charAt(i);
        if(i<(s.length()-1))s1=s1+"-";  //faccio si che il "-" non venga messo dopo l'ultimo carattere
        return separaCaratteriRicorsivo(s,c,s1,i+1);
    }
}
