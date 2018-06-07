package com.example.restfluxkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories

@SpringBootApplication
@EnableReactiveMongoRepositories
class RestfluxkotlinApplication

fun main(args: Array<String>) {
    runApplication<RestfluxkotlinApplication>(*args)
}
