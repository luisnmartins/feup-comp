.class public t4
.super java/lang/Object

.method public static f1(IIII)I
.limit stack 2
.limit locals 5

iload_0
iload_1
iadd
istore 4

iload 4
iload_2
iadd
istore 4

iload 4
iload_3
iadd
istore 4

iload 4
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 5
.limit locals 3

bipush 10
newarray int
astore_0

aload_0
iconst_1
iaload
iconst_1
iconst_2
iconst_3
bipush 4
invokestatic t4/f1(IIII)I

iadd
istore_1

iload_1
invokestatic io/print(I)V

iload_1
aload_0
iconst_2
iaload
if_icmpge if_end0

if_end0:

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

