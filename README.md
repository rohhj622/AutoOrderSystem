# AutoOrderSystem

> 자동으로 순서를 정해주는 프로그램입니다.
#eclipse #jsp  #mysql8.0.17 #apacheTomcat9.0.24 #spring-MVC-Modle

## 주요 기능

### 순서 정하는 기능
- 하루에 한번만 가능.
- 같은 날에 한번 더 순서정하기를 클릭 시, 별다른 순서지정없이 내역만 보여주는 기능.

### 학생 추가 기능

### 차트
- 누적된 순서를 보는 기능.
- 만약 누적 값이 가장 클 경우, 자동으로 1번이 되는 기능.

## Controller

### HomeController
- '/'
  + Main Page

### AddStudentController
- '/addStudentPage'
  + 학생 추가 페이지로 이동.
- '/addStudentProc'
  + 학생을 추가하는 과정.

### OrderingListController
- '/oredering'
  + 순서 기능
  
## Domain

### MemberVO
- 학생 정보를 담을 VO
  + no,name,address(학번,이름,github주소)
  
### OrderListVO
- 순서 정보를 담을 VO
  + idx,no,name,todayDate,orderNo(인덱스,학번,이름,순서)
  
### MemberOrderVO
- '학번'을 이용하여 join한 정보를 담을 VO
  + idx,no,name,todayDate,orderNO,address
  

  
