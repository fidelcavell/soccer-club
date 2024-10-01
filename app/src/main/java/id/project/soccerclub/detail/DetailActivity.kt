package id.project.soccerclub.detail

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import id.project.core.domain.model.SoccerClub
import id.project.soccerclub.R
import id.project.soccerclub.databinding.ActivityDetailBinding

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val soccerClubData = intent.getParcelableExtra<SoccerClub>(EXTRA_DATA)

        setupAction()
        setupDetailSoccerClub(soccerClubData)
    }

    private fun setupDetailSoccerClub(soccerClub: SoccerClub?) {
        binding.progressBar.visibility = View.VISIBLE
        binding.errorImage.visibility = View.GONE
        if (soccerClub != null) {
            binding.apply {
                Glide.with(this@DetailActivity)
                    .load(soccerClub.strFanArt)
                    .transform(RoundedCorners(16))
                    .into(soccerClubImage)
                soccerClubName.text = soccerClub.strTeam
                soccerClubDescription.text = soccerClub.strDescriptionEN

                var isFavorite = soccerClub.isFavorite
                updateIsFavorite(isFavorite)

                fabFavorite.setOnClickListener {
                    isFavorite = !isFavorite
                    viewModel.updateFavoriteSoccerClub(soccerClub, isFavorite)
                    updateIsFavorite(isFavorite)
                }
            }

        } else {
            binding.errorImage.visibility = View.VISIBLE
        }
        binding.progressBar.visibility = View.GONE
    }

    private fun updateIsFavorite(isFavorite: Boolean) {
        binding.fabFavorite.apply {
            if (isFavorite) {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        this@DetailActivity,
                        R.drawable.ic_favorite_filled
                    )
                )
            } else {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        this@DetailActivity,
                        R.drawable.ic_favorite_unfilled
                    )
                )
            }
        }
    }

    private fun setupAction() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}