package com.vama.network

object NetworkManagerConfigurations {
    lateinit var configuration: NetworkConfiguration
    fun setUp(networkConfiguration: NetworkConfiguration){
        this.configuration = networkConfiguration
    }
}