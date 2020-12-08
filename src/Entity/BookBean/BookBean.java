package Entity.BookBean;
/*数据实体类*/
/**
 * @Author:The King Of the World
 * @Date:2020/12/3
 * @Description:BookBean
 * @version：1.0
 */

/**
 * Book的实体类采用JavaBean的风格来定义
 */
public class BookBean {
    //图书编号
    private String num;
    //图书名字
    private String name;
    //图书价格
    private String price;
    //图书出版社
    private String publisher;


    //num的get/set方法
    public String getNum()
    {
        return num;
    }
    public void setNum(String num)
    {
        this.num = num;
    }

    //name的get/set方法
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    //price的get/set方法
    public String getPrice()
    {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    //publisher的get/set方法
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
