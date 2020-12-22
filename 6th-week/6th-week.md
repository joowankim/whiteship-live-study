# 자바의 상속에 대해 학습하세요

## 자바 상속의 특징

### 상속

한 클래스의 멤버(fields & methods & nested class)를 다른 클래스가 물려받는 것.

### 상속의 구성요소

1. 멤버를 **물려주는** 클래스: *superclass*(*base class* or *parent class*)
2. 멤버를 **물려받는** 클래스: *subclass*(*derived class* or *child class*)

### 자바에서의 상속

1. `Object` 클래스는 *superclass*를 가지지 않는다.
2. `Object`를 제외한 모든 클래스는 단 하나의 *superclass*를 가진다.
3. *superclass*가 보이지 않는 클래스는 `Object` 클래스를 이미 상속하고 있다.
4. 따라서 `Object` 클래스를 제외한 모든 클래스는 `Object` 클래스의 *descendants*라고 할 수 있다.
5. *superclass*의 멤버는 *subclass*에 상속된다.
   - 접근 제어자에 따라서 달라진다.
6. **생성자**는 멤버가 아니기에 *subclass*에 상속되지 않는다.
7. 하지만 *superclass*의 생성자는 *subclass*에서 호출할 수 있다.

## super 키워드

오라클 공식 문서에서 소개된 `super` 키워드의 역할은 두가지이다.

1. *superclass* 멤버에 접근

    ```java
   /* SuperClass.java */
    public class SuperClass {
        public void printMethod() {
            System.out.println("Printed in Superclass.");
        }
    }

    /* SubClass.java */
    public class SubClass extends Superclass {
        public void printMethod() {
            super.printMethod();
            System.out.println("Printed in Subclass.");
        }
    }

    /* App.java */
    public final class App {
        private App() {
        }

        /**
         * Says hello to the world.
         * @param args The arguments of the program.
         */
        public static void main(String[] args) {
            SubClass s = new SubClass();
            s.printMethod();
        }
    }
    
    //>> Printed in Superclass.
    //>> Printed in Subclass.
    ```

2. *superclass*의 생성자 호출

    ```java
    public MountainBike(int startHeight, 
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }   
    ```

---
[Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)

## 메소드 오버라이딩

1. 클래스는 instance 메소드와 static 메소드를 가질 수 있다.
2. 인터페이스 또한 default 메소드를 가지며 클래스는 이를 오버라이딩할 수 있다.
3. *superclass*의 메소드를 오버라이드하는 메소드는 *superclass*의 메소드와 **같은 메소드 명**, **같은 파라미터 타입과 갯수**, **같은 반환 타입**을 가진다.

### instance 메소드 오버라이딩

instance 메소드에 대한 오버라이딩에서는 **공변 반환 타입**을 반환 타입으로 설정할 수 있다.

> 공변 반환 타입을 반환 타입으로 설정할 수 있다는 말은 *superclass*를 상속 받는 *subclass*를 반환 타입으로 지정할 수 있다는 뜻이다.

그리고 `@Override` 어노테이션을 통해 컴파일러에 오버라이딩을 알릴 수 있다.

### static 메소드 오버라이딩(hiding)

static 메소드에 대한 오버라이딩은 **hiding**이라는 말로 정의된다.

> 런타임에 생성된 인스턴스의 메소드가 호출되지 않고 **컴파일 시에 선언된 객체의 메소드가 호출되는 static 메소드**에 대해서는 다형성이 적용되지 않는다.

```java
public class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}

public class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Animal myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();       // 1.
        myAnimal.testInstanceMethod();  // 2.
    }
}

//>> The static method in Animal
//>> The instance method in Cat
```

1. `myAnimal` 객체로 `testClassMethod()`를 호출할 수 없다.
   - 호출할 때 참조되는 클래스에 따라서 `testClassMethod()`의 결과가 달라진다.
2. `Animal`의 `testInstanceMethod()`를 오버라이드한 `myCat`의 `testInstanceMethod()`가 호출되었다.

### 인터페이스 default 메소드 오버라이딩

인터페이스는 기본적으로 메소드 내용을 구현할 수 없지만 메소드에 `default` 선언을 통해 메소드 바디를 구현할 수 있다. 또한 해당 인터페이스를 구현하는 클래스는 `default` 메소드를 오버라이딩할 수 있다.

다만 같은 시그니처를 가지는 여러개의 `default` 메소드를 구현하는 경우 두가지 원칙으로 이름 충돌을 막는다.

1. 인스턴스 메소드가 이미 구현되어 있으면 인터페이스의 `default` 메소드는 무시하고 인스턴스 메소드를 따른다.

    ```java
    public class Horse {
        public String identifyMyself() {
            return "I am a horse.";
        }
    }
    public interface Flyer {
        default public String identifyMyself() {
            return "I am able to fly.";
        }
    }
    public interface Mythical {
        default public String identifyMyself() {
            return "I am a mythical creature.";
        }
    }
    public class Pegasus extends Horse implements Flyer, Mythical {
        public static void main(String... args) {
            Pegasus myApp = new Pegasus();
            System.out.println(myApp.identifyMyself());
        }
    }
    //>> I am a horse.
    ```

2. 공통된 *ancestor*를 가지는 인터페이스들이 있을 때, 이미 오버라이딩이 되어있는 인터페이스의 `default` 메소드를 따른다.

    ```java
    public interface Animal {
        default public String identifyMyself() {
            return "I am an animal.";
        }
    }
    public interface EggLayer extends Animal {
        default public String identifyMyself() {
            return "I am able to lay eggs.";
        }
    }
    public interface FireBreather extends Animal { }

    public class Dragon implements EggLayer, FireBreather {
        public static void main (String... args) {
            Dragon myApp = new Dragon();
            System.out.println(myApp.identifyMyself());
        }
    }
    //>> I am able to lay eggs.
    ```

3. 만약, `default` 메소드끼리 충돌이 나거나 추상 메소드와 충돌이 나는 경우는 컴파일러가 에러를 띄운다.

---
[Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/java/IandI/super.html) \
https://joochang.tistory.com/75 \
https://inor.tistory.com/7 \
https://programmers.co.kr/learn/courses/5/lessons/241

## 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)

다이나믹 메소드 디스패치는 컴파일 타임에 정의된 메소드가 아닌 런타임에 오버라이딩된 메소드를 호출하는 메커니즘이다.

- *superclass* 참조로 오버라이딩된 메소드가 호출되었을 때, 자바는 호출이 발생할 때 참조된 객체의 유형에 기반해 어떤 버전(*superclass*/*subclass*)의 메소드가 호출될지를 결정한다. 따라서 해당 결정은 런타임에 만들어진다.
- 런타임에는 참조되는 객체의 타입에 의존해 호출될 메소드를 결정한다.

```java
class A 
{ 
    void m1() 
    { 
        System.out.println("Inside A's m1 method"); 
    } 
} 
  
class B extends A 
{ 
    // overriding m1() 
    void m1() 
    { 
        System.out.println("Inside B's m1 method"); 
    } 
} 
  
class C extends A 
{ 
    // overriding m1() 
    void m1() 
    { 
        System.out.println("Inside C's m1 method"); 
    } 
} 
  
// Driver class 
class Dispatch 
{ 
    public static void main(String args[]) 
    { 
        // object of type A 
        A a = new A(); 
  
        // object of type B 
        B b = new B(); 
  
        // object of type C 
        C c = new C(); 
  
        // obtain a reference of type A 
        A ref; 
          
        // ref refers to an A object 
        ref = a; 
  
        // calling A's version of m1() 
        ref.m1(); 
  
        // now ref refers to a B object 
        ref = b; 
  
        // calling B's version of m1() 
        ref.m1(); 
  
        // now ref refers to a C object 
        ref = c; 
  
        // calling C's version of m1() 
        ref.m1(); 
    } 
}

//>> Inside A's m1 method
//>> Inside B's m1 method
//>> Inside C's m1 method
```

- 자바에서는 오버라이드는 메소드에만 할 수 있기 때문에 **data member에는 적용되지 않는다.**

```java
// class A 
class A 
{ 
    int x = 10; 
} 
  
// class B 
class B extends A 
{ 
    int x = 20; 
} 
  
// Driver class 
public class Test 
{ 
    public static void main(String args[]) 
    { 
        A a = new B(); // object of type B 
  
        // Data member of class A will be accessed 
        System.out.println(a.x); 
    } 
} 

//>> 10
```

---
[Dynamic Method Dispatch or Runtime Polymorphism in Java - GeeksforGeeks](https://www.geeksforgeeks.org/dynamic-method-dispatch-runtime-polymorphism-java/)

## 추상 클래스

### 추상 클래스

1. `abstract` 키워드로 선언된 클래스를 말한다.
2. 이는 `abstract` 메소드를 포함할 수 있다.
3. 인스턴스로는 만들 수 없다.

### 추상 메소드

1. 구현없이 선언만 된 메소드를 말한다.
2. `abstract` 키워드로 선언된다.

```java
abstact void moveTo(double deltaX, double deltaY);
```

추상 클래스를 상속 받는 클래스가 있다면, 해당 클래스는 부모 클래스의 모든 추상 메소드를 구현해야한다. 구현을 하지 않을 경우에는 상속받은 클래스또한 `abstract`로 선언되어야 한다.

### Abstract class vs Interface

| | 추상 클래스 | 인터페이스 |
|---|---|---|
| 인스턴스화 | 불가능 | 불가능 |
| fields | 선언 가능(`static`이나 `final`이 아닌 필드만) | 자동으로 `public`, `static`, `final`이 된다 |
| methods | `public`, `protected`, `private`으로 정의 가능 | 모든 메소드가 `public` |

---
[Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/java/IandI/super.html)

## final 키워드

`final` 키워드로 선언되는 entity는 그 값이 **변경될 수 없음**을 의미한다. 그 entity는 변수, 파라미터, 메소드, 클래스가 될 수 있다.

### final variables

`final` 키워드와 함께 선언된 변수는 한번 초기화되면 다시는 바뀔 수 없다. 하지만 선언과 함께 초기화될 필요는 없다.

### final parameters

`final`로 선언된 파라미터는 그 함수 어디에서도 파라미터의 값을 변경할 수 없음을 의미한다.

### final methods

`final`로 선언된 메소드는 override나 hide될 수 없다.

### final classes

`final`로 선언된 클래스는 *subclass*를 가질 수 없다.

---
[What is the final keyword in Java? - educative.io](https://www.educative.io/edpresso/what-is-the-final-keyword-in-java?aid=5082902844932096&utm_source=google&utm_medium=cpc&utm_campaign=edpresso-dynamic&gclid=CjwKCAiAz4b_BRBbEiwA5XlVVr2Kkk4gDDPQSGzjnGqbgLw5FJtrETYW_oZNvv39fu8OaWYnZTq2zxoCRGwQAvD_BwE)

## Object 클래스

모든 클래스의 *superclass*이다. 따라서 모든 클래스는 `Object` 클래스의 메소드를 사용할 수 있으며 오버라이딩도 가능하다.

### Object 클래스가 가지는 메소드

#### `protected Object clone()`

해당 객체를 생성하고 copy된 객체를 반환한다.

#### `boolean equals(Object obj)`

다른 객체와 해당 객체가 같은 지를 비교하여 Boolean 타입의 결과값을 반환한다.

#### `protected void finalize()`

garbage collector가 해당 객체가 더 이상 참조되지 않는다고 판단했을 때, 해당 객체의 `finalize()` 메소드를 호출한다.

#### `Class<?> getClass()`

해당 객체의 런타임 클래스를 반환한다.

#### `int hashCode()`

해당 객체의 hash code 값을 반환한다.

#### `String toString()`

해당 객체의 문자열 표현을 반환한다.

---
[Oracle Java Documentation](https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html)
