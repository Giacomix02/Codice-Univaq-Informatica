# Tipi
Nome           |  Dimensione       
---------------|:--------------:|
**long long**  | 64bit (8 byte)
**double**     | 64bit (8 byte)
**float**      | 32bit (4 byte)
**int**        | 32bit (4 byte)
**short**      | 16bit (2 byte)
**char**       | 8bit (1 byte)

# Comandi
## include
Include delle librerie esterne ad esempio <stdio.h>
## define
È una macro che permette di definire un "alias" ad un pezzo di codice. Quando il programma viene compilato, il compilatore rimpiazza ogni occorrenza dell'alias con il valore definito
```c
#define <nome> <codice>

#define PI 3.14
```
## printf

Tipo dato      |  Codice       
---------------|:--------------:|
double,int     | **%d**
float          | **%f**
exadecimal     | **%x**

```c
int n = 10;
printf("numero = %d", n);
// stampa a schermo "numero = 10" 
```
## scanf

**ATTENZIONE** Lo `scanf` richiede l'inserimento del puntatore `&` prima della variabile in cui si vuole salvare il valore inserito

```c
int s;
scanf("%d", &s);
// inserisce un valore intero in s
```

## if
```c
if (condizione) {
    // codice se vero
} else{
    // codice se falso
}

//unstructured

if(!condizione) goto if_false;
    //codice se vero
    goto if_false;
if_false:
    //codice se falso
```

## Operatore ternario
```c
condizione ? seVero : seFalso;

//esempio
int unaVariabile = numero > 0 ? 1 : 0;
```

## >> e <<

Operano direttamente sui bit delle variabili

`>>` sposta i bit a destra di un numero di bit specificato
`<<` sposta i bit a sinistra di un numero di bit specificato

```c
int a = 2;  // a = 0000 0010
a >> 1; // a = 0000 0001

--------------------------------

int a = 4;  // a = 0000 0100
a << 1; // a = 0000 1000
```

## Cicli

## for

```c
for (variabili; condizioni; incrementi) {
    // codice
}


//unstructured
int i;
for_start:
    if(i < 5) goto for_end;
        //codice del for
    i++;
    goto for_start
for_end:

//esempio
for(int i = 0, j = 0; i < 5; i++){
    
}

```


## while
Esegue il ciclo finchè la condizione è vera
```c
while(condizione){
   //codice 
}

//unstructured
while_true: 
    if(!condizione) goto while_end
    //codice
    goto while_true
while_end:
```
## do-while
Esegue il ciclo finchè la condizione è vera, ma esegue almeno una volta.
```c
do{
   //codice 
} while(condizione);

//unstructured
while_true: 
    //codice
    if(condizione) goto while_true;
```
# struct
Usato per raggruppare più valori in una singola variabile, "simile" agli oggetti in Java, ma senza metodi. Naturalmente I tipi possono essere diversi.
***Dichiarazione***
```c
struct nome{
    //parametri
}
typedef struct {
    //parametri
} nome


//esempio
struct Point{
    int x;
    int y;
}
typedef struct {
    int start;
    int end; 
} Line;
```
***Utilizzo***, I parametri sono passati in ordine
```c
struct Point punto = {
    1, //x
    2 //y
};
Line linea = { 
    0, //start
    1   //end
};
```

## Array 

### Moniodimensionali
```c
int name[length];
//esempio
int array[4] = {2,1,3,4}; //valori iniziali
```
```c
/*
 * array1 = { 10, 12, -4, 0, 0, 0, 9 } di dimensione 7
 * [ 6 ] = 9  mette 9 nella posizione di indice 6
 * dell'array
*/
int array1[ ] = { 10, 12, -4, [ 6 ] = 9 };
```
```c
// 	array2 = { 2.5, 5.0, 1.2, 0.0, 0.0 } di dimensione 5
float array2[ 5 ] = { 2.5f, 5.0f, 1.2f }
// array3 = { 0.7, 0.0, 0.0, 3.4, -1.1, 0.0, 0.0, 0.0 } di dimensione 8
float array3[ 8 ] = { 0.7f, [ 3 ] = 3.4f, -1.1f };
```
### Bidimensionali

```c
array2 = array3  //ERRORE: gli array non possono essere assegnati
int array4[ ][ 6 ] = { { 100 }, { 10, 20, 30, 40, 50, 60 }, { 1, 2, 3 } };  //definizione di array bidimensionale (multidimensionale)
```
***ATTENZIONE*** In un array bidimensionale, o in generale multidimensionale, la prima dimensione può essere omessa, mentre tutte le altre vanno per forza specificate
```c
int array5[ 4 ][ ] = { { 100, 101, 102 }, { 10, 20, 30 }};      //ERRORE: seconda dimensione non specificata
int array6[  ][ 4 ] = { { 100, 101, 102 }, { 10, 20, 30 }};     //OK
```
Per utilizzare dinamicamente un array
```c
int array7[2][4] = {{1, 2, 3, 4},{2,3,4,5}};
    
    for(int i=0;i<2;i++){
        printf("\n");
        for(int j=0;j<4;j++){
            printf("%d ",array7[i][j]);
        }
    }
```


# Puntatori
I puntatori hanno lo scopo di permettere il passaggio per "reference" di un informazione. Quando per esempio chiamiamo un metodo, possiamo passare come parametro una variabile tramite reference, poi la funzione modificherà ciò che gli è stato passato.

I puntatori vengono usati con 2 caratteri speciali

* `&` per prendere il puntatore di una variabile
* `*` per accedere ad un puntatore

## Dichiarazione puntatore
```c
int nome;
int *puntatore;
puntatore = &nome;

//esempio
int x = 10;
int *p = &x;
//in p è salvato il puntatore di x
```

## Utilizzo puntatore
Possiamo risalire a cosa punta il puntatore mettendo `*` prima del puntatore, in questo modo, scrivere/leggere il puntatore ha lo stesso effetto di scrivere/leggere cosa punta il puntatore.

```c
int x = 10;
int *p = &x;

// p contiene l'indirizzo di x

*p = 20;
//ora x è uguale a 20
```

## Puntatori negli array

