.class public array2
.super java/lang/Object

.method public static sum_array([I)I
.limit stack 3
.limit locals 4

ldc 0
istore 1

ldc 0
istore 2

loop0:

iload 1
aload 0
arraylength
if_icmpge loop_end0
iload 2
aload 0
iload 1
iaload
iadd
istore 2

iload 1
ldc 10
if_icmpne if_end0

ldc 1904
istore 3

iload 2
iload 3
iadd
istore 2

if_end0:

iload 1
ldc 1
iadd
istore 1

goto loop0
loop_end0:
iload 2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 6

ldc 16
istore 0

iload 0
newarray int
astore 1

ldc 0
istore 2

loop0:

iload 2
iload 0
if_icmpge loop_end0
iload 2
istore 5
aload 1
iload 2
iload 5
iastore

iload 2
ldc 1
iadd
istore 2

goto loop0
loop_end0:
aload 1
invokestatic array2/sum_array([I)I

istore 3

ldc "sum of array elements = "
iload 3
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

