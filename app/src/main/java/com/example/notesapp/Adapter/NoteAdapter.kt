package com.example.notesapp.Adapter

import android.icu.text.CaseMap.Title
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.notesapp.Entity.NoteEntity
import com.example.notesapp.databinding.NoteItemBinding
import org.w3c.dom.Text

class NoteAdapter(note : List<NoteEntity>) : Adapter<NoteAdapter.NoteHolder>() {

    var note = note

    class NoteHolder(itemView:NoteItemBinding) : ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        var binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteHolder(binding)
    }

    override fun getItemCount(): Int {
        return note.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.binding.apply {
            txtTitle.isSelected = true
            note.get(position).apply{
                txtTitle.text = Title
                txtText.text = Text
            }
        }
    }

    fun update(notes: List<NoteEntity>) {
        this.note = notes
        notifyDataSetChanged()
    }

    private fun notifyDataSetChanged() {

    }

}