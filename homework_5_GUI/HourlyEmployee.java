package homework_5_GUI;


public class HourlyEmployee extends Employee {
    private double _wage;
    private int _hours;

    public HourlyEmployee(String Name,
                          String socialSecurityNumber, double wage, int hours) {
        super(Name, socialSecurityNumber);
        _wage = wage;
        _hours = hours;
        set_Type("时薪雇员");
    }

    public double get_wage() {
        return _wage;
    }

    public void set_wage(double _wage) {
        this._wage = _wage;
    }

    public int get_hours() {
        return _hours;
    }

    public void set_hours(int _hours) {
        this._hours = _hours;
    }

    @Override
    public double earning() {
        return get_wage() * get_hours();
    }
}
