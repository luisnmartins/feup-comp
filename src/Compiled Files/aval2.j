.class public aval2
.super java/lang/Object

.method public static f(II)I
.limit stack 100
.limit locals 3

ldc 3
istore 2

iload 0
iload 1
if_icmpeq if_end0

ldc 2
istore 2

if_end0:

iload 2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 2

ldc 2
ldc 12
invokestatic aval2/f(II)I

istore 0

iload 0
invokestatic io/println(I)V

ldc 4
ldc 2
invokestatic aval2/f(II)I

istore 0

iload 0
invokestatic io/println(I)V

ldc 3
istore 0

ldc 4
ldc 2
invokestatic aval2/f(II)I

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

