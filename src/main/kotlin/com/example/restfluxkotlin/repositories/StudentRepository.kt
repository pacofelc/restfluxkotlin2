package com.example.restfluxkotlin.repositories

import com.example.restfluxkotlin.data.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux


interface StudentRepository : ReactiveCrudRepository<Student, String> {
    fun findByName(name:String): Flux<Student>
    //fun findByIdent( id:String): Flux<Student>
    //fun save ( new: Student): Student
}
