package homework_大作业_2018213344_凌国瀚;

import java.util.ArrayList;

public class _2018213344_凌国瀚_大作业_Sale {
    private ArrayList<_2018213344_凌国瀚_大作业_SaleLineItem> items;

    public _2018213344_凌国瀚_大作业_Sale(ArrayList<_2018213344_凌国瀚_大作业_SaleLineItem> items) {
        setItems(items);
    }

    public double getTotal() {
        double sum = 0;
        for (_2018213344_凌国瀚_大作业_SaleLineItem SI : getItems()) {
            sum += SI.getStrategy().getSubTotal(SI);
        }
        return (double) (Math.round(sum * 100)) / 100;  // 四舍五入到小数点后2位
    }

    public double getPreTotal() {
        double sum = 0;
        for (_2018213344_凌国瀚_大作业_SaleLineItem SI : getItems()) {
            sum += SI.getSubTotal();
        }
        return (double) (Math.round(sum * 100)) / 100;  // 四舍五入到小数点后2位
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (_2018213344_凌国瀚_大作业_SaleLineItem SI : getItems()) {
            sb.append("书名：").append(SI.getProdSpec().getTitle());
            sb.append("\nISBN：").append(SI.getProdSpec().getIsbn());
            sb.append("\n单价：").append(SI.getProdSpec().getPrice());
            sb.append("\n类型：").append(SI.getProdSpec().getTypeString());
            sb.append("\n数量：").append(SI.getCopies());
            sb.append("\n\n");
        }

        return sb.toString();
    }

    public ArrayList<_2018213344_凌国瀚_大作业_SaleLineItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<_2018213344_凌国瀚_大作业_SaleLineItem> items) {
        this.items = items;
    }
}
