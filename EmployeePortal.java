import javax.swing.*;
import java.awt.*;

class EmployeeModel {
    String password = "admin123";
}

class LoginView extends JFrame {
    JTextField user = new JTextField();
    JPasswordField pass = new JPasswordField();
    JButton login = new JButton("Login");

    LoginView() {
        setTitle("Employee Login");
        setSize(350, 200);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username"));
        add(user);
        add(new JLabel("Password"));
        add(pass);
        add(login);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class MainView extends JFrame {
    MainView() {
        setTitle("Employee Management Portal");
        setSize(500, 300);

        JMenuBar bar = new JMenuBar();

        JMenu employee = new JMenu("Employee");
        JMenu tools = new JMenu("Tools");
        JMenu exit = new JMenu("Exit");

        JMenuItem add = new JMenuItem("Add Employee");
        JMenuItem view = new JMenuItem("View Employee");
        JMenuItem change = new JMenuItem("Change Password");
        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem close = new JMenuItem("Exit Application");

        employee.add(add);
        employee.add(view);
        tools.add(change);
        exit.add(logout);
        exit.add(close);

        bar.add(employee);
        bar.add(tools);
        bar.add(exit);

        setJMenuBar(bar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        add.addActionListener(e -> {
            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField dept = new JTextField();

            Object[] fields = {
                "Employee ID:", id,
                "Employee Name:", name,
                "Department:", dept
            };

            JOptionPane.showConfirmDialog(this, fields,
                    "Add Employee", JOptionPane.OK_CANCEL_OPTION);
        });

        change.addActionListener(e -> {
            JPasswordField old = new JPasswordField();
            JPasswordField n = new JPasswordField();
            JPasswordField confirm = new JPasswordField();

            Object[] fields = {
                "Old Password:", old,
                "New Password:", n,
                "Confirm Password:", confirm
            };

            int option = JOptionPane.showConfirmDialog(
                    this, fields, "Change Password",
                    JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                if (new String(n.getPassword()).equals(
                        new String(confirm.getPassword())))
                    JOptionPane.showMessageDialog(this,
                            "Password changed successfully");
                else
                    JOptionPane.showMessageDialog(this,
                            "Passwords do not match");
            }
        });

        close.addActionListener(e -> System.exit(0));
        logout.addActionListener(e -> {
            dispose();
            new LoginView();
        });
    }
}

public class EmployeePortal {
    public static void main(String[] args) {
        LoginView v = new LoginView();

        v.login.addActionListener(e -> {
            if (v.user.getText().equals("admin") &&
                new String(v.pass.getPassword()).equals("admin123")) {
                v.dispose();
                new MainView();
            } else {
                JOptionPane.showMessageDialog(v,
                        "Invalid username or password");
            }
        });
    }
}