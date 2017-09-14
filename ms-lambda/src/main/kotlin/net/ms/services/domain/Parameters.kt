package net.ms.services.domain

data class MyLambdaParameters(var name: String) {
    constructor(): this("")
}

data class MyLambdaResponse (val value: String)