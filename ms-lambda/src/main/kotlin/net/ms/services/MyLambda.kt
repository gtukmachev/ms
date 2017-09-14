package net.ms.services

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import net.ms.services.domain.MyLambdaParameters
import net.ms.services.domain.MyLambdaResponse

class MyLambda : RequestHandler<MyLambdaParameters, MyLambdaResponse> {

    var index = 0

    override fun handleRequest(event : MyLambdaParameters, context: Context): MyLambdaResponse {
        index++
        return  MyLambdaResponse("""Hello, ${event.name},
            from Kotlin Lambda function! You call me in $index time."""
        )
    }

}