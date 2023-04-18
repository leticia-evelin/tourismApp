package br.senai.sp.jandira.loginapp.dao

import androidx.room.*
import br.senai.sp.jandira.loginapp.model.User


@Dao //anotar para o ROOM cuidar dela!

interface UserDao { //nao posso implementar metodos, o ROOM faz isso

    //salvar usuario
    @Insert
    fun save(user: User): Long

    //atualizar usuario
    @Update
    fun update(user: User): Int

    //deletar usuario
    @Delete
    fun delete(user: User): Int

    // autenticar
    @Query("SELECT * FROM tbl_user WHERE email = :email AND password = :password") // consulta
    fun authenticate(email: String, password: String): User

    //encontrar usuario pelo email
    @Query("SELECT * FROM tbl_user WHERE email = :email") //consulta
    fun findUserByEmail(email: String): User

    // id
//    @Query("SELECT * FROM tbl_user WHERE email = :email") //consulta
//    fun findUserByEmail(email: String): User
}