#!/bin/bash
javac ChopLast.java
args=("$@")
echo `which ${args[0]}`
address=$(which ${args[0]})
java ChopLast "$address"
output=$(java ChopLast "$address")
cd "$output"

