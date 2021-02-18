package web.id.wahyou.movieq.ui.movie.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.bumptech.glide.Glide
import web.id.wahyou.movieq.databinding.ActivityDetailMovieBinding
import web.id.wahyou.movieq.model.DataMovie

class DetailMovieActivity : AppCompatActivity() {
    private val binding : ActivityDetailMovieBinding by lazy {
        ActivityDetailMovieBinding.inflate(layoutInflater)
    }

    private val data : DataMovie? by lazy {
        intent.getParcelableExtra("data")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupStatusBar()
        setData()
    }

    private fun setupStatusBar() {
        with(window) {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setData() {
        with(binding) {
            if(data!=null) {
                tvTitle.text = data?.title
                tvRelease.text = data?.date
                tvPopularity.text = data?.popularity.toString() + " Viewers"
                tvRating.text = data?.vote_average.toString()
                tvDescription.text = data?.description

                val poster = resources.getIdentifier(
                    "web.id.wahyou.movieq:drawable/"
                            + data?.poster?.substring(10, data!!.poster.length),
                    null, null
                )
                Glide.with(this@DetailMovieActivity).load(poster).into(imgPoster)

                Glide.with(this@DetailMovieActivity)
                    .load(poster)
                    .into(imgBackground)
            }

            imgBack.setOnClickListener {
                finish()
            }
        }
    }
}