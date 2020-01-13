package com.neu.criminalintent;

import androidx.fragment.app.Fragment;

public class CrimeListActivity extends SingFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
