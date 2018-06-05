.class public t6
.super java/lang/Object

.method public static avg(IIII)I
.limit stack 1
.limit locals 5

iconst_4
istore 4

iload 4
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 3

iconst_4
istore_0

bipush 7
istore_1

iload_0
invokestatic io/println(I)V

loop0:

iload_0
iconst_2
if_icmple loop_end0
loop1:

iload_0
bipush 8
if_icmpge loop_end1
loop2:

iload_0
bipush 7
if_icmpge loop_end2
iinc 0 1

loop3:

iload_0
bipush 6
if_icmpge loop_end3
iinc 0 1

iload_0
invokestatic io/println(I)V

goto loop3
loop_end3:
goto loop2
loop_end2:
iload_0
invokestatic io/println(I)V

goto loop1
loop_end1:
goto loop0
loop_end0:
loop4:

iload_0
bipush 6
if_icmpge loop_end4
iload_0
invokestatic io/println(I)V

goto loop4
loop_end4:
return
.end method

.method static public <clinit>()V
.limit stack 0
.limit locals 0

return
.end method

