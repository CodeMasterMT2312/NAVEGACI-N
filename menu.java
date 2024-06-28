package DeberNavegacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame {
    private JRadioButton verSaldoRadioButton;
    private JRadioButton retiroRadioButton;
    private JRadioButton depositoRadioButton;
    private JRadioButton salirRadioButton;
    private JPanel JPanel_menu;
    private String Username;
    private Cuenta cuenta;

    public menu(String username1) {
        setTitle("Menu");
        this.Username = username1;
        setContentPane(JPanel_menu);
        cuenta = new Cuenta(); // Crear una instancia única de Cuenta

        verSaldoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ver_Saldo VS = new Ver_Saldo(cuenta);
                VS.iniciar();
                VS.setCampoUser(Username);
                VS.VerSaldo(); // Actualiza el campo de saldo al abrir la ventana
                dispose();
            }
        });

        depositoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposito dep = new Deposito(cuenta, new Ver_Saldo(cuenta)); // Pasar la instancia existente de Ver_Saldo
                dep.iniciar();
                dispose();
            }
        });

        retiroRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Retiro retiro = new Retiro(cuenta);
                retiro.iniciar();
                dispose();
            }
        });

        salirRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    public void iniciar() {
        setVisible(true);
        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
