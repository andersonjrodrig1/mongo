package com.example.adapter.`in`.rest

import com.example.common.extensions.httpResponse
import com.example.domain.entities.Book
import com.example.ports.usecases.BookUseCases
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import javax.validation.Valid

@Controller("/book")
open class BookController(
    private val bookUseCases: BookUseCases
) {

    @Post
    open fun save(@Valid @Body book: Book): HttpResponse<*> = HttpResponse.created(bookUseCases.save(book))

    @Get
    open fun findAll(): HttpResponse<*> = bookUseCases.findAll().httpResponse()

}