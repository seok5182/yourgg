<b>과제 요구사항</b>

- BE<br>
Java, Kotlin, Scala 중 택1 + Spring Boot<br>
=> Java + Spring Boot 선택

- FE<br>
Template Engine 사용(Thymeleaf, JSP 등)<br>
=> Thymeleaf 사용

- 소환사명 입력 후 가장 최근에 플레이한 매치의 상세 페이지를 보여줍니다.(소환사의 협곡 매치만 처리(일반, 솔랭, 자랭))
1) 소환사명을 입력할 수 있는 search.html 페이지 제작<br>
2) local 환경에서 localhost:8080, localhost:8080/your.gg, localhost:8080/your.gg.ko/kr 모두 search.html을 보여줄 수 있도록 HomeController 추가<br>
3) search.html의 검색 창에 소환사명(YOUR GG#GenG) 입력 시 LOL에서 제공하는 Open API를 사용하기 위해 properties에 발급받은 API key 추가<br>
4) Open API를 사용하는 서비스들을 모아두기 위한 RiotApiService 클래스 생성<br>
5) 소환사명 입력 후 가장 최근에 플레이한 매치의 상세 페이지를 보여주기 위한 순서 생각<br>
	가) 소환사명을 입력한다<br>
	나) 해당 소환사명을 사용하여 puuid를 알아낸다<br>
	다) 알아낸 puuid를 사용하여 해당 소환사의 가장 최근 매치의 id를 알아낸다<br>
	라) 알아낸 매치 id를 사용하여 해당 매치의 상세정보를 알아낸다<br>
	마) 알아낸 정보들을 사용하여 상세 페이지에 알맞게 뿌려준다<br>
6) 나)를 위한 getPuuidByRiotId 메서드를 RiotApiService에 생성<br>
7) 다)를 위한 getMostRecentMatchIdByPuuid 메서드를 RiotApiService에 생성<br>
8) 라)를 위한 getMatchDetails 메서드를 RiotApiService에 생성<br>
9) 8)에서 얻은 데이터를 LOL OpenAPI DOCS에서 제공하는 Dto에 각각 담기 위해 Dto들 생성<br>
10) 최종적으로 MatchDetails란 객체에 담아서 matchDetail.html로 전송<br>
11) matchDetail.html에서 각 요소에 알맞은 데이터 뿌려주기<br>
