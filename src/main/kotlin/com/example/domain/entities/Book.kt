package com.example.domain.entities

import com.example.domain.abstracts.IEntity
import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.SerdeImport
import io.micronaut.serde.annotation.Serdeable
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId

@Introspected
@Serdeable
@SerdeImport(Book::class)
@MappedEntity("book")
data class Book @Creator @BsonCreator constructor(

    @field:Id
    @BsonId
    @GeneratedValue
    override val id: ObjectId? = null,

    @BsonProperty("code")
    var code: String,

    @BsonProperty("name")
    var name: String,

    @BsonProperty("launch_date")
    var launch_date: String? = null,

    @BsonProperty("author")
    var author: Author

): IEntity<ObjectId>
