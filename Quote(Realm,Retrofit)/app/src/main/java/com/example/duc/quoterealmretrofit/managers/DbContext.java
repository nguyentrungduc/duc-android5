package com.example.duc.quoterealmretrofit.managers;

import android.content.Context;

import com.example.duc.quoterealmretrofit.models.Quote;

import java.util.List;
import java.util.Random;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by DUC on 11/4/2016.
 */

public class DbContext {
    private Realm realm;
    public DbContext(Context context) {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    private static DbContext instance;
    public static DbContext getInstance(){
        return instance;
    }

    public static void init(Context context){
        if(instance == null){
            instance = new DbContext(context);
        }
    }

    public void add(Quote quote){
        realm.beginTransaction();
        realm.copyToRealm(quote);
        realm.commitTransaction();
    }

    public List<Quote> findAllQuote(){
        Realm realm = Realm.getDefaultInstance();

        //3 Query - lazy load
        RealmResults<Quote> quotes =
                realm.where(Quote.class)
                        .findAll();
        return quotes;
    }

    public Quote findQuoteByTitle(String title){
        Realm realm = Realm.getDefaultInstance();

        //3 Query - lazy load
        Quote quote = realm.where(Quote.class).equalTo("title",title, Case.INSENSITIVE)
                .findFirst();
        return quote;
    }

    public void update(Quote quote, String title, String content){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        quote.setTitle(title);
        quote.setContent(content);
        realm.commitTransaction();
    }

    public void delete(Quote quote){

        if(quote == null)  return ;
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        quote.deleteFromRealm();
        realm.beginTransaction();
    }

    public void deleteAll(Class<? extends RealmModel> clazz){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(clazz);
        realm.commitTransaction();

    }

    public int getNextId(Class<? extends RealmModel> clasz, String idKey){
        Number idNumber = realm.where(clasz).max(idKey).intValue()+1;
        if(idNumber == null)  return 1;
        else   return realm.where(clasz).max(idKey).intValue()+1;

    }

    public Quote pickQuoteRandom() {
        RealmResults<Quote> quotes = realm
                .where(Quote.class)
                .findAll();
        Random random = new Random();
        int firtRandomNumber = random.nextInt(quotes.size());
        return quotes.get(firtRandomNumber);
    }

    public long getSize() {
        return realm.where(Quote.class).count();
    }
}
