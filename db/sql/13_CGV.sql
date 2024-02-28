/*
영화 예매 사이트 요구 사항(CGV)
사용자 기능(회원 + 비회원)
- 조회(무비차트)
	- 사용자는 현재 상영 중이거나 상영 예정인 영화를 조회할 수 있다.
    - 영화는 오늘을 기준으로 1주일 동안 예매한 내역을 기준으로 예매순으로 조회한다.
    - 영화는 오늘 이후에 일정들을 예매한 내역을 기준으로 조회한다.
    - 예매 내역이 많은 순으로 조회한다.
- 조회(상영시간)
	- 사용자는 영화, 극장, 날짜를 선택해서 상영시간을 확인할 수 있다.
    - 사용자는 현재 상영중인 영화를 선택할 수 있다.
    - 사용자는 현재 영화가 상영중인 극장을 선택할 수 있다.
    - 사용자는 현재 영화가 상영중인 날짜를 선택할 수 있다.
    - 사용자가 영화, 극장, 날짜를 선택하면 영화관 정보(극장 이름, 전체 좌석 수)와 상영시간 별 현재 예매 가능 좌석수를 조회할 수 있다.
-조회(영화 상세 조회)
	- 사용자는 영화 상세 정보를 조회할 수 있다.
    - 상세 정보는 감독, 배우, 장르, 기본정보, 개봉일, 트레일러, 스틸컷이 있다.
    - 장르는 등록된 장르를 보여주며, 장르는 여러가지일 수 있다.
    - 기본정보에는 관람 나이정보, 런닝 시간(분), 제작 국가가 있다.
    - 제작 국가는 여러 국가가 될 수 있다.
    - 감독은 여러 감독이 올 수 있다.
    - 배우는 주연, 조연 구분 없이 등록된 배우를 영화에 등록된 배우순으로 조회한다.
- 검색
	- 사용자는 검색을 통해 등록된 영화를 조회할 수 있다.
    - 조회되는 영화는 현재 상영과 상관없이 제목을 기준으로 조회한다.
    
회원 기능
- 예매
	- 예매는 회원만 가능하다.
    - 상영시간을 선택하면 인원을 선택하고, 좌석을 선택해서 예매를 할 수 있다.
    - 인원은 성인, 청소년으로 구분한다.
    - 좌석은 선택된 인원수에 맞춰서 예매 가능한 좌석을 선택한다.
    - 예매가 완료되면 예매 번호가 할당되고, 예매 번호에 예매 좌석과 예매 인원 정보를 조회할 수 있다. 
    - 예매 시 할인은 없다.
    - 12시 이전에 상영하는 영화는 조조할인이 적용된다. 
    
관리자 기능
- 감독/배우 관리
	- 관리자는 감독/배우를 등록/수정/삭제할 수 있다. 
    - 감독/배우는 등록된 인물과 역할, 대표 사진을 선택하여 등록한다.
    - 같은 영화인이 감독과 배우로 각각 등록될 수 있다.
- 인물 관리
	- 관리자는 인물을 등록/수정/삭제할 수 있다.
    - 인물은 영화인의 정보로 이름, 생년월일, 내용, 국가를 입력한다. 
    
- 영화 관리
	- 관리자는 상영 예정/상영된 영화를 등록할 수 있다.
    - 영화 정보는 영화에 참여한 감독, 배우, 제목, 장르, 기본정보, 개봉일, 내용, 스틸컷, 트레일러를 입력하여 등록한다.
    - 감독은 등록된 감독 중 여러명 선택이 가능하다.
    - 배우는 등록된 배우 중 여러명 선택이 가능하다.
	- 장르는 등록된 장르 중 여러 장르를 선택할 수 있다.
    - 기본 정보에서 연령은 등록된 연령 중 하나를 선택할 수 있다. 
    - 런닝 시간은 분으로 입력한다.
    - 제작 국가는 등록된 국가 중 여러 국가를 선택할 수 있다.
    - 트레일러는 여러 트레일러를 등록할 수 있다.
    - 스틸컷은 여러 스틸컷을 등록할 수 있다. 
- 극장 관리 
	- 관리자는 극장을 등록/수정/삭제할 수 있다.
    - 극장은 지역, 이름, 상영관 정보, 주소, 총 관수를 입력하고,
	  총 좌석수는 등록된 상영관에 맞게 계산이 된다. 
	- 지역은 등록된 지역 중 하나를 선택한다.
    - 상영관 정보는 극장 등록과 함께 등록하거나 극장 등록 후 등록할 수 있다.
- 상영관 관리
	- 관리자는 상영관을 등록/수정/삭제할 수 있다.
    - 극장 등록 시 상영관을 추가하는 경우 상영관 번호, 총 좌석수, 좌석 정보를 입력하여 등록한다.
    - 극장 등록 후 상영관을 추가하는 경우 극장 번호, 상영관 번호, 총 좌석수, 좌석 정보를 입력하여 등록한다.
    - 상영관 번호는 극장의 총 관수보다 작거나 같아야 하며, 같은 극장에 등록된 상영관 번호는 쓸 수 없다.
    - 좌석 정보는 행의 수를 입력하고, 각 행의 열의 수를 입력한다.
    - 행의 수를 입력하면 수만큼 A부터 알파벳이 할당된다.
    - 좌석 정보 입력이 완료되면 A1부터 좌석 정보가 할당이 된다.
- 상영시간 관리 
	- 관리자는 상영시간 추가/수정/삭제할 수 있다.
    - 상영시간은 상영관 정보, 영화, 날짜, 상영시간을 입력하여 등록할 수 있다.
    - 상영관 정보는 극장을 선택하면 조회가 되고, 등록된 상영관 중에서 선택한다.
    - 영화는 등록된 영화 중에서 선택한다.
    - 상영시간은 10분 단위로 등록한다. 
- 요금 관리
	- 관리자는 요금을 수정할 수 있다.
    - 성인 요금과 조조할인 요금과 청소년 요금을 수정할 수 있다.
    - 기본 요금은 성인 14,000원 조조 11,000원 청소년 11,200원(성인의 80%)
*/