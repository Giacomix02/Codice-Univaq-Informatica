# Introduzione
In m68k i registri sono formati in 3 tipi diversi:
* `long` 32 bit
* `word` 16 bit
* `byte` 8 bit

Possono essere visti come 2 gruppi da 16 bit, le due word formano una long
```
[0000000000000000][0000000000000000]
```

**ATTENZIONE** A differenza di MIPS, gli operatori come addizione etc funzionano solo a 2 registri, con il secondo operando, quello che riceve il dato.

Ha 18 registri utilizzabili, 8 data e 8 address
```assembly
d0,d1,d2,d3,d4,d5,d6,d7
a0,a1,a2,a3,a4,a5,a6,a7
```
gli altri sono speciali, come registro 0 dove sono contenuti solo zeri, il registro 1 e 31 etc...
**ATTENZIONE**, i registri a, sono di tipo address, non supportano le operazioni aritmetiche

I valori numerici in formato **decimale** sono rappresentati aggiungendo un `#` prima del numero, mentre il registro è scritto direttamente
```assembly
add #22,d6
```
per rappresentare valori in formato esadecimale si mette il prefisso `#$`, mentre per il formato binario `#%`
```assembly
move #$00000016, d0 
; copia il numero 22 in formato esadecimale nel registro d0

move #%10110, d0
; copia il numero 22 in formato binario nel registro d0
```

# Comandi

**ATTENZIONE** In alcuni dei comandi possiamo scegliere quale parte dei registri utilizzare, se solo i primi 8 bit, i primi 16 bit o tutti e 32 bit, facciamo ciò aggiungendo uno di questi 3 dopo il comando:

`.l` indica il formato long

`.w` indica il formato word

`.b` indica il formato byte

Esempio:
```assembly
move.l d7, d0
; copia tutti 32 bit di d7 in d0
move.w d7, d0
; copia i primi 16bit di d7 in d0
move.b d7, d0
; copia i primi 8bit di d7 in d0
```
## move 

Copia il contenuto del primo, nel secondo
```assembly
move <numero/registro>, <destinazione>

move #100, d0
; d0 = 100
move d7, d0
; d0 = d7
```

## add
Effettua la somma di due valori e salva il risultato nel secondo
```assembly
add <numero/registro>, <destinazione>

add #100, d0
; d7 = d7 + 100
add d7, d0
; d0 = d0 + d7
```

## sub
Effettua la sottrazione del secondo valore meno il primo e salva il risultato nel secondo 
```assembly
sub <numero/registro>, <destinazione>

sub d7, d0
; d0 = d0 - d7
sub #100, d0
; d0 = d0 - 100
```
**ATTENZIONE**, il secondo parametro deve sempre essere un registro, se vogliamo fare `100 - d0` dobbiamo caricare il `100` dentro un registro, poi fare la sottrazione
```assembly
move #100, d7
sub d7, d0
```

## divs
Divide il secondo registro per il primo numero/registro, salva il risultato nel secondo registro.

**ATTENZIONE** salva il risultato della divisone nei primi 16 bit del secondo registro, il resto negli ultimi 16 bit. Se si vuole accedere al resto, usare il comando [swap](#swap)
```assembly
divs <numero/registro>, <destinazione>

move #100, d0
; d0 = 100
divs #11, d0
; d0 = d0/11, cioé 100/11 
```
al termine dell'esecuzione del codice il registro `d0` sarà composto dai seguenti bit (in formato esadecimale):
>[`00010009`]

dove `0001` è il resto, mentre `0009` è il risultato

per ottenere il risultato serve copiare il registro in formato word, copiando solo i **primi 16 bit** di esso

per ottenere il resto serve eseguire `swap` sul registro, e poi ripetere quanto detto sopra:
```assembly
move.w d0, d1
; d1 = d0/11

swap d0
move.w d0, d2
; d2 = d0 % 11
```


## muls
Moltiplica il secondo registro per il primo valore/registro e salva il risultato nel secondo registro
```assembly
muls <numero/registro>, <destinazione>

muls #10,d1
; d1 = d1 * 10

muls d1,d2
; d2 = d2 * d1

```

## swap
Inverte le due word all'interno dello stesso registro, se guardiamo il registro come se fosse `[a,b]`, diventerà `[b,a]`, utile per la divisione
```assembly
swap <registro>

;prima: d0 = 0x0000FFFF
swap d0
;dopo:  d0 = 0xFFFF0000
```

## clr
Azzera il contenuto del registro messo dopo il comando
```assembly
clr <registro>

;prima: d0 = 0x01495840
clr d0
;dopo:  d0 = 0x00000000
```


## exg 
Scambia il contenuto di due registri, **ATTENZIONE**, funziona solo con 32 bit
```assembly
;prima: d0 = 0x12940000
;prima: d1 = 0x00000010
exg d0,d1
;dopo:  d0 = 0x00000010
;dopo:  d1 = 0x12940000
```
## neg
Cambia il segno al valore del registro messo dopo l'operando
```assembly
neg <registro>

;prima: d0 = 100 
neg d0
;dopo:  d0 = -100 
```

# Comandi branch e comparazione
Questi comandi vengono usati per mettere a confronto un registro ad un altro registro, o ad un numero immediato, per poi andare nella label se la condizione è vera.

In m68k la comparazione e branch vengono effettuati in comandi separati. Il primo ,`cmp`, mette a confronto due valori, poi con i vari comandi di branch, si decide a quale label andare. 

Ci sono due comandi di comparazione, quello rispetto due valori `cmp`, e quello rispetto allo zero `tst`. Questi comandi accettano l'utilizzo di `.l` `.w` `.b`

```assembly
tst <registro>
; comparazione con 0

cmp <registro/numero>, <registro>
; comparazione di due valori 
```
## Comandi di branch
Una volta settati i valori da comparare, possiamo fare il confronto vero e proprio con i comandi di branch, questi andranno a controllare i dati del CCR e "salteranno" alla label data se la comparazione è vera. Tutti hanno sintassi:
```assembly
comando <label>
```

* `beq` a == b
* `bne` a != b
* `blt` a < b
* `ble` a <= b
* `bgt` a > b
* `bge` a >= b

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
Se si vuole andare alla label senza confronti, utile nei loop.
```assembly
b <label>
```
## Lettura degli elementi del CCR
Come visto prima nei branch, nel CCR troviamo varie informazioni durante l'esecuzione del codice, come per esempio se c'è stato un overflow, se un numero è maggiore, se è minore, etc... Possiamo leggere queste informazioni tramite questi comandi, se una condizione è vera, allora tutti i bit saranno settati a 1, sennò saranno settati a 0. hanno tutti sintassi:
```assembly
comando <destinazione>
```
* `scc` se non c'è stato riporto (carry clear)
* `scs` se c'è stato riporto (carry set)
* `seq` se è uguale
* `sge` se è maggiore uguale (greater or equal) **SIGNED**
* `sgt` se è maggiore (greater) **SIGNED**
* `sle` se è minore uguale (less or equal) **SIGNED**
* `sls` se è più piccolo o uguale (lower) **UNSIGNED**
* `slt` se è minore (less) **SIGNED**
* `shi` se è più grande (higher) **UNSIGNED**
* `smi` se è negativo
* `sne` se non è uguale
* `spl` se è positivo
* `svc` se non c'è stato overflow (overflow clear)
* `svs` se c'è stato overflow (overflow set)
* `sf`  se è falso
* `st`  se è vero
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
not <registro>

or <registro/numero>, <destinazione>
and <registro/numero>, <destinazione>
eor <registro/numero>, <destinazione>
```
esempi:
```assembly
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
-----------------------------------
## lsl 
logical shift left, sposta tutti i bit di di un registro di tot posizioni a sinistra, le cifre aggiunte saranno uguali a 0.
Uguale al comando << in C
```assembly
lsl <registro/numero>, <destinazione>

; d0 = 01011101 (in binario)
; d2 = 3 (in decimale)
lsl d2, d0
; d0 = 11101000
```
## lsr 
logical shift right, sposta tutti i bit di di un registro di tot posizioni a destra, le cifre aggiunte saranno uguali a 0. Ignora il segno del numero, quindi un numero negativo verrà trattato ugualmente ad uno positivo. 
Uguale al comando >> in C (undefined behaviour)
```assembly
lsr <registro/numero>, <destinazione>

; d0 = 11011101 (in binario)
; d2 = 3 (in decimale)
lsr d2, d0
; d0 = 00011011
```

## asr / asl 
arithmetical shift right/left, sposta tutti i bit di di un registro di tot posizioni a destra/sinistra. Tiene conto del segno del numero. Se verso destra, i numeri aggiunti saranno uguali al numero più a sinistra, se verso sinistra, il segno verrà ignorato, ma se c'è un cambio di segno, verrà segnato sul CCR

```assembly
asr <registro/numero>, <destinazione>
asl <registro/numero>, <destinazione>
; d0 = 10010111 (in binario)
; d2 = 2 (in decimale)
asr d2, d0
; d0 = 11100101
```
## rol / ror
rotate left / rotate right. Prendendo per esempio la rotazione a destra, il comando sposterà a destra di un tot numero di bit, e li posizionerà a sinistra (al posto dei bit da aggiungere). Lo stesso vale per rol, ma verso sinistra
```assembly
rol <registro/numero>, <destinazione>
ror <registro/numero>, <destinazione>

; d0 = 01000011
rol #2, d0
; d0 = 11010000
```