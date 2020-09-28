package homework_大作业_2018213344_凌国瀚;

public class _2018213344_凌国瀚_大作业_FlatRateStrategy implements _2018213344_凌国瀚_大作业_IPricingStrategy {
    private double discountPerBook;

    public _2018213344_凌国瀚_大作业_FlatRateStrategy(double DPB) {
        setDiscountPerBook(DPB);
    }

    @Override
    public double getSubTotal(_2018213344_凌国瀚_大作业_SaleLineItem SLT) {
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
