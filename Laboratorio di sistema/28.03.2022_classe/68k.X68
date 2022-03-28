*-----------------------------------------------------------
* Title      :
* Written by :
* Date       :
* Description:
*-----------------------------------------------------------
    ORG    $2000
START:                  ; first instruction of program

* Put program code here
    move.l #325,d0
    neg d0
    move.l #826,d2
    
    *ADD <ea>,Dn sintassi
    * move [sorgente],[destinazione]    move SINTASSI
    
    move.l d0,d5
    add #22,d5         ; t1 = s1 + 22
    move.l d5,d3
    
    move.l d2,d5
    sub #329,d5
    move.l d3,d5
    
    move.l #2048,d5
    sub d5,d3
    move.l d5,d1
    
    add d1,d3
    
    move.l d5,d0
    add #345,d0
    move.l d0,d3
    
    move.l d0,d5
    add #9,d5
    move.l d5,d3
    
    move.l d1,d5
    sub d5,d3
    move.l d5,d2
    
    move.l d3,d5
    sub d5,d2
    move.l d5,d4
    
    sub d0,d4
    
    
    
    


    SIMHALT             ; halt simulator

* Put variables and constants here
    
    END    START        ; last line of source


*~Font name~Courier New~
*~Font size~10~
*~Tab type~1~
*~Tab size~4~
