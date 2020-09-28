package homework_3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int code = sc.nextInt();
            switch (code) {
                case 0:
                    SalariedEmployee se = new SalariedEmployee(sc.next(), sc.next(),
                            sc.next(), sc.nextDouble());
                    System.out.println(se.toString());
                    break;
                case 1:
                    HourlyEmployee he = new HourlyEmployee(sc.next(), sc.next(),
                            sc.next(), sc.nextDouble(), sc.nextInt());
                    System.out.println(he.toString());
                    break;
                case 2:
                    CommissionEmployee ce = new CommissionEmployee(sc.next(), sc.next(),
                            sc.next(), sc.nextDouble(), sc.nextDouble());
                    System.out.println(ce.toString());
                    break;
                default:
                    BasePlusCommissionEmployee bpce = new BasePlusCommissionEmployee(sc.next(), sc.next(),
                            sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                    System.out.println(bpce.toString());
                    break;
            }
        }
        sc.close();
    }
}









