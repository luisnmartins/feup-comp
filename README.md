# README #

This README would normally document whatever steps are necessary to get your application up and running.

COMP Group56

### Pre-requirements ###

jasmin.jar and io.class to be placed on the src folder

### How to run? ###

Run the following commands on command line:

jjtree Parser.jjt

javacc Parser.jj

javac *.java

And then gerate code for jasmin:

java YAL ../YalFiles/Working/aval1.yal

java -jar jasmin.jar "Compiled Files"/aval1.j

java aval1

### Some notes ###

a[] creates an array that isn't initialized