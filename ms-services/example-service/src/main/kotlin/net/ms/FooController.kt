package net.ms

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc

/**
 * Example of a controller which can be deployed as Lambda function
 *
 * Important!!! :
 *
 * You can't map methods on "" (empty) or "/" (root) http URIs,
 * because of the 'API Gateway' mapping looks like this: '/foo/{+proxy}'.
 *
 * this means - this lambda will be invoked only for the following requests: '/foo/...',
 * so your '/foo' or '/foo/' request will not be transferred by API Gateway to this controller.
 *
 */
@RestController
@EnableWebMvc
@RequestMapping("/foo")
class FooController {


    @GetMapping("/list")
    fun fooList() = foos

    @GetMapping("/{id}")
    fun fooList(@PathVariable id: String) = foos.first { it["id"] == id }

    private val foos: Array<Map<String,String>> = arrayOf(
            mapOf("id" to "1", "name" to "foo-1"),
            mapOf("id" to "2", "name" to "foo-2"),
            mapOf("id" to "3", "name" to "foo-3")
    )

}