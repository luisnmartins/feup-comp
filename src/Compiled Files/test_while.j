.class public test_while
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 3

ldc 0
istore 0

ldc 10
istore 1

loop0:

iload 0
iload 1
if_icmpeq loop_end0

iload 0
invokestatic io/print(I)V

iload 0
ldc 1
iadd
istore 0

goto loop0
loop_end0:
return
.end method

.method static public <clinit>()V
.limit stack 100
.limit locals 0

return
.end method

