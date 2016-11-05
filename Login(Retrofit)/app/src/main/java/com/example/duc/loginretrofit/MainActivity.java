package com.example.duc.loginretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_user)
    EditText etUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.btn_login)
    public void sendRequest(){
        Retrofit loginRetrofit = new Retrofit
                .Builder()
                .baseUrl("https://a5-tumblelog.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Account account = new Account(etUser.getText().toString(),etPassword.getText().toString());
        String jsonBody = new Gson().toJson(account);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"),jsonBody);

        LoginService loginService = loginRetrofit.create(LoginService.class);
        loginService.login(body).enqueue(new Callback<ResultLoginJsonModel>() {
            @Override
            public void onResponse(Call<ResultLoginJsonModel> call, Response<ResultLoginJsonModel> response) {
                ResultLoginJsonModel result = response.body();
                boolean resultString = result.isSuccessful();
                if (resultString){
                    Toast toast = Toast.makeText(MainActivity.this,"Login passed",Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Toast toast = Toast.makeText(MainActivity.this,"Login failed",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            @Override
            public void onFailure(Call<ResultLoginJsonModel> call, Throwable t) {

            }
        });

    }


}
