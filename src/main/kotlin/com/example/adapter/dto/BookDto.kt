package com.example.adapter.dto

import com.example.domain.abstracts.IEntity
import io.micronaut.core.annotation.Introspected

@Introspected
data class BookDto(

    override val id: String,
    val code: String,
    val name: String,
    val launch_date: String? = null,
    val author: AuthorDto

): IEntity<String>
