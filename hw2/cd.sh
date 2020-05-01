javac ChopLast.java
args=("$@")
address=$(which ${args[0]})
java ChopLast "$address"
result=$(java ChopLast "$address")
echo `${result}`
cd "$result"
