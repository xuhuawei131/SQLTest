/*
 * 文 件 名:  Temp.java
 * 修 改 人:  
 * 修改时间:  2014-3-18
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.example.sqltest;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author yq
 * @version [版本号, 2014-3-18]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@DatabaseTable
public class Temp {
    
    @DatabaseField(generatedId = true)
    public int id;
    
    @DatabaseField
    public String name;
    
    @DatabaseField
    public String pwd;

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Temp [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
    }
    
    
}
