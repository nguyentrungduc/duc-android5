package com.example.duc.dailyquote.models;

import android.support.v4.app.Fragment;
import com.example.duc.dailyquote.fragments.QuoteFragment;

/**
 * Created by DUC on 10/19/2016.
 */

public class FragmentEvent{
    private Fragment fragment;
    private boolean addtoBackStack;


    public FragmentEvent(Fragment fragment, boolean addtoBackStack) {
        this.fragment = fragment;
        this.addtoBackStack = addtoBackStack;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public boolean isAddtoBackStack() {
        return addtoBackStack;
    }

    public void setAddtoBackStack(boolean addtoBackStack) {
        this.addtoBackStack = addtoBackStack;
    }
}
