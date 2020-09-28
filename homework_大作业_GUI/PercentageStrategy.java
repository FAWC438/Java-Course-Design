package homework_大作业_GUI;

public class PercentageStrategy implements IPricingStrategy {
    private int discountPercentage;

    public PercentageStrategy(int DP) {
        setDiscountPercentage(DP);
    }

    @Override
    public double getSubTotal(SaleLineItem SLT) {
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
