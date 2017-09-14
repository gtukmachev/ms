package net.ms

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@RestController
@EnableWebMvc
class BulkIndexingController {

    @RequestMapping(path = arrayOf("/bulk-indexing/check"), method = arrayOf(RequestMethod.POST))
    fun check(@RequestBody response: CheckResponse): CheckResult {
        return CheckResult("fail", listOf(
                Msg(l = "inf", obj = response.s3BucketURL, msg = "The bucket do not exists / or access for the bucket wasn't provided."),
                Msg(l = "wrn", obj = "file",               msg = "Cannot be read."),
                Msg(l = "err", obj = "metadata-file",      msg = "Wrong format.")
        ))
    }

    @RequestMapping(path = arrayOf("/bulk-indexing/start"), method = arrayOf(RequestMethod.POST))
    fun start(@RequestBody response: CheckResponse): CheckResult {
        return CheckResult("ok", listOf(
                Msg(l = "inf", obj = "All checks passed", msg = "ready to start.")
        ))
    }

}



data class CheckResult (val status: String, val messages: List<Msg>)
data class Msg(val l: String, val obj: String, val msg: String)

class CheckResponse(var s3BucketURL: String) {
    constructor(): this("")
}
