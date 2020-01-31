package com.neu.criminalintent.database.CrimeDbSchema;

public class CrimeDbSchema {
    public static final class CrimeTable {
        //定义描述数据表元素的String常量
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
