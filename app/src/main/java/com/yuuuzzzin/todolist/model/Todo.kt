package com.yuuuzzzin.todolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Todo(var text: String?, var isCompleted: Boolean = false) : Serializable {
    // 1. 엔티티 클래스 생성
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
