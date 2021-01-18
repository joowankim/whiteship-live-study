# 학습할 것 (필수)

[Thread 클래스와 Runnable 인터페이스]() \
[쓰레드의 상태]() \
[쓰레드의 우선순위]() \
[Main 쓰레드]() \
[동기화]() \
[데드락]()

## Thread란?

> 하나의 프로세스 내부에서 **독립적으로 실행되는** 하나의 **작업 단위**를 말한다. 세부적으로는 운영체제에 의해 관리되는 하나의 작업 혹은 태스크를 의미한다.

### 자바에서의 쓰레드

1. JVM에 의해 하나의 프로세스가 발생하고 `main()` 안의 실행문들이 하나의 쓰레드이다.
2. `main()` 이외에 또 다른 쓰레드를 만들기 위해서는:
    - `Thread` 클래스를 상속
    - `Runnable` 인터페이스를 구현
3. 다중 쓰레드 작업 시, 각 쓰레드끼리는 정보를 주고받을 수 있다.
4. 프로세스끼리는 정보를 주고받을 수 없다.

---
https://coding-factory.tistory.com/279

## Thread 클래스와 Runnable 인터페이스

### Runnable 인터페이스

1. 함수형 인터페이스 중 하나이다. 따라서 lambda 표현식을 선언할 때 SAM으로써 쓰일 수 있다.
2. 인스턴스가 쓰레드에 의해 실행되도록 의도된 모든 클래스에서 구현되어야 한다.
3. `Runnable` 인터페이스를 구현하는 객체가 쓰레드를 생성하는데 사용되는 경우, 해당 객체가 쓰레드를 시작하면 `run()` 메소드가 별도로 실행되는 쓰레드에서 호출된다.

### Thread 클래스

Oracle의 Java API 문서에 따르면 `Thread` 클래스는 `Object`를 상속하면 `Runnable`을 구현한다.

1. 각 쓰레드는 우선순위를 가지며 우선순위가 높은 쓰레드부터 실행된다.
2. 각 쓰레드는 daemon으로 쓰일 수도 있다.
3. 쓰레드 안에서 실행되는 코드는 새로운 `Thread` 객체를 만든다.
   - 새롭게 생성된 쓰레드의 우선순위는 그 객체를 생성한 쓰레드와 동등한 우선순위를 가진다.
   - 새로운 쓰레드를 생성한 쓰레드가 daemon일 경우에는 생성된 쓰레드도 daemon이 된다.

#### 몇가지 참고할만한 `Thread`의 메소드들

| Modifier and Type | Method | Description |
|---|---|---|
| `static Thread` | `currentThread()` | 현재 실행 중인 쓰레드를 반환한다. |
| `long` | `getId()` | 쓰레드의 id를 반환한다. |
| `String` | `getName()` | 쓰레드의 이름을 반환한다. |
| `int` | `getPriority()` | 쓰레드의 우선순위를 반환한다. |
| `Thread.State` | `getState()` | 쓰레드의 상태를 반환한다. |
| `void` | `interrupt()` | 해당 쓰레드를 멈춘다. |
| `void` | `join()` | 이 쓰레드가 끝나기를 기다린다. |
| `void` | `run()` | 이 쓰레드가 별도의 Runnable 실행 객체를 사용해 생성된 경우 해당 Runnable 객체의 run 메소드가 호출된다. 그렇지 않으면 해당 메소드는 아무 작업도 실행하지 않고 반환한다. |
| `void` | `start()` | 해당 쓰레드를 시작한다. JVM이 이 쓰레드의 run 메소드를 호출한다. |

---
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Runnable.html \
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Thread.html

## 쓰레드의 상태

---
https://widevery.tistory.com/27 \
https://wonjerry.tistory.com/13 \

## 쓰레드의 우선순위

## Main 쓰레드

## 동기화

## 데드락
