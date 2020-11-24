# 자바가 제공하는 다양한 연산자를 학습

## 산술 연산자

### 이항 연산자 (Infix Operator)

> 좌항과 우항을 같이 가지는 연산자

Operator | Name | Description | Example
---|---|---|---
+ | Addition | Adds together two values | x + y
- | Subtraction | Subtracts one value from another | x - y
\* | Multiplication | Multiplies two values | x \* y
/ | Division | Divides one value by another | x / y
% | Modulus | Returns the division remainder | x % y

### 단항 연산자

> 좌항이나 우항을 하나만 가지는 연산자

Operator | Name | Description | Example
---|---|---|---
+ | Positive | Represents a positive value | +x
- | Negative | Represents a negative value | -x
++| Increment | Increases the value of a variable by 1 | ++x
-- | Decrement | Decreases the value of a variable by 1 | --x

```java
3++                         // 3 + 1을 뜻함
int i = 3;
i++;
System.out.println(i);      // 4 출력
++i;
System.out.println(i);      // 5 출력
System.out.println(++i);    // 6 출력, Increment 연산을 먼저 실행한 후에 i를 출력
System.out.println(i++);    // 6 출력, Increment 연산을 실행하기 전에 i를 출력
System.out.println(i);      // 7 출력
```

---
[생활코딩 단항연산자](https://edu.goorm.io/learn/lecture/41/%EB%B0%94%EB%A1%9C%EC%8B%A4%EC%8A%B5-%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94-java/lesson/39167/%EB%8B%A8%ED%95%AD-%EC%97%B0%EC%82%B0%EC%9E%90)

## 비트 연산자

> 0과 1로 표현이 가능한 **정수형**만 비트 연산이 가능하다 \
> 32-bit signed integer \
> 64-bit sigend long integer

Operator | Description | Example | Same as | Result | Decimal
---|---|---|---|---|---
a & b | AND - 둘다 1이어야 1 | 5 & 1 | 0101 & 0001 | 0001 | 1
a \| b | OR - 둘 중 하나만 1이면 1 | 5 \| 1 | 0101 \| 0001 | 0101 | 5
a ~ b | NOT - 1이면 0, 0이면 1 | ~ 5 | ~0101 | 1010 | 10
a ^ b | XOR - 같으면 0, 다르면 1 | 5 ^ 1 | 0101 ^ 0001 | 0100 | 4

### 비트 쉬프트 연산자

Operator | Description |
---|---|
a << b | a의 각 비트를 b만큼 왼쪽으로 이동 (오른쪽에 추가되는 비트는 무조건 0)
a >> b | a의 각 비트를 b만큼 오른쪽으로 이동 (빈비트는 최상위 부호 비트와 같다)
a >>> b | a의 각 비트를 b만큼 오른쪽으로 이동 (왼쪽에 추가되는 비트는 무조건 0)

```java
13 << 3     //                         00000000 00000000 00000000 00001101 << 3
            // 1칸 왼쪽으로 이동 :    0 00000000 00000000 00000000 00011010
            // 1칸 왼쪽으로 이동 :   00 00000000 00000000 00000000 00110100
            // 1칸 왼쪽으로 이동 :  000 00000000 00000000 00000000 01101000
            // 연산 결과(Decimal) : 104

13 >> 3     // 양수일 땐 0           00000000 00000000 00000000 00001101 >> 3
            // 1칸 오른쪽으로 이동 : 00000000 00000000 00000000 00000110 1
            // 1칸 오른쪽으로 이동 : 00000000 00000000 00000000 00000011 01
            // 1칸 오른쪽으로 이동 : 00000000 00000000 00000000 00000001 011
            // 연산 결과(Decimal) : 1

-13 >> 3    // 음수일 땐 1           11111111 11111111 11111111 11110010 >> 3
            // 1칸 오른쪽으로 이동 : 11111111 11111111 11111111 11111001 0
            // 1칸 오른쪽으로 이동 : 11111111 11111111 11111111 11111100 10
            // 1칸 오른쪽으로 이동 : 11111111 11111111 11111111 11111110 010
            // 연산 결과(Decimal) : -1

13 >>> 3    //                      00000000 00000000 00000000 00001101 >> 3
            // 1칸 오른쪽으로 이동 : 00000000 00000000 00000000 00000110 1
            // 1칸 오른쪽으로 이동 : 00000000 00000000 00000000 00000011 01
            // 1칸 오른쪽으로 이동 : 00000000 00000000 00000000 00000001 101
            // 연산 결과(Decimal) : 1

-13 >>> 3   //                      11111111 11111111 11111111 11110010 >> 3
            // 1칸 오른쪽으로 이동 : 01111111 11111111 11111111 11111001 0
            // 1칸 오른쪽으로 이동 : 00111111 11111111 11111111 11111100 10
            // 1칸 오른쪽으로 이동 : 00011111 11111111 11111111 11111110 010
            // 연산 결과(Decimal) : 536870910
```

---
[\[Java\] 비트 연산자 사용법 & 예제](https://coding-factory.tistory.com/521)

## 관계 연산자

> 비교 연산자라고도 한다. 관계 연산자의 결과값은 true나 false인 boolean 타입으로 반환된다.

1. 두개의 변수 또는 리터럴을 비교할 때 사용되는 연산자
2. 관계 연산자 또한 이항 연산자이므로 피연산자의 자료형이 다를 경우에는 자료형의 범위가 큰 쪽으로 형변환을 하여 피연산자의 **타입을 일치시킨 후** 비교 연산을 수행한다

### 등가 비교 연산자

> 두 피연산자에 저장되어 있는 값이 같은지, 다른지를 비교하는 연산자

기본형과 참조형 타입에 사용할 수 있다

- 기본형의 경우 변수에 저장되어 있는 값이 같은지를 알 수 있다
- 참조형의 경우 객체의 주소값을 비교해 두 피연산자가 같은 객체를 가리키는지를 알 수 있다

```java
10 == 10.0f     // true, int 타입인 좌변을 float 타입으로 형변환 후 비교
'0' == 0        // false
'A' == 65       // true, char 타입인 좌변을 int 타입으로 형변환 후 비교
```

### 대소 비교 연산자

> 두 피연산자의 크기를 비교하는 연산자, **boolean 타입과 참조형에는 사용할 수 없다**

Operator | Operation | Example
---|---|---
> | 좌항이 우항보다 큰가 | x > y
< | 좌항이 우항보다 작은가 | x < y
>= | 좌항이 우항보다 크거나 같은가 | x >= y
<= | 좌항이 우항보다 작거나 같은가 | x <= y

---
[\[Java\] 연산자 - 관계, 논리, 조건, 비트 연산자](https://velog.io/@foeverna/Java-%EC%97%B0%EC%82%B0%EC%9E%90-%EA%B4%80%EA%B3%84-%EB%85%BC%EB%A6%AC-%EC%A1%B0%EA%B1%B4-%EB%B9%84%ED%8A%B8-%EC%97%B0%EC%82%B0%EC%9E%90)

## 논리 연산자

> 논리 연산자는 피연산자로 boolean 타입 또는 boolean 타입인 값을 결과로하는 조건식만을 허용한다

Operator | Name | Description | Example
---|---|---|---
&& | 논리 곱 | 양변 모두 true여야 true를 반환 | x < 5 &&  x < 10
\|\| | 논리 합 | 두변 중 하나만 true이면 true를 반환 | x < 5 \|\| x < 4
! | 부정 | Reverse the result, returns false if the result is true | !(x < 5 && x < 10)

1. 논리 곱(&&)이 논리 합(||)보다 우선순위가 높다
2. 논리 합(||)의 경우, 좌항의 피연산자가 true이면 우항의 연산을 생략한다
3. 논리 곱(&&)의 경우, 좌항의 피연산자가 false이면 우항의 연산을 생략한다

## instanceof

> 객체 타입을 확인할 때 사용된다. 형변환이 가능한 지에 대한 해당 여부를 true 또는 false로 알려준다.

```java
class A{}
class B extends A{}

a = new A()
b = new B()

a instanceof Object     // true
a instanceof A          // true
a instanceof B          // true, 자식 클래스에 구현되어야 하는 부분을 a 인스턴스가 가지고 있기때문

b instanceof Object     // true
b instanceof A          // true, 부모 클래스의 프로퍼티와 메소드를 상속받기에 형변환 가능
b instanceof B          // true
```

---
[자바 instanceof 사용방법](https://improver.tistory.com/140) \
[자바 instanceof](https://blog.naver.com/rwans0397/220602620066)

## assignment(=) operator

> 대입 연산자는 변수에 값 또는 수식의 연산결과를 저장하는데 사용된다

1. 좌변에는 항상 **변수**가 위치해야 한다.
2. 우변에는 **리터럴**이나 **변수** 또는 **수식**이 올 수 있다.
3. 대입 연산자(=)는 모든 연산자들 중에서 가장 낮은 우선순위를 갖기에 제일 마지막에 수행된다.
4. 단일 `=` 또는 `(operator)=`로 표현된다.

## 화살표(->) 연산자

> Java 8에서 새로 등장한 feature, lambda function. \
> 화살표 연산자는 lambda 함수를 정의하기 위해 사용된다.

`(Lambda parameters) -> Lambda Body`

- Lambda Parameters : 람다 함수로 넘겨지는 파라미터
- Lambda Body : a code block or an expression

### 람다(Lambda)

코드를 간결하게 만든다.

> 람다의 핵심은 지울 수 있는 건 모두 지우자는 것이다. 모든 걸 컴파일러의 추론에 의지하고 코드로 표현하는 건 다 없애버려 코드를 간결하게 만드는 것이다.

```java
interface Movable{
    void move(String str);
}
```

```java
// 재사용성의 필요를 느끼지 못할 때 익명클래스를 통해 구현되는 Movable
Movable movable = new Movable(){
    @Override
    public void move(String str){
        System.out.println("move move " + str);
    }
};
```

컴파일러의 추론에 맞길 수 있는 부분들

1. 이미 대상 타입(Target Type)에서 `Movable`이라고 명시했기 때문에 `new Movable()` 부분은 없어도 컴파일러가 추론할 수 있다
2. 구현해야 하는 부분은 `move` 메소드 뿐이다. 구현해야할 메소드가 하나 뿐이라면 메소드의 명칭은 중요하지 않다 (익명)
3. 이미 초기화된 인자는 컴파일러가 추론할 수 있을 것이다

위 부분들을 토대로 위 익명클래스를 람다 표현식으로 고쳐보면

```java
Movable movable = (str) -> {
    System.out.println("move move " + str);
};
```

좀 더 간결하게 할 수 있지 않을까

1. 인자가 1개 일 땐, 괄호를 생략해도 되지 않을까
2. 실행 구문이 1줄 일 땐, 중괄호를 생략해도 되지 않을까

```java
Movable movable = str -> System.out.println("move move" + str);
```

### 함수형 인터페이스

위 예제에서 람다 표현식의 정체는 **구현해야하는 추상 메소드가 1개인 인터페이스를 구현한 익명클래스의 메소드**였다. 추상 메소드가 2개인 인터페이스에 대해서는 람다 표현식을 지원하지 않는다. 따라서 람다 표현식으로 구현이 가능한 인터페이스는 **오직 추상 메소드가 하나인 인터페이스** 뿐이다. 해당 인터페이스를 부르는 명칭이 **함수형 인터페이스**이다.

Java 8에서는 `@FunctionalInterface` 어노테이션을 제공해 함수형 인터페이스 임을 표시할 수 있도록 지원한다. 이를 이용해 어떤 인터페이스가 함수형 인터페이스인지를 코드에 표시하여 함수형 인터페이스의 추상 메소드가 1개가 아닐 경우 컴파일 에러를 내도록 의도할 수 있다.

```java
@FunctionalInterface
interface Movable{
    void move(String str);
}
```

물론 어노테이션이 없어도 함수형 인터페이스라면 람다 표현식으로 표현이 가능하지만 어노테이션을 통해 함수형 인터페이스임을 알리는 게 좋다.

### 행위 파라미터화

데이터만 매개변수로 전달하는 것이 아닌 행위(함수) 자체를 매개변수로 전달할 수 있다.

```java
// Fruit class
class Fruit{
    private String name;
    private String color;

    Fruit(String name, String color){
        this.name = name;
        this.color = color;
    }

    String getName(){
        return this.name;
    }

    String getColor(){
        return this.color;
    }
}
```

```java
// 특정 조건을 만족하는 Fruit 인스턴스 리스트를 반환하는 함수들
// 1. name이 'apple'인 Fruit 인스턴스 리스트를 반환하는 함수
List<Fruit> extractApple(List<Fruit> fruits){
    List<Fruit> resultList = new ArrayList<>();
    for (Fruit fruit: fruits){
        if ("apple".equals(fruit.getName())){
            resultList.add(fruit);
        }
    }
    return resultList;
}

// 2. color가 'red'인 Fruit 인스턴스 리스트를 반환하는 함수
List<Fruit> extractRed(List<Fruit> fruits){
    List<Fruit> resultList = new ArrayList<>();
    for (Fruit fruit: fruits){
        if ("red".equals(fruit.getColor())){
            resultList.add(fruit);
        }
    }
    return resultList;
}
```

Fruit 인스턴스를 추출하는 조건만 다를뿐 '추출한다'라는 행위는 동일한 2개의 함수들을 하나의 함수로 합쳐보면

```java
static List<Fruit> extractFruitList(List<Fruit> fruits, Predicate<Fruit> predicate){
    List<Fruit> resultList = new ArrayList<>();
    for (Fruit fruit: fruits){
        if (predicate.test(fruit)){ // 1.
            resultList.add(fruit);
        }
    }
    return resultList;
}
```

1. 추출하는 조건만 Predicate functional interface를 통해 test 메소드를 따로 구현할 수 있도록 제공

따라서 실제 호출한 내용을 살펴보면

```java
List<Fruit> fruits = Arrays.asList(new Fruit("apple", "red"), new Fruit("melon", "green"), new Fruit("banana", "yellow"))
List<Fruit> appleList = extractFruitList(fruits, new Predicate<Fruit>(){
    @Override
    public boolean test(Fruit fruit){
        return "apple".equals(fruit.getName());
    }
});

List<Fruit> redList = extractFruitList(fruits, new Predicate<Fruit>(){
    @Override
    public boolean test(Fruit fruit) {
        return "red".equals(fruit.getColor());
    }
});
```

각 Predicate의 구현체가 하나의 메소드(test)만 구현하고 있다. Predicate는 functional interface로 제공되는 함수형 인터페이스이다. 따라서 해당 구현체들은 다음과 같은 람다 표현식으로 표현될 수 있다.

```java
List<Fruit> appleList = extractFruitList(fruits, fruit -> "apple".equals(fruit.getName()));
List<Fruit> redList = extractFruitList(fruits, fruit -> "red".equals(fruit.getColor()));
```

행위(함수) 자체를 파라미터로 넘기는 기법은 람다 표현식이 있기 전에도 **익명클래스**를 이용해 활용되던 기법이지만 람다 표현식을 이용해 위와 같이 극적으로 간결하게 표현할 수 있게 되었다.

---
[Lambda Expressions in Oracle](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) \
[우리집앞마당 lambda Expression](https://multifrontgarden.tistory.com/124) \
[투덜이의 리얼 블로그 Java 8 Lambda Expression](https://tourspace.tistory.com/6)

## 3항 연산자

> 삼항 연산자는 세 개의 피연산자를 필요로 한다

1. **조건식**과 **조건식이 각각 true나 false일 때 반환되는 값**이 피연산자이다.
2. 삼항 연산자의 조건식에는 연산결과가 boolean 타입인 식이 사용되어야 한다.

```java
// 절대값을 구하는 식
result = (x > 0) ? x : -x   // (조건식) ? ture일 때의 값 : false 일 때의 값
```

## 연산자 우선 순위

### 연산자 종류에 따른 우선순위

1. 최우선연산자 ( ., [], () )
2. 단항연산자 ( ++,--,!,~,+/-   : 부정, bit변환>부호>증감)
3. 산술연산자 ( *,/,%,+,-,shift) < 시프트연산자 ( >>,<<,>>> ) >
4. 비교연산자 ( >,<,>=,<=,==,!= )
5. 비트연산자 ( &,|,,~ )
6. 논리연산자 (&& , || , !)
7. 삼항연산자 (조건식) ? :
8. 대입연산자 =,*=,/=,%=,+=,-=

### 항의 개수에 따른 우선순위

1. 단항 연산자
2. 이항 연산자
3. 삼항 연산자

단, 증감 연산자의 위치에 따라 우선순위가 변경될 수 있다

```java
System.out.println(  5 - 10 * 5 );  // 5 - (10 * 5) = -45
                                    // step 1 > 10과 5의 곱
                                    // step 2 > 5에서 50을 뺀다
                                    // step 3 > 결과 -45를 출력한다

int a = 5;
System.out.println(++a - 5);        // 1
                                    // 단항 연산자이면서, 전위 연산자인 ++가 먼저 연산된다
                                    // step 1 > a에 1을 더해 a가 6이된다
                                    // step 2 > 6인 a에서 5를 뺀다
                                    // step 3 > 결과 6을 출력한다

int a = 5;
System.out.println(a++ - 5);        // 0
                                    // 단항 연산자이면서, 후위 연산자인 ++가 나중에 연산된다
                                    // step 1 > a가 5인 상태에서 a를 뺀다
                                    // step 2 > 결과 0을 출력한다
                                    // step 3 > a에 1을 더해 a에 6이 할당된다
System.out.println(a);              // 6
                                    // 위 연산으로 6이 된 a를 출력한다
```

---
[자바의 연산자 및 우선 순위](https://toma0912.tistory.com/66) \
[프로그래머스 자바 입문 연산자 우선순위](https://programmers.co.kr/learn/courses/5/lessons/116)

## (optional) Java 13. switch 연산자

Java 12까지 쓰던 switch 문의 **break** keyword가 **yield**로 대체되었다.

```java
// Java 12까지 컴파일이 가능한 코드
public class Java12SwitchCaseBreak {

    public static void main(String[] args) {
        getGrade('A');
        getGrade('C');
        getGrade('D');
        getGrade('E');
        getGrade('X');
    }

    public static void getGrade(char grade) {
        System.out.print(switch (grade) {
            case 'A':
                break "Excellent";
            case 'B':
                break "Good";
            case 'C':
                break "Standard";
            case 'D':
                break "Low";
            case 'E':
                break "Very Low";
            default:
                break "Invalid";
        });

        System.out.println(getResult(grade));
    }

    public static String getResult(char grade) {
        return switch (grade) {
            case 'A', 'B', 'C':
                break "::Success";
            case 'D', 'E':
                break "::Fail";
            default:
                break "::No result";
        };
    }
}
```

```java
// break 대신 yield를 사용하는 Java 13의 switch 문
public class Java13SwitchCaseBreak {

    public static void main(String[] args) {
        getGrade('A');
        getGrade('C');
        getGrade('D');
        getGrade('E');
        getGrade('X');
    }

    public static void getGrade(char grade) {
        System.out.print(switch (grade) {
            case 'A': yield "Excellent";
            case 'B': yield "Good";
            case 'C': yield "Standard";
            case 'D': yield "Low";
            case 'E': yield "Very Low";
            default: yield "Invalid";
        });

        System.out.println(getResult(grade));
    }

    public static String getResult(char grade) {
        return switch (grade) {
            case 'A', 'B', 'C' -> "::Success";
            case 'D', 'E' -> "::Fail";
            default -> "::No result";
        };
    }
}
```

break은 yield로 대체 되었으나, 화살표 연산자(->)는 콜론(:)과 함께 Java 12와 마찬가지로 그대로 쓸 수 있다

```java
return switch (grade) {
    case 'A', 'B', 'C' -> "::Success";
    case 'D', 'E' -> "::Fail";
    default -> "::No result";
};
```

---
[Java 13, Switch Expressions(JEP 354)](https://www.dariawan.com/tutorials/java/java-13-switch-expressions-jep-354/) \
[Java 13 Enhanced Switch](https://medium.com/@harshavardhan_reddy/java-13-enhanced-switch-3d22b001ee0d)

---
[W3School operators](https://www.w3schools.com/java/java_operators.asp) \
[\[Java의 정석\] 제 3장 연산자 - 4. 비교 연산자, 5. 그 외의 연산자](https://myeonguni.tistory.com/41)
