.class public gen_code1
.super java/lang/Object

.field static arr [I 

.method public static func(I)I
.limit stack 5
.limit locals 4

loop0:

iload_0
getstatic gen_code1/arr [I
arraylength
if_icmpge loop_end0
getstatic gen_code1/arr [I
iload_0
getstatic gen_code1/arr [I
iload_0
iaload
iload_0
iadd
iastore

getstatic gen_code1/arr [I
iload_0
iaload
istore_2

iload_2
invokestatic io/println(I)V

iinc 0 1

goto loop0
loop_end0:
iload_0
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 3
.limit locals 6

ldc "Indique um numero: "
invokestatic io/println(Ljava/lang/String;)V

invokestatic io/read()I

istore_0

ldc "h: "
iload_0
invokestatic io/println(Ljava/lang/String;I)V

loop1:

iload_0
iconst_2
if_icmple loop_end1
iload_0
iconst_4
if_icmpne if_else0

loop2:

iload_0
bipush 8
if_icmpge loop_end2
iinc 0 1

goto loop2
loop_end2:
iconst_0
istore_0

ldc ":o"
invokestatic io/println(Ljava/lang/String;)V

goto if_end0

if_else0:
iload_0
iconst_5
if_icmpne if_else1

ldc "HI"
iload_0
invokestatic io/println(Ljava/lang/String;I)V

goto if_end1

if_else1:
ldc "TWITTER"
invokestatic io/println(Ljava/lang/String;)V

if_end1:

if_end0:

iinc 0 -1

goto loop1
loop_end1:
bipush 8
istore_3
getstatic gen_code1/arr [I
arraylength
istore 4
iconst_0
istore 5
loop3:
iload 5
iload 4
if_icmpge loop_end3
getstatic gen_code1/arr [I
iload 5
iload_3
iastore
iinc 5 1
goto loop3
loop_end3:

iconst_0
istore_1

iload_1
invokestatic gen_code1/func(I)I

istore_1

ldc "i: "
iload_1
invokestatic io/println(Ljava/lang/String;I)V

return
.end method

.method static public <clinit>()V
.limit stack 1
.limit locals 1

bipush 10
newarray int
putstatic gen_code1/arr [I

return
.end method

