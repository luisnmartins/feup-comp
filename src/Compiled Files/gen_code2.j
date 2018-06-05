.class public gen_code2
.super java/lang/Object

.field static k I = 8

.method public static func(IIIII)I
.limit stack 2
.limit locals 6

iload_0
iload_1
if_icmplt  if_else0

iload_2
iload_3
iushr
istore_0

iload_1
iload_2
iand
istore 4

iload 4
iload_0
iadd
istore_0

goto if_end0

if_else0:
iload_3
istore_0

if_end0:

iload_0
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 8
.limit locals 8

getstatic gen_code2/k I
iconst_m1
iadd
istore_0

ldc "b: "
iload_0
invokestatic io/println(Ljava/lang/String;I)V

iconst_1
istore_1

iconst_2
istore_1

iconst_3
istore_2

iconst_0
istore_3

ldc "a: "
iconst_3
invokestatic io/println(Ljava/lang/String;I)V

ldc "c: "
iconst_0
invokestatic io/println(Ljava/lang/String;I)V

iload_2
bipush 6
if_icmpge loop_end0
loop0:

iinc 2 1

iload_2
iconst_2
iadd
istore_3

ldc "a: "
iload_2
invokestatic io/println(Ljava/lang/String;I)V

ldc "c: "
iload_3
invokestatic io/println(Ljava/lang/String;I)V

iload_2
bipush 6
if_icmplt loop0
loop_end0:
bipush 10
istore_2

bipush 10
iload_3
iadd
istore_0

ldc "a: "
bipush 10
invokestatic io/println(Ljava/lang/String;I)V

ldc "b: "
iload_0
invokestatic io/println(Ljava/lang/String;I)V

iconst_4
newarray int
astore 4

aload 4
iconst_3
bipush 10
iastore

aload 4
iconst_2
aload 4
iconst_3
iaload
bipush 10
iload_0
iload_3
bipush 8
bipush 9
invokestatic gen_code2/func(IIIII)I

iadd
iastore

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

