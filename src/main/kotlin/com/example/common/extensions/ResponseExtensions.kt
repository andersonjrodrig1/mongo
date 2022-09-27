package com.example.common.extensions

import com.example.domain.abstracts.IEntity
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse

fun <T: List<IEntity<*>>> T.httpResponse(): MutableHttpResponse<*> =
    when {
        this.isEmpty() -> HttpResponse.noContent<Unit>()
        else -> HttpResponse.ok(this)
    }

fun <E, T: IEntity<*>?> httpResponse(argument: E, method: (E) -> T): MutableHttpResponse<*> {
    val response = method(argument)
    return when {
        response != null -> HttpResponse.ok(response)
        else -> HttpResponse.noContent<Unit>()
    }
}