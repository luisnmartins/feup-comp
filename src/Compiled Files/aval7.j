.class public aval7
.super java/lang/Object

.method public static Count(I)I
.limit stack 2
.limit locals 4

iconst_0
istore_1

iconst_m1
istore_2

loop0:

iload_2
bipush 32
if_icmpge loop_end0
iload_0
iconst_1
iand
istore_3

iload_3
iconst_1
if_icmpne if_end0

iinc 1 1

if_end0:

iinc 0 1

iinc 2 1

goto loop0
loop_end0:
iload_1
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 2

iconst_3
invokestatic aval7/Count(I)I

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

