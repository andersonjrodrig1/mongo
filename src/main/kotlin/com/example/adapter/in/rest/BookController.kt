package com.example.adapter.`in`.rest

import com.example.adapter.dto.BookDto
import com.example.adapter.`in`.mapper.toEntity
import com.example.common.extensions.httpResponse
import com.example.ports.usecases.BookUseCases
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
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

    @Get("/name/{name}")
    open fun findByName(
        @PathVariable name: String
    ): HttpResponse<*> = httpResponse(name, bookUseCases::findByName)

    @Get("/author/code/{code}/name/{name}")
    open fun findBooksByAuthor(
        @PathVariable code: String,
        @PathVariable name: String
    ): HttpResponse<*> = bookUseCases.findByAuthor(code, name).httpResponse()

    @Put
    open fun update(
        @Valid @Body bookDto: BookDto
    ): HttpResponse<*> = HttpResponse.ok(bookUseCases.update(bookDto.toEntity()))

    @Delete("/{id}")
    open fun delete(
        @PathVariable id: String
    ): HttpResponse<*> = HttpResponse.ok(bookUseCases.delete(id))

}