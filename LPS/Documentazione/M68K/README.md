# Introduzione
In m68k i registri sono formati in 3 tipi diversi:
* `long` 32 bit
* `word` 16 bit
* `byte` 8 bit

Possono essere visti come 2 gruppi da 16 bit, le due word formano una long
```
[00000000 00000000][00000000 00000000]
```


**ATTENZIONE** Gli operatori come addizione etc funzionano solo a 2 registri. Il secondo operando sarà quello destinazione dove viene salvato il dato.

Ha 18 registri utilizzabili, 8 data e 8 address
```assembly
d0,d1,d2,d3,d4,d5,d6,d7
a0,a1,a2,a3,a4,a5,a6,a7
```
gli altri sono speciali, come registro 0 dove sono contenuti solo zeri, il registro 1 e 31 etc...
**ATTENZIONE**, i registri a, sono di tipo address, non supportano le operazioni aritmetiche


# Struttura di un programma
Un programma base in M68K è strutturato:
```
ORG $2000

START:

END
```
Dove ORG è l'indirizzo di partenza, START è dove il programma inizierà l'esecuzione, e END è dove terminerà l'esecuzione.


# Utilizzo valori numerici ed esadecimali

I valori numerici in formato **decimale** sono rappresentati aggiungendo un `#` prima del numero, mentre il registro è scritto direttamente
```assembly
add #22,d6
```

per rappresentare valori in formato esadecimale si mette il prefisso `#$`, mentre per il formato binario `#%`
```assembly
move #$16, d0 
    ;copia il numero 22 in formato esadecimale nel registro d0

move #%10110, d0
    ;copia il numero 22 in formato binario nel registro d0
```

# Metodi di indirizzamento

***ATTENZIONE*** Nella documentazione utilizzeremo questi nomi per specificare quali tipi di operandi sono supportati dalle istruzioni. 
Si definisce *modo di indirizzamento* (*addressing mode*) una regola che, a partire da alcune informazioni, permette di indirizzare una parola.

In m68K ci sono vari modi per indirizzare i dati e prenderne i valori. 

## Immediato
`Im` Un numero, non è mai destinazione di un'istruzione
```assembly   
Im -> #<numero>
    move #10, d0
```

## Diretto di registro (dati)
`Dn` Registro dati, può essere usato in tutte le istruzioni che accettano registri, specialmente quelli aritmetici
```
Dn -> <d1/d2/d3/d4/d5/d6/d7>
    move d0, d1
```
## Diretto di registro (indirizzi)
`An` Registro indirizzi, **NON** può essere usato in tutte le istruzioni, per esempio **NON** può essere usato per la moltiplicazione e divisone.
```
An -> <a1/a2/a3/a4/a5/a6/a7>
    move a0, a1
```


## Indiretto registro 
`(An)` Si utilizza un registro indirizzi come puntatore. Legge la memoria all'indirizzo di An. Utilizzato nell'indicizzazione dinamica di un array.
```assembly
    move.l (a0), d0
```

## Implicito
In questa documentazione non trattiamo casi di indirizzamento implicito.

## Diretto Indirizzo
`Ea` Indirizzo di memoria, valido sia come label che come indirizzo di memoria.
```
Ea -> <label/$indirizzo>

    move.l $0x2000, d0
    move.l unaLabel, d0
```
# Comandi

**ATTENZIONE** In alcuni dei comandi possiamo scegliere quale parte dei registri utilizzare, se solo i primi 8 bit, i primi 16 bit o tutti e 32 bit, facciamo ciò aggiungendo uno di questi 3 dopo il comando:

# Estensioni

`.l` indica il formato long (32 bit)

`.w` indica il formato word (16 bit)

`.b` indica il formato byte (8 bit)

Esempio:
```assembly
move.l d7, d0
    ;copia tutti 32 bit di d7 in d0
move.w d7, d0
    ;copia i primi 16bit di d7 in d0
move.b d7, d0
    ;copia i primi 8bit di d7 in d0
```
### ***ATTENZIONE***

In questa documentazione metteremo fra [ ] e { } le estensioni disponibili. 

Se le parentesi [ ] non sono presenti, vuol dire che non abbiamo informazioni su quel comando, se abbiamo le parentesi vuote [ ] allora il comando non ha estensioni.

In { } è specificata l'estensione di default

## move [l w b] {w}

*move* -> Copia il contenuto del primo nel secondo. Se la destinazione è un registro indirizzi (a), di default usa formato long
```assembly
move <Im/Dn/An/(An)/Ea>, <Dn/An/(An)/Ea>

move #100, d0
    ;d0 = 100
move d7, d0
    ;d0 = d7
move.w  $2082,$208c     ; copia la word dell'address di memoria $2082 nell'address di memoria $208c
```
È inoltre possibile utilizzare operazioni di somma per indicare address, queste operazioni vengono fatte dal traduttore e non al momento dell'esecuzione

```assembly
move.b  $00002080+1,d1     ; copia il valore del byte dell'address di memoria $2081 in d1
```
## add - adda [l w b]
*addition* -> Effettua la somma di due valori e salva il risultato nel secondo. `adda` non cambia il CCR
```assembly
add <Im/Dn/An/(An)/Ea>, <Dn/An/(An)/Ea>
adda <Im/Dn/An/(An)/Ea> , <An>

add #100, d0
    ;d7 = d7 + 100
add d7, d0
    ;d0 = d0 + d7
add.b   #3,$0000208c    ; somma 3 al byte dell'address di memoria $208c
``` 

## sub [l w b]
*subtract* -> Effettua la sottrazione del secondo valore meno il primo e salva il risultato nel secondo 
```assembly
sub <Im/Dn/An/(An)/Ea>, <Dn/An/(An)/Ea>

sub d7, d0
    ;d0 = d0 - d7
sub #100, d0
    ;d0 = d0 - 100
sub.b   #3,$0000208c    ; sottrare 3 al byte dell'address di memoria $208c
```
**ATTENZIONE**, il secondo parametro deve sempre essere un registro, se vogliamo fare `100 - d0` dobbiamo caricare il `100` dentro un registro, poi fare la sottrazione
```assembly
move #100, d7
sub d7, d0
```

## divs - divu [ ]
* `divs` divisione **signed**
* `divu` divisione **unsigned**

Divide il secondo registro per il primo num/reg, salva il risultato nel secondo registro. Il primo operando viene letto con formato `word`, il secondo con formato `long`. 

**ATTENZIONE** salva il risultato della divisone nei primi 16 bit del secondo registro, il resto negli ultimi 16 bit. Se si vuole accedere al resto, usare il comando [swap](#swap)
```assembly
divs <Im/Dn/(An)/Ea>, <Dn>
divu <Im/Dn/(An)/Ea>, <Dn>

move #100, d0
    ;d0 = 100
divs #11, d0
    ;d0 = d0/11, cioé 100/11 
divs    $00002810,d0    ; divide d0 per il valore dell'address $2810
```
al termine dell'esecuzione del codice il registro `d0` sarà composto dai seguenti bit (in formato esadecimale):
>[`00010009`]

dove `0001` è il resto, mentre `0009` è il risultato

per ottenere il risultato serve copiare il registro in formato word, copiando solo i **primi 16 bit** di esso

per ottenere il resto serve eseguire `swap` sul registro, e poi ripetere quanto detto sopra:
```assembly
move.w d0, d1
    ;d1 = d0/11

swap d0
move.w d0, d2
    ;d2 = d0 % 11
```


## muls - mulu [ ]

* `muls` moltiplicazione **signed**
* `mulu` moltiplicazione **unsigned**

Moltiplica il secondo registro per il primo valore/registro e salva il risultato nel secondo registro. Il primo operando viene letto con formato `word`, il secondo con formato `long`. 
```assembly
muls <Im/Dn/(An)/Ea>, <Dn>
mulu <Im/Dn/(An)/Ea>, <Dn>

muls #10,d1
    ;d1 = d1 * 10

muls d1,d2
    ;d2 = d2 * d1
muls    $00002810,d0    ; moltiplica d0 per il valore dell'address $2810

```


## swap [ ]
*swap* -> Inverte le due word all'interno dello stesso registro, se guardiamo il registro come se fosse `[a,b]`, diventerà `[b,a]`, utile per la divisione
```assembly
swap <Dn>

    ;prima: d0 = 0x0000FFFF
swap d0
    ;dopo:  d0 = 0xFFFF0000
```

## clr [ ]
*clear* -> Azzera il contenuto del registro messo dopo il comando
```assembly
clr <Dn/(An)>

    ;prima: d0 = 0x01495840
clr d0
    ;dopo:  d0 = 0x00000000
```


## exg 
*exchange* -> Scambia il contenuto di due registri, **ATTENZIONE**, funziona solo con 32 bit
```assembly
exg <Dn/An>, <Dn/An>
----------------------------
    ;prima: d0 = 0x12940000
    ;prima: d1 = 0x00000010
exg d0,d1
    ;dopo:  d0 = 0x00000010
    ;dopo:  d1 = 0x12940000
```
## neg [l w b] {w}
*negate* -> Cambia il segno al valore del registro messo dopo l'operando
```assembly
neg <Dn/(An)/Ea>
----------------------------
    ;prima: d0 = 100 
neg d0
    ;dopo:  d0 = -100 
```
## ext [l w]
*extend* -> Estende un registro al formato specificato, usato per convertire un registro da byte a word (.w), o da word a long (.l). **ATTENZIONE**, il funzionamento del comando è prendere l'ultimo bit del tipo di formato che volete convertire e sostituirlo a tutti i restanti bit del nuovo formato, per esempio da byte a word, copia l'ultimo bit del byte e lo mette in tutti i restanti bit della word. 

```assembly
ext.w <Dn> ;converte la parte byte nella word
ext.l <Dn> ;converte la parte word nella long

----------------------------

    ;prima: d0 = 0xFF -> 1111 1111 (negativo, quindi copia l'1)
ext.w d0
    ;dopo: d0 = 0xFFFF -> 1111 1111 1111 1111

    ;prima: d1 = 0x1234 -> 0001 0010 0011 0100  (positivo, quindi copia lo 0)
ext.l d1
    ;dopo: d1 = 0x00001234

    ;prima d2 = 0xFF00 -> 1111 1111 0000 0000
ext.w d2
    ;dopo: d2 = 0x0000 -> 0000 0000 0000 0000
```

# Comandi branch e comparazione
Questi comandi vengono usati per mettere a confronto un registro ad un altro registro, o ad un numero immediato, per poi andare nella label se la condizione è vera.

In m68k la comparazione e branch vengono effettuati in comandi separati. Il primo ,`cmp`, mette a confronto due valori, poi con i vari comandi di branch, si decide a quale label andare. 

Ci sono due comandi di comparazione, quello rispetto due valori `cmp`, e quello rispetto allo zero `tst`. Questi comandi accettano l'utilizzo di `.l` `.w` `.b`

Entrambi i comandi `cmp` e `tst` salvano il risultato del confronto nel `CCR`, che poi verranno utilizzati nei comandi di branch scritti sotto.

## tst [l w b] {w}
*test* -> Comparazione con lo 0
```assembly
tst <An/Dn/(An)/Ea>
    ; comparazione con 0
```

## cmp [l w b] {w}
*compare* -> Se il secondo operando è un registro indirizzi (a) allora ha formato `long`.
```assembly
cmp <Im/Dn/(An)/Ea>, <Dn>
    ; comparazione di due valori 
```
## Comandi di branch
Una volta settati i valori da comparare, possiamo fare il confronto vero e proprio con i comandi di branch, questi andranno a controllare i dati del CCR e "salteranno" alla label data se la comparazione è vera. Tutti hanno sintassi:
```assembly
comando <label>
```


Comando             |  Logicamente        | Acronimo
:------------------:|:-------------------:|:------------------------
beq                 |      a == b         | *Branch equal*   
bne                 |      a != b         | *Branch not equal*
blt                 |      a < b          | *Branch less than*
ble                 |      a <= b         | *Branch less equal*
bgt                 |      a > b          | *Branch greater than*
bge                 |      a >= b         | *Branch greater equal*  

## Comandi di branch speciali (CCR)
In oltre ci sono altri comandi di branch "speciali", molti comandi in m68k, una volta eseguiti, comparano il registro destinazione con lo 0, in oltre tengono conto anche del segno del numero, se c'è stato un overflow, etc... Queste informazioni vengono salvate nel CCR, ed oltre ai comandi di branch precedenti, come i precedenti comandi di branch, hanno sintassi: 
```assembly
comando <label>
```
e sono:
* `bmi` se un valore è negativo
* `bpl` se un valore è positivo
* `bcs` se dopo aver fatto un operazione aritmetica su numeri unsigned, se c'è stato riporto nella cifra più a sinistra (più significativa), per esempio, prendendo un byte per numero, si fa `255 + 9`, il risultato sarà `8`, perchè `264` è più grande del numero massimo rappresentabile da un byte, che è 255, se ciò è accaduto, allora si dice che c'è stato **riporto**. vale anche se un numero va da positivo a negativo, es: 1-3 sarà 254. 
* `bcc` come bcs, ma se **NON** c'è stato riporto
* `bvc` come bcc, ma con numeri signed
* `bvs` come bcs, ma con numeri signed


## Branch incondizionato
Va direttamente alla label.
```assembly
bra <label>
jmp <label>
```
## Lettura degli elementi del CCR
Come visto prima nei branch, nel CCR troviamo varie informazioni durante l'esecuzione del codice, come per esempio se c'è stato un overflow, se un numero è maggiore, se è minore, etc... Possiamo leggere queste informazioni tramite questi comandi, se una condizione è vera, allora tutti i bit saranno settati a 1, sennò saranno settati a 0. hanno tutti sintassi:
```assembly
comando <destinazione>
```
* `scc` se non c'è stato riporto (carry clear)
* `scs` se c'è stato riporto (carry set)
* `seq` se è uguale (equal)
* `sne` se non è uguale (not equal)
* `sge` se è maggiore uguale (greater or equal) **SIGNED**
* `sgt` se è maggiore (greater) **SIGNED**
* `sle` se è minore uguale (less or equal) **SIGNED**
* `sls` se è più piccolo o uguale (lower) **UNSIGNED**
* `slt` se è minore (less) **SIGNED**
* `shi` se è più grande (higher) **UNSIGNED**
* `smi` se è negativo (minus)
* `spl` se è positivo (positive)
* `svc` se non c'è stato overflow (overflow clear)
* `svs` se c'è stato overflow (overflow set)
* `sf`  se è falso (false)
* `st`  se è vero (true)


# Operazioni sui bit e logici
Le operazioni sui bit ci permettono di effettuare modifiche ai singoli bit di un registro, come spostarli a sinistra/destra, invertirli, etc...

## not, or, and, xor
Effettua le operazioni not, or, and, xor, tra un registro e una maschera. La maschera è una sequenza di bit che specificano a quali posizioni si deve effettuare l'operazione logica. I vari operatori hanno funzioni equiparabili a:
* `NOT` Inverso di tutti i bit (1 diventa 0, 0 diventa 1), non usa una maschera
* `OR`  Setta ad 1 i bit alle posizioni della maschera, senza modificare gli altri
* `AND` Prelevare i bit alle posizioni della maschera, oppure controllare se un bit è segnato ad 1 nella posizione segnata nella maschera
* `XOR` Inverso dei bit alle posizioni della maschera.

il primo elemento del comando sarà la maschera, (tranne nel not), il secondo elemento sarà il registro dove effettuare l'operazione, e dove verrà salvata
```assembly
not <reg>

or <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>
and <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>
eor <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>
```
esempi:
```assembly
    ; per semplicità di scrittura, sono rappresentati solo 8 dei 32 bit
    ; d0 = 01100111
    ; in realtà sarebbe
    ; d0 = 00000000000000000000000001100111

    ; d0 = 01100111 (maschera)
    ; d1 = 11001100 
    ; d2 = 11001100 
    ; d3 = 11001100 
    ; d4 = 11001100 

not d1
    ; d1 = 00110011

or d0, d2
    ; d2 = 11101111

and d0, d3
    ; d3 = 01000100

eor d0, d4
    ; d4 = 10101011
```

## lsl 
*logical shift left* -> Sposta tutti i bit di di un registro di tot posizioni a sinistra, le cifre aggiunte saranno uguali a 0.

Uguale al comando `<<` in C




```assembly
lsl <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>

    ;d0 = 01011101 (in binario)
    ;d2 = 3 (in decimale)
lsl d2, d0
    ;d0 = 11101000
```

Lo `shift sinistro` logico ha lo scopo aritmetico di effettuare `(N * 2^k) mod 2^l` dove N = numero dove effettuare lo shift, k è il numero di bit da spostare a sinistra, e l è il numero di bit nel formato usato.


## lsr 
*logical shift right* -> Sposta tutti i bit di di un registro di tot posizioni a destra, le cifre aggiunte saranno uguali a 0. Ignora il segno del numero, quindi un numero negativo verrà trattato ugualmente ad uno positivo. 
 
Uguale al comando `>>` in C

```assembly
lsr <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>

    ;d0 = 11011101 (in binario)
    ;d2 = 3 (in decimale)
lsr d2, d0
    ;d0 = 00011011
```

Lo `shift destro` logico è uguale a calcolare `N/2^k` dove N è il numero dove effettuare lo shift e `k` è la quantità dello shift, oppure semplicemente, ogni volta che spostiamo di una posizione, il numero viene diviso per 2.


## asr / asl 
*arithmetical shift right/left* -> Sposta tutti i bit di di un registro di tot posizioni a destra/sinistra. Tiene conto del segno del numero. Se verso destra, i numeri aggiunti saranno uguali al numero più a sinistra, se verso sinistra, il segno verrà ignorato, ma se c'è un cambio di segno, verrà segnato sul CCR

```assembly
asr <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>

asl <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>

    ;d0 = 10010111 (in binario)
    ;d2 = 2 (in decimale)
    
asr d2, d0

    ;d0 = 11100101
```

Aritmeticamente, lo  `shift sinistro` aritmetico è uguale a calcolare `N*2^k` dove N è il numero dove effettuare lo shift e `k` è la quantità dello shift, oppure semplicemente, ogni volta che spostiamo di una posizione, il numero viene moltiplicato per 2. 

Mentre per lo `shift destro` aritmetico è uguale a calcolare `N/2^k` dove N è il numero dove effettuare lo shift e `k` è la quantità dello shift, oppure semplicemente, ogni volta che spostiamo di una posizione, il numero viene diviso per 2.


Bisogna fare attenzione nel caso che il numero sia negativo, o se il numero è grande, visto che potrebbe andare in overflow.

## rol / ror
*rotate left / rotate right* -> Prendendo per esempio la rotazione a destra, il comando sposterà a destra di un tot numero di bit, e li posizionerà a sinistra (al posto dei bit da aggiungere). Lo stesso vale per rol, ma verso sinistra
```assembly
rol <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>
ror <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>

    ;d0 = 01000011
rol #2, d0
    ;d0 = 11010000
```

# Operazioni sui singoli bit
Servono per effettuare operazioni sui singoli bit. Tutti i comandi seguenti, prima di modificare un bit, settano il CCR `equal` al valore del bit da cambiare, e poi modificano il bit. Se il secondo operando è un registro viene letto tutto il registro, se non lo è, vengono letti solo i primi 8 bit.

Il primo operando è il bit da leggere, il secondo sarà dove effettuare l'operazione e salvarla. 
## btst
*Bit test* -> Testa il bit a posizione specificata del registro, setta la condizione del CCR `equal` al valore del bit a quella posizione, poi possiamo usare il comando `beq` per i branch. Non modifica la destinazione

```assembly
btst <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>
```
## bclr 
*Bit clear* -> Setta a 0 il bit a posizione specificata del registro.
```assembly
bclr <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>
```

## bchg
*Bit change* -> Inverte il bit a posizione specificata del registro.
```assembly
bchg <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>
```

## bset
*Bit set* -> Setta ad 1 il bit a posizione specificata del registro.
```assembly
bset <Im/Dn/(An)/Ea>, <Dn/(An)/Ea>
```

# La memoria in M68K
La memoria in M68K può essere vista come una lista di byte, dove ogni byte nella lista ha una posizione chiamata "address". La gestione dei dati salvati all'interno della memoria è completamente lasciata allo sviluppatore che scrive il programma, quindi dovranno essere tenuti in conto la lunghezza in byte dei vari formati di dati che andremo a salvare. 


**ATTENZIONE**, quando andiamo a leggere e scrivere negli address, in base alla grandezza del formato che vogliamo usare, l'indirizzo scelto dovrà essere un multiplo del formato scelto. Per esempio, non possiamo salvare una word (4 byte) all'indirizzo 2021, perchè non è modulo di 4, ma possiamo salvarlo in 2024

## Formati di dato e allineamento
Ogni formato di dato ha la propria lunghezza, dovremmo tenerne conto quando salviamo e leggiamo dalla memoria. I dati letti/scritti verranno letti dall'indirizzo specificato, fino all'`indirizzo + lunghezza`.

Alcuni formati standard, diversi dal formato **byte**, definiscono una restrizione agli indirizzi validi per le 
parole standard di tale formato, chiamata `vincolo di allineamento`.

* `byte` : ha lunghezza 8 bit (1 parola)
* `word` : ha lunghezza 16 bit (2 parole), fattore di allineamento 2
* `long` : ha lunghezza 32 bit (4 parole), fattore di allineamento 2

Ad esempio, per salvare una **word** all'address 0x2000, il dato verrà salvato agli indirizzi 0x2000 e 0x2001 e, dunque, la successiva **word** o **long**, non potrà essere salvata a partire dall'address 0x2001 ma bensì dovrà essere salvata a partire dall'address 0x2002.

Importante è sapere il modo in cui la memoria viene letta/scritta. Esistono due tipologie chiamate `little endian` e `big endian`. 

In m68k, per la lettura/scrittura in memoria viene usato il [Big endian](#Big-endian).

### Little endian
Little endian è quando i byte sono salvati da destra verso sinistra, partendo dal più significativo. Per esempio il numero `0x1234` viene salvato in memoria come `0x34 0x12`.

### Big endian
Big endian è quando i byte sono salvati da sinistra verso destra, partendo dal più significativo. Per esempio il numero `0x1234` viene salvato in memoria come `0x12 0x34`.

## Utilizzo della memoria
Per utilizzare la memoria all'interno del programma, ci basterà specificare il numero dell'indirizzo della memoria come operando, scrivendolo in maniera `$numero_indirizzo`, esempio `$2000`. Alternativamente, possiamo creare una `variabile` alias all'inizio del programma che indica a quale indirizzo fa riferimento l' alias. Facciamo ciò tramite il comando [equ](#equ)

```assembly
unaVariabile equ $3000

move.w #1234, $00002000
    ; la word 1234 viene salvata in memoria all'indirizzo 0x2000
    ; quindi viene salvato 12 all'indirizzo 0x2000 e 34 all'indirizzo 0x2001
move.w #1234, unaVariabile
```
Naturalmente la lettura e scrittura dipendono dal formato di dato utilizzato.

## equ
*equals* -> La direttiva `equ` è usata per assegnare ad un indirizzo di memoria una variabile

Deve essere messo prima di `ORG $2000` e senza indentazione. Verrà convertito dall'assembler e sostituito con l'indirizzo di memoria.

```assembly
<nome_variabile>  equ  <adr> 

unaVariabile equ 5020
```

# Indirizzi di Memoria e Label
Gli indirizzi possono essere scritti in forme più comode utilizzando `label`. 
Ogni label è legata ad un indirizzo di memoria, ovvero rappresenta tale indirizzo. In fase di traduzione l'assembler trasforma ogni label nell'indirizzo ad essa legato. Ha quindi senso operazioni come
```assembly
; se pippo è una label, l'indirizzo successivo sarà l'indirizzo pippo+1, quello dopo ancora pippo+2, e così via..-

        move.b  d4,d6
pippo:  cmp #256,d0 
        clr d6              ;pippo+1
        move.w  d0,d2       ;pippo+2
```
Quando il programma viene assemblato, ogni istruzione è convertita in un numero a 32 bit (4 byte). Quando il programma viene eseguito, questi numeri sono caricati nella memoria ed eseguiti. Le label sono solo un "alias" all'indirizzo di memoria dove è salvata l'istruzione. Quando per esempio facciamo un branch ad una label, quello che in realtà sta succedendo, è che il programma continua l'esecuzione all'indirizzo di memoria dove è salvata la label.

# Allocazione statica della memoria
L’allocazione della memoria statica viene fatta mediante le `sezioni`; ogni sezione ha un `indirizzo di inizio sezione`.

Si può allocare la memoria in maniera "statica" (cioè non si può espandere).

Una direttiva di definizione dati:
* indica quanti byte devono essere allocati e se necessario, i valori da memorizzare.
* non indica l’indirizzo di memoria dei byte da allocare: tale indirizzo è determinato automaticamente dall'assembler.

## org
Per allocare la memoria viene utilizzata la direttiva 𝒐𝒓𝒈 seguita dall’indirizzo di inizio 
sezione. Tale direttiva imposta infatti l’indirizzo di memoria iniziale per i successivi che seguiranno.
```assembly
org     $1100
move.l  #$12,d0
tst d1
```
Indirizzo           |  Comando        
:------------------:|:-------------------
1100    |    org     $1100
1100    |   move.l  #$12,d0
1104    |   tst d1

## dc [l w b]
**define constant** -> La direttiva `dc` è usata per definire costanti.

Se non è specificata una estensione di lunghezza (b,w,l), per le stringhe è utilizzato il formato *byte*, mentre per i valori numerici il formato *word*.
``` assembly
<label>: dc <valore>

x: dc.b 10
v:  dc.l    1,3,4
    ; alloca 3 long, la prima con valore 1, la seconda con valore 3 e la terza con valore 4
    ; "v" è l'indirizzo della prima long
-----------------------------------------
    org $2800
v:  dc.l    0       ; v ha indirizzo 2800
w:  dc.l    220200  ; w ha indirizzo 2804 
    ; ovvero 2800 (org) + 4 byte (long v)
```
Possiamo usare `dc` per definire array e stringhe (di lunghezza fissa).


Per esempio per definire un array di 5 elementi tutti a valore 1:
```assembly
    ; long unArray[ 5 ] = { 1, 1, 1, 1, 1 };
    org $4000
unArray: dc.l 1,1,1,1,1
```
Potremmo poi accedere ai valori dell'array usando il nome della label. Se vogliamo iterare gli elementi dell'array, dovremmo leggere l'indirizzo dell'array, e poi incrementarlo in base alla grandezza degli elementi. Oppure se dobbiamo leggere un elemento specifico, possiamo usare `label+posizione`
```assembly
; STATICO
    ; copia elemento a posizione 3
move.l unArray+2, d0

; DINAMICO
    ; prende l'indirizzo di "unArray"
move.l #unArray, a0
    ; incrementa l'indirizzo di 4 byte
    ; perchè il tipo degli elementi di "unArray" è long
add.l #4, a0
    ; copia elemento a posizione 1
move.l (a0), d0

```
C'è un altro tipo di rappresentazione per gli array, che per una serie di problemi è consigliabile ***non*** *utilizzare*.
```assembly
    move.w   el3,d0
    add.w    el0,d0
; fine codice

; int x[ 4 ] = { 7, 0, 3, 8 };
    org $4000
el0: dc.w     7
el1: dc.w     0
el2: dc.w     3
el3: dc.w     8
```


