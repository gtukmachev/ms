package net.ms

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

// Spring Configuration class - required for Lambda as point of Spring-context initiation
@Configuration
@ComponentScan("net.ms")
open class BulkIndexingConfiguration


// Lambda function
class BulkIndexingLambda : SpringLambdaTemplate( BulkIndexingConfiguration::class.java )