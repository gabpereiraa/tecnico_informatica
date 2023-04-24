package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.DAO;

public class Agenda extends JFrame {

	// Criação de objetos (JDBC)
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setResizable(false);
		setTitle("Agenda de contatos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/notepad.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(40, 41, 46, 14);
		contentPane.add(lblNewLabel);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(71, 38, 67, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(40, 86, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBounds(96, 83, 301, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fone");
		lblNewLabel_2.setBounds(40, 134, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtFone = new JTextField();
		txtFone.setBounds(96, 131, 147, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(40, 183, 46, 14);
		contentPane.add(lblNewLabel_3);

		txtEmail = new JTextField();
		txtEmail.setBounds(96, 180, 301, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// botão adicionar contato
				adicionarContato();
			}
		});
		btnCreate.setToolTipText("Adicionar contato");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorder(null);
		btnCreate.setIcon(new ImageIcon(Agenda.class.getResource("/img/create.png")));
		btnCreate.setBounds(40, 242, 64, 64);
		contentPane.add(btnCreate);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(480, 274, 48, 48);
		contentPane.add(lblStatus);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// as linhas abaixo fazem o link entre JFrame e JDialog
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setIcon(new ImageIcon(Agenda.class.getResource("/img/about.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorder(null);
		btnSobre.setToolTipText("Sobre");
		btnSobre.setBounds(461, 23, 48, 48);
		contentPane.add(btnSobre);
	}// fim do construtor

	/**
	 * Método para verificar o status de conexão
	 */
	private void status() {
		// System.out.println("teste janela ativada");
		try {
			// abrir a conexão com o banco
			con = dao.conectar();
			if (con == null) {
				// mudar o ícone da jlabel
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon.png")));
			}
			// fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do método status

	/**
	 * Método para adicionar um contato no banco
	 */
	private void adicionarContato() {
		// System.out.println("Teste do botão adicionar");

		// validação de campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do contato");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o telefone do contato");
			txtFone.requestFocus();
		} else {
			// lógica principal
			// a linha abaixo cria uma variável de nome create que recebe o código sql
			String create = "insert into contatos(nome,fone,email) values (?,?,?)";
			// tratamento de exceção
			try {
				// abrir a conexão com o banco
				con = dao.conectar();
				// Uso da classe PreparedStatement para executar a instrução sql e replicar no
				// banco
				pst = con.prepareStatement(create);
				// setar(definir) os parâmetros (?,?,?) de acordo com o preenchimento das caixas
				// de texto
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				// executar a instrução sql (query)
				pst.executeUpdate();
				// confirmar para o usuário
				JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso");
				// limpar os campos
				limparCampos();
				// fechar a conexão com o banco
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}// fim do método adicionarContato

	/**
	 * Método responsável por limpar os campos
	 */
	private void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
	} //fim do método limparCampos()
	
}// fim do código
