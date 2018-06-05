@ECHO OFF
setlocal EnableDelayedExpansion

FOR %%i IN (C:\Users\emanu\Documents\g56\YalFiles\Working\*) DO (

java parser/YAL ../YalFiles/Working/%%~ni.yal
java -jar jasmin.jar "Compiled Files"/%%~ni.j
java %%~ni
PAUSE
)
PAUSE
CLS
EXIT