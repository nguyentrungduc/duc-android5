package com.example.duc.ss18.managers;

import android.content.Context;

import com.example.duc.ss18.models.Dog;
import com.example.duc.ss18.models.Person;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by DUC on 11/2/2016.
 */

public class DbContext  {
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

    public void add(Person p){
        //2 Get Realm defaul
        Realm realm = Realm.getDefaultInstance(); // singleton
        //4 Add object to realm (managed object)
        realm.beginTransaction();
        realm.copyToRealm(p);
        realm.commitTransaction();
    }

    public List<Person> findAllPerson(){
        Realm realm = Realm.getDefaultInstance();

        //3 Query - lazy load
        RealmResults<Person> persons =
                realm.where(Person.class)
                        .findAll();
        return persons;
    }

    public Person findPersonByName(String name){
        Realm realm = Realm.getDefaultInstance();

        //3 Query - lazy load
        Person person = realm.where(Person.class).equalTo("name",name, Case.INSENSITIVE)
                .findFirst();
        return person;
    }

    public void update(Person person, String name, int age){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        person.setAge(age);
        person.setName(name);
        realm.commitTransaction();
    }

    public void delete(Person person){

        if(person == null)  return ;
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        person.deleteFromRealm();
        realm.beginTransaction();
    }

    public void deleteAll(Class<? extends RealmModel> clazz){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(clazz);
        realm.commitTransaction();

    }

    public int getNextId(Class<? extends  RealmModel> clasz,String idKey){
        Number idNumber = realm.where(clasz).max(idKey).intValue()+1;
        if(idNumber == null)  return 1;
        else   return realm.where(clasz).max(idKey).intValue()+1;

    }
    // ===========================dog===========================//
    public void add(Dog dog){

        realm.beginTransaction();
        realm.copyToRealm(dog);
        realm.commitTransaction();

    }

    public void addDogToPerson(Person person, Dog dog){
        realm.beginTransaction();
        person.getDogs().add(dog);
        realm.commitTransaction();
    }


}
