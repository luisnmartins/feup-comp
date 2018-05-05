.class public test_if_else
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 3

ldc 4
istore 0

ldc 10
istore 1

iload 0
iload 1
if_icmpge if_end0

iload 0
invokestatic io/println(I)V

iload 0
ldc 1
iadd
istore 0

if_end0:

iload 0
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 100
.limit locals 0

return
.end method

