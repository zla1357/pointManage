# pointManage
point 관리 서비스

## 포인트 내역 저장
+ url: /events
+ method: POST
+ parameter: json

마일리지 내역을 저장합니다.

ADD: pointHist에 포인트 내역을 저장하고 보너스 포인트 부여 여부를 체크하여 bonusPointHist에 보너스 포인트 내역을 저장합니다.

그리고 점수의 합계를 point에 누적시킵니다.

MOD: pointHist에 포인트 내역을 저장하고 기존 포인트와 차이를 계산해 point에 누적시킵니다.

DELETE: 보너스 포인트가 있다면 bonusPointHist에 0으로 저장합니다.

그리고 pointHist에 포인트를 0으로 저장하고 기존에 있던 해당 리뷰의 포인트를 point에서 빼서 소멸시킵니다.

## 누적 포인트 조회
+ url: point
+ method: GET
+ parameter: userId:String

해당 유저의 누적포인트를 조회한다.

# 사용법


doc/ddl.sql의 쿼리를 사용해 테이블을 생성하고 url에 요청을 보낸다
