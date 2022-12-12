# REWARD
1. 요구사항
```
1) 매일 00시 00분 00초에 선착순 10명에게 보상 지급 하는 REST API를 구현합니다.
2) 보상 지급 방식은 사용자가 받기를 누를 때 지급 하게 됩니다.
   > 선착순 10명에게 100 포인트의 보상이 지급 되며 10명 이후에는 지급되지 않아야 합니다.
   > 추가 보상은 10일 까지 이어지며 그 이후 연속 보상 횟수는 1회 부터 다시 시작 됩니다.
```
2. 구현 API 목록
```
1) 보상 데이터 조회 API
   > 보상 데이터의 상세 내용을 조회 합니다.
2) 보상 지급 API
   > 한 사용자는 같은 날 1회만 받을 수 있습니다.
   > 10명이 넘는다면 더 이상 지급되지 않아야합니다.
3) 보상 조회 API
   > 특정 일자 별 보상 받은 사용자 10명을 조회 가능하여야 합니다.
      > 검색 조건 : 날짜 (필수 값)
      > 정렬 조건 : 시간 오름 내림 차순
```
3. 추가 구현
```
1) Unit test 및 Integration test 작성 - 미구현
2) Front-end 페이지 구현 - 구현 (tymeleaf 사용)
3) 보상 지급 시 동시성 제어 처리 - 미구현
```
4. 실행 방법
```
1) STS 실행
2) Window - Show View - Other - Git - Git Repositories 선택
3) Clone a Git Repository
   > URI: https://github.com/ghkddlsdyd97/reward.git
   > Host: github.com
   > Repository path: /ghkddlsdyd97/reward.git
4) Next -> main 브런치 선택 -> Next -> Directory 선택 -> Finish
5) Git Repositories -> reward 우클릭 -> Import Projects -> Finish
6) 생성된 reward 프로젝트 우클릭 -> Run As -> Maven build
7) 해당 디렉토리 아래 reward.jar 파일 생성 확인
8) cmd 접속
9) cd 디렉토리명
10) java -jar reward.jar 명령어 실행
11) 웹 브라우저 localhost:8090 접속
```
5. DB 정보
```
1) 로그인
   > ID: test1 ~ test15
   > PW: 1234
2) 보상 내역
   > 임의 데이터 생성
3) 보상 지급
   > 임의 데이터 생성
```
6. 개발환경
```
> Tool: STS4
> FrameWork: Spring boot 2.7.X
> Build: Maven
> Java Version: 1.8
> Front-end: Tymeleaf
> Packaging: jar
> ORM: Mybatis
> DB: H2
```
