package id.project.favorite

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.EntryPointAccessors
import id.project.core.ui.SoccerClubAdapter
import id.project.favorite.databinding.FragmentFavoriteBinding
import id.project.soccerclub.detail.DetailActivity
import id.project.soccerclub.di.FavoriteModuleDependencies
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        DaggerFavoriteComponent.builder()
            .context(requireActivity())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireActivity().applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this@FavoriteFragment)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoriteListAdapter = SoccerClubAdapter()

        viewModel.favoriteSoccerClub.observe(viewLifecycleOwner) { favoriteList ->
            binding.apply {
                progressBar.visibility = View.VISIBLE
                errorImage.visibility = View.GONE

                if (favoriteList.isNotEmpty()) {
                    favoriteListAdapter.submitList(favoriteList)

                } else {
                    errorImage.visibility = View.VISIBLE
                }
                progressBar.visibility = View.GONE
            }
        }

        binding.rvFavoriteSoccerClub.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = favoriteListAdapter
        }

        favoriteListAdapter.onItemClick = { data ->
            val intentToDetail = Intent(requireActivity(), DetailActivity::class.java)
            intentToDetail.putExtra(DetailActivity.EXTRA_DATA, data)
            startActivity(intentToDetail)
        }
    }

    override fun onResume() {
        super.onResume()
        val favoriteListAdapter = SoccerClubAdapter()

        viewModel.favoriteSoccerClub.observe(viewLifecycleOwner) { favoriteList ->
            binding.apply {
                progressBar.visibility = View.VISIBLE
                errorImage.visibility = View.GONE

                if (favoriteList.isNotEmpty()) {
                    favoriteListAdapter.submitList(favoriteList)

                } else {
                    errorImage.visibility = View.VISIBLE
                }
                progressBar.visibility = View.GONE
            }
        }

        binding.rvFavoriteSoccerClub.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = favoriteListAdapter
        }

        favoriteListAdapter.onItemClick = { data ->
            val intentToDetail = Intent(requireActivity(), DetailActivity::class.java)
            intentToDetail.putExtra(DetailActivity.EXTRA_DATA, data)
            startActivity(intentToDetail)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}