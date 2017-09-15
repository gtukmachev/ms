package net.ms

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

// Spring Configuration class - required for Lambda as point of Spring-context initiation
@Configuration
@ComponentScan("net.ms")
open class ExampleServiceConfiguration

// Lambda function
class BarLambda : SpringLambdaTemplate( ExampleServiceConfiguration::class.java )
class FooLambda : SpringLambdaTemplate( ExampleServiceConfiguration::class.java )