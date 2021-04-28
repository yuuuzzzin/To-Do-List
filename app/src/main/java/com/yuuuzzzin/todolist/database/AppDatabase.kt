package com.yuuuzzzin.todolist.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}