## Importance of Hashcode method in Java and the difference between equals() and hashCode()
HashMap and HashSet use hashing to manipulate data. They use hashCode() method to check hash values. The default implementation of hashCode() in Object class returns distinct integers for different objects.

equals() : This method checks if some other object passed to it as an argument is equal the object in which this method is invoked. Hash code value: o1.equals(o2) implies o1.hashCode() == o2.hashCode() . If you define a equals() method then you must define a hashCode() method as well. Also it means that if you have two objects that are equal then they must have the same hashCode, however the reverse is not true.

hashCode(): This method returns a hashCode() value as an Integer and is supported for the benefit of hashing based java.util.Collection classes like Hashtable, HashMap, HashSet etc. If a class overrides the equals() method, it must implement the hashCode() method as well.
