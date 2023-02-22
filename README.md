# demo-devops
- Backend-API 테스트 및 데모 용도로 해당 프로젝트를 사용합니다.
- CI/CD, Kubernetes, Docker 등 다양한 기능을 붙일 때 테스트 용도로 프로젝트를 사용합니다.
- 개발환경
  - Spring Boot 2.7.0 / Java 11(Eclipse Temurin)
  - Gradle 7.5

# FYI : For Your Information 
- Q) gradlew는 무엇일까?</br>
  - gradlew로 설명할 것이 아니라 정확히는 Gradle Wrapper이다. </br>
  - Gradle을 각 개발자나 CI 서버에 깔지 않고, 프로젝트에 함께 포함시켜 배포할 수 있는 방법을 제공한다. </br>
  - ./gradlew build 생성 시 2가지 버전("프로젝트 이름-버전.jar", "프로젝트 이름-버전-plain.jar")이 만들어진다. </br>
  - Jar에 의해 생성된 "*-plain.jar"는 Application 실행에 필요한 모든 의존성을 포함하고 있지 않다. 소스코드의 클래스 & 리소스 파일만 포함</br>
  - BootJar에 의해 생성된 jar는 Application에 필요한 모든 의존성을 함께 Build </br>

- DockerFile Build & Run
  - `docker build -t demo-devops:1.0 .`
  - `docker run -p 8080:8080 [Repository Name]`

# k8s
- minikube 설치 후 minikube start로 실행해야 명령어 동작 가능.
- "deployment.yml" 파일 역할은?
-> 디플로이먼트는 파드와 레플리카에 대한 선언적 업데이트를 제공한다.

### 참고
- mapstruct get started : https://mapstruct.org/
- (MacBook) Install Gradle & Configuration GRADLE_HOME : https://skryvets.com/blog/2017/08/21/install-gradle-and-configure-gradle-home-on-a-mac/
- Gradle Wrapper : https://kwonnam.pe.kr/wiki/gradle/wrapper
- Spring-Boot-Docker : https://spring.io/guides/topicals/spring-boot-docker/
- k8s / deployment : https://kubernetes.io/ko/docs/concepts/workloads/controllers/deployment/