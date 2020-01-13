package com.neu.criminalintent;

import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTite;

    public Crime(){
        //Generate unique identifier
        mId = UUID.randomUUID();

    }

    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }

    public String getmTite() {
        return mTite;
    }

    public void setmTite(String mTite) {
        this.mTite = mTite;
    }

    public UUID getId(){
        return mId;
    }
}
