# ๐ To-Do-List
![language](https://img.shields.io/badge/language-Kotlin-9cf)
![์ํคํ์ณ](https://img.shields.io/badge/%EC%95%84%ED%82%A4%ED%85%8D%EC%B3%90-mvvm-6054d1)
![network](https://img.shields.io/badge/network-Retrofit2-yellow)
![database](https://img.shields.io/badge/database-Room-d9fff8)
## ํ  ์ผ์ ์ ์ด ๊ด๋ฆฌํ๋ To-Do List ์ดํ๋ฆฌ์ผ์ด์

### โ ๊ธฐ๋ฅ
--------------------------------------
- ์ฌ์ฉ์์ ํ  ์ผ ์ ๋ณด๋ฅผ Room์ ์ด์ฉํด Database์ ์ ์ฅ
- CRUD ๊ตฌํ - ์ฌ์ฉ์๊ฐ ํ  ์ผ์ ์ถ๊ฐ, ์์ , ์กฐํ, ์ญ์  ๊ฐ๋ฅ
  1. ํ  ์ผ ์ถ๊ฐ
   
     ![์ถ๊ฐ](https://user-images.githubusercontent.com/57751515/116553645-4fac8800-a935-11eb-9462-01ee0a410e04.gif)   
   
  2. ํ  ์ผ ์์ 

     <img src="https://user-images.githubusercontent.com/57751515/116553640-4e7b5b00-a935-11eb-8400-c743d1bd520a.gif" width="263dp">

     +) ํ ์ผ ์๋ฃ ์ db table๋ด์ isCompleted๊ฐ 1๋ก ๋ฐ๋

     <img src="https://user-images.githubusercontent.com/57751515/120897415-00a6f080-c661-11eb-96e8-2681c6f0ad05.jpg" width="263dp">

     ![image](https://user-images.githubusercontent.com/57751515/120897497-757a2a80-c661-11eb-8d97-e6f0537e8042.png)

  3. ํ  ์ผ ๊ฒ์
   
     ![๊ฒ์](https://user-images.githubusercontent.com/57751515/116553624-4cb19780-a935-11eb-8461-d66f3eb5c27c.gif)

  4. ํ  ์ผ ์ญ์ 
   
      ![์ญ์ ](https://user-images.githubusercontent.com/57751515/116553635-4de2c480-a935-11eb-8fce-2764aeddf6fb.gif)

- MVVM ์ํคํ์ฒ๋ก LiveData๋ฅผ ์ด์ฉํด ๋ณ๊ฒฝ ์ฌํญ์ด ์๊ธธ ์ ViewModel ๋ณ์ ๊ฐ์ ๋ณํ์ํค๊ณ , ๊ทธ ๋ณ์๋ฅผ view์์ observeํ๋ ๋ฐฉ์์ผ๋ก ๋์
  
  ![mvvm](https://user-images.githubusercontent.com/57751515/116552853-76b68a00-a934-11eb-943a-80d7c3948345.png)


### ๐ถ ๊ธฐ์ 
--------------------------------------
- `Android Studio`
- ์ฌ์ฉ ์ธ์ด : `Kotlin`
- ๋ฐ์ดํฐ๋ฒ ์ด์ค : `Room`

### ๐ง App Version
--------------------------------------
targetSdkVersion 30 / minSdkVersion 19

 ### ๐ ํ๋ก์ ํธ ๊ตฌ์กฐ
--------------------------------------
```
todolist/
โโ model/
โ  โโ AppDatabase.kt : ํ  ์ผ์ ์ ์ฅํ  Room Database ์์ฑ
โ  โโ Todo.kt : Room Database ๊ฐ์ฒด ๋ด์ ํ์ด๋ธ ์์ฑ
โ  โโ TodoDao.kt : Data Access Object
โโ view/
โ  โโ adapter/
โ  โ   โโ TodoAdapter.kt : recyclerview๋ฅผ ์ํ adapter
โ  โโ EditActivity.kt : ํ  ์ผ ์์  UI ๊ด๋ จ ์กํฐ๋นํฐ
โ  โโ MainActivity.kt : ํ  ์ผ ๋ฆฌ์คํธ UI ๊ด๋ จ ์กํฐ๋นํฐ
โโ viewmodel/
   โโ TodoViewModel.kt : ๋ทฐ์ ๋ชจ๋ธ ์ฌ์ด์ ์ธํฐํ์ด์ค
```
