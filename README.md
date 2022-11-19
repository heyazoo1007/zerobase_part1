# zerobase_part1 Mission1 

서울시 공공 와이파이 Open API를 이용한 개인 프로젝트입니다. 

Tech Stack
<br>
Language : Java
<br>
Tools : IntelliJ, Tomcat, gson, lombok
<br>
DataBase : MariaDb, DBeaver
<br>

Process 
* 서울시 공공와이파이 회원가입, open api 인증키 발급
* IntelliJ에 lombok, gson, okhttp3, tomcat 설치
* API 요청 및 응답 데이터 수신 완료
* mariadb jdbc 연결
* db에 객체 저장하는 로직(wifiSave) 구현
* 데이터 파싱 후 DTO 객체 생성 및 저장 구현
* 홈 화면 구현하기(텍스트, 버튼, 테이블)
* 현재 위치 JavaScript로 가져오기
* 현재 위치 히스토리 테이블에 저장
* 저장된 히스토리 값 리스트 조회 로직 구현
* (현재 위치 ~ 각 wifi 위치) 거리 구하고 거리 테이블에 저장 로직 구현
* 거리 테이블, wifi 테이블 조인 후 asc해서 20개 리스트 반환하는 로직 구현

진행하면서 배운 것들
* Spring 없이 jdbc 연결하는 방법 
* JPA 없이 CRUD 로직 구현하는 방법 
* JSP 사용하는 방법 

진행 중 어려웠던 점 
* Spring 없이 Tomcat 실행해본 적이 처음이라 어떻게 구현해야할지 몰랐는데, 프로젝트 생성시 JavaEE를 이용하면 구현한 화면 Tomcat으로 확인 가능


