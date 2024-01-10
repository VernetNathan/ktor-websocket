package com.vernet.modeles

import kotlinx.serialization.Serializable

data class Temp(
    @Serializable
    var id : Int,
    var horodatage : String,
    var temp: Float
)
