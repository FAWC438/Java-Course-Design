package homework_5_GUI;

public abstract class _2018213344_5_Employee {
    private String _FirstName;
    private String _LastName;
    private String _Name;
    private String _Type;
    private final String _SocialSecurityNumber;

    public abstract double earning();

    @Override
    public String toString() {
        return String.format("姓名:%s， 社保号:%s， 员工类型:%s",
                this.get_Name(), this.get_SocialSecurityNumber(), get_Type());
    }

    public _2018213344_5_Employee(String firstName, String lastName, String socialSecurityNumber) {
        _FirstName = firstName;
        _LastName = lastName;
        set_Name(_FirstName + " " + _LastName);
        _SocialSecurityNumber = socialSecurityNumber;
    }

    public _2018213344_5_Employee(String Name, String socialSecurityNumber) {
        set_Name(Name);
        _SocialSecurityNumber = socialSecurityNumber;
    }

    public String get_FirstName() {
        return _FirstName;
    }

    public void set_FirstName(String _FirstName) {
        this._FirstName = _FirstName;
    }

    public String get_LastName() {
        return _LastName;
    }

    public void set_LastName(String _LastName) {
        this._LastName = _LastName;
    }

    public String get_SocialSecurityNumber() {
        return _SocialSecurityNumber;
    }

    public String get_Name() {
        return _Name;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    public String get_Type() {
        return _Type;
    }

    public void set_Type(String _Type) {
        this._Type = _Type;
    }
}
