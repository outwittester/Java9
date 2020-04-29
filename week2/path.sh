#!/bin/bash

FILE1=$1

#echo "$FILE1"

javac getPath.java

#use sh path.sh python or sh path.sh java to get the path

if [ $FILE1 = 'java' ]
then
    java_path=$(which java)
 #   echo "$java_path"
    java getPath "$java_path"

elif [ $FILE1 = 'python' ]
then
    python_path=$(which python)
 #   which python
    java getPath "$python_path"
fi
