package com.zcd.mapper.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @program: jack
 * @description:
 * @author: xn086532
 * @create: 2018-12-07 15:27
 **/
public class DynamicDataSource  extends AbstractRoutingDataSource {

    private static  ThreadLocal<String> DATASOURCE_CONTEXT=new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        String key=getDataSourceContext();
        if(key==null){
            setDataSourceContext(DataSourceEnum.MASTER.getDbName());
        }
        return null;
    }

    private void setDataSourceContext(String dbName) {
        DATASOURCE_CONTEXT.set(dbName);
    }

    private String getDataSourceContext() {

      return   DATASOURCE_CONTEXT.get();

    }


}
