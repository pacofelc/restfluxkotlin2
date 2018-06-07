package com.example.restfluxkotlin.data

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "students")
data class Student(val id:String, val name:String) {
}
