.class public aval8
.super java/lang/Object

.method public static max1()I
.limit stack 2
.limit locals 5

invokestatic io/read()I

istore_0

invokestatic io/read()I

istore_1

iload_1
istore_2

iload_0
iload_1
if_icmple if_end0

iload_0
istore_2

if_end0:

iconst_2
bipush 4
imul
istore_3

ldc "a"
iload_0
invokestatic io/print(Ljava/lang/String;I)V

iload_0
bipush -23
if_icmpge if_else1

iconst_0
istore 4

goto if_end1

if_else1:
bipush -2
bipush 4
imul
istore 4

if_end1:

iload 4
istore_2

iload_2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 2

invokestatic aval8/max1()I

istore_0

iload_0
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

