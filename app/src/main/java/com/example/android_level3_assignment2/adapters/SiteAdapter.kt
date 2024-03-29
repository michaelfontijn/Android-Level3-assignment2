package com.example.android_level3_assignment2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_level3_assignment2.models.Site

class SiteAdapter(private val sites: List<Site>) :
    RecyclerView.Adapter<SiteAdapter.ViewHolder>() {

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return sites.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(sites[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvSiteTitle: TextView = itemView.findViewById(android.R.id.text1)

        //binds a given reminder to the reminder text input
        fun bind(site: Site) {
            //TODO
            tvSiteTitle.text = site.title
        }
    }

}