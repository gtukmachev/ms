package net.ms

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@RestController
@EnableWebMvc
class ExampleController {

    @RequestMapping("example/hello")
    fun returnSimpleType(): String {
        return "Hello!"
    }


    @RequestMapping(path = arrayOf("/example/{id}"), method = arrayOf(RequestMethod.GET))
    fun anPathVarParsing(@PathVariable id: String): Map<*,*> {
        return mapOf("id" to id, "name" to "ExampleController")
    }


    @RequestMapping(path = arrayOf("/example/{id1}/to/{id2}"), method = arrayOf(RequestMethod.GET))
    fun start(@PathVariable id1: String, @PathVariable id2: Int): someClassForAutoConvertToJson {
        return someClassForAutoConvertToJson(id1, id2)
    }

}

data class someClassForAutoConvertToJson(val id1: String, val id2: Int)
