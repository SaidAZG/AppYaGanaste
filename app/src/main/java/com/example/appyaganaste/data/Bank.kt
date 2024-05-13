package com.example.appyaganaste.data

import java.io.Serializable

data class Bank(
    val description: String,
    val age: Int,
    val url: String,
    val bankName: String
) : Serializable
