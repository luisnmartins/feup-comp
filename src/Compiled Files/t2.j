.class public t2
.super java/lang/Object

.field static t1 I = 8

.field static l [I 

.method public static sqrt(I)I
.limit stack 2
.limit locals 13

iload_0
istore_1

iconst_0
istore_2

iconst_0
istore_3

iconst_0
istore 4

iconst_0
istore 5

loop0:

iload 5
bipush 6
if_icmpge loop_end0
iload_2
iload_3
iadd
istore 6

iload 6
iconst_2
ishl
istore 7

iload 7
iconst_1
ior
istore 8

iload_3
iconst_1
ishl
istore 9

iload 4
iconst_2
ishl
istore 10

iload_1
bipush 10
ishr
istore 11

iload 11
iconst_3
iand
istore 12

iload 10
iload 12
ior
istore 4

iinc 1 2

iload 8
iload 4
if_icmpgt if_else0

iload 9
iconst_1
ior
istore_3

iload 8
istore_2

goto if_end0

if_else0:
iload 9
istore_3

iinc 2 2

if_end0:

iinc 5 1

goto loop0
loop_end0:
iload_3
ireturn
.end method

.method public static ka()V
.limit stack 0
.limit locals 0

return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 8

bipush 17
invokestatic t2/sqrt(I)I

istore_0

iload_0
invokestatic io/println(I)V

invokestatic io/read()I

istore_1

invokestatic t2/ka()V

bipush 10
newarray int
astore_2

bipush 10
newarray int
astore_3

iconst_0
istore 4

loop1:

iload 4
aload_2
arraylength
if_icmpge loop_end1
aload_2
iload 4
iload 4
iastore

iinc 4 1

goto loop1
loop_end1:
aload_3
astore_3
iconst_0
istore 4

loop2:

iload 4
aload_3
arraylength
if_icmpge loop_end2
aload_3
iload 4
iaload
istore 5

iload 5
invokestatic io/print(I)V

iinc 4 1

goto loop2
loop_end2:
return
.end method

.method static public <clinit>()V
.limit stack 1
.limit locals 1

bipush 10
newarray int
putstatic t2/l [I

return
.end method

