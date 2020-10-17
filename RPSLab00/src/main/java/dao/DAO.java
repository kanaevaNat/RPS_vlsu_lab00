package dao;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public abstract class DAO{
    protected DataSource ds = new MysqlDataSource();
    protected String user = "root";
    protected String password = "narutotigde521";
}
