package com.example.adapter.`in`.rest

import com.example.adapter.dto.BookDto
import com.example.common.*
import com.example.ports.usecases.BookUseCases
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.MicronautKotestExtension.getMock
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import jakarta.inject.Inject
import kotlin.time.Duration.Companion.seconds

@MicronautTest
class BookControllerTest(
    @Client("/book") private val httpClient: HttpClient,
    @Inject val bookUseCases: BookUseCases
): FunSpec({

    test("should be return status code 202 and object book with save").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val bookDto = getBookDto()

        every {
            mockBookUseCases.save(any())
        } answers {
            bookDto
        }

        val httpRequest = HttpRequest.POST("/", bookDto)
        val response = httpClient.toBlocking().exchange(
            httpRequest, BookDto::class.java
        )

        verify (exactly = 1) {
            mockBookUseCases.save(any())
        }

        response.status shouldBe HttpStatus.CREATED
        response.body() shouldBe bookDto

    }

    test("should be return status code 200 and list books with findAll").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val listBooks = getBooksDtoList()

        every {
            mockBookUseCases.findAll()
        } answers {
            listBooks
        }

        val httpRequest = HttpRequest.GET<String>("/")
        val response = httpClient.toBlocking().exchange(
            httpRequest, Argument.listOf(BookDto::class.java)
        )

        response.status shouldBe HttpStatus.OK
        response.body() shouldBe listBooks

    }

    test("should be return status code 204 and list empty with findAll").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val listEmpty = getBooksDtoEmpty()

        every {
            mockBookUseCases.findAll()
        } answers {
            listEmpty
        }

        val httpRequest = HttpRequest.GET<String>("/")
        val response = httpClient.toBlocking().exchange(
            httpRequest, Argument.listOf(BookDto::class.java)
        )

        response.status shouldBe HttpStatus.NO_CONTENT
        response.body() shouldBe null

    }

    test("should be return status code 200 and object book with findById").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val book = getBookDto()

        every {
            mockBookUseCases.findById(any())
        } answers {
            book
        }

        val httpRequest = HttpRequest.GET<String>("/${book.id}")
        val response = httpClient.toBlocking().exchange(
            httpRequest, BookDto::class.java
        )

        verify (exactly = 1) {
            mockBookUseCases.findById(any())
        }

        response.status shouldBe HttpStatus.OK
        response.body() shouldBe book

    }

    test("should be return status code 204 and object null with findById").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val book = getBookDtoNullable()
        val id = getObjectIdString()

        every {
            mockBookUseCases.findById(any())
        } answers {
            book
        }

        val httpRequest = HttpRequest.GET<String>("/$id")
        val response = httpClient.toBlocking().exchange(
            httpRequest, BookDto::class.java
        )

        verify (exactly = 1) {
            mockBookUseCases.findById(any())
        }

        response.status shouldBe HttpStatus.NO_CONTENT
        response.body() shouldBe null

    }

    test("should be return status code 200 and object book with findByName").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val book = getBookDto()

        every {
            mockBookUseCases.findByName(any())
        } answers {
            book
        }

        val httpRequest = HttpRequest.GET<String>("/name/test")
        val response = httpClient.toBlocking().exchange(
            httpRequest, BookDto::class.java
        )

        verify (exactly = 1) {
            mockBookUseCases.findByName(any())
        }

        response.status shouldBe HttpStatus.OK
        response.body() shouldBe book

    }

    test("should be return status code 204 and null with findByName").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val book = getBookDtoNullable()

        every {
            mockBookUseCases.findByName(any())
        } answers {
            book
        }

        val httpRequest = HttpRequest.GET<String>("/name/test")
        val response = httpClient.toBlocking().exchange(
            httpRequest, BookDto::class.java
        )

        verify (exactly = 1) {
            mockBookUseCases.findByName(any())
        }

        response.status shouldBe HttpStatus.NO_CONTENT
        response.body() shouldBe null

    }

    test("should be return status code 200 and list book with findBooksByAuthor").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val books = getBooksDtoList()

        every {
            mockBookUseCases.findByAuthor(any(), any())
        } answers {
            books
        }

        val httpRequest = HttpRequest.GET<String>("/author/code/111/name/test")
        val response = httpClient.toBlocking().exchange(
            httpRequest, Argument.listOf(BookDto::class.java)
        )

        response.status shouldBe HttpStatus.OK
        response.body() shouldBe books

    }

    test("should be return status code 204 and null with findBooksByAuthor").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val books = getBooksDtoEmpty()

        every {
            mockBookUseCases.findByAuthor(any(), any())
        } answers {
            books
        }

        val httpRequest = HttpRequest.GET<String>("/author/code/111/name/test")
        val response = httpClient.toBlocking().exchange(
            httpRequest, Argument.listOf(BookDto::class.java)
        )

        response.status shouldBe HttpStatus.NO_CONTENT
        response.body() shouldBe null

    }

    test("should be status code 200 and object book with update").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val book = getBookDto()

        every {
            mockBookUseCases.update(any())
        } answers {
            book
        }

        val httpRequest = HttpRequest.PUT("/", book)
        val response = httpClient.toBlocking().exchange(
            httpRequest, BookDto::class.java
        )

        verify (exactly = 1) {
            mockBookUseCases.update(any())
        }

        response.status shouldBe HttpStatus.OK
        response.body() shouldBe book

    }

    test("should be status code 200 with delete").config(timeout = 10.seconds) {

        val mockBookUseCases = getMock(bookUseCases)
        val id = getObjectIdString()

        every {
            mockBookUseCases.delete(any())
        } returns(Unit)

        val httpRequest = HttpRequest.DELETE<Boolean>("/${id}")
        val response = httpClient.toBlocking().exchange(
            httpRequest, Unit::class.java
        )

        verify (exactly = 1) {
            mockBookUseCases.delete(any())
        }

        response.status shouldBe HttpStatus.OK

    }

}) {
    @MockBean(BookUseCases::class)
    fun bookUseCases(): BookUseCases = mockk()
}