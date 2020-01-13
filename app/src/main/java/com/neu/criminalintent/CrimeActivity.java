package com.neu.criminalintent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class CrimeActivity extends SingFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }


}
