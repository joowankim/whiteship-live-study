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

## 인터페이스 구현하는 방법

## 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

## 인터페이스 상속

## 인터페이스의 기본 메소드 (Default Method), 자바 8

## 인터페이스의 static 메소드, 자바 8

## 인터페이스의 private 메소드, 자바 9
