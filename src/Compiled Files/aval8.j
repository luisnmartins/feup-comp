.class public aval8
.super java/lang/Object

.method public static max1()I
.limit stack 100
.limit locals 6

invokestatic io/read()V

istore 0

invokestatic io/read()V

istore 1

iload 1
istore 2

iload 0
iload 1
if_icmple if_end0

iload 0
istore 2

if_end0:

ldc 2
ldc 4
imul
istore 3

ldc "a"
iload 0
invokestatic io/print(Ljava/lang/String;I)V

iload 0
ldc -23
if_icmpge if_else1

ldc 0
istore 4

goto if_end1

if_else1:
ldc -2
ldc 4
imul
istore 5

if_end1:

iload 4
istore 2

iload 2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 2

invokestatic aval8/max1()I

istore 0

iload 0
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 100
.limit locals 0

return
.end method

