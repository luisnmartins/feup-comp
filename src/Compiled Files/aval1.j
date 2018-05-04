.class public aval1
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 2

bipush 2
bipush 3
invokestatic aval1/f(II)I

istore 0

iload 0
invokestatic io/println(I)V

return
.end method

.method public static f(II)I
.limit stack 100
.limit locals 3

iload 0
iload 1
imul
istore 2

iload 2
ireturn
.end method

.method static public <clinit>()V
.limit stack 100
.limit locals 0

return
.end method

