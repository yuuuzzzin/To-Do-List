# 📝 To-Do-List

## 할 일을 적어 관리하는 To-Do List 어플리케이션

<br>🛶 Tech Stack 🛶</br>

![language](https://img.shields.io/badge/language-Kotlin-9cf)
![아키텍쳐](https://img.shields.io/badge/%EC%95%84%ED%82%A4%ED%85%8D%EC%B3%90-mvvm-6054d1)
![network](https://img.shields.io/badge/network-Retrofit2-yellow)
![database](https://img.shields.io/badge/database-Room-d9fff8)

### ✏️ 기능
--------------------------------------
- CRUD 구현 - 사용자가 할 일을 추가, 수정, 조회, 삭제 가능
- 사용자의 할 일 정보를 Room을 이용해 Database에 저장
- MVVM 아키텍처로 LiveData를 이용해 변경 사항이 생길 시 ViewModel 변수 값을 변화시키고, 그 변수를 view에서 observe하는 방식으로 동작
  
  ![mvvm](https://user-images.githubusercontent.com/57751515/116552853-76b68a00-a934-11eb-943a-80d7c3948345.png)


### ✏️ 기술
--------------------------------------
- `Android Studio`
- 사용 언어 : `Kotlin`
- 데이터베이스 : `Room`

### ✏️ 실행 화면
--------------------------------------
1. 할 일 추가
   
![추가](https://user-images.githubusercontent.com/57751515/116553645-4fac8800-a935-11eb-9462-01ee0a410e04.gif)   

2. 할 일 수정

<img src="https://user-images.githubusercontent.com/57751515/116553640-4e7b5b00-a935-11eb-8400-c743d1bd520a.gif" width="265dp">

3. 할 일 검색
   
![검색](https://user-images.githubusercontent.com/57751515/116553624-4cb19780-a935-11eb-8461-d66f3eb5c27c.gif)

4. 할 일 삭제
   
![삭제](https://user-images.githubusercontent.com/57751515/116553635-4de2c480-a935-11eb-8fce-2764aeddf6fb.gif)
