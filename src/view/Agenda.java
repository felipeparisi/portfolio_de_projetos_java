package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Agenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;

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
	 * Construtor
	 */
	public Agenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Agenda de contatos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/favicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 292);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(385, 27, 39, 14);
		contentPane.add(lblNewLabel);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setForeground(Color.WHITE);
		txtId.setBackground(Color.GRAY);
		txtId.setBounds(419, 24, 53, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(31, 27, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBackground(Color.GRAY);
		txtNome.setForeground(Color.WHITE);
		txtNome.setBounds(82, 24, 200, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fone");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(31, 76, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtFone = new JTextField();
		txtFone.setForeground(Color.WHITE);
		txtFone.setBackground(Color.GRAY);
		txtFone.setBounds(82, 73, 177, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(31, 127, 46, 14);
		contentPane.add(lblNewLabel_3);

		txtEmail = new JTextField();
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setBackground(Color.GRAY);
		txtEmail.setBounds(82, 124, 322, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		btnCreate7 = new JButton("");
		btnCreate7.setEnabled(false);
		btnCreate7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarContato();
			}
		});
		btnCreate7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate7.setContentAreaFilled(false);
		btnCreate7.setBorderPainted(false);
		btnCreate7.setToolTipText("Adicionar contato");
		btnCreate7.setIcon(new ImageIcon(Agenda.class.getResource("/img/create.png")));
		btnCreate7.setBounds(251, 167, 64, 64);
		contentPane.add(btnCreate7);

		btnUpdate7 = new JButton("");
		btnUpdate7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarContato();
			}
		});
		btnUpdate7.setEnabled(false);
		btnUpdate7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate7.setIcon(new ImageIcon(Agenda.class.getResource("/img/update.png")));
		btnUpdate7.setToolTipText("Editar contato");
		btnUpdate7.setContentAreaFilled(false);
		btnUpdate7.setBorderPainted(false);
		btnUpdate7.setBounds(325, 167, 64, 64);
		contentPane.add(btnUpdate7);

		btnDelete = new JButton("");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Agenda.class.getResource("/img/delete.png")));
		btnDelete.setToolTipText("Excluir contato");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(402, 167, 64, 64);
		contentPane.add(btnDelete);

		btnRead = new JButton("");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarContato();
			}
		});
		btnRead.setIcon(new ImageIcon(Agenda.class.getResource("/img/pesquisar.png")));
		btnRead.setContentAreaFilled(false);
		btnRead.setBorderPainted(false);
		btnRead.setBounds(299, 24, 32, 32);
		contentPane.add(btnRead);

		lblStatus = new JLabel("");
		lblStatus.setToolTipText("Status do Banco de Dados.");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(48, 182, 48, 48);
		contentPane.add(lblStatus);

		// Uso da Tecla Enter junto com um botão
		getRootPane().setDefaultButton(btnRead);
		RestrictedTextField nome = new RestrictedTextField(txtNome);
		nome.setOnlyText(true);
		nome.setAcceptSpace(true);
		nome.setLimit(50);

		RestrictedTextField fone = new RestrictedTextField(txtFone);
		fone.setOnlyNums(true);
		fone.setLimit(15);

		RestrictedTextField email = new RestrictedTextField(txtEmail);
		email.setLimit(50);

	}// fim do Construtor

// Cria um objeto para acessar o metodo conectar() da classe DAO
	DAO dao = new DAO();
	private JLabel lblStatus;
	private JButton btnDelete;
	private JButton btnUpdate7;
	private JButton btnCreate7;
	private JButton btnRead;

	/**
	 * Método Responsavel por verificar o status da conexão com o banco de dados
	 */
	private void status() {
		try {
			// Uso da classe Conection (JDBC) para estabelecer a conexão
			Connection con = dao.conectar();
			if (con == null) {
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon.png")));
			}

			// Nunca esquecer de encerrar a conexao
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}

	}// Fim do status
		// Metodo responsavel pela pesquisa de um contato no banco

	private void pesquisarContato() {
		// Validação
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Contato");
			txtNome.requestFocus();
		} else {
			// Iniciar com a instrução SQL
			String read = "select	* from contatos where nome = ?"; // <--- Interrogação = parametro a ser substituido
			try {
				// Estabelecer a conexao
				Connection con = dao.conectar();
				// Preparar o codigo SQL para execução
				PreparedStatement pst = con.prepareStatement(read);
				// A linha abaixo substitui o interrogação pelo conteudo da caixa de texto txt
				// Nome
				// O 1 fz referencia a interrogação
				pst.setString(1, txtNome.getText());
				// Obter dados dos contatos
				ResultSet rs = pst.executeQuery();

				// Vertificar cadastro
				// rs.next significa ter um contato correspondente ao nome pesquisado
				if (rs.next()) {
					// SETAR A CAIXA DE TEXTO.
					txtId.setText(rs.getString(1));
					txtFone.setText(rs.getString(3));
					txtEmail.setText(rs.getString(4));
					// HABILITAR BOTÕES (ALTERAR E EXCLUIR).
					btnUpdate7.setEnabled(true);
					btnDelete.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Contato Inexistente");
					txtFone.setText(null);
					txtEmail.setText(null);
					txtFone.requestFocus();
					btnCreate7.setEnabled(true);
					btnRead.setEnabled(false);
					con.close();

				}

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * MÉTODO RESPONSAVEL PELO CADASTRO DE UM NOVO USUÁRIO.
	 */

	void adicionarContato() {
		// VALIDAÇÃO DOS CAMPOS
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Fone");
			txtFone.requestFocus();
		} else {

			String create = "insert into	contatos (nome, fone,email) values (?,?,?)";
			try {
				// ABRUR A CONEXÃO
				Connection con = dao.conectar();
				// PREPARAR A QUERY
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				// EXECUTAR A QUERY CONFIRMAR A INSERÇÃO NO BANCO DE DADOS
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Contato cadastrado com Sucesso!");
					limpar();
				}
				// ENCERRAR CONEXÃO
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * MÉTODO RESPONSAVEL PELA EDIÇÃO DO CONTATO.
	 */
	private void alterarContato() {
		// System.out.println("Teste do botão Update");

		// VALIDAÇÃO
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Fone");
			txtFone.requestFocus();
		} else {
			// LÓGICA PRINCIPAL.
			String update = "update contatos set nome = ?, fone = ?, email = ? where id = ?";
			try {
				// ABRIR A CONEXÃO
				Connection con = dao.conectar();
				// PREPARAR A QUERY (INSTRUÇÃO SQL).
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtId.getText());
				// EXECUTAR A QUERY CONFIRMAR A INSERÇÃO NO BANCO DE DADOS
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Ddaos do contato Atualizado com Sucesso!");
					limpar();
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}// FIM DO MÉTODO RESPONSAVEL PELA EDIÇÃO DE CONTATO

	/**
	 * MÉTODO USADO PARA EXCLUIR UM CONTATO.
	 */
	private void excluirContato() {
		// System.out.println("Teste exluir");
		// VALIDAÇÃO
		int confirma = JOptionPane.showConfirmDialog(null, "Confirmar a exclusão deste contato?", "Atenção!!!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from contatos where id = ?;";
			try {
				// ABRIR A CONEXÃO
				Connection con = dao.conectar();
				// PREPARAR A QUERY (INSTRUÇÃO SQL).
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				//EXECUTAR O COMANDO SQL E CONFIRMAR A EXCLUSÃO
				int excluir = pst.executeUpdate();
				if(excluir == 1) {
					JOptionPane.showMessageDialog(null, "Contato excluido com sucesso ");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	/**
	 * Método utilizado para limpar os campos
	 */
	private void limpar() {
		txtId.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		txtNome.requestFocus();
		btnCreate7.setEnabled(false);
		btnRead.setEnabled(true);
	}
}
