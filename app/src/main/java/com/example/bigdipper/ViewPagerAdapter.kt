package com.example.bigdipper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.example.bigdipper.databinding.ActivityMainBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class ViewPagerAdapter(private var title: List<String>, private var description: List<String>, private var lottie: List<Int>)
    : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val itemTitle: TextView = itemView.findViewById(R.id.welcomeTitle)
        val itemDescription: TextView = itemView.findViewById(R.id.welcomeDescription)
        val itemAnimation : LottieAnimationView = itemView.findViewById(R.id.welcomeAnimationView)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_welcome_guide, parent, false))
    }

    override fun getItemCount(): Int {
       return title.size
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDescription.text = description[position]
        holder.itemAnimation.setAnimation(lottie[position])
    }

}