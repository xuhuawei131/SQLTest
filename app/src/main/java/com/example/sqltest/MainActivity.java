package com.example.sqltest;

import java.util.List;

import net.sqlcipher.database.SQLiteDatabase;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class MainActivity extends Activity {
    
    DBHelper mDBHelper;
    RuntimeExceptionDao<Temp, Integer> mTemp;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase.loadLibs(this);
        mDBHelper = OpenHelperManager.getHelper(this, DBHelper.class);
        mTemp = mDBHelper.getRuntimeExceptionDao(Temp.class);
        
        findViewById(R.id.add_data).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Temp mtep = new Temp();
                mtep.name = "aaaaa";
                mtep.pwd = "bbbb";
                mTemp.create(mtep);
            }
        });
        
        findViewById(R.id.query_data).setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                try {
                    List<Temp> list = mTemp.queryForAll();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("temp->" + list.get(i));
                    }
                }
                catch (Exception e) {
                }
                
            }
        });
    }
}
