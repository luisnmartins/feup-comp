.class public new1
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 7

iconst_1
istore_0

bipush 10
newarray int
astore_1

iconst_1
istore 4
aload_1
arraylength
istore 5
iconst_0
istore 6
loop0:
iload 6
iload 5
if_icmpge loop_end0
aload_1
iload 6
iload 4
iastore
iinc 6 1
goto loop0
loop_end0:

aload_1
bipush 4
iaload
istore_2

iload_2
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

