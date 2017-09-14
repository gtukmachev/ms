package net.ms

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/bulk-indexing")
class BulkIndexingController {

    @RequestMapping("")
    fun status(): String {
        return "alive"
    }

    @PostMapping("/check")
    fun check(@RequestBody response: CheckResponse): CheckResult {
        return CheckResult("ok", listOf(
                Msg(l = "inf", obj = response.s3BucketURL, msg = "The bucket do not exists / or access for the bucket wasn't provided."),
                Msg(l = "wrn", obj = "file",               msg = "Cannot be read."),
                Msg(l = "err", obj = "metadata-file",      msg = "Wrong format.")
        ))
    }

}



data class CheckResult (val status: String, val messages: List<Msg>)
data class Msg(val l: String, val obj: String, val msg: String)

class CheckResponse(var s3BucketURL: String) {
    constructor(): this("")
}
