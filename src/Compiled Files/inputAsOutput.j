.class public inputAsOutput
.super java/lang/Object

.method public static f(I)I
.limit stack 1
.limit locals 1

iload_0
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 2

bipush 4
invokestatic inputAsOutput/f(I)I

istore_0

iload_0
invokestatic io/print(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

