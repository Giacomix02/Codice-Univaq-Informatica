class HaKAdiacenti {
    public static void main(String[] args) {
        /*
            Scrivi un metodo iterativo e ricorsivo per controllare se ogni stringa nell'array in input
            ha almeno K lettere adiacenti uguali, ritorna true se tutte lo hanno, sennò false
        */
        String[] input = {"appelo","jjygyyrr","ddd"};
        int k = 2;

        boolean trovato = haKAdiacenti(input,k); //iterativo
        System.out.println(trovato);

        boolean trovatoRicorsivo = ricHaKAdiacenti(input,k); //ricorsivo
        System.out.println(trovatoRicorsivo);
    }

    // ITERATIVO
    public static boolean haKAdiacenti(String[] input, int k){
        for(int i = 0; i<input.length; i++){
            String riga = input[i];
            int lettereUguali = 1;
            boolean trovato = false;
            for(int j = 0; j < riga.length() - 1 && !trovato; j++){
                if(riga.charAt(j) == riga.charAt(j + 1)){
                    lettereUguali++;
                }else{
                    lettereUguali = 1;
                }
                if(lettereUguali >= k) trovato = true;
            }
            if(!trovato) return false;
        }
        return true;
    }


    // RICORSIVO
    public static boolean ricHaKAdiacenti(String[] input, int k){
        return ricHaKAdiacenti(input, k, 0, 0, 1, false);
    }
    public static boolean ricHaKAdiacenti(String[] input, int k,int i,int j,int lettereUguali,boolean trovato ){
        //se ha finito di iterare le stringhe e c'è almeno una coppia in ogni stringa
        if(i == input.length) return true;
        String riga = input[i];
        //se ha finito di iterare la stringa a posizione i e non ha trovato coppie
        if(j == riga.length() - 1 && !trovato) return false;

        //quando il ciclo for con la j finisce
        if(j == riga.length() - 1 && trovato){
            lettereUguali = 1;
            trovato = false;
            j = 0;
            i++;
        }
        
        //[INIZIO FOR j]
        if(riga.charAt(j) == riga.charAt(j + 1)){
            lettereUguali++;
        }else{
            lettereUguali = 1;
        }
        if(lettereUguali >= k) trovato = true;
        j++;
        //[FINE FOR]

        return ricHaKAdiacenti(input, k, i, j, lettereUguali, trovato);
    }
}