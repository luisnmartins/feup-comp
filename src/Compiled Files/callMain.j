.class public callMain
.super java/lang/Object

.field static x I = 1

.method public static f()V
.limit stack 2
.limit locals 0

getstatic callMain/x I
iconst_0
if_icmple if_end0

getstatic callMain/x I
iconst_1
isub
putstatic callMain/x I

aconst_null
invokestatic callMain/main([Ljava/lang/String;)V

if_end0:

return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 1

ldc "Call main"
invokestatic io/println(Ljava/lang/String;)V

invokestatic callMain/f()V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

