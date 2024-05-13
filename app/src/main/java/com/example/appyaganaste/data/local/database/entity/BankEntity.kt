package com.example.appyaganaste.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appyaganaste.domain.model.Bank

@Entity(tableName = "favorite_banks")
data class BankEntity(
    @PrimaryKey val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "age") val age : Int,
    @ColumnInfo(name = "url") val url : String
){
    fun toBank() : Bank = Bank(name, age, description, url,true)
}