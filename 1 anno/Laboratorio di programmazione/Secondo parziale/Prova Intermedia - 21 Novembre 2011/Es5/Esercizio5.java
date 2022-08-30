import javax.swing.text.html.HTMLDocument.BlockElement;

public class Esercizio5 {
    public static void main(String[] args) {
        /*
            Scrivere un metodo che, dati un array bidimensionale di stringhe a ed un array
            monodimensionale di caratteri c, restituisce un array di booleani b tale che l’elemento b[i]
            vale true se ogni stringa nella riga a[i] termina con il carattere c[i], altrimenti b[i] vale false.
            Ad esempio, se a = {{"jhsz","r5","pxx"},{"pw","sqw"},{"kff","sbtf","f","gbxf"}}
            e c = {’z’,’w’,’f’}, il metodo restituisce b = {false,true,true}.
            Si assuma che gli array a e c abbiano la stessa lunghezza
        */
        
        String[][] a = {{"jhsz","r5","pxx"},{"pw","sqw"},{"kff","sbtf","f","gbxf"}};
        char[] c = {'z','w','f'};
        boolean[] b;

        System.out.println("METODO ITERATIVO:");
        b= carattereTerminale(a,c);
        for(int i=0; i<b.length;i++){
            System.out.print(" "+b[i]);
        }

        System.out.println("\n\nMETODO RICORSIVO:");
        b= carattereTerminaleRicorsivo(a,c);
        for(int i=0; i<b.length;i++){
            System.out.print(" "+b[i]);
        }
    }

    // I T E R A T I V O 

    public static boolean[] carattereTerminale(String[][] a,char[] c){
        boolean[] b = new boolean[a.length];
        boolean trovato = true;
        for(int i=0; i<a.length;i++){
            for(int j=0;j<a[i].length && trovato ;j++){
                if(a[i][j].charAt(a[i][j].length()-1)==c[i]) trovato=true;
                else trovato=false;
            }
            b[i] = trovato;
            trovato=true;
        }


        return b;
    }

    // R I C O R S I V O 

    public static boolean[] carattereTerminaleRicorsivo(String[][] a,char[] c){
        boolean[] b = new boolean[a.length];
        boolean trovato = true;
        return carattereTerminaleRicorsivo(a, c, 0, 0, trovato, b);

    }

    public static boolean[] carattereTerminaleRicorsivo(String[][] a, char[] c, int i, int j, boolean trovato, boolean[] b){
        if(i>=a.length){
            return b;
        }
        if(j>=a[i].length || !trovato){
            b[i] = trovato;
            return carattereTerminaleRicorsivo(a, c, i+1, 0, true, b);
        }

        if(a[i][j].charAt(a[i][j].length()-1)==c[i]) trovato=true;
        else trovato=false;
        return carattereTerminaleRicorsivo(a, c, i, j+1, trovato, b);


    }
}
