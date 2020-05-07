#!/bin/zsh
javac chopLast.java
args=("$@")
address = $(which ${args[0]})
java chopLast "$address"
output=$(java chopLast "$address")
echo `$(output)`
cd "$result"
