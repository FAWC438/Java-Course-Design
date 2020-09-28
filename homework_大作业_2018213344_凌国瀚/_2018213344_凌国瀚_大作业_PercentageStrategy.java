package homework_大作业_2018213344_凌国瀚;

public class _2018213344_凌国瀚_大作业_PercentageStrategy implements _2018213344_凌国瀚_大作业_IPricingStrategy {
    private int discountPercentage;

    public _2018213344_凌国瀚_大作业_PercentageStrategy(int DP) {
        setDiscountPercentage(DP);
    }

    @Override
    public double getSubTotal(_2018213344_凌国瀚_大作业_SaleLineItem SLT) {
        if (getDiscountPercentage() >= 100) // 大于等于100的折扣相当于免费
            return 0;
        return SLT.getSubTotal() * (1 - getDiscountPercentage() / 100.0);
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }


}
