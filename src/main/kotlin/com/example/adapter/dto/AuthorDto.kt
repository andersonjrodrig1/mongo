package com.example.adapter.dto

import io.micronaut.core.annotation.Introspected
import java.time.LocalDateTime

@Introspected
data class AuthorDto(

    val code: String,
    val name: String,

)
