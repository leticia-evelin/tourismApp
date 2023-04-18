package br.senai.sp.jandira.loginapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.loginapp.model.User

// Representacao do banco de dados

@Database(entities = [User::class], version = 3)
abstract class TripDb: RoomDatabase() { // herda classe que se conecta ao banco
    //toda vez que eu precisar do banco de dados, chamar TripDb

    //interface para manipular
    abstract fun userDao(): UserDao

   companion object{
       //inicializacao tardia - criar no final
       private lateinit var instanceDb: TripDb

       fun getDataBase(context: Context): TripDb {
            if (!::instanceDb.isInitialized){
                instanceDb = Room
                    .databaseBuilder(
                        context,
                        TripDb::class.java,
                        "db_trip"
                    ).allowMainThreadQueries().fallbackToDestructiveMigration().build() //disparar a construcao do banco, guardar instacia na instaceDb
            }
                return instanceDb
            }
       }
   }
