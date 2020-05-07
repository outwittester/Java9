## What is the difference between .Class, forName() and getClass()

MyClass.Class: works at the compile time.

obj.getClass(): works at the runtime. It is called by the object.

Class.forName(): works at the runtime. It will dynamically load the class to the memory and initialize it. forName() is usually used in reflection.