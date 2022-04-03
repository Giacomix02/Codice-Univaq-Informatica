# link rapidi 
[Comandi](#comandi)

[move](#move)

[Addizione](#add)

[Sottrazione](#sub)

[Divisone](#divs)

[Moltiplicazione](#muls)

[swap](#swap)

[clr](#clr)

[exg](#exg)

[neg](#neg)



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

**ATTENZIONE** In alcuni dei comandi possiamo scegliere quale parte dei registri utilizzare, se solo i primi 8 bit, i primi 16 bit o tutti e 32 bit, facciamo ciò aggiungendo uno di questi 3 suffissi dopo il comando:

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
; d0 = d0 + 100
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

**ATTENZIONE** salva il risultato della divisione nei primi 16 bit del secondo registro, il resto negli ultimi 16 bit. Se si vuole accedere al resto, usare il comando [swap](#swap)
```assembly
divs <numero/registro>, <destinazione>

move #100, d0
; d0 = 100
divs #11, d0
; d0 = d0/11, cioé 100/11 
```
al termine dell'esecuzione del codice il registro `d0` sarà composto dai seguenti bit:
>[000000000000000`1`000000000000`1001`]

dove 000000000000000`1` è il resto, mentre 000000000000`1001` è il risultato

(infatti 1001 in binario è 9, quindi 100/11, mentre 1 è il resto, 100-11*9)

per ottenere il risultato serve copiare il registro in formato word, copiando solo i **primi 16 bit** di esso

per ottenere il resto serve eseguire [swap](#swap) sul registro, e poi ripetere quanto detto sopra:
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

