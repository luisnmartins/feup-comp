.class public max
.super java/lang/Object

.method public static max(IIIII)I
.limit stack 2
.limit locals 6

iload_0
istore 5

iload 5
iload_1
if_icmpge if_end0

iload_1
istore 5

if_end0:

iload 5
iload_2
if_icmpge if_end1

iload_2
istore 5

if_end1:

iload 5
iload_3
if_icmpge if_end2

iload_3
istore 5

if_end2:

iload 5
iload 4
if_icmpge if_end3

iload 4
istore 5

if_end3:

iload 5
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 5
.limit locals 2

iconst_1
iconst_2
iconst_3
iconst_4
iconst_3
invokestatic max/max(IIIII)I

istore_0

iload_0
invokestatic io/println(I)V

iconst_1
bipush 6
iconst_3
iconst_4
iconst_5
invokestatic max/max(IIIII)I

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

