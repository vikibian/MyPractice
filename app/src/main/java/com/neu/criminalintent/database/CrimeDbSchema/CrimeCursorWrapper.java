package com.neu.criminalintent.database.CrimeDbSchema;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.neu.criminalintent.Crime;
import com.neu.criminalintent.CrimeLab;

import java.util.Date;
import java.util.UUID;

import static com.neu.criminalintent.database.CrimeDbSchema.CrimeDbSchema.*;

public class CrimeCursorWrapper extends CursorWrapper {

    //创建了Corsor的封装类，该类继承了Cursor类的全部方法
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setmTitle(title);
        crime.setmDate(new Date(date));
        crime.setmSolved(isSolved != 0);

        return crime;
    }
}
