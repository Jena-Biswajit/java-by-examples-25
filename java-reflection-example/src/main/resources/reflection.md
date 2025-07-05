### Reflection

- It allows to inspect and manipulate classes , method , constructor , interfaces , and fields at run time .
- In order to reflect a class we first need create an object of class . From the classes you can obtain information about.
- Class Name ,Class Modifies (public, private, synchronized etc.) ,Package Info ,Superclass ,Implemented Interfaces ,Constructors ,Methods ,Fields .
- There are different way to achieve this i.e
  - 1) Using .Class extension
  - 2) Using getClass() method
  - 3) Using forName() method

- The forName() method of java.lang.Class class is used to get the instance of this Class with the specified class name. 
- This class name is specified as the string parameter.
**Syntax :**
  - public static Class<T> forName(String className) throws ClassNotFoundException
  
**Example**

```
// class name using forName()
Cat cat = new Cat();
Class object1 = Class.forName("com.example.app.Cat");
System.out.println(object1);

//class :
class Cat extends Animal{
    public void skinColor(){
        System.out.println("my skin color is black");
    }
}

o/p : class com.example.app.Cat
```
### For Classes :
- getName() returns the name of the class 
- getModifiers() - returns the access modifier of the class in integer form 
- getSuperClass() - returns the superclass of the class 

### The Class Object :
- All types in Java including the primitive types (int, long, float etc.) including arrays have an associated Class object.
- If you don't know the name at compile time, but have the class name as a string at runtime, you can do like this:
- String className = ... //obtain class name as string at runtime Class class = Class.forName(className);
- When using the Class.forName() method you must supply the fully qualified class name.
- The Class.forName() method may throw a ClassNotFoundException if the class cannot be found on the classpath at runtime.

**Modifiers :**
- You can access the modifiers of a class via the Class object. 
- The class modifiers are the keywords "public", "private", "static" etc. You obtain the class modifiers like this:

**Example**
```java
package com.example.app;

import java.lang.reflect.Modifier;

// get access modifier of the class
public class App3 {
  public static void main(String[] args) {
    UtkalUniversity university = new UtkalUniversity();
    Class institute = UtkalUniversity.class;
    int modifier = institute.getModifiers();
    System.out.println(Modifier.toString(modifier));
  }
}
class Institute{
  public void university(){
    System.out.println("UGC");
  }
}

package com.example.app;

public class UtkalUniversity extends Institute {
  public void subUniversity() {
    System.out.println("utkal university is under ugc ");
  }
}

// 0/p : public
```
### Implemented Interfaces
- A class can implement many interfaces. Therefore an array of Class is returned. 
- Interfaces are also represented by Class objects in Java Reflection.

**Note**
- Only the interfaces specifically declared implemented by a given class is returned
-  If a superclass of the class implements an interface, but the class doesn't specifically state that it also implements that interface, that interface will not be returned in the array.
- Even if the class in practice implements that interface, because the superclass does.

**Example**
```
package com.example.app;

import java.lang.reflect.Method;

public class App4 {
    public static void main(String[] args) {
        PublicRight publicRight = new PublicRight();
        Class implementedInterface = PublicRight.class;
        Class[] interfaces = implementedInterface.getInterfaces();
        for (Class interface1 : interfaces){
            System.out.println(interface1.getName());
        }

    }
}
interface Vehicle{
}
interface Institution{
}
interface Constitution{
}
class PublicRight implements Vehicle,Institution,Constitution{

}

// o/p : 
com.example.app.Vehicle
com.example.app.Institution
com.example.app.Constitution
```

