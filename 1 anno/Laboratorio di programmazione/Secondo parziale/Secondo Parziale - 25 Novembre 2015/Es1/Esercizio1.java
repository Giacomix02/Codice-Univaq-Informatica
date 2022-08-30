public class Esercizio1 {

    public static void main(String[] args){

        /*
            Scrivere un metodo che, dati un array bidimensionale di interi a, un array monodimensionale di interi r ed un intero k, 
            restituisce un array monodimensionale di booleani b tale che b[i] vale true se esistono almeno k coppie di elementi adiacenti di a[i]
            tali che la loro somma `e uguale ad r[i], altrimenti b[i] vale false. 
            Esempio: se a = {{3,-7,12,0,2,3,9,3,2,10},{1,1,-9,1,1},{4},{7,-1,3,3,3,2}}, r = {12,2,5,6}
            e k = 3, il metodo restituisce l’array b = {true,false,false,true}.
            Si assuma k > 0 e che gli array a ed r abbiano la stessa lunghezza.
        */

        int a[][] = {{3,-7,12,0,2,3,9,3,2,10},{1,1,-9,1,1},{4},{7,-1,3,3,3,2}};
        int[] r = {12,2,5,6};
        int k = 3;
        boolean[] out = new boolean[a.length];

        out = SommaAdiacenti(a,r,k);

        System.out.println("RISULTATI:");   //da non mettere durante il compito (vieni inculato)
        for(int i=0;i<out.length;i++){
            System.out.println("\t-->"+out[i]);
        }

    }

    public static boolean[] SommaAdiacenti(int a[][], int[] r, int k){
        
        boolean[] b = new boolean[a.length];

        for(int i=0;i<a.length;i++){

            int conta=0;

            for(int j=1;j<a[i].length;j++){

                int somma=0;
                somma=a[i][j]+a[i][j-1];

                if(somma==r[i]) conta++;
                
            }

            if(conta>=k) b[i]=true;
        }


        return b;
    }
}
