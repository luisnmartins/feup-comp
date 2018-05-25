.class public max1
.super java/lang/Object

.method public static max()I
.limit stack 2
.limit locals 6

invokestatic io/read()I

istore 0

invokestatic io/read()I

istore 1

invokestatic io/read()I

istore 2

invokestatic io/read()I

istore 3

invokestatic io/read()I

istore 4

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

ldc "max "
iload 5
invokestatic io/print(Ljava/lang/String;I)V

iload 5
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 1
.limit locals 2

invokestatic max1/max()I

istore 0

return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

