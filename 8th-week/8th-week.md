# 학습할 것

[인터페이스 정의하는 방법](인터페이스-정의하는-방법) \
[인터페이스 구현하는 방법](인터페이스-구현하는-방법) \
[인터페이스 레퍼런스를 통해 구현체를 사용하는 방법](인터페이스-레퍼런스를-통해-구현체를-사용하는-방법) \
[인터페이스 상속](인터페이스-상속) \
[인터페이스의 기본 메소드 (Default Method), 자바 8](인터페이스의-기본-메소드-(Default-Method),-자바-8) \
[인터페이스의 static 메소드, 자바 8](인터페이스의-static-메소드,-자바-8) \
[인터페이스의 private 메소드, 자바 9](인터페이스의-private-메소드,-자바-9)

## 인터페이스 정의하는 방법

인터페이스는 클래스와 같이 **메소드**와 **변수**를 가진다. 하지만 인터페이스 안에 선언된 **메소드**는 기본적으로 `abstract`로 선언된다.

- 인터페이스는 클래스가 어떤 행동을 하고, 하지 말아야 하는지를 정의한다.
- 인터페이스의 선언은 다음과 같다

    ```java
    interface <interface_name> {
        // declare constant fields
        // declare methods that abstract by default.
    }
    ```

---
[Interfaces in Java - GeeksforGeeks](https://www.geeksforgeeks.org/interfaces-in-java/)

## 인터페이스 구현하는 방법

```java
class <class_name> implements <interface_name> {
    // all of the methods in interface is implemented.
}
```

1. `interface` 키워드로 선언한다.
2. 인터페이스 내에 선언된 모든 메소드는 empty body를 가지는 추상 메소드이며, `public`으로 선언된다.
3. 모든 필드는 `public`, `static`과 `final`으로 선언될 수 있다.
4. 인터페이스를 구현하는 클래스는 반드시 **인터페이스 내의 모든 메소드를 구현**해야 한다.

---
[Interfaces in Java - GeeksforGeeks](https://www.geeksforgeeks.org/interfaces-in-java/)

## 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

1. 인터페이스 타입의 reference variable을 선언할 수 있다. (인터페이스를 구현하는 클래스만 가능하다.)

    ```java
    interface Vehicle {
        void move();
    }

    class car implements Vehicle {
        public void move(){
            System.out.println("move with wheels");
        }
    }

    static public void main(String[] args){
        Vehicle car = new car();
    }
    ```

2. 인터페이스를 구현하는 인스턴스의 참조 타입을 인터페이스로 변환할 수 있다.

    ```java
    static public void main(String[] args){
        Vehicle car = new car();
        Vehicle v = (Vehicle) car;
    }
    ```

## 인터페이스 상속

1. 하나의 *super class*만 상속할 수 있는 클래스 상속과는 다르게 인터페이스는 다중 상속을 할 수 있다.

    ```java
    interface Fightable() {
        public void attack();
    }

    interface Talkable() {
        public void talk();
    }

    class Person implements Fightable, Talkable {
        @Override
        public void attack() {
            System.out.println("bite!");
        }

        @Override
        public void talk() {
            System.out.println("hi");
        }
    }
    ```

2. 메소드 명이 겹친다면 하나만 선언해서 구현하면 된다.

    ```java
    interface Fightable() {
        public void talk();
    }

    interface Talkable() {
        public void talk();
    }

    class Person implements Fightable, Talkable {
        @Override
        public void talk() {
            System.out.println("hi");
        }
    }
    ```

    - 같은 이름을 가지지만 반환 타입이 서로 다른 메소드를 가지는 두 인터페이스는 다중 상속할 수 없다.

3. 인터페이스끼리 상속하는 것도 가능하다.

    ```java
    interface Fightable() {
        public void attack();
    }

    interface Talkable() extends Fightable {
        public void talk();
    }

    class Person implements Talkable {
        @Override
        public void attack() {  // from Fightable interface
            System.out.println("bite!");
        }

        @Override
        public void talk() {
            System.out.println("hi");
        }
    }
    ```

    - 부모 인터페이스를 가지는 인터페이스를 구현하는 클래스는 부모 인터페이스의 메소드까지 구현해야 한다.

---
https://joont92.github.io/java/class-interface-%EC%83%81%EC%86%8D/

## 인터페이스의 기본 메소드 (Default Method), 자바 8

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

## 인터페이스의 static 메소드, 자바 8

default method와 비슷하지만 static method를 가지는 인터페이스를 구현하는 클래스는 해당 인터페이스의 static method를 구현할 수 없다.

인터페이스에서 static method는 반드시 `<인터페이스 명>.<메소드>` 형식으로 호출해야 한다. 이를 이용해 유틸리티성 인터페이스를 구현할 수도 있다.

---
https://beginnersbook.com/2017/10/java-8-interface-changes-default-method-and-static-method/ \
https://programmers.co.kr/learn/courses/5/lessons/241

## 인터페이스의 private 메소드, 자바 9

인터페이스 내에서 메소드를 공유할 일이 있을 때 다음 룰을 지키면서 사용할 수 있다.

1. `private` 인터페이스의 메소드는 `abstract`로 선언될 수 없다.
2. `private` 메소드는 오직 인터페이스 안에서만 사용할 수 있다.
3. `private static` 메소드는 인터페이스 내의 다른 `static` 메소드나 non-static 메소드에서 사용될 수 있다.
4. private non-static 메소드는 `private static` 메소드 내에서 쓰일 수 없다.

---
https://howtodoinjava.com/java9/java9-private-interface-methods/#java9
