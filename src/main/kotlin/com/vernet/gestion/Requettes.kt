package com.vernet.gestion

import com.vernet.modeles.Temp
import com.vernet.modeles.Valeurs

class Requettes {
    var laConnexion = Connexion("jdbc:mysql://localhost/websocket", "root", "")
    fun lireLesValeurs(id: Int?): Valeurs? {
        val preparedStatement = laConnexion.getConnexion().prepareStatement("SELECT * FROM valeurs WHERE id = ?")
        preparedStatement.setString(1, id.toString())
        val rs = preparedStatement.executeQuery()
        var valeur : Valeurs ?= null
        while (rs.next()){
            valeur=
                Valeurs(rs.getInt("id"),
                    rs.getInt("valeur1"),
                    rs.getInt("valeur2"))
        }
        return valeur
    }
    fun ajouterTemp(temperature : Float) : Int{
        val preparedStatement = laConnexion.getConnexion().prepareStatement("INSERT INTO temperatures (temp) values (?)")
        preparedStatement.setString(1, temperature.toString())
        return preparedStatement.executeUpdate()
    }
    fun lireTemp(){
        //val preparedStatement = laConnexion.getConnexion().prepareStatement("SELECT ")
    }
}