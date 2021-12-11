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
        
        out = controllo(a,b,k);
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
}
