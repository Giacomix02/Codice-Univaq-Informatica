package ClassiEPolimorfismo;

public class Main {
    public static void main(String[] args){



        int numero = 2;
        int numero2 = 2;
        //numero e numero2 sono uguali
        if(numero == numero2){
            System.out.print("Sono uguali");
        }else{
            System.out.print("Sono diversi");
        }
        /* */






        ClasseFiglia a = new ClasseFiglia("Mario","Rossi");
        ClasseFiglia b = new ClasseFiglia("Mario","Rossi");

        a.stampa();
        if(a.equals(b)){
            System.out.print("Sono uguali");
        }else{
            System.out.print("Sono diversi");
        }
    }
}

/*
    STACK
    
    numero = 2
    numero2 = 2
    a = l1
    b = l2


    HEAP 

    l1 = ...
    l2 = ...
*/