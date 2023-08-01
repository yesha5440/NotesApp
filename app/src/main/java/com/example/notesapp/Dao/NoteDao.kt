package com.example.notesapp.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.Entity.NoteEntity


@Dao
interface NoteDao {

    @Insert
    fun addNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    fun getNotes() : List<NoteEntity>

    @Update
    fun updataNote(noteEntity: NoteEntity)

    @Delete
    fun deletNote(noteEntity: NoteEntity)

    @Query("DELETE FROM notes")
    fun allDelete()

}