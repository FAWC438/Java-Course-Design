package homework_4_2018213344_凌国瀚;

public class _2018213344_凌国瀚_4_SalariedEmployee extends _2018213344_凌国瀚_4_Employee {
    private double _weeklySalary;

    public _2018213344_凌国瀚_4_SalariedEmployee(String firstName, String lastName,
                                              String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        _weeklySalary = weeklySalary;
    }

    public double get_weeklySalary() {
        return _weeklySalary;
    }

    public void set_weeklySalary(double _weeklySalary) {
        this._weeklySalary = _weeklySalary;
    }

    @Override
    public double earning() {
        return get_weeklySalary() * 4;
    }
}
