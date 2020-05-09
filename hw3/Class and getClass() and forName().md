Object.getClass() is used for instance of an object which means it is resolved at runtime. It only works for reference types that inherit from Object.

.class is resolved at compile time and it is static which means no instance is needed to invoke .class. It can also be used for primitive types.

Class.forName() is static method and it is resolved at runtime. It is useful for dynamically loading classes based on configuration (for instance, loading database drivers depending on the settings of a config file). It cannot be used for primitive types.	