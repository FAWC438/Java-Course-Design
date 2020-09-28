package homework_大作业_2018213344_凌国瀚;

public class _2018213344_凌国瀚_大作业_NoDiscountStrategy implements _2018213344_凌国瀚_大作业_IPricingStrategy {

    @Override
    public double getSubTotal(_2018213344_凌国瀚_大作业_SaleLineItem SLT) {
        return SLT.getSubTotal();
    }
}
