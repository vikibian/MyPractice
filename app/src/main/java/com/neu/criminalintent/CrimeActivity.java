package com.neu.criminalintent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;


//此文件可以删除， 因为已经应用viewPager了
public class CrimeActivity extends SingFragmentActivity{

//    public static final String EXTRA_CRIME_ID = "com.neu.criminalintent.crime_id";
    private static final String EXTRA_CRIME_ID = "com.neu.criminalintent.crime_id";

    @Override
    protected Fragment createFragment() {
//        return new CrimeFragment();
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }

    public static Intent newIntent(Context packageContext, UUID crimeId){
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeId);
        return intent;
    }


}
