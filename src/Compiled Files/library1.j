.class public library1
.super java/lang/Object

.method public static max(II)I
.limit stack 2
.limit locals 3

iload 0
iload 1
if_icmple if_else0

iload 0
istore 2

goto if_end0

if_else0:
iload 1
istore 2

if_end0:

iload 2
ireturn
.end method

.method public static min(II)I
.limit stack 2
.limit locals 3

iload 0
iload 1
if_icmple if_else0

iload 1
istore 2

goto if_end0

if_else0:
iload 0
istore 2

if_end0:

iload 2
ireturn
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

