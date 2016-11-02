package com.example.duc.notelistdatabase.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.duc.notelistdatabase.MainActivity;
import com.example.duc.notelistdatabase.R;
import com.example.duc.notelistdatabase.items.Note;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 10/31/2016.
 */

public class NoteDetailViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public NoteDetailViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(Note note){
        tvTitle.setText(note.getTitle());
    }


}
