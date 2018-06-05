.class public nestedBranch
.super java/lang/Object

.method public static sign(I)I
.limit stack 2
.limit locals 2

iload_0
iconst_0
if_icmpge if_else0

iconst_m1
istore_1

goto if_end0

if_else0:
iload_0
iconst_0
if_icmpne if_else1

iconst_0
istore_1

goto if_end1

if_else1:
iconst_1
istore_1

if_end1:

if_end0:

iload_0
bipush 9
if_icmpne if_end2

if_end2:

iload_1
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 3

iconst_m1
istore_0

iload_0
invokestatic nestedBranch/sign(I)I

istore_1

iload_1
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

