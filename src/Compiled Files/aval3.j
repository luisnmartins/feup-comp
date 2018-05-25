.class public aval3
.super java/lang/Object

.method public static f(II)I
.limit stack 2
.limit locals 3

iload_0
iload_1
if_icmplt  if_else0

iconst_2
istore_2

goto if_end0

if_else0:
bipush 4
istore_2

if_end0:

iload_2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 3

iconst_2
istore_0

iconst_3
istore_1

iload_0
iload_1
invokestatic aval3/f(II)I

istore_0

iload_0
invokestatic io/println(I)V

bipush 6
istore_0

iload_0
iload_1
invokestatic aval3/f(II)I

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

