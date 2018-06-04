.class public array1
.super java/lang/Object

.field static v I = 1904

.method public static print_array(I[II)V
.limit stack 3
.limit locals 7

aload_1
iconst_3
bipush -7
iastore

iconst_0
istore_3

loop0:

iload_3
iload_0
if_icmpge loop_end0
aload_1
iload_3
iload_3
iastore

iload_3
iconst_1
iadd
istore_3

goto loop0
loop_end0:
iconst_0
istore_3

loop1:

iload_3
iload_0
if_icmpge loop_end1
aload_1
iload_3
iaload
istore 4

ldc "a: "
iload 4
invokestatic io/print(Ljava/lang/String;I)V

iload_3
iconst_1
iadd
istore_3

goto loop1
loop_end1:
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 2

bipush 10
newarray int
astore_0

bipush 10
aload_0
iconst_4
invokestatic array1/print_array(I[II)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

