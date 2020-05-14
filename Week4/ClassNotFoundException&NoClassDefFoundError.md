## ClassNotFoundException vs NoClassDefFoundError

ClassNotFoundException is a runtime Exception, and it is thrown when an application tries to load a class at running using Class.forName() or loadClass() or findSystemClass() methods, and the class with the specific name is not found in the class path, or you have not updated the class path with the required JAR files.

NoClassDefFoundError is an error that is thrown during the runtime, when the application trying to load the class but the class definition is no longer available. After the compilation, there will be .class files, if you remove some .class files, you will get this error. This errors happend when a class definition presents at the compile time but missing at the runtime.