# 학습할 것 (필수)

- [학습할 것 (필수)](#학습할-것-필수)
	- [Java annotation이란](#java-annotation이란)
		- [메타데이터](#메타데이터)
		- [어노테이션의 기능](#어노테이션의-기능)
	- [리플렉션?](#리플렉션)
	- [롬복?](#롬복)
		- [애노테이션 프로세서](#애노테이션-프로세서)
	- [애노테이션 정의하는 방법](#애노테이션-정의하는-방법)
	- [@retention](#retention)
		- [`RetentionPolicy`](#retentionpolicy)
			- [be read reflectively?](#be-read-reflectively)
		- [`RetentionPolicy`에 따른 어노테이션의 차이점 확인하기](#retentionpolicy에-따른-어노테이션의-차이점-확인하기)
	- [@target](#target)
		- [ElementType 클래스](#elementtype-클래스)
			- [1.5 버전부터 추가된 것들](#15-버전부터-추가된-것들)
			- [1.8 이후에 추가된 것들](#18-이후에-추가된-것들)
			- [Java 9 이후에 추가된 것](#java-9-이후에-추가된-것)
	- [@documented](#documented)
	- [애노테이션 프로세서](#애노테이션-프로세서-1)

## Java annotation이란

소스 코드에 추가할 수 있는 메타데이터의 일종이다. 일반적으로 `@` 기호를 앞에 붙여서 사용하며 JDK 1.5 버전 이상부터 사용할 수 있다. 자바 어노테이션은 클래스 파일에 임베디드되어 컴파일러에 의해 생성된 후 자바 가상머신에 포함되어 작동한다.

### 메타데이터

어플리케이션이 처리해야 할 데이터가 아니라, 컴파일 과정과 실행 과정에서 코드를 어떻게 컴파일하고 처리할 것인지를 알려주는 정보를 말한다.

### 어노테이션의 기능

1. 컴파일러에 추가적인 문법 정보를 제공해 추가적인 상황에서 에러를 낼 수 있도록 만든다.
2. 빌드나 배치 시에 .class 파일에 코드를 자동으로 생성할 수 있다.
3. 실행 시 특정 기능을 실행하도록 정보를 제공할 수 있다.

---
https://coding-factory.tistory.com/575

## 리플렉션?

## 롬복?

### 애노테이션 프로세서

애노테이션이 붙어있는 클래스의 정보를 트리구조로 참조할 수 있다. 소스코드의 AST를 조작한다.

- 공개된 API가 아닌 **컴파일러 내부 클래스**를 사용해 코드를 조작한다.

컴파일타임에 어떻게 코드를 만들어 낼 수 있는가

## 애노테이션 정의하는 방법

```java
public @interface AnnotationName {
	int value1() default 1;
	String value2();
}
```

1. interface 키워드 앞에 `@`를 붙여 어노테이션 명과 함께 선언한다.
2. 어노테이션의 인자에 default 값을 설정해 인자에 대한 값을 넣지 않게 할 수 있다.
3. default 값이 할당되지 않은 인자는 필수적으로 값을 넘겨 받아야 한다.
4. 각 엘리멘트 뒤에는 괄호를 붙여야 한다.

---
https://coding-factory.tistory.com/575

## @retention

어노테이션을 어느 단계까지 유지할 것인지 결정할 때 사용할 수 있다. 여기서 **어느 단계**라는 말은 `RetentionPoilcy` 타입의 인스턴스를 말하며 `SOURCE`, `CLASS`, `RUNTIME` 단계로 나뉜다.

### `RetentionPolicy`

그렇다면 `@Retention` 어노테이션의 인자로 사용되는 `RetentionPolicy`란 무엇인지 살펴보자. 소스 코드는 다음과 같다.

```java
package java.lang.annotation;

/**
 * Annotation retention policy.  The constants of this enumerated type
 * describe the various policies for retaining annotations.  They are used
 * in conjunction with the {@link Retention} meta-annotation type to specify
 * how long annotations are to be retained.
 *
 * @author  Joshua Bloch
 * @since 1.5
 */
public enum RetentionPolicy {
    /**
     * Annotations are to be discarded by the compiler.
     */
    SOURCE,

    /**
     * Annotations are to be recorded in the class file by the compiler
     * but need not be retained by the VM at run time.  This is the default
     * behavior.
     */
    CLASS,

    /**
     * Annotations are to be recorded in the class file by the compiler and
     * retained by the VM at run time, so they may be read reflectively.
     *
     * @see java.lang.reflect.AnnotatedElement
     */
    RUNTIME
}

```

1. 전체적인 설명으로는 앞에서 말했던 것과 같이 `RetentionPolicy`의 각 상수들은 어노테이션이 어느 시점까지 유지될지를 특정한다고 설명하고 있다.
2. `enum` 키워드를 사용해 `RetentionPolicy` 기간들에 대한 인스턴스를 상수화시켰다.
3. `RetentionPolicy`는 총 3가지 기간으로 나뉜다. 설명은 모두 `@Retention` 어노테이션이 사용된 어노테이션에 적용된 유효기간(?)을 설명하고 있다.
	- `SOURCE`: 컴파일 단계에서 어노테이션이 사라진다.
	- `CLASS`: .class 파일까지 어노테이션이 유지되지만 Runtime엔 사라진다. (별도의 `@Retention` 선언이 없는 어노테이션은 해당 `RetentionPolicy`가 default로 부여된다.)
	- `RUNTIME`: .class 파일에도 기록이되며 런타임에도 읽을 수 있다.

#### be read reflectively?

### `RetentionPolicy`에 따른 어노테이션의 차이점 확인하기

위 설명대로라면 어노테이션에 `RetentionPolicy`를 적용한 어노테이션이 .class파일에서 보일 수도 있고 안 보일 수도 있으며 실제 런타임에서도 어노테이션을 읽을 수도 있고 아닐 수도 있다. 그 차이를 간단한 코드로 확인해보자.

1. 다음과 같은 어노테이션들을 선언한다.

	```java
	/* ClassAnnotation.java */
	@Retention(RetentionPolicy.CLASS)
	public @interface ClassAnnotation {
	}

	/* DefaultAnnotation.java */
	public @interface DefaultAnnotation {
	}

	/* SourceAnnotation.java */
	@Retention(RetentionPolicy.SOURCE)
	public @interface SourceAnnotation {
	}

	/* RuntimeAnnotation.java */
	@Retention(RetentionPolicy.RUNTIME)
	public @interface RuntimeAnnotation {
	}
	```

2. 각각의 어노테이션이 적용된 메소드를 선언한다.

	```java
	/* AnotExample.java */
	public class AnotExample {
		public static void main(String[] args) {
		}

		@ClassAnnotation
		void myClassMethod(){

		}

		@DefaultAnnotation
		void defaultMethod(){

		}

		@SourceAnnotation
		void sourceMethod(){

		}

		@RuntimeAnnotation
		void runtimeMethod(){

		}
	}
	```

3. 컴파일 후 class 파일을 확인한다.

	```java
	public class AnotExample {
		public AnotExample() {
		}

		public static void main(String[] args) {
		}

		@ClassAnnotation
		void myClassMethod() {
		}

		@DefaultAnnotation
		void defaultMethod() {
		}

		void sourceMethod() {
		}

		@RuntimeAnnotation
		void runtimeMethod() {
		}
	}
	```

	- `@SourceAnnotation`을 찾을 수 없다.
	- 그 외 어노테이션은 모두 class파일 안에서 찾을 수 있었다.

4. IntelliJ CE의 힘을 빌려 바이트 코드를 확인해보자. (코드가 너무 길어서 생성자와 main method 부분은 생략했다.)

	```
	// access flags 0x0
	myClassMethod()V
	@LClassAnnotation;() // invisible
	L0
		LINENUMBER 14 L0
		RETURN
	L1
		LOCALVARIABLE this LAnotExample; L0 L1 0
		MAXSTACK = 0
		MAXLOCALS = 1

	// access flags 0x0
	defaultMethod()V
	@LDefaultAnnotation;() // invisible
	L0
		LINENUMBER 19 L0
		RETURN
	L1
		LOCALVARIABLE this LAnotExample; L0 L1 0
		MAXSTACK = 0
		MAXLOCALS = 1

	// access flags 0x0
	sourceMethod()V
	L0
		LINENUMBER 24 L0
		RETURN
	L1
		LOCALVARIABLE this LAnotExample; L0 L1 0
		MAXSTACK = 0
		MAXLOCALS = 1

	// access flags 0x0
	runtimeMethod()V
	@LRuntimeAnnotation;()
	L0
		LINENUMBER 29 L0
		RETURN
	L1
		LOCALVARIABLE this LAnotExample; L0 L1 0
		MAXSTACK = 0
		MAXLOCALS = 1
	```

	- 마찬가지로 `@SourceAnnotation`은 찾을 수 없다.
	- `@ClassAnnotation`과 `@DefaultAnnotation`은 `LINENUMBER`를 제외하면 모두 같다.
	- `@RuntimeAnnotation`은 `@ClassAnnotation`과는 다르게 `// invisible`이 보이지 않는다.

---
https://sas-study.tistory.com/329

## @target

어노테이션을 적용할 대상을 지정할 때 사용한다.
```java
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Target {
    /**
     * Returns an array of the kinds of elements an annotation type
     * can be applied to.
     * @return an array of the kinds of elements an annotation type
     * can be applied to
     */
    ElementType[] value();
}
```

1. 해당 어노테이션은 `RUNTIME`까지 적용된다.
2. `ElementType` enum 클래스의 인스턴스를 인자로 받아 해당 어노테이션을 적용할 Element의 타입을 규정한다.

### ElementType 클래스

ElementType 클래스에서는 `@Target` 어노테이션을 사용할 때 인자로 넘겨줄 적용대상에 대한 열거 타입들을 볼 수 있었다. 그 중에서 다른 것들과는 다르게 주석에서 유난히 많은 비중을 차지하는 `TYPE_USE`라는 열거 타입도 있었다.

`TYPE_USE`라는 열거 타입의 경우는 적용 대상으로 쓰이기 보다는 필드를 하나의 타입으로서 선언한다던가 하는 등의 용도로 사용되는 것 같았다.

#### 1.5 버전부터 추가된 것들

| ElementType 열거 상수 | 적용 대상 |
|---|---|
| TYPE | 클래스, 인터페이스, 열거 타입 |
| ANNOTATION_TYPE | 어노테이션 |
| FIELD | 필드 |
| CONSTRUCTOR | 생성자 |
| METHOD | 메소드 |
| LOCAL_VARIABLE | 지역 변수 |
| PACKAGE | 패키지 |
| PARAMETER | 파라미터 |

#### 1.8 이후에 추가된 것들

| ElementType 열거 상수 | 적용 대상 |
|---|---|
| TYPE_PARAMETER | 타입 파라미터 |
| TYPE_USE | use of a type |

#### Java 9 이후에 추가된 것

| ElementType 열거 상수 | 적용 대상 |
|---|---|
| MODULE | 모듈 |

---
https://kephilab.tistory.com/55

## @documented

javadoc으로 문서 생성 시 현재 어노테이션에 대한 설명을 추가한다.

## 애노테이션 프로세서
