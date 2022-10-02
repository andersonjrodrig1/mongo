package com.example.common

import org.bson.types.ObjectId
import java.time.LocalDateTime
import java.util.Random

fun generateObjectIdString() = ObjectId.get().toString()

fun generateObjectId(): ObjectId = ObjectId.get()

fun generateDateTimeString() = LocalDateTime.now().toString()

fun generateCodeString() = Random().nextInt(1, 999).toString()

fun generateName(lenght: Int): String {
    var text: String = ""

    for (i in 1..lenght)
        text += ('a'..'z').random()

    return text
}