@echo off
set JLINK_VM_OPTIONS=
set DIR=%~dp0
"%DIR%\java" %JLINK_VM_OPTIONS% -m aml/it.stacja.java9.aml.app.AntiMoneyLaunderingSystem %*
