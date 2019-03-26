package pl.daftacademy.androidlevelup.data

import android.content.Context
import com.google.gson.Gson
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.MoviesPage
import java.io.InputStreamReader

class MovieFileDao(private val context: Context) : MovieDao {
    @Suppress("UNCHECKED_CAST")

    override fun getAllMovies() =
        InputStreamReader(context.assets.open("movies.json"))
            .let { Gson().fromJson(it, MoviesPage::class.java) }
            .movies

    override fun getCrimeMovies() =
       getAllMovies().filter { movie -> movie.genres.contains("Crime")}

    override fun getActionMovies() =
        getAllMovies().filter { movie -> movie.genres.contains("Action") }

    override fun getHorrorMovies() =
        getAllMovies().filter { movie -> movie.genres.contains("Horror") }

    override fun getComedyMovies() =
        getAllMovies().filter { movie -> movie.genres.contains("Comedy") }

    override fun getRomanceMovies() =
        getAllMovies().filter { movie -> movie.genres.contains("Romance") }
}