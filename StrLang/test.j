.class public test
.super java/lang/Object
  .method public static func()V
  .limit locals 100
  .limit stack 20
    ldc ""
    astore 0
    new java/lang/Integer
    dup
    ldc 12
    invokenonvirtual java/lang/Integer/<init>(I)V
    invokevirtual java/lang/Integer.toString()Ljava/lang/String;
    astore 0
    ldc ""
    astore 1
    new java/lang/Integer
    dup
    ldc 15
    invokenonvirtual java/lang/Integer/<init>(I)V
    invokevirtual java/lang/Integer.toString()Ljava/lang/String;
    astore 1
    new java/lang/StringBuilder
    dup
    aload 0
    invokestatic java/lang/String.valueOf(Ljava/lang/Object;)Ljava/lang/String;
    invokespecial java/lang/StringBuilder.<init>(Ljava/lang/String;)V
    aload 1
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    astore 2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 2
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
    return
  .end method

	.method public static main([Ljava/lang/String;)V
	.limit locals 100
	.limit stack 20
	  ldc ""
	  astore 0
	  ldc "19"
	  astore 0
	  ldc ""
	  astore 1
	  ldc "92"
	  astore 1
	  new java/lang/StringBuilder
	  dup
	  aload 0
	  invokestatic java/lang/String.valueOf(Ljava/lang/Object;)Ljava/lang/String;
	  invokespecial java/lang/StringBuilder.<init>(Ljava/lang/String;)V
	  aload 1
	  invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
	  invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
	  astore 3
	  getstatic java/lang/System/out Ljava/io/PrintStream;
	  aload 3
	  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	  ldc ""
	  astore 0
	  ldc "19"
	  astore 0
	  ldc ""
	  astore 1
	  ldc "91"
	  astore 1
	  ldc ""
	  astore 6
	  new java/lang/StringBuilder
	  dup
	  ldc "I born in "
	  invokestatic java/lang/String.valueOf(Ljava/lang/Object;)Ljava/lang/String;
	  invokespecial java/lang/StringBuilder.<init>(Ljava/lang/String;)V
	  new java/lang/StringBuilder
	  dup
	  aload 0
	  invokestatic java/lang/String.valueOf(Ljava/lang/Object;)Ljava/lang/String;
	  invokespecial java/lang/StringBuilder.<init>(Ljava/lang/String;)V
	  aload 1
	  invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
	  invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
	  invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
	  invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
	  astore 5
	  aload 5
	  astore 4
	  getstatic java/lang/System/out Ljava/io/PrintStream;
	  aload 4
	  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
	  invokestatic test/func()V
	  return
	.end method