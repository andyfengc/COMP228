package ca.centennial.assignment;

/**
 * @author Chen Feng
 * 1.	Develop a GUI loan-calculator application
 *  using Java that takes annual interest rate, 
 *  number of years, and loan amount as input from
 *   three textfields and displays monthly payment
 *    and total payment in two textfields when
 *     Compute Payment button is clicked.
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoanCalculatorGui extends JFrame {
	private JLabel lblAnnualRate = new JLabel(" Annual Interest Rate: ");;
	private JTextField txtAnnualRate = new JTextField(10);
	private JLabel lblYear = new JLabel(" Number of Years: ");;
	private JTextField txtYear = new JTextField(10);
	private JLabel lblAmount = new JLabel(" Loan Amount: ");
	private JTextField txtAmount = new JTextField(10);
	private JLabel lblMonthlyPayment = new JLabel(" Monthly Payment: ");
	private JTextField txtMonthlyPayment = new JTextField(10);
	private JLabel lblTotalPayment = new JLabel(" Total Payment: ");
	private JTextField txtTotalPayment = new JTextField(10);
	private JButton btnCalc = new JButton("Calculate Payment");

	public LoanCalculatorGui() {
		super();
		buildLayout();
	}

	private void buildLayout() {
		// set root container
		this.setTitle("COMP 228 Loan Calculator");
		this.setSize(450, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// add panel container
		JPanel pnlCalc = new JPanel(new GridLayout(5, 2));
		pnlCalc.setBorder(new TitledBorder(
				"Enter Loan Amount, Interest Rate, and years: "));
		this.add(pnlCalc, BorderLayout.CENTER);
		// add fields
		pnlCalc.add(lblAnnualRate);
		pnlCalc.add(txtAnnualRate);
		pnlCalc.add(lblYear);
		pnlCalc.add(txtYear);
		pnlCalc.add(lblAmount);
		pnlCalc.add(txtAmount);
		pnlCalc.add(lblMonthlyPayment);
		txtMonthlyPayment.setEnabled(false);
		pnlCalc.add(txtMonthlyPayment);
		pnlCalc.add(lblTotalPayment);
		txtTotalPayment.setEnabled(false);
		pnlCalc.add(txtTotalPayment);

		// add calculate button
		JPanel pnlBtn = new JPanel(new FlowLayout());
		pnlBtn.add(btnCalc);
		this.add(pnlBtn, BorderLayout.SOUTH);
		btnCalc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// validate input
				if (txtAnnualRate.getText() == null
						|| txtAnnualRate.getText().equals("")) {
					JOptionPane.showMessageDialog(LoanCalculatorGui.this,
							"Please enter Annual Interest Rate");
					LoanCalculatorGui.this.txtAnnualRate.requestFocus();
				} else if (txtYear.getText() == null
						|| txtYear.getText().equals("")) {
					JOptionPane.showMessageDialog(LoanCalculatorGui.this,
							"Please enter Number of Years");
					LoanCalculatorGui.this.txtYear.requestFocusInWindow();
				} else if (txtAmount.getText() == null
						|| txtAmount.getText().equals("")) {
					JOptionPane.showMessageDialog(LoanCalculatorGui.this,
							"Please enter Loan Amount");
					LoanCalculatorGui.this.txtAmount.requestFocusInWindow();
				}
				else{
					try {
						// read annual interest rate
						double annualRate = Double.parseDouble(txtAnnualRate
								.getText());
						double year = Double.parseDouble(txtYear.getText());
						double amount = Double.parseDouble(txtAmount.getText());
						// calculate payment
						double monthlyRate = annualRate / 1200;
						double monthlyPayment = (amount * monthlyRate)
								/ (1 - (1 / Math
										.pow(1 + monthlyRate, year * 12)));
						double totalPayment = monthlyPayment * year * 12;
						txtMonthlyPayment.setText(String.format("%.2f",
								monthlyPayment));
						txtTotalPayment.setText(String.format("%.2f",
								totalPayment));
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(LoanCalculatorGui.this,
								"Please enter valid number");
					}
				}
				
			}
		});
	}

	public static void main(String[] args) {
		new LoanCalculatorGui();
	}
}
