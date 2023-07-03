# MBTI
MBTI 특징 공유 서비스 (멋쟁이사자처럼)

## Server
2023.06.28~ 2023.07.03 : spring으로 서버 개발 (이현정)

### API 명세서

|method|url|기능|request|success response|fail response|
|---|---|---|---|---|---|
|get|/mbti/{type}|MBTI 정보 조회|-|{"status": 200,"message": "Success","mbti": "ENTP","info": "사교적","count": 1}|{"status": 404, "message": "MBTI Type Not Found"}|
|post|/mbti|MBTI 특징 저장|{"MBTI”: “ENTJ”, “info”: “특징”}|{"status": 200, "message": "Success"} <br> <br> {"status": 201,"message": "MBTI Tendency Not Found","mbti": "ISFP"}|{ "status": 404,"message": "MBTI Type Not Found"}|
|get|/mbti/all|모든 MBTI 특징 조회|-|{"status": 200,"message": "Success", <br> "data": [{"id": 1,"mbti": "ENTP","info": "사교적","count": 0}] <br> }|{ "status": 404,"message": "MBTI Type Not Found"}|

통신 : @CrossOrigin 이용
