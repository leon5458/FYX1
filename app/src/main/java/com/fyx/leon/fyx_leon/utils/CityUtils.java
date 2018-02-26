package com.fyx.leon.fyx_leon.utils;
import android.content.Context;

import com.fyx.leon.fyx_leon.ui.R;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.ArrayList;
public class CityUtils {

    private CityUtils() {
    }

    public static CityUtils getInstance() {
        return new CityUtils();
    }


    ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> read(Context context) {
        contacts.clear();
        try {
            //将json文件读取到buffer数组中
            InputStream is = context.getResources().openRawResource(R.raw.allcity);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            //将字节数组转换为以UTF-8编码的字符串
            String json = new String(buffer, "UTF-8");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("City");
            JSONObject obj = array.getJSONObject(0);
            char a;
            for (int i = 0; i < 26; i++) {
                a = (char) ('A' + i);
                if (a == 'U' || a == 'V' || a == 'I' || a == 'O')
                    continue;
                resolve(obj, String.valueOf(a));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contacts;
    }

    private void resolve(JSONObject obj, String key) {
        try {

            JSONArray arr = obj.getJSONArray(key);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject name = arr.getJSONObject(i);
                Contact contact = new Contact(key, name.getString("name"));
                contacts.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
