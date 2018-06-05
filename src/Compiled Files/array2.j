.class public array2
.super java/lang/Object

.method public static sum_array([I)I
.limit stack 3
.limit locals 5

iconst_0
istore_1

iconst_0
istore_2

aload_0
bipush 7
iaload
istore_3

iload_3
invokestatic io/println(I)V

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

iload_2
invokestatic io/print(I)V

iload_1
bipush 10
if_icmpne if_end0

sipush 1904
istore 4

iload_2
iload 4
iadd
istore_2

if_end0:

iinc 1 1

goto loop0
loop_end0:
iload_2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 7

bipush 16
istore_0

iload_0
newarray int
astore_1

iconst_0
istore_2

loop1:

iload_2
iload_0
if_icmpge loop_end1
aload_1
iload_2
iload_2
iastore

aload_1
iload_2
iaload
istore_3

iinc 2 1

iload_3
invokestatic io/println(I)V

goto loop1
loop_end1:
aload_1
invokestatic array2/sum_array([I)I

istore 4

ldc "sum of array elements = "
iload 4
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

