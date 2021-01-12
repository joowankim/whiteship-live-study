# 학습할 것

[자바에서 예외 처리 방법 (try, catch, throw, throws, finally)]()

[자바가 제공하는 예외 계층 구조]()

[Exception과 Error의 차이는?]()

[RuntimeException과 RE가 아닌 것의 차이는?]()

[커스텀한 예외 만드는 방법]()

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

---
