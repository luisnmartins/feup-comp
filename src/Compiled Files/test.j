.class public test
.super java/lang/Object

.field static k [I 

.field static l [I 

.method public static f1(I)I
.limit stack 100
.limit locals 6

ldc 10
newarray int
astore 1

iload 0
istore 3
aload 1
arraylength
istore 4
iconst_0
istore 5
loop0:
iload 5
iload 4
if_icmpge loop_end0
aload 1
iload 5
iload 3
iastore
iinc 5 1
goto loop0
loop_end0:

iload 0
ldc 114
iadd
istore 2

ldc "p "
iload 0
invokestatic io/println(Ljava/lang/String;I)V

iload 2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 18

ldc 1
istore 0

ldc 10
newarray int
astore 1

ldc 1
istore 7
aload 1
arraylength
istore 8
iconst_0
istore 9
loop0:
iload 9
iload 8
if_icmpge loop_end0
aload 1
iload 9
iload 7
iastore
iinc 9 1
goto loop0
loop_end0:

ldc 87
istore 10
getstatic test/k [I
ldc 2
iload 10
iastore

getstatic test/k [I
arraylength
istore 2

getstatic test/k [I
ldc 2
iaload
istore 3

ldc 4
newarray int
astore 1

ldc 5
istore 11
aload 1
arraylength
istore 12
iconst_0
istore 13
loop1:
iload 13
iload 12
if_icmpge loop_end1
aload 1
iload 13
iload 11
iastore
iinc 13 1
goto loop1
loop_end1:

ldc 2
istore 14
aload 1
ldc 3
iload 14
iastore

getstatic test/k [I
arraylength
ldc 2
imul
istore 3

getstatic test/l [I
arraylength
newarray int
astore 4

ldc 1904
istore 15
aload 4
arraylength
istore 16
iconst_0
istore 17
loop2:
iload 17
iload 16
if_icmpge loop_end2
aload 4
iload 17
iload 15
iastore
iinc 17 1
goto loop2
loop_end2:

aload 4
ldc 1
iaload
istore 5

iload 5
invokestatic test/f1(I)I

iload 5
invokestatic test/f1(I)I

iadd
istore 3

ldc "d "
iload 2
invokestatic io/println(Ljava/lang/String;I)V

ldc "c "
iload 3
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method static public <clinit>()V
.limit stack 100
.limit locals 6

ldc 4
newarray int
putstatic test/k [I

ldc 4
istore 1
iconst_0
istore 2
loop0:
iload 2
iload 1
if_icmpge loop_end0
getstatic test/k [I
iload 2
ldc 9
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
ldc 123
iastore
iinc 5 1
goto loop1
loop_end1:

return
.end method

