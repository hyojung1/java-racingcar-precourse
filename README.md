# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

-----------------------------------------------

##기능목록

* 게임 시작을 위해, 참가한 자동차명과 시도횟수 입력받기
   * 자동차명 유효성검사
     * 자동차명은 ,를 기준으로 구분
     * 자동차명의 길이는 5자 이하
   * 시도횟수 유효성검사
     * 숫자만 입력했는지
   * 유효성에 어긋난 경우 Error메세지 출력 및 재입력받기


* 게임 규칙 구현하기
  * 횟수만큼 반복
  * 자동차마다 0-9사이의 random 수 배정
  * 결과가 3이상일 때 1보 전진가능
  * 자동차의 현재 상태 출력


* 게임 결과 출력하기
  * 가장 많이 전진한 자동차가 우승이며, 우승자가 한명 이상이면 콤마구분자로 이름 구분하여 출력
