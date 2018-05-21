.class public t4
.super java/lang/Object

.method public static f1(IIII)I
.limit stack 100
.limit locals 5

iload 0
iload 1
iadd
istore 4

iload 4
iload 2
iadd
istore 4

iload 4
iload 3
iadd
istore 4

iload 4
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 3

ldc 10
newarray int
astore 0

aload 0
ldc 1
iaload
ldc 1
ldc 2
ldc 3
ldc 4
invokestatic t4/f1(IIII)I

iadd
istore 1

iload 1
invokestatic io/print(I)V

iload 1
aload 0
ldc 2
iaload
if_icmpge if_end0

if_end0:

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

