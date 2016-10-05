package com.example.duc.turn4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_new_menu)
    public ListView lvNewMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {
//        lvFashionMenu.setAdapter(new ArrayAdapter<FashionItem>
//                (this, android.R.layout.simple_list_item_1,FashionItem.ARRAY));
        lvNewMenu.setAdapter(new NewAdapter
                (this, R.layout.listviewnewitem,
                        Arrays.asList(NewItem.ARRAY)));

    }
}
