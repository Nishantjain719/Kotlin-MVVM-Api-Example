package com.example.kotlincoroutines

import com.example.kotlincoroutines.models.User

object ExampleSingleton {

    val singletonUser: User by lazy {
        User("mitchelltabian@gmail.com", "nichinu", "image.png")
    }
}