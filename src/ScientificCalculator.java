
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {
    private final JTextField textField;
    private double num1;
    private double result;
    private int operator;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 10, 10));
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C", "sqrt", "sin", "cos"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(textField, BorderLayout.NORTH);
        add(buttonPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (Character.isDigit(command.charAt(0))) {
            textField.setText(textField.getText() + command);
        } else {
            switch (command) {
                case "+":
                    num1 = Double.parseDouble(textField.getText());
                    operator = 1;
                    textField.setText("");
                    break;
                case "-":
                    num1 = Double.parseDouble(textField.getText());
                    operator = 2;
                    textField.setText("");
                    break;
                case "*":
                    num1 = Double.parseDouble(textField.getText());
                    operator = 3;
                    textField.setText("");
                    break;
                case "/":
                    num1 = Double.parseDouble(textField.getText());
                    operator = 4;
                    textField.setText("");
                    break;
                case "=":
                    double num2 = Double.parseDouble(textField.getText());
                    switch (operator) {
                        case 1:
                            result = num1 + num2;
                            break;
                        case 2:
                            result = num1 - num2;
                            break;
                        case 3:
                            result = num1 * num2;
                            break;
                        case 4:
                            result = num1 / num2;
                            break;
                    }
                    textField.setText(String.valueOf(result));
                    break;
                case "C":
                    textField.setText("");
                    break;
                case "sqrt":
                    num1 = Double.parseDouble(textField.getText());
                    result = Math.sqrt(num1);
                    textField.setText(String.valueOf(result));
                    break;
                case "sin":
                    num1 = Double.parseDouble(textField.getText());
                    result = Math.sin(Math.toRadians(num1));
                    textField.setText(String.valueOf(result));
                    break;
                case "cos":
                    num1 = Double.parseDouble(textField.getText());
                    result = Math.cos(Math.toRadians(num1));
                    textField.setText(String.valueOf(result));
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}

