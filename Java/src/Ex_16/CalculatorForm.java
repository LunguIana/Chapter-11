package Ex_16;
public class CalculatorForm extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = -5421898671553588643L;
    // Need to put all buttons and fields as private variables
    private JButton calculateButton;
    private JButton exitButton;
    // private JTextBox fistNumber;
    private JRadioButton addRadioButton;
    private JRadioButton subtractRadioButton;
    private JRadioButton multiplyRadioButton;
    private JRadioButton divideRadioButton;
    private ButtonGroup radioGroup;
    private JTextField numberOneTextField;
    private JTextField numberTwoTextField;
    private JTextField answerTextField;
    private JLabel numberOneLabel;
    private JLabel numberTwoLabel;
    private JLabel buttonGroupLabel;
    private JLabel answerLabel;

    private DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        CalculatorForm cForm = new CalculatorForm();
        cForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cForm.setSize(300, 300);
        // cForm.setResizable(false);
        cForm.setVisible(true);
    }

    public CalculatorForm() {
        super("A Simple Calculator Form");
        //I'm using the GridBagLayout and will use GridBagConstraints to get the form looking right.
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Initialize Text Field One and Label One
        numberOneLabel = new JLabel("First number:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(0, 0, 0, 3);
        add(numberOneLabel, gbc);
        numberOneTextField = new JTextField("0", 10);
        numberOneLabel.setLabelFor(numberOneTextField);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(numberOneTextField, gbc);

        // Radio Buttons
        //Start with the label
        buttonGroupLabel = new JLabel("Operation:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(buttonGroupLabel, gbc);
        gbc.gridheight = 1;
        //Create individual radio buttons
        addRadioButton = new JRadioButton("add", true);
        subtractRadioButton = new JRadioButton("subtract", false);
        multiplyRadioButton = new JRadioButton("multiply", false);
        divideRadioButton = new JRadioButton("divide", false);
        //Place the radio buttons on the grid
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(addRadioButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(subtractRadioButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(multiplyRadioButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(divideRadioButton, gbc);

        // create logical relationship between JRadioButtons, so only one can be selected
        radioGroup = new ButtonGroup();
        radioGroup.add(addRadioButton);
        radioGroup.add(subtractRadioButton);
        radioGroup.add(multiplyRadioButton);
        radioGroup.add(divideRadioButton);

        // Initialize Text Field Two
        numberTwoLabel = new JLabel("Second number:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        add(numberTwoLabel, gbc);
        numberTwoTextField = new JTextField("0", 10);
        numberTwoLabel.setLabelFor(numberTwoTextField);
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(numberTwoTextField, gbc);
        // Initialize Answer Text Field
        answerLabel = new JLabel("Answer:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        add(answerLabel, gbc);
        answerTextField = new JTextField(df.format(0.0), 10);
        // answerTextField.setEnabled(false);
        answerLabel.setLabelFor(answerTextField);
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(answerTextField, gbc);

        // Initialize Buttons (Calc and exit)
        calculateButton = new JButton("calculate");
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(calculateButton, gbc);
        exitButton = new JButton("exit");
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(exitButton, gbc);

        // Now we need to register event listeners for buttons
        ButtonHandler handler = new ButtonHandler();
        calculateButton.addActionListener(handler);
        exitButton.addActionListener(handler);

    } // End Constructor

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            //See which button was pressed
            if (event.getSource() == calculateButton) {
                // OK, so we need to perform a mathematical operation on the two
                // text fields (after validating them)
                // And put the results in the answerText field
                if (isInteger(numberOneTextField.getText())
                        && isInteger(numberTwoTextField.getText())) {
                    int intOne = Integer.parseInt(numberOneTextField.getText());
                    int intTwo = Integer.parseInt(numberTwoTextField.getText());
                    double dblAnswer = 0.0;
                    if (addRadioButton.isSelected()) {
                        dblAnswer = intOne + intTwo;
                    } else if (subtractRadioButton.isSelected()) {
                        dblAnswer = intOne - intTwo;
                    } else if (multiplyRadioButton.isSelected()) {
                        dblAnswer = intOne * intTwo;
                    } else if (divideRadioButton.isSelected()) {
                        if (intTwo == 0) {
                            // Divide by Zero is a problem. Show an alert
                            JOptionPane.showMessageDialog(CalculatorForm.this,
                                    "Cannot Divide by Zero.");
                        } else {
                            dblAnswer = (double) intOne / (double) intTwo;
                        } // divide by zero
                    } // divison
                    answerTextField.setText(df.format(dblAnswer));

                } else {
                    // One of the Text Fields is not an integer, so show an alert
                    JOptionPane
                            .showMessageDialog(CalculatorForm.this,
                                    "There was an error with one of your entries.  Only integers are accepted.");
                }
            } else if (event.getSource() == exitButton) {
                // Exit the application, only one form
                CalculatorForm.this.dispose();
            }
        } // actionPerformed

        //Test to see if parseInt throws an exception
        public boolean isInteger(String intString) {
            boolean blnReturn = true;
            try {
                Integer.parseInt(intString);
            } catch (NumberFormatException e) {
                blnReturn = false;
            }

            return blnReturn;
        }
    } // ButtonHandler inner class

}