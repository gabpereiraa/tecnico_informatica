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
import java.sql.ResultSet;

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
	private ResultSet rs;

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
	private JButton btnCreate;
	private JButton btnBuscar;
	private JButton btnUpdate;
	private JButton btnDelete;

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

		btnCreate = new JButton("");
		btnCreate.setEnabled(false);
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
		btnSobre.setBounds(469, 21, 48, 48);
		contentPane.add(btnSobre);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// evento clicar no botão
				limparCampos();
			}
		});
		btnLimpar.setToolTipText("Limpar Campos");
		btnLimpar.setIcon(new ImageIcon(Agenda.class.getResource("/img/clear.png")));
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setBounds(275, 242, 64, 64);
		contentPane.add(btnLimpar);

		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Agenda.class.getResource("/img/search.png")));
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorder(null);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarContato();
			}
		});
		btnBuscar.setBounds(407, 82, 24, 24);
		contentPane.add(btnBuscar);

		// substituir o click pela tecla <ENTER> em um botão
		getRootPane().setDefaultButton(btnBuscar);
		
		btnUpdate = new JButton("");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
		});
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(Agenda.class.getResource("/img/update.png")));
		btnUpdate.setToolTipText("Editar contato");
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorder(null);
		btnUpdate.setBounds(114, 242, 64, 64);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setIcon(new ImageIcon(Agenda.class.getResource("/img/delete.png")));
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("Excluir contato");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorder(null);
		btnDelete.setBounds(188, 242, 64, 64);
		contentPane.add(btnDelete);

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
	 * Método responsável por buscar um contato no banco
	 */
	private void buscarContato() {
		// validação da busca (obrigar o usuário a preencher um nome)
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome do contato");
			txtNome.requestFocus(); // setar o cursor na caixa de texto
		} else {
			// System.out.println("Teste do botão buscar");
			String read = "select * from contatos where nome = ?";
			try {
				// abrir a conexão
				con = dao.conectar();
				// preparar e execução da query
				pst = con.prepareStatement(read);
				// pegar o conteúdo da caixa de texto e substituir o parâmetro ?
				pst.setString(1, txtNome.getText());
				// uso do ResultSet para obter os dados do contato
				ResultSet rs = pst.executeQuery();
				// se existir um contato cadastrado
				if (rs.next()) {
					// preencher as caixas de texto com o ID, fone e o email
					// ATENÇÃO! o Nome (2º campo da tabela já foi preenchido)
					txtID.setText(rs.getString(1)); // 1 ID
					txtFone.setText(rs.getString(3)); // 3 Fone
					txtEmail.setText(rs.getString(4)); // Email
					// desativar o botão adicionar
					btnCreate.setEnabled(false);
					// desativar o botão buscar
					btnBuscar.setEnabled(false);
					// ativar os botões editar e excluir
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Contato inexistente");
					// ativar o botão adicionar
					btnCreate.setEnabled(true);
					// desativar o botão buscar
					btnBuscar.setEnabled(false);
				}
				// NUNCA esquecer de fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Método responsável pela edição dos dados de um contato
	 */
	private void editarContato() {
		//System.out.println("teste do botão editar");
		//validação de campos obrigatórios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do contato");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o telefone");
			txtFone.requestFocus();
		} else {
			//lógica pricipal (CRUD Update)
			// criando uma variável do tipo String que irá receber a query
			String update = "update contatos set nome=?,fone=?,email=? where id = ?";
			//tratamento de exceções
			try {
				//abrir a conexão com o banco
				con = dao.conectar();
				//preparar a query(substituir ????)
				pst = con.prepareStatement(update);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtID.getText());
				//executar o update no banco
				pst.executeUpdate();
				//confirmar para o usuário
				JOptionPane.showMessageDialog(null, "Dados do contato alterados com sucesso");
				//NUNCA esquecer de fechar a conexão
				con.close();
				//limpar os campos
				limparCampos();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método responsável por excluir um contato
	 */
	private void excluirContato() {
		//System.out.println("teste do botão excluir");
		//Confirmação de exclusão
		//A variável confirma captura a opção escolhida do JOptionPane
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste contato?", "ATENÇÃO!", JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			//query (instrução sql)
			String delete = "delete from contatos where id=?";
			//tratamento de exceções
			try {
				//abrir a conexão
				con = dao.conectar();
				//preparar a query (instrução sql)
				pst = con.prepareStatement(delete);
				pst.setString(1, txtID.getText());
				//executar a query
				pst.executeUpdate();
				//limpar os campos
				limparCampos();
				//exibir uma mensagem ao usuário
				JOptionPane.showMessageDialog(null, "Contato excluído");
				//fechar a conexão (IMPORTANTE!)
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	/**
	 * Método responsável por limpar os campos
	 */
	private void limparCampos() {
		txtID.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		// setar botões
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		btnBuscar.setEnabled(true);
	} // fim do método limparCampos()
}// fim do código
