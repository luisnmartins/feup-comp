.class public registerTest
.super java/lang/Object

.method public static f(I)I
.limit stack 2
.limit locals 5

iload_0
iconst_1
iadd
istore_1

iload_1
iconst_1
iadd
istore_2

iload_2
iconst_1
iadd
istore_3

iload_3
iconst_1
iadd
istore 4

iload 4
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 2

bipush 7
invokestatic registerTest/f(I)I

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

