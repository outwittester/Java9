hashCode() is like finding the right bucket fot the object while equals is like searching the bucket for the right element. When overriding equals(), we must oveeride hashCode() as well. Three basic principles are:

* When hashcode is invoked on the same object more than once during an execution of application, the hashCode method must consistently return the same integer. But multiple values are allowed for different executions of application.
* If two objects are equal according to equals() method, then the hashCode method on two objects must produce the same integer result.
* Although it is not required that two unequal objects have different hashCode, providing distinct integer results for unequal objects may improve the performance of the hashtables.

* Overriding both equals() and hashCode() method : when the objects are the same, it will hash to the same bucket and replace the old object with the new one with the new value but with the same key.
* Overriding only equals() method : since hashCode is not overriden, the new object will be hashed to some other bucket so even though the values of the objects are the same, they have different keys. This is incorrect.
* Overriding only hashCode method : Two objects are regarded as different but with same hashCode because equals() is not overriden, and therefore, without rules for equals, we fail to recognize the same values of two objects and thus fail to replace the old one with the new value, but to try to use the same bucket with different values so there would be an error. 