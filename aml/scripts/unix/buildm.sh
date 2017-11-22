rm -rf ./../../classes
mkdir ./../../classes
javac -d ../../classes -p ../../../tinyspring/bin/tinyspring.jar $(find ./../../ -name "*.java")

rm -rf ./../../bin
mkdir ./../../bin

mkdir ../../bin/lib
cp ../../../tinyspring/bin/tinyspring.jar ../../bin/lib
cp ../../../tinyspring/lib/*.jar ../../bin/lib

jar -cfe ../../bin/aml.jar it.stacja.java9.aml.app.AntiMoneyLaunderingSystem -C ./../../classes .
