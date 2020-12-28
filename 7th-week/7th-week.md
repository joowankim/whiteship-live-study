# 학습할 것 (필수)

자바의 패키지에 대해 학습하세요.

## package 키워드

### 패키지란

자바에서 Package는 클래스, 서브 패키지 그리고 인터페이스로 이루어진 그룹을 캡슐화하는 매커니즘을 말한다. 그리고 다음과 같은 경우를 위해 사용된다:

1. 이름 충돌 방지(Preventing naming conflicts)
2. classes, interfaces, enumerations and annotations를 더 쉽게 찾고, 사용하기 위해
3. 접근 제어
4. 데이터 캡슐화로 간주되기도 한다.

### 패키지가 동작하는 방식

패키지는 directory structure와 밀접한 관련이 있다. 예를 들어 `college.staff.cse`라는 패키지 명이 있다면, 3개의 디렉토리(`college`, `staff`, `cse`)가 존재하며 `cse`는 `staff`안에 `staff`는 `college` 디렉토리 안에 위치한다.

또한, `college` 디렉토리는 **CLASSPATH** 변수를 통해서 접근할 수 있다.

#### 패키지 네이밍 관습

domain name의 역순으로 명명된다. (i.e, org.geeksforgeeks.practice, college.tech.cse, college.tech.ee)

#### 패키지에 클래스 추가하기

1. 패키지 안에 클래스를 생성한다.
2. 클래스를 정의하는 프로그램 코드 맨 윗줄에 패키지 이름을 선언한다.

```java
/* dog.java */
package Animal

public class Dog {
    ...
}
```

#### 서브 패키지

패키지 안에서 사용되는 또 다른 패키지를 말하며 `import` 선언을 통해 사용할 수 있다. 사윙 패키지가 서브 패키지의 멤버에 접근할 수 있는 특별한 권한은 따로 존재하지 않는다.

```java
import java.util.*;
```

### 패키지의 종류

1. Built-in Package
2. User-defined Package

#### Built-in Package

수 많은 패키지가 기본적으로 자바에서 제공되며 그중 자주 쓰이는 몇가지의 용도를 정리해볼 수 있다.

1. `java.lang`: 언어의 기본적인 클래스를 제공하기 때문에 항상 자동으로 import되는 패키지이다. (e.g. 데이터 원시 타입, 수학 연산 등을 포함하는 클래스)
2. `java.io`: Input/Output을 관리하는 클래스를 포함하는 패키지
3. `java.util`: 자료구조나 시간과 같은 유틸리티 클래스를 포함하는 패키지

#### User-defined Package

말 그래도 유저에 의해 정의된 패키지를 말한다.

## import 키워드

### 서브 클래스 내부로 접근하기

```java
// java안에 있는 util 패키지 내에 모든 클래스에 접근하기
import java.util.*;

// java 안에 있는 util 패키지 중 Vector 클래스에 접근하기
import java.util.Vector;
```

### 패키지를 정의하고 사용하기

1. 처음 만들어진, 최상위에 위치하는 디렉토리의 이름은 패키지 이름과 동일해야한다.
2. 그 아래 생성된 디렉토리와 클래스에는 `.`으로 구분하며 접근할 수 있다.

```shell
 `- example
    |- MyClass.java
    `- PrintName.java
```

```java
/* MyClass.java */
package example;

public class MyClass {
    public void getNames(String s) {
        System.out.println(s);
    }
}

/* PrintName.java */
package main.java.example;

import example.MyClass;

public class PrintName 
{
   public static void main(String args[]) 
   {       
      String name = "GeeksforGeeks";
      MyClass obj = new MyClass();
      
      obj.getNames(name);
   }
}
```

### static import

자바 버전 5 이후부터 소개된 기능이다. 한 클래스에 정의된 멤버들(fields와 methods)를 클래스를 특정하지 않고 `public static`으로 자바 코드 안에서 사용될 수 있게 만들어주는 기능을 말한다.

```java
import static java.lang.System.*;

class StaticImportDemo {
    public static void main(String args[]) {
        out.println("Hello world");
    }
}
```

### 이름 충돌 다루기

예를 들어 상황을 살펴보자.  `java.util`과 `java.sql` 패키지는 둘다 `Date`라는 이름의 클래스를 포함한다. 따라서 다음과 같은 코드는 컴파일 에러를 발생시킨다.

```java
import java.util.*;
import java.sql.*;

Date today; // java.util과 java.sql 패키지 모두 
            // Date라는 클래스를 포함하기에 
            // 컴파일러는 어느것을 지칭하는지를 구분할 수 없다.
```

한 쪽에서만 `Date` 클래스를 사용해야 한다면 다음과 같은 코딩이 솔루션이 될 수 있다.

```java
import java.util.Date
import java.sql.*;
```

하지만 양 쪽에서 써야한다면 변수 선언 시에 풀 패키지 명으로 선언해줘야 한다.

```java
java.util.Date deadLine = new java.util.Date();
java.sql.Date today = new java.sql.Date();
```

---
[Packages in Java - GeeksforGeeks](https://www.geeksforgeeks.org/packages-in-java/)

## 클래스패스

![Java 컴파일 과정](https://t1.daumcdn.net/cfile/tistory/991D064B5AE999D512?original)

[그림 출처 - 알짜배기 프로그래머 블로그](https://aljjabaegi.tistory.com/387)

위 그림에서 클래스 로더는 JVM에 바이트 코드(.class)를 불러오는 역할을 한다.
그렇다면 클래스 로더는 어떻게 바이트 코드의 위치를 알 수 있었을까?

JVM의 클래스 로더는 JVM이 시작될 때 **CLASSPATH** 환경 변수를 호출하여 **CLASSPATH** 환경 변수에 설정되어 있는 디렉토리를 파악할 수 있었다.

### 그렇다면 클래스패스는 무엇인가?

클래스패스는 클래스가 위치하고 있는 경로를 말한다. 더 명확하게 말해보자면 **JVM이 프로그램을 실행할 때, 클래스 파일을 찾는데 기준이 되는 파일 경로**를 말한다.

기본적으로는 `java` 명령어가 실행된 위치를 default class path로 갖는다. 하지만 **CLASSPATH 환경 변수 설정**이나 커맨드 라인에서 `java` 명령어에 `-classpath`나 `-cp` 명령을 이용해 설정할 수 있다.

위 그림에서 볼 수 있듯이

1. Java Source code(.java)를 컴파일하면
2. Byte Code(.class) 형태로 변환된다.
3. 이 클래스 파일(Byte Code)에 포함된 명령을 사용하려면 해당 파일을 찾을 수 있어야 한다.
4. 그 경로를 찾기 위해 **CLASSPATH** 환경 변수에 저장된 클래스패스를 사용한다.

---
[자바 클래스패스(classpath)란? - 코딩하는 오징어 블로그](https://effectivesquid.tistory.com/entry/%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4%ED%8C%A8%EC%8A%A4classpath%EB%9E%80)

## CLASSPATH 환경변수

**CLASSPATH** 환경 변수는 앞에서도 언급했듯이 *.class* 파일을 찾기 위한 경로가 저장되어 있는 환경 변수를 말한다. 더 정확히는 ***.class* 파일이 포함된 디렉토리와 파일을 세미콜론(;)으로 구분한 목록**이다.

1. java runtime은 이 **CLASSPATH** 환경 변수에 저장된 경로를 모두 검색해서 특정 클래스에 대한 코드가 포함된 *.class* 파일을 찾는다.
2. 찾으려는 클래스 코드가 포함된 *.class* 파일을 찾으면 해당 파일을 사용한다.

[Windows에서 CLASSPATH 환경 변수 설정하기](https://howtodoinjava.com/java-examples/java-set-classpath-windows/)

## -classpath 옵션

커맨드 라인에서 `java` 명령어를 실행할 때 `-classpath`나 `-cp`를 붙여 클래스패스를 특정할 수 있다. 지금부터는 그 방법과 커맨드 라인에서 CLASSPATH를 설정할 수 있는 또 하나의 방법을 소개하겠다.

#### Use `-classpath` or `-cp`

```shell
C:> sdkTool -classpath classpath1;classpath2...
```

#### Use `set CLASSPATH`

```shell
C:> set CLASSPATH=classpath1;classpath2...
```

1. sdkTool
   - `java`, `javac`, `javadoc`과 같은 커맨드 라인 툴이 해당한다.
2. classpath1;classpath2
   - *.jar*, *.zip*, *.class* 파일이 위치하는 클래스패스를 뜻한다.
   - 각 클래스패스는 파일 이름이나 디렉토리 이름으로 끝나야한다.
3. 다양한 클래스패스를 갖는다면 세미콜론(;)으로 구분한다.
4. default class path는 현재 디렉토리를 가리킨다.
   - 다만, 다른 클래스 패스를 추가하려고 `-classpath` 옵션이나 `set`을 사용한다면 `.`을 맨 앞에 붙여 현재 위치를 클래스패스 목록에 추가할 수 있다.
5. 디렉토리, 아카이브(.zip or .jar files)나 `*`이 아닌 클래스패스는 무시된다.

---
[Setting the class path - Oracle Java SE Document](https://docs.oracle.com/javase/7/docs/technotes/tools/windows/classpath.html)

## 접근지시자

자바에서는 클래스, 인터페이스나 멤버에 대한 접근을 제어할 수 있는 접근 지시자(Access Modifier)라는 것을 제공한다. Effective Java에서는 Access Control Mechanism으로 표현하고 있다.

**선언 위치**에 따라 위에서 언급한 항목들에 대해 접근성이 정해진다는 것이다.

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
Effective Java 3rd Edition
