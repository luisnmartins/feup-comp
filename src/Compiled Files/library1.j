.class public library1
.super java/lang/Object

.method public static max(II)I
.limit stack 2
.limit locals 3

iload_0
iload_1
if_icmple if_else0

iload_0
istore_2

goto if_end0

if_else0:
iload_1
istore_2

if_end0:

iload_2
ireturn
.end method

.method public static min(II)I
.limit stack 2
.limit locals 3

iload_0
iload_1
if_icmple if_else1

iload_1
istore_2

goto if_end1

if_else1:
iload_0
istore_2

if_end1:

iload_2
ireturn
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

