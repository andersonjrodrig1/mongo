package com.example.ports.usecases

import com.example.adapter.dto.BookDto
import com.example.domain.entities.Book
import jakarta.inject.Singleton

@Singleton
interface BookUseCases {

    fun save(book: Book): BookDto?

    fun findAll(): List<BookDto>

    fun findById(id: String): BookDto?

    fun findByName(name: String): BookDto?

    fun update(book: Book): BookDto

    fun delete(id: String)

}