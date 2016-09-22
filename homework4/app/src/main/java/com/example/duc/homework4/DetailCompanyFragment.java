package com.example.duc.homework4;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCompanyFragment extends Fragment {

    private TextView tvname;
    private TextView tvphonenb;
    private TextView tvwebsite;

    private Company company;


    public DetailCompanyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_company, container, false);

        getRefereces(view);
        setupUI();
        addListener();
        return view;
    }

    public void setCompany(Company company){
        this.company = company;
    }

    private void getRefereces(View view){
        tvname = (TextView) view.findViewById(R.id.tv_name);
        tvphonenb = (TextView) view.findViewById(R.id.tv_phonenb);
        tvwebsite = (TextView) view.findViewById(R.id.tv_website);
    }

    private void setupUI(){
        tvname.setText(company.getName());
        tvphonenb.setText(company.getPhonenb());
        tvwebsite.setText(company.getWebsite());
    }

    private void addListener(){
        tvwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String googleSearchString = String.format("https://google.com/?q=s",company.getWebsite());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSearchString));
                startActivity(intent);
            }
        });
        tvphonenb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri call = Uri.parse("tel:" + company.getPhonenb());
                Intent surf = new Intent(Intent.ACTION_DIAL, call);
                startActivity(surf);
            }
        });

    }

}
