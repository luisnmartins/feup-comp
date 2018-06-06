@ECHO OFF
setlocal EnableDelayedExpansion

if not exist "Compiled Files" mkdir "Compiled Files"



REM Array Init
java -jar ../../yal2jvm.jar array-init.yal
java -jar ../../jasmin.jar "Compiled Files"/arrayInit.j
java arrayInit
PAUSE



REM Array1
java -jar ../../yal2jvm.jar array1.yal
java -jar ../../jasmin.jar "Compiled Files"/array1.j
java array1
PAUSE

REM Array2
java -jar ../../yal2jvm.jar array2.yal
java -jar ../../jasmin.jar "Compiled Files"/array2.j
java array2
PAUSE

REM Aval1
java -jar ../../yal2jvm.jar aval1.yal
java -jar ../../jasmin.jar "Compiled Files"/aval1.j
java aval1
PAUSE

REM Aval2
java -jar ../../yal2jvm.jar aval2.yal
java -jar ../../jasmin.jar "Compiled Files"/aval2.j
java aval2
PAUSE

REM Aval3
java -jar ../../yal2jvm.jar aval3.yal
java -jar ../../jasmin.jar "Compiled Files"/aval3.j
java aval3
PAUSE

REM Aval4
java -jar ../../yal2jvm.jar aval4.yal
java -jar ../../jasmin.jar "Compiled Files"/aval4.j
java aval4
PAUSE

REM Aval5
java -jar ../../yal2jvm.jar aval5.yal
java -jar ../../jasmin.jar "Compiled Files"/aval5.j
java aval5
PAUSE

REM Aval6
java -jar ../../yal2jvm.jar aval6.yal
java -jar ../../jasmin.jar "Compiled Files"/aval6.j
java aval6
PAUSE

REM Aval7
java -jar ../../yal2jvm.jar aval7.yal
java -jar ../../jasmin.jar "Compiled Files"/aval7.j
java aval7
PAUSE

REM Aval8
java -jar ../../yal2jvm.jar aval8.yal
java -jar ../../jasmin.jar "Compiled Files"/aval8.j
java aval8
PAUSE

REM callMain
java -jar ../../yal2jvm.jar call-main.yal
java -jar ../../jasmin.jar "Compiled Files"/callMain.j
java callMain
PAUSE

REM constantRanges
java -jar ../../yal2jvm.jar constant-ranges.yal
java -jar ../../jasmin.jar "Compiled Files"/constantRanges.j
java constantRanges
PAUSE

REM inputAsOutput
java -jar ../../yal2jvm.jar input-as-output.yal
java -jar ../../jasmin.jar "Compiled Files"/inputAsOutput.j
java inputAsOutput
PAUSE


REM library1
java -jar ../../yal2jvm.jar library1.yal
java -jar ../../jasmin.jar "Compiled Files"/library1.j
PAUSE

REM max_array
java -jar ../../yal2jvm.jar max_array.yal
java -jar ../../jasmin.jar "Compiled Files"/max_array.j
java max_array
PAUSE

REM max
java -jar ../../yal2jvm.jar max.yal
java -jar ../../jasmin.jar "Compiled Files"/max.j
java max
PAUSE

REM max1
java -jar ../../yal2jvm.jar max1.yal
java -jar ../../jasmin.jar "Compiled Files"/max1.j
java max1
PAUSE

REM maxmin
java -jar ../../yal2jvm.jar maxmin.yal
java -jar ../../jasmin.jar "Compiled Files"/maxmin.j
java maxmin
PAUSE

REM nestedBranch
java -jar ../../yal2jvm.jar nested-branch.yal
java -jar ../../jasmin.jar "Compiled Files"/nestedBranch.j
java nestedBranch
PAUSE


REM Programa1
java -jar ../../yal2jvm.jar programa1.yal
java -jar ../../jasmin.jar "Compiled Files"/programa1.j
java programa1
PAUSE

REM Programa2
java -jar ../../yal2jvm.jar programa2.yal
java -jar ../../jasmin.jar "Compiled Files"/programa2.j
java programa2
PAUSE

REM Programa3
java -jar ../../yal2jvm.jar programa3.yal
java -jar ../../jasmin.jar "Compiled Files"/programa3.j
java programa3
PAUSE

REM quicksort
java -jar ../../yal2jvm.jar quicksort.yal
java -jar ../../jasmin.jar "Compiled Files"/quicksort.j
java quicksort
PAUSE

REM registerTest
java -jar ../../yal2jvm.jar register-test.yal
java -jar ../../jasmin.jar "Compiled Files"/registerTest.j
java registerTest
PAUSE

REM sqrt
java -jar ../../yal2jvm.jar sqrt.yal
java -jar ../../jasmin.jar "Compiled Files"/sqrt.j
java sqrt
PAUSE

REM stackSize
java -jar ../../yal2jvm.jar stack-size.yal
java -jar ../../jasmin.jar "Compiled Files"/stackSize.j
java stackSize
PAUSE




