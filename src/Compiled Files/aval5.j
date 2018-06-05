.class public aval5
.super java/lang/Object

.method public static f(II)I
.limit stack 2
.limit locals 5

bipush 10
istore_2

iload_0
iload_1
if_icmpne if_else0

loop0:

iload_0
iload_2
if_icmpge loop_end0
iinc 0 1

goto loop0
loop_end0:
iload_0
iconst_2
ishl
istore_1

goto if_end0

if_else0:
if_end0:

iload_1
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 2

iconst_4
iconst_5
invokestatic aval5/f(II)I

istore_0

iload_0
invokestatic io/println(I)V

iconst_2
iconst_2
invokestatic aval5/f(II)I

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

