.class public sqrt
.super java/lang/Object

.method public static sqrt()I
.limit stack 2
.limit locals 13

invokestatic io/read()I

istore 0

ldc "vsqn: "
iload 0
invokestatic io/println(Ljava/lang/String;I)V

iload 0
istore 1

ldc 0
istore 2

ldc 0
istore 3

ldc 0
istore 4

ldc 0
istore 5

loop0:

iload 5
ldc 6
if_icmpge loop_end0
iload 2
iload 3
iadd
istore 6

iload 6
ldc 2
ishl
istore 7

iload 7
ldc 1
ior
istore 8

iload 3
ldc 1
ishl
istore 9

iload 4
ldc 2
ishl
istore 10

iload 1
ldc 10
ishr
istore 11

iload 11
ldc 3
iand
istore 12

iload 10
iload 12
ior
istore 4

iload 1
ldc 2
ishl
istore 1

iload 8
iload 4
if_icmpgt if_else0

iload 9
ldc 1
ior
istore 3

iload 8
istore 2

goto if_end0

if_else0:
iload 9
istore 3

iload 2
ldc 2
ishl
istore 2

if_end0:

iload 5
ldc 1
iadd
istore 5

goto loop0
loop_end0:
ldc "sqrt: "
iload 3
invokestatic io/println(Ljava/lang/String;I)V

iload 3
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 2

invokestatic sqrt/sqrt()I

istore 0

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

