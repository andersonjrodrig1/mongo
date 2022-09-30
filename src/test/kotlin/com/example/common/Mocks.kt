package com.example.common

import com.example.adapter.dto.AuthorDto
import com.example.adapter.dto.BookDto

fun getBookDtoNullable() = null

fun getObjectId() = generateObjectIdString()

fun getBooksDtoEmpty() = emptyList<BookDto>()

fun getBookDto() = BookDto(
    id = getObjectId(),
    code = generateCodeString(),
    name = generateName(10),
    launch_date = generateDateTimeString(),
    author = AuthorDto(
        code = generateCodeString(),
        name = generateName(10)
    )
)

fun getBooksDto() = listOf(
    BookDto(
        id = getObjectId(),
        code = generateCodeString(),
        name = generateName(10),
        launch_date = generateDateTimeString(),
        author = AuthorDto(
            code = generateCodeString(),
            name = generateName(10)
        )
    ),
    BookDto(
        id = getObjectId(),
        code = generateCodeString(),
        name = generateName(10),
        launch_date = generateDateTimeString(),
        author = AuthorDto(
            code = generateCodeString(),
            name = generateName(10)
        )
    )
)
