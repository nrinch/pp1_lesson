package na.severinchik.lesson5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import na.severinchik.data.lesson5.UserDTO
import na.severinchik.lesson5.databinding.ActivityMainBinding
import na.severinchik.lesson5.databinding.UserItemListBinding

class UserAdapter : ListAdapter<UserDTO, UserAdapter.UserViewHolder>(UserDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UserItemListBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class UserViewHolder(private val binding: UserItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userDTO: UserDTO) {
            binding.uilName.text = userDTO.name
            binding.uilAddress.text = userDTO.address
            binding.uilAge.text = "${userDTO.age} y.o."
        }
    }

    class UserDiffCallback() : DiffUtil.ItemCallback<UserDTO>() {
        override fun areItemsTheSame(oldItem: UserDTO, newItem: UserDTO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserDTO, newItem: UserDTO): Boolean {
            return oldItem == newItem
        }

    }
}