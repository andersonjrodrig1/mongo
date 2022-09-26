package com.example.ports.repository

import com.example.domain.entities.Book
import io.micronaut.context.annotation.Executable
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository
import org.bson.types.ObjectId
import org.reactivestreams.Publisher

@MongoRepository
interface BookRepository: ReactiveStreamsCrudRepository<Book, ObjectId> {

    @Executable
    fun find(name: String): Publisher<Book>

}