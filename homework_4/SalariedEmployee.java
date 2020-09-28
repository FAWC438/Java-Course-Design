package homework_4;

public class SalariedEmployee extends Employee {
    private double _weeklySalary;

    public SalariedEmployee(String firstName, String lastName,
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
