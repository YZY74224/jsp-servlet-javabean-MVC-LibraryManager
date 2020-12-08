package DataBase;
import Common.druid.DBConnect;

/**
 * 测试druid数据连接池
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author:The King Of the World
 * @Date:2020/12/4
 * @Description:DataBase
 * @version：1.0
 */
public class DataBase{

    public static void main(String[] args) throws SQLException {
        PreparedStatement statement = null;
        Connection conn = null;
        conn = DBConnect.getConnection();
        String sql ="SELECT t.* FROM jwex3.图书信息表 t LIMIT 501";

        statement = conn.prepareCall(sql);
        ResultSet rs = statement.executeQuery();
        while (true)
        {
            if(!rs.next())break;
            String Num ;
            String Name = null;
            String Price;
            String Publisher = null;
            Num = rs.getString("Num");
            Name = rs.getString("Name");
            Price = rs.getString("Price");
            Publisher = rs.getString("Publisher");
            System.out.println(Num + "\t" + Name + "\t" + Price + "\t" + Publisher);
        }
        DBConnect.close(rs,statement,conn);
    }
}
