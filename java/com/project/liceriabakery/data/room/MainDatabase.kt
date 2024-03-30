package com.project.liceriabakery.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.project.liceriabakery.data.entity.MainEntity
import com.project.liceriabakery.utils.InitialData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [MainEntity::class], version = 1)
abstract class MainDatabase : RoomDatabase(){
    abstract fun mainDao(): MainDAO

    companion object{
        @Volatile
        private var instance: MainDatabase? = null

        @JvmStatic
        fun getInstance(context: Context, applicationScope: CoroutineScope): MainDatabase {
            if (instance == null){
                synchronized(MainDatabase::class.java){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDatabase::class.java, "bakery_database"
                    ).fallbackToDestructiveMigration()
                        .addCallback(object : Callback(){
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                instance?.let { database->
                                    applicationScope.launch {
                                        val mainDAO= database.mainDao()
                                        mainDAO.insertData(InitialData.listBakery())
                                    }

                                }
                            }
                        })
                        .build()
                }
            }
            return instance as MainDatabase
        }
    }

}