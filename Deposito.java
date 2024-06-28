package DeberNavegacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposito extends JFrame {
    private JTextField Valor;
    private JButton menuButton;
    private JPanel JPanel_Deposito;
    private JButton depositarButton;
    private Cuenta cuenta;
    private Ver_Saldo verSaldo;

    public Deposito(Cuenta cuenta, Ver_Saldo verSaldo) {
        super("Deposito");
        this.cuenta = cuenta;
        this.verSaldo = verSaldo;
        setContentPane(JPanel_Deposito);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu Men1 = new menu("");
                Men1.iniciar();
                dispose();
            }
        });

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Depositar();
            }
        });
    }

    public void iniciar() {
        setVisible(true);
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Depositar() {
            Double amount = Double.parseDouble(Valor.getText());
            if (amount < 0.0) {
                JOptionPane.showMessageDialog(null, "No se puede depositar valores negativos.");
            } else {
                cuenta.depositar(amount);
                JOptionPane.showMessageDialog(null, "Deposito realizado exitosamente");
            }
    }
}
