.class public all
.super java/lang/Object

.field static a I = 0

.field static b I = 1

.method public static funcAbove(II)I
.limit stack 100
.limit locals 3

ldc "arg1 = "
iload 0
invokestatic io/println(Ljava/lang/String;I)V

ldc "arg2 = "
iload 1
invokestatic io/println(Ljava/lang/String;I)V

iload 0
iload 1
iadd
istore 2

ldc "ret in funcAbove = "
iload 2
invokestatic io/println(Ljava/lang/String;I)V

iload 2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 8

ldc "a = "
getstatic all/a I
invokestatic io/println(Ljava/lang/String;I)V

ldc "b = "
getstatic all/b I
invokestatic io/println(Ljava/lang/String;I)V

ldc "1 = "
bipush 1
invokestatic io/println(Ljava/lang/String;I)V

getstatic all/a I
getstatic all/b I
iadd
istore 0

getstatic all/a I
getstatic all/b I
isub
istore 1

getstatic all/a I
getstatic all/b I
imul
istore 2

getstatic all/a I
getstatic all/b I
idiv
istore 3

ldc "sum = "
iload 0
invokestatic io/println(Ljava/lang/String;I)V

ldc "dif = "
iload 1
invokestatic io/println(Ljava/lang/String;I)V

ldc "mul = "
iload 2
invokestatic io/println(Ljava/lang/String;I)V

ldc "div = "
iload 3
invokestatic io/println(Ljava/lang/String;I)V

invokestatic io/println()V

getstatic all/a I
getstatic all/b I
iadd
istore 4

ldc "c = "
iload 4
invokestatic io/println(Ljava/lang/String;I)V

invokestatic io/println()V

getstatic all/b I
iload 4
invokestatic all/funcAbove(II)I

istore 5

getstatic all/b I
iload 4
invokestatic all/funcBelow(II)I

istore 6

ldc "funcAbove of b c = "
iload 5
invokestatic io/println(Ljava/lang/String;I)V

ldc "funcBelow of b c = "
iload 6
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method public static funcBelow(II)I
.limit stack 100
.limit locals 3

ldc "arg1 = "
iload 0
invokestatic io/println(Ljava/lang/String;I)V

ldc "arg2 = "
iload 1
invokestatic io/println(Ljava/lang/String;I)V

iload 0
iload 1
iadd
istore 2

ldc "ret in funcBelow = "
iload 2
invokestatic io/println(Ljava/lang/String;I)V

iload 2
ireturn
.end method

