package com.example.duc.l62;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.duc.l62.constants.Constant.FLICKR_API;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.toString();

    @BindView(R.id.lv_item)
    ListView lvItem;
    private ArrayList<Item> itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        getSupportActionBar().hide();
        getContent();
    }

    public void getContent(){
        itemArrayList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(FLICKR_API).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string().replace("jsonFlickrFeed(","")
                        .replace("})","}");
                Log.d(TAG,body);
                Gson gson = new Gson();
                final FlickrFeed flickrFeed = gson.fromJson(body,FlickrFeed.class);
                for(Item item : flickrFeed.getItems()){
                    itemArrayList.add(item);
                }
                MainActivity.this.updateBody(itemArrayList);

            }
        });

    }
    private void updateBody(final ArrayList<Item> flickrItems) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lvItem.setAdapter(new FlickrAdapter(MainActivity.this,
                        R.layout.item,itemArrayList));
            }
        });
    }


}
