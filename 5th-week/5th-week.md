# 학습할 것 (필수)

## 클래스 정의하는 방법

> 클래스는 현실의 객체들을 추상화하여 만들어낸 소스 형태의 산출물이다. 클래스는 선언부와 몸체로 나뉘며 몸체에는 **클래스 멤버**가 선언된다.

```java
<클래스 선언부> {
    <클래스 몸체>
}
```

### Access Control Mechanism

> The access control mechanism **specifies the accessibility of classes, interfaces, and members**. The accessibility of an entity is determined by the **location** of its declaration and by which, if any, of the access modifiers is present on the declaration.

**top-level(non-nested) classes and interfaces**, there are only two possible access levels:

- `package-private`
- `public`

**For members (fields, methods, nested classes, and nested interfaces)**, there are four possible access levels, listed here in order of increasing accessibility:

- `private`: **해당 멤버가 선언된 클래스(top-level class) 안**에서만 접근할 수 있다.
- `package-private`: 해당 멤버가 선언된 **패키지 안**에서만 접근할 수 있다.
- `protected`:
  - 해당 멤버가 **선언된 클래스의 자식 클래스**에서 접근할 수 있다.
  - 해당 멤버가 **선언된 패키지 내의 어느 클래스**에서든 접근할 수 있다.
- `public`: 어디서든 접근이 가능하다.

---
[\[Java\] 클래스 선언, 구성요소(생성자, 멤버변수, 메서드) - cristoval blog](https://data-make.tistory.com/194)
Effective Java 3rd Edition

## 객체 만드는 방법 (new 키워드 이해하기)

`new` 연산자를 사용하여 객체를 생성할 수 있다.

```java
public class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public void getName() {
        return this.name;
    }
    
    public static void main(String[] args) {
        Person p = new Person("A");
    }
}
```

### new 연산자

```java
클래스 객체 변수 = new 클래스();
```

1. `new` 연산자를 통해 메모리(Heap 영역)에 데이터를 저장할 공간을 할당 받는다.
2. 앞서 할당 받은 공간의 참조값을 객체에게 반환한다.
3. 그리고 나서 생성자를 호출한다.

따라서 위 `new` 생성자 선언 문법을 다시 보면

1. 클래스: 생성될 객체의 자료형이다.
2. 객체 변수: 생성된 객체의 참조값을 저장하는 변수이다.
3. `new`: 데이터 공간을 할당 받고, 해당 공간의 참조 값을 객체에 반환한다.
4. 클래스(): 생성자를 호출한다.

---
[자바 클래스 2. 객체의 정의와 생성방법(new 연산자) - nukestorm tistory blog](https://nukestorm.tistory.com/79) \
[\[JAVA\\자바\] new 연산자 - JOKER naver blog](https://m.blog.naver.com/PostView.nhn?blogId=heartflow89&logNo=220955262405&proxyReferer=https:%2F%2Fwww.google.com%2F)

## 메소드 정의하는 방법

메소드를 정의하기 위해 필요한 구성요소는 다음과 같다.

1. 접근 제어자
2. 반환 타입
3. 메소드 명
4. 메소드 파라미터(optional)
5. 메소드 바디

```java
public class practiceMethod {
    public String normal() {
        return "normal";
    }

    public static String staticNormal() {
        return "static normal";
    }

    public static void main(String args[]) {
        App app = new App();
        System.out.println(app.normal());
        System.out.println(staticNormal());
    }
}
```

위 코드에서 살펴볼 거리는 크게 3가지라고 생각한다.

1. 일반 메소드 `normal()`
2. `static` 메소드
3. `main` 메소드

### 일반 메소드 `normal()`

위에서 `normal()` 메소드는 깔끔하게 접근성 변경자와 반환 타입, 클래스 명, 메소드 바디를 통해 평범하게(?) 선언되었다. 이 선언의 의미는 해당 메소드는 이를 포함하는 클래스의 **인스턴스와 함께 동작**한다는 것이다.

처음 위 예제 코드를 짜고 다음과 같이 코드를 만든 다음 실행시켜 보았다.

```java
public class practiceMethod {
    public String normal() {
        return "normal";
    }
    public static void main(String args[]) {
        System.out.println(normal());
    }
}
```

결과는 빌드가 되지 않았다. 해당 메소드의 바디의 내용은 클래스의 어떤 요소와도 상관은 없다. 하지만 위와 같은 선언은 `practiceMethod` 클래스의 인스턴스가 사용할 수 있는 메소드를 선언하는 것이었기에 `normal()` 메소드는 독립적으로 쓰일 수 없었다.

따라서 다음과 같이 코드를 바꿔 준 후에 코드가 실행되는 것을 확인할 수 있었다.

```java
public class practiceMethod {
    public String normal() {
        return "normal";
    }
    public static void main(String args[]) {
        App app = new App();
        System.out.println(app.normal());
    }
}
```

### `static` 메소드

`normal()` 메소드 예제를 통해 **메소드는 클래스의 인스턴스에 귀속된다**는 것을 알 수 있었다. 그렇다면 "**클래스와 맥락적으로 연관은 되어 있지만 클래스의 인스턴스와는 독립적으로 사용하고 싶은 메소드에 대해서는 어떻게 선언을 해야하는 것인가?**"라는 질문에 대해 생각해볼 수 있을거 같다.

클래스의 인스턴스와 독립적이고 싶다면 클래스 밖에 해당 메소드를 **함수**로써 선언을 해도 될 것 같았다. 하지만 자바에서는 클래스 밖의 함수, 즉 최상위 함수를 선언할 수 없었다.

```java
public String topNormal() {
    return "top normal";    
}

public class App {...}
```

- 위 코드를 실행할 경우 자바의 컴파일러는 Syntax error를 일으킨다.
- 따라서 자바에서는 클래스 밖에 함수를 선언할 수 없기에 함수는 항상 클래스 안에만 존재하며 이는 **메소드**라 불린다.

자바는 이에 대한 해답으로 `static` 선언을 주어줬다고 생각한다. 우리는 `static` 선언을 통해 해당 메소드를 **메모리의 static 영역**에 저장할 수 있다. 이를 통해 클래스의 인스턴스를 따로 생성하지 않고 해당 메소드를 사용할 수 있다.

여기서 한가지 궁금증이 생겼다.

#### `static` 메소드를 객체 생성없이 사용할 수 있다면, `static` 메소드가 생성되지 않은 객체를 사용하려 할 때는 어떻게 반응하는가?

이에 대한 대답은 **`static` 메소드는 해당 클래스의 `static` 변수만 사용할 수 있다**는 것 이었다.

```java
public class App 
{
    public String param1 = "hello public";
    public static String param2 = "hello public static";
    private static String param3 = "hello private static";

    public static String returnParam1() {
        return this.param1; // 클래스의 일반 변수인 param1에는 접근이 불가능해서 빌드조차 할 수 없었다.
    }

    public static String returnParam2() {
        return param2;  // static 변수에는 접근할 수 있었으며 this는 붙일 수 없었다.
    }

    public static String returnParam3() {
        return param3;  // 접근 제어자는 같은 클래스 내이기에 관계 없었다.
    }

    ...
}
```

### `main` 메소드

1. 자바 어플리케이션 실행 시 제일 먼저 동작하는 메소드
2. 어느 객체에서든 접근할 수 있다.  (`public`)
3. 자바가 컴파일이 되는 순간 정의된다.  (`static`)
4. 반환 값이 없다. (`void`)
5. 커맨드 라인에서 호출시 arguments를 넘겨받아 사용할 수 있다. (`String[] args`)

---
[\[JAVA\\자바\] 메모리 구조(static, stack, heap) - JOKER naver blog](https://m.blog.naver.com/heartflow89/220954420688) \
[\[Java\] static 변수와 static 메소드 - 망나니개발자 tistory blog](https://mangkyu.tistory.com/47)
[\[JAVA\] 메인 메소드 public static void main(Stringp[] args)를 이해하자 - 버물리의 IT 공부](https://javacpro.tistory.com/11)

## 생성자 정의하는 방법

> 생성자란 객체가 메모리에 할당 될 때마다 **자동으로 실행되는 메소드**를 의미한다. 객체가 생성될 때 **한 번 호출**되는 메소드이며, 리턴형이 없고 **클래스 명과 메소드 명**이 같다. 그리고 반드시 **`public`** 접근 제한자가 붙는다.

1. 디폴트 생성자
2. 매개변수를 갖는 생성자
3. 생성자 오버로딩
4. 생성자에서 다른 생성자 호출

### 디폴트 생성자

따로 생성자를 정의하지 않아도 컴파일러가 기본적으로 제공하는 생성자를 말한다.

```java
public class App 
{
    public String normal() {
        return "normal";
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.normal());
    }
}
```

위 코드는 생성자를 따로 정의하지 않았음에도 `new App()`을 통해 새로운 `App` 타입의 객체를 생성할 수 있다.

### 매개변수를 갖는 생성자

메소드와 비슷한 모양을 가지고 있지만 반환 타입이 없으며 클래스 이름과 동일한 메소드 명을 사용해야 한다.

```java
public class App 
{
    private String name;

    public App(String name) {
        this.name = name;
    }

    public String normal() {
        return "normal " + this.name;
    }

    public static void main(String[] args) {
        App app = new App("app name");
        System.out.println(app.normal());
    }
}
```

### 생성자 오버로딩

생성자 오버로딩을 통해서 여러개의 생성자를 정의할 수 있으며 그에 따라 매개변수를 서로 다르게 정의할 수 있다.

```java
public class App 
{
    private String name;
    private String version;

    public App() {}
    
    public App(String name) {
        this.name = name;
    }

    public App(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String normal() {
        return "normal " + this.name;
    }

    public static void main(String[] args) {
        App app = new App("app name");
        System.out.println(app.normal());
    }
}
```

### 생성자에서 다른 생성자 호출

생성자에서 다른 생성자를 호출할 때는 `this()`를 사용한다. `this()` 호출은 생성자의 첫 줄에서만 호출이 가능하다.

```java
public class App 
{
    private String name;
    private String version;

    public App() {}
    
    public App(String name) {
        this(name, "0.0.0")
    }

    public App(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String normal() {
        return "normal " + this.name;
    }

    public static void main(String[] args) {
        App app = new App("app name");
        System.out.println(app.normal());
    }
}
```

---
[\[스터디_자바 기본\] 21. 생성자(Constructor) - 세바의 코딩교실](https://programmer-seva.tistory.com/79)

## this 키워드 이해하기

`this`는 `this`가 사용되는 클래스의 인스턴스이다. 어렵다. 예제를 보자.

```java
public class App 
{
    private String name;
    private String version;

    public App() {}
    
    public App(String name) {
        this(name, "0.0.0") // 4.
    }

    public App(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String normal() {
        return "normal " + this.name;   // 3.
    }

    public static void main(String[] args) {
        App app = new App("app name");      // 1.
        System.out.println(app.normal());   // 2.
    }
}
```

1. 새로운 `App` 타입의 객체가 생성되어 `app` 변수에 참조값이 저장되었다.
2. 객체 `app`은 자신의 메소드 `normal()`을 호출한다.
3. `app` 객체의 메소드 `normal()`은 `this`를 통해 `app` 객체의 프로퍼티에 접근한다.
4. `this()` 메소드는 생성자에서 다른 생성자를 사용하려 할 때만 쓰이는 메소드로 `this` 객체와는 다르다.
