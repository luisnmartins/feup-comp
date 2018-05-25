.class public array1
.super java/lang/Object

.method public static print_array(I[II)V
.limit stack 3
.limit locals 7

ldc 7
istore 5
aload 1
ldc 3
iload 5
iastore

ldc 0
istore 3

loop0:

iload 3
iload 0
if_icmpge loop_end0
iload 3
istore 6
aload 1
iload 3
iload 6
iastore

iload 3
ldc 1
iadd
istore 3

goto loop0
loop_end0:
ldc 0
istore 3

loop1:

iload 3
iload 0
if_icmpge loop_end1
aload 1
iload 3
iaload
istore 4

ldc "a: "
iload 4
invokestatic io/print(Ljava/lang/String;I)V

iload 3
ldc 1
iadd
istore 3

goto loop1
loop_end1:
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 2

ldc 10
newarray int
astore 0

ldc 10
aload 0
ldc 4
invokestatic array1/print_array(I[II)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

