## In Java, what is the difference between .getclass() and .forName()?
.getclass() : It’s the runtime class of of the Object on which it is invoked. If an instance of an object is available, then the simplest way to get its Class is to invoke Object.getClass().

.forName() : It’s the Class object associated with the class or interface.  A call to Class.forName() causes the class to be dynamically loaded (at runtime). A call to forName() causes the class to be initialized (eg. JVM executes all its static block after class loading).
