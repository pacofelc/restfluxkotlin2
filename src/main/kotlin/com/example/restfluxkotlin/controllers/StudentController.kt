package com.example.restfluxkotlin.controllers

import com.example.restfluxkotlin.data.Student
import com.example.restfluxkotlin.repositories.StudentRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

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

    @GetMapping("/student/id")
    fun studentById(@RequestParam id:String) = repository.findById(id)


    @GetMapping("/student/new")
    fun nuevo(@RequestParam id:String, @RequestParam name:String): Mono<Student> {

        val student = Student(id, name)
        return repository.save( student )
    }

    @GetMapping("/student/update")
    fun modificar(@RequestParam id:String, @RequestParam name:String): Mono <Student> {

        repository.findById(id).doOnSuccess {student->

            println ("----------Encontrado $student")
            val modified = student.copy(name=name)
            println ("----------Cambiado $modified")
            repository.save( modified ).subscribe( )

            // TODO NO SE COMO DEVOLVER MODIFIED==
            // TODO NO SE PORQUE HAY QUE HACER DOS SUBSCRIBE??
            //return@doOnSuccess modified
        }.subscribe( )

        return Student ("0", "desconocido").toMono()
    }


}