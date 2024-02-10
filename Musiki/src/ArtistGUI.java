import java.awt.EventQueue;
import java.awt.FlowLayout;


import java.awt.event.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datas.UploadMusic;
import models.Artist;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class ArtistGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Artist artist = new Artist();
	
	JButton btnSarkiEkle = null;
	private JTextField txtSarkiIsmi;
	private JTextField txtSarkiTuru;
	private JTextField txt_DosyaYolu;
	JFileChooser fileChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArtistGUI frame = new ArtistGUI(artist);
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
	public ArtistGUI(Artist artist) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArtistKarsila = new JLabel("Müziklerini yükle " + artist.getUsername().toUpperCase() + " buna ihtiyacimiz var..");
		lblArtistKarsila.setHorizontalAlignment(SwingConstants.CENTER);
		lblArtistKarsila.setForeground(new Color(0, 100, 0));
		lblArtistKarsila.setFont(new Font("Verdana", Font.ITALIC, 22));
		lblArtistKarsila.setBounds(50, 11, 783, 34);
		contentPane.add(lblArtistKarsila);
		
		JLabel lblSanatci = new JLabel("Sanatçı:");
		lblSanatci.setHorizontalAlignment(SwingConstants.LEFT);
		lblSanatci.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSanatci.setForeground(Color.WHITE);
		lblSanatci.setBounds(220, 121, 168, 34);
		contentPane.add(lblSanatci);
		
		JLabel lblDefaultArtist = new JLabel("default: " + artist.getUsername().toUpperCase());
		lblDefaultArtist.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblDefaultArtist.setForeground(Color.GRAY);
		lblDefaultArtist.setBounds(432, 121, 225, 34);
		contentPane.add(lblDefaultArtist);
		
		JLabel lblSarkiIsım = new JLabel("Sarki isim: ");
		lblSarkiIsım.setHorizontalAlignment(SwingConstants.LEFT);
		lblSarkiIsım.setForeground(Color.WHITE);
		lblSarkiIsım.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSarkiIsım.setBounds(220, 191, 168, 34);
		contentPane.add(lblSarkiIsım);
		
		JLabel lblTur = new JLabel("Tür");
		lblTur.setHorizontalAlignment(SwingConstants.LEFT);
		lblTur.setForeground(Color.WHITE);
		lblTur.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTur.setBounds(220, 251, 168, 34);
		contentPane.add(lblTur);
		
		JButton btnSarkiEkle = new JButton("Dosya sec");
		btnSarkiEkle.setFont(new Font("Verdana", Font.BOLD, 13));
		btnSarkiEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSarkiEkle) {
					
					fileChooser = new JFileChooser();
					
					int response = fileChooser.showOpenDialog(null);
					if(response == JFileChooser.APPROVE_OPTION) {
						File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
						System.out.println(file);
						txt_DosyaYolu.setText("Dosya yolu: " + file);
					}
				}
			}
		});
		btnSarkiEkle.setBounds(143, 351, 253, 57);
		contentPane.add(btnSarkiEkle);
		
		txtSarkiIsmi = new JTextField();
		txtSarkiIsmi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtSarkiIsmi.setBounds(432, 191, 225, 34);
		contentPane.add(txtSarkiIsmi);
		txtSarkiIsmi.setColumns(10);
		
		txtSarkiTuru = new JTextField();
		txtSarkiTuru.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtSarkiTuru.setColumns(10);
		txtSarkiTuru.setBounds(432, 251, 225, 34);
		contentPane.add(txtSarkiTuru);
		
		JButton btnAddPackage = new JButton("Sarkiyi pakete ekle");
		btnAddPackage.setFont(new Font("Verdana", Font.BOLD, 13));
		btnAddPackage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File file2 = null;
				try {
					file2 = new File(fileChooser.getSelectedFile().getAbsolutePath());
				}
				catch(Exception ex) {
					Helper.Helper.showMsg("Dosya seciniz...");
				}
				String path1 = "";
				
				try {
					path1 = file2.getAbsolutePath();
				} catch (Exception e1) {
					
				
				}
				
				
				if(!path1.equals("")) {
					UploadMusic.upload(path1, artist.getUsername(), txtSarkiIsmi.getText(), txtSarkiTuru.getText());
				}
					
				
			}
		});
		btnAddPackage.setBounds(456, 351, 253, 57);
		contentPane.add(btnAddPackage);
		
		txt_DosyaYolu = new JTextField();
		txt_DosyaYolu.setEditable(false);
		txt_DosyaYolu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_DosyaYolu.setForeground(Color.PINK);
		txt_DosyaYolu.setBackground(Color.BLACK);
		txt_DosyaYolu.setBounds(39, 437, 796, 43);
		contentPane.add(txt_DosyaYolu);
		txt_DosyaYolu.setColumns(10);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
