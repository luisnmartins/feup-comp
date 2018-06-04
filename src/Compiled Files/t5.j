.class public t5
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 3

iconst_0
istore_0

iconst_0
istore_1

iload_0
bipush 7
if_icmpge if_else0

iload_0
iconst_3
if_icmpge if_end0

bipush 4
istore_1

if_end0:

goto if_end0

if_else0:
bipush 7
istore_1

if_end0:

iload_1
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

