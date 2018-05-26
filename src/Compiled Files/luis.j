.class public luis
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 4

iconst_1
istore_0

bipush 10
newarray int
astore_1

iconst_1
istore_2

iload_0
iconst_1
if_icmpne if_end0

iconst_2
istore_2

if_end0:

iload_2
iconst_1
iadd
istore_0

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

