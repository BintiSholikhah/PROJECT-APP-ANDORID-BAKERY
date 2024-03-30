package com.project.liceriabakery.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "bakery")
data class MainEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "stock")
    var stock: String,

    @ColumnInfo(name = "harga")
    var harga: String,

    @ColumnInfo(name = "images")
    var images: String  = ""
) : Parcelable
