package com.example.duc.ss18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.duc.ss18.jsonmodels.Repo;
import com.example.duc.ss18.managers.DbContext;
import com.example.duc.ss18.models.Dog;
import com.example.duc.ss18.models.Person;
import com.example.duc.ss18.network.GitHubService;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private DbContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit gitHubRetrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();// sinh ra service

        GitHubService gitHubService = gitHubRetrofit.create(GitHubService.class);

        gitHubService
                .listRepo("nguyentrungduc")
                .enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        Log.d(TAG,"onResponse");
                        List<Repo> repoList = response.body();
                        for(Repo repo : repoList){
                            Log.d(TAG, repo.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {
                        Log.d(TAG,"onFailure");
                    }
                });




        // 1 Inittilize realm
 //       Realm.init(this);
        //2 Get Realm defaul
     //   Realm realm = Realm.getDefaultInstance(); // singleton
        //3 Creat unmanaged object
//        Person p = Person.create("M", 20);
        //4 Add object to realm (managed object)
//        realm.beginTransaction();
//        realm.copyToRealm(p);
//        realm.commitTransaction();
//        add(p);
//
//        //3 Query - lazy load
//        RealmResults<Person> persons =
//                realm.where(Person.class).equalTo("name","Duc")
//                        .findAll();
//        Log.d(TAG, String.format("%s", persons.size()));
//        //4 Iterate
//        for(Person person : persons){
//            Log.d(TAG, person.toString());


//        }

//        Realm realm = Realm.getDefaultInstance();
//        Person M = findPersonByName("M");
//        if(M != null){
//            realm.beginTransaction();
//            M.deleteFromRealm();
//            realm.commitTransaction();
//        }
//        for(Person p :findAllPerson()){
//            Log.d(TAG,p.toString());
//        }
//        add(Person.create("Hau", 20));
//        add(Person.create("Thanh", 20));
//
//        Log.d(TAG, String.format("", findAllPerson().size()));
//        realm.beginTransaction();
//        realm.delete(Person.class);
//        realm.commitTransaction();
//        Log.d(TAG, String.format("", findAllPerson().size()));
//        DbContext.init(this);
//        dbContext = DbContext.getInstance();
//        Person m = dbContext.findPersonByName("M");
//        Dog dog = Dog.create("Alaska","Joel");
//        dbContext.add(dog);
//        m.getDogs().add(dog);
//        int personId = dbContext.getNextId(Person.class," id");
//        dbContext.add(Person.create(personId,"M", 20));
//        for(Person p : dbContext.findAllPerson()){
//            Log.d(TAG,p.toString());
//        }

    }

//    public void add(Person p){
//        //2 Get Realm defaul
//        Realm realm = Realm.getDefaultInstance(); // singleton
//        //4 Add object to realm (managed object)
//        realm.beginTransaction();
//        realm.copyToRealm(p);
//        realm.commitTransaction();
//    }
//
//    public List<Person> findAllPerson(){
//        Realm realm = Realm.getDefaultInstance();
//
//        //3 Query - lazy load
//        RealmResults<Person> persons =
//                realm.where(Person.class)
//                        .findAll();
//        return persons;
//    }
//
//    public Person findPersonByName(String name){
//        Realm realm = Realm.getDefaultInstance();
//
//        //3 Query - lazy load
//        Person person = realm.where(Person.class).equalTo("name",name, Case.INSENSITIVE)
//                        .findFirst();
//        return person;
//    }
//
//    public void update(Person person, String name, int age){
//        Realm realm = Realm.getDefaultInstance();
//
//        realm.beginTransaction();
//        person.setAge(age);
//        person.setName(name);
//        realm.commitTransaction();
//    }
//
//    public void delete(Person person){
//
//        if(person == null)  return ;
//        Realm realm = Realm.getDefaultInstance();
//
//        realm.beginTransaction();
//        person.deleteFromRealm();
//        realm.beginTransaction();
//    }
//
//    public void deleteAll(Class<? extends RealmModel> clazz){
//        Realm realm = Realm.getDefaultInstance();
//        realm.beginTransaction();
//        realm.delete(clazz);
//        realm.commitTransaction();
//
//    }


}
