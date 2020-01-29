package com.neu.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab getInstance(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return  sCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();

        //由于下面的addCrime可以自动添加Crime了所以就不需要自己生成了
//        for (int i=0;i<100;i++){
//            Crime crime = new Crime();
//            crime.setmTitle("Crime #" + i);
//            crime.setmSolved(i%2 == 0);
//            mCrimes.add(crime);
//        }
    }

    public void addCrime(Crime c){
        mCrimes.add(c);
    }

    public List<Crime> getmCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID uuid){
        for (Crime crime: mCrimes){
            if (crime.getId().equals(uuid)){
                return crime;
            }
        }
        return null;
    }
}
