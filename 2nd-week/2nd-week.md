# 자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법을 익힙니다

## 프리미티브 타입 종류와 값의 범위 그리고 기본 값

<table>
    <tr>
        <td></td>
        <td>타입</td>
        <td>할당되는 메모리 크기</td>
        <td>기본값</td>
        <td>데이터의 표현 범위</td>
    </tr>
    <tr>
        <td>논리형</td>
        <td>boolean</td>
        <td>1 byte</td>
        <td>false</td>
        <td>true, false</td>
    </tr>
    <tr>
        <td rowspan="4">정수형</td>
        <td>byte</td>
        <td>1 byte</td>
        <td>0</td>
        <td>-128 ~ 127</td>
    </tr>
    <tr>
        <td>short</td>
        <td>2 byte</td>
        <td>0</td>
        <td>-32,768 ~ 32,767</td>
    </tr>
    <tr>
        <td>int</td>
        <td>4 byte</td>
        <td>0</td>
        <td>-2,147,483,648 ~ 2,147,483,647</td>
    </tr>
    <tr>
        <td>long</td>
        <td>8 byte</td>
        <td>0L</td>
        <td>-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807</td>
    </tr>
    <tr>
        <td rowspan="2">실수형</td>
        <td>float</td>
        <td>4 byte</td>
        <td>0.0F</td>
        <td>(3.4 X 10<sup>-38</sup> ) ~ (3.4 X 10<sup>38</sup>) 의 근사값</td>
    </tr>
    <tr>
        <td>double</td>
        <td>8 byte</td>
        <td>0.0</td>
        <td>(1.7 X 10<sup>-308</sup>) ~ (1.7 X 10<sup>308</sup>) 의 근사값</td>
    </tr>
    <tr>
        <td>문자형</td>
        <td>char</td>
        <td>2 byte (유니코드)</td>
        <td>'\u0000'</td>
        <td>0 ~ 65,535</td>
    </tr>
</table>

## 프리미티브 타입과 레퍼런스 타입

| 프리미티브 타입 | 레퍼런스 타입 |
|---|---|
| 언어에서 기본적으로 제공되는 데이터의 타입 |  기본형 타입을 제외한 모든 타입들 |
| 기본값이 있기 때문에 Null이 존재하지 않음 > 기본형 타입에 Null을 할당하고 싶다면 Wrapper 클래스를 사용해야한다. | 빈 객체를 의미하는 Null이 존재 |
| **실제 값**을 저장하는 공간인 **Stack** 메모리에 저장됨 | 값이 저장되어 있는 곳의 **주소값**을 저장하는 공간으로 **Heap** 메모리에 저장됨 |

## 리터럴

**리터럴**

1. 자바 언어가 처리하는 실제 데이터
2. 자료형마다 표현방식이 다름
3. 변수에 저장되는 변하지 않는 데이터

| 타입 | 표현 예시 |
|---|---|
| 문자형 | '\uC790' --> '자' |
| 정수형 | 234, 030, 0xA4, 0b1010 |
| 실수형 | 3.14, 6.02E23, 2.718F, 123.4E+306D |
| 논리형 | true, false |

#### vs 상수

1. 상수는 변하지 않는 **변수**, 리터럴은 변하지 않는 **데이터**
2. final로 상수를 만들 수는 있으나 이것이 가리키는 객체를 변화시키는 건 가능하다

## 변수 선언 및 초기화하는 방법

```java
int i;          // <데이터 타입> <변수명>;
float a, b;     // <데이터 타입> <변수명>, <변수명>;

i = 1;          // <변수명> = <리터럴>
```

1. 변수 선언 : 값을 저장할 수 있는 메모리 주소에 이름을 붙여 <변수명>으로 해당 메모리 공간에 접근이 가능하게 함
2. 변수 초기화 : 선언한 객체에 최초로 값을 넣어 주는 것

## 변수의 스코프와 라이프타임

선언 위치에 따른 변수의 종류

1. Instance Variables: 클래스 내부, 모든 메소드 및 블록 외부에 선언된 변수
2. Class Variables: 클래스 내부에서, 모든 블록 외부에 static으로 선언된 변수
    - 메모리에 한 번만 올라감
3. Local Variables: 함수 내부에 선언된 변수

```java
/*
 * 출처 : Scope and Lifetime of a Variable in Java
 */
public class scope_and_lifetime {
    int num1, num2;   //Instance Variables
    static int result;  //Class Variable
    int add(int a, int b){  //Local Variables
        num1 = a;
        num2 = b;
        return a+b;
    }
    public static void main(String args[]){
        scope_and_lifetime ob = new scope_and_lifetime();
        result = ob.add(10, 20);
        System.out.println("Sum = " + result);
    }
}
```

|| scope | lifetime |
|---|---|---|
| Instance variables | static method를 제외한 클래스 전역 | 클래스의 인스턴스가 메모리에 남아있을 때까지 |
| Class variables | 클래스 전역 | 프로그램의 시작부터 끝까지 |
| Local variables | 선언된 블럭 안 | 선언된 블럭 실행이 끝날 때까지 |

## 타입 변환, 캐스팅 그리고 타입 프로모션

> 자료형이 정해진 변수에 값을 넣을때는 \
> 변수가 원하는 정보를 하나도 빠짐 없이 다 넣어줘야 성립한다.
 
#### 프리미티브 타입의 형변환

1. 강제 형변환(Casting)
   - 프로그램 실행 도중에 자동적으로 형변환이 일어나는 것
   - 대체적으로 작은 메모리 크기의 데이터 타입을 큰 메모리 크기의 데이터 타입으로 변환하는 행위
   - 메모리 크기가 큰 데이터 타입이라도, 타입 범위를 포함하지 못한다면 자동 형변환(Promotion) 이 불가능하다 (e.g. byte -> char, float -> long)
2. 자동 형변환(Promotion)
   - 큰 메모리 크기의 데이터 타입을 작은 메모리 타입으로 강제로 변환하는 행위
   - 데이터 손실의 위험이 따른다
   - 특정 변수의 최대값과 같은 사항을 파악한 후 사용해야 데이터 손실을 방지할 수 있다

#### 레퍼런스 타입의 형변환

1. 업캐스팅(Up-Casting)
   - 부모를 상속 받는 자식 인스턴스의 데이터 타입을 부모 타입으로 형변환 시키는 것
2. 다운캐스팅(Down-Casting)
   - 부모 인스턴스를 자식 데이터 타입으로 형변환 시키는 것
   - 일반적인 경우에는 성립하지 않는다
   - 하지만 자식 데이터 타입이 요구하는 **정보**를 부모 인스턴스가 가지고 있다면 성립한다

```java
Parent parent = (Parent) new Child();   // up-casting

Parent parent = new Child();            // down-casting
Child child = (Child)parent;
```

## 1차 및 2차 배열 선언하기

배열(Array): 선형 자료구조 중 하나로, 동일한 타입의 연관된 데이터를 메모리에 연속적으로 저장하여 하나의 변수에 묶어서 관리하기 위한 자료구조.

- **배열의 길이**는 최초 선언한 값으로 **고정**됨
- **Index**를 통해 데이터에 접근할 수 있음

```java
// 크기 할당 & 초기화 없이 배열 참조변수만 선언
int[] arr;
int arr[];

// 선언과 동시에 배열 크기 할당
int[] arr_int = new int[5];
char[] arr_chr = new char[5];
String[] arr_str = new String[5];
// arr_int[0] >> 0
// arr_chr[0] >> .
// arr_str[0] >> null

// 기존 배열의 참조 변수에 초기화 할당
int[] arr;
arr = new int[5];               // {0, 0, 0, 0, 0}
int[] arr = {1, 3, 5, 7, 9};    // 참조변수를 선언 후 새로운 배열 {1, 3, 5, 7, 9}를 arr에 할당

// 선언과 동시에 배열의 크기 지정 및 값 초기화
int[] arr = new int[]{1,2,3,4,5};
int[] odds = {1, 3, 5, 7, 9};
String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};

// 2차원 배열 선언
int[][] arr = new int[4][3];
int[][] arr = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}, {3, 4, 5}};
// arr[0] >> {2, 5, 3}
// arr[1] >> {4, 4, 1}
// arr[2] >> {1, 7, 3}
// arr[3] >> {3, 4, 5}
```

## 타입 추론, var

타입 추론: 개발자가 매개 변수의 타입을 매번 명시하도록 강제하기 보다는 컴파일러가 스스로 매개 변수의 타입이 무엇인지 알아내는 것

#### var

1. Java 10부터 추가된 타입 추론을 지원하는 `var` 키워드
2. local variables만 선언 가능하며 initializer가 요구됨

부적절한 var 사용 예시

```java
// 'var' must work with initializer
var n;
//>> error: cannot use 'var' on variable without initializer

// 'var' must not be initialized with 'null'
var emptyList = null;
//>> error: variable initializer is 'null'

// it must work with local variables
public var helloSting = "hello";
//>> error: 'var' is not allowed here

// Lamda expression needs explicit target type, so 'var' cannot be used
var p = (String s) -> s.length() > 10;
//>> error: lambda expression needs an explicit target-type

// array initializer needs explicit target-type
var arr = {1, 2, 3};
//>> error: array initializer needs an explicit target-type
```

---

[자바의 데이터 타입](https://gbsb.tistory.com/6) \
[상수와 리터럴이란](https://mommoo.tistory.com/14) \
[JAVA 리터럴](https://codingisgame.tistory.com/3) \
[Scope and Lifetime of a Variable in Java](https://www.learningjournal.guru/article/programming-in-java/scope-and-lifetime-of-a-variable/) \
[자바의 변수](https://itmining.tistory.com/20) \
[타입 형변환](https://kamang-it.tistory.com/entry/Java-19%ED%83%80%EC%9E%85%ED%98%95-%EB%B3%80%ED%99%98Type-Casting) \
[Java 데이터 타입 자동 형변환(Promotion)과 강제 형변환(Casting)](https://stage-loving-developers.tistory.com/8) \
[개발자로 홀로 서기](https://mommoo.tistory.com/41) \
[Java 배열(Array) 선언 및 초기화 하기](https://ifuwanna.tistory.com/231) \
[Dale Seo님의 Engineering blog](https://www.daleseo.com/java8-lambdas-part1-2/) \
[Java 타입추론](https://velog.io/@bk_log/Java-%ED%83%80%EC%9E%85-%EC%B6%94%EB%A1%A0) \
[Java 10 Local variable Type-Inference](https://www.baeldung.com/java-10-local-variable-type-inference)
