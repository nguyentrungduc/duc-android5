package com.example.duc.homework4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUC on 9/22/2016.
 */
public class Company implements Serializable {
    private String name;
    private String phonenb;
    private String website;

    private static List<Company> listCompany;

    public static synchronized List<Company> getListCompany(){
        if(listCompany == null){
            listCompany = new ArrayList<>();
            listCompany.add(new Company("FPT Software", "0473007575", "https://www.fpt-software.com"
            ));
            listCompany.add(new Company("EWay", "+84432595450", "https://eway.vn"));
            listCompany.add(new Company("KMS", "+84838486888", "http://www.kms-technology.com"
            ));
            listCompany.add(new Company("BraveBits", " +84463260066", "http://www.bravebits.vn"
            ));
            listCompany.add(new Company("TechKids", "+841653005670", "http://techkids.vn"));
        }
        return listCompany;
    }


    public Company(String name, String phonenb, String website) {
        this.name = name;
        this.phonenb = phonenb;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenb() {
        return phonenb;
    }

    public void setPhonenb(String phonenb) {
        this.phonenb = phonenb;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString(){
        return this.getName();
    }


}
