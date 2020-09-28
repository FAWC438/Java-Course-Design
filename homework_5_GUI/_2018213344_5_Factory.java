package homework_5_GUI;

import java.util.HashMap;

public class _2018213344_5_Factory {
    private HashMap<String, _2018213344_5_Employee> _employees = new HashMap<>();

    public _2018213344_5_Factory() {
    }

    public HashMap<String, _2018213344_5_Employee> get_employees() {
        return _employees;
    }

    public void set_employees(HashMap<String, _2018213344_5_Employee> _employees) {
        this._employees = _employees;
    }

    public _2018213344_5_Employee getEmployee(String empSecNum) {
        return get_employees().get(empSecNum);
    }

    public _2018213344_5_Employee deleteEmployee(String empSecNum) {
        _2018213344_5_Employee e = get_employees().get(empSecNum);
        get_employees().remove(empSecNum);
        return e;
    }

    public _2018213344_5_Employee addEmployee(_2018213344_5_Employee stu) {
        if (get_employees().containsKey(stu.get_SocialSecurityNumber())) {
            return null;
        } else {
            get_employees().put(stu.get_SocialSecurityNumber(), stu);
            return stu;
        }
    }

    public _2018213344_5_Employee updateEmployee(String empSecNum, _2018213344_5_Employee emp) {
        if (!get_employees().containsKey(empSecNum)) {
            return null;
        } else {
            get_employees().remove(empSecNum);
            get_employees().put(empSecNum, emp);
            return emp;
        }
    }

    public String printEmployees() {
        StringBuilder s = new StringBuilder();
        for (String key : get_employees().keySet()) {
            s.append(get_employees().get(key)).append("\n\n");
        }
        return s.toString();
    }
}
