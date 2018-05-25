.class public t3
.super java/lang/Object

.field static v [I 

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 13

ldc 10
newarray int
astore 0

ldc 30
newarray int
putstatic t3/v [I

ldc 0
istore 1

loop0:

iload 1
ldc 4
ldc 4
iadd
if_icmpge loop_end0
iload 1
istore 8
getstatic t3/v [I
iload 1
iload 8
iastore

iload 1
ldc 1
iadd
istore 1

goto loop0
loop_end0:
ldc 40
newarray int
astore 2

getstatic t3/v [I
astore 2
ldc 20
newarray int
astore 0

ldc 1
istore 9
aload 0
ldc 4
iload 9
iastore

aload 2
ldc 4
iaload
istore 3

aload 0
ldc 4
iaload
istore 4

iload 3
invokestatic io/println(I)V

iload 4
invokestatic io/println(I)V

ldc 10
newarray int
astore 5

ldc 3
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

ldc 0
istore 1

loop2:

iload 1
aload 2
arraylength
if_icmpge loop_end2
aload 2
iload 1
iaload
istore 6

iload 6
invokestatic io/print(I)V

iload 1
ldc 1
iadd
istore 1

goto loop2
loop_end2:
invokestatic t3/f1()V

return
.end method

.method public static f1()V
.limit stack 2
.limit locals 1

getstatic t3/v [I
ldc 20
iaload
istore 0

iload 0
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 3
.limit locals 3

ldc 10
newarray int
putstatic t3/v [I

ldc 10
istore 1
iconst_0
istore 2
loop0:
iload 2
iload 1
if_icmpge loop_end0
getstatic t3/v [I
iload 2
ldc 99999
iastore
iinc 2 1
goto loop0
loop_end0:

return
.end method

