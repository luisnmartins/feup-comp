.class public t6
.super java/lang/Object

.method public static avg(IIII)I
.limit stack 1
.limit locals 5

iconst_4
istore 4

iload 4
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 3

bipush 7
istore_0

bipush 49
istore_1

iinc 1 1

iload_1
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

