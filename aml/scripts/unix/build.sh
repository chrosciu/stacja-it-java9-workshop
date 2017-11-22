rm -rf ./../../classes
mkdir ./../../classes
javac -d ../../classes -cp ../../../tinyspring/bin/tinyspring.jar $(find ./../../ -name "*.java")

rm -rf ./../../bin
mkdir ../../bin

mkdir ../../bin/lib
cp ../../../tinyspring/bin/tinyspring.jar ../../bin/lib
cp ../../../tinyspring/lib/*.jar ../../bin/lib

jar -cfme ../../bin/aml.jar MANIFEST.MF it.stacja.java9.aml.app.AntiMoneyLaunderingSystem -C ./../../classes .