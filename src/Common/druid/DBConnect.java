package Common.druid;
/**
 * 公共类负责存放如使用druid数据连接池获取数据库连接等的方法
 */

/*druid数据连接池中自定义的功能方法*/
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * @Author:The King Of the World
 * @Date:2020/12/3
 * @Description:druid
 * @version：1.0
 */
public class DBConnect {
    //1.定义成员变量 DataSource
    public static DataSource ds;
    static {
      try{
          //1.加载配置文件
          Properties pro = new Properties();
          pro.load(DBConnect.class.getClassLoader().getResourceAsStream("druid.properties"));
          //2.获取DataSource
          ds = DruidDataSourceFactory.createDataSource(pro);
      }catch (IOException e){
          e.printStackTrace();
      }catch (Exception e){
          e.printStackTrace();
      }

    }
    /**
     * 功能一 获取连接
     */
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    /**
     * 功能二 释放资源(DML情况)
     */
    public static void close(Statement stmt,Connection conn){
        if(stmt!=null)
        {
            try{
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 功能二 释放资源(DQL)
     */
    public static void close(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 功能三 获取连接池
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
