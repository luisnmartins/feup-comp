@ECHO OFF
setlocal EnableDelayedExpansion

if not exist "Compiled Files" mkdir "Compiled Files"


REM array2_err
java -jar ../../yal2jvm.jar array2_err.yal
java -jar ../../jasmin.jar "Compiled Files"/array2_err.j
java array2_err
PAUSE

REM array4_err
java -jar ../../yal2jvm.jar array4_err.yal
java -jar ../../jasmin.jar "Compiled Files"/array4_err.j
java array4_err
PAUSE

REM aval1_err
java -jar ../../yal2jvm.jar aval1_err.yal
java -jar ../../jasmin.jar "Compiled Files"/aval1_err.j
java aval1_err
PAUSE

REM aval2_err
java -jar ../../yal2jvm.jar aval2_err.yal
java -jar ../../jasmin.jar "Compiled Files"/aval2_err.j
java aval2_err
PAUSE

REM aval3_err
java -jar ../../yal2jvm.jar aval3_err.yal
java -jar ../../jasmin.jar "Compiled Files"/aval3_err.j
java aval3_err
PAUSE

REM aval4_err
java -jar ../../yal2jvm.jar aval4_err.yal
java -jar ../../jasmin.jar "Compiled Files"/aval4_err.j
java aval4_err
PAUSE

REM aval5_err
java -jar ../../yal2jvm.jar aval5_err.yal
java -jar ../../jasmin.jar "Compiled Files"/aval5_err.j
java aval5_err
PAUSE

REM aval6_err
java -jar ../../yal2jvm.jar aval6_err.yal
java -jar ../../jasmin.jar "Compiled Files"/aval6_err.j
java aval6_err
PAUSE

REM aval7_err
java -jar ../../yal2jvm.jar aval7_err.yal
java -jar ../../jasmin.jar "Compiled Files"/aval7_err.j
java aval7_err
PAUSE


REM err1
java -jar ../../yal2jvm.jar err1.yal
java -jar ../../jasmin.jar "Compiled Files"/err1.j
java err1
PAUSE

REM errorArrayCompare
java -jar ../../yal2jvm.jar error-array-compare.yal
java -jar ../../jasmin.jar "Compiled Files"/errorArrayCompare.j
java errorArrayCompare
PAUSE

REM errorResizeArray
java -jar ../../yal2jvm.jar error-resize-array.yal
java -jar ../../jasmin.jar "Compiled Files"/errorResizeArray.j
java errorResizeArray
PAUSE

REM errorSharedScope
java -jar ../../yal2jvm.jar error-shared-scope.yal
java -jar ../../jasmin.jar "Compiled Files"/errorSharedScope.j
java errorSharedScope
PAUSE

REM errorUninitializedOutput
java -jar ../../yal2jvm.jar error-uninitialized-output.yal
java -jar ../../jasmin.jar "Compiled Files"/errorUninitializedOutput.j
java errorUninitializedOutput
PAUSE


