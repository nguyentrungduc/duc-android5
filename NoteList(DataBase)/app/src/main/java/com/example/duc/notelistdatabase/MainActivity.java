package com.example.duc.notelistdatabase;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.duc.notelistdatabase.adapters.NoteListAdapter;
import com.example.duc.notelistdatabase.fragments.BlankFragment;
import com.example.duc.notelistdatabase.fragments.DetailFragment;
import com.example.duc.notelistdatabase.items.Note;
import com.example.duc.notelistdatabase.managers.DbHelper;
import com.example.duc.notelistdatabase.onlisteners.ItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.duc.notelistdatabase.adapters.NoteListAdapter.notesList;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_note)
    RecyclerView rvNote;
    @BindView(R.id.bt_add)
    Button btAdd;
    public static int pos;
    private NoteListAdapter noteListAdapter = new NoteListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
        addListener();
    }

    private void addListener() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new DetailFragment(), true);
            }
        });

        rvNote.addOnItemTouchListener(new ItemClickListener(this, rvNote, new ItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                pos = position;
                changeFragment(new DetailFragment(), true);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                DbHelper.getInstance().deleteNote(notesList.get(position));
                notesList = DbHelper.getInstance().selectAllNote();
                noteListAdapter.notifyDataSetChanged();

            }
        }));
    }

    private void setupUI() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvNote.setLayoutManager(linearLayoutManager);
        rvNote.setAdapter(noteListAdapter);
    }

    public void changeFragment(Fragment fragment, boolean addToBackstack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, fragment);
        if(addToBackstack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    public void reset(){
        notesList = DbHelper.getInstance().selectAllNote();
    }



    public Note getNote(){
        return notesList.get(pos);
    }






}
