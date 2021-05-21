package com.example.quiz_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class ThemeAdapter(val context: Context, val items: ArrayList<String>, val userName: String) :
    RecyclerView.Adapter<ThemeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.theme_custom_row,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)
        holder.tvItem.text = item


        holder.tvItem.setOnClickListener() {
            val intent = Intent(context, QuestionsActivity::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            intent.putExtra(Constants.THEME_NUM, position)
            context.startActivity(intent)
        }


        // Updating the background color according to the odd/even positions in list.
        if (position % 2 == 0) {
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorLightGray
                )
            )
        } else {
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.colorWhite
                )
            )
        }
    }

    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val tvItem: TextView = view.findViewById<TextView>(R.id.tv_item_name)
        val cardViewItem: CardView = view.findViewById<CardView>(R.id.card_view_item)

    }
}
