.class public maxmin
.super java/lang/Object

.method public static maxmin()I
.limit stack 2
.limit locals 1

invokestatic io/read()I

istore_0

iload_0
iconst_0
if_icmpge if_else0

loop0:

iload_0
iconst_0
if_icmpge loop_end0
iload_0
iconst_1
iadd
istore_0

goto loop0
loop_end0:
goto if_end0

if_else0:
loop1:

iload_0
iconst_0
if_icmple loop_end1
iload_0
iconst_1
isub
istore_0

goto loop1
loop_end1:
if_end0:

ldc "a"
iload_0
invokestatic io/println(Ljava/lang/String;I)V

iload_0
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 2

invokestatic maxmin/maxmin()I

istore_0

ldc "a="
iload_0
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

