package id.project.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.project.core.databinding.ItemListSoccerClubBinding
import id.project.core.domain.model.SoccerClub

class SoccerClubAdapter : ListAdapter<SoccerClub, SoccerClubAdapter.ListViewHolder>(DIFF_CALLBACK) {
    var onItemClick: ((SoccerClub) -> Unit)? = null

    inner class ListViewHolder(private val binding: ItemListSoccerClubBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(soccerClub: SoccerClub) {
            binding.apply {
                Glide.with(itemImage.context)
                    .load(soccerClub.strFanArt)
                    .into(itemImage)
                itemName.text = soccerClub.strTeam
                itemLocation.text = soccerClub.strLocation
            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListSoccerClubBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<SoccerClub> =
            object : DiffUtil.ItemCallback<SoccerClub>() {
                override fun areItemsTheSame(oldItem: SoccerClub, newItem: SoccerClub): Boolean {
                    return oldItem.idTeam == newItem.idTeam
                }

                override fun areContentsTheSame(oldItem: SoccerClub, newItem: SoccerClub): Boolean {
                    return oldItem == newItem
                }
            }
    }
}