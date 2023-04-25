package br.senai.sp.jandira.loginapp.repository

import br.senai.sp.jandira.loginapp.model.Trip
import java.time.LocalDate

class TripRepository {

    companion object{
        fun getTrips(): List<Trip>{
            return  listOf(
                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "Cidade muito bonita, com muitas opçoes de passeios.",
                    startDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 4, 23),
                ),
                Trip(
                id = 2,
                location = "São Roque",
                description = "Cidade muito bonita, visitei a vinícula Goes, e tomei bastante vinho.",
                startDate = LocalDate.of(2023, 3, 21),
                endDate = LocalDate.of(2023, 3, 23),
            ),
                Trip(
                    id = 1,
                    location = "Rio de Janeiro",
                    description = "Cidade muito bonita, cheia de montanhas",
                    startDate = LocalDate.of(2023, 1, 16),
                    endDate = LocalDate.of(2023, 1, 23),
                ),





            )
        }
    }
}