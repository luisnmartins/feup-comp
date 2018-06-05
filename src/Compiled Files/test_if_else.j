.class public test_if_else
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 3

iconst_4
istore_0

bipush 10
istore_1

iload_0
iload_1
if_icmpge if_end0

iload_0
invokestatic io/println(I)V

iinc 0 1

if_end0:

iload_0
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

