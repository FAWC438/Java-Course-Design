package homework_大作业_GUI;

public class NoDiscountStrategy implements IPricingStrategy {

    @Override
    public double getSubTotal(SaleLineItem SLT) {
        return SLT.getSubTotal();
    }
}
