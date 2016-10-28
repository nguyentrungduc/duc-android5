package com.example.duc.dailyquote.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.dailyquote.MainActivity;
import com.example.duc.dailyquote.R;
import com.example.duc.dailyquote.constants.Constants;
import com.example.duc.dailyquote.jsonmodels.QuoteJSONModels;
import com.example.duc.dailyquote.manages.Preferences;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.duc.dailyquote.constants.Constants.QUOTE_API;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {
    public static final String TAG = MainActivity.class.toString();
    @BindView(R.id.imv_background)
    ImageView imvBackground;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.tv_title)
    TextView tvTitle;


    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this,view);
        setupUI();

        return view;
    }
    private void setupUI() {
        //tvname.settext(Preferences.getPreferences().getUsername());
        ImageLoader.getInstance().displayImage(Constants.UNSPLASH_API,imvBackground);

        //1 Create Client
        OkHttpClient client = new OkHttpClient();


        //2 Create request
        Request request = new Request.Builder().url(QUOTE_API).build();

        //3 Send and handlde feedback
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //ket noi that bai

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //ket noi thanh cong
                Log.d(TAG,"onResponse");
                String bodyString = response.body().string();
                Log.d(TAG, String.format("Responsebody : %s",bodyString));
                //Create Gson
                Gson gson = new Gson();
                //Parse
                QuoteJSONModels[] quote = gson.fromJson(bodyString, QuoteJSONModels[].class);
                //  Log.d(TAG, String.format("quote length : %s", quote.length));
                if(quote.length > 0){
                    QuoteFragment.this.updateQuote(quote[0]);

                }


            }
        });


    }

    private void updateQuote(final QuoteJSONModels quoteJSONModels){
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText(quoteJSONModels.getTitle());
                tvContent.setText(Html.fromHtml(quoteJSONModels.getContent()));
            }
        });

    }

}
