.class public t3
.super java/lang/Object

.field static v [I 

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 13

bipush 10
newarray int
astore_0

bipush 30
newarray int
putstatic t3/v [I

iconst_0
istore_1

loop0:

iload_1
bipush 4
bipush 4
iadd
if_icmpge loop_end0
iload_1
istore 8
getstatic t3/v [I
iload_1
iload 8
iastore

iload_1
iconst_1
iadd
istore_1

goto loop0
loop_end0:
bipush 40
newarray int
astore_2

getstatic t3/v [I
astore_2
bipush 20
newarray int
astore_0

iconst_1
istore 9
aload_0
bipush 4
iload 9
iastore

aload_2
bipush 4
iaload
istore_3

aload_0
bipush 4
iaload
istore 4

iload_3
invokestatic io/println(I)V

iload 4
invokestatic io/println(I)V

bipush 10
newarray int
astore 5

iconst_3
istore 10
aload 5
arraylength
istore 11
iconst_0
istore 12
loop1:
iload 12
iload 11
if_icmpge loop_end1
aload 5
iload 12
iload 10
iastore
iinc 12 1
goto loop1
loop_end1:

iconst_0
istore_1

loop2:

iload_1
aload_2
arraylength
if_icmpge loop_end2
aload_2
iload_1
iaload
istore 6

iload 6
invokestatic io/print(I)V

iload_1
iconst_1
iadd
istore_1

goto loop2
loop_end2:
invokestatic t3/f1()V

return
.end method

.method public static f1()V
.limit stack 2
.limit locals 1

getstatic t3/v [I
bipush 20
iaload
istore_0

iload_0
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 3
.limit locals 3

bipush 10
newarray int
putstatic t3/v [I

bipush 10
istore_1
iconst_0
istore_2
loop0:
iload_2
iload_1
if_icmpge loop_end0
getstatic t3/v [I
iload_2
ldc 99999
iastore
iinc 2 1
goto loop0
loop_end0:

return
.end method

