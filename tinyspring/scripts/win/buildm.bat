@echo off

if defined JAVA_HOME goto findJavaFromJavaHome

echo.
echo ERROR: JAVA_HOME is not set!
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

:findJavaFromJavaHome

rd ..\..\classes /s /q 2>nul
mkdir ..\..\classes
del sources.txt /f /q 2>nul
dir /s /B ..\..\*.java > sources.txt
"%JAVA_HOME%/bin/javac" -d ..\..\classes -p ..\..\lib\guava-20.0.jar;..\..\lib\javassist-3.21.0-GA.jar;..\..\lib\reflections-0.9.10.jar @sources.txt
del sources.txt /f /q 2>nul

rd /s /q ..\..\bin 2>nul
mkdir ..\..\bin
"%JAVA_HOME%/bin/jar" -cf ..\..\bin\tinyspring.jar -C .\..\..\classes .