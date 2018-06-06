@ECHO OFF
setlocal EnableDelayedExpansion

FOR %%i IN (*) DO (

java -jar ../yal2jvm.jar %%~ni.yal
java -jar ../jasmin.jar "Compiled Files"/%%~ni.j
java %%~ni
PAUSE
)
PAUSE
CLS
EXIT