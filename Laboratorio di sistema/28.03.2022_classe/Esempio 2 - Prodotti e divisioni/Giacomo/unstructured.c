#include <stdio.h>

int s1 = 4095;
int s2 = 41;
int s3 = 33;
int s4;
int s5;

int main(void){

// part 1: computes two quotients and a product

	s5 = 29041 / s1;
	s4 = s5 * s3;
	s3 = s3 + 113;
	s5 = s3 / 3;

// part 2: computes reminder

	s3 = s5 % 5;
	
// part 3: computes both quotient and reminder of a product
	s2 = s2 * 52;
	s1 = s2 / s3;
	s2 = s2 % s3;

}


/*

	LPS Example

	C to ASM: Expression 2022

	Language: C99
 	Style: unstructured C
 	Version: Ref-uc
 


    Original C Code

	Problem statement: transform a C program in an equivalent program
		in MIPS32-MARS and MC68000-ASM1



	Important point: in this example, all variables should have non-negative values


int s1 = 4095, s2 = 41, s3 = 33, s4, s5;

int main( void ) {

// part 1: computes two quotients and a product
	s5 = 29041 / s1;
	s4 = s5 * s3;
	s3 += 113;
	s5 = s3 / 3;

// part 2: computes reminder
	s3 = s5 % 5;

// part 3: computes both quotient and reminder of a product
	s2 *= 52;
	s1 = s2 / s3;
	s2 = s2 % s3;

	return 0;
}

Final values of the variables
s1 : 710
s2 : 2
s3 : 3
s4 : 231
s5 : 48

*/
