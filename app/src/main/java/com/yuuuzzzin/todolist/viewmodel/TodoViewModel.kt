package com.yuuuzzzin.todolist.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.yuuuzzzin.todolist.model.AppDatabase
import com.yuuuzzzin.todolist.model.Todo

class TodoViewModel (application: Application) : AndroidViewModel(application){
    private val todoDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "todo")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    private val todoDao = todoDatabase.todoDao()
    private val todos = todoDao.getAll()
    val mutableLiveData = MutableLiveData<MutableList<Todo>>(todos)

    fun getAll() : MutableList<Todo> {
        return todoDao.getAll()
    }

    fun Search(text: String) : MutableList<Todo> {
        return todoDao.Search(text)
    }

    fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

    fun update(todo: Todo) {
        todoDao.update(todo)
    }

    fun delete(todo: Todo) {
        todoDao.delete(todo)
    }

    fun deleteAll(todo: Array<Todo>){
        todoDao.deleteAll(*todo)
    }
}