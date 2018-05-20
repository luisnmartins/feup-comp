.class public t3
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 10

ldc 10
newarray int
astore 0

ldc 0
istore 1

loop0:

iload 1
ldc 4
ldc 4
iadd
if_icmpge loop_end0
iload 1
istore 5
aload 0
iload 1
iload 5
iastore

iload 1
ldc 1
iadd
istore 1

goto loop0
loop_end0:
ldc 10
newarray int
astore 2

aload 0
arraylength
newarray int
astore 2
aload 2
arraylength
istore 8
iconst_0
istore 9
iconst_0
istore 7
loop1:
iload 9
iload 8
if_icmpge loop_end1
aload 0
iload 7
iaload
istore 6
aload 2
iload 9
iload 6
iastore
iinc 9 1
iinc 7 1
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
istore 3

iload 3
invokestatic io/print(I)V

iload 1
ldc 1
iadd
istore 1

goto loop2
loop_end2:
return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

