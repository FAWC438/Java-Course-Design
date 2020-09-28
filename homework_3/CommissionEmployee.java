package homework_3;

public class CommissionEmployee extends Employee {
    private double _grossSales;
    private double _commissionRate;

    public CommissionEmployee(String firstName, String lastName,
                              String socialSecurityNumber, double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);
        _grossSales = grossSales;
        _commissionRate = commissionRate;
    }

    public double get_grossSales() {
        return _grossSales;
    }

    public void set_grossSales(double _grossSales) {
        this._grossSales = _grossSales;
    }

    public double get_commissionRate() {
        return _commissionRate;
    }

    public void set_commissionRate(double _commissionRate) {
        this._commissionRate = _commissionRate;
    }

    @Override
    public double earning() {
        return get_grossSales() * get_commissionRate();
    }
}
