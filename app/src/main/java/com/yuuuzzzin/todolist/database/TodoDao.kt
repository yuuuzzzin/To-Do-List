package com.yuuuzzzin.todolist.database

import androidx.room.*


@Dao
interface TodoDao {
    // 2. Dao 인터페이스 생성

    @Query("SELECT * FROM Todo")
    fun getAll() : MutableList<Todo>

    @Insert
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Delete
    fun delete(todo: Todo?)

    @Delete
    fun deleteAll(vararg todo: Todo)
}