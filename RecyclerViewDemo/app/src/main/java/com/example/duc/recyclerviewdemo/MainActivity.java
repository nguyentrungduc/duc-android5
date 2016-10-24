package com.example.duc.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.example.duc.recyclerviewdemo.adapters.PostAdapter;
import com.example.duc.recyclerviewdemo.jsonmodels.PostJsonModel;
import com.example.duc.recyclerviewdemo.models.Post;
import com.example.duc.recyclerviewdemo.views.ExtendedRecyclerView;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private PostAdapter postAdapter;
    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.rv_post)
    RecyclerView rvPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        setupUI();
           sendGETRequest();
        //sendPOSTRequet();
    }

    private void setupUI() {
        //final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
//        rvPost.setLayoutManager(layoutManager);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvPost.setLayoutManager(staggeredGridLayoutManager);
        //setup adapter
        postAdapter = new PostAdapter();
        rvPost.setAdapter(postAdapter);
    }

    private void sendPOSTRequet() {
        String URL ="https://hihihoho.herokuapp.com/";

        OkHttpClient client = new OkHttpClient();

//        FormBody formBody = new FormBody.Builder()
//                .add("title","1").add("content","11").build();
//
        PostJsonModel postJsonModel = new PostJsonModel("5","3");
        String jsonBody = new Gson().toJson(postJsonModel);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonBody);
        Request request = new Request.Builder().url(URL).post(requestBody).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {
                    String body = response.body().string();
                    Log.d(TAG, String.format("onResponse : %s", body));
                    PostJsonModel[] postJsonModels = (new Gson())
                            .fromJson(body,PostJsonModel[].class);
                    Post.list.clear();
                    for(PostJsonModel postJsonModel : postJsonModels){
                        Post.list.add
                                (new Post(postJsonModel.getTitle(),
                                        postJsonModel.getContent()));
                    }
                }
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        postAdapter.notifyDataSetChanged();
                    }
                });

            }

        });

    }

    private void sendGETRequest(){
        String URL ="https://hihihoho.herokuapp.com/";

        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder().url(URL).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    String body = response.body().string();
                    Log.d(TAG, String.format("onResponse:body = %s", body));
                    PostJsonModel[] postJSONModel = (new Gson()
                            .fromJson(body,PostJsonModel[]
                                    .class));
                    Post.list.clear();
                    for (PostJsonModel postJSONMode :postJSONModel){
                        Post.list
                                .add(new Post(
                                        postJSONMode.getTitle(),
                                        postJSONMode.getContent()));
                    }
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            postAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });

    }

}

