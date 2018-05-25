.class public nestedBranch
.super java/lang/Object

.method public static sign(I)I
.limit stack 2
.limit locals 2

iload_0
iconst_0
if_icmpge if_else0

bipush -1
istore_1

goto if_end0

if_else0:
iload_0
iconst_0
if_icmpne if_else0

iconst_0
istore_1

goto if_end0

if_else0:
iconst_1
istore_1

if_end0:

if_end0:

iload_1
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 2

bipush 4
invokestatic nestedBranch/sign(I)I

istore_0

iload_0
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

