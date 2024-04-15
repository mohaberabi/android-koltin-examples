package database.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moviescleanarchitcture.data.database.AppDatabase
import com.example.moviescleanarchitcture.data.database.dao.MovieDao
import com.example.moviescleanarchitcture.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    private val movies = listOf<Movie>(

        Movie(1, "asdsa", "asdasdasd", "sadasdasd", "sadsadasd"),


        )

    @get:Rule
    val instant = InstantTaskExecutorRule()


    private lateinit var movieDao: MovieDao


    private lateinit var database: AppDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()

        movieDao = database.moviesDao
    }


    @Test

    fun saveMovies() = runBlocking {


        movieDao.saveMovies(movies)

        val allMovies = movieDao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }


    @Test

    fun deleteMovies() = runBlocking {


        movieDao.deleteMovies()
        val mov = movieDao.getMovies()

        Truth.assertThat(mov).isEmpty()
    }


    @After
    fun tearDown() {
        database.close()
    }


}