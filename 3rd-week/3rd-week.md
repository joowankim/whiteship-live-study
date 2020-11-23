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

`(Lambda parameters) -> {LambdaBody}`

- Lambda Parameters : 람다 함수로 넘겨지는 파라미터
- Lambda Body : a code block or an expression

람다 함수는 함수 자체를 method의 인수로 처리하거나 코드를 데이터로 처리할 수 있게 해준다.

---
[Lambda Expressions in Oracle](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

## 3항 연산자

> 삼항 연산자는 세 개의 피연산자를 필요로 한다

1. **조건식**과 **조건식이 각각 true나 false일 때 반환되는 값**이 피연산자이다.
2. 삼항 연산자의 조건식에는 연산결과가 boolean 타입인 식이 사용되어야 한다.

```java
// 절대값을 구하는 식
result = (x > 0) ? x : -x   // (조건식) ? ture일 때의 값 : false 일 때의 값
```

## 연산자 우선 순위

## (optional) Java 13. switch 연산자

---
[W3School operators](https://www.w3schools.com/java/java_operators.asp) \
[\[Java의 정석\] 제 3장 연산자 - 4. 비교 연산자, 5. 그 외의 연산자](https://myeonguni.tistory.com/41)
