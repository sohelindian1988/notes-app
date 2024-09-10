package `in`.co.mohamedsohel.notekotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import `in`.co.mohamedsohel.notekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var db:NotesDatabaseHelper
    private lateinit var notesAdapter: NotesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=NotesDatabaseHelper(this)
        notesAdapter=NotesAdapter(this,db.getAllNotes())

        binding.notesRecyclerView.layoutManager =LinearLayoutManager(this)
        binding.notesRecyclerView.adapter=notesAdapter

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this,AddNoteActivity::class.java ))
        }

    }



    override fun onResume() {
        super.onResume()
        notesAdapter.refresh(db.getAllNotes())
    }
}