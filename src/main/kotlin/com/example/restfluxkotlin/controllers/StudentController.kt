package com.example.restfluxkotlin.controllers

import com.example.restfluxkotlin.data.Student
import com.example.restfluxkotlin.repositories.StudentRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class StudentController (
        val repository: StudentRepository
) {
    @GetMapping("/dummy-student")
    fun students(@RequestParam name:String): Student {
        val student = Student("1", name)
        return student

    }

    @GetMapping("/students")
    fun  students(): Flux<Student> {
        return repository.findAll()
    }


    @GetMapping("/student/name")
    fun studentByName(@RequestParam name:String) = repository.findByName(name)


    @GetMapping("/student/new")
    fun students(@RequestParam id:String, @RequestParam name:String): Mono<Student> {

        println ( "----- id $id y name $name")

        val student = Student(id, name)

        println ("----- Creado ${student.id} ${student.name}")

        return repository.save( student )
    }



}