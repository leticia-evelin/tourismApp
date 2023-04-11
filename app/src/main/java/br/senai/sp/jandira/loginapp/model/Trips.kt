package br.senai.sp.jandira.loginapp.model

import androidx.compose.ui.graphics.painter.Painter

data class Trips (
        var id: Int = 0,
        var name: String = " ",
        var description: String = "Esta é a descrição do produto. ",
        var price: Double = 0.0,
        var image: Painter? = null
)


