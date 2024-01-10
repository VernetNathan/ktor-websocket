package com.vernet.gestion

import java.sql.Connection
import java.sql.DriverManager

class Connexion(ip:String, username:String, password:String) {
    lateinit var conn:Connection
    private val ip = ip
    private val username = username
    private val password = password
    init {
         conn = DriverManager.getConnection(ip, username, password)
    }
    fun getConnexion():Connection{
        return conn
    }
}