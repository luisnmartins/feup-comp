.class public aval7
.super java/lang/Object

.method public static Count(I)I
.limit stack 100
.limit locals 4

ldc 0
istore 1

ldc -1
istore 2

loop0:

iload 2
ldc 32
if_icmpge loop_end0
iload 0
ldc 1
iand
istore 3

iload 3
ldc 1
if_icmpne if_end0

iload 1
ldc 1
iadd
istore 1

if_end0:

iload 0
ldc 1
ishr
istore 0

iload 2
ldc 1
iadd
istore 2

goto loop0
loop_end0:
iload 1
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 2

ldc 3
invokestatic aval7/Count(I)I

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

