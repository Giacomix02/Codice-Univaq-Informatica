public class Esercizio5 {
    public static void main(String[] args) {
        /*
            Scrivere un metodo che, dati due array monodimensionali di interi a e b
            ed un intero k (k > 0), restituisce true se tutti gli elementi di a compaiono almeno k
            volte in b, altrimenti il metodo restituisce false. Ad esempio, se a = {2,-3,5}, b =
            {5,-4,2,-3,2,-3,7,5,5} e k = 2, il metodo restituisce true.
        */
        int[] a = {2,-3,5};
        int[] b = {5,-4,2,-3,2,-3,7,5,5};
        int k = 2;
        boolean out;
        
        System.out.println("METODO ITERATIVO:");
        out = controllo(a,b,k);
        System.out.println(out);

        System.out.println("\nMETODO RICORSIVO:");
        out=controlloRicorsivo(a,b,k);
        System.out.println(out);

    }

    public static boolean controllo(int[] a, int[] b, int k){
        boolean out=true;
        int conta;

        for(int i=0;i<a.length && out;i++){
            conta=0;
            for(int j=0;j<b.length;j++){
                if(a[i]==b[j]) conta++;
            }
            if(conta<k) out=false;
        }
        
        return out;
    }

    public static boolean controlloRicorsivo(int[] a, int[] b, int k){
        return controlloRicorsivo(a, b, k, 0, 0, true,0);
    }

    public static boolean controlloRicorsivo(int[] a, int[] b, int k,int i, int j, boolean out,int conta){
        if(i>=a.length || !out) return out;
        if(j==0) conta=0;
        if(j>=b.length){
            if(conta<k) out=false;
            return controlloRicorsivo(a, b, k, i+1, 0, out, conta);
        }
        if(a[i]==b[j]) conta++;
        return controlloRicorsivo(a, b, k, i, j+1, out, conta);
    }
}
