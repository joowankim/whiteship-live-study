# 학습할 것 (필수)

- [학습할 것 (필수)](#학습할-것-필수)
  - [Enum이란](#enum이란)
  - [Java에서 Enum이란](#java에서-enum이란)
  - [enum 정의하는 방법](#enum-정의하는-방법)
    - [enum의 생성자](#enum의-생성자)
  - [enum이 제공하는 메소드 (values()와 valueOf())](#enum이-제공하는-메소드-values와-valueof)
  - [java.lang.Enum](#javalangenum)
  - [EnumSet](#enumset)

## Enum이란

Enum이란 Enumeration의 앞 글자를 의미해 '열거'라는 의미를 지닌다. 흔히 **관련된 상수들의 집합**을 정의할 때 쓰이는 문법이라고 한다.

## Java에서 Enum이란

1.5버전 이전의 Java에서는 `final static`을 이용해 클래스 내에서, 혹은 인터페이스 안에서 상수를 정의해왔다. 하지만 그러한 방식의 상수 선언은 다음 예제와 같은 형태로 사용되며 몇몇 문제점을 가지고 있었다.

요일에 대응되는 상수들을 가지고 예를 들어보자. 아래 예제들의 출처는 [여기](https://www.nextree.co.kr/p11686/)임을 밝힙니다.

1. 메인 함수에서 조건문을 활용해 상수 구별하기

    ```java
    public class EnumExample{
        public static void main(String[] args){
            
            /**
             * 월요일 == 1
             * 화요일 == 2
             * 수요일 == 3
             * 목요일 == 4
             * 금요일 == 5
             * 토요일 == 6
             * 일요일 == 7
             */

            /* get value implies the day of the week */

            switch(day){
                case 1:
                    System.out.println("월요일");
                    break;
                case 2:
                    System.out.println("화요일");
                    break;
                case 3:
                    System.out.println("수요일");
                    break;
                case 4:
                    System.out.println("목요일");
                    break;
                case 5:
                    System.out.println("금요일");
                    break;
                case 6:
                    System.out.println("토요일");
                    break;
                case 7:
                    System.out.println("일요일");
                    break;
            }
        }
    }
    ```

    - 주석이 사라진다면 코드를 이해하기 어려울 수 있다.
    - `switch` 문이 주석과 다른 곳에서 사용될 때에도 코드 이해에 어려움이 따를 수 있다.

2. `final static`을 이용해 상수가 컴파일 타임에 고정되게 만들기

    ```java
    public class EnumExample {
        private final static int MONDAY = 1;
        private final static int TUESDAY = 2;
        private final static int WEDNESDAY = 3;
        private final static int THURSDAY = 4;
        private final static int FRIDAY = 5;
        private final static int SATURDAY = 6;
        private final static int SUNDAY = 7;

        public static void main(String[] args) {
            /* get value implies the day of the week */

            switch(day){
                case MONDAY:
                    System.out.println("월요일");
                    break;
                case TUESDAY:
                    System.out.println("화요일");
                    break;
                case WEDNESDAY:
                    System.out.println("수요일");
                    break;
                case THURSDAY:
                    System.out.println("목요일");
                    break;
                case FRIDAY:
                    System.out.println("금요일");
                    break;
                case SATURDAY:
                    System.out.println("토요일");
                    break;
                case SUNDAY:
                    System.out.println("일요일");
                    break;
            }
        }
    }
    ```

    - 상수에 대응되는 이름을 통해 각 case가 의미하는 바를 명확하게 알 수 있다.
    - 달(month)과 같은 추가적인 변수를 추가해야할 때 상수가 매우 많아진다.
    - 상수의 집합에서 중복된 이름을 사용할 수 없다.
    - 추가나 변경에 취약할 수 있다.

3. 인터페이스를 이용해 집합끼리 정의되도록 만들기

    ```java
    interface DAY {
        int MONDAY = 1;
        int TUESDAY = 2;
        int WEDNESDAY = 3;
        int THURSDAY = 4;
        int FRIDAY = 5;
        int SATURDAY = 6;
        int SUNDAY = 7;
    }

    interface MONTH {
        int JANUARY = 1;
        int FEBRUARY = 2;
        int MARCH = 3;
        int APRIL = 4;
        int MAY = 5;
        int JUNE = 6;
        int JULY = 7;
        int AUGUST = 8;
        int SEPTEMBER = 9;
        int OCTOBER = 10;
        int NOVEMBER = 11;
        int DECEMBER = 12;
    }

    public class EnumExample {
        public static void main(String[] args) {
            if (DAY.MONDAY == MONTH.JANUARY){
                System.out.println("두 상수는 같습니다.");
            }

            /* get value implies the day of the week */

            switch(day) {
                case DAY.MONDAY:
                    System.out.println("월요일");
                    break;
                case DAY.TUESDAY:
                    System.out.println("화요일");
                    break;
                case DAY.WEDNESDAY:
                    System.out.println("수요일");
                    break;
                case DAY.THURSDAY:
                    System.out.println("목요일");
                    break;
                case DAY.FRIDAY:
                    System.out.println("금요일");
                    break;
                case DAY.SATURDAY:
                    System.out.println("토요일");
                    break;
                case DAY.SUNDAY:
                    System.out.println("일요일");
                    break;
            }
        }
    }
    ```

    - 집합끼리 나눠져 있어 중복된 이름이 있어도 컴파일 에러가 발생하지 않는다.
    - `public final static` 제어자를 생략할 수 있다.
    - 서로 다른 집합에 있는 상수라도 그 값이 같으면 비교했을 때 컴파일 에러가 나지 않는다.

4. 인터페이스 대신 클래스를 사용해 상수 집합을 정의하기

    ```java
    class Day {
        public final static Day MONDAY = new Day();
        public final static Day TUESDAY = new Day();
        public final static Day WEDNESDAY = new Day();
        public final static Day THURSDAY = new Day();
        public final static Day FRIDAY = new Day();
        public final static Day SATURDAY = new Day();
        public final static Day SUNDAY = new Day();
    }

    class Month {
        public final static Month JANUARY = new Month();
        public final static Month FEBRUARY = new Month();
        public final static Month MARCH = new Month();
        public final static Month APRIL = new Month();
        public final static Month MAY = new Month();
        public final static Month JUNE = new Month();
        public final static Month JULY = new Month();
        public final static Month AUGUST = new Month();
        public final static Month SEPTEMBER =new Month();
        public final static Month OCTOBER = new Month();
        public final static Month NOVEMBER = new Month();
        public final static Month DECEMBER = new Month();
    }

    public class EnumExample {
        public static void main(String[] args) {
            if (Day.MONDAY == Month.JANUARY) {
                System.out.println("두 상수는 같습니다.");
            }

            Day day = Day.MONDAY;

            switch(day) {
                case DAY.MONDAY:
                    System.out.println("월요일");
                    break;
                case DAY.TUESDAY:
                    System.out.println("화요일");
                    break;
                case DAY.WEDNESDAY:
                    System.out.println("수요일");
                    break;
                case DAY.THURSDAY:
                    System.out.println("목요일");
                    break;
                case DAY.FRIDAY:
                    System.out.println("금요일");
                    break;
                case DAY.SATURDAY:
                    System.out.println("토요일");
                    break;
                case DAY.SUNDAY:
                    System.out.println("일요일");
                    break;
            }
        }
    }
    ```

    - 서로 다른 집합에 있는 상수는 서로 다른 타입이기 때문에 서로 비교할 수 없다.
    - `switch` 문이 제공하는 문법에서는 비교할 수 있는 타입에 제한이 있기 때문에 `switch` 문에서 사용할 수 없다.

## enum 정의하는 방법

위와 같은 문제를 해결하는 방법 중에 하나로 자바 1.5부터 소개된 enum 문법을 사용할 수 있다. 위 코드를 enum 문법을 사용해 바꿔보면 다음과 같다.

```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
    JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
}

public class EnumExample {
    public static void main(String[] args) {
        Day day = Day.MONDAY;

        switch(day) {
            case MONDAY:
                System.out.println("월요일");
                break;
            case TUESDAY:
                System.out.println("화요일");
                break;
            case WEDNESDAY:
                System.out.println("수요일");
                break;
            case THURSDAY:
                System.out.println("목요일");
                break;
            case FRIDAY:
                System.out.println("금요일");
                break;
            case SATURDAY:
                System.out.println("토요일");
                break;
            case SUNDAY:
                System.out.println("일요일");
                break;

        }
    }
}
```

- 클래스를 사용해 각각의 상수에 고유값을 대입했던 것과 똑같이 동작한다.
- 코드는 단순하다.
- 인스턴스 생성과 상속을 방지한다.
- enum이라는 키워드를 사용해 해당 클래스가 열거형임을 분명히 할 수 있다.

### enum의 생성자

1. enum class의 생성자를 이용해 각 객체를 열거할 때 추가적인 속성을 같이 부여할 수 있다.
2. enum class의 생성자는 `private` 접근 제어자만을 가진다.
3. 따라서 enum class 내에 선언하는 것 외에 enum class의 인스턴스를 만드는 것은 불가능하다.

```java
public enum Planet {
    EARTH(6400);

    private int radius;

    private Planet(int radius){
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }
}
```

## enum이 제공하는 메소드 (values()와 valueOf())

enum이 제공하는 메소드들을 알아보기 위해 oracle의 java api 문서를 검색해보았다. `Object` 클래스의 메소드를 오버라이드한 메소드를 제외한 메소드들을 다음과 같이 추려보았다.

| Modifier and Type | Method | Description |
|---|---|---|
| `int` | `ordinal()` | enum 클래스에 선언된 순번을 반환한다. |
| `static <T extends Enum<T>> T` | `valueOf(Class<T> enumType, String name)` | `name` 파라미터로 전달되는 이름의 enum 상수를 반환한다. |

java api 문서의 All Methods 항목의 표에서 볼 수 있었던 것은 위 `Object` 클래스의 메소드를 오버라이드 하거나 wrapping 한 것을 제외하면 위 2개 뿐이었다. 그렇다면 `values()`는 어디서 찾아볼 수 있을까?

`valueOf()`의 [details](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Enum.html#valueOf(java.lang.Class,java.lang.String))에서 찾을 수 있었다. `values()`에 대한 설명은 간단했다. `valueOf()`가 특정한 하나의 enum 상수를 반환하지만 `values()`는 전체 상수들을 array 형태로 반환할 수 있다고 한다.

| Modifier and Type | Method | Description |
|---|---|---|
| `static T[]` | `values()` | enum 타입의 모든 상수를 반환한다. |

---
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Enum.html#%3Cinit%3E(java.lang.String,int)

## java.lang.Enum

```java
public abstract class Enum<E extends Enum<E>> implements Serializable, Comparable<E>
```

위 선언은 오라클의 java api 문서에서 볼 수 있다. 하나씩 살펴보자.

1. `E`는 enum type의 서브클래스를 말한다.
2. 추상 클래스이다.
3. `Comparable<E>`을 구현하고 있다.
4. `Serializable`을 구현하고 있다.

---
https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Enum.html#%3Cinit%3E(java.lang.String,int) \
https://docs.oracle.com/javase/specs/jls/se7/html/jls-8.html#jls-8.9

## EnumSet


---
https://velog.io/@ljinsk3/Enum%EC%9C%BC%EB%A1%9C-%EB%8B%A4%ED%98%95%EC%84%B1%EC%9D%84-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95 \
https://woowabros.github.io/tools/2017/07/10/java-enum-uses.html \
http://www.tcpschool.com/java/java_api_enum \
https://velog.io/@kyle/%EC%9E%90%EB%B0%94-Enum-%EA%B8%B0%EB%B3%B8-%EB%B0%8F-%ED%99%9C%EC%9A%A9 \
https://www.nextree.co.kr/p11686/ \
