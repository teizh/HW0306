package com.example.hw0306.ui
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw0306.data.model.PlaylistsModel
import com.example.hw0306.databinding.ItemPlaylistsBinding


class AdapterPlayLists(private val onCLick: (PlaylistsModel.Item) -> Unit) :
    RecyclerView.Adapter<AdapterPlayLists.PlayListsViewHolder>() {

    private var list = arrayListOf<PlaylistsModel.Item>()

    fun setList(lists: List<PlaylistsModel.Item>) {
//        this.list = lists as ArrayList<PlayListsModel.Item>
        val previousSize = list.size
        list.clear()
        list.addAll(lists)
        val newSize = list.size
        if (previousSize == newSize) notifyItemRangeChanged(0, newSize)
        else notifyItemRangeChanged(0, newSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayListsViewHolder {
        return PlayListsViewHolder(
            ItemPlaylistsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlayListsViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    inner class PlayListsViewHolder(private val binding: ItemPlaylistsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PlaylistsModel.Item) {
          //  binding.ivPlaylist.load(item.snippet.thumbnails.standard.url)
            binding.tvTitle.text = item.snippet.title
            binding.tvVideoSeries.text = "${item.contentDetails.itemCount} video"

            itemView.setOnClickListener {
                onCLick(item)
            }
        }
    }
}