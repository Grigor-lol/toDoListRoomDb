package com.example.todolist.db

import androidx.room.*
import com.example.todolist.model.TaskModel


@Dao
interface TaskDao {
    @Query("SELECT * FROM taskModel")
    fun getAll(): List<TaskModel>

    @Query("SELECT * FROM taskModel WHERE uid IN (:taskIds)")
    fun loadAllByIds(taskIds: IntArray): List<TaskModel>

    @Update
    fun updateTask(task: TaskModel)

    @Insert
    fun insert(task: TaskModel): Long

    @Delete
    fun delete(task: TaskModel)
}

@Database(entities = [TaskModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}