package com.example.duc.hw12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.duc.hw12.constants.Constant;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_idUser)
    EditText etidUser;
    @BindView(R.id.et_title)
    EditText ettitle;
    @BindView(R.id.et_body)
    EditText etbody;
    @BindView(R.id.tv_response)
    TextView tvresponse;
    @BindView(R.id.bt_post)
    Button btpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        postContent();
    }

    @OnClick(R.id.bt_post)
    public void postContent() {

        Item item = new Item(etidUser.getText().toString(),ettitle.getText()
                .toString(),etbody.getText().toString());
        Gson gson = new Gson();
        String jsonItem = gson.toJson(item);
        RequestBody formbody = RequestBody.
                create(MediaType.parse("application/json; charset=utf-8"),jsonItem);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(Constant.POST_API).
                post(formbody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               setText(response.body().string());
            }
        });

    }

    private void setText(final String response) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvresponse.setText(response);
            }
        });
    }


}
