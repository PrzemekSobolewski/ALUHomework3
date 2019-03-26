package pl.daftacademy.androidlevelup.view.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_home.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.movies.MoviesFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        nav.setNavigationItemSelectedListener { changePage(item = it , fragment = fragment as MoviesFragment) }
        if (savedInstanceState == null) (fragment as MoviesFragment).setItems("all")
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
    }

    private fun changePage(item: MenuItem, fragment: MoviesFragment): Boolean {
        when (item.itemId) {
            R.id.action_movies -> fragment.setItems("all")
            R.id.action_action -> fragment.setItems("Action")
            R.id.action_comedy -> fragment.setItems("Comedy")
            R.id.action_crime -> fragment.setItems("Crime")
            R.id.action_horror -> fragment.setItems("Horror")
            R.id.action_romance -> fragment.setItems("Romance")
            else -> return true
        }
        nav.menu.children.find { it.isChecked }?.isChecked = false
        item.isChecked = true
        drawer.closeDrawers()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


}