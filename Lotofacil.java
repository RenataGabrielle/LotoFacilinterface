import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JogoLoteriaGUI extends JFrame implements ActionListener {
    private JButton btnApostarNumero;
    private JButton btnApostarLetra;
    private JButton btnApostarParImpar;
    private JButton btnSair;

    public JogoLoteriaGUI() {
        setTitle("Menu LOTOFÁCIL");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnApostarNumero = new JButton("Apostar de 0 a 100");
        btnApostarLetra = new JButton("Apostar de A à Z");
        btnApostarParImpar = new JButton("Apostar em par ou ímpar");
        btnSair = new JButton("Sair");

        btnApostarNumero.addActionListener(this);
        btnApostarLetra.addActionListener(this);
        btnApostarParImpar.addActionListener(this);
        btnSair.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(btnApostarNumero);
        panel.add(btnApostarLetra);
        panel.add(btnApostarParImpar);
        panel.add(btnSair);

        add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Random random = new Random();
        if (e.getSource() == btnApostarNumero) {
            int numeroAposta = Integer.parseInt(JOptionPane.showInputDialog("Digite um número de 0 a 100: "));
            int numeroSorteado = random.nextInt(101);
            if (numeroAposta == numeroSorteado) {
                JOptionPane.showMessageDialog(this, "Você ganhou R$ 1.000,00 reais.");
            } else {
                JOptionPane.showMessageDialog(this, "Que pena! O número sorteado foi: " + numeroSorteado + ".");
            }
        } else if (e.getSource() == btnApostarLetra) {
            String entrada = JOptionPane.showInputDialog("Digite uma letra de A à Z: ");
            char letraAposta = Character.toUpperCase(entrada.charAt(0));
            char letraPremiada = 'R'; 
            if (letraAposta == letraPremiada) {
                JOptionPane.showMessageDialog(this, "Você ganhou R$ 500,00 reais.");
            } else {
                JOptionPane.showMessageDialog(this, "Que pena! A letra sorteada foi: " + letraPremiada + ".");
            }
        } else if (e.getSource() == btnApostarParImpar) {
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro: "));
            if (numero % 2 == 0) {
                JOptionPane.showMessageDialog(this, "Você ganhou R$ 100,00 reais.");
            } else {
                JOptionPane.showMessageDialog(this, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        } else if (e.getSource() == btnSair) {
            JOptionPane.showMessageDialog(this, "Saindo...");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new JogoLoteriaGUI();
    }
}
