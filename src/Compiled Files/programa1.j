.class public programa1
.super java/lang/Object

.field static data [I 

.field static mx I
.field static mn I
.method public static f1([I)I
.limit stack 1
.limit locals 2

bipush 7
istore_1

iload_1
ireturn
.end method

.method public static det([I)V
.limit stack 2
.limit locals 6

aload_0
invokestatic programa1/f1([I)I

istore_1

iconst_0
istore_2

aload_0
arraylength
iconst_1
isub
istore_3

loop0:

iload_2
iload_3
if_icmpge loop_end0
aload_0
iload_2
iaload
istore 4

iload_2
iconst_1
iadd
istore_2

aload_0
iload_2
iaload
istore 5

iload 4
iload 5
invokestatic library1/max(II)I

putstatic programa1/mx I

iload 4
iload 5
invokestatic library1/min(II)I

putstatic programa1/mn I

goto loop0
loop_end0:
return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 1

getstatic programa1/data [I
invokestatic programa1/det([I)V

ldc "max: "
getstatic programa1/mx I
invokestatic io/println(Ljava/lang/String;I)V

ldc "min: "
getstatic programa1/mn I
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method static public <clinit>()V
.limit stack 3
.limit locals 3

bipush 100
newarray int
putstatic programa1/data [I

bipush 100
istore_1
iconst_0
istore_2
loop0:
iload_2
iload_1
if_icmpge loop_end0
getstatic programa1/data [I
iload_2
sipush 1904
iastore
iinc 2 1
goto loop0
loop_end0:

return
.end method

