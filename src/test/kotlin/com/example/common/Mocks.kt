package com.example.common

import com.example.adapter.dto.AuthorDto
import com.example.adapter.dto.BookDto
import com.example.domain.entities.Author
import com.example.domain.entities.Book

fun getBookDtoNullable() = null

fun getObjectIdString() = generateObjectIdString()

fun getObjectId() = generateObjectId()

fun getBooksDtoEmpty() = emptyList<BookDto>()

fun getBookDto() = BookDto(
    id = getObjectIdString(),
    code = generateCodeString(),
    name = generateName(10),
    launch_date = generateDateTimeString(),
    author = AuthorDto(
        code = generateCodeString(),
        name = generateName(10)
    )
)

fun getBooksDtoList() = listOf(
    BookDto(
        id = getObjectIdString(),
        code = generateCodeString(),
        name = generateName(10),
        launch_date = generateDateTimeString(),
        author = AuthorDto(
            code = generateCodeString(),
            name = generateName(10)
        )
    ),
    BookDto(
        id = getObjectIdString(),
        code = generateCodeString(),
        name = generateName(10),
        launch_date = generateDateTimeString(),
        author = AuthorDto(
            code = generateCodeString(),
            name = generateName(10)
        )
    )
)

fun getBooksList() = listOf(
    Book(
        id = getObjectId(),
        code = generateCodeString(),
        name = generateName(10),
        launch_date = generateDateTimeString(),
        author = Author(
            code = generateCodeString(),
            name = generateName(10)
        )
    ),
    Book(
        id = getObjectId(),
        code = generateCodeString(),
        name = generateName(10),
        launch_date = generateDateTimeString(),
        author = Author(
            code = generateCodeString(),
            name = generateName(10)
        )
    )
)
