public class Esercizio4 {
    public static void main(String[] args) {
        /*
            Scrivere un metodo che, dato un array monodimensionale di interi a ed un
            intero k (k > 0), restituisce true se in a compaiono almeno k coppie di elementi adiacenti
            uguali, altrimenti il metodo restituisce false. Ad esempio, se a = {3,5,5,-1,7,7,7,4} e
            k = 3, il metodo restituisce true.
        */

        int[] a = {3,5,5,-1,7,7,7,4};
        int k=3;
        System.out.println(adiacenti(a,k));


    }

    public static boolean adiacenti(int[] a, int k){
        int conta =0 ;
        for(int i=0;i<a.length-1;i++){
            if(a[i]==a[i+1]) conta++;
        }

        if(conta>=k) return true;
        else return false;
    }
}
