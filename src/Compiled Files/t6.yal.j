.method public static avg(IIII)I
.limit stack 1
.limit locals 5

iconst_4
istore 4

iload 4
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 8

iconst_4
istore 5
getstatic t6/a [I
arraylength
istore 6
iconst_0
istore 7
loop0:
iload 7
iload 6
if_icmpge loop_end0
getstatic t6/a [I
iload 7
iload 5
iastore
iinc 7 1
goto loop0
loop_end0:

iconst_0
istore_0

loop1:

iload_0
getstatic t6/a [I
arraylength
if_icmpge loop_end1
getstatic t6/a [I
iload_0
iaload
istore_1

iload_1
invokestatic io/println(I)V

goto loop1
loop_end1:
iconst_4
istore_2

bipush 7
istore_3

iload_2
invokestatic io/println(I)V

loop2:

iload_2
iconst_2
if_icmple loop_end2
loop3:

iload_2
bipush 8
if_icmpge loop_end3
loop4:

iload_2
bipush 7
if_icmpge loop_end4
iinc 2 1

loop5:

iload_2
bipush 6
if_icmpge loop_end5
iinc 2 1

iload_2
invokestatic io/println(I)V

goto loop5
loop_end5:
goto loop4
loop_end4:
iload_2
invokestatic io/println(I)V

goto loop3
loop_end3:
goto loop2
loop_end2:
loop6:

iload_2
bipush 6
if_icmpge loop_end6
iload_2
invokestatic io/println(I)V

goto loop6
loop_end6:
return
.end method

.method static public <clinit>()V
.limit stack 1
.limit locals 1

bipush 10
newarray int
putstatic t6/a [I

return
.end method

