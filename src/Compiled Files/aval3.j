.class public aval3
.super java/lang/Object

.method public static f(II)I
.limit stack 100
.limit locals 3

iload 0
iload 1
if_icmplt  if_else0

ldc 2
istore 2

goto if_end0

if_else0:
ldc 4
istore 2

if_end0:

iload 2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 3

ldc 2
istore 0

ldc 3
istore 1

iload 0
iload 1
invokestatic aval3/f(II)I

istore 0

iload 0
invokestatic io/println(I)V

ldc 6
istore 0

iload 0
iload 1
invokestatic aval3/f(II)I

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

