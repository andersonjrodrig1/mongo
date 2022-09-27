package com.example.domain.services

import com.example.adapter.dto.BookDto
import com.example.adapter.out.mapper.toDto
import com.example.common.utils.runCathing
import com.example.common.utils.runCathingList
import com.example.domain.entities.Book
import com.example.ports.repository.BookRepository
import com.example.ports.usecases.BookUseCases
import jakarta.inject.Singleton
import org.bson.types.ObjectId
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Singleton
open class BookService(
    private val bookRepository: BookRepository
): BookUseCases {

    override fun save(book: Book): BookDto? = runCathing {
        Mono.from(bookRepository.save(book))
            .block()
            .toDto()
    }

    override fun findAll(): List<BookDto> = runCathingList {
        Flux.from(bookRepository.findAll())
            .collectList()
            .block()
            .toDto()
    }

    override fun findById(id: String): BookDto? = runCathing {
        val idObj = ObjectId(id)

        Mono.from(bookRepository.findById(idObj))
            .block()
            .toDto()
    }

}