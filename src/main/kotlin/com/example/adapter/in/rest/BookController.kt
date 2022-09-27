package com.example.adapter.`in`.rest

import com.example.adapter.dto.BookDto
import com.example.adapter.`in`.mapper.toEntity
import com.example.common.extensions.httpResponse
import com.example.ports.usecases.BookUseCases
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import javax.validation.Valid

@Controller("/book")
open class BookController(
    private val bookUseCases: BookUseCases
) {

    @Post
    open fun save(
        @Valid @Body bookDto: BookDto
    ): HttpResponse<*> = HttpResponse.created(bookUseCases.save(bookDto.toEntity()))

    @Get
    open fun findAll(): HttpResponse<*> = bookUseCases.findAll().httpResponse()

    @Get("/{id}")
    open fun findById(
        @PathVariable id: String
    ): HttpResponse<*> = httpResponse(id, bookUseCases::findById)

}