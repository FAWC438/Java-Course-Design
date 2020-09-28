package homework_4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Factory factory = new Factory();
        int code;
        Employee target;
        String SN;
        while (sc.hasNext()) {
            String command = sc.next();
            switch (command) {
                case "init":
                    code = sc.nextInt();
                    if (code != -1) {
                        switch (code) {
                            case 0:
                                SalariedEmployee se = new SalariedEmployee(sc.next(), sc.next(),
                                        sc.next(), sc.nextDouble());
                                factory.initEmployees(se);
                                break;
                            case 1:
                                HourlyEmployee he = new HourlyEmployee(sc.next(), sc.next(),
                                        sc.next(), sc.nextDouble(), sc.nextInt());
                                factory.initEmployees(he);
                                break;
                            case 2:
                                CommissionEmployee ce = new CommissionEmployee(sc.next(), sc.next(),
                                        sc.next(), sc.nextDouble(), sc.nextDouble());
                                factory.initEmployees(ce);
                                break;
                            default:
                                BasePlusCommissionEmployee bpce = new BasePlusCommissionEmployee(sc.next(), sc.next(),
                                        sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                                factory.initEmployees(bpce);
                                break;
                        }
                    }
                    break;
                case "add":
                    code = sc.nextInt();
                    switch (code) {
                        case 0:
                            SalariedEmployee se = new SalariedEmployee(sc.next(), sc.next(),
                                    sc.next(), sc.nextDouble());
                            target = factory.addEmployee(se);
                            break;
                        case 1:
                            HourlyEmployee he = new HourlyEmployee(sc.next(), sc.next(),
                                    sc.next(), sc.nextDouble(), sc.nextInt());
                            target = factory.addEmployee(he);
                            break;
                        case 2:
                            CommissionEmployee ce = new CommissionEmployee(sc.next(), sc.next(),
                                    sc.next(), sc.nextDouble(), sc.nextDouble());
                            target = factory.addEmployee(ce);
                            break;
                        default:
                            BasePlusCommissionEmployee bpce = new BasePlusCommissionEmployee(sc.next(), sc.next(),
                                    sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                            target = factory.addEmployee(bpce);
                            break;
                    }
                    if (target == null) {
                        System.out.println("add: employee exists.");
                    } else {
                        System.out.println(target.toString());
                    }
                    break;
                case "update":
                    code = sc.nextInt();
                    switch (code) {
                        case 0:
                            SalariedEmployee se = new SalariedEmployee(sc.next(), sc.next(),
                                    sc.next(), sc.nextDouble());
                            target = factory.updateEmployee(se.get_socialSecurityNumber(), se);
                            break;
                        case 1:
                            HourlyEmployee he = new HourlyEmployee(sc.next(), sc.next(),
                                    sc.next(), sc.nextDouble(), sc.nextInt());
                            target = factory.updateEmployee(he.get_socialSecurityNumber(), he);
                            break;
                        case 2:
                            CommissionEmployee ce = new CommissionEmployee(sc.next(), sc.next(),
                                    sc.next(), sc.nextDouble(), sc.nextDouble());
                            target = factory.updateEmployee(ce.get_socialSecurityNumber(), ce);
                            break;
                        default:
                            BasePlusCommissionEmployee bpce = new BasePlusCommissionEmployee(sc.next(), sc.next(),
                                    sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
                            target = factory.updateEmployee(bpce.get_socialSecurityNumber(), bpce);
                            break;
                    }
                    if (target == null) {
                        System.out.println("update: employee not found.");
                    } else {
                        System.out.println(target.toString());
                    }
                    break;
                case "get":
                    SN = sc.next();
                    target = factory.getEmployee(SN);
                    if (target == null) {
                        System.out.println("get: employee not found.");
                    } else {
                        System.out.println(target.toString());
                    }
                    break;
                case "delete":
                    SN = sc.next();
                    target = factory.deleteEmployee(SN);
                    if (target == null) {
                        System.out.println("delete: employee not found.");
                    } else {
                        System.out.println(target.toString());
                    }
                    break;
                case "print":
                    factory.printEmployees();
                    break;
            }
        }

        sc.close();
    }
}












