package com.example.duc.homework4;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

public class CompanyListActivity extends AppCompatActivity {

    private ListView lvcompany;
    private List<Company> companyList;
    private FrameLayout flcontainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        initData();
        getRefereces();
        setupUI();
        addListener();
    }

    private void getRefereces(){
        lvcompany = (ListView) findViewById(R.id.lv_company);
        flcontainer = (FrameLayout) findViewById(R.id.fl_company_list_container1);
    }

    private void initData(){
        companyList = Company.getListCompany();
    }

    private void setupUI(){
        ArrayAdapter<Company> companyArrayAdapter = new ArrayAdapter<Company>
                (this,android.R.layout.simple_list_item_1,companyList);
        lvcompany.setAdapter(companyArrayAdapter);
    }

    private void addListener(){
        lvcompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Company company = companyList.get(i);
                DetailCompanyFragment companyDetailFragment = new DetailCompanyFragment();
                companyDetailFragment.setCompany(company);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(findViewById(R.id.fl_company_list_container2) == null){
                    fragmentTransaction.replace(R.id.fl_company_list_container1, companyDetailFragment);
                }
                else{
                    fragmentTransaction.replace(R.id.fl_company_list_container2, companyDetailFragment);
                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                }
        });
    }
}
