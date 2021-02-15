# 학습할 것 (필수)

- [학습할 것 (필수)](#학습할-것-필수)
  - [스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O](#스트림-stream--버퍼-buffer--채널-channel-기반의-io)
    - [스트림 (Stream)](#스트림-stream)
    - [버퍼 (Buffer)](#버퍼-buffer)
    - [채널 (Channel)](#채널-channel)
  - [InputStream과 OutputStream](#inputstream과-outputstream)
    - [InputStream](#inputstream)
    - [OutputStream](#outputstream)
  - [Byte와 Character 스트림](#byte와-character-스트림)
    - [Byte Streams](#byte-streams)
    - [Character Streams](#character-streams)
  - [표준 스트림 (System.in, System.out, System.err)](#표준-스트림-systemin-systemout-systemerr)
  - [파일 읽고 쓰기](#파일-읽고-쓰기)

## 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O

### 스트림 (Stream)

**단방향성**의 데이터를 **담아 둘수 있는 통로**를 의미한다. \
여기서 단방향성이란 들어오거나(Input) 출력하는(Output) 방향을 의미한다고 볼 수 있다.

따라서, 자바에서는 들어오는 혹은 읽어들이는 데이터를 담아두는 객체에 `InputStream`이라는 이름을 붙여주었다. 그 반대로 출력할 혹은 내보낼 데이터를 담아두는 객체를 `OutputStream`이라는 이름을 붙여줬다.

여기서 이름을 붙여줬다라는 것의 의미는 그러한 역할을 할당했다는 것과 같은 의미를 가진다고 할 수 있다. 즉, 자바는 `InputStream`과 `OutputStream`이라는 추상클래스를 제공하여 이를 상속하는 클래스들의 본질적인 역할을 세부적으로 구현할 수 있게 해두었다.

### 버퍼 (Buffer)

앞서 소개한 스트림을 이용하면 데이터를 순차적으로 입출력을 할 수 있었다. 하지만 이 방식은 1바이트 씩 처리되는 방식이기 때문에 한 뭉탱이(버퍼) 씩 데이터를 처리하는 방식보다 느릴 수 밖에 없다.

여기서 언급된 그 한 뭉탱이가 지금 소개할 **버퍼**이다. \
**버퍼**는 스트림과 같이 데이터를 담아둘 수 있는 객체이다. 하지만 **버퍼에 담긴 데이터는 스트림에 담겨저 있는 데이터처럼 1 바이트 씩 움직이지 않고 일정한 크기로 한번에 읽혀서 저장되거나 쓰여질 수 있다.**

### 채널 (Channel)

위에서 **버퍼**를 사용해 스트림에서의 속도 측면의 성능 문제를 개선할 수 있었다. 하지만 기존의 스트림을 사용하는 방식에서 문제점은 하나가 더 있었다. 바로 **Blocking**이다.

I/O Blocking은 입출력 스트림의 `read()`, `write()` 메소드를 호출하면 데이터가 입력하기 전까지 스레드가 블로킹(대기상태)가 된다. 블로킹이 되면 다른 일을 할 수 없고 블로킹을 빠져나오기 위해 인터럽트도 할 수 없다. 블로킹을 빠져나오는 유일한 방법은 스트림 객체에 전달된 메시지를 수행완료하는 것이다.

하지만, 제한적으로 **non-blocking** 방식을 사용하는 **채널**을 이용해 위와 같은 블로킹에 대한 이슈를 어느정도 해소할 수 있다고 한다.

**채널**은 **버퍼**를 통해서만 데이터를 읽고 쓸 수 있다. Channel에서 데이터를 읽으면 Buffer에 담아야만 어떤 처리를 할 수 있고, Channel에 데이터를 쓰려면 먼저 Buffer에 담고, Buffer에 담긴 데이터를 Channel에 써야 한다.

---
https://b-programmer.tistory.com/268 \
https://homoefficio.github.io/2016/08/06/Java-NIO%EB%8A%94-%EC%83%9D%EA%B0%81%EB%A7%8C%ED%81%BC-non-blocking-%ED%95%98%EC%A7%80-%EC%95%8A%EB%8B%A4/ \
https://deftkang.tistory.com/25 \
https://clairdelunes.tistory.com/56

## InputStream과 OutputStream

### InputStream

위에서도 언급했듯이 `InputStream`은 바이트 기반 입력 스트림의 최상위 클래스로 추상클래스이다. 모든 바이트 기반 입력 스트림은 이 클래스를 상속받아서 만들어진다.

| method | description |
|---|---|
| `read()` | 입력 스트림으로부터 1바이트를 읽고 **읽은 바이트**를 반환한다. |
| `read(byte[] b)` | 입력 스트림으로부터 읽은 바이트들을 매개값으로 주어진 바이트 배열(`b`)에 저장하고 실제로 **읽은 바이트 수**를 반환한다. |
| `read(byte[] b, int off, int len)` | 입력 스트림으로부터 `len`개의 바이트만큼 읽고 매개값으로 주어진 바이트 배열 `b[off]`부터 `len`개까지 저장한다. 그리고 실제로 읽은 바이트 수인 **`len`개**를 반환한다. 만약 `len`개를 모두 읽지 못하면 **실제로 읽은 바이트 수**를 반환한다. |
| `close()` | 사용한 시스템 **자원을 반납**하고 입력 스트림을 닫는다. |

### OutputStream

위에서도 언급했듯이 `OutputStream`은 바이트 기반 출력 스트림의 최상위 클래스로 추상클래스이다. 모든 바이트 기반 출력 스트림은 이 클래스를 상속받아서 만들어진다.

| method | description |
|---|---|
| `write(int b)` | 출력 스트림으로부터 1바이트를 내보낸다. |
| `write(byte[] b)` | 출력 스트림으로부터 주어진 바이트 배열 `b`의 모든 바이트를 내보낸다. |
| `write(byte[] b, int off, int len)` | 출력 스트림으로 주어진 바이트 배열 `b[off]`부터 `len`개까지의 바이트를 내보낸다. |
| `flush()` | 버퍼에 잔류하는 모든 바이트를 출력한다. |
| `close()` | 사용한 시스템 자원을 반납하고 출력 스트림을 닫는다. |

---
https://coding-factory.tistory.com/281

## Byte와 Character 스트림

### Byte Streams

바이트(8-bit) 단위의 데이터를 처리한다. 즉, `ByteStream` 클래스는 바이트 데이터를 읽고/쓴다. 이를 이용해 다양한 데이터를 저장할 수 있다.(e.g. character, video, audio, image and etc)

Java에서는 Byte streams를 다루기 위한 클래스로 `InputStream`과 `OutputStream` 추상클래스를 상속한 다양한 클래스를 제공한다.

### Character Streams

16-bit Unicode로 데이터를 처리한다. 그렇기 때문에 텍스트 데이터만 처리가 가능하다.

Java에서는 Character Streams를 다루기 위한 클래스로 `Reader`와 `Writer` 추상클래스를 상속한 다양한 클래스를 제공한다.

---
https://www.tutorialspoint.com/difference-between-the-byte-stream-and-character-stream-classes-in-java

## 표준 스트림 (System.in, System.out, System.err)

Java는 콘솔과 같은 표준 입출력 장치를 위해 `System`이라는 표준 입출력 클래스를 정의하고 있다. `java.lang` 패키지에 포함되어 있는 `System` 클래스는 아래의 클래스 변수를 제공한다.

| 클래스 변수 | 입출력 스트림 | 설명 |
|---|---|---|
| `System.in` | `InputStream` | 콘솔로부터 데이터를 입력받는다. |
| `System.out` | `PrintStream` | 콘솔로 데이터를 출력한다. |
| `System.err` | `PrintStream` | 콘솔로 데이터를 출력한다. |

---
http://www.tcpschool.com/java/java_io_file

## 파일 읽고 쓰기


