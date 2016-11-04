package com.example.duc.ss18.models;

import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * Created by DUC on 11/2/2016.
 */

public class Dog extends RealmObject {
    private String breed;
    private String name;

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static  Dog create(String breed, String name){
        Dog dog = new Dog();
        dog.setBreed(breed);
        dog.setName(name);
        return dog;
    }
}
