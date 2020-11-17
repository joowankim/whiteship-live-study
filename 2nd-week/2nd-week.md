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

스코프 : 변수를 사용할 수 있는 영역
라이프타임 : 

## 타입 변환, 캐스팅 그리고 타입 프로모션

## 1차 및 2차 배열 선언하기

## 타입 추론, var

---

[자바의 데이터 타입](https://gbsb.tistory.com/6) \
[상수와 리터럴이란](https://mommoo.tistory.com/14) \
[JAVA 리터럴](https://codingisgame.tistory.com/3) \
[Scope and Lifetime of a Variable in Java](https://www.learningjournal.guru/article/programming-in-java/scope-and-lifetime-of-a-variable/) \
