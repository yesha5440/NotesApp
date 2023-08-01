package com.example.notesapp.Database

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notesapp.Dao.NoteDao
import com.example.notesapp.Entity.NoteEntity


@Database(entities = [NoteEntity::class], version = 1)

abstract class RoomDB() : RoomDB(){

    companion object {
        fun init(context: Context): RoomDB {
            var db = Room.databaseBuilder(context, RoomDB::class.java, "Note.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            return db
        }
    }

    constructor(parcel: Parcel) : this() {
    }

    abstract fun note(): NoteDao
    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RoomDB> {
        override fun createFromParcel(parcel: Parcel): RoomDB {
            return RoomDB(parcel)
        }

        override fun newArray(size: Int): Array<RoomDB?> {
            return arrayOfNulls(size)
        }
    }

}