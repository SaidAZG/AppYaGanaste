package com.example.appyaganaste.data

import com.example.appyaganaste.data.database.entity.BankEntity
import java.io.Serializable

data class Bank(
    val description: String,
    val age: Int,
    val url: String,
    val bankName: String,
    var isFavorite: Boolean = false
) : Serializable {
    fun toBankEntity() = BankEntity(bankName, description, age, url)
}
