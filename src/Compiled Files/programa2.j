.class public programa2
.super java/lang/Object

.method public static f1([I)[I
.limit stack 9
.limit locals 5

iconst_0
istore_1

aload_0
arraylength
istore_2

iload_2
newarray int
astore_3

loop0:

iload_1
aload_0
arraylength
if_icmpge loop_end0
aload_3
iload_1
aload_0
iload_1
iaload
iconst_1
iconst_2
iconst_3
iconst_4
iconst_5
bipush 6
invokestatic programa2/j(IIIIII)I

iadd
iastore

iinc 1 1

goto loop0
loop_end0:
aload_3
areturn
.end method

.method public static f2(I)[I
.limit stack 3
.limit locals 5

iload_0
newarray int
astore_1

iconst_1
istore_2
aload_1
arraylength
istore_3
iconst_0
istore 4
loop1:
iload 4
iload_3
if_icmpge loop_end1
aload_1
iload 4
iload_2
iastore
iinc 4 1
goto loop1
loop_end1:

aload_1
areturn
.end method

.method public static j(IIIIII)I
.limit stack 1
.limit locals 7

iconst_4
istore 6

iload 6
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 7

bipush 100
newarray int
astore_0

aload_0
iconst_0
iconst_1
iastore

aload_0
bipush 99
iconst_2
iastore

aload_0
invokestatic programa2/f1([I)[I

astore_1
aload_1
iconst_0
iaload
istore_2

aload_1
bipush 99
iaload
istore_3

ldc "first: "
iload_2
invokestatic io/println(Ljava/lang/String;I)V

ldc "last: "
iload_3
invokestatic io/println(Ljava/lang/String;I)V

bipush 100
invokestatic programa2/f2(I)[I

astore_1
aload_1
iconst_0
iaload
istore_2

aload_1
bipush 99
iaload
istore_3

ldc "first: "
iload_2
invokestatic io/println(Ljava/lang/String;I)V

ldc "last: "
iload_3
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

