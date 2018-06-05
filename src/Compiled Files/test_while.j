.class public test_while
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 3

iconst_0
istore_0

bipush 10
istore_1

loop0:

iload_0
iload_1
if_icmpge loop_end0
iload_0
invokestatic io/print(I)V

iinc 0 1

goto loop0
loop_end0:
return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

