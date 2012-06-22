@echo off
MD Result

java -jar Compiler.jar %1
if not exist %~n1.j goto end

java -jar lib/jasmin.jar %~n1.j
if not exist %~n1.class goto end
"c:\Program Files\Java\jdk1.7.0\bin\jar" cvfe %~n1.jar %~n1 %~n1.class

del %~n1.class
del %~n1.j
move %~n1.jar Result

CD Result

@echo Start program:
java -Dfile.encoding=Cp866 -jar %~n1.jar
: end