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

sbb 프로젝트에 HelloController.java와 HelloLombok.java 파일을 생성하였다. 자바 파일을 생성하거나 그레이들 파일을 수정하면서 살펴보긴 했지만 지금보다 규모가 더 큰 프로젝트를 만들려면 프로젝트 구조를 자세히 알고 이해해야 한다. 이번에는 스프링 부트 프로젝트의 구조와 파일에 대해서 알아보자. 먼저, STS 화면 왼쪽에 있는 스프링 부트 프로젝트의 전체 구조부터 살펴본다.

![image-20250410153358187](./assets/image-20250410153358187.png)

### src/main/java 디렉터리 

자바 파일을 저장하는 공간이다.

#### com.mysite.sbb 패키지

이 패키지는 SBB의 자바 파일을 저장하는 공간이다. HelloController.java와 같은 스프링 부트의 컨트롤러, 폼과 DTO, 데이터베이스 처리를 위한 엔티티, 서비스 등의 자바 파일이 이 곳에 위치한다.

#### SbbApplication.java 파일

모든 프로그램에는 프로그램의 시작을 담당하는 파일이 있다. 스프링 부트로 만든 프로그램(스프링 부트 애플리케이션)에도 시작을 담당하는 파일이 있는데 그 파일이 바로 '프로젝트명 + Application.java' 파일이다. 스프링 부트 프로젝트를 생성할 때 프로젝트명으로 'sbb'라는 이름을 입력하면 다음과 같이 SbbApplication.java 파일이 자동으로 생성된다.

```java
package com.mysite.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbbApplication.class, args);
	}

}
```

SbbApplication 클래스에는 반드시 @SpringBootApplication 애너테이션이 적용되어 있어야 한다. @SpringBootApplication 애너테이션을 통해 스프링 부트 애플리케이션을 시작할 수 있다.

### src/main/resources 디렉터리 

자바 파일을 제외한 HTML, CSS, JS, 환경 파일 등을 저장하는 공간이다.

cf) : 환경파일이란?

프로젝트의 설정 정보를 저장하는 파일이다.

#### templates 디렉터리

src/main/resources 디렉터리의 하위 디렉터리인 templates에는 템플릿 파일을 저장한다. 템플릿 파일은 자바 코드를 삽입할 수 있는 HTML 형식의 파일로, 스프링 부트에서 생성한 자바 객체를 HTML 형태로 출력할 수 있다. templates에는 SBB 게시판 서비스에 필요한 '질문 목록', '질문 상세' 등의 웹 페이지를 구성하는 HTML 파일을 저장한다.

#### static 디렉터리

static 디렉터리에는 sbb 프로젝트의 스타일시트(css 파일), 자바스크립트(js 파일) 그리고 이미지 파일(jpg 파일, png 파일 등) 등을 저장한다.

#### application.properties 파일

application.properties 파일은 sbb 프로젝트의 환경을 설정한다. sbb 프로젝트의 환경 변수, 데이터베이스 등의 설정을 이 파일에 저장한다.

### src/test/java 디렉터리

sbb 프로젝트에서 작성한 파일을 테스트하는 코드를 저장하는 공간이다. JUnit과 스프링 부트의 테스트 도구를 사용하여 서버를 실행하지 않은 상태에서 src/main/java 디렉터리에 작성한 코드를 테스트할 수 있다.

### build.gradle 파일

build.gradle은 그레이들이 사용하는 환경 파일이다. 그레이들은 그루비를 기반으로 한 빌드 도구로 Ant, Maven과 같은 이전 세대의 단점을 보완하고 장점을 취합하여 만들었다. build.gradle 파일에는 프로젝트에 필요한 플러그인과 라이브러리를 설치하기 위한 내용을 작성한다.

cf) : 그루비란?

그레이들 빌드 스크립트를 작성하는 데 사용하는 스크립트 언어이다.

cf) : 빌드 도구의 쓰임

소스 코드를 컴파일하고 필요한 라이브러리를 내려받을 때 사용한다. SBB 프로젝트를 완성하면 단 한 개의 jar 파일로 패키징하여 서버에 배포할 수 있는데 이때에도 역시 빌드 도구를 사용한다.

## 간단한 웹 프로그램 만들기

웹 브라우저에서 http://localhost:8080/sbb 페이지를 요청했을 때 '안녕하세요 sbb에 오신 것을 환영합니다.'라는 문자열을 출력하도록 만든다.

### URL 매핑과 컨트롤러

1. STS의 왼쪽 하단에 있는 Boot Dashboard에서 시작 버튼을 눌러 로컬 서버를 구동한다.

2. http://localhost:8080/sbb 페이지를 요청한다.

   아마 URL을 입력하면 오류를 알리는 화면이 등장한다. 여기서 404는 HTTP 오류 코드 중 하나로, 브라우저가 요청한 페이지를 찾을 수 없다는 의미이다. 즉, 스프링 부트 서버가 http://localhost:8080/sbb라는 요청을 해석할 수 없기 때문에 이와 같은 오류가 발생한 것이다.

   그렇다면 이러한 오류를 해결하기 위해 어떻게 해야 하는가? 컨트롤러를 작성하여 /sbb URL에 대한 매핑을 추가하면 해결할 수 있다. 브라우저와 같은 클라이언트의 페이지 요청이 발생하면 스프링 부트는 가장 먼저 컨트롤러에 등록된 URL 매핑을 찾고, 해당 URL 매핑을 발견하면 URL 매핑과 연결된 메서드를 실행한다.

### 컨트롤러 만들어서 URL 매핑하기

웹 브라우저와 같은 클라이언트의 요청이 발생하면 서버 역할을 하는 스프링 부트가 응답해야 한다. 그러기 위해서는 URL이 스프링 부트에 매핑되어 있어야 하고 이를 위해서는 먼저 컨트롤러를 만들어야 한다.

1. 컨트롤러를 작성하여 URL 매핑을 추가하기 위해 다음과 같이 src/main/java 디렉터리의 com.mysite.sbb 패키지에 MainController.java 파일을 작성한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.GetMapping;
   
   @Controller
   public class MainController {
   	@GetMapping("/sbb")
   	public void index() {
   		System.out.println("index");
   	}
   }
   ```

   MainController 클래스에 @Controller 어노테이션을 적용하면 MainController 클래스는 스프링 부트의 컨트롤러가 된다. 그리고 index 메서드의 @GetMapping 어노테이션은 요청된 URL(/sbb)과의 매핑을 담당한다. 브라우저가 URL을 요청하면 스프링 부트는 요청 페이지와 매핑되는 메서드를 찾아 실행한다.

   정리하자면, 스프링 부트는 웹 브라우저로부터 http://localhost:8080/sbb 요청이 발생하면 /sbb URL과 매핑되는 index 메서드릴 MainController 클래스에서 찾아 실행한다.

2. 다시 http://localhost:8080/sbb URL을 호출해 본다.

   이번에도 오류가 발생한다. 하지만 404가 아닌 500 오류 코드로 바뀐 것을 확인할 수 있다. 브라우저가 http://localhost:8080/sbb 요청했을 때 MainController 클래스의 index 메서드가 호출되긴 했지만 오류가 발생하였다. 원래 URL과 매핑된 메서드는 결괏값을 리턴해야 하는데 아무 값도 리턴하지 않아 이와 같은 오류가 발생한 것이다. 즉, 오류를 해결하려면 클라이언트(브라우저)로 응답을 리턴해야 한다.

3. 다음과 같이 MainController.java를 수정한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.ResponseBody;
   
   @Controller
   public class MainController {
   	@GetMapping("/sbb")
   	@ResponseBody
   	public String index() {
   		return "index";
   	}
   }
   ```

   응답으로 'index'라는 문자열을 브라우저에 출력하기 위해 index 메서드의 리턴 자료형을 String으로 변경하고 문자열 'index'를 리턴했다. 여기서 @ResponseBody 어노테이션은 URL 요청에 대한 응답으로 문자열을 리턴하라는 의미로 쓰였다.

4. 오류가 해결되었다.

   ![image-20250410160713502](./assets/image-20250410160713502.png)

5. 이번에는 MainController.java를 수정하여 문자열 'index' 대신 '안녕하세요 sbb에 오신 것을 환영합니다.'를 출력한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.ResponseBody;
   
   @Controller
   public class MainController {
   	@GetMapping("/sbb")
   	@ResponseBody
   	public String index() {
   		return "안녕하세요 sbb에 오신 것을 환영한다.";
   	}
   }
   ```

6. 브라우저에 변경한 문자열이 잘 출력된다.

   ![image-20250410160850519](./assets/image-20250410160850519.png)

## JAP로 데이터베이스 사용하기

만들어 볼 SBB는 방문자들이 질문과 답변을 남길 수 있는 게시판 서비스이다. SBB 게시판의 사용자가 질문이나 답변을 작성하면 데이터가 생성되는데, 이러한 데이터를 관리하려면 저장, 조회, 수정하는 등의 기능을 구현해야 한다. 우리가 만들 SBB뿐만 아니라 대부분의 웹 서비스들은 생성되는 데이터를 관리하고 처리하기 위해 DB를 사용한다. DB는 데이터를 모으고 관리하는 저장소라고 할 수 있다.

여기서 문제는 DB를 관리하려면 SQL이라는 언어를 사용해야한다는 점이다. 스프링 부트와 달리 DB는 자바를 이해하지 못한다. 하지만 ORM(Object Relational Mapping)이라는 도구를 사용하면 자바 문법으로도 DB를 다룰 수 있다. 즉, ORM을 이용하면 개발자는 SQL을 직접 작성하지 않아도 DB의 데이터를 처리할 수 있다.

### ORM과 JPA 이해하기

#### ORM이란?

먼저, ORM에 대해 알아본다. 앞서 ORM은 SQL을 사용하지 않고 DB를 관리할 수 있는 도구라고 설명했다. ORM은 DB의 테이블을 자바 클래스로 만들어 관리할 수 있다. SQL의 쿼리문과 ORM 코드(즉, 자바로 작성된 코드)를 비교하여 ORM을 좀 더 이해해본다. 다음과 같은 'question'이란 이름의 테이블에 데이터를 입력한다고 가정한다. 그리고 question 테이블에는 id, subject, content라는 열이 있다고 가정한다.

| id   | subject | content    |
| ---- | ------- | ---------- |
| 1    | 안녕    | 인사드림   |
| 2    | 질문    | ORM이 궁금 |
| ...  | ...     | ...        |

이렇게 question 테이블에 데이터를 저장하려면 SQL 쿼리문은 다음과 같이 작성한다.

```sql
insert into question(id, subject, content) values (1, '안녕', '인사드림');
insert into question(id, subject, content) values (2, '질문', 'ORM이 궁금');
```

하지만 ORM을 사용하면 이러한 쿼리문 대신 자바 코드로 다음과 같이 작성할 수 있다.

```java
Question q1 = new Question();
q1.setId(1);
q1.setSubject("안녕");
q1.setContent("인사드림");
this.questionRepository.save(q1);

Question q2 = new Question();
q2.setId(2);
q2.setSubject("질문");
q2.setContent("ORM이 궁금");
this.questionRepository.save(q2);
```

이와 같이 SQL의 쿼리문과 ORM 코드를 단순히 비교하면 ORM 코드의 양이 더 많아 보이지만 별도의 SQL문을 사용하지 않아도 DB를 사용할 수 있기에 편리하다. ORM 코드를 살펴보면 Question은 자바 클래스이며, 이처럼 데이터를 관리하는 데 사용하는 ORM의 자바 클래스를 엔티티라고 한다. 엔티티는 DB의 테이블과 매핑되는 자바 클래스를 말한다.

ORM을 이용하면 MySQL, 오라클 DB, MS SQL과 같은 DBMS의 종류에 관계 없이 일관된 자바 코드를 사용할 수 있어서 프로그램을 유지보수하기가 편리하다. 또한 코드 내부에서 안정적인 SQL 쿼리문을 자동으로 생성해 주므로 개발자가 달라도 통일된 쿼리문을 작성할 수 있고, 오류 발생률도 줄일 수 있다.

#### JPA란?

스프링 부트는 JPA를 사용하여 DB를 관리한다. 스프링 부트는 JPA를 ORM의 기술 표준으로 사용한다. JPA는 인터페이스 모음이므로 이 인터페이스를 구현한 실제 클래스가 필요하다. JPA를 구현한 실제 클래스에는 대표적으로 하이버네이트가 있다. 

정리하자면, 하이버네이트는 JPA의 인터페이스를 구현한 실제 클래스이자 자바의 ORM 프레임워크로 스프링 부트에서 DB를 관리하기 쉽게 도와준다. 앞으로 만들어갈 SBB도 JPA와 하이버네이트 조합으로 DB를 관리한다.

### 데이터베이스 설치하기

JPA를 사용해 데이터를 관리하기 위해 먼저 DB를 설치한다. 

1. build.gradle 파일에 다음과 같이 dependencies를 추가한다.

   ```
   ...
   dependencies {
   	implementation 'org.springframework.boot:spring-boot-starter-web'
   	testImplementation 'org.springframework.boot:spring-boot-starter-test'
   	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
   	developmentOnly 'org.springframework.boot:spring-boot-devtools'
   	compileOnly 'org.projectlombok:lombok'
   	annotationProcessor 'org.projectlombok:lombok'
   	runtimeOnly 'com.oracle.database.jdbc:ojdbc11'
   }
   ...
   ```

   그 다음 build.gradle 파일을 선택한 후 마우스 오른쪽 버튼을 눌러 Gradle - Refresh Gradle Project를 클릭하여 필요한 라이브러리를 설치한다.

2. 설치한 DB를 사용하려면 src/main/resources 디렉터리의 application.properties 파일에 새로운 설정을 추가해야 한다. 다음과 같이 application.properties 파일을 작성한다.

   ```
   ...
   
   #DATABASE
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521/orcl
   spring.datasource.username=C##SCOTT
   spring.datasource.password=0000
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
   
   ...
   ```

   * spring.datasource.url=jdbc:oracle:thin:@localhost:1521/orcl

     DB에 접속하기 위한 URL 경로이다.

     * jdbc

       DB 드라이버를 의미한다. 다른 드라이버(예를 들면 ODBC)를 사용한다면 해당 드라이버를 기입한다.

     * oracle

       사용하려는 DB가 Oracle임을 나타낸다.

     * thin

       Thin Driver를 사용한다는 것을 의미한다.

       Thin Driver는 Java로 작성된 경량 드라이버로, 네트워크를 통해 직접 DB 서버에 접속한다.

       클라이언트 쪽에 추가적인 네이티브 라이브러리를 설치하지 않아도 되는 장점이 있다.

     * @

       드라이버가 연결 정보(host, port, database)를 포함하는 부분이 시작된다는 것을 나타낸다.

     * localhost

       DB 서버의 호스트 이름 또는 IP 주소를 나타낸다.

       여기서는 `localhost`로 로컬 컴퓨터(자기 자신의 머신)를 가리킨다.

       원격 서버에 연결하려면 해당 서버의 IP 주소나 도메인 이름으로 바꿔야 한다.

     * 1521

       DB 서버의 포트 번호이다.

       다른 포트를 사용할 경우 해당 번호로 변경해야 한다.

     * orcl

       연결하려는 DB의 서비스 이름(Service Name) 또는 SID를 나타낸다.

       환경에 적합한 서비스 이름을 사용해야 한다.

   * spring.datasource.username=C##SCOTT

     DB 서버의 사용자 이름(계정)이다.

     C##은 Oracle 12d 부터 사용되는 구문 규칙이다.

   * spring.datasource.password=0000

     DB 서버의 사용자 패스워드이다.

   * spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

     Oracle JDBC 드라이버 클래스 이름이다(oracle.jdbc.OracleDriver).

3. spring.datasource.url에 설정한 경로에 해당하는 DB 파일을 만들어야 한다. 스프링 부트에서 Oracle DB는 DB 경로를 따로 설정하지 않는다. 대신, Oracle DB에서 DB 경로를 직접 설정을 해야 한다.

### JPA 환경 설정하기

DB를 사용할 준비가 끝났다. 이제 자바 프로그램에서 DB를 사용할 수 있게 해야 한다. 자바 프로그램에서 DB에 데이터를 저장하거나 조회하려면 JPA를 사용해야 한다. 하지만 JPA를 사용하려면 먼저 준비 작업이 필요하다.

1. 다음처럼 build.gradle 파일을 수정한다.

   ```
   ...
   
   dependencies {
   	implementation 'org.springframework.boot:spring-boot-starter-web'
   	testImplementation 'org.springframework.boot:spring-boot-starter-test'
   	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
   	developmentOnly 'org.springframework.boot:spring-boot-devtools'
   	compileOnly 'org.projectlombok:lombok'
   	annotationProcessor 'org.projectlombok:lombok'
   	runtimeOnly 'com.oracle.database.jdbc:ojdbc11'
   	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
   }
   
   ...
   ```

   이전과 마찬가지로 build.gradle 파일을 선택한 후 마우스 오른쪽 버튼을 눌러 Gradle - Refresh Gradle Project를 클릭하여 변경 사항을 적용하면 JPA 라이브러리가 설치된다.

   cf) : implementation이란?

   build.gradle 파일에서 작성한 implementation은 필요한 라이브러리 설치를 위해 가장 일반적으로 사용하는 설정이다. implementation은 해당 라이브러리가 변경되더라도 이 라이브러리와 연관된 모든 모듈을 컴파일하지 않고 변경된 내용과 관련이 있는 모듈만 컴파일하므로 프로젝트를 리빌드하는 속도가 빠르다.

2. JPA 설정을 위해 이번에는 application.properties 파일을 다음과 같이 수정한다.

   ```
   #JPA
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
   spring.jpa.hibernate.ddl-auto=update
   ```

   추가한 설정 항목을 살펴본다.

   * spring.jpa.properties.hibernate.dialect

     스프링 부트와 하이버네이트를 함께 사용할 때 필요한 설정 항목이다. 표준 SQL이 아닌 하이버네이트만의 SQL을 사용할 때 필요한 항목으로 하이버네이트의 org.hibernate.dialect.Oracle21cDialect 클래스를 설정했다.

   * spring.jpa.hibernate.ddl-auto

     엔티티를 기준으로 데이터의 테이블을 생성하는 규칙을 설정한다.

   cf) : spring.jpa.hibernate.ddl-auto의 규칙을 더 알아본다.

   * none : 엔티티가 변경되더라도 데이터베이스를 변경하지 않는다.
   * update : 엔티티의 변경된 부분만 데이터베이스에 적용한다.
   * validate : 엔티티와 테이블 간에 차이점이 있는지 검사만 한다.
   * create : 스프링 부트 서버를 시작할 때 테이블을 모두 삭제한 후 다시 생성한다.
   * create-drop : create와 동일하지만 스프링 부트 서버를 종료할 때에도 테이블을 모두 삭제한다.

   개발 환경에서는 보통 update 모드를 사용하고, 운영 환경에서는 none 또는 validate를 주로 사용한다.

## 엔티티로 테이블 매핑하기

앞서 JPA로 DB를 사용할 준비를 마쳤다. JPA를 사용하려면 반드시 엔티티를 이해해야 한다. 그전에 DB의 구성 요소를 살펴보고 이어 엔티티에 대해 알아본다.

### 데이터베이스 구성 요소 살펴보기

### 엔티티 속성 구성하기

SBB에 사용할 엔티티를 만들어 보며 개념을 이해한다. 엔티티는 DB 테이블과 매핑되는 자바 클래스를 말한다. 우리가 만들고 있는 SBB는 질문과 답변을 할 수 있는 게시판 서비스이므로 SBB의 질문과 답변 데이터를 저장할 DB 테이블과 매핑되는 질문과 답변 엔티티가 있어야 한다.

※ 엔티티를 모델 또는 도메인 모델이라고도 한다. 여기에서는 이것을 구분하지 않고 테이블과 매핑되는 클래스를 모두 엔티티라 지칭한다.

그렇다면 먼저, 만들어야 할 질문(Question)과 답변(Answer) 엔티티에는 각각 어떤 속성들이 필요한지 생각한다. 우리가 만들려는 SBB 게시판은 사용자가 질문을 남기고 답변을 받을 수 있는 웹 서비스이다. 이와 같은 서비스를 제공하기 위해서는 사용자가 입력한 질문을 저장해야 하고, 질문의 제목과 내용을 담을 수 있는 항목이 필요하다. 그러므로 질문의 '제목'과 '내용' 등을 엔티티의 속성으로 추가해야 한다. 질문 엔티티에는 다음과 같은 속성이 필요하고, 이러한 엔티티의 속성은 테이블의 열과 매핑이 된다.

| 속성 이름  | 설명                      |
| ---------- | ------------------------- |
| id         | 질문 데이터의 고유 번호   |
| subject    | 질문 데이터의 제목        |
| content    | 질문 데이터의 내용        |
| createData | 질문 데이터를 작성한 일시 |

마찬가지로 답변 엔티티에는 다음과 같은 속성이 필요하다.

| 속성 이름  | 설명                      |
| ---------- | ------------------------- |
| id         | 답변 데이터의 고유 번호   |
| question   | 질문 데이터               |
| content    | 답변 데이터의 내용        |
| createData | 답변 데이터를 작성한 일시 |

이렇게 생각한 속성을 바탕으로 질문과 답변에 해당되는 엔티티를 작성한다.

### 질문 엔티티 만들기

다음과 같이 질문 엔티티를 만든다. 먼저 src/main/java 디렉터리의 com.mysite.sbb 패키지에 Question.java 파일을 작성해 Question 클래스를 만든다.

```java
package com.mysite.sbb;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
}
```

엔티티로 만들기 위해 Question 클래스에 @Entity 어노테이션을 적용했다. 이와 같이 @Entity 어노테이션을 적용해야 스프링 부트가 Question 클래스를 엔티티로 인식한다.

그리고 엔티티의 속성으로 고유 번호(id), 제목(subject), 내용(content), 작성 일시(createDate)를 작성했다. 각 속성에는 Id, GeneratedValue, Column과 같은 어노테이션이 적용되어 있는데 하나씩 살펴본다.

#### @Id 어노테이션

id 속성에 적용한 @Id 어노테이션은 id 속성을 기본키로 지정한다. id 속성을 기본키로 지정한 이유는 id 속성의 고유 번호들은 엔티티에서 각 데이터들을 구분하는 유효한 값으로, 중복되면 안 되기 때문이다.

#### @GeneratedValue 어노테이션

@GeneratedValue 어노테이션을 적용하면 데이터를 저장할 때 해당 속성에 값을 일일이 입력하지 않아도 자동으로 1씩 증가하여 저장된다. strategy = GenerationType.IDENTITY는 고유한 번호를 생성하는 방법을 지정하는 부분으로, GenerationType.IDENTITY는 해당 속성만 별도로 번호가 차례대로 늘어나도록 할 때 사용한다.

※ strategy 옵션을 생략한다면 @GeneratedValue 어노테이션이 지정된 모든 속성에 번호를 차례로 생성하므로 순서가 일정한 고유 번호를 가질 수 없게 된다. 이러한 이유로 보통 strategy = GenerationType.IDENTITY를 많이 사용한다.

#### @Column 어노테이션

엔티티의 속성은 테이브릐 열 이름과 일치하는데 열의 세부 설정을 위해 @Column 어노테이션을 사용한다. length는 열의 길이를 설정할 때 사용하고(여기서는 열의 길이를 200으로 정했다), columnDefinition은 열 데이터의 유형이나 성격을 정의할 때 사용한다. 여기서 columnDefinition = "TEXT"는 말 그대로 '텍스트'를 열 데이터로 넣을 수 있음을 의미하고, 글자 수를 제한할 수 없는 경우에 사용한다.

※ 엔티티의 속성은 @Column 어노테이션을 사용하지 않더라도 테이블의 열로 인식한다. 테이블의 열로 인식하고 싶지 않다면 @Transient 어노테이션을 사용한다. @Transient 어노테이션은 엔티티의 속성을 테이블의 열로 만들지 않고 클래스의 속성 기능으로만 사용하고자 할 때 쓴다.

cf) : 엔티티의 속성 이름과 테이블의 열 이름의 차이

Question 엔티티에서 작성 일시에 해당하는 createDate 속성의 이름은 DB 테이블에서는 create_date라는 열 이름으로 설정된다. 즉, createDate 처럼 카멜케이스 형식의 이름은 create_date처럼 모두 소문자로 변경되고 단어가 언더바로 구분되어 DB 테이블의 열 이름이 된다.

cf) : 엔티티를 만들 때 Setter 메서드는 사용하지 않는다.

일반적으로 엔티티를 만들 때에는 Setter 메서드를 사용하는것을 지양한다. 왜냐하면 엔티티는 DB와 바로 연결되므로 데이터를 자유롭게 변경할 수 있는 Setter 메서드를 허용하는 것이 안전하지 않다고 판단하기 때문이다. 그렇다면 Setter 메서드 없이 어떻게 엔티티에 값을 저장할 수 있을까?

엔티티는 생성자에 의해서만 엔티티의 값을 저장할 수 있게 하고, 데이터를 변경해야 할 경우에는 메서드를 추가로 작성하면 된다. 

### 답변 엔티티 만들기

1. 답변 엔티티를 만든다. 먼저 src/main/java 디렉터리의 com.mysite.sbb 패키지에 Answer.java 파일을 작성해 Answer 클래스를 만든다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   
   import jakarta.persistence.Column;
   import jakarta.persistence.Entity;
   import jakarta.persistence.GeneratedValue;
   import jakarta.persistence.GenerationType;
   import jakarta.persistence.Id;
   import lombok.Getter;
   import lombok.Setter;
   
   @Getter
   @Setter
   @Entity
   public class Answer {
   	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	private Integer id;
   	
   	@Column(columnDefinition = "TEXT")
   	private String content;
   	
   	private LocalDateTime createDate;
   	
   	private Question question;
   }
   ```

   질문 엔티티와 달리 답변 엔티티에서는 질문 엔티티를 참조하기 위해 question 속성을 추가했다.

2. 답변을 통해 질문의 제목을 알고 싶다면 answer.getQuestion().getSubject()를 사용해 접근할 수 있다. 하지만 이렇게 question 속성만 추가하면 안 되고 질문 엔티티와 연결된 속성이라는 것을 답변 엔티티에 표시해야 한다. 즉, 다음과 같이 Answer 엔티티의 question 속성에 @ManyToOne 어노테이션을 추가해 질문 엔티티와 연결한다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   
   import org.springframework.data.annotation.CreatedDate;
   
   import jakarta.persistence.Column;
   import jakarta.persistence.Entity;
   import jakarta.persistence.GeneratedValue;
   import jakarta.persistence.GenerationType;
   import jakarta.persistence.Id;
   import jakarta.persistence.ManyToOne;
   import lombok.Getter;
   import lombok.Setter;
   
   @Getter
   @Setter
   @Entity
   public class Answer {
   	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	private Integer id;
   	
   	@Column(columnDefinition = "TEXT")
   	private String content;
   	
   	@CreatedDate
   	private LocalDateTime createDate;
   	
   	@ManyToOne
   	private Question question;
   }
   ```

   게시판 서비스에서는 하나의 질문에 답변은 여러 개가 달릴 수 있다. 따라서 답변은 Many(많은 것)가 되고 질문은 One(하나)이 된다. 즉, @ManyToOne 어노테이션을 사용하면 N:1 관계를 나타낼 수 있다. 이렇게 @ManyToOne 어노테이션을 설정하면 Answer(답변) 엔티티의 question 속성과 Question(질문) 엔티티가 서로 연결된다(실제 DB에서는 외래키 관계가 생성된다).

   ※ @ManyToOne은 부모 자식 관계를 갖는 구조에서 사용한다. 여기서 부모는 Question, 자식은 Answer라고 할 수 있다.

   ※ 외래키란 테이블과 테이블 사이의 관계를 구성할 때 연결되는 열을 의미한다.

3. 그렇다면 반대로 질문에서 답변을 참조할 수는 없는가? 물론 가능하다. 답변과 질문이 N:1 관계라면 답변은 1:N 관계라고 할 수 있다. 이런 경우에는 @ManyToOne이 아닌 @OneToMany 어노테이션을 사용한다. 질문 하나에 답변은 여러 개이므로 Question 엔티티에 추가할 Answer 속성은 List 형태로 구성해야 한다. 이를 구현하기 위해 Question 엔티티를 다음과 같이 수정한다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   import java.util.List;
   
   import jakarta.persistence.CascadeType;
   import jakarta.persistence.Column;
   import jakarta.persistence.Entity;
   import jakarta.persistence.GeneratedValue;
   import jakarta.persistence.GenerationType;
   import jakarta.persistence.Id;
   import jakarta.persistence.OneToMany;
   import lombok.Getter;
   import lombok.Setter;
   
   @Getter
   @Setter
   @Entity
   public class Question {
   	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	private Integer id;
   	
   	@Column(length = 200)
   	private String subject;
   	
   	@Column(columnDefinition = "TEXT")
   	private String content;
   	
   	private LocalDateTime createDate;
   	
   	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
   	private List<Answer> answerList;
   }
   ```
   
   Answer 객체들로 구성된 answerList를 Question 엔티티의 속성으로 추가하고 @OneToMany 어노테이션을 설정했다. 질문에서 답변을 참조하려면 question.getAnswerList()를 호출한다. @OneToMany 어노테이션에 사용된 mappedBy는 참조 엔티티의 속성명을 정의한다. 즉, Answer 엔티티에서 Question 엔티티를 참조한 속성인 question을 mappedBy에 전달해야 한다.
   
   cf) : CascadeType.REMOVE란?
   
   게시판 서비스에서 질문 하나에 답변이 여러 개 작성될 수 있다. 그런데 보통 게시판 서비스에서는 질문을 삭제하면 그에 달린 답변들도 함께 삭제된다. SBB도 질문을 삭제하면 그에 달린 답변들도 모두 삭제되도록 cascade = CascadeType.REMOVE를 사용했다. 이와 관련해 보다 자세한 내용을 알고 싶다면 https://www.baeldung.com/jpa-cascade-types를 참고한다.

## 리포지터리로 데이터베이스 관리하기

앞서 엔티티로 테이블을 구성하여 데이터를 관리할 준비를 마쳤다. 하지만 엔티티만으로는 테이블의 데이터를 저장, 조회, 수정, 삭제 등을 할 수 없다. 이와 같이 데이터를 관리하려면 데이터베이스와 연동하는 JPA 리포지터리가 반드시 필요하다.

### 리포지터리 생성하기

엔티티가 DB 테이블을 생성했다면, 리포지터리는 이와 같이 생성된 DB 테이블의 데이터들을 저장, 조회, 수정, 삭제 등을 할 수 있도록 도와주는 인터페이스이다. 이때 리포지터리는 테이블에 접근하고, 데이터를 관리하는 메서드(예를 들어 findAll, save 등)를 제공한다.

1. 리포지터리를 만들기 위해 com.mysite.sbb 패키지를 선택한 후 마우스 오른쪽 버튼을 누르고 New - Interface를 클릭해 QuestionRepository 인터페이스를 생성한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.data.jpa.repository.JpaRepository;
   
   public interface QuestionRepository extends JpaRepository<Question, Integer> {
   	
   }
   ```

   생성한 QuestionRepository 인터페이스를 리포지터리로 만들기 위해 JpaRepository 인터페이스를 상속한다. JpaRepository는 JPA가 제공하는 인터페이스 중 하나로 CRUD 작업을 처리하는 메서드를 이미 내장하고 있어 데이터 관리 작업을 좀 더 편리하게 처리할 수 있다. JpaRepository<Question, Integer>는 Question 엔티티로 리포지터리를 생성한다는 의미이다. Question 엔티티의 기본키의 자료형이 Integer임을 이와 같이 추가로 지정해야 한다.

2. 마찬가지로 AnswerRepository 인터페이스를 생성한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.data.jpa.repository.JpaRepository;
   
   public interface AnswerRepository extends JpaRepository<Answer, Integer> {
   
   }
   ```

   이제 QuestionRepository, AnswerRepository를 이용하여 question, answer 테이블에 데이터를 저장, 조회, 수정, 삭제할 수 있다.

### JUnit 설치하기

리포지터리를 이용하여 데이터를 저장하려면 질문을 등록하는 화면과 사용자가 입력한 질문 관련 정보를 저장하는 컨트롤러, 서비스 파일 등이 필요하다. 하지만 JUnit을 사용하면 이러한 프로세스를 따르지 않아도 리포지터리만 개별적으로 실행해 테스트해 볼 수 있다. 앞서 작성한 리포지터리가 정상적으로 동작하는지 직접 테스트하기 위해 먼저 JUnit을 설치한다.

※ JUnit은 테스트 코드를 작성하고, 작성한 테스트 코드를 실행할 때 사용하는 자바의 테스트 프레임워크이다. 사실 JUnit은 리포지터리뿐만 아니라 소프트웨어 개발 시 테스트 작업을 수행할 때 많이 사용한다.

JUnit을 사용하려면 build.gradle 파일에 다음과 같은 내용을 추가해야 한다.

```
...

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	compileOnly 'org.projectlombok:lombok'
	annotationProcessor 'org.projectlombok:lombok'
	runtimeOnly 'com.oracle.database.jdbc:ojdbc11'
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	
	// JUnit 의존성
	testImplementation 'org.junit.jupiter:junit-jupiter'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}

...
```

추가 후 Refresh Gradle Project를 선택하여 JUnit 설치를 마친다. JUnit을 사용할 준비가 된 것이다.

### 질문 데이터 저장하기

1. 질문 엔티티로 테이블을 만들었으니 이제 만들어진 테이블에 데이터를 생성하고 저장한다. 먼저, src/test/java 디렉터리의 com.mysite.sbb 패키지에 SbbApplicationTests.java 파일을 열어 본다.

   ![image-20250411180222214](./assets/image-20250411180222214.png)

2. SbbApplicationTests.java 파일을 다음과 같이 수정한다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   
   import org.junit.jupiter.api.Test;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   
   @SpringBootTest
   class SbbApplicationTests {
   	
   	@Autowired
   	private QuestionRepository questionRepository;
   
   	@Test
   	void testJpa() {
   		Question q1 = new Question();
   		q1.setSubject("sbb가 무엇인가요?");
   		q1.setContent("sbb에 대하여 알고 싶다.");
   		q1.setCreateDate(LocalDateTime.now());
   		this.questionRepository.save(q1);
   		
   		Question q2 = new Question();
   		q2.setContent("스프링 부트 모델 질문");
   		q2.setContent("id는 자동으로 생성되는가?");
   		q2.setCreateDate(LocalDateTime.now());
   		this.questionRepository.save(q2);
   	}
   
   }
   ```

   @SpringBootTest 어노테이션은 SbbApplicationTests 클래스가 스프링 부트의 테스트 클래스임을 의미한다. 그리고 질문 엔티티의 데이터를 생성할 때 리포지터리(여기서는 QuestionRepository)가 필요하므로 @Autowired 어노테이션을 통해 스프링의 '의존성 주입(DI)'이라는 기능을 사용하여 QuestionRepository의 객체를 주입했다.

   ※ 스프링의 의존성 주입(DI)이란 스프링이 객체를 대신 생성하여 주입하는 기법을 말한다.

   > cf) : @Autowired 어노테이션
   >
   > 앞서 작성한 테스트 코드를 보면 questionRepository 변수는 선언만 되어 있고 그 값이 비어 있다. 하지만 @Autowired 어노테이션을 해당 변수에 적용하면 스프링 부트가 questionRepository 객체를 자동으로 만들어 주입한다. 객체를 주입하는 방식에는 @Autowired 어노테이션을 사용하는것 외에 Setter 메서드 또는 생성자를 사용하는 방식이 있다. 순환 참조 문제와 같은 이유로 개발 시 @Autowired보다는 생성자를 통한 객체 주입 방식을 권장한다. 하지만 테스트 코드의 경우 JUnit이 생성자를 통한 객체 주입을 지원하지 않으므로 테스트 코드 작성 시에만 @Autowired를 사용하고 실제 코드 작성 시에는 생성자를 통한 객체 주입 방식을 사용한다. 

   @Test 어노테이션은 testJpa 메서드가 테스트 메서드임을 나타낸다. SbbApplicationTests 클래스를 JUnit으로 실행하면 @Test 어노테이션이 붙은 testJpa 메서드가 실행된다.

   testJpa 메서드의 내용을 자세히 보자. testJpa 메서드는 q1, q2라는 질문 엔티티의 객체를 생성하고 QuestionRepository를 이용하여 그 값을 DB에 저장한다. 이와 같이 데이터를 저장하면 DB의 question 테이블은 다음과 같은 형태로 저장될 것이다.

   | ID   | Content                   | CreateDate          | Subject                      |
   | ---- | ------------------------- | ------------------- | ---------------------------- |
   | 1    | sbb에 대해서 알고 싶다.   | 2025-04-11-18:22:22 | sbb가 무엇인가?              |
   | 2    | id는 자동으로 생성되는가? | 2025-04-11-18:22:22 | 스프링 부트 모델 질문입니다. |

3. 이제 작성한 SbbApplicationTests 클래스를 실행한다. Run - Run As - JUnit Test 순서대로 선택하면 SbbApplicationTests 클래스를 실행할 수 있다.

4. 하지만 로컬 서버가 이미 구동 중이라면 'The file is locked: nio:/Users/pahkey/local.mv.db'와 비슷한 오류가 발생할 것이다. 오라클 DB는 파일 기반의 DB인데, 이미 로컬 서버가 동일한 DB 파일(local.mv.db)을 점유하고 있어 이러한 오류가 발생하는 것이다. 따라서 테스트할 때는 먼저 로컬 서버를 중지해야 한다. 로컬 서버는 다음과 같이 Boot Dashboard에서 중지 버튼을 클릭하여 중지할 수 있다.

5. 만약 오류가 발생했다면 로컬 서버를 중지하고 Run - Run을 클릭한 뒤, 다시 테스트를 실행한다. 그러면 오른쪽과 같은 JUnit 화면이 나타나고 오류 없이 잘 실행된다.

6. 실제 DB에 값이 잘 들어갔는지 확인해 보기 위해 다시 로컬 서버를 시작하고 DB에 접속하여 다음 쿼리를 실행한다.

   ```sql
   SELECT * FROM QUESTION
   ```

   그러면 다음과 같이 우리가 저장한 Question 객체의 값이 DB의 데이터로 저장된 것을 확인할 수 있다.

   ※ id는 질문 엔티티의 기본키로, 질문 엔티티를 생성할 때 @GeneratedValue를 활용해 설정했던 대로 속성값이 자동으로 1씩 증가하는 것을 확인할 수 있다.

   ※ JPA가 적용되지 않으므로(에러) 테이블을 아래와 같이 1씩 증가하도록 작성했다.

   ```sql
   DROP TABLE ANSWER;
   DROP TABLE QUESTION;
   
   CREATE TABLE QUESTION(
       ID              NUMBER(10) GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
       SUBJECT         NVARCHAR2(20),
       CONTENT         CLOB,
       CREATE_DATE     DATE
   );
   
   CREATE TABLE ANSWER(
       ID              NUMBER(10)  PRIMARY KEY,
       QUESTION_ID     NUMBER(10),
       CONTENT         CLOB,
       CREATE_DATE     DATE,
       CONSTRAINT      fk_question     FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE   
   );
   ```

### 질문 데이터 조회하기

리포지터리가 제공하는 메서드들을 하나씩 살펴보고 이를 활요해 데이터를 조회한다.

#### findAll 메서드

SbbApplicationTests.java 파일에서 작성한 테스트 코드를 다음과 같이 수정해 보자.

```java
package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());
		Question q = all.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}
}
```

question 테이블에 저장된 모든 데이터를 조회하기 위해서 리포지터리(questionRepository)의 findAll 메서드를 사용했다. 앞서 2개의 질문 데이터를 저장했기 때문에 데이터 사이즈는 2가 되어야 한다. 데이터 사이즈가 2인지 확인하기 위해 JUnit의 assertEquals 메서드를 사용하는데, 이 메서드는 테스트에서 예상한 결과와 실제 결과가 동일한지를 확인하는 목적으로 사용한다. 즉, JPA 또는 DB에서 데이터를 올바르게 가져오는지를 확인하려는 것이다. assertEquals(기잿값, 실젯값)와 같이 작성하고 기댓값과 실젯값이 동일한지를 조사한다. 만약 기댓값과 실젯값이 동일하지 않다면 테스트는 실패로 처리된다. 여기서는 우리가 저장한 첫 번째 데이터의 제목이 'sbb가 무엇인가요?' 데이터와 일치하는지도 테스트했다. 테스트할 때 로컬 서버를 중지하고 다시 한번 Run - Run As - JUnit Test을 실행하면 테스트가 성공했다고 표시될 것이다.

#### findById 메서드

이번에는 질문 엔티티의 기본인 id의 값을 활용해 데이터를 조회한다.

```java
package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()) {
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}

}
```

id값으로 데이터를 조회하기 위해서는 리포지터리의 findById 메서드를 사용해야 한다. 여기서 questionRepository를 사용하여 DB에서 id가 1인 질문을 조회한다. 이때 findById의 리턴 타입은 Question이 아닌 Optional임에 주의한다. findById로 호출한 값이 존재할 수도 있고, 존재하지 않을 수도 있어서 리턴 타입으로 Optional이 사용된 것이다.

Optional은 그 값을 처리하기 위한(null값을 유연하게 처리하기 위한) 클래스로, isPresent() 메서드로 값이 존재하는지 확인할 수 있다. 만약 isPresent()를 통해 값이 존재한다는 것을 확인했다면, get() 메서드를 통해 실제 Question 객체의 값을 얻는다. 즉, 여기서는 DB에서 ID가 1인 질문을 검색하고, 이에 해당하는 질문의 제목이 'sbb가 무엇인가요?'인 경우에 JUnit 테스트를 통과하게 된다.

#### findBySubject 메서드

이번에는 질문 엔티티의 subject값으로 데이터를 조회한다.

1. 아쉽게도 리포지터리는 findBySubject 메서드를 기본적으로 제공하지는 않는다. 그래서 findBySubject 메서드를 기본적으로 제공하지는 않는다. 그래서 findBySubject 메서드를 사용하려면 다음과 같이 QuestionRepository 인터페이스를 변경해야 한다. 먼저 src/main/java 디렉터리로 돌아가 com.mysite.sbb 패키지의 QuestionRepository.java를 수정한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.data.jpa.repository.JpaRepository;
   
   public interface QuestionRepository extends JpaRepository<Question, Integer> {
   	Question findBySubject(String subject);
   }
   ```

2. 다시 src/test/java 디렉터리로 돌아가 com.mysite.sbb 패키지의 SbbApplicationTests.java를 수정해 subject 값으로 테이블에 저장된 데이터를 조회할 수 있다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   import java.util.List;
   import java.util.Optional;
   
   import org.junit.jupiter.api.Test;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   
   import static org.junit.jupiter.api.Assertions.assertEquals;
   
   @SpringBootTest
   class SbbApplicationTests {
   	
   	@Autowired
   	private QuestionRepository questionRepository;
   
   	@Test
   	void testJpa() {
   		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
   		assertEquals(1, q.getId());
   	}
   
   }
   ```

   테스트 코드를 실행해 보면 성공적으로 통과된다. '인터페이스에 findBySubject라는 메서드를 선언만 하고 구현하지 않았는데 도대체 어떻게 실행되는 거지?'라는 궁금징이 생길 수 있다. 이는 JPA에 리포지터리의 메서드명을 분석하여 쿼리를 만들고 실행하는 기능이 있기 때문에 가능하다. 즉, findBy + 엔티티의 속성명(예를 들어 findBySubject)과 같은 리포지터리의 메서드를 작성하면 입력한 속성의 값으로 데이터를 조회할 수 있다.

3. findBySubject 메서드를 호출할 때 실제 DB에서는 어떤 쿼리문이 실행되는지 살펴본다. 실행되는 쿼리문은 콘솔 로그에서 확인할 수 있다. 그러기 위해 다음과 같이 application.properties 파일을 수정한다.

   ```
   spring.application.name=sbb
   
   #SERVER
   server.port=8080
   
   #DATABASE
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521/orcl
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
   spring.datasource.username=C##SCOTT
   spring.datasource.password=0000
   
   
   #JPA
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.format_sql=true
   spring.jpa.properties.hibernate.show_sql=true
   ```

4. 그리고 다시 한번 테스트 코드를 실행한다. 그러면 다음과 같이 콘솔 로그에서 DB에서 실행된 쿼리문을 확인할 수 있다.

   ```
   Hibernate: 
       select
           q1_0.id,
           q1_0.content,
           q1_0.create_date,
           q1_0.subject 
       from
           question q1_0 
       where
           q1_0.subject=?
   ```

   실행한 쿼리문 중 where 문에 조건으로 subject가 포함된 것을 확인할 수 있다.

#### findBySubjectAndContent 메서드

1. 이번에는 subject와 content를 함께 조회한다. SQL을 활용해 DB에서 두 개의 열(여기서는 엔티티의 속성)을 조회하기 위해서는 And 연산자를 사용한다. subject와 content 속성을 조회하기 위해 findBySubject와 마찬가지로 리포지터리에 findBySubjectAndContent 메서드를 추가해야 한다. 다음과 같이 QuestionRepository.java 파일을 수정한다.

   ```java
   package com.mysite.sbb;
   
   import org.springframework.data.jpa.repository.JpaRepository;
   
   public interface QuestionRepository extends JpaRepository<Question, Integer> {
   	Question findBySubject(String subject);
   	Question findBySubjectAndContent(String subject, String content);
   }
   ```

2. 그리고 테스트 코드를 다음과 같이 작성한다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   import java.util.List;
   import java.util.Optional;
   
   import org.junit.jupiter.api.Test;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   
   import static org.junit.jupiter.api.Assertions.assertEquals;
   
   @SpringBootTest
   class SbbApplicationTests {
   	
   	@Autowired
   	private QuestionRepository questionRepository;
   
   	@Test
   	void testJpa() {
   		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
   		assertEquals(1, q.getId());
   	}
   
   }
   
   ```

   ```
   Hibernate: 
       select
           q1_0.id,
           q1_0.content,
           q1_0.create_date,
           q1_0.subject 
       from
           question q1_0 
       where
           q1_0.subject=? 
           and q1_0.content=?
   ```

   where 문에 and 연산자가 사용되어 subject와 content 열을 조회하는 것을 확인할 수 있다.

   이렇듯 리포지터리의 메서드명은 데이터를 조회하는 쿼리문의 where 조건을 결정하는 역할을 한다. 여기서는 findBySubject, findBySubjectAndContent 두 메서드만 알아봤지만 상당히 많은 조합을 사용할 수 있다. 조합할 수 있는 메서드를 간단하게 표로 정리해 보았다.

   | SQL 연산자       | 리포지터리의 메서드 예                                       | 설명                                                         |
   | ---------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
   | And              | findBySubjectAndContent(String subject, String content)      | Subject, Content 열과 일치하는 데이터를 조회                 |
   | Or               | findBySubjectOrContent(String subject, String content)       | Subject열 또는 Content 열과 일치하는 데이터를 조회           |
   | Between          | findByCreateDateBetween(LocalDateTime fromDate, LocalDateTime toDate) | CreateDate 열의 데이터 중 정해진 범위 내에 있는 데이터를 조회 |
   | LessThan         | findByLessThan(Integer id)                                   | id 열에서 조건보다 작은 데이터를 조회                        |
   | GreaterThanEqual | findByIdGreaterThanEqual(Integer id)                         | id 열에서 조건보다 크거나 같은 데이터를 조회                 |
   | Like             | findBySubjectLike(String subject)                            | Subject 열에서 문자열 'subject'와 같은 문자열을 포함한 데이터를 조회 |
   | In               | findBySubjectIn(String[] subjects)                           | Subject 열의 데이터가 주어진 배열에 포함되는 데이터만 조회   |
   | OrderBy          | findBySubjectOrderByCreateDateAsc(String subject)            | Subject 열 중 조건에 일치하는 데이터를 조회하여 그 데이터를 반환할 때 CreateDate 열을 오름차순으로 정렬하여 반환 |

#### findBySubjectLike 메서드

1. 이번에는 질문 엔티티의 subject 열 값들 중에 특정 문자열을 포함하는 데이터를 조회한다. SQL에서는 특정 문자열을 포함한 데이터를 열에서 찾을 때 Like를 사용한다. subject 열에서 특정 문자열을 포함하는 데이터를 찾기 위해 다음과 같이 findBySubjectLike 메서드를 리포지터리에 추가한다.

   ```java
   package com.mysite.sbb;
   
   import java.util.List;
   
   import org.springframework.data.jpa.repository.JpaRepository;
   
   public interface QuestionRepository extends JpaRepository<Question, Integer> {
   	Question findBySubject(String subject);
   	Question findBySubjectAndContent(String subject, String content);
   	List<Question> findBySubjectLike(String subject);
   }
   ```

2. 그리고 테스트 코드는 다음과 같이 수정한다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   import java.util.List;
   import java.util.Optional;
   
   import org.junit.jupiter.api.Test;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   
   import static org.junit.jupiter.api.Assertions.assertEquals;
   
   @SpringBootTest
   class SbbApplicationTests {
   	
   	@Autowired
   	private QuestionRepository questionRepository;
   
   	@Test
   	void testJpa() {
   		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
   		Question q = qList.get(0);
   		assertEquals("sbb가 무엇인가요?", q.getSubject());
   	}
   
   }
   ```

   findBySubjectLike 메서드를 사용할 때 데이터 조회를 위한 조건이 되는 문자열로 sbb%와 같이 %를 적어 주어야 한다. %는 표기하는 위치에 따라 의미가 달라진다. 아래 표를 살펴보자.

   | 표기 예 | 표기 위치에 따른 의미   |
   | ------- | ----------------------- |
   | sbb%    | 'sbb'로 시작하는 문자열 |
   | %sbb    | 'sbb'로 끝나는 문자열   |
   | %sbb%   | 'sbb'를 포함하는 문자열 |

### 질문 데이터 수정하기

1. 질문 엔티티의 데이터를 수정하는 테스트 코드를 작성한다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   import java.util.List;
   import java.util.Optional;
   
   import org.junit.jupiter.api.Test;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   
   import static org.junit.jupiter.api.Assertions.assertEquals;
   import static org.junit.jupiter.api.Assertions.assertTrue;
   
   @SpringBootTest
   class SbbApplicationTests {
   	
   	@Autowired
   	private QuestionRepository questionRepository;
   
   	@Test
   	void testJpa() {
   		Optional<Question> oq = this.questionRepository.findById(1);
   		assertTrue(oq.isPresent());
   		Question q = oq.get();
   		q.setSubject("수정된 제목");
   		this.questionRepository.save(q);
   	}
   
   }
   ```

   질문 엔티티의 데이터를 조회한 다음, subject 속성을 '수정한 제목'이라는 값으로 수정했다. 변경된 질문을 DB에 저장하기 위해서 this.questionRepository.sava(q)와 같이 리포지터리의 save 메서드를 사용했다.

2. 테스트를 수행해 보면 다음과 같이 콘솔 로그에서 update 문이 실행되었음을 확인할 수 있다.

   ```
   Hibernate: 
       select
           q1_0.id,
           q1_0.content,
           q1_0.create_date,
           q1_0.subject 
       from
           question q1_0 
       where
           q1_0.subject like ?
   ```

   그리고 SELECT * FROM QUESTION 쿼리문을 입력하고 실행해 question 테이블을 확인하면 subject의 값이 변경되었음을 알 수 있다.

   ![image-20250412153257018](./assets/image-20250412153257018.png)

### 질문 데이터 삭제하기

1. 이어서 데이터를 삭제한다. 여기서는 첫 번째 질문을 삭제해 본다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   import java.util.List;
   import java.util.Optional;
   
   import org.junit.jupiter.api.Test;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   
   import static org.junit.jupiter.api.Assertions.assertEquals;
   import static org.junit.jupiter.api.Assertions.assertTrue;
   
   @SpringBootTest
   class SbbApplicationTests {
   	
   	@Autowired
   	private QuestionRepository questionRepository;
   
   	@Test
   	void testJpa() {
   		assertEquals(2, this.questionRepository.count());
   		Optional<Question> oq = this.questionRepository.findById(1);
   		assertTrue(oq.isPresent());
   		Question q = oq.get();
   		this.questionRepository.delete(q);
   		assertEquals(1, this.questionRepository.count());
   	}
   
   }
   ```

   리포지터리의 delete 메서드를 사용하여 데이터를 삭제했다. 데이터 건수가 삭제하기 전에 2였는데, 삭제한 후 1이 되었는지를 테스트했다(리포지터리의 count 메서드는 테이블 행의 개수를 리턴한다).

2. 그리고 다시 question 테이블을 확인해 보면 다음과 같이 ID가 1인 행이 삭제되었음을 알 수 있다.

   ![image-20250412153641239](./assets/image-20250412153641239.png)

### 답변 데이터 저장하기

1. 이번에는 답변 엔티티의 데이터를 생성하고 저장한다. SbbApplicationTests.java 파일을 열고 다음과 같이 수정한다.

   ```java
   package com.mysite.sbb;
   
   import java.time.LocalDateTime;
   import java.util.List;
   import java.util.Optional;
   
   import org.junit.jupiter.api.Test;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.test.context.SpringBootTest;
   
   import static org.junit.jupiter.api.Assertions.assertEquals;
   import static org.junit.jupiter.api.Assertions.assertTrue;
   
   @SpringBootTest
   class SbbApplicationTests {
   	
   	@Autowired
   	private QuestionRepository questionRepository;
   	
   	@Autowired
   	private AnswerRepository answerRepository;
   
   	@Test
   	void testJpa() {
   		Optional<Question> oq = this.questionRepository.findById(2);
   		assertTrue(oq.isPresent());
   		Question q = oq.get();
   		
   		Answer a = new Answer();
   		a.setContent("네 자동으로 생성됩니다.");
   		a.setQuestion(q);
   		a.setCreateDate(LocalDateTime.now());
   		this.answerRepository.save(a);
   	}
   
   }
   ```

   질문 데이터를 저장할 때와 마찬가지로 답변 데이터를 저장할 때에도 리포지터리(여기서는 AnswerRepository)가 필요하므로 AnswerRepository의 객체를 @Autowired를 통해 주입했다. 답변을 생성하려면 질문이 필요하므로 우선 질문을 조회해야 한다. questionRepository의 findById 메서드를 통해 id가 2인 질문 데이터를 가져와 답변의 question 속성에 대입해 답변 데이터를 생성했다.

2. DB에 값이 잘 들어갔는지 확인한다.

   ![image-20250412154451974](./assets/image-20250412154451974.png)

### 답변 데이터 조회하기

답변 엔티티도 질문 엔티티와 마찬가지로 id 속성이 기본키이므로 값이 자동으로 생성된다. 질문 데이터를 조회할 때 findByID 메서드를 사용했듯이 id값을 활용해 데이터를 조회한다.

```java
package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testJpa() {
		Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion().getId());
	}

}
```

id값이 1인 답변을 조회했다. 그리고 조회한 답변과 연결된 질문의 id가 2인지도 조회해 보았다.

### 답변 데이터를 통해 질문 데이터 찾기 vs 질문 데이터를 통해 답변 데이터 찾기

앞에서 살펴본 답변 엔티티의 question 속성을 이용하면 다음과 같은 메서드를 사용해 '답변에 연결된 질문'에 접근할 수 있다.

```
a.getQuestion()
```

a는 답변 객체이고, a.getQuestion()은 답변에 연결된 질문 객체를 뜻한다.

답변에 연결된 질문 데이터를 찾는 것은 Answer 엔티티에 question 속성이 이미 정의되어 있어서 매우 쉽다.

그런데 반대의 경우도 가능할까? 즉, 질문 데이터에서 답변 데이터를 찾을 수 있을까? 다음과 같이 질문 엔티티에 정의한 answerList를 사용하면 해결할 수 있다.

```java
package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}

}
```

질문을 조회한 후 이 질문에 달린 답변 전체를 구하는 테스트 코드이다. id가 2인 질문 데이터에 답변 데이터를 1개 등록했으므로 이와 같이 코드를 작성해 확인할 수 있다.

왜냐하면 QuestionRepository가 findById 메서드를 통해 Question 객체를 조회하고 나면 DB 세션이 끊어지기 때문이다.

그래서 그 이후에 실행되는 q.getAnswerList() 메서드(Question 객체로부터 answer 리스트를 구하는 메서드)는 세션이 종료되어 오류가 발생한다. answerList는 앞서 q 객체를 조회할 때가 아니라 q.getAnswerList() 메서드를 호출하는 시점에 가져오기 때문에 이와 같이 오류가 발생한 것이다.

※ 이렇게 데이터를 필요한 시점에 가져오는 방식을 지연(Lazy) 방식이라고 한다. 이와 반대로 q 객체를 조회할 때 미리 answer 리스트를 모두 가져오는 방식은 즉시(Eager) 방식이라고 한다. @OneToMany, @ManyToOne 어노테이션 옵션으로 fetch-FetchType.LAZY 또는 fetch=FetchType.EAGER처럼 가져오는 방식을 설정할 수 있는데, 이 책에서는 따로 지정하지 않고 항상 디폴트값을 사용한다.

사실 이 문제는 테스트 코드에서만 발생한다. 실제 서버에서 JPA 프로그램들을 실행할 때는 DB 세션이 종료되지 않아 이와 같은 오류가 발생하지 않는다.

테스트 코드를 수행할 때 이런 오류를 방지할 수 있는 가장 간단한 방법은 다음과 같이 @Transactional 어노테이션을 사용하는 것이다. @Transactional 어노테이션을 사용하면 메서드가 종료될 때까지 DB 세션이 유지된다. 코드를 수정해본다.

```java
package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}

}
```

메서드에 @Transactional 어노테이션을 추가하면 오류 없이 잘 수행된다.

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





