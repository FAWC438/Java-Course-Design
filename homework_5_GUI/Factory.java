package homework_5_GUI;

import java.util.HashMap;

public class Factory {
    private HashMap<String, Employee> _employees = new HashMap<>();

    public Factory() {
    }

    public HashMap<String, Employee> get_employees() {
        return _employees;
    }

    public void set_employees(HashMap<String, Employee> _employees) {
        this._employees = _employees;
    }

    public Employee getEmployee(String empSecNum) {
        return get_employees().get(empSecNum);
    }

    public Employee deleteEmployee(String empSecNum) {
        Employee e = get_employees().get(empSecNum);
        get_employees().remove(empSecNum);
        return e;
    }

    public Employee addEmployee(Employee stu) {
        if (get_employees().containsKey(stu.get_SocialSecurityNumber())) {
            return null;
        } else {
            get_employees().put(stu.get_SocialSecurityNumber(), stu);
            return stu;
        }
    }

    public Employee updateEmployee(String empSecNum, Employee emp) {
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
