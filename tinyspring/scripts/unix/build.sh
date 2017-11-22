rm -rf ./../../classes
mkdir ./../../classes
javac -d ../../classes -cp ../../lib/guava-20.0.jar:../../lib/javassist-3.21.0-GA.jar:../../lib/reflections-0.9.10.jar $(find ./../../ -name "*.java")

rm -rf ./../../bin
mkdir ../../bin
jar -cf ../../bin/tinyspring.jar -C ./../../classes .