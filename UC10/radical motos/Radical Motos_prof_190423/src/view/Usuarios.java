package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.DAO;

public class Usuarios extends JDialog {
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JTextField txtPerfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Usuarios() {
		setTitle("Usuários");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 596, 335);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(36, 38, 46, 14);
		getContentPane().add(lblNewLabel);

		txtID = new JTextField();
		txtID.setBounds(81, 35, 86, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(36, 81, 46, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(36, 123, 46, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setBounds(36, 166, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtNome = new JTextField();
		txtNome.setBounds(81, 78, 420, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		txtLogin = new JTextField();
		txtLogin.setBounds(81, 120, 162, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		JButton btnCreate = new JButton("Adicionar");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnCreate.setBounds(36, 226, 89, 23);
		getContentPane().add(btnCreate);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(81, 163, 218, 20);
		getContentPane().add(txtSenha);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarUsuario();
			}
		});
		btnBuscar.setBounds(270, 119, 89, 23);
		getContentPane().add(btnBuscar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarUsuario();
			}
		});
		btnEditar.setBounds(154, 226, 89, 23);
		getContentPane().add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnExcluir.setBounds(270, 226, 89, 23);
		getContentPane().add(btnExcluir);
		
		JLabel lblNewLabel_4 = new JLabel("Perfil");
		lblNewLabel_4.setBounds(338, 166, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtPerfil = new JTextField();
		txtPerfil.setBounds(383, 163, 118, 20);
		getContentPane().add(txtPerfil);
		txtPerfil.setColumns(10);

	}// fim do construtor

	/**
	 * Método para adicionar um novo usuário
	 */
	private void adicionarUsuario() {
		// System.out.println("teste do botão adicionar");
		String create = "insert into usuarios(nome,login,senha,perfil) values(?,?,?,?)";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(create);
			pst.setString(1, txtNome.getText());
			pst.setString(2, txtLogin.getText());
			pst.setString(3, txtSenha.getText());
			pst.setString(4, txtPerfil.getText());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do método novoUsuario

	/**
	 * Método para buscar um usuário
	 */
	private void buscarUsuario() {
		// System.out.println("teste do botão buscar");
		String read = "select * from usuarios where login = ?";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, txtLogin.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtID.setText(rs.getString(1));
				txtNome.setText(rs.getString(2));
				txtSenha.setText(rs.getString(4));
				txtPerfil.setText(rs.getString(5));
			} else {
				System.out.println("usuário não cadastrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do método buscarUsuario

	/**
	 * Método para editar os dados do usuário
	 */
	private void editarUsuario() {
		// System.out.println("teste do botão editar");
		String update = "update usuarios set nome=?,login=?,senha=? where iduser=?";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(update);
			pst.setString(1, txtNome.getText());
			pst.setString(2, txtLogin.getText());
			pst.setString(3, txtSenha.getText());
			pst.setString(4, txtID.getText());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dados do usuário editados com sucesso");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do método editarUsuario

	/**
	 * Método usado para excluir um usuário
	 */
	private void excluirUsuario() {
		//System.out.println("teste do botão excluir");
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste usuário?", "ATENÇÃO!",JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from usuarios where iduser=?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(delete);
				pst.setString(1, txtID.getText());
				pst.executeUpdate();				
				JOptionPane.showMessageDialog(null, "Usuário excluído");
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}// fim do método excluirUsuario
}// fim do código
