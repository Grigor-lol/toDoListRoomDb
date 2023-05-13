package com.example.todolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TaskModel(@ColumnInfo(name = "text_of_task") var textOfTask: String,
                @ColumnInfo(name = "is_checked") var isChecked: Int){
                @PrimaryKey(autoGenerate = true) var uid: Long = 0
}
