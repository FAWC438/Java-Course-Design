package homework_大作业_2018213344_凌国瀚;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class _2018213344_凌国瀚_大作业_GUI extends JFrame {

    private JPanel MainPanel;
    private JButton ShowPrice;
    private JButton ShowPrePrice;
    private JButton BookConfirm;
    private JButton BookClear;
    private JTextArea InfoTextArea;
    private JTextField[] BookInfo = new JTextField[5];
    private JComboBox<String> BookType;

    public _2018213344_凌国瀚_大作业_GUI() {
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
                "书籍购物车系统", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

        _2018213344_凌国瀚_大作业_Sale saleAction = new _2018213344_凌国瀚_大作业_Sale(new ArrayList<>());

        FunctionSelection();

        WelcomeTitle();

        InfoHandler();

        ShowAddedEmployee();

        ActionHandler(saleAction);

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

        setShowPrice(new JButton());
        getShowPrice().setPreferredSize(new Dimension(88, 80));
        getShowPrice().setText("查询折扣后价格");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(getShowPrice(), gbc);

        setShowPrePrice(new JButton());
        getShowPrePrice().setPreferredSize(new Dimension(88, 80));
        getShowPrePrice().setText("查询折扣前价格");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(getShowPrePrice(), gbc);
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
     * 显示书籍信息
     */
    private void InfoHandler() {
        GridBagConstraints gbc;
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        BookInfoInit(panel3);
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
        getInfoTextArea().setText("暂无书籍信息\n");

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
     * 处理事件
     */
    private void ActionHandler(_2018213344_凌国瀚_大作业_Sale saleAction) {

        // 查询折扣后价格按钮事件
        getShowPrice().addActionListener(event -> JOptionPane.showMessageDialog(this, "折扣后总价格为" + saleAction.getTotal(),
                "查询结果", JOptionPane.INFORMATION_MESSAGE));

        // 查询折扣前价格按钮事件
        getShowPrePrice().addActionListener(event -> JOptionPane.showMessageDialog(this, "折扣前总价格为" + saleAction.getPreTotal(),
                "查询结果", JOptionPane.INFORMATION_MESSAGE));

        //region 信息输入确认按钮事件

        getBookConfirm().addActionListener(event -> {
            int flag = 1;
            for (int i = 1; i < getBookInfo().length - 1; i++) {
                if (!getBookInfo()[i].getText().matches("^[0-9]+(\\.?)[0-9]*$")) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) {
                if (getBookInfo()[4].getText() == null || getBookInfo()[4].getText().equals("")) {

                    _2018213344_凌国瀚_大作业_SaleLineItem newBooks = new _2018213344_凌国瀚_大作业_SaleLineItem(
                            Integer.parseInt(getBookInfo()[3].getText()),
                            new _2018213344_凌国瀚_大作业_ProductSpecification(getBookInfo()[1].getText(), Double.parseDouble(getBookInfo()[2].getText()),
                                    getBookInfo()[0].getText(), getBookType().getSelectedIndex()));

                    saleAction.getItems().add(newBooks);

                    for (int i = 0; i < this.getBookInfo().length - 1; i++)
                        getBookInfo()[i].setText(null);

                } else if (getBookInfo()[4].getText().matches("^[0-9]+(\\.?)[0-9]*$")) {

                    _2018213344_凌国瀚_大作业_SaleLineItem newBooks = new _2018213344_凌国瀚_大作业_SaleLineItem(
                            Integer.parseInt(getBookInfo()[3].getText()),
                            Double.parseDouble(getBookInfo()[4].getText()),
                            new _2018213344_凌国瀚_大作业_ProductSpecification(getBookInfo()[1].getText(),
                                    Double.parseDouble(getBookInfo()[2].getText()),
                                    getBookInfo()[0].getText(), getBookType().getSelectedIndex()));

                    saleAction.getItems().add(newBooks);

                    for (int i = 0; i < this.getBookInfo().length - 1; i++)
                        getBookInfo()[i].setText(null);

                } else
                    JOptionPane.showMessageDialog(this, "输入格式错误", "错误", JOptionPane.WARNING_MESSAGE);
            } else
                JOptionPane.showMessageDialog(this, "输入格式错误", "错误", JOptionPane.WARNING_MESSAGE);

            // 重置文本框
            for (int i = 0; i < getBookInfo().length - 1; i++) {
                getBookInfo()[i].setText(null);
            }
            getInfoTextArea().setText(saleAction.toString());
        });

        //endregion

        // 焦点事件
        Component tempParent = this;
        getBookInfo()[4].addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getBookInfo()[4].setText(null);
                getInfoTextArea().setText(
                        "教材类图书：按固定价格优惠，如输入“1”，则每本优惠1元\n" +
                                "连环画类图书：按百分比优惠，如输入“2”，则每本优惠2%\n" +
                                "非教材类的计算机图书：按百分比优惠，如输入“2”，则每本优惠2%\n" +
                                "其他类图书：该字段无需填写，填写内容无效");

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (saleAction.toString() == null || saleAction.toString().equals(""))
                    getInfoTextArea().setText("暂无书籍信息");
                else
                    getInfoTextArea().setText(saleAction.toString());
            }
        });

        // 清除按钮
        BookClear.addActionListener(event -> {
            saleAction.getItems().clear();
            for (int i = 0; i < getBookInfo().length - 1; i++) {
                getBookInfo()[i].setText(null);
            }
            getInfoTextArea().setText("暂无书籍信息");
        });
    }

    /**
     * 初始化用户信息显示
     *
     * @param parent 父容器
     */
    private void BookInfoInit(JPanel parent) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("书籍名称"));
        getBookInfo()[0] = new JTextField(10);
        panel1.add(getBookInfo()[0]);


        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("I  S  B  N"));
        getBookInfo()[1] = new JTextField(10);
        panel2.add(getBookInfo()[1]);


        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("单本价格"));
        getBookInfo()[2] = new JTextField(10);
        panel3.add(getBookInfo()[2]);

        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("购买数量"));
        getBookInfo()[3] = new JTextField(10);
        panel4.add(getBookInfo()[3]);

        JPanel panel5 = new JPanel();
        panel5.add(new JLabel("折扣参数"));
        getBookInfo()[4] = new JTextField(10);
        panel5.add(getBookInfo()[4]);

        JPanel panel6 = new JPanel();
        panel6.add(new JLabel("书籍类型"));
        setBookType(new JComboBox<>(new String[]{"教材类图书", "连环画类图书", "非教材类的计算机图书", "其他类图书"}));
        panel6.add(getBookType());

        JPanel panel_button1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        setBookConfirm(new JButton("确认添加"));
        panel_button1.add(getBookConfirm());

        JPanel panel_button2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        setBookClear(new JButton("全部清除"));
        panel_button2.add(getBookClear());

        parent.add(panel1, gbc);
        parent.add(panel2, gbc);
        parent.add(panel3, gbc);
        parent.add(panel4, gbc);
        parent.add(panel5, gbc);
        parent.add(panel6, gbc);
        parent.add(panel_button1, gbc);
        parent.add(panel_button2, gbc);
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

    public JButton getShowPrice() {
        return ShowPrice;
    }

    public void setShowPrice(JButton showPrice) {
        ShowPrice = showPrice;
    }

    public JButton getShowPrePrice() {
        return ShowPrePrice;
    }

    public void setShowPrePrice(JButton showPrePrice) {
        ShowPrePrice = showPrePrice;
    }

    public JButton getBookConfirm() {
        return BookConfirm;
    }

    public void setBookConfirm(JButton bookConfirm) {
        BookConfirm = bookConfirm;
    }

    public JTextField[] getBookInfo() {
        return BookInfo;
    }

    public void setBookInfo(JTextField[] bookInfo) {
        BookInfo = bookInfo;
    }

    public JTextArea getInfoTextArea() {
        return InfoTextArea;
    }

    public void setInfoTextArea(JTextArea infoTextArea) {
        this.InfoTextArea = infoTextArea;
    }

    public JComboBox<String> getBookType() {
        return BookType;
    }

    public void setBookType(JComboBox<String> bookType) {
        BookType = bookType;
    }

    public JButton getBookClear() {
        return BookClear;
    }

    public void setBookClear(JButton bookClear) {
        BookClear = bookClear;
    }
}
