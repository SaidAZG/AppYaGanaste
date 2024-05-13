package com.example.appyaganaste.domain.model

import com.example.appyaganaste.data.local.database.entity.BankEntity
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
