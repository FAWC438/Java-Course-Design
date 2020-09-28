package homework_3_2018213344_凌国瀚;

import java.util.*;

public class _2018213344_凌国瀚_3_Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int code = sc.nextInt();
            switch (code) {
                case 0:
                    _2018213344_凌国瀚_3_SalariedEmployee se = new _2018213344_凌国瀚_3_SalariedEmployee(sc.next(), sc.next(),
                            sc.next(), sc.nextDouble());
                    System.out.println(se.toString());
                    break;
                case 1:
                    _2018213344_凌国瀚_3_HourlyEmployee he = new _2018213344_凌国瀚_3_HourlyEmployee(sc.next(), sc.next(),
                            sc.next(), sc.nextDouble(), sc.nextInt());
                    System.out.println(he.toString());
                    break;
                case 2:
                    _2018213344_凌国瀚_3_CommissionEmployee ce = new _2018213344_凌国瀚_3_CommissionEmployee(sc.next(), sc.next(),
                            sc.next(), sc.nextDouble(), sc.nextDouble());
                    System.out.println(ce.toString());
                    break;
                default:
                    _2018213344_凌国瀚_3_BasePlusCommissionEmployee bpce = new _2018213344_凌国瀚_3_BasePlusCommissionEmployee(sc.next(), sc.next(),
                            sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                    System.out.println(bpce.toString());
                    break;
            }
        }
        sc.close();
    }
}









