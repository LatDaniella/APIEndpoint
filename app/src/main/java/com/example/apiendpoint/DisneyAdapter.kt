package com.example.apiendpoint

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class DisneyAdapter(var dataSet: List<DisneyCharactersInfo>) :
    RecyclerView.Adapter<DisneyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView
        var textViewId: TextView
        val layout: ConstraintLayout


        init {
            // Define click listener for the ViewHolder's View.
            // view.findViewById looks for the id in the ViewHolder Class
            textViewName = view.findViewById(R.id.textView_disneyItem_name)
            textViewId = view.findViewById(R.id.textView_disneyItem_id)
            layout = view.findViewById(R.id.layout_disneyItem)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_disney, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        // assigning all values (put on click listeners too
        val disney = dataSet[position]
        viewHolder.textViewName.text = disney.name
        viewHolder.textViewId.text = disney.id.toString()

        viewHolder.layout.setOnClickListener {
            // Toast.makeText(it.context, "Hi, you clicked on ${hero.name}", Toast.LENGTH_SHORT).show()
            //get context from something in viewHolder
            val context = viewHolder.layout.context
            //make the intent with context we got
            val disneyDetailIntent = Intent(context, DisneyDetailActivity::class.java).apply {
                putExtra(DisneyDetailActivity.EXTRA_CHARACTER, disney)
            }
            context.startActivity(disneyDetailIntent)
        }

    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}
