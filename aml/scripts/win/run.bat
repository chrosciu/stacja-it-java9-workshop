@echo off

if defined JAVA_HOME goto main

echo.
echo ERROR: JAVA_HOME is not set!
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

:main

"%JAVA_HOME%\bin\java" -jar ..\..\bin\aml.jar