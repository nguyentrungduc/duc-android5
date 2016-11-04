package com.example.duc.notelistdatabase.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.duc.notelistdatabase.MainActivity;
import com.example.duc.notelistdatabase.R;
import com.example.duc.notelistdatabase.items.Note;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    @BindView(R.id.bt_save)
    Button btSave;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_content)
    EditText etContent;
    private Note note;


    public DetailFragment() {
        // Required empty public constructor
    }

    private void setNote(Note note){
        this.note = note;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this,view);
        setupUI();
        addListener();
        return view;
    }

    private void addListener() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note(
                        ((MainActivity)getActivity()).getNote().getId(),
                        etTitle.getText().toString(),
                        etContent.getText().toString()
                );
                ((MainActivity) getActivity()).onBackPressed();
            }
        });

    }

    private void setupUI(){
        Note note = ((MainActivity)getActivity()).getNote();
        etTitle.setText(etTitle.getText());
        etContent.setText(etContent.getText());
    }

}
