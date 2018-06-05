.class public test
.super java/lang/Object

.field static k [I 

.field static l [I 

.method public static f1(I)I
.limit stack 3
.limit locals 6

bipush 10
newarray int
astore_1

iload_0
istore_3
aload_1
arraylength
istore 4
iconst_0
istore 5
loop2:
iload 5
iload 4
if_icmpge loop_end2
aload_1
iload 5
iload_3
iastore
iinc 5 1
goto loop2
loop_end2:

iload_0
bipush 114
iadd
istore_2

ldc "p "
iload_0
invokestatic io/println(Ljava/lang/String;I)V

iload_2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 18

iconst_1
istore_0

bipush 10
newarray int
astore_1

iconst_1
istore 7
aload_1
arraylength
istore 8
iconst_0
istore 9
loop3:
iload 9
iload 8
if_icmpge loop_end3
aload_1
iload 9
iload 7
iastore
iinc 9 1
goto loop3
loop_end3:

getstatic test/k [I
iconst_2
bipush 87
iastore

getstatic test/k [I
arraylength
istore_2

getstatic test/k [I
iconst_2
iaload
istore_3

iconst_4
newarray int
astore_1

iconst_5
istore 11
aload_1
arraylength
istore 12
iconst_0
istore 13
loop4:
iload 13
iload 12
if_icmpge loop_end4
aload_1
iload 13
iload 11
iastore
iinc 13 1
goto loop4
loop_end4:

aload_1
iconst_3
iconst_2
iastore

getstatic test/k [I
arraylength
iconst_2
imul
istore_3

getstatic test/l [I
arraylength
newarray int
astore 4

sipush 1904
istore 15
aload 4
arraylength
istore 16
iconst_0
istore 17
loop5:
iload 17
iload 16
if_icmpge loop_end5
aload 4
iload 17
iload 15
iastore
iinc 17 1
goto loop5
loop_end5:

aload 4
iconst_1
iaload
istore 5

iload 5
invokestatic test/f1(I)I

iload 5
invokestatic test/f1(I)I

iadd
istore_3

ldc "d "
iload_2
invokestatic io/println(Ljava/lang/String;I)V

ldc "c "
iload_3
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method static public <clinit>()V
.limit stack 3
.limit locals 6

iconst_4
newarray int
putstatic test/k [I

iconst_4
istore_1
iconst_0
istore_2
loop0:
iload_2
iload_1
if_icmpge loop_end0
getstatic test/k [I
iload_2
bipush 9
iastore
iinc 2 1
goto loop0
loop_end0:

getstatic test/k [I
arraylength
newarray int
putstatic test/l [I

getstatic test/k [I
arraylength
istore 4
iconst_0
istore 5
loop1:
iload 5
iload 4
if_icmpge loop_end1
getstatic test/l [I
iload 5
bipush 123
iastore
iinc 5 1
goto loop1
loop_end1:

return
.end method

