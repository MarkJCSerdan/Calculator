package Project.Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JButton [] button;
    JFrame frame;
    JPanel mainPanel, buttonPanel, displayPanel;
    JTextField displayTextField;
    String display = "";
    float num1 = 0, num2 = 0, total=0;
    char operator = '=';
    boolean isTotalDisplayed = false;

    public Calculator(){
        frame = new JFrame();
        mainPanel = new JPanel();
        Font font = new Font("Roboto", Font.BOLD, 14);

        buttonPanel = new JPanel();

        button = new JButton[20];

        button[0] = new JButton("C");
        button[1] = new JButton(")");
        button[2] = new JButton("(");
        button[3] = new JButton("/");
        button[4] = new JButton("7");
        button[5] = new JButton("8");
        button[6] = new JButton("9");
        button[7] = new JButton("*");
        button[8] = new JButton("4");
        button[9] = new JButton("5");
        button[10] = new JButton("6");
        button[11] = new JButton("-");
        button[12] = new JButton("1");
        button[13] = new JButton("2");
        button[14] = new JButton("3");
        button[15] = new JButton("+");
        button[16] = new JButton("%");
        button[17] = new JButton("0");
        button[18] = new JButton(".");
        button[19] = new JButton("=");


        for(int i=0; i<20; i++){
            buttonPanel.add(button[i]);
            button[i].setFocusable(false);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }
        buttonPanel.setBounds(32,150, 300, 280);
        buttonPanel.setLayout(new GridLayout(5,4, 10,10));
        buttonPanel.setBackground(Color.GRAY);

        displayPanel = new JPanel();

        displayTextField = new JTextField();
        displayTextField.setFont(new Font("Roboto", Font.BOLD, 22));
        displayTextField.setBounds(20,30,305,50);
        displayTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        displayTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        displayTextField.setEditable(false);
        displayTextField.setText("0");


        displayPanel.setBounds(9, 30, 344, 100);
        displayPanel.setLayout(null);
        displayPanel.add(displayTextField);
        displayPanel.setBackground(Color.GRAY);

        mainPanel.setBounds(10,10,363,440);
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setLayout(null);
        mainPanel.add(buttonPanel);
        mainPanel.add(displayPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.setSize(new Dimension(400, 500));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=4; i<=19; i++) {
            if (i == 3 || i == 7 || i == 11 || i == 15 || i == 16 || i==19) {
                continue;
            } else if (e.getSource() == button[i]) {
                displayTextField.setText("");
                setDisplay(getDisplay().concat(button[i].getText()));
                displayTextField.setText(getDisplay());
            }
        }

        for(int i=3; i<=19; i+=4){
            if(e.getSource()==button[i]){
                num1 = Float.parseFloat(displayTextField.getText());
                switch(button[i].getText()){
                    case "+":
                        operator = '+';
                        break;
                    case "-":
                        operator = '-';
                        break;
                    case "*":
                        operator = '*';
                        break;
                    case "/":
                        operator = '/';
                        break;
                }
            }
        }

        if (e.getSource() == button[0]) {
            String str = "";
            for(int i=0; i<getDisplay().length()-1; i++) {
                str += getDisplay().charAt(i);
            }
            setDisplay(str);
            displayTextField.setText(getDisplay());
        }

        try{
            if (e.getSource() == button[19]) {
                if(!isTotalDisplayed){
                    num = Float.parseFloat(displayTextField.getText());
                    switch (operator) {
                        case '+':
                            total += num;
                            changeDisplay(String.valueOf(total));
                            break;
                        case '-':
                            total -= num;
                            changeDisplay(String.valueOf(total));
                            break;
                        case '*':
                            total *= num;
                            changeDisplay(String.valueOf(total));
                            break;
                        case '/':
                            total /= num;
                            changeDisplay(String.valueOf(total));
                            break;

                    }
                    isTotalDisplayed = true;
                }
                else{
                    displayTextField.setText("0");
                    isTotalDisplayed = false;
                }
                changeDisplay(getDisplay());
            }

        }catch(Exception ex){
            displayTextField.setText("Error");
        }

    }

    public void changeDisplay(String str){
        setDisplay(str);
        displayTextField.setText(getDisplay());
    }

    public void setDisplay(String display){
        this.display = display;
    }

    public String getDisplay(){
        return this.display;
    }
}


