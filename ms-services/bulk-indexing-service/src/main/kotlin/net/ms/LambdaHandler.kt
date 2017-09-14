package net.ms

import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import org.slf4j.LoggerFactory


class LambdaHandler : RequestHandler<AwsProxyRequest, AwsProxyResponse> {
    private var handler: SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>? = null
    private val log = LoggerFactory.getLogger(LambdaHandler::class.java)

    override fun handleRequest(awsProxyRequest: AwsProxyRequest, context: Context): AwsProxyResponse? {
        if (handler == null) {
            try {
                handler = SpringLambdaContainerHandler.getAwsProxyHandler(BulkIndexingApplication::class.java)
            } catch (e: ContainerInitializationException) {
                log.error("Cannot initialize spring handler", e)
                return null
            }

        }
        return handler!!.proxy(awsProxyRequest, context)
    }
}
