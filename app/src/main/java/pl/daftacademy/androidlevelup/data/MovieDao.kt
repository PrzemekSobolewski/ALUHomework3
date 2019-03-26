package pl.daftacademy.androidlevelup.data

import pl.daftacademy.androidlevelup.entity.Movie

interface MovieDao {
    fun getAllMovies(): List<Movie>
    fun getCrimeMovies():List<Movie>
    fun getActionMovies():List<Movie>
    fun getHorrorMovies():List<Movie>
    fun getComedyMovies():List<Movie>
    fun getRomanceMovies():List<Movie>
}