.class public aval4
.super java/lang/Object

.method public static f(II)I
.limit stack 2
.limit locals 4

loop0:

iload_0
iload_1
if_icmpge loop_end0
invokestatic io/read()I

istore_2

invokestatic io/read()I

istore_0

iload_0
iload_2
iadd
istore_0

goto loop0
loop_end0:
iload_0
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 2

iconst_5
bipush 6
invokestatic aval4/f(II)I

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

