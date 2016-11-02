package com.example.duc.notelistdatabase.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.notelistdatabase.R;
import com.example.duc.notelistdatabase.items.Note;
import com.example.duc.notelistdatabase.viewholders.NoteDetailViewHolder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DUC on 10/31/2016.
 */

public class NoteListAdapter extends RecyclerView.Adapter<NoteDetailViewHolder> {

    public static List<Note> notesList = Arrays.asList(Note.NOTES);
    @Override
    public NoteDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.note_item, parent, false);
        NoteDetailViewHolder noteDetailViewHolder = new NoteDetailViewHolder(itemView);
        return noteDetailViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteDetailViewHolder holder, int position) {
        Note note = notesList.get(position);
        holder.setData(note);

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public void addItem(int position, Note note) {
        notesList.add(position, note);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        notesList.remove(position);
        notifyItemRemoved(position);
    }
}
