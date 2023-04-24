package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	public JLabel lblUsuario; //public -> visível em outras classes

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setarData();
			}
		});
		setResizable(false);
		setTitle("Radical Motos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 480);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 395, 679, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblData.setBounds(407, 11, 272, 33);
		panel.add(lblData);
		lblData.setForeground(SystemColor.text);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setBounds(10, 21, 70, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblUsuario = new JLabel("");
		lblUsuario.setBounds(80, 16, 215, 24);
		panel.add(lblUsuario);
		lblUsuario.setForeground(SystemColor.info);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/img/logo.png")));
		lblLogo.setBounds(477, 236, 192, 148);
		contentPane.add(lblLogo);
		
		JButton btnUsuarios = new JButton("");
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento clicar no botão
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setToolTipText("Usuários");
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/usuarios.png")));
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setBounds(30, 23, 128, 128);
		contentPane.add(btnUsuarios);
	}//fim do construtor
	
	/**
	 * Método para setar a data atual
	 */
	private void setarData() {
		//System.out.println("teste");
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblData.setText(formatador.format(data));
	}
}//fim do código
