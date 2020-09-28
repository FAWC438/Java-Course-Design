package homework_4_2018213344_凌国瀚;

public class _2018213344_凌国瀚_4_BasePlusCommissionEmployee extends _2018213344_凌国瀚_4_CommissionEmployee {
    private double _baseSalary;

    public _2018213344_凌国瀚_4_BasePlusCommissionEmployee(String firstName, String lastName,
                                                        String socialSecurityNumber, double grossSales,
                                                        double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        _baseSalary = baseSalary;
    }

    public double get_baseSalary() {
        return _baseSalary;
    }

    public void set_baseSalary(double _baseSalary) {
        this._baseSalary = _baseSalary;
    }

    @Override
    public double earning() {
        return get_grossSales() * get_commissionRate() + get_baseSalary();
    }
}
