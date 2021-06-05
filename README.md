# 📝 To-Do-List
![language](https://img.shields.io/badge/language-Kotlin-9cf)
![아키텍쳐](https://img.shields.io/badge/%EC%95%84%ED%82%A4%ED%85%8D%EC%B3%90-mvvm-6054d1)
![network](https://img.shields.io/badge/network-Retrofit2-yellow)
![database](https://img.shields.io/badge/database-Room-d9fff8)
## 할 일을 적어 관리하는 To-Do List 어플리케이션

### ✅ 기능
--------------------------------------
- 사용자의 할 일 정보를 Room을 이용해 Database에 저장
- CRUD 구현 - 사용자가 할 일을 추가, 수정, 조회, 삭제 가능
  1. 할 일 추가
   
     ![추가](https://user-images.githubusercontent.com/57751515/116553645-4fac8800-a935-11eb-9462-01ee0a410e04.gif)   
   
  2. 할 일 수정

     <img src="https://user-images.githubusercontent.com/57751515/116553640-4e7b5b00-a935-11eb-8400-c743d1bd520a.gif" width="263dp">

     +) 할일 완료 시 db table내의 isCompleted가 1로 바뀜

     <img src="https://user-images.githubusercontent.com/57751515/120897415-00a6f080-c661-11eb-96e8-2681c6f0ad05.jpg" width="263dp">

     ![image](https://user-images.githubusercontent.com/57751515/120897497-757a2a80-c661-11eb-8d97-e6f0537e8042.png)

  3. 할 일 검색
   
     ![검색](https://user-images.githubusercontent.com/57751515/116553624-4cb19780-a935-11eb-8461-d66f3eb5c27c.gif)

  4. 할 일 삭제
   
      ![삭제](https://user-images.githubusercontent.com/57751515/116553635-4de2c480-a935-11eb-8fce-2764aeddf6fb.gif)

- MVVM 아키텍처로 LiveData를 이용해 변경 사항이 생길 시 ViewModel 변수 값을 변화시키고, 그 변수를 view에서 observe하는 방식으로 동작
  
  ![mvvm](https://user-images.githubusercontent.com/57751515/116552853-76b68a00-a934-11eb-943a-80d7c3948345.png)


### 🛶 기술
--------------------------------------
- `Android Studio`
- 사용 언어 : `Kotlin`
- 데이터베이스 : `Room`

 ### 📁 프로젝트 구조
--------------------------------------
```
todolist/
├─ model/
│  ├─ AppDatabase.kt : 할 일을 저장할 Room Database 생성
│  ├─ Todo.kt : Room Database 객체 내에 테이블 생성
│  └─ TodoDao.kt : Data Access Object
├─ view/
│  ├─ adapter/
│  │   └─ TodoAdapter.kt : recyclerview를 위한 adapter
│  ├─ EditActivity.kt : 할 일 수정 UI 관련 액티비티
│  └─ MainActivity.kt : 할 일 리스트 UI 관련 액티비티
└─ viewmodel/
   └─ TodoViewModel.kt : 뷰와 모델 사이의 인터페이스
```