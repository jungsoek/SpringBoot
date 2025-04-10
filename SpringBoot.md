# 스프링 부트 개발 준비

## 스프링 부트란?

스프링 부트는 웹 애플리케이션을 만들도록 도와주는 웹 프레임워크이다. 스프링 부트는 스프링 프레임워크에 톰캣이라는 서버를 내장하고 여러 편의 기능들을 추가하였다.

### 웹 프레임워크란?

쿠키나 세션 처리, 로그인/로그아웃 처리, 권한 처리, 데이터베이스 처리 등 웹 프로그램을 완성하기 위해 만들어야 하는 기능이 많다. 웹 프레임워크를 사용하면 이런 기능들을 일일이 만들 필요가 없다. 이미 프레임워크에 만들어져 있기 때문에 그 기능들을 익혀서 사용하기만 하면 된다.

### 스프링 부트를 배워야 하는 이유

#### 스프링 부트는 튼튼한 웹 프레임워크이다

스프링 부트는 보안면에서 우수하다. 예를 들어 SQL 인젝션, XSS, CSRF, 클릭재킹과 같은 보안 공격을 막아준다.

#### 스프링 부트는 WAS가 필요 없다

스프링 부트 대신 스프링만 사용하여 웹 애플리케이션을 개발한다면 실행할 수 있는 톰캣과 같은 WAS가 필요하다. 하지만 스프링 부트에는 톰캣 서버가 내장되어 있고 설정도 자동 적용되기 때문에 WAS에 대해서 전혀 신경 쓸 필요가 없다. 심지어 배포되는 jar 파일에도 톰캣 서버가 내장되어 실행되므로 서로 다른 WAS들로 인해 발생되는 문제들도 사라진다. 즉 프로젝트 패키지만 옮기면 내장 톰캣도 덩달아 옮겨진다.

## 스프링 부트 개발 환경 준비

### JDK 설치

### STS 설치

### STS 실행

### 스프링 부트 프로젝트 생성

## 스프링 부트 맛보기

### 웹 서비스는 어떻게 동작할까?

본격적으로 웹 프로그램을 만들며 스프링 부트를 맛보기 전에 웹 서비스의 동작 원리를 간단히 살펴본다. 로컬 호스트, 웹 서버, 포트 등이 무엇인지 개념을 익힌다.

#### 클라이언트와 서버 구조 이해하기

클라이언트와 서버의 관계는 아래 그림으로 쉽게 이해할 수 있다. 클라이언트는 자주 사용하는 브라우저(크롬, 사파리 등)를 말하고, 서버는 브라우저로 접속 가능한 원격 컴퓨터를 의미한다.



크롬 브라우저에서 서버에 요청을 보낼 때는 서버의 주소(IP 주소) 또는 서버의 주소를 대체할 수 있는 도메인명을 알아야 한다. 가까운 예로 브라우저 주소 창에 naver.com을 입력하면 네이버에서 운용하는 웹 서버가 호출되고 서버는 요청에 대한 응답을 브라우저에게 돌려준다. 즉, 웹 서버는 요청에 대한 응답으로 HTML 문서나 다른 리소스들을 브라우저에 표시한다.

#### IP 주소와 포트 이해하기

서버는 브라우저로 접속할 수 있는 웹 서비스뿐만 아니라 FTP, 이메일 서비스 등도 운용할 수 있다. 하지만 보통 서비스별로 다른 IP 주소를 사용하지는 않는다. 왜냐하면 포트로 이러한 서비스들을 구분할 수 있기 때문이다. 포트는 네트워크 서비스를 구분하는 번호로, 하나의 서버 주소에서 포트를 사용하여 매우 많은 서비스를 운용할 수 있는데, 대표적인 서비스의 종류는 다음과 같다.

| 프로토콜  | 서비스 내용                            | 포트 |
| --------- | -------------------------------------- | ---- |
| HTTP      | 웹 서비스                              | 80   |
| HTTPS     | SSL을 적용한 웹 서비스                 | 443  |
| FTP       | 파일 전송 서비스                       | 21   |
| SSH, SFTP | 보안이 강화된 TELNET(텔넷), FTP 서비스 | 22   |
| TELNET    | 원격 서버 접속 서비스                  | 23   |
| SMTP      | 메일 전송 서비스                       | 25   |

브라우저 주소 창에 naver.com 대신 naver.com:443을 입력해본다. 443dms HTTPS 서비스의 기본 포트 번호이므로 naver.com만 입력했을 때와 동일하게 동작하는 것을 확인할 수 있다.

#### localhost:8080 이해하기

이번에는 웹 개발에서 자주 등장하는 localhost:8080을 알아본다. localhost:8080에서 먼저 localhost(로컬 호스트)라는 도메인명은 127.0.0.1이라는 IP 주소를 의미하며, 127.0.0.1 IP 주소는 내 컴퓨터를 의미한다. 그리고 8080은 8080번 포트로 서비스를 운용한다는 의미이다. 정리하자면, localhost:8080는 내 컴퓨터(localhost)에 8080번 포트로 실행된 서비스를 의미하는 것이다.

### 컨트롤러 만들기

http://localhost:8080/hello와 같은 브라우저의 요청을 처리하려면 먼저 컨트롤러가 필요하다. 컨트롤러는 서버에 전달된 클라이언트의 요청을 처리하는 자바 클래스이다. 컨트롤러를 한번 만들어본다.

1. com.mysite.sbb 패키지를 선택 - New - Class 클릭 - Name에 HelloController 입력 - Finish

2. 화면에 HelloController.java 파일이 생성된다.

   ```java
   package com.mysite.sbb;
   
   public class HelloController {
   	
   }
   ```

3. 컨트롤러의 기능을 추가한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.ResponseBody;
   
   @Controller
   public class HelloController {
   	@GetMapping("/hello")
   	@ResponseBody
   	public String hello() {
   		return "Hello World";
   	}
   }
   ```

클래스명 위에 적용된 @Controller 어노테이션은 HelloController 클래스가 컨트롤러의 기능을 수행한다는 의미이다. 이 어노테이션이 있어야 스프링 부터 프레임워크가 컨트롤러로 인식한다.

hello 메서드에 적용된 @GetMapping("/hello") 어노테이션은 http://localhost:8080/hello URL 요청이 발생하면 hello 메서드가 실행됨을 의미한다. 즉, /hello URL과 hello 메서드를 매핑하는 역할을 한다. 이때 URL명과 메서드명이 동일할 필요는 없다. 즉 /hello URL일 때 메서드명을 hello가 아닌 hello2와 같이 써도 상관 없다.

또한 Get 방식의 URL 요청을 위해 GetMapping을 사용하고 Post 방식의 URL 요청을 위해서는 PostMapping을 사용한다. 그리고 @ResponseBody 어노테이션은 hello 메서드의 출력 결과가 문자열 그 자체임을 나타낸다. hello 메서드는 'Hello World' 문자열을 리턴하므로 결과로 'Hello World' 문자열이 출력된다.

cf) : Get 방식과 Post 방식

Get과 Post는 HTTP 프로토콜을 사용하여 데이터를 서버로 전송하는 주요 방식이다. 먼저, Get 방식은 데이터를 URL에 노출시켜 요청하며, 주로 서버에서 데이터를 조회하거나 읽기 위한 목적으로 사용한다. 반면, Post 방식은 데이터를 숨겨서 요청하므로 로그인 정보와 같은 민감한 데이터를 서버에 제출하거나 저장하는 목적으로 사용한다.

### 로컬 서버 실행

앞에서 작성한 HelloController가 브라우저의 요청을 제대로 처리하는지 확인하려면 먼저 로컬 서버를 실행해야 한다.

1. 로컬 서버는 다음과 같은 순서로 실행한다.
   1. 화면 왼쪽 하단에 Boot Dashboard가 보이지 않는다면 STS 상단의 툴바에서 [Boot Dashboard] 아이콘을 클릭한다.
   2. Boot Dashboard에서 'local' 왼쪽에 있는 아래 화살표를 클릭하면 'sbb'라는 프로젝트명이 보이면 마우스로 선택한다.
   3. 'sbb'를 선택하면 로컬 서버를 실행할 수 있는 버튼이 여러 개 활성화 되는데 그중에 가장 왼쪽에 있는 시작 버튼을 클릭해 서버를 실행한다.
2. 순서대로 진행했다면 로컬 서버가 실행되고 STS 콘솔 창에 로컬 서버가 8080 포트로 실행되었다는 메시지가 출력될 것이다.

### 브라우저로 확인

로컬 서버를 실행하였으니 이번에는 HelloController가 브라우저의 요청을 처리하는지 확인한다. 구글 크롬과 같은 브라우저를 실행하고 주소 창에 http://localhost:8080/hello를 입력한다.

## 스프링 부트 도구 설치하기

### Spring Boot Devtools 설치

Spring Boot Devtools 라이브러리를 STS에 추가한다. Spring Boot Devtools를 추가하면 서버를 매번 재시작하지 않고도 수정한 내용이 반영된다.

1. 앞에서 작성한 HelloController.java를 다음과 같이 수정한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.ResponseBody;
   
   @Controller
   public class HelloController {
   	@GetMapping("/hello")
   	@ResponseBody
   	public String hello() {
   		return "Hello SBB";
   	}
   }
   ```

   출력하는 문자열을 'Hello World'에서 'Hello SBB'로 변경했다. 하지만 이렇게 수정하고 http://localhost:8080/hello URL을 호출하면 여전히 'Hello World'가 출력된다. 왜냐면 이와 같이 프로그램이 변경되더라도 별도의 과정 없이는 로컬 서버가 변경된 클래스를 즉시 반영하지 않기 때문이다. 그래서 프로그램을 간단히 수정하더라도 변경된 사항을 확인하기 위해 매번 서버를 재시작해야 하므로 개발 과정이 꽤 번거롭다.

2. 이러한 문제를 해결하려면 Spring Boot Devtools를 설치해야 한다. Spring Boot Devtools를 설치하면 서버를 재시작하지 않아도 클래스를 변경할 때 서버가 자동으로 재가동된다. Spring Boot Devtools를 사용하려면 Spring Boot Devtools를 그레이들로 설치해야 한다. 다음과 같이 STS 화면 왼쪽에서 build.gradle 파일을 찾아 수정한다.

   ```
   ...
       
   dependencies {
   	implementation 'org.springframework.boot:spring-boot-starter-web'
   	testImplementation 'org.springframework.boot:spring-boot-starter-test'
   	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
   	developmentOnly 'org.springframework.boot:spring-boot-devtools'
   }
   
   ...
   ```

3. build.gradle 파일에 작성한 내용을 적용하려면 build.gradle 파일을 선택한 후 마우스 오른쪽 버튼을 눌러 Gradle - Refresh Gradle Project를 클릭하여 필요한 라이브러리를 설치한다.

4. 설치가 완료되면 Boot Dashboard의 서버명이 sbb에서 sbb [devtools]로 바뀐다.

   ![image-20250410135137818](./assets/image-20250410135137818.png)

5. 서버 재시작

6. 이제 Spring Boot Devtools가 적용되었으니 브라우저에서 다시 http://localhost:8080/hello를 호출한다. 서버를 재시작했으므로 'Hello SBB'가 출력된다. 서버 재시작 없이도 변경 사항이 적용되는지 확인하기 위해 출력할 문자열을 다음과 같이 다시 변경한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.ResponseBody;
   
   @Controller
   public class HelloController {
   	@GetMapping("/hello")
   	@ResponseBody
   	public String hello() {
   		return "Hello Spring Boot Board";
   	}
   }
   ```

7. 수정 사항이 잘 반영되었는지 http://localhost:8080/hello을 호출한다. 서버를 재시작하지 않아도 'Hello Spring Board'가 출력된다. 

### 롬복 설치

롬복 라이브러리는 소스 코드를 작성할 때 자바 클래스에 어노테이션을 사용하여 자주 쓰는 Getter 메서드, Setter 메서드, 생성자 등을 자동으로 만들어 주는 도구이다.

이제 SBB 프로그램을 만들면서 게시물과 관련된 데이터를 처리하기 위해 엔티티 클래스나 DTO 클래스 등을 사용해야 하는데 그러기 위해서는 먼저 이 클래스들의 속성값을 읽고 저장하는 Getter, Setter 메서드를 만들어야 한다. 물론 Getter, Setter 메서드를 직접 작성해도 되지만 롬복을 사용하면 좀 더 짧고 깔끔한 소스 코드를 만들 수 있다.

1. 롬복을 사용하려면 먼저 플러그인을 설치해야 한다. 다음 URL에서 롬복 플러그인을 내려받는다.

   ```
   https://projectlombok.org/download
   ```

2. 내려받은 lombok.jar 파일을 cmd 창에서 다음과 같이 설치한다. lombok.jar 파일이 있는 위치로 이동한 후, 다음 명령을 실행해야 한다. 여기서는 'Downloads' 폴더에 lombok.jar 파일이 있으므로, 다음과 같이 입력한다.

   ```
   java -jar lombok.jar
   ```

3. 설치 창이 떳다면 [Specify location]을 클릭해 롬복 플러그인을 사용할 IDE인 STS가 설치된 경로를 선택한다(이미 올바른 경로가 선택되어 있다면 이 과정은 생략해도 된다). 그다음 [Install/Update]를 클릭해 롬복 플러그인을 설치한다.

4. 설치가 성공적으로 완료되면 [Quit Installer]를 클릭해 설치 프로그램을 종료한다.

5. 만약 STS가 활성화되어 있다면 종료하고 다시 시작한 후 build.gradle 파일을 다음과 같이 수정한다.

   ```
   ...
   dependencies {
   	implementation 'org.springframework.boot:spring-boot-starter-web'
   	testImplementation 'org.springframework.boot:spring-boot-starter-test'
   	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
   	developmentOnly 'org.springframework.boot:spring-boot-devtools'
   	compileOnly 'org.projectlombok:lombok'
   	annotationProcessor 'org.projectlombok:lombok'
   }
   ...
   ```

   이와 같이 롬복 라이브러리를 설치하고 컴파일할 때 롬복 라이브러리가 적용되도록 코드를 추가했다.

#### 롬복으로 Getter, Setter 메서드 만들기

[com.mysite.sbb]에 마우스 오른쪽 버튼을 누르고 [New - Class]를 클릭해 HelloLombok 클래스를 만든다. 그리고 다음과 같이 소스 코드를 작성하여 롬복이 정상적으로 동작하는지 확인한다. 다음 코드를 작성했을 때 오류가 없어야 한다.

```java
package com.mysite.sbb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
	private String hello;
	private int lombok;
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok();
		helloLombok.setHello("헬로");
		helloLombok.setLombok(5);
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
	
}
```

HelloLombok 클래스에 'hello', 'lombok' 이렇게 2개의 속성을 추가한 후 클래스명 바로 위에 @Getter, @Setter라는 어노테이션을 적용했더니 Getter와 Setter 메서드를 따로 작성하지 않아도 setHello, setLombok, getHello, getLombok 등의 메서드를 사용할 수 있게 되었다. 즉, 롬복을 활용하면 속성에 대한 Setter, Getter 메서드를 별도로 작성하지 않아도 된다.

#### 롬복으로 생성자 만들기

이와 같이 hello, lombok 속성에 final을 추가하고 @RequiredArgsConstructor 어노테이션을 적용하면 해당 속성을 필요로 하는 생성자가 롬복에 의해 자동으로 생성된다. 즉, 롬복을 활용하면 필요한 생성자를 자동으로 만들어 준다.

```java
package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class HelloLombok {

	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("헬로", 5);
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
	}
	
}
```

# 스프링 부트의 기본 기능 익히기

## 스프링 부트 프로젝트의 구조 이해

### src/main/java 디렉터리 

#### com.mysite.sbb 패키지

#### SbbApplication.java 파일

### src/main/resources 디렉터리 

#### templates 디렉터리

#### static 디렉터리

#### application.properties 파일

### src/test/java 디렉터리

### build.gradle 파일

## 간단한 웹 프로그램 만들기

### URL 매핑과 컨트롤러

### 컨트롤러 만들어서 URL 매핑하기

## JAP로 데이터베이스 사용하기

### ORM과 JPA 이해하기

#### ORM이란?

#### JPA란?

### 데이터베이스 설치하기

### JPA 환경 설정하기

## 엔티티로 테이블 매핑하기

### 데이터베이스 구성 요소 살펴보기

### 엔티티 속성 구성하기

### 질문 엔티티 만들기

#### @Id 어노테이션

#### @GeneratedValue 어노테이션

#### @Column 어노테이션

### 답변 엔티티 만들기

## 리포지터리로 데이터베이스 관리하기

### 리포지터리 생성하기

### JUnit 설치하기

### 질문 데이터 저장하기

### 질문 데이터 조회하기

#### findAll 메서드

#### findById 메서드

#### findBySubject 메서드

#### findBySubjectAndContent 메서드

#### findBySubjectLike 메서드

### 질문 데이터 수정하기

### 질문 데이터 삭제하기

### 답변 데이터 저장하기

### 답변 데이터 조회하기

### 답변 데이터를 통해 질문 데이터 찾기 vs 질문 데이터를 통해 답변 데이터 찾기

## 도메인별로 분류하기

## 질문 목록 만들기

### 질문 목록 URL 매핑하기

### 템플릿 설정하기

### 템플릿 사용하기

### 데이터를 템플릿에 전달하기

### 데이터를 화면에 출력하기

## 루트 URL 사용하기

## 서비스 활용하기

### 서비스가 필요한 이유

#### 복잡한 코드를 모듈화할 수 있다

#### 엔티티 객체를 DTO 객체로 변환할 수 있다

### 서비스 만들기

### 컨트롤러에서 서비스 사용하기

## 상세 페이지 만들기

### 질문 목록에 링크 추가하기

### 상세 페이지 컨트롤러 만들기

### 상세 페이지에 서비스 사용하기

### 상세 페이지 출력하기

## URL 프리픽스 알아 두기

## 답변 기능 만들기

### 텍스트 창과 등록 버튼 만들기

### 답변 컨트롤러 만들기

### 답변 서비스 만들기

### 상세 페이지에 답변 표시하기

## 웹 페이지 디자인하기

### 스태틱 디렉터리와 스타일시트 이해하기

### 템플릿에 스타일 적용하기

## 부트스트랩으로 화면 꾸미기

### 부트스트랩 설치하기

### 부트스트랩 적용하기

## 표준 HTML 구조로 변경하기

### 표준 HTML 구조 살펴보기

### 템플릿 상속하기

#### layout.html로 기본 틀 만들기

#### question_list.html에 템플릿 상속하기

#### question_detail.html에 템플릿 상속하기

## 질문 등록 기능 추가하기

### 질문 등록 버튼과 화면 만들기

#### URL 매핑하기

#### 템플릿 만들기

#### 서비스 수정하기

### 폼 활용하기

#### Spring Boot Validation 라이브러리 설치하기

#### 폼 클래스 만들기

#### 컨트롤러에 전송하기

#### 템플릿 수정하기

#### 오류 처리하기

### 답변 등록 기능에 폼 적용하기

### 공통 템플릿 만들기

#### 오류 메시지 템플릿 만들기

#### 기존 템플릿에 적용하기

# SBB 서비스 개발하기

## 내비게이션 바 추가하기

### 내비게이션 바 만들기

### 내비게이션 바의 숨은 기능 알기

### 내비게이션 바 분리하기

## 페이징 기능 추가하기

### 대량 테스트 데이터 만들기

### 페이징 구현하기

### 페이지 이동 기능 추가하기

### 페이지 이동 기능 완성하기

### 최신순으로 데이터 조회하기

## 게시물에 번호 지정하기

### 게시물 번호 공식 만들기

### 게시물 번호 공식 적용하기

## 답변 개수 표시하기

## 스프링 시큐리티란?

### 스프링 시큐리티 설치하기

### 스프링 시큐리티 설정하기

### DB 콘솔 오류 수정하기

## 회원 가입 기능 구현하기

### 회원 가입 기능 구성하기

#### 회원 엔티티 생성하기

#### User 리포지터리와 서비스 생성하기

#### 회원 가입 폼 생성하기

#### 회원 가입 컨트롤러 생성하기

### 회원 가입 화면 구성하기

#### 회원 가입 템플릿 생성하기

#### 내비게이션 바에 회원 가입 링크 추가하기

### 회원 가입 기능 확인하기

### 중복 회원 가입 방지하기

## 로그인과 로그아웃 기능 구현하기

### 로그인 기능 구현하기

#### 로그인 URL 등록하기

#### User 컨트롤러에 URL 매핑 추가하기

#### 로그인 템플릿 작성하기

#### User 리포지터리 수정하기

#### UserRole 파일 생성하기

#### UserSecurityService 서비스 생성하기

#### 스프링 시큐리티 설정 수정하기

#### 로그인 화면 수정하기

### 로그아웃 기능 구현하기

## 글쓴이 항목 추가하기

### 엔티티에 속성 추가하기

#### 질문 엔티티에 속성 추가하기

#### 답변 엔티티에 속성 추가하기

#### 테이블 확인하기

### 글쓴이 저장하기

#### 답변 컨트롤러와 서비스 업데이트하기

#### 질문 컨트롤러와 서비스 업데이트하기

### 로그인 페이지로 이동시키기

### 답변 작성 막아 두기

### 화면에 글쓴이 나타내기

#### 질문 목록에 글쓴이 표시하기

#### 질문 상세에 글쓴이 표시하기

## 수정과 삭제 기능 추가하기

### 수정 일시 추가하기

### 질문 수정 기능 생성하기

#### 질문 수정 버튼 만들기

#### 질문 컨트롤러 수정하기 1

#### 질문 등록 템플릿 수정하기

#### 질문 서비스 수정하기

#### 질문 컨트롤러 수정하기 2

#### 수정 기능 확인하기

### 질문 삭제 기능 생성하기

#### 질문 삭제 버튼 만들기

#### 삭제를 위한 자바스크립트 작성하기

#### 질문 서비스와 컨트롤러 수정하기

### 답변 수정 기능 추가하기

#### 버튼 추가하고 서비스와 컨트롤러 수정하기

#### 답변 수정 템플릿 생성하기

#### 답변 컨트롤러 재수정하기

### 답변 삭제 기능 추가하기

### 수정 일시 표시하기

## 추천 기능 추가하기

### 엔티티에 속성 추가하기

### 질문 추천 기능 생성하기

### 답변 추천 기능 생성하기

## 앵커 기능 추가하기

### 답변 앵커 추가하기

### 리다이렉트 수정하기

### 답변 서비스 수정하기

### 답변 컨트롤러 수정하기

### 답변 앵커 기능 확인하기

## 마크다운 적용하기

### 마크다운 문법 살펴보기

#### 목록 표시하기

#### 강조 표시하기

#### 링크 표시하기

#### 소스 코드 표시하기

#### 인용 표시하기

### 마크다운 설치하기

### 마크다운 컴포넌트 작성하기

### 템플릿에 마크다운 적용하기

### 마크다운 확인하기

## 검색 기능 추가하기

### 검색 기능 구현하기

#### JPA의 Specification 인터페이스 사용하기

#### 질문 리포지터리 수정하기

#### 질문 서비스 수정하기

#### 질문 컨트롤러 수정하기

### 검색 화면 구현하기

#### 검색창 만들기

#### 검색 폼 만들기

#### 페이징 수정하기

#### 검색 스크립트 추가하기

### 검색 기능 확인하기

### @Query 어노테이션 사용하기

## SBB 추가 기능 구현하기

### 답변 페이징과 정렬 기능 추가하기

### 댓글 기능 추가하기

### 카테고리 추가하기

### 비밀번호 찾기와 변경 기능 추가하기

### 프로필 화면 구현하기

### 최근 답변과 최근 댓글 순으로 노출시키기

### 조회 수 표시하기

### 소셜 미디어 로그인 기능 구현하기

### 마크다운 에디터 적용하기

# SBB 서비스 배포 및 출시

## 이제 서버가 필요하다

## AWS 라이트세일 알아보기

### AWS 라이트세일이란?

### AWS 가입하기

### AWS 라이트세일 시작하기

#### AWS 라이트세일에 접속하기

#### 인스턴스 생성하기

## 서버 접속 설정하기

### 고정 IP 생성하기

### 방화벽 해제하기

## 서버 접속 프로그램 설치하기

### 프라이빗 키 만들기

### SSH 클라이언트 설치하기

### SFTP 클라이언트 설치하기

## SBB 배포하기

### 서버 환경 설정하기

#### 호스트 이름 변경하기

#### 서버 시간 설정하기

#### 서버에 자바 설치하기

#### 프로젝트 디렉터리 생성하기

### STS에서 SBB 배포 파일 생성하기

### SFTP로 SBB 배포 파일 전송하기

## 서버 스크립트 생성하기

### SBB 시작 스크립트 작성하기

### SBB 중지 스크립트 작성하기

## 서버 환경으로 분리하기

### 서버 환경 파일 생성하기

### 빌드 버전 변경하여 배포 파일 생성하기

### 서버에 변경 내용 적용하기

### 서버의 데이터베이스 콘솔 접속하기

## 80번 포트로 웹 서비스 운영하기

### 엔진엑스 설치 및 설정하기

### 엔진엑스 실행 및 적용하기

## 로그 관리하기

### 서버 로그 분리하기

### 서버에서 start.sh 변경하기

### 사용자 로그 작성하기

## 도메인 사용하기

### 도메인 구입하기

### 도메인 연결하기

### 도메인 적용하기

## HTTPS로 전환하기

### HTTPS가 필요한 이유

### SSL 인증서를 발급받아 HTTPS로 접속하기

## PostgreSQL로 전환하기

### PostgreSQL 설치하기

### 데이터베이스 생성하기

### 데이터베이스 변경하기

### PostgreSQL 접속하기





