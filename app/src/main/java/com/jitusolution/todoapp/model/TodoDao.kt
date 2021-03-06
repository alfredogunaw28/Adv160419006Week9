package com.jitusolution.todoapp.model

import androidx.room.*

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg todo:Todo)

    @Query("SELECT * FROM todo")
    suspend fun selectAllTodo(): List<Todo>

    @Query("SELECT * FROM todo ORDER BY priority DESC")
    suspend fun selectTodo(): List<Todo>

    @Query("UPDATE todo SET title=:title, notes=:notes, priority=:priority WHERE uuid = :id")
    suspend fun update(title:String, notes:String, priority:Int, id:Int)
    @Delete
    suspend fun deleteTodo(todo:Todo)
}