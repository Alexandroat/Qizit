package com.example.alex.qizit;

import android.provider.BaseColumns;

/**
 * Created by alex on 30/01/15.
 */
public class ContactDBContract {
    public ContactDBContract() {
    }

    public static abstract class ContactEntry implements BaseColumns {
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_MAIL = "email";
        public static final String TABLE_NAME = "CONTACTS";
    }
}
