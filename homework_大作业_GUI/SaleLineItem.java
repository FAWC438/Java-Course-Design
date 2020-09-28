package homework_大作业_GUI;

public class SaleLineItem {

    private int copies;
    private final ProductSpecification prodSpec; // 书籍属性
    private final IPricingStrategy strategy;

    /**
     * 重载1：SaleLineItem代表一个销售项目，即抽象地代表同一个类型的书的集合，该重载可供直接计算题目用例
     *
     * @param bookNum 书籍数量
     * @param PS      书籍描述信息
     */
    public SaleLineItem(int bookNum, ProductSpecification PS) {
        this.prodSpec = PS;
        setCopies(bookNum);
        this.strategy = PricingStrategyFactory.getInstance().getPricingStrategy(getProdSpec().getType());
    }

    /**
     * 重载2：创建SaleLineItem实例的初始函数，使其能够处理变化的优惠参数
     *
     * @param bookNum      书籍数量
     * @param discountPara 优惠参数
     * @param PS           书籍描述信息
     */
    public SaleLineItem(int bookNum, double discountPara, ProductSpecification PS) {
        this.prodSpec = PS;
        setCopies(bookNum);
        this.strategy = PricingStrategyFactory.getInstance().getPricingStrategy(getProdSpec().getType(), discountPara);
    }

    /**
     * 与接口所抽象的同名函数不同的是，该方法返回的是未执行降价策略的价格
     *
     * @return 未执行降价策略的该种书的总价格
     */
    public double getSubTotal() {
        return getCopies() * getProdSpec().getPrice();
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public ProductSpecification getProdSpec() {
        return prodSpec;
    }

    public IPricingStrategy getStrategy() {
        return strategy;
    }
}
