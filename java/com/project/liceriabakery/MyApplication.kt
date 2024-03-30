package com.project.liceriabakery

import android.app.Application
import com.project.liceriabakery.data.MainRepository
import com.project.liceriabakery.data.room.MainDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication: Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { MainDatabase.getInstance(this, applicationScope) }
    val repository by lazy { MainRepository(database.mainDao()) }

}