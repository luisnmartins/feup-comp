.class public max_array
.super java/lang/Object

.method public static maxarray([I)I
.limit stack 3
.limit locals 3

aload 0
ldc 0
iaload
istore 1

ldc 1
istore 2

loop0:

iload 2
aload 0
arraylength
if_icmpge loop_end0
iload 1
aload 0
iload 2
iaload
if_icmpge if_end0

aload 0
iload 2
iaload
istore 1

if_end0:

iload 2
ldc 1
iadd
istore 2

goto loop0
loop_end0:
ldc "max: "
iload 1
invokestatic io/print(Ljava/lang/String;I)V

iload 1
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 5

ldc 10
newarray int
astore 0

ldc 0
istore 1

loop0:

iload 1
ldc 10
if_icmpge loop_end0
iload 1
istore 4
aload 0
iload 1
iload 4
iastore

iload 1
ldc 1
iadd
istore 1

goto loop0
loop_end0:
aload 0
invokestatic max_array/maxarray([I)I

istore 2

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

