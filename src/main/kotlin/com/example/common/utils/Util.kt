package com.example.common.utils

import com.example.domain.abstracts.IEntity
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("UtilKt")!!

internal inline fun <T: IEntity<String>?> runCathingEntity(block: () -> T): T =
    runCatching {
        block()
    }.onSuccess {
        logger.info("Execution Sucess")
    }.getOrThrow()

internal inline fun <T: List<IEntity<String>>> runCathingList(block: () -> T): T =
    runCatching {
        block()
    }.onSuccess {
        logger.info("Execution Sucess")
    }.getOrThrow()