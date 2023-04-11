package br.senai.sp.jandira.loginapp.repository

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Email
import br.senai.sp.jandira.loginapp.dao.TripDb
import br.senai.sp.jandira.loginapp.model.User

class UserRepository(context: Context) {

    //Variavel que representa nosso banco de dados
    //recebi contexto e passo para o proximo - ingessao de dependencia
    private val db = TripDb.getDataBase(context)


   //responsavel por encontrar um usuario no banco
    fun save(user: User): Long {
        return db.userDao().save(user)
    }

    //responsavel pela autenticacao do usuario
    fun authenticate(email: String, password: String): User {
        return db.userDao().authenticate(email, password)
    }

    //reponsavel por encontrar um usuario por email
    fun finUserByEmail(email: String): User{
        return db.userDao().findUserByEmail(email)
    }
}