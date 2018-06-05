@ECHO OFF
setlocal EnableDelayedExpansion

FOR %%i IN (C:\Users\emanu\Documents\g56\YalFiles\Working\*) DO (

java parser/YAL ../YalFiles/Working/%%~ni.yal
cd "Compiled Files"
java -jar jasmin.jar %%~ni.j
java %%~ni
cd..
PAUSE
)
PAUSE
CLS
EXIT