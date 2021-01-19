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

쓰레드는 다음과 같은 상태를 얻을 수 있다.

- 객체 생성(NEW): 쓰레드 객체가 생성된 상태. `start()` 메소드는 호출되지 않은 상태
- 실행 대기(RUNNABLE): 실행을 언제든지 할 수 있는 상태
- 일시 정지
  - WAITING: 다른 쓰레드가 통지할 때까지 기다리는 상태
  - TIMED_WAITING: 주어진 시간 동안 기다리는 상태
  - BLOCKED: 사용하고자 하는 객체의 락이 풀릴 떄까지 기다리는 상태
- 종료(TERMINATED): 실행을 마친 상태

---
https://widevery.tistory.com/27 \
https://wonjerry.tistory.com/13 \

## 쓰레드의 우선순위

> 자바의 쓰레드 스케줄링은 우선순위 방식과 순환 할당 방식을 사용해 쓰레드의 실행을 관리한다.

쓰레드의 우선순위를 관리하기 위해 `Thread` 클래스는 다음과 같은 멤버를 가진다.

- `void setPriority(int new Priority)`
- `int getPriority()`
- `public static final int MAX_PRIORITY = 10`
- `public static final int MIN_PRIORITY = 1`
- `public static final int NORM_PRIORITY = 5`

위 두개의 메소드를 통해 쓰레드위 우선순위의 값을 매기고 가져올 수 있다. 또한 아래 3개의 상수를 통해 쓰레드 우선순위의 최대값과 최소값이 10과 1이라는 것을 알 수 있으며, 우선순위가 별도로 부여되지 않은 쓰레드의 경우에는 `NORM_PRIORITY`를 갖는 다는 걸 알 수 있다.

---
https://devbox.tistory.com/entry/Java-%EC%93%B0%EB%A0%88%EB%93%9C%EC%9D%98-%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84 \
https://deftkang.tistory.com/56 \
https://docs.oracle.com/en/java/javase/11/docs/api/constant-values.html#java.lang.Thread.MAX_PRIORITY

## Main 쓰레드

## 동기화

## 데드락
