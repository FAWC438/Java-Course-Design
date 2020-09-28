package homework_大作业_GUI;

public class PricingStrategyFactory {

    /**
     * 单子模式的三个漏洞
     * 1.反射（reflection）机制
     * 2.对象序列化机制
     * 3.clone()函数
     */

    private static final PricingStrategyFactory instance = new PricingStrategyFactory(); // 单子模式

    /**
     * 1.解决反射：利用线程锁判断单子模式对象是否已经实例化
     */
    private static volatile boolean isCreate = false;

    /**
     * 2.解决序列化：添加该方法后，序列化将对对象实行的是浅拷贝而非深拷贝，即仅拷贝其引用，不会引发错误
     *
     * @return 单子的唯一实例
     */
    private Object readResolve() {
        return instance;
    }

    /**
     * 3.重写clone()方法，使其失去原有功能，本质上仍然是阻止深拷贝
     *
     * @return 单子的唯一实例
     * @throws CloneNotSupportedException clone()方法不可用
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }


    /**
     * 单子模式构造方法必须私有
     */
    private PricingStrategyFactory() {
        if (isCreate) {
            throw new RuntimeException("重复实例化");
        }
        isCreate = true;
    }


    /**
     * 重载1：返回降价策略接口
     *
     * @param bookType 书籍类型
     * @return 降价策略
     */
    public IPricingStrategy getPricingStrategy(int bookType) {
        switch (bookType) {
            case 0:
                return new FlatRateStrategy(1);
            case 1:
                return new PercentageStrategy(7);
            case 2:
                return new PercentageStrategy(3);
            default:
                return new NoDiscountStrategy();
        }
    }

    /**
     * 重载2：返回降价策略接口，降价参数自定义
     *
     * @param bookType     书籍类型
     * @param discountPara 降价参数
     * @return 降价策略
     */
    public IPricingStrategy getPricingStrategy(int bookType, double discountPara) {
        switch (bookType) {
            case 0:
                return new FlatRateStrategy(discountPara);
            case 1:
            case 2:
                return new PercentageStrategy((int) discountPara);
            default:
                return new NoDiscountStrategy();
        }
    }

    public static PricingStrategyFactory getInstance() {
        return instance;
    }
}