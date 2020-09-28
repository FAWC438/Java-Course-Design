package homework_5_GUI;

public class CommissionEmployee extends Employee {
    private double _grossSales;
    private double _commissionRate;

    public CommissionEmployee(String Name,
                              String socialSecurityNumber, double grossSales, double commissionRate) {
        super(Name, socialSecurityNumber);
        _grossSales = grossSales;
        _commissionRate = commissionRate;
        set_Type("提成雇员");
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