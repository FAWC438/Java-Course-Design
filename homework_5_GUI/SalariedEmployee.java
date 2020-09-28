package homework_5_GUI;

public class SalariedEmployee extends Employee {
    private double _weeklySalary;

    public SalariedEmployee(String Name,
                            String socialSecurityNumber, double weeklySalary) {
        super(Name, socialSecurityNumber);
        _weeklySalary = weeklySalary;
        set_Type("周薪雇员");
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