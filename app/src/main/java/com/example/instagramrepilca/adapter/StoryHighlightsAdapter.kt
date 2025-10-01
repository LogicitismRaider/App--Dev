package com.example.instagramrepilca.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramrepilca.R
import com.example.instagramrepilca.model.StoryHighlight
import com.google.android.material.imageview.ShapeableImageView

class StoryHighlightsAdapter(private val highlights: List<StoryHighlight>) :
    RecyclerView.Adapter<StoryHighlightsAdapter.HighlightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.addhighlight, parent, false) // Changed to use addhighlight.xml
        return HighlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: HighlightViewHolder, position: Int) {
        holder.bind(highlights[position])
    }

    override fun getItemCount(): Int = highlights.size

    class HighlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Updated IDs to match addhighlight.xml
        private val highlightImage: ShapeableImageView = itemView.findViewById(R.id.add_highlight_image)
        private val highlightName: TextView = itemView.findViewById(R.id.add_highlight_text)

        fun bind(highlight: StoryHighlight) {
            highlightImage.setImageResource(highlight.imageResId)
            highlightName.text = highlight.name
        }
    }
}
