package ClassiEPolimorfismo;
import ClassiEPolimorfismo.ClassePadre;



public class ClasseFiglia extends ClassePadre{
    String cognome;
    public ClasseFiglia(String nome, String cognome){
        super(nome);
        this.cognome = cognome;

    }   

    public void stampa(){
        System.out.println("Figlio");
    }

    public boolean equals(Object o){
        if(!(o instanceof ClasseFiglia)) return false;
        ClasseFiglia obj = (ClasseFiglia) o;

        if(obj.nome == this.nome && obj.cognome == this.cognome){
            return true;
        }

        return false;    
    }
}

/*
    <- = ritorna il valore accessibile al figlio
    -> = esegue il metodo 

    costruttore classefiglia (nome, cognome)
        <-cognome
        <-stampa()
        -> costruttore classepadre (nome)
            <-nome
            <-stampa()
*/