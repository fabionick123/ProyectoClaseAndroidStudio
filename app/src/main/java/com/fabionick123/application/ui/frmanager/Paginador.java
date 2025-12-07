package com.fabionick123.application.ui.frmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fabionick123.application.mainfr.tarjetas1;
import com.fabionick123.application.mainfr.tarjetas2;


public class Paginador extends FragmentPagerAdapter {

    public Paginador(Context context, FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new tarjetas1();
            case 1:
                return new tarjetas2();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
