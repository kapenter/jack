package com.zcd.mapper.common;

import lombok.Data;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-11 10:46
 **/
public enum  DataSourceEnum {
    //主库
    MASTER("masterDataSource",true) ,
    SLAVE("slaveDataSource",false);
    //数据源名称
    private  String dbName;

    //是否是主库
    private boolean master;

    DataSourceEnum(String dbName, boolean master) {
        this.dbName = dbName;
        this.master = master;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }
}
