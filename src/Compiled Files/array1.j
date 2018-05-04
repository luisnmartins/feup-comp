.class public array1
.super java/lang/Object

.method public static print_array(I[II)V
.limit stack 100
.limit locals 4

istore 5
aload 1
bipush 3
iload 5
iastore
bipush 0
istore 3

istore 3

bipush 0
istore 3

istore 3

return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 2

istore 3
istore 4
iconst_0
istore 5
loop:
iload 5
iload 4
if_icmpge loop_end
getstatic array1/a [I
iload 5
bipush null
iastore
iinc 5 1
goto loop
loop_end:
return

bipush 10
bipush 4
invokestatic array1/print_array(I[II)V

return
.end method

