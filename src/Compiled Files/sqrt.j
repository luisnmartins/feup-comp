.class public sqrt
.super java/lang/Object

.method public static sqrt()I
.limit stack 2
.limit locals 13

invokestatic io/read()I

istore_0

ldc "vsqn: "
iload_0
invokestatic io/println(Ljava/lang/String;I)V

iload_0
istore_1

iconst_0
istore_2

iconst_0
istore_3

iconst_0
istore 4

iconst_0
istore 5

loop0:

iload 5
bipush 6
if_icmpge loop_end0
iload_2
iload_3
iadd
istore 6

iload 6
iconst_2
ishl
istore 7

iload 7
iconst_1
ior
istore 8

iload_3
iconst_1
ishl
istore 9

iload 4
iconst_2
ishl
istore 10

iload_1
bipush 10
ishr
istore 11

iload 11
iconst_3
iand
istore 12

iload 10
iload 12
ior
istore 4

iload_1
iconst_2
ishl
istore_1

iload 8
iload 4
if_icmpgt if_else0

iload 9
iconst_1
ior
istore_3

iload 8
istore_2

goto if_end0

if_else0:
iload 9
istore_3

iload_2
iconst_2
ishl
istore_2

if_end0:

iload 5
iconst_1
iadd
istore 5

goto loop0
loop_end0:
ldc "sqrt: "
iload_3
invokestatic io/println(Ljava/lang/String;I)V

iload_3
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 2

invokestatic sqrt/sqrt()I

istore_0

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

