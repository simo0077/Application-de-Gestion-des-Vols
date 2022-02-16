package projet_gestion_de_vols;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

public class application {

	private JFrame frame;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTable tabClients;
	private JButton btnAjouterClient;
	private JButton btnSupprimerClient;
	private JButton btnModifierClient;
	private JButton btnEnregistrer; 
	LinkedList<Client> clients;
	DefaultTableModel modelClients;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application window = new application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public application() throws IOException {
		initialize();
		clients = new LinkedList();
		modelClients = (DefaultTableModel) tabClients.getModel();
		btnModifierClient.setVisible(false);
		btnSupprimerClient.setVisible(false);
		remplirTableClient();
	}
	
	private void remplirTableClient() throws IOException {
		Path path = Paths.get("clients.txt");
		if(Files.exists(path)) {
			File fichier = new File("clients.txt");
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);
			LinkedList<String> file = new LinkedList();
			String s = br.readLine();
			while (s != null) {
			      file.add(s);
			      s = br.readLine();
			   }
			for(int i =0;i<file.size();i++) {
				String[] clientS = file.get(i).split("-");
				Client client = new Client(Integer.parseInt(clientS[0]),clientS[1],clientS[2],Boolean.parseBoolean(clientS[3]));
				clients.add(client);
				if(clientS[3].equals("true")) {
					modelClients.addRow(new String[] {Integer.toString(client.getClientId()),client.getNom(),client.getPrenom()});
				}

				

				
				
			}
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtNom.setText(null);
				txtPrenom.setText(null);
				tabClients.getSelectionModel().clearSelection();
				btnAjouterClient.setVisible(true);
				btnModifierClient.setVisible(false);
				btnSupprimerClient.setVisible(false);
				btnEnregistrer.setVisible(true);
				
			}
		});
		frame.setBounds(100, 100, 686, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("clients");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("show clients");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnAvions = new JMenu("avions");
		menuBar.add(mnAvions);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("show avions");
		mnAvions.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1_1 = new JMenu("aeroports");
		menuBar.add(mnNewMenu_1_1);
		
		JMenu mnNewMenu_1_1_1 = new JMenu("vols");
		menuBar.add(mnNewMenu_1_1_1);
		
		JMenu mnNewMenu_1_1_1_1 = new JMenu("reservation");
		menuBar.add(mnNewMenu_1_1_1_1);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("nom :");
		lblNom.setBounds(30, 61, 64, 14);
		lblNom.setVerticalAlignment(SwingConstants.BOTTOM);
		frame.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("prenom :");
		lblPrenom.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPrenom.setBounds(30, 104, 64, 14);
		frame.getContentPane().add(lblPrenom);
		
		txtNom = new JTextField();
		txtNom.setBounds(108, 58, 86, 20);
		frame.getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(108, 101, 86, 20);
		frame.getContentPane().add(txtPrenom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(301, 61, 328, 313);
		frame.getContentPane().add(scrollPane);
		
		tabClients = new JTable();
		tabClients.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tabClients.getSelectedRow();
				txtNom.setText((String) modelClients.getValueAt(index, 1));
				txtPrenom.setText((String) modelClients.getValueAt(index, 2));
				btnAjouterClient.setVisible(false);
				btnModifierClient.setVisible(true);
				btnSupprimerClient.setVisible(true);
				btnEnregistrer.setVisible(false);
				
				
			}
		});
		tabClients.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "prenom", "nom"
			}
		));
		scrollPane.setViewportView(tabClients);
		
		btnAjouterClient = new JButton("ajouter");
		btnAjouterClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				if(!(nom==null|| nom.equals("")||prenom==null|| prenom.equals(""))) {
					int c=0;
					int index =0;
					for(Client client: clients) {
						if(client.getNom().equalsIgnoreCase(nom)&&client.getPrenom().equalsIgnoreCase(prenom)) {
							c=1;
							index = clients.indexOf(client);
						}
					}
					if(c==0) {
						Client client = new Client(nom,prenom);
						clients.add(client);
						modelClients.addRow(new String[] {Integer.toString(client.getClientId()),nom,prenom});
						txtNom.setText(null);
						txtPrenom.setText(null);
					}
					else if(!(clients.get(index).isStatus())) {
						Client client = clients.get(index);
						client.setStatus(true);
						modelClients.addRow(new String[] {Integer.toString(client.getClientId()),nom,prenom});
					}
					
				}
				
			}
		});
		btnAjouterClient.setBounds(30, 194, 89, 23);
		frame.getContentPane().add(btnAjouterClient);
		
		btnModifierClient = new JButton("modifier");
		btnModifierClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = tabClients.getSelectedRow();
				String nom = txtNom.getText();
				String prenom = txtPrenom.getText();
				
				if(!(nom==null|| nom.equals("")||prenom==null|| prenom.equals(""))) {
					int c=0;
					for(Client client: clients) {
						if(client.getNom().equalsIgnoreCase(nom)&&client.getPrenom().equalsIgnoreCase(prenom)) {
							c=1;
						}
					}
					if(c==0) {
						clients.get(indice).modify(nom, prenom);
						modelClients.setValueAt(nom, indice, 1);
						modelClients.setValueAt(prenom, indice, 2);
						txtNom.setText(null);
						txtPrenom.setText(null);
						btnAjouterClient.setVisible(true);
						btnModifierClient.setVisible(false);
						btnSupprimerClient.setVisible(false);
						btnEnregistrer.setVisible(true);
						tabClients.getSelectionModel().clearSelection();
					}
					
				}
			}
		});
		btnModifierClient.setBounds(158, 244, 89, 23);
		frame.getContentPane().add(btnModifierClient);
		
		btnSupprimerClient = new JButton("supprimer");
		btnSupprimerClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = tabClients.getSelectedRow();
				if(indice!=-1) {
					 clients.get(indice).setStatus(false);;
					 modelClients.removeRow(indice);
					 txtPrenom.setText(null);
					 txtNom.setText(null);
					 btnAjouterClient.setVisible(true);
					 btnModifierClient.setVisible(false);
					 btnSupprimerClient.setVisible(false);
					 btnEnregistrer.setVisible(true);
				}
			}
		});
		btnSupprimerClient.setBounds(30, 244, 89, 23);
		frame.getContentPane().add(btnSupprimerClient);
		
		btnEnregistrer = new JButton("enregistrer");
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File fichier = new File("clients.txt");
				FileWriter fw = null;
				try {
					fw = new FileWriter(fichier);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PrintWriter pw = new PrintWriter(fw);
				for(Client client : clients) {
					pw.println(client);
				}
				pw.close();

				
			}
		});
		btnEnregistrer.setBounds(30, 351, 89, 23);
		frame.getContentPane().add(btnEnregistrer);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
