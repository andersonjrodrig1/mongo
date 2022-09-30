package com.example.adapter.`in`.rest

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/health")
open class HealthCheckController {

    @Get
    open fun getHealthCheck(): MutableHttpResponse<*> = HttpResponse.ok("ok")

}