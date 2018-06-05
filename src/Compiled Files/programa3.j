.class public programa3
.super java/lang/Object

.method public static f1([I)[I
.limit stack 4
.limit locals 4

iconst_0
istore_1

aload_0
arraylength
newarray int
astore_2

loop0:

iload_1
aload_0
arraylength
if_icmpge loop_end0
aload_2
iload_1
aload_0
iload_1
iaload
iastore

iinc 1 1

goto loop0
loop_end0:
aload_2
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
invokestatic programa3/f1([I)[I

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
invokestatic programa3/f2(I)[I

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

