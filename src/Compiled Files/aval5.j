.class public aval5
.super java/lang/Object

.method public static f(II)I
.limit stack 100
.limit locals 5

ldc 10
istore 2

iload 0
iload 1
if_icmpne if_else0

loop0:

iload 0
iload 2
if_icmpge loop_end0
iload 0
ldc 1
iadd
istore 0

goto loop0
loop_end0:
iload 0
ldc 1
ishl
istore 1

goto if_end0

if_else0:
iload 1
iload 0
iadd
istore 1

if_end0:

iload 1
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 2

ldc 4
ldc 5
invokestatic aval5/f(II)I

istore 0

iload 0
invokestatic io/println(I)V

ldc 2
ldc 2
invokestatic aval5/f(II)I

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

