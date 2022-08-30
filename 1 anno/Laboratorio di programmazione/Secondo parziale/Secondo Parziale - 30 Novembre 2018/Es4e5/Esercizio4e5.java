public class Esercizio4e5 {
    public static void main(String[] args){
        /*
            Scrivere un metodo che, dato un array monodimensionale di stringhe a, restituisce un array bidimensionale di caratteri c
            tale che la riga c[i] contiene i caratteri della stringa a[i] (letta da sx a dx).
            Esempio: se a = {"dcba","k","","9qr","v3"}, 
            il metodo restituisce l’array c = {{’d’,’c’,’b’,’a’},{’k’},{},{’9’,’q’,’r’},{’v’,’3’}}.

        */

        String[] a = {"dcba","k","","9qr","v3"};
        char[][] c;

        c=suddividoStringa(a);
        System.out.println("METODO ITERATIVO:");
        for(int i=0 ; i<c.length;i++){
            System.out.print("\t-->");
            for(int j=0;j<c[i].length;j++){
                System.out.print(" "+c[i][j]);
            }
            System.out.println();
        }

        c=suddividoStringaRicorsivo(a);
        System.out.println("\n\nMETODO RICORSIVO:");
        for(int i=0 ; i<c.length;i++){
            System.out.print("\t-->");
            for(int j=0;j<c[i].length;j++){
                System.out.print(" "+c[i][j]);
            }
            System.out.println();
        }

    }

    // I T E R T I V O 

    public static char[][] suddividoStringa(String[] a){
        char[][] c = new char[a.length][];

        for(int i=0;i<a.length;i++){
            c[i] = new char[a[i].length()];
            for(int j=0;j<a[i].length();j++){
                c[i][j]=a[i].charAt(j);
            }
        }
        return c;
    }

    // R I C O R S I V O 

    public static char[][] suddividoStringaRicorsivo(String[] a){
        char[][] c= new char[a.length][];
        return suddividoStringaRicorsivo(a,c,0,0);

    }

    public static char[][] suddividoStringaRicorsivo(String[] a, char[][] c, int i, int j){

        if(i>=a.length){
            return c;
        }
        if(j==0){
            c[i] = new char[a[i].length()];
        }
        if(j>=a[i].length()){
            return suddividoStringaRicorsivo(a, c, i+1, 0);
        }
        c[i][j]=a[i].charAt(j);
        return suddividoStringaRicorsivo(a, c, i, j+1);

    }
}
