package com.example.adapter.`in`.mapper

import com.example.adapter.dto.BookDto
import com.example.domain.entities.Author
import com.example.domain.entities.Book
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("BookDtoInMapperKt")

fun BookDto.toEntity(): Book {
    logger.info("Execution Entity Mapper")

    return with (this) {
        Book(
            code = code,
            name = name,
            launch_date = launch_date,
            author = Author(
                code = author.code,
                name = author.name
            )
        )
    }
}