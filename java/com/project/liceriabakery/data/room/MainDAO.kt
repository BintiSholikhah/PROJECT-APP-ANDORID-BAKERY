package com.project.liceriabakery.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.liceriabakery.data.entity.MainEntity

@Dao
interface  MainDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(data: List<MainEntity>)

    @Query("SELECT * FROM bakery")
    fun getData(): LiveData<List<MainEntity>>
}