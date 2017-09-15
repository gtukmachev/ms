package net.ms

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@RestController
@EnableWebMvc
@RequestMapping("/bar")
class BarController {

    /**
     * simple type as result
     */
    @GetMapping("/info")
    fun returnSimpleType()
            = "Hello from Kotlin - SpringMVC @RestController deployed as lambda!"

    /**
     * 1. return json as a Map
     *
     * 2. path variables mapping
     */
    @GetMapping("/{id}")
    fun anPathVarParsing(@PathVariable id: String): Map<*,*> {
        return mapOf("id" to id, "name" to "BarController")
    }


    /**
     * 1. return json with auto-converting from a returned object
     *
     * 2. several path variables mapping + numeric variables in path
     *
     */
    @GetMapping("/{id1}/to/{id2}")
    fun start(@PathVariable id1: String, @PathVariable id2: Int)
            = someClassForAutoConvertToJson(id1, id2)

}

data class someClassForAutoConvertToJson(val id1: String, val id2: Int)
