# 학습할 것

[자바에서 예외 처리 방법 (try, catch, throw, throws, finally)](https://github.com/kjw217/whiteship-live-study/blob/master/9th-week/9th-week.md#%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC-%EB%B0%A9%EB%B2%95-try-catch-throw-throws-finally)

[자바가 제공하는 예외 계층 구조](https://github.com/kjw217/whiteship-live-study/blob/master/9th-week/9th-week.md#%EC%9E%90%EB%B0%94%EA%B0%80-%EC%A0%9C%EA%B3%B5%ED%95%98%EB%8A%94-%EC%98%88%EC%99%B8-%EA%B3%84%EC%B8%B5-%EA%B5%AC%EC%A1%B0)

[Exception과 Error의 차이는?](https://github.com/kjw217/whiteship-live-study/blob/master/9th-week/9th-week.md#exception%EA%B3%BC-error%EC%9D%98-%EC%B0%A8%EC%9D%B4%EB%8A%94)

[RuntimeException과 RE가 아닌 것의 차이는?](https://github.com/kjw217/whiteship-live-study/blob/master/9th-week/9th-week.md#runtimeexception%EA%B3%BC-re%EA%B0%80-%EC%95%84%EB%8B%8C-%EA%B2%83%EC%9D%98-%EC%B0%A8%EC%9D%B4%EB%8A%94)

[커스텀한 예외 만드는 방법](https://github.com/kjw217/whiteship-live-study/blob/master/9th-week/9th-week.md#%EC%BB%A4%EC%8A%A4%ED%85%80%ED%95%9C-%EC%98%88%EC%99%B8-%EB%A7%8C%EB%93%9C%EB%8A%94-%EB%B0%A9%EB%B2%95)

## 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)

예외를 처리하는 일반적인 방법 3가지는 다음과 같다.

1. 예외복구
2. 예외처리 회피
3. 예외 전환

### 예외복구

예외가 발생하면 다른 작업 흐름으로 유도한다. `try-catch-finally` 구문을 이용해 `try`문에서 예외가 발생해도 `catch` 블럭에서 예외를 처리하고 `finally` 블럭을 실행한다.

```java
try {
    leesin.ult(misfortune);
} catch(RangeException e) {
    System.out.println("캐릭터가 맵을 벗어났습니다.");
} finally {
    System.out.println("아군이 당했습니다.");
    System.out.println("미스포춘 - 점멸(준비됨)");
    System.out.println("미스포춘 - 점멸(준비됨)");
    System.out.println("미스포춘 - 점멸(준비됨)");
    System.out.println("미스포춘 - 점멸(준비됨)");
}
```

### 예외처리 회피

처리를 하지 않고 호출한 쪽으로 던져버린다. 메소드를 정의할 때 `throws`를 활용하여 해당 메소드를 호출한 곳으로 예외처리를 넘길 수 있다.

```java
class Leesin implements Champion {
    ...
    @Override
    public void ult(Champion champ) throws RangeException { // ult 메소드에서 발생할 수 있는
                                                            // RangeException의 처리를
                                                            // 메소드를 호출한 쪽으로 넘긴다.
        System.out.println("YEE-KOO!!");
        champ.moveTo(champ.getX() + 10, 
                     champ.getY() + 10);
    }
}
```

### 예외 전환

호출한 쪽으로 던질 때 명확한 의미를 전달하기 위해 다른 예외로 전환하여 던진다.

이제는 익숙해진 리신을 다시 소환해보자.

```java
try {
    leesin.ult(misfortune);
} catch(RangeException e) {
    System.out.println("캐릭터가 맵을 벗어났습니다.");
    throw new OutOfMapException();  // RangeException을 새로운 예외로 전환하여 발생시킨다.
} finally {
    System.out.println("아군이 당했습니다.");
    System.out.println("미스포춘 - 점멸(준비됨)");
    System.out.println("미스포춘 - 점멸(준비됨)");
    System.out.println("미스포춘 - 점멸(준비됨)");
    System.out.println("미스포춘 - 점멸(준비됨)");
}
```

---
https://www.nextree.co.kr/p3239/

## 자바가 제공하는 예외 계층 구조

![자바 계층 구조](https://www.nextree.co.kr/content/images/2021/01/Exception-Class.png)

[그림 참조 - 예외 처리에 대한 작은 생각 by nextree](https://www.nextree.co.kr/p3239/)

그림에서 볼 수 있듯이 Exception과 Error는 모두 `Throwable` 클래스를 상속한다. 여기서 `Throwable` 인터페이스를 구현하는 것이 아닌 **클래스**를 상속한다는 것을 알 수 있었다. 그렇다면 `Throwable`의 멤버를 Exception과 Error 클래스가 상속 받아 사용한다는 것 또한 알 수 있다.

### Throwable 클래스

Oracle의 자바 api 문서에 따르면 Throwable 클래스는 모든 Error와 Exception의 *superclass*라는 설명으로 Throwable과 이를 상속하는 클래스의 특징을 설명한다.

1. Throwable 클래스나 이를 상속하는 클래스의 **인스턴스 객체**만이 JVM에 의해 **던져지며**, 자바의 `throw` 선언을 통해 **던져질** 수 있다.
2. Throwable 클래스나 이를 상속하는 클래스 만이 `catch` 절에서 **인자**로 쓰일 수 있다.

#### members of Throwable

##### 생성자

기본적으로는 `Throwable()`이며 인자로 `String message`나 `Throwable cause` 등을 넘겨 인스턴스를 생성할 수 있다.

##### 메소드

| Modifier and Type | Method | Description |
|---|---|---|
| `void` | `addSuppressed​(Throwable exception)` | Appends the specified exception to the exceptions that were suppressed in order to deliver this exception. |
| `Throwable` | `fillInStackTrace()` | Fills in the execution stack trace. |
| `Throwable` | `getCause()` | 해당 Throwable의 cause인 Throwable 인스턴스나 null(원인을 모를 경우)을 반환한다. |
| `String` | `getMessage()` | 해당 Throwable 인스턴스의 상세 메시지를 반환한다. |
| `StackTraceElement[]` | `getStackTrace()` | `printStackTrace()`에 호출되는 스택을 반환한다. |
| `Throwable[]` | `getSuppressed()` | Throwable 인스턴스에 `addSuppressed()`된 모든 Exception으로 이루어진 array를 반환한다. |
|`Throwable` | `initCause​(Throwable cause)` | 특정한 cause 인자를 넘겨 해당 Throwable 인스턴스의 cause를 초기화 한다. |
| `void` | `printStackTrace()` | Prints this throwable and its backtrace to the standard error stream. |
| `void` | `printStackTrace​(PrintStream s)` | Prints this throwable and its backtrace to the specified print stream. |
| `void` | `printStackTrace​(PrintWriter s)` | Prints this throwable and its backtrace to the specified print writer. |
| `void` | `setStackTrace​(StackTraceElement[] stackTrace)` | Sets the stack trace elements that will be returned by getStackTrace() and printed by printStackTrace() and related methods. |
| `String` | `toString()` | Returns a short description of this throwable. |

---
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Throwable.html

## Exception과 Error의 차이는?

| Exception | Error |
|---|---|
| 프로그램 내부 코드가 의도와는 다른 상황에 직면한 것 | 프로그램 내부가 아닌 외부 환경에서 비롯된 오류 상황 |

### Exception 예시

1. 파일을 열기 위해 주어진 위치에서 프로그램이 파일을 찾을 때 파일을 찾을 수 없는 경우
2. 0으로 수를 나누려고 시도하는 경우

### Error 예시

1. 네트워크의 상태 불안정으로 인한 커넥션 끊김
2. OS에서 접근 권한을 주지 않아 발생하는 에러

## RuntimeException과 RE가 아닌 것의 차이는?

흔히 **Unchecked Exception**과 **Checked Exception**이라고 불린다.

`RuntimeException`을 포함해 이를 상속하는 모든 Exception들은 Unchecked Exception에 해당한다. 그리고 그 외 Exception들은 Checked Exception에 속한다.

### Unchecked Exception vs Checked Exception

| | Unchecked Exception | Checked Exception |
|---|---|---|
| 처리 여부 | 명시적인 예외 처리를 강제하지 않는다. | 반드시 예외를 처리해야 한다. |
| 확인 시점 | 실행 단계 | 컴파일 단계 |
| 예외 발생 시 트랜잭션 처리 | roll-back 한다. | roll-back하지 않는다. |

---
https://www.nextree.co.kr/p3239/

## 커스텀한 예외 만드는 방법

커스텀 예외 클래스에서 `Exception` 클래스를 상속해 생성자에서 `super()`를 호출해 커스텀 예외의 `String message`와 `Throwable cause` 등을 초기화 시킬 수 있다. 그리고 예외 클래스의 자체적인 메소드 또한 선언할 수 있다.

```java
class MyException extends Exception{
    MyException(String msg){// 문자열을 매개변수로 받는 생성자
        super(msg);// 조상인 Exception 클래스의 생성자를 호출한다.
    }
}
```

---
[장인개발자를 꿈꾸는 :: 기록하는 공간](https://devbox.tistory.com/entry/Java-예외-만들기)
