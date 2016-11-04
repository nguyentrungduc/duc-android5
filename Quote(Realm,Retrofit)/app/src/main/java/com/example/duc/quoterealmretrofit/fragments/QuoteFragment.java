package com.example.duc.quoterealmretrofit.fragments;


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

import com.example.duc.quoterealmretrofit.R;
import com.example.duc.quoterealmretrofit.constants.Constanst;
import com.example.duc.quoterealmretrofit.managers.DbContext;
import com.example.duc.quoterealmretrofit.managers.NetWorkManager;
import com.example.duc.quoterealmretrofit.http.QODService;
import com.example.duc.quoterealmretrofit.models.Quote;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {
    private static final String TAG = QuoteFragment.class.toString();
    @BindView(R.id.imv_background)
    ImageView imvBackground;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_username)
    TextView tvUserName;

    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        ButterKnife.bind(this, view);
        setupUI();
        return view;
    }
    static final String BASE_URL = "http://quotesondesign.com";

    private void setupUI() {
        //get image with ImageLoader
        ImageLoader.getInstance().displayImage(Constanst.UNSPLASH_API, imvBackground);

        if(NetWorkManager.getInstance().isConnectedToInternet()){
            Log.d(TAG,"hihi");
        }
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        QODService service = retrofit.create(QODService.class);
        service.getQuote().enqueue(new Callback<Quote[]>() {
            @Override
            public void onResponse(Call<Quote[]> call, Response<Quote[]> response) {
                Log.d(TAG,"onR");
                Quote[] quote = response.body();
                Log.d(TAG,quote[0].getContent());
                Log.d(TAG,quote[0].getTitle());
                updateQuote(quote[0]);
                if(DbContext.getInstance().getSize() < 10){
                    DbContext.getInstance().add(quote[0]);
                }
                Log.d(TAG, String.format("%s",DbContext.getInstance().getSize()));
            }

            @Override
            public void onFailure(Call<Quote[]> call, Throwable t) {
                updateQuote(DbContext.getInstance().pickQuoteRandom());
            }
        });


    }

    private void updateQuote(final Quote quote) {
        Activity parent = getActivity();
        parent.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvTitle.setText(quote.getTitle());
                tvContent.setText(Html.fromHtml(quote.getContent()));
            }
        });
    }



}
