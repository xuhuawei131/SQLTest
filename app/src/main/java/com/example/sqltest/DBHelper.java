package com.example.sqltest;

import java.io.File;
import java.sql.SQLException;

import net.sqlcipher.database.SQLiteDatabase;
import android.content.Context;
import android.os.Environment;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DBHelper extends OrmLiteSqliteOpenHelper {
    public static final String TAG = "DBHelper";
    public static final int VERSION = 1;
    private static String DB_NAME = "abs.db";
    private static String KEY = "cst2008";
    
    Context mContext;
    
    Class<?>[] tableClasss = new Class<?>[] {Temp.class};
    
    public DBHelper(Context context) {
        super(context, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator
            + context.getPackageName() + File.separator + DB_NAME, null, VERSION, KEY);
        mContext = context;
    }
    
    @Override
    public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
        
        try {
            for (int i = 0; i < tableClasss.length; i++) {
                TableUtils.createTable(arg1, tableClasss[i]);
            }
        }
        catch (SQLException e) {
        }
    }
    
    @Override
    public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2, int arg3) {
        try {
            
            for (Class<?> cls : tableClasss) {
                TableUtils.dropTable(arg1, cls, true);
            }
            
            onCreate(arg0, arg1);
        }
        catch (SQLException e) {
        }
    }
    
    @Override
    public void close() {
        super.close();
    }
    
}
