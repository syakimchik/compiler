@echo off
MD Result

java -jar Compiler.jar %1
java -jar lib/jasmin.jar %~n1.j
"c:\Program Files\Java\jdk1.7.0\bin\jar" cvfe %~n1.jar %~n1 %~n1.class

del %~n1.class
del %~n1.j
move %~n1.jar Result