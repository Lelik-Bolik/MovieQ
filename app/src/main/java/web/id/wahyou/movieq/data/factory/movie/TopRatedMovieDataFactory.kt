package web.id.wahyou.movieq.data.factory.movie

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import web.id.wahyou.movieq.data.model.movie.DataMovie
import web.id.wahyou.movieq.data.source.movie.TopRatedMovieDataSource
import web.id.wahyou.movieq.state.MovieState
import javax.inject.Inject

class TopRatedMovieDataFactory @Inject constructor(
    private val topRatedMovieDataSource: TopRatedMovieDataSource
) : DataSource.Factory<Int, DataMovie>(){

    lateinit var liveData: MutableLiveData<MovieState>

    override fun create(): DataSource<Int, DataMovie> {
        return topRatedMovieDataSource.also {
            it.liveData = liveData
        }
    }
}