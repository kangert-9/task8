package com.example.task3.data.bd

import androidx.room.*

@Dao
interface HistoryDao {
    @Query("SELECT * FROM HistoryEntity")
    suspend fun all(): List<HistoryEntity>
    @Query("SELECT * FROM HistoryEntity WHERE word LIKE :word")
    suspend fun getDataByWord(word: String): List<HistoryEntity>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: HistoryEntity)
}