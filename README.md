# README

This README would normally document whatever steps are necessary to get your application up and running.

COMP Group56

### Project Title: YAL

### Group 56

- Carlos Freitas - 201504749, 18 , 28%
- Luis Martins - 201503344, 18 , 29%
- Rui Quaresma - 201503005, 18 , 28%
- Tiago Carvalho - 201504461, 14 , 15%

### Global grade of project : 18

## Summary

This tool allows the user to pre-compile a yal file to .j file so that it can be after compiled to .class file using jasmin.

## Pre-requirements

jasmin.jar and io.class to be placed on the src folder

## How to run?

Run the following commands on command line:

jjtree parser/Parser.jjt && javacc parser/Parser.jj && javac parser/\*.java

And then gerate code for jasmin:

java parser/YAL [-o] ../YalFiles/Working/aval1.yal

java -jar jasmin.jar "Compiled Files"/aval1.j

java aval1

## Dealing with syntactic errors

When a syntactic error is detected an exception is thrown
and one of the following functions is called: error_skipto(int kind, ParseException e)
or error_skipto2(int kind, int kind2, ParseException e).

These functions print a message with the line of code where the error occurred and which kind of tokens it was expecting. After that, it ignores the following tokens until a specific token (kind or kind2) so that it can continue the analysis and find other syntactic errors. There is a constraint that limits the number of founded error up to 10.

## Semantic analysis

As semantic rules, we decided to implement the following:

- On the main scope a[] creates a not initialized array
- An instanciated a array cannot be redeclared as for example, a=[100]; a=[20];
- a[] = 100 or a = 100, assuming 'a' is already consider an array, only is allowed if 'a' has been initialized with a specified size.
- a[] = 100, if it is the first time 'appears' is accepted and assumes 'a' as constant of value 100
- a = b, assuming b is an array is only acceptable if a has not been already initialized and b is of course initialized (????)
- a = x, where x is any type of operation with constant,variable or calls, the semantic analysis verifies if 'x' is of the same type of 'a' if 'a' as already been defined or just assumes 'a' as variable of the same type as 'x'.All variables used on the right side ('x'),must be initialized.The right side ('x'), unless is only an array ('x' represents an array or a call that returns an array), can only be integer since there cannot be allowed operations between arrays, only with its values
  - a = [100], b = [100] , c = a is allowed
  - a = [100], b = [100], c = a + b is not allowed but c = a[1] + b[2] is allowed.
- Change the size of an array like a.size = 10 is not allowed.
- Variable .size is only allowed if the variable is an instaciated array. (?need to check)
- Whenever a function is called the parameters are always checked if they are compatible (are initialized and are of the same type)
- A call function cannot be on the right side of an assign if it doesnt return a variable
- The return variable of a function must be initialized
- Any call of a function of other modules are per default considered to return a scalar value, unless the variable that the call is to be assigned is already defined.For example:
  - a = ext.fun(), if a is not defined ext.fun() returns scalar
  - a = [100]; a = ext.fun(), since a is defined assume ext.fun() returns an array
- Overload of functions is not allowed
- Variables declared inside of an if cannot be used outside of it
-

## Code generation

The code generation is being done after the semantic analysis. 
First the regists are assigned to the symbols present in the symbol table, which also allows us to have an initial value for locals (later this number may be increased according to te code provided, beacuse of the need to use more regists).
After that, the declarations are generated. The field static are pushed into an ArrayList and the count for the stack and locals in the <clinit> is made. Also, for the declarations that are arrays, the corresponding code to the array initialization and filling is also pushed to another ArrayList.
The declarations ArrayList is printed on the file. 
Then, the code for the functions is generated. Function by function, line by line, The code begins to be generated and written on the file starting in the deepest child of each line.
The stack is updated in each set of instructions correspondent to each element of a line of yal code.
The code generation covers all the cases needed: nested ifs, nested whiles, arrays, all kind of assigns, fill of arrays, calls, arithmetic expressions, ...
After one function is all written on the file, its stack is updated.

After all the functions are on the file, the global arrays are initialized (and filled) in the method <clinit>.

Notes:

- The code generation is optimized to use the instructions that have the least cost in terms of resources. 
- In cases like: x = x + 1, the iinc instruction is used.
- In constants loading cases the instructions used are the ones that fit the value of the constant.

## Overview

To pre-compile and generate the .j file, the system starts by constructing an abstract syntax tree with some nodes using the grammar structure.

After getting the AST, it creates a symbol table where it saves for each variable, the kind and if it is initialized. 
While the symbol table is created the compiler also checks all variables use and assign checking if there are not any semantic errors.

If all these steps are valid, the final code is generated with or without optimizations, depending on the user's preference.

### Optimizations

To optimize the compiled file we consider some optimizations. To get an optimize code you should run using -o flag

We implemented 3 optimizations: constant propagation, constant folding and while loop removing unnecessary goto instructions.

##### Constant Propagation

So, to implement constant propagation while generating code for each assigned variable (not array) it saves the assigned value in the symbol table of the function. So when it variable is used it can replace the iload instruction by instructions like iconst. Although, it do not replace if the variable is used inside a while loop or an if/else block since it can change inside this block even after be used and the analysis in done while generating code.

It allows some load instructions to be saved, so it is optimized.

##### Constant Folding

Since we implemented Constant Progagation,to take advantange of it, we decided to also implement Constant Folding. Basically Constant Folding is the process of recognizing and evaluating constant expressions at compile time rather than computing the calculations at runtime.So basically everytime there is any type of operation (eg a = 4+4), while generating the code we do the operation and store the 8 immediately instead putting the operation on the jasmin file.This optimization works also with constant variables like b = a + 7, since we have done Constant Progagation, of course since constant progagation is not used on variables inside while loops and if/else, then,inside of these constant folding only works with constant (eg: a = 8>>6).

##### While loop

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


## Testsuite and test infrastructure

There is a script that iterates through each file from working folder and runs all the necessary commands to compile and execute each yal file. 

PS: It does not work with files which filename and module name are different because the generated class file has the module name as filename.

## Task Distribution

- Carlos Freitas - semantic analysis and
- Luis Martins - semantic analysis and some optimizations such as constant propagation and efficient while loop. Also contributed in some other tasks from code generation.
- Rui Quaresma - code generation and constant folding
- Tiago Carvalho -

## Pros

Our tool is optimized to use the least resources possible in order for the program to run correctly.

## Cons

It can be optimized implementing other otimizations such as minimizing the number of allocated registeries with dataflow analysis and graph coloring.

## Some notes

a[] creates an array that isn't initialized
