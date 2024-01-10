package com.vernet.gestion

import com.vernet.modele.Valeurs

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
}