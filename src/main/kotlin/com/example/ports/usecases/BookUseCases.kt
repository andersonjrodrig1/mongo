package com.example.ports.usecases

import com.example.adapter.dto.BookDto
import com.example.domain.entities.Book
import jakarta.inject.Singleton

@Singleton
interface BookUseCases {

    fun findAll(): List<BookDto>

    fun save(book: Book): BookDto?

}