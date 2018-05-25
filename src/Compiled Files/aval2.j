.class public aval2
.super java/lang/Object

.method public static f(II)I
.limit stack 2
.limit locals 3

iconst_3
istore_2

iload_0
iload_1
if_icmpne if_end0

iconst_2
istore_2

if_end0:

iload_2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 2

iconst_2
bipush 12
invokestatic aval2/f(II)I

istore_0

iload_0
invokestatic io/println(I)V

bipush 4
iconst_2
invokestatic aval2/f(II)I

istore_0

iload_0
invokestatic io/println(I)V

iconst_3
istore_0

bipush 4
iconst_2
invokestatic aval2/f(II)I

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

