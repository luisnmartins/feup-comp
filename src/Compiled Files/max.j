.class public max
.super java/lang/Object

.method public static max(IIIII)I
.limit stack 2
.limit locals 6

iload 0
istore 5

iload 5
iload 1
if_icmpge if_end0

iload 1
istore 5

if_end0:

iload 5
iload 2
if_icmpge if_end1

iload 2
istore 5

if_end1:

iload 5
iload 3
if_icmpge if_end2

iload 3
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

ldc 1
ldc 2
ldc 3
ldc 4
ldc 3
invokestatic max/max(IIIII)I

istore 0

iload 0
invokestatic io/println(I)V

ldc 1
ldc 6
ldc 3
ldc 4
ldc 5
invokestatic max/max(IIIII)I

istore 0

iload 0
invokestatic io/println(I)V

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

