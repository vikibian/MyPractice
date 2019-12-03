package com.neu.criminalintent;

import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTite;

    public Crime(){
        //Generate unique identifier
        mId = UUID.randomUUID();

    }

    public UUID getId(){
        return mId;
    }
}
