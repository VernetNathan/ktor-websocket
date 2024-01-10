package com.vernet.modele

import kotlinx.serialization.Serializable

@Serializable
data class Valeurs(
    var id : Int ?= null,
    var valeur1 : Int ?= null,
    var valeur2: Int ?= null
)
