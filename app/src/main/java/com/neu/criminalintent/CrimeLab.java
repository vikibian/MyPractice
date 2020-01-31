package com.neu.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.neu.criminalintent.database.CrimeDbSchema.CrimeBaseHelper;
import com.neu.criminalintent.database.CrimeDbSchema.CrimeCursorWrapper;
import com.neu.criminalintent.database.CrimeDbSchema.CrimeDbSchema;
import com.neu.criminalintent.database.CrimeDbSchema.CrimeDbSchema.CrimeTable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

//    private List<Crime> mCrimes; 使用数据库
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CrimeLab getInstance(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return  sCrimeLab;
    }

    private CrimeLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
//        mCrimes = new ArrayList<>(); 使用数据库

        //由于下面的addCrime可以自动添加Crime了所以就不需要自己生成了
//        for (int i=0;i<100;i++){
//            Crime crime = new Crime();
//            crime.setmTitle("Crime #" + i);
//            crime.setmSolved(i%2 == 0);
//            mCrimes.add(crime);
//        }
    }

    public void addCrime(Crime c){
//        mCrimes.add(c); 使用数据库
        ContentValues values = getContentValues(c);

        mDatabase.insert(CrimeTable.NAME, null, values);
    }

    public List<Crime> getmCrimes(){
//        return mCrimes; 使用数据库
//        return new ArrayList<>();
        List<Crime> crimes = new ArrayList<>();

        CrimeCursorWrapper cursor = queryCrimes(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                crimes.add(cursor.getCrime());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }

        return crimes;
    }

    public Crime getCrime(UUID uuid){
//        for (Crime crime: mCrimes){  使用数据库
//            if (crime.getId().equals(uuid)){
//                return crime;
//            }
//        }
//        return null;
        CrimeCursorWrapper cursor = queryCrimes(CrimeTable.Cols.UUID + " = ?",
                new String[] {uuid.toString()});

        try {
            if (cursor.getCount() == 0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getCrime();
        }finally {
            cursor.close();
        }
    }

    public File getPhotoFile(Crime crime){
        File externalFileDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalFileDir == null){
            return null;
        }

        return new File(externalFileDir, crime.getPhotoFilename());
    }

    public void updateCrime(Crime crime) {
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);

        mDatabase.update(CrimeTable.NAME, values,
                CrimeTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    private static ContentValues getContentValues(Crime crime){
        ContentValues values = new ContentValues();
        values.put(CrimeTable.Cols.UUID, crime.getId().toString());
        values.put(CrimeTable.Cols.TITLE, crime.getmTitle());
        values.put(CrimeTable.Cols.DATE, crime.getmDate().getTime());
        values.put(CrimeTable.Cols.SOLVED, crime.ismSolved()?1:0);
        values.put(CrimeTable.Cols.SUSPECT, crime.getmSuspect());

        return values;
    }

    private CrimeCursorWrapper queryCrimes(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                CrimeTable.NAME,
                null,//Columns - null selects all columns
                whereClause,
                whereArgs,
                null,//groupBy
                null,//having
                null//orderBy
        );
        return new CrimeCursorWrapper(cursor);
    }

}
