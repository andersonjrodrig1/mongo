package com.example.domain.services

import com.example.adapter.`in`.mapper.toEntity
import com.example.adapter.out.mapper.toDto
import com.example.common.getBookDto
import com.example.common.getBooksDtoList
import com.example.common.getBooksList
import com.example.common.getObjectIdString
import com.example.domain.entities.Book
import com.example.ports.repository.BookRepository
import com.example.ports.usecases.BookUseCases
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.MicronautKotestExtension.getMock
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@MicronautTest
class BookServiceTest(
    private val bookUseCases: BookUseCases,
    private val bookRepository: BookRepository
): FunSpec({

    test("should be return book with save") {

        val mockBookRepository = getMock(bookRepository)
        val book = getBookDto().toEntity()

        every {
            mockBookRepository.save(any())
        } answers {
            Mono.just(book)
        }

        val response = bookUseCases.save(book)

        response shouldBe book.toDto()

    }

    test("should be return list book with findAll") {

        val mockBookRepository = getMock(bookRepository)
        val books = getBooksList()

        every {
            mockBookRepository.findAll()
        } answers {
            Flux.fromIterable(books)
        }

        val response = bookUseCases.findAll()

        response shouldBe books.toDto()

    }

    test("should be return book with findById") {

        val mockBookRepository = getMock(bookRepository)
        val book = getBookDto().toEntity()

        every {
            mockBookRepository.findById(any())
        } answers {
            Mono.just(book)
        }

        val response = bookUseCases.findById(getObjectIdString())

        response shouldBe book.toDto()

    }

    test("should be return book with findByName") {

        val mockBookRepository = getMock(bookRepository)
        val book = getBookDto().toEntity()

        every {
            mockBookRepository.find(any())
        } answers {
            Mono.just(book)
        }

        val response = bookUseCases.findByName("name test")

        response shouldBe book.toDto()

    }

    test("should be return book with findByAuthor") {

        val mockBookRepository = getMock(bookRepository)
        val books = getBooksList()

        every {
            mockBookRepository.findByAuthor(any())
        } answers {
            Flux.fromIterable(books)
        }

        val response = bookUseCases.findByAuthor("111","name test")

        response shouldBe books.toDto()

    }

    test("should be return book with update") {

        val mockBookRepository = getMock(bookRepository)
        val book = getBookDto().toEntity()

        every {
            mockBookRepository.update(any())
        } answers {
            Mono.just(book)
        }

        val response = bookUseCases.update(book)

        response shouldBe book.toDto()

    }

    test("should be unit with delete") {

        val mockBookRepository = getMock(bookRepository)

        every {
            mockBookRepository.delete(any())
        } answers {
            Mono.just(0)
        }

        bookUseCases.delete(getObjectIdString())

        assert(true)

    }

}) {
    @MockBean(BookRepository::class)
    fun bookRepository(): BookRepository = mockk()
}