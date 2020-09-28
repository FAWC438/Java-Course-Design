package homework_大作业_GUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // 以下代码使用控制台测试题目要求样例

//        ArrayList<_2018213344_凌国瀚_大作业_SaleLineItem> SLArr = new ArrayList<>();
//
//        _2018213344_凌国瀚_大作业_ProductSpecification UML_APP = new _2018213344_凌国瀚_大作业_ProductSpecification("111", 18, "UML与模式应用", 0);
//        _2018213344_凌国瀚_大作业_ProductSpecification Java_MODE = new _2018213344_凌国瀚_大作业_ProductSpecification("222", 34, "Java与模式", 2);
//        _2018213344_凌国瀚_大作业_ProductSpecification HeadFirst = new _2018213344_凌国瀚_大作业_ProductSpecification("333", 58, "HeadFirst 设计模式", 2);
//        _2018213344_凌国瀚_大作业_ProductSpecification Alice = new _2018213344_凌国瀚_大作业_ProductSpecification("444", 30, "爱丽丝历险记", 1);
//        _2018213344_凌国瀚_大作业_ProductSpecification Soup = new _2018213344_凌国瀚_大作业_ProductSpecification("555", 20, "煲汤大全", 3);
//
//        SLArr.add(new _2018213344_凌国瀚_大作业_SaleLineItem(2, UML_APP));
//        SLArr.add(new _2018213344_凌国瀚_大作业_SaleLineItem(2, Java_MODE));
//        SLArr.add(new _2018213344_凌国瀚_大作业_SaleLineItem(1, HeadFirst));
//        SLArr.add(new _2018213344_凌国瀚_大作业_SaleLineItem(3, Alice));
//        SLArr.add(new _2018213344_凌国瀚_大作业_SaleLineItem(1, Soup));
//
//        _2018213344_凌国瀚_大作业_Sale saleAction = new _2018213344_凌国瀚_大作业_Sale(SLArr);
//        System.out.println(saleAction.getTotal());

        // 以下代码运行GUI模式

        GUI form = new GUI();
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setResizable(false);
        form.setTitle("面向对象程序设计实践(java)");

        form.pack();
        form.setVisible(true);
    }
}
