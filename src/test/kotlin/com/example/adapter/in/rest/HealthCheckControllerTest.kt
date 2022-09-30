package com.example.adapter.`in`.rest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
class HealthCheckControllerTest(
    @Client("/health") private val httpClient: HttpClient
): StringSpec ({

    "should be return status code 200 and text ok" {

        val httpRequest = HttpRequest.GET<String>("/")
        val response = httpClient.toBlocking().exchange(
            httpRequest, String::class.java
        )

        response.status shouldBe HttpStatus.OK
        response.body() shouldBe "ok"

    }

})