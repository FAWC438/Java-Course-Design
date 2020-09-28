package homework_5_GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GUI extends JFrame {

    private JPanel MainPanel;
    private JButton AddEmployee;
    private JButton ShowSalary;
    private JButton EmployeeConfirm;
    private JTextArea InfoTextArea;
    private JTextField[] EmployeeInfo = new JTextField[9];
    private JMenuBar Menu;

    public GUI() {
        setupUI();
        setContentPane(getMainPanel());
    }

    /**
     * 界面初始化
     */
    private void setupUI() {
        setMainPanel(new JPanel());
        GridBagLayout layout = new GridBagLayout();
        getMainPanel().setLayout(layout);
        getMainPanel().setPreferredSize(new Dimension(700, 607));
        getMainPanel().setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(),
                " 菜单栏", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        Factory factory = new Factory();

        FunctionSelection();

        WelcomeTitle();

        InfoHandler();

        ShowAddedEmployee();

        ActionHandler(factory);

        MenuHandler(factory);
    }

    /**
     * 两个功能选择按钮
     */
    private void FunctionSelection() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 2.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        getMainPanel().add(panel1, gbc);

        setAddEmployee(new JButton());
        getAddEmployee().setPreferredSize(new Dimension(88, 80));
        getAddEmployee().setText("员工信息录入");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(getAddEmployee(), gbc);

        setShowSalary(new JButton());
        getShowSalary().setPreferredSize(new Dimension(88, 80));
        getShowSalary().setText("员工工资查询");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(getShowSalary(), gbc);
    }

    /**
     * 欢迎标题
     */
    private void WelcomeTitle() {
        GridBagConstraints gbc;
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        getMainPanel().add(panel2, gbc);

        final JLabel label1 = new JLabel();
        Font label1Font = this.getFont("Consolas", Font.BOLD, 72, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-6911124));
        label1.setText("WELCOME");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label1, gbc);

    }

    /**
     * 显示员工信息
     */
    private void InfoHandler() {
        GridBagConstraints gbc;
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        EmployeeInfoInit(panel3);
        getMainPanel().add(panel3, gbc);
    }

    /**
     * 界面上方显示已添加的员工的文本块
     */
    private void ShowAddedEmployee() {
        GridBagConstraints gbc;
        // 创建文本区域组件
        setInfoTextArea(new JTextArea());
        getInfoTextArea().setLineWrap(true);                         // 自动换行
        getInfoTextArea().setWrapStyleWord(true);
        Font textAreaFont = this.getFont("黑体", 0, 14, getInfoTextArea().getFont());
        if (textAreaFont != null) getInfoTextArea().setFont(textAreaFont);   // 设置字体
        getInfoTextArea().setEditable(false);
        getInfoTextArea().setText("暂无员工信息\n");

        // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
        JScrollPane scrollPane = new JScrollPane(
                getInfoTextArea(),
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setPreferredSize(new Dimension(550, 100));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        getMainPanel().add(scrollPane, gbc);
    }

    /**
     * 处理非菜单方式的事件
     */
    private void ActionHandler(Factory factory) {
        final String[] s = {""};

        //region 添加用户按钮事件

        this.getAddEmployee().addActionListener(event -> {
            Object[] temp_obj = {"周薪雇员", "时薪雇员", "提成雇员", "基本+提成雇员"};

            // 弹出提示窗口
            s[0] = (String) JOptionPane.showInputDialog(this, "请选择您的员工类型:\n", "选择员工类型",
                    JOptionPane.PLAIN_MESSAGE, null, temp_obj, "BasePlusCommissionEmployee");

            // 清空原有输入框，并提示输入成功
            if (s[0] != null) {
                JOptionPane.showMessageDialog(this, "您选择的员工类型为" + s[0], "成功", JOptionPane.INFORMATION_MESSAGE);

                this.getEmployeeInfo()[0].setText(s[0]);    // 更新员工类型显示栏

                for (int i = 1; i < this.getEmployeeInfo().length - 1; i++) {
                    this.getEmployeeInfo()[i].setText(null);
                    this.getEmployeeInfo()[i].setEditable(false);
                }
                this.getEmployeeInfo()[this.getEmployeeInfo().length - 1].setText(null);
                SetInfoEditable(this, s[0]);
            }

        });

        // endregion

        //region 显示工资按钮事件

        this.getShowSalary().addActionListener(event -> {
            StringBuilder temp = new StringBuilder();
            double sum = 0;
            int count = 0;
            for (String key : factory.get_employees().keySet()) {
                temp.append("姓名：").append(factory.get_employees().get(key).get_Name()).append("； ")
                        .append("工资：").append(String.format("%.2f", factory.get_employees().get(key).earning())).append("\n\n");
                sum += factory.get_employees().get(key).earning();
                count++;
            }
            temp.append(String.format("平均工资：%.2f",sum/count));
            JOptionPane.showMessageDialog(this, temp.toString(), "员工工资信息", JOptionPane.INFORMATION_MESSAGE);
        });

        //endregion

        //region 信息输入确认按钮事件

        this.getEmployeeConfirm().addActionListener(event -> {
            int flag = 1;
            for (int i = 0; i < this.getEmployeeInfo().length - 1; i++) {
                if (this.getEmployeeInfo()[i].isEditable() &&
                        !this.getEmployeeInfo()[i].getText().matches("^[0-9]+(\\.?)[0-9]*$")) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                Employee judgement;
                switch (this.getEmployeeInfo()[0].getText()) {
                    case "周薪雇员":
                        judgement = factory.addEmployee(new SalariedEmployee(
                                this.getEmployeeInfo()[8].getText(), this.getEmployeeInfo()[7].getText(),
                                Double.parseDouble(this.getEmployeeInfo()[7].getText())
                        ));
                        break;
                    case "时薪雇员":
                        judgement = factory.addEmployee(new HourlyEmployee(
                                this.getEmployeeInfo()[8].getText(), this.getEmployeeInfo()[7].getText(),
                                Double.parseDouble(this.getEmployeeInfo()[2].getText()), (int) Double.parseDouble(this.getEmployeeInfo()[3].getText())
                        ));
                        break;
                    case "提成雇员":
                        judgement = factory.addEmployee(new CommissionEmployee(
                                this.getEmployeeInfo()[8].getText(), this.getEmployeeInfo()[7].getText(),
                                Double.parseDouble(this.getEmployeeInfo()[4].getText()), Double.parseDouble(this.getEmployeeInfo()[5].getText())
                        ));
                        break;
                    default:
                        judgement = factory.addEmployee(new BasePlusCommissionEmployee(
                                this.getEmployeeInfo()[8].getText(), this.getEmployeeInfo()[7].getText(),
                                Double.parseDouble(this.getEmployeeInfo()[4].getText()), Double.parseDouble(this.getEmployeeInfo()[5].getText()),
                                Double.parseDouble(this.getEmployeeInfo()[6].getText())
                        ));
                        break;
                }
                if (judgement != null)
                    JOptionPane.showMessageDialog(this, "员工添加成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(this, "该员工已存在", "错误", JOptionPane.WARNING_MESSAGE);
            } else
                JOptionPane.showMessageDialog(this, "输入格式错误", "错误", JOptionPane.WARNING_MESSAGE);
            this.getInfoTextArea().setText(factory.printEmployees());
        });

        //endregion
    }

    /**
     * 菜单方式输入
     */
    private void MenuHandler(Factory factory) {
        GridBagConstraints gbc;
        final String[] s = {""};
        setMenu(new JMenuBar());

        //region 创建一级子菜单

        JMenu inputMenu = new JMenu("信息录入");
        JMenu delMenu = new JMenu("员工删除");
        JMenu searchMenu = new JMenu("查询");
        JMenu aboutMenu = new JMenu("关于");

        getMenu().add(inputMenu);
        getMenu().add(delMenu);
        getMenu().add(searchMenu);
        getMenu().add(aboutMenu);

        //endregion

        //region “员工删除”的二级子菜单

        JMenuItem delByNameMenu = new JMenuItem("按姓名删除");
        delByNameMenu.addActionListener(event -> {
            if (!factory.get_employees().isEmpty()) {
                ArrayList<String> temp_arr = new ArrayList<>();
                for (String key : factory.get_employees().keySet()) {
                    temp_arr.add(factory.get_employees().get(key).get_Name());
                }

                // 弹出提示窗口
                s[0] = (String) JOptionPane.showInputDialog(this, "请选择您欲删除员工姓名:\n", "选择员工姓名",
                        JOptionPane.PLAIN_MESSAGE, null, temp_arr.toArray(), "");

                for (String key : factory.get_employees().keySet()) {
                    if (factory.get_employees().get(key).get_Name().equals(s[0])) {
                        factory.get_employees().remove(key);
                        JOptionPane.showMessageDialog(this, "您已删除了姓名为" + s[0] + "的员工", "成功", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
                this.getInfoTextArea().setText(factory.printEmployees());
            } else
                JOptionPane.showMessageDialog(this, "您还未添加任何员工", "错误", JOptionPane.WARNING_MESSAGE);
        });

        JMenuItem delBySNMenu = new JMenuItem("按社保号删除");
        delBySNMenu.addActionListener(event -> {
            if (!factory.get_employees().isEmpty()) {
                ArrayList<String> temp_arr = new ArrayList<>(factory.get_employees().keySet());
                // 弹出提示窗口
                s[0] = (String) JOptionPane.showInputDialog(this, "请选择您欲删除员工社保号:\n", "选择员工社保号",
                        JOptionPane.PLAIN_MESSAGE, null, temp_arr.toArray(), "");

                for (String key : factory.get_employees().keySet()) {
                    if (key.equals(s[0])) {
                        factory.get_employees().remove(key);
                        JOptionPane.showMessageDialog(this, "您已删除了社保号为" + s[0] + "的员工", "成功", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
                this.getInfoTextArea().setText(factory.printEmployees());
            } else
                JOptionPane.showMessageDialog(this, "您还未添加任何员工", "错误", JOptionPane.WARNING_MESSAGE);
        });

        delMenu.add(delByNameMenu);
        delMenu.add(delBySNMenu);

        //endregion

        //region “信息录入”的二级子菜单

        JMenuItem SEMenu = new JMenuItem("周薪雇员");
        SEMenu.addActionListener(event -> {
            JOptionPane.showMessageDialog(this, "您选择的员工类型为" + "周薪雇员", "成功", JOptionPane.INFORMATION_MESSAGE);

            this.getEmployeeInfo()[0].setText("周薪雇员");    // 更新员工类型显示栏

            for (int i = 1; i < this.getEmployeeInfo().length - 1; i++) {
                this.getEmployeeInfo()[i].setText(null);
                this.getEmployeeInfo()[i].setEditable(false);
            }
            this.getEmployeeInfo()[this.getEmployeeInfo().length - 1].setText(null);
            SetInfoEditable(this, "周薪雇员");
        });

        JMenuItem HEMenu = new JMenuItem("时薪雇员");
        HEMenu.addActionListener(event -> {
            JOptionPane.showMessageDialog(this, "您选择的员工类型为" + "时薪雇员", "成功", JOptionPane.INFORMATION_MESSAGE);

            this.getEmployeeInfo()[0].setText("时薪雇员");    // 更新员工类型显示栏

            for (int i = 1; i < this.getEmployeeInfo().length - 1; i++) {
                this.getEmployeeInfo()[i].setText(null);
                this.getEmployeeInfo()[i].setEditable(false);
            }
            this.getEmployeeInfo()[this.getEmployeeInfo().length - 1].setText(null);
            SetInfoEditable(this, "时薪雇员");
        });

        JMenuItem CEMenu = new JMenuItem("提成雇员");
        CEMenu.addActionListener(event -> {
            JOptionPane.showMessageDialog(this, "您选择的员工类型为" + "提成雇员", "成功", JOptionPane.INFORMATION_MESSAGE);

            this.getEmployeeInfo()[0].setText("提成雇员");    // 更新员工类型显示栏

            for (int i = 1; i < this.getEmployeeInfo().length - 1; i++) {
                this.getEmployeeInfo()[i].setText(null);
                this.getEmployeeInfo()[i].setEditable(false);
            }
            this.getEmployeeInfo()[this.getEmployeeInfo().length - 1].setText(null);
            SetInfoEditable(this, "提成雇员");
        });

        JMenuItem BEMenu = new JMenuItem("基本+提成雇员");
        BEMenu.addActionListener(event -> {
            JOptionPane.showMessageDialog(this, "您选择的员工类型为" + "基本+提成雇员", "成功", JOptionPane.INFORMATION_MESSAGE);

            this.getEmployeeInfo()[0].setText("基本+提成雇员");    // 更新员工类型显示栏

            for (int i = 1; i < this.getEmployeeInfo().length - 1; i++) {
                this.getEmployeeInfo()[i].setText(null);
                this.getEmployeeInfo()[i].setEditable(false);
            }
            this.getEmployeeInfo()[this.getEmployeeInfo().length - 1].setText(null);
            SetInfoEditable(this, "基本+提成雇员");
        });

        inputMenu.add(SEMenu);
        inputMenu.add(HEMenu);
        inputMenu.add(CEMenu);
        inputMenu.add(BEMenu);

        //endregion

        //region “查询”的二级子菜单

        JMenuItem searchSalaryMenu = new JMenuItem("员工平均工资查询");
        searchSalaryMenu.addActionListener(event -> getShowSalary().doClick());
        searchMenu.add(searchSalaryMenu);

        //endregion

        //region “关于”的二级子菜单

        JMenuItem docMenu = new JMenuItem("帮助文档（请在工程文件中运行时点击）");
        docMenu.addActionListener(event -> {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(new File(GUI.class.getResource("").getPath() + "/帮助文档.pdf"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        JMenuItem authorMenu = new JMenuItem("作者");
        authorMenu.addActionListener(event -> {
            JOptionPane.showMessageDialog(this, "姓名：凌国瀚\n学号：2018213344", "作者信息", JOptionPane.INFORMATION_MESSAGE);
        });
        aboutMenu.add(docMenu);
        aboutMenu.add(authorMenu);

        //endregion

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        getMainPanel().add(getMenu(), gbc);
    }

    /**
     * 初始化用户信息显示
     *
     * @param parent 父容器
     */
    private void EmployeeInfoInit(JPanel parent) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("员 工  类 型"));
        getEmployeeInfo()[0] = new JTextField("暂未选择员工类型", 10);
        // getEmployeeInfo()[0].setFont(this.getFont("黑体", 0, 10, getEmployeeInfo()[0].getFont()));
        getEmployeeInfo()[0].setEditable(false);
        panel1.add(getEmployeeInfo()[0]);


        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("周            薪"));
        getEmployeeInfo()[1] = new JTextField(10);
        getEmployeeInfo()[1].setEditable(false);
        panel2.add(getEmployeeInfo()[1]);


        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("每小时工钱"));
        getEmployeeInfo()[2] = new JTextField(10);
        getEmployeeInfo()[2].setEditable(false);
        panel3.add(getEmployeeInfo()[2]);

        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("月工作小时"));
        getEmployeeInfo()[3] = new JTextField(10);
        getEmployeeInfo()[3].setEditable(false);
        panel4.add(getEmployeeInfo()[3]);

        JPanel panel5 = new JPanel();
        panel5.add(new JLabel("销    售    额"));
        getEmployeeInfo()[4] = new JTextField(10);
        getEmployeeInfo()[4].setEditable(false);
        panel5.add(getEmployeeInfo()[4]);

        JPanel panel6 = new JPanel();
        panel6.add(new JLabel("提 成  比 率"));
        getEmployeeInfo()[5] = new JTextField(10);
        getEmployeeInfo()[5].setEditable(false);
        panel6.add(getEmployeeInfo()[5]);

        JPanel panel7 = new JPanel();
        panel7.add(new JLabel("月基本工资"));
        getEmployeeInfo()[6] = new JTextField(10);
        getEmployeeInfo()[6].setEditable(false);
        panel7.add(getEmployeeInfo()[6]);

        JPanel panel8 = new JPanel();
        panel8.add(new JLabel("员工社保号"));
        getEmployeeInfo()[7] = new JTextField(10);
        getEmployeeInfo()[7].setEditable(false);
        panel8.add(getEmployeeInfo()[7]);

        JPanel panel9 = new JPanel();
        panel9.add(new JLabel("员 工  全 名"));
        getEmployeeInfo()[8] = new JTextField(10);
        getEmployeeInfo()[8].setEditable(false);
        panel9.add(getEmployeeInfo()[8]);

        JPanel panel_button = new JPanel(new FlowLayout(FlowLayout.CENTER));
        setEmployeeConfirm(new JButton("确认"));
        getEmployeeConfirm().setVisible(false);
        panel_button.add(getEmployeeConfirm());

        parent.add(panel1, gbc);
        parent.add(panel9, gbc);
        parent.add(panel8, gbc);
        parent.add(panel2, gbc);
        parent.add(panel3, gbc);
        parent.add(panel4, gbc);
        parent.add(panel5, gbc);
        parent.add(panel6, gbc);
        parent.add(panel7, gbc);
        parent.add(panel_button, gbc);
    }

    /**
     * 更新控件可编辑性
     *
     * @param parent 父容器
     * @param type   员工类型
     */
    private void SetInfoEditable(GUI parent, String type) {
        parent.getEmployeeConfirm().setVisible(true);
        parent.getEmployeeInfo()[7].setEditable(true);
        parent.getEmployeeInfo()[8].setEditable(true);
        switch (type) {
            case "周薪雇员":
                parent.getEmployeeInfo()[1].setEditable(true);
                break;
            case "时薪雇员":
                parent.getEmployeeInfo()[2].setEditable(true);
                parent.getEmployeeInfo()[3].setEditable(true);
                break;
            case "提成雇员":
                parent.getEmployeeInfo()[4].setEditable(true);
                parent.getEmployeeInfo()[5].setEditable(true);
                break;
            default:
                parent.getEmployeeInfo()[4].setEditable(true);
                parent.getEmployeeInfo()[5].setEditable(true);
                parent.getEmployeeInfo()[6].setEditable(true);
                break;
        }
    }

    /**
     * 设置文字样式
     *
     * @param fontName    字体
     * @param style       样式
     * @param size        大小
     * @param currentFont 当前样式
     * @return 样式对象实例
     */
    private Font getFont(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    // 以下均为属性方法

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.MainPanel = mainPanel;
    }

    public JButton getAddEmployee() {
        return AddEmployee;
    }

    public void setAddEmployee(JButton addEmployee) {
        AddEmployee = addEmployee;
    }

    public JButton getShowSalary() {
        return ShowSalary;
    }

    public void setShowSalary(JButton showSalary) {
        ShowSalary = showSalary;
    }

    public JButton getEmployeeConfirm() {
        return EmployeeConfirm;
    }

    public void setEmployeeConfirm(JButton employeeConfirm) {
        EmployeeConfirm = employeeConfirm;
    }

    public JTextField[] getEmployeeInfo() {
        return EmployeeInfo;
    }

    public void setEmployeeInfo(JTextField[] employeeInfo) {
        EmployeeInfo = employeeInfo;
    }

    public JTextArea getInfoTextArea() {
        return InfoTextArea;
    }

    public void setInfoTextArea(JTextArea infoTextArea) {
        this.InfoTextArea = infoTextArea;
    }

    public JMenuBar getMenu() {
        return Menu;
    }

    public void setMenu(JMenuBar menu) {
        Menu = menu;
    }
}
