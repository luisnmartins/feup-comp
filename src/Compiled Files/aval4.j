.class public aval4
.super java/lang/Object

.method public static f(II)I
.limit stack 2
.limit locals 4

loop0:

iload 0
iload 1
if_icmpge loop_end0
invokestatic io/read()I

istore 2

invokestatic io/read()I

istore 0

iload 0
iload 2
iadd
istore 0

goto loop0
loop_end0:
iload 0
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 2

ldc 5
ldc 6
invokestatic aval4/f(II)I

istore 0

iload 0
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

