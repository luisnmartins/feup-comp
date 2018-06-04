.class public t6
.super java/lang/Object

.field static n [I 

.method public static avg(IIII)V
.limit stack 0
.limit locals 4

return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 5

bipush 7
istore_0

iconst_0
istore_1

getstatic t6/n [I
iconst_2
bipush 8
iastore

getstatic t6/n [I
iconst_2
iaload
istore_2

iload_2
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 1
.limit locals 1

bipush 10
newarray int
putstatic t6/n [I

return
.end method

