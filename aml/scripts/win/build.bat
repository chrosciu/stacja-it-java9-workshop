@echo off

if defined JAVA_HOME goto main

echo.
echo ERROR: JAVA_HOME is not set!
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

:main

rd ..\..\classes /s /q 2>nul
mkdir ..\..\classes
del sources.txt /f /q 2>nul
dir /s /B ..\..\*.java > sources.txt
"%JAVA_HOME%\bin\javac" -d ..\..\classes -cp ..\..\..\tinyspring\bin\tinyspring.jar @sources.txt
del sources.txt /f /q 2>nul

rd ..\..\bin /s /q 2>nul
mkdir ..\..\bin

mkdir ..\..\bin\lib
xcopy "..\..\..\tinyspring\bin\tinyspring.jar" "..\..\bin\lib"
xcopy "..\..\..\tinyspring\lib\*.jar" "..\..\bin\lib"

"%JAVA_HOME%/bin/jar" -cfme ..\..\bin\aml.jar MANIFEST.MF it.stacja.java9.aml.app.AntiMoneyLaunderingSystem -C ..\..\classes .