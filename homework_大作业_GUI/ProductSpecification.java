package homework_大作业_GUI;

public class ProductSpecification {
    private String isbn;
    private double price;
    private String title;
    private int type;

    /**
     * 书籍描述信息类构造函数
     * 共有4种类型的书，其中
     * 0：教材类图书；
     * 1：连环画类图书；
     * 2：非教材类的计算机图书；
     * 3：其他类图书
     *
     * @param isbn  ISBN号码
     * @param price 单本书价格
     * @param title 书名
     * @param type  书籍类型
     */
    public ProductSpecification(String isbn, double price, String title, int type) {
        setIsbn(isbn);
        setPrice(price);
        setTitle(title);
        setType(type);
    }

    public String getTypeString() {
        String[] arr = {"教材类图书", "连环画类图书", "非教材类的计算机图书", "其他类图书"};
        return arr[getType()];
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
