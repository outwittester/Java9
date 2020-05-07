## Why we need HashCode function, what is the different between hashcode and equals?

hashCode() return the hashcode of the object. equals() return the boolean value of whether the two objects are equal.

When we are using self-defined class, and add objects of the self-defined class to the HashSet, HashMap or HashTable. We need to rewrite the hashCode() and equals() methods.

The elements in the HashSet, HashMap or HashTable are unique. Take HashSet as an example, each time we add an object to a set, we need to check if the object is already in the set. Firtly we check the hashCode(), because it is the fast. If the two objects have different hashcodes, they are different, we do not need to use equals method and we could safely add it to the set. However, two different objects might share the same hashcode, so when the hashcodes of the two objects are the same, we need to use the equals function to check whether they are the same object or not. That's why when we rewrite the hashCode method for the self-defined class, we also need to rewrite the equals method.