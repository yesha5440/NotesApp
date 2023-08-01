package com.example.notesapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notesapp.Adapter.NoteAdapter
import com.example.notesapp.Database.RoomDB
import com.example.notesapp.Entity.NoteEntity
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.databinding.AddDialogBinding
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {


    lateinit var db: RoomDB
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = RoomDB.init(this)

        initView()


    }

    private fun initView() {

        binding.add.setOnClickListener{
            addNoteDialoge()

    }
        adapter = NoteAdapter(db.note().getNotes())
        binding.noteList.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.noteList.adapter = adapter
}

    private fun addNoteDialoge() {

        var dialog = Dialog(this)
        var bind = AddDialogBinding.inflate(layoutInflater)
        dialog.setContentView(bind.root)

        bind.btnSubmit.setOnClickListener {
            var title = bind.edtTitle.text.toString()
            var text = bind.edtText.text.toString()
            var format = SimpleDateFormat("DD/MM/YYYY hh:mm:ss a ")
            var current = format.format(Date())
            var data = NoteEntity(title,text,current)
            db.note().addNote(data)
            adapter.update(db.note().getNotes())
            dialog.dismiss()
        }

        dialog.show()

    }

}
