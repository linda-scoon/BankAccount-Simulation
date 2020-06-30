package project1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BankAccountViewer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private BankAccount acc = new BankAccount(500503831);
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BankAccountViewer frame = new BankAccountViewer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankAccountViewer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblBankAccount = new JLabel("Bank Account");
		lblBankAccount.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblBankAccount = new GridBagConstraints();
		gbc_lblBankAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblBankAccount.gridx = 2;
		gbc_lblBankAccount.gridy = 0;
		contentPane.add(lblBankAccount, gbc_lblBankAccount);

		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnDeposit) {
					try {
						acc.deposit(Double.parseDouble(textField.getText()));
						textField.setText("");
					} catch (NumberFormatException e1) {
						lblNewLabel.setText("INVALID NUMBER FORMAT");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		GridBagConstraints gbc_btnDeposit = new GridBagConstraints();
		gbc_btnDeposit.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeposit.gridx = 1;
		gbc_btnDeposit.gridy = 2;
		contentPane.add(btnDeposit, gbc_btnDeposit);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnWithdraw) {
					try {
						acc.withdraw(Double.parseDouble(textField_1.getText()));
						textField_1.setText("");
					} catch (NumberFormatException | SQLException e1) {
						lblNewLabel.setText("INVALID NUMBER FORMAT");
					}
					textField.setText("");
				}
			}
		});
		GridBagConstraints gbc_btnWithdraw = new GridBagConstraints();
		gbc_btnWithdraw.insets = new Insets(0, 0, 5, 5);
		gbc_btnWithdraw.gridx = 1;
		gbc_btnWithdraw.gridy = 4;
		contentPane.add(btnWithdraw, gbc_btnWithdraw);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JButton btnShowBalance = new JButton("Show Balance");
		btnShowBalance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnShowBalance) {
					try {
						lblNewLabel.setText(acc.getBalance() + "");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			}
		});
		btnShowBalance.setForeground(new Color(178, 34, 34));
		GridBagConstraints gbc_btnShowBalance = new GridBagConstraints();
		gbc_btnShowBalance.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowBalance.gridx = 2;
		gbc_btnShowBalance.gridy = 6;
		contentPane.add(btnShowBalance, gbc_btnShowBalance);

		lblNewLabel = new JLabel("...");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 7;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
	}

}
