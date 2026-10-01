import javax.swing.*;
import java.awt.*;

class ServiceModel {
    int calculate(boolean general, boolean oil, boolean brake, boolean battery) {
        int cost = 0;

        if (general) cost += 1000;
        if (oil) cost += 800;
        if (brake) cost += 1200;
        if (battery) cost += 500;

        return cost;
    }
}

class ServiceView extends JFrame {
    JTextField reg = new JTextField();
    JRadioButton two = new JRadioButton("Two Wheeler");
    JRadioButton car = new JRadioButton("Car");
    JCheckBox general = new JCheckBox("General Service - ₹1000");
    JCheckBox oil = new JCheckBox("Oil Change - ₹800");
    JCheckBox brake = new JCheckBox("Brake Service - ₹1200");
    JCheckBox battery = new JCheckBox("Battery Check - ₹500");
    JButton calculate = new JButton("Calculate Cost");
    JLabel result = new JLabel("Total: ₹0");

    ServiceView() {
        setTitle("Vehicle Service Cost");
        setSize(450, 350);
        setLayout(new GridLayout(8, 1));

        add(new JLabel("Registration Number"));
        add(reg);

        ButtonGroup bg = new ButtonGroup();
        bg.add(two);
        bg.add(car);

        add(two);
        add(car);
        add(general);
        add(oil);
        add(brake);
        add(battery);
        add(calculate);
        add(result);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

class ServiceController {
    ServiceController(ServiceView v) {
        ServiceModel model = new ServiceModel();

        v.calculate.addActionListener(e -> {
            int cost = model.calculate(
                v.general.isSelected(),
                v.oil.isSelected(),
                v.brake.isSelected(),
                v.battery.isSelected()
            );

            v.result.setText("Total Cost: ₹" + cost);
        });
    }
}

public class VehicleService {
    public static void main(String[] args) {
        new ServiceController(new ServiceView());
    }
}