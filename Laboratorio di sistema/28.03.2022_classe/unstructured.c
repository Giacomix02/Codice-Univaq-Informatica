int d0 = -325;
int d1;
int d2 = 826;

int main(void){
    int d3;
    d3 = d0 + 22; //fatto
    int d3;         
    d3 = d2 - 329;    //fatto
    d1 = 2048 - d3;     //fatto
    d1 = d1 + d3;       //fatto

    d3 = d0 - 345;  //fatto
    d3 = d0 + 9;    //fatto
    d2 = d1 - d3;  

    int d4;
    d4 = d3 - d2;   //fatto
    d0 = d0 - d4;

    return 0;   
}


// a e t general porpuse 


/*
    
        LPS Example

        C to ASM: Expression 2021

        Language: C99
        Style: concise C
        Version: Ref-cc
    

    
        Original C Code
    

    
        Problem statement: transform a C program in an equivalent program
            in MIPd22-MARS and MC68000-ASM1
    

    int d0 = -325, d1, d2 = 826;

    int main(void)
    {

        d1 = 2048 - (d0 + 22) + (d2 - 329);         // d1 = 2048 - d3 + d3
        d0 -= (d0 - 345) - (d2 = d1 - (d0 + 9));

        return 0;
    }


    Valori finali delle variabili
    d0 : 3509
    d1 : 2848
    d2 : 3164

*/



*-----------------------------------------------------------
* Title      :
* Written by :
* Date       :
* Description:
*-----------------------------------------------------------
    ORG    $1000
START:                  ; first instruction of program

* Put program code here
    move.l d0,#-325
    move.l d2,#826
    
    *ADD <ea>,Dn sintassi
    * move [sorgente],[destinazione]    move SINTASSI
    
    move.l d0,d5
    add d5,#22         ; t1 = s1 + 22
    move.l d5,d3
    
    move.l d2,d5
    sub d5,#329
    move.l d3,d5
    
    move.l d5,#2048
    sub d5,d3
    move.l d5,d1
    
    add d1,d3
    
    move.l d5,d0
    add d0,#345
    move.l d0,d3
    
    move.l d0,d5
    add d5,#9
    move.l d5,d3    ;la morte è vicina
    
    move.l d1,d5
    sub d5,d3
    move.l d5,d2
    
    move.l d3,d5
    sub d5,d2
    move.l d5,d4
    
    sub d0,d4       ;non posso bestemmiare in chat, che peccato
    
    
    
    


    SIMHALT             ; halt simulator

* Put variables and constants here
    
    END    START        ; last line of source
