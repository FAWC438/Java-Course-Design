package homework_大作业_GUI;

public class FlatRateStrategy implements IPricingStrategy {
    private double discountPerBook;

    public FlatRateStrategy(double DPB) {
        setDiscountPerBook(DPB);
    }

    @Override
    public double getSubTotal(SaleLineItem SLT) {
        double result = SLT.getSubTotal() - getDiscountPerBook() * SLT.getCopies();
        return result < 0 ? 0 : result; // 折后价小于0说明免费
    }

    public double getDiscountPerBook() {
        return discountPerBook;
    }

    public void setDiscountPerBook(double discountPerBook) {
        this.discountPerBook = discountPerBook;
    }

}
