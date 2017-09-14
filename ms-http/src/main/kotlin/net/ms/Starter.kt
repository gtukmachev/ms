package net.ms

import org.springframework.boot.SpringApplication

object Starter {


    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(App::class.java, *args)
    }


}

