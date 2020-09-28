package homework_5_GUI;

public class _2018213344_5_BasePlusCommissionEmployee extends _2018213344_5_CommissionEmployee {
    private double _baseSalary;

    public _2018213344_5_BasePlusCommissionEmployee(String Name,
                                                    String socialSecurityNumber, double grossSales,
                                                    double commissionRate, double baseSalary) {
        super(Name, socialSecurityNumber, grossSales, commissionRate);
        _baseSalary = baseSalary;
        set_Type("基本+提成雇员");
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
