package com.project.liceriabakery.data

import androidx.lifecycle.LiveData
import com.project.liceriabakery.data.entity.MainEntity
import com.project.liceriabakery.data.room.MainDAO

class MainRepository(private val mainDAO: MainDAO) {

    fun listBakery(): LiveData<List<MainEntity>> = mainDAO.getData()
}