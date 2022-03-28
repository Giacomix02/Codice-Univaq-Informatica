/*
5 diversi tipi di behavior:
    > well-defined
    > locale-specific
    > unspecified
    > implementation-defined
    > undefined

*/

// WELL-DEFINED
/*
    >> E' un comportamento del tutto gestito da C standard
*/
// esempi
int x, y = 42;
x = y;
return x;

// LOCALE-SPECIFIC
/*
    >> I locale-specific sono tutti legati all'esecuzione di funzioni delle librere standard di C

    NON VENGONO TRATTATE NEL CORSO
*/

// UNSPECIFIED
/*
    >> Uso di un valore non specificato o di un altro comportamento per il quale il C standard presenta due o più possibità
            >> non sappiamo quale implementazione viene scelta

    >> Caso più comune : Ordine di valutazione delle sottoespressioni di una stessa espressione
        >> L'ordine di valutazione delle espressioni non è specificato
        >> Le implementazioni possono valutare l'espressione in qualsiasi ordine
            >> E1 + E2, in cui sia E1 ed E2 sono a loro volta altre espressioni
                >> un'implementazione può scegliere se valutare prima E1 o prima E2

    >> Definiamo due tipi di c : 
        >> portable
            >> unspecified behavior che non pregiudicano la portabilità del codice 

        >> non-portable
            >> unspecified behavior che rendono un programma non portabile
    
*/
// esempi  ==> entrambi i modi restituiscono lo stesso risultato
x = y * 4 + z % 3;      //non sappiamo cosa esegue per primo
// riscriviamolo in unstructured (1° modo)
int t1, t2;
t1 = y * 4;
t2 = z % 3;
x = t1 + t2;

// riscriviamolo in unstructured (2° modo)
int t1,t2;
t2 = z % 3;
t1 = y * 4;
x = t1 + t2;



// IMPLEMENTATION-DEFINED
/*
    >> La documentazione dell'implementazione deve dichiarare quale delle possibilità permesse da C standard viene realizzata
    >> Distinguiamo fra due tipi di behavior :
        >> portable implementation-defined behavior
            >> non pregiudicano la portabilità
        
        >> non-portable implementation-defined behavior
            >> rendono non portabile un programma
*/


//UNDEFINED 
/*
    >> Comportamento che C standard non definisce nel modo più assoluto




*/




// OPERATORI CON SIDE-EFFECT
/*
    >> Oltre a calcolare un valore modificano uno dei loro operandi 
        >> Producono un side effect
            >> Esempi :
                >> x++ , ++x
        
        >> x++
            >> prima restituisce il valore della variabile e poi aumenta di 1
        
        >> ++x
            >> prima aumenta di 1 e poi restituisce il valore della variabile
*/
// Esempi:

    y++ + a;
    // Si traduce in :
    a= y+a;
    y = y+1;

    ++y + a;
    // Si traduce in : 
    y=y+1;
    a= y+a;

    // Esempio di portable unsecified behavior
    x = y++ * (z + 5);
    
    // Esempio di non-portable unsecified behavior
    z = (++x - b) * (x -=3);
    /*
        >>Perchè?
            >> La x è presente in entrambe le parentesi
                >> Il risultato può cambiare a differenza dell'ordine di esecuzione
                    delle parantesi 


    */

