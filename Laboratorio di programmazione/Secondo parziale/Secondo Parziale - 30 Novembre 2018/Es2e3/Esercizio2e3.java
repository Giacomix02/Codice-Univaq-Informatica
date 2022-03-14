
public class Esercizio2e3 {
    public static void main(String[] args){
        /*
            Scrivere un metodo che, dati un array bidimensionale di interi a, un array
            monodimensionale di interi b ed un intero k, restituisce true se in ogni riga a[i] di a esistono
            almeno k numeri minori o uguali a b[i], altrimenti il metodo restituisce false. 
            Esempio: se a = {{7,3,-2,2,9},{5,0,8,3},{15,11,-2}}, b = {6,3,11} e k = 2, il metodo restituisce true.
            N.B. 
            i) Occorre restituire false non appena si trova una riga a[i] che non soddisfa la condizione richiesta. 
            ii)Occorre passare alla riga successiva non appena si verifica che una riga a[i] soddisfa la condizione richiesta.
            iii) Si assuma che gli array a e b abbiano la stessa lunghezza e k > 0.
        */

        int[][] a = {{7,3,-2,2,9},{5,0,8,3},{15,11,-2}};
        int[] b = {6,3,11};
        int k = 2;

        System.out.print("METODO ITERATIVO >> ");
        System.out.println(numeroRicorrenzeNumeri(a,b,k));

        System.out.print("\nMETODO RICORSIVO >> ");
        System.out.println(numeroRicorrenzeNumeriRicorsivo(a,b,k));

       

    }

    // I T E R A T I V O 
    public static boolean numeroRicorrenzeNumeri(int[][] a,int[] b, int k){
        for(int i=0;i<a.length;i++){
            int conta=0;
            for(int j=0;j<a[i].length && conta<k;j++){
                if(a[i][j]<=b[i]) conta++;
            }
            if(conta<k) return false;
        }
        return true;
    }

    // R I C O R S I V O
    public static boolean numeroRicorrenzeNumeriRicorsivo(int[][] a, int[] b, int k){
        return numeroRicorrenzeNumeriRicorsivo(a, b, k, 0, 0, 0);
    }

    public static boolean numeroRicorrenzeNumeriRicorsivo(int[][] a, int[] b, int k,int i, int j, int conta){
        if(i>=a.length){
            return true;
        }

        if(j>=a[i].length || conta>k){
            if(conta<k) return false;
            return numeroRicorrenzeNumeriRicorsivo(a, b, k, i+1, 0, 0);
        }

        if(a[i][j]<=b[i]) conta++;
        return numeroRicorrenzeNumeriRicorsivo(a, b, k, i, j+1, conta);
    }

}
