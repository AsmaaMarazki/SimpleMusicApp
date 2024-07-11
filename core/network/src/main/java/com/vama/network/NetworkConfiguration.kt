package com.vama.network

class NetworkConfiguration(
    val isDebug: Boolean,
    val baseUrl: String,
    val readTimeOut: Long = NetworkConstants.TimeOutConfigurations.DEFAULT_TIME_OUT,
    val writeTimeOut: Long = NetworkConstants.TimeOutConfigurations.WRITING_TIME_OUT
)