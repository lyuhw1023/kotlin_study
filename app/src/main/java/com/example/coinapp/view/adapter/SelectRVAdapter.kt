package com.example.coinapp.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coinapp.R
import com.example.coinapp.dataModel.CurrentPriceResult

class SelectRVAdapter (val context : Context, val coinPriceLst : List<CurrentPriceResult>)
    :RecyclerView.Adapter<SelectRVAdapter.ViewHolder>(){

    val selectedCoinList = ArrayList<String>()
        inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
            val coinName : TextView = view.findViewById(R.id.coinName)
            val coinPriceUpDown : TextView = view.findViewById(R.id.coinPriceUpDown)
            val likeImage : ImageView = view.findViewById(R.id.likeBtn)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.intro_coin_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return coinPriceLst.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.coinName.text = coinPriceLst[position].coinName

        val fluctate_24H = coinPriceLst[position].coinInfo.fluctate_24H

        if(fluctate_24H.contains("-")){
            holder.coinPriceUpDown.text = "하락입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#114fed"))
        } else {
            holder.coinPriceUpDown.text = "상승입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#ed2e11"))
        }

        val likeImage = holder.likeImage
        val currentCoin = coinPriceLst[position].coinName

        // 현재 아이템의 좋아요 상태를 초기 설정, recyclerview가 화면에 아이템을 그릴 때
        if(selectedCoinList.contains(currentCoin)){
            likeImage.setImageResource(R.drawable.like_red)
        } else {
            likeImage.setImageResource(R.drawable.like_grey)
        }

        // 좋아요 상태 변경 & 즉시 ui 업데이트, 하트 버튼 클릭할 때
        likeImage.setOnClickListener{

            if(selectedCoinList.contains(currentCoin)){
                // 포함하면
                selectedCoinList.remove(currentCoin)
                likeImage.setImageResource(R.drawable.like_grey)
            } else {
                // 포함하지 않으면
                selectedCoinList.add(currentCoin)
                likeImage.setImageResource(R.drawable.like_red)
            }


        }
    }
}