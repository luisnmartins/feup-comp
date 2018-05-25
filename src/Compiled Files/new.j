.class public new
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 7

ldc 1
istore 0

ldc 10
newarray int
astore 1

ldc 1
istore 4
aload 1
arraylength
istore 5
iconst_0
istore 6
loop0:
iload 6
iload 5
if_icmpge loop_end0
aload 1
iload 6
iload 4
iastore
iinc 6 1
goto loop0
loop_end0:

aload 1
ldc 4
iaload
istore 2

iload 2
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

