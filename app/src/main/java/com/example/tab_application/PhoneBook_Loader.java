package com.example.tab_application;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class PhoneBook_Loader {
    public static ArrayList<PhoneBook> getData(Context context){
        ArrayList<PhoneBook> phoneBooks = new ArrayList<PhoneBook>();

        ContentResolver resolver = context.getContentResolver();

        Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String proj[] = {ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER};

        // 컨텐트 리졸버로 데이터 가져오기. 가져온 형태 -> 커서
        Cursor cursor = resolver.query(phoneUri, proj, null, null, null);

        // cursor에 데이터 존재여부
        if(cursor != null ){
            while (cursor.moveToNext()){
                int index = cursor.getColumnIndex(proj[0]);
                int id = cursor.getInt(index);

                index = cursor.getColumnIndex(proj[1]);
                String name = cursor.getString(index);

                index = cursor.getColumnIndex(proj[2]);
                String tel = cursor.getString(index);

                PhoneBook data = new PhoneBook(name, tel);

                phoneBooks.add(data);  // 위에 정의한 데이터 저장소에 add
                // datas에 열 하나하나 단위의 데이터 클래스가 저장됨 -> 주소록만큼 datas의 개수가 생성됨.
            }
        }
        cursor.close(); // 닫지 않으면 계속 열려있음.
        //

        return phoneBooks;
    }
}
