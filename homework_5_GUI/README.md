# 帮助文档

| 姓名   | 学号       |
| ------ | ---------- |
| 凌国瀚 | 2018213344 |

---

## 目录

<!-- TOC -->
>
> *1.* [软件亮点](#软件亮点)
>
> *2.* [开发环境与运行环境](#开发环境与运行环境)
>
> *3.* [使用说明](#使用说明)
>   - [按键模式](#按键模式)
>   - [菜单模式](#菜单模式)
> 
> *4.* [（函数）数据结构](#（函数）数据结构)
<!-- /TOC -->

---

## 软件亮点

本软件实现了周薪雇员（SalariedEmployee）、时薪雇员（HourlyEmployee）、提成雇员（CommissionEmployee）、基本+提成雇员（BasePlusCommissionEmployee）全部四种不同类型员工的**信息录入**、**查询**与**删除**功能，并且拥有 **按键** 和 **菜单** 两种不同的操作方式供使用者选择。

在代码结构上，如下列代码所示，尽量不利用`try-catch`语句而是利用效率更高的判断方保证软件的鲁棒性，例如用**正则表达式**判断输入字符串的格式是否正确，并且大量采用 **Lambda 表达式**实现控件事件，简化代码结构使之更加易读。同时，大面积封装了具体功能的代码块为相应的函数或添加`region-endregion`语句，并辅以一定的注释，使得代码更简洁美观。

> **温馨提示** 
> Lambda 表达式是Java 8的新特性，因此请务必保证您的JDK版本至少为8.0

```java
this.getEmployeeConfirm().addActionListener(event -> {
    int flag = 1;
    for (int i = 0; i < this.getEmployeeInfo().length - 1; i++) {
        if (this.getEmployeeInfo()[i].isEditable() &&
                !this.getEmployeeInfo()[i].getText().matches("^[0-9]+(\\.?)[0-9]*$")) {
            flag = 0;
            break;
        }
    }
...
```

类文件树如下：

    .
    ├── README.md
    ├── GUI_self.java
    ├── Main.java
    ├── Factory.java
    └── Employee.java
        ├── SalariedEmployee.java
        ├── HourlyEmployee.java
        └── CommissionEmployee.java
            └── BasePlusCommissionEmployee.java

---

## 开发环境与运行环境

JDK版本：12

JVM版本：OpenJDK 64-Bit Server VM by JetBrains s.r.o.

IDE：IntelliJ IDEA 2020.1.3 (Ultimate Edition) on Windows 10

---

## 使用说明

### 按键模式

主界面下方的两个按键即按键模式输入。

点击**员工信息录入**将弹出选择员工类型的对话框，选择对应员工后点击**确认**，相应的员工参数将可供编辑。在输入员工参数后，请**务必点击输入栏下方的确认键**。在录入成功的提示框出现后，员工信息已经加载至内存，您可以在主界面上方的文本区域查看已添加的员工基本身份信息。

点击**员工工资查询**将弹出显示所有员工工资信息的对话框。点击确认即可关闭。

### 菜单模式

主界面左上方即菜单模式输入。

点击**信息录入**一级菜单栏，可以选择四种不同的员工类型。选择了欲添加的员工类型后即可在下方编辑添加的员工属性，与按键模式相同。

点击**员工删除**一级菜单栏，可以选择两种不同的员工删除方式。若选择**按姓名删除**，将会弹出下拉列表对话框，可选择欲删除的员工的姓名并点击确认即可完成删除操作。类似地，若选择**按社保号删除**，将会弹出下拉列表对话框，可选择欲删除的员工的社保号。当您未添加任何员工信息时，删除操作无效并会弹出提示对话框。

点击**查询**一级菜单栏，软件将会模拟用户点击**员工工资查询**按钮，因此二者得到的结果完全相同。

点击**关于**一级菜单栏，选择**帮助文档**，可以在PDF格式查看本文档。选择**作者**，可以查看本软件作者信息。

> **温馨提示** 
> 帮助文档的相对路径指向`GUI_self.class`文件而非`GUI_self.java`文件，因此请在工程文件中运行时选择该选项

---

## （函数）数据结构

本部分将主要介绍`GUI_self.java`中的函数关系。

    GUI_self.java
    └── GUI_self()
        └── setupUI()
            ├── FunctionSelection()
            ├── WelcomeTitle()
            |   └── getFont()
            ├── InfoHandler()
            |   └── EmployeeInfoInit()
            ├── ShowAddedEmployee()
            |   └── getFont()
            ├── ActionHandler()
            |   └── SetInfoEditable()
            └── MenuHandler()
                └── SetInfoEditable()

`setupUI()`: GUI界面初始化函数，必须在构造方法中调用。

`FunctionSelection()`: 主界面下方两个主要按钮的样式设计。

`WelcomeTitle()`: 主界面上方欢迎标题的样式设计。

`InfoHandler()`: 主界面中央的用户信息输入模块，配合`EmployeeInfoInit()`函数控制其初始化内容。

`ShowAddedEmployee()`: 主界面上方的文本块，主要功能为实时显示已经存入内存的员工信息。

`ActionHandler()`: **非菜单方式**的事件响应模块，配合`SetInfoEditable()`函数控制信息输入模块的可编辑属性。

`MenuHandler()`: 菜单方式的样式设计和事件响应模块，配合`SetInfoEditable()`函数控制信息输入模块的可编辑属性。