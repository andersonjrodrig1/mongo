package com.example.domain.entities

import io.micronaut.core.annotation.Creator
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty

@Introspected
@Serdeable
data class Author @Creator @BsonCreator constructor(

    @BsonProperty("code")
    var code: String,

    @BsonProperty("name")
    var name: String

)
