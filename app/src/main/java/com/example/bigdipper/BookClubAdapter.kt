package com.example.bigdipper

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat.getFont
import androidx.core.view.marginRight
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.example.bigdipper.databinding.RowBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class BookClubAdapter(val items: ArrayList<BookClubData>): RecyclerView.Adapter<BookClubAdapter.ViewHolder> (){


    interface onItemClickListener{
        fun onItemClick(data: BookClubData, position: Int)
    }
    var itemClickListener : onItemClickListener?= null

    inner class ViewHolder(val binding: RowBinding): RecyclerView.ViewHolder(binding.root){
        init{
            binding.bookClubItem.setOnClickListener{
                itemClickListener?.onItemClick(items[adapterPosition], adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookClubAdapter.ViewHolder {
        val view = RowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookClubAdapter.ViewHolder, position: Int) {
//        이미지 설정
//        items[position].clubImg
        holder.binding.creator.text = items[position].creatorName
        holder.binding.clubName.text = items[position].clubName
        for(tagString in items[position].tags){
            val context = holder.itemView.context
            val textView = TextView(context)
            textView.includeFontPadding = false
            textView.typeface = context.resources.getFont(R.font.notosanskr_medium)
            textView.text = tagString
            textView.setBackgroundResource(R.drawable.tag_shape)
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 0, context.resources.getDimensionPixelSize(R.dimen.tag_right_margin), 0)
            textView.layoutParams = layoutParams
            textView.setPadding(
                context.resources.getDimensionPixelSize(R.dimen.tag_padding_horizontal),
                context.resources.getDimensionPixelSize(R.dimen.tag_padding_vertical),
                context.resources.getDimensionPixelSize(R.dimen.tag_padding_horizontal),
                context.resources.getDimensionPixelSize(R.dimen.tag_padding_vertical)
            )
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
            holder.binding.clubTags.addView(textView)
        }
        holder.binding.clubDetails.text = items[position].clubDetails
        holder.binding.memberNum.text = items[position].memberNum + " 명"
    }

    override fun getItemCount(): Int {
        return items.size
    }

}