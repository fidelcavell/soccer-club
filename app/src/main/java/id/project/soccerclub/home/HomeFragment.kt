package id.project.soccerclub.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import id.project.core.data.source.Resource
import id.project.core.ui.SoccerClubAdapter
import id.project.soccerclub.databinding.FragmentHomeBinding
import id.project.soccerclub.detail.DetailActivity

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val soccerClubListAdapter = SoccerClubAdapter()

        viewModel.soccerClubList.observe(viewLifecycleOwner) { soccerClubList ->
            when (soccerClubList) {
                is Resource.Loading -> {
                    binding.apply {
                        progressBar.visibility = View.VISIBLE
                        errorImage.visibility = View.GONE
                    }
                }

                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    soccerClubListAdapter.submitList(soccerClubList.data)
                }

                is Resource.Error -> {
                    binding.apply {
                        progressBar.visibility = View.GONE
                        errorImage.visibility = View.VISIBLE
                    }
                }
            }
        }

        viewModel.isDarkMode.observe(viewLifecycleOwner) { isDarkMode: Boolean ->
            if (isDarkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        binding.rvSoccerClub.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = soccerClubListAdapter
        }

        soccerClubListAdapter.onItemClick = { data ->
            val intentToDetail = Intent(requireActivity(), DetailActivity::class.java)
            intentToDetail.putExtra(DetailActivity.EXTRA_DATA, data)
            startActivity(intentToDetail)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}