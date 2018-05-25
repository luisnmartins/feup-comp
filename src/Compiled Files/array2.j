.class public array2
.super java/lang/Object

.method public static sum_array([I)I
.limit stack 3
.limit locals 4

iconst_0
istore_1

iconst_0
istore_2

loop0:

iload_1
aload_0
arraylength
if_icmpge loop_end0
iload_2
aload_0
iload_1
iaload
iadd
istore_2

iload_1
bipush 10
if_icmpne if_end0

sipush 1904
istore_3

iload_2
iload_3
iadd
istore_2

if_end0:

iload_1
iconst_1
iadd
istore_1

goto loop0
loop_end0:
iload_2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 6

bipush 16
istore_0

iload_0
newarray int
astore_1

iconst_0
istore_2

loop0:

iload_2
iload_0
if_icmpge loop_end0
iload_2
istore 5
aload_1
iload_2
iload 5
iastore

iload_2
iconst_1
iadd
istore_2

goto loop0
loop_end0:
aload_1
invokestatic array2/sum_array([I)I

istore_3

ldc "sum of array elements = "
iload_3
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

