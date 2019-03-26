package pl.daftacademy.androidlevelup.view.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_movies.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.viewmodel.MoviesViewModel

class MoviesFragment : Fragment() {

    private val viewModel by lazy { ViewModelProviders.of(this)[MoviesViewModel::class.java] }
    private val adapter = MoviesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_movies, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.adapter = adapter
        adapter.items = viewModel.getMovies()
    }

    fun setItems(name: String): Boolean {
        when (name) {
            "Horror" -> adapter.items = viewModel.getHorrors()
            "Action" -> adapter.items = viewModel.getAction()
            "Romance" -> adapter.items = viewModel.getRomance()
            "Crime" -> adapter.items = viewModel.getCrimes()
            "Comedy" -> adapter.items = viewModel.getComedy()
            else -> adapter.items = viewModel.getMovies()
        }
        return true
    }
}
