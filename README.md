# README #

This README would normally document whatever steps are necessary to get your application up and running.

COMP Group56

## Pre-requirements ##

jasmin.jar and io.class to be placed on the src folder

## How to run? ##

Run the following commands on command line:

jjtree parser/Parser.jjt && javacc parser/Parser.jj && javac parser/*.java

And then gerate code for jasmin:

java parser/YAL ../YalFiles/Working/aval1.yal

java -jar jasmin.jar "Compiled Files"/aval1.j

java aval1

## Optimizations ##

To optimize the compiled file we consider some optimizations. To get an optimize code you should run using -o flag

We implemented 3 optimizations: constant propagation, constant folding and while loop removing unnecessary goto instructions.

#### Constant Propagation ####
So, to implement constant propagation while generating code for each assigned variable (not array) it saves the assigned value in the symbol table of the function. So when it variable is used it can replace the iload instruction by instructions like iconst. Although, it do not replace if the variable is used inside a while loop or an if/else block since it can change inside this block even after be used and the analysis in done while generating code.

It allows some load instructions to be saved, so it is optimized.  

#### Constant Folding ####
Since we implemented Constant Progagation,to take advantange of it, we decided to also implement Constant Folding. Basically Constant Folding is the process of recognizing and evaluating constant expressions at compile time rather than computing the calculations at runtime.So basically everytime there is any type of operation (eg a = 4+4), while generating the code we do the operation and store the 8 immediately instead putting the operation on the jasmin file.This optimization works also with constant variables like b = a + 7, since we have done Constant Progagation, of course since constant progagation is not used on variables inside while loops and if/else, then,inside of these constant folding only works with constant (eg: a = 8>>6).



#### While loop ####
To generate code without unnecessary goto instructions when -o flag is on the generated code of a while loop becomes an if/do while loop. This transformation saves 2 jumps, since it checks the condition just after executing the code. It allows that it is not necessary to jump to the beginning of the cycle in the last iteration, because the condition is checked in the end, so it can leave right away. 

Example,

Begin:
	not_cond jump End
	body
	jump Begin
End:

Becomes,

If not_cond jump End
Begin:
	body
	cond jump Begin
End:



## Some notes ##

a[] creates an array that isn't initialized