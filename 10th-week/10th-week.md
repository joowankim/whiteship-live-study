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

자바 어플리케이션이 시작되면서 실행되는 쓰레드로 메인 쓰레드는 `main()` 메소드를 실행시키면서 시작한다.

## 동기화

멀티 쓰레드 환경에서 데이터의 일관성(consistency)을 유지해주는 것을 의미한다.

싱글 쓰레드 프로세스의 경우에는 프로세스 내에 하나의 쓰레드만 작업하기 때문에 프로세스의 자원을 임의로 수정해도 영향을 받을 다른 쓰레드가 존재하지 않는다.

하지만 멀티 쓰레드가 작업하는 프로세스의 경우에는 프로세스의 자원을 각 쓰레드가 공유하여 사용하고 있기 때문에 쓰레드끼리 영향을 주고 받을 수 있다. 즉, 프로그래머가 의도한 것과는 작업 결과가 나올 수 있는 환경이 조성된다. 이와 같은 문제가 발생하는 것을 방지하기 위해 **동기화**를 사용한다.

따라서 특정 쓰레드가 작업을 끝마치기 전에 다른 쓰레드에 의해 방해받지 않도록 할 수단으로 **임계 영역(critical section)**과 **잠금(lock)**이라는 개념이 도입되었다.

### 임계 영역(critical section)

> **공유 데이터를 사용하는 코드 영역**을 임계 영역으로 지정하고, 공유 데이터(객체)가 가지고 있는 lock을 획득한 **단 하나의 쓰레드**만 해당 영역에서 작업을 수행할 수 있도록 하는 것이다.

그 외 방법들로는 다음과 같은 것들이 있다.

### 뮤텍스(mutex)

임계 영역과 마찬가지로 공유자원에 여러 쓰레드가 접근하려고 할 때, lock을 이용해 한번에 하나의 쓰레드만 공유자원에 접근하도록 허용하는 것

한 프로세스 내의 쓰레드에서만 적용가능한 임계 영역과는 달리 뮤텍스는 서로 다른 프로세스에 속한 쓰레드에도 적용이 가능하다.

### 세마포어(semaphore)

한정된 자원을 여러 쓰레드가 사용하려고 할 때 접근을 제어한다.

다중 쓰레드 간 공유 자원에 대한 접근 순서를 제어하고 공유 자원의 수와 접근 쓰레드 수에 따라 보다 유연하게 공유영역으로의 접근을 제어한다.

### 이벤트(event)

특정한 이벤트가 발생한 것을 다른 쓰레드에게 알린다.

### 대기 가능 타이머(waitable timer)

특정 시간이 되면 대기중이던 쓰레드를 깨운다.

---
https://kyun2.tistory.com/12 \
https://gongstudyit.tistory.com/22 \
https://mingmi-programming.tistory.com/79

## 데드락

> 둘 이상의 쓰레드가 lock을 획득하기 위해 기다리는데, lock 잡고 있는 쓰레드 조차도 다른 자원에 대한 lock 기다리면서 서로 block 상태에 놓인 상황을 말한다.

### 데드락의 발생 조건

아래 조건들을 모두 만족하게 되면 데드락이 발생한다.

#### 상호 배제(Mutual Exclusion)

한 번에 한 프로세스만이 자원을 사용하는 것

#### 점유 대기(Hold and Wait)

하나 이상의 자원을 소지한 프로세스가 다른 프로세스가 가진 자원을 추가로 얻기 위해 대기하는 것

#### 비선점(Non-preemption)

자원을 강제적으로 빼앗을 수 없기 때문에 자원을 사용중인 프로세스가 종료된 후에 자원이 반환되어야 사용이 가능한 것

#### 환형 대기(Circular Wait)

각 쓰레드가 서로 다른 자원에 대한 lock을 가지고 있으면서 상대가 가진 자원에 대한 lock 또한 사용하려고 서로 대기하는 것

### 데드락을 예방하는 방법

기본적으로 위 4개의 조건을 모두 만족하는 상황에서 데드락이 발생하기 때문에 하나의 조건만 제거해주면 된다. 다만, 자원의 낭비가 심하고 시스템 처리율이 감소할 수 있다.

1. 여러 개의 프로세스가 공유자원을 사용할 수 있도록 한다.
   - 상호 배제 조건을 제거
   - 데이터의 consistency를 보장할 수 있는 환경에서 사용해야 한다.
2. 수행 전 모든 자원을 할당시켜주고 자원을 점유하고 있지 않을 때에만 자원을 요구하도록 한다.
   - 점유 대기 조건을 제거
3. 자원을 점유하고 있는 프로세스가 다른 자원을 요구할 때는 점유하고 있는 자원을 반납하고 난 후 요구한 자원을 기다리게 한다.
   - 비선점 조건 제거
4. 자원 유형에 따라 순서를 매긴다.

---
https://parkcheolu.tistory.com/19 \
https://m.blog.naver.com/PostView.nhn?blogId=tommybee&logNo=50192920921&proxyReferer=https:%2F%2Fwww.google.com%2F \
https://mingmi-programming.tistory.com/79
