package homework_3;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double _baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName,
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
