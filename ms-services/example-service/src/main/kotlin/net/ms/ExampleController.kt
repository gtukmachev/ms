package net.ms

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/example")
class ExampleController {

    @RequestMapping("/hello")
    fun sayHello(): String {
        return "Hello!"
    }

}