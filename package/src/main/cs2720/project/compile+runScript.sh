#!/bin/bash

echo "Compiling java files..."
javac -d bin ./src/main/cs2720/project/*.java  

echo "Executing driver file"
java -cp bin main.cs2720.project.SortingDriver 

#echo "Executing driver file: double data type"
#java -cp bin main.cs2720.project.BinaryTreeDriver ./src/main/cs2720/project/double-input.txt

#echo "Executing driver file: string data type"
#java -cp bin main.cs2720.project.BinaryTreeDriver ./src/main/cs2720/project/string-input.txt
