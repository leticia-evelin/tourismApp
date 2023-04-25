package br.senai.sp.jandira.loginapp.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.loginapp.R
import br.senai.sp.jandira.loginapp.model.Category

class CategoryRepository {

    //tudo estatico
    companion object{
        @Composable
        fun getCategories(): List<Category>{
            return listOf(
                Category(
                    id = 1,
                    categoryName = "Montain",
                    categoryIcon = painterResource(id = R.drawable.montanha),
                ),
                Category(
                    id = 2,
                    categoryName = "Snow",
                    categoryIcon = painterResource(id = R.drawable.alpino),
                ),

                Category(
                    id = 3,
                    categoryName = "Beach",
                    categoryIcon = painterResource(id = R.drawable.praia),
                        ),
                Category(
                    id = 4,
                    categoryName = "Business",
                    categoryIcon = painterResource(id = R.drawable.mala),
                ),
            )
        }
    }
}