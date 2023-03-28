package br.senai.sp.jandira.loginapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//anotacao para ele refatorar o nome da tabela para o que eu quero!
// anotacoes podem ser escritas imediatamente acima ou do lado
@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "user_name")  var userName: String = " ",
    var email: String = " ",
    var password: String = " ",
    var phone: String = " ",
   @ColumnInfo(name = "is_over_18") var isOver18: Boolean = false
)
