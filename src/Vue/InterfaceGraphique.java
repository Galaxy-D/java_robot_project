package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Modele.ErrRobot;
import Modele.Monde;
import Modele.Robot;
import Modele.RobotNettoyeur;
import Modele.RobotNettoyeurLibre;
import Modele.RobotNettoyeurSmart;
import Modele.RobotNettoyeurStandard;
import Modele.RobotPollueur;
import Modele.RobotpollueurLibre;
import Modele.RobotpollueurSauteurs;
import Modele.RobotpollueurToutDroit;

public class InterfaceGraphique {

	/******************************************** Create the application **************************************************************/
	
	public InterfaceGraphique() { initialize();}
	
	private JFrame frame;	
	
	/******************************************** Button de Panel de NORD *************************************************************/
	
	JButton Nettoyer 				= new JButton("Nettoyer");
	JButton Polluer 				= new JButton("Polluer");
	JButton Actualiser 				= new JButton("Rénitialiser le monde");
	JButton QuitterNorth 			= new JButton("Quitter");	
	JLabel  NbrPG 					= new JLabel(" ");
	
	/******************************************** Button de Panel de EST *************************************************************/
	
	JButton NettoyeurStandard 		= new JButton("Nettoyeur Standard ");
	JButton NettoyeurSmart 			= new JButton("Nettoyeur Smart");
	JButton EastLeftArrowButton 	= new JButton(" ");
	JButton EastRightArrowButton 	= new JButton(" ");
	JButton EastTopArrowButton 		= new JButton(" ");
	JButton EastBottomArrowButton 	= new JButton(" ");
	JButton NettoyeurLibre 			= new JButton("Nettoyeur Libre");
	JButton QuitterEast  			= new JButton("Quitter");
	
	/******************************************** Button de Panel de OEUST ***********************************************************/
	
	JButton PollueurDroit 			= new JButton("Pollueur Droit");
	JButton PollueurSauteur			= new JButton("Pollueur Sauteur");
	JButton WestTopArrowbutton 		= new JButton(" ");
	JButton WestLeftArrowbutton 	= new JButton(" ");
	JButton WestRightArrowbutton	= new JButton(" ");
	JButton WestBottomArrowbutton	= new JButton(" ");
	JButton PollueurLibre 			= new JButton("Pollueur Libre");
	JButton QuitterWest 			= new JButton("Quitter");
	
	/******************************************** Button de Panel de SUD ***********************************************************/
	
	JButton Boldpaper = new JButton(" ");
	JButton CleanCase = new JButton(" ");
	private JLabel txtPapierGras;
	private JLabel txtCaseNettoye;
	
	/********************************************* Button de Panel de CENTRE *******************************************************/
	
	JButton[][] TabButton = new JButton[10][10];
	
	/********************************************* Déclaration de Monde, Robots, variables **************************************************/
	
	Monde M = new Monde(10, 10); 
	RobotPollueur  			RP;
	RobotNettoyeur 			RN;
	RobotpollueurToutDroit 	RpTD; 
	RobotpollueurLibre 		RpL;
	RobotpollueurSauteurs 	RpS;
	RobotNettoyeurLibre 	RNL;
	RobotNettoyeurStandard 	RNS;
	RobotNettoyeurSmart 	RNSm;	
	Robot R;
	int ColDepart,LigDepart;	
	int ind_poll=0,ind_nett=0;			

	/**************************************** Initialize the contents of the frame and panel creation******************************************/
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Projet Robot");		
		frame.setResizable(true); 
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setMinimumSize(new Dimension(1000, 600));
		
		/******************************************************* Panel de NORD *******************************************************/
		
		JPanel Northpanel = new JPanel();
		Northpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));		
		
		Nettoyer.setFont(new Font("SansSerif", Font.BOLD, 12));
		Nettoyer.setBackground(Color.CYAN);
		Nettoyer.addActionListener(new NettoyerListener(M));
		Northpanel.add(Nettoyer);
		
		
		Polluer.setFont(new Font("SansSerif", Font.BOLD, 12));
		Polluer.setBackground(Color.CYAN);
		Polluer.addActionListener(new PolluerListener(M));
		Northpanel.add(Polluer);
		
		
		Actualiser.setFont(new Font("SansSerif", Font.BOLD, 12));
		Actualiser.setBackground(Color.CYAN);
		Actualiser.addActionListener(new ActualiserListener());
		Northpanel.add(Actualiser);
		
		
		QuitterNorth.setFont(new Font("SansSerif", Font.BOLD, 12));
		QuitterNorth.setBackground(Color.CYAN);
		QuitterNorth.addActionListener(new QuitterListener());
		Northpanel.add(QuitterNorth);		
		
		NbrPG.setFont(new Font("SansSerif", Font.BOLD, 12));		
		Northpanel.add(NbrPG);
		
		/******************************************************* Panel de SUD *******************************************************/
		
		JPanel Southpanel = new JPanel();
		Southpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));		
		
		Boldpaper.setBackground(Color.BLACK);
		Southpanel.add(Boldpaper);
		
		txtPapierGras = new JLabel();
		txtPapierGras.setHorizontalAlignment(SwingConstants.CENTER);
		txtPapierGras.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		txtPapierGras.setText("Papier Gras");		
		Southpanel.add(txtPapierGras);
				
		CleanCase.setBackground(Color.GREEN);
		Southpanel.add(CleanCase);
		
		txtCaseNettoye = new JLabel();
		txtCaseNettoye.setHorizontalAlignment(SwingConstants.CENTER);
		txtCaseNettoye.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		txtCaseNettoye.setText("Case Nettoy\u00E9e");
		Southpanel.add(txtCaseNettoye);
				
		/******************************************************* Panel de OUEST *******************************************************/
		
		JPanel Westpanel = new JPanel();
		Westpanel.setLayout(new CardLayout(0, 0));
		
		JPanel WestButtonpanel = new JPanel();
		Westpanel.add(WestButtonpanel, "WestButtonpanel");
		WestButtonpanel.setLayout(new BoxLayout(WestButtonpanel, BoxLayout.Y_AXIS));
		
		PollueurDroit.setFont(new Font("SansSerif", Font.BOLD, 12));
		PollueurDroit.setAlignmentX(0.5f);
		PollueurDroit.setBackground(Color.CYAN);
		PollueurDroit.setBorderPainted(true);
		WestButtonpanel.add(PollueurDroit);		
		PollueurDroit.addActionListener(new PollueurTDListener(ColDepart, M));
		
		PollueurSauteur.setFont(new Font("SansSerif", Font.BOLD, 12));
		PollueurSauteur.setAlignmentX(0.5f);
		PollueurSauteur.setBackground(Color.CYAN);
		PollueurSauteur.setBorderPainted(true);
		WestButtonpanel.add(PollueurSauteur);
		PollueurSauteur.addActionListener(new PolluerSauteursListener(M));
		
		JPanel WestArrowpanel = new JPanel();
		WestButtonpanel.add(WestArrowpanel, "WestArrowpanel");
		WestArrowpanel.setLayout(new BorderLayout(0, 0));		
		
		WestTopArrowbutton.setBackground(Color.CYAN);
		WestTopArrowbutton.setIcon(new ImageIcon(InterfaceGraphique.class.getResource("/media/Top.png")));
		WestArrowpanel.add(WestTopArrowbutton, BorderLayout.NORTH);	
		WestTopArrowbutton.addActionListener(new WestTopbuttonListener());
		
		WestLeftArrowbutton.setBackground(Color.CYAN);
		WestLeftArrowbutton.setIcon(new ImageIcon(InterfaceGraphique.class.getResource("/media/Left.png")));
		WestArrowpanel.add(WestLeftArrowbutton, BorderLayout.WEST);		
		WestLeftArrowbutton.addActionListener(new WestLeftbuttonListener());
		
		WestRightArrowbutton.setBackground(Color.CYAN);
		WestRightArrowbutton.setIcon(new ImageIcon(InterfaceGraphique.class.getResource("/media/Right.png")));
		WestArrowpanel.add(WestRightArrowbutton, BorderLayout.EAST);		
		WestRightArrowbutton.addActionListener(new WestRightbuttonListener());
		
		WestBottomArrowbutton.setBackground(Color.CYAN);
		WestBottomArrowbutton.setIcon(new ImageIcon(InterfaceGraphique.class.getResource("/media/Bottom.png")));
		WestArrowpanel.add(WestBottomArrowbutton, BorderLayout.SOUTH);	
		WestBottomArrowbutton.addActionListener(new WestBottombuttonListener());
		
		PollueurLibre.setFont(new Font("SansSerif", Font.BOLD, 12));
		PollueurLibre.setAlignmentX(0.5f);
		PollueurLibre.setBackground(Color.CYAN);
		PollueurLibre.setBorderPainted(true);
		PollueurLibre.addActionListener(new PolluerLibreListener(M));
		WestButtonpanel.add(PollueurLibre);

		QuitterWest.setFont(new Font("SansSerif", Font.BOLD, 12));
		QuitterWest.setAlignmentX(0.5f);
		QuitterWest.setBackground(Color.CYAN);
		QuitterWest.setBorderPainted(true);
		QuitterWest.addActionListener(new QuitterListener());
		WestButtonpanel.add(QuitterWest);
		
		/******************************************************* Panel de EST *******************************************************/
				
		JPanel Eastpanel = new JPanel();
		Eastpanel.setLayout(new CardLayout(0, 0));
		
		JPanel EastButtonpanel = new JPanel();
		Eastpanel.add(EastButtonpanel, "EastButtonpanel");
		EastButtonpanel.setLayout(new BoxLayout(EastButtonpanel, BoxLayout.Y_AXIS));
				
		NettoyeurStandard.setFont(new Font("SansSerif", Font.BOLD, 12));
		NettoyeurStandard.setAlignmentX(0.5f);
		NettoyeurStandard.setBackground(Color.CYAN);
		EastButtonpanel.add(NettoyeurStandard);
		NettoyeurStandard.addActionListener(new NettoyeurStandardListener(ColDepart,M));
				
		NettoyeurSmart.setFont(new Font("SansSerif", Font.BOLD, 12));
		NettoyeurSmart.setBackground(Color.CYAN);
		EastButtonpanel.add(NettoyeurSmart);
		NettoyeurSmart.setAlignmentX(0.5f);
		NettoyeurSmart.addActionListener(new NettoyeurSmartListener(M));
		
		JPanel EastArrowpanel = new JPanel();
		EastButtonpanel.add(EastArrowpanel, "EastArrowpanel");
		EastArrowpanel.setLayout(new BorderLayout(0, 0));		
		
		EastLeftArrowButton.setBackground(Color.CYAN);
		EastLeftArrowButton.setIcon(new ImageIcon(InterfaceGraphique.class.getResource("/media/Left.png")));
		EastArrowpanel.add(EastLeftArrowButton, BorderLayout.CENTER);
		EastLeftArrowButton.addActionListener(new EastLeftbuttonListener());
		
		EastRightArrowButton.setBackground(Color.CYAN);
		EastRightArrowButton.setIcon(new ImageIcon(InterfaceGraphique.class.getResource("/media/Right.png")));
		EastArrowpanel.add(EastRightArrowButton, BorderLayout.EAST);
		EastRightArrowButton.addActionListener(new EastRightbuttonListener());		
		
		EastTopArrowButton.setBackground(Color.CYAN);
		EastTopArrowButton.setIcon(new ImageIcon(InterfaceGraphique.class.getResource("/media/Top.png")));		
		EastArrowpanel.add(EastTopArrowButton, BorderLayout.NORTH);
		EastTopArrowButton.addActionListener(new EastTopbuttonListener());		
		
		EastBottomArrowButton.setBackground(Color.CYAN);
		EastBottomArrowButton.setIcon(new ImageIcon(InterfaceGraphique.class.getResource("/media/Bottom.png")));		
		EastArrowpanel.add(EastBottomArrowButton, BorderLayout.SOUTH);	
		EastBottomArrowButton.addActionListener(new EastBottombuttonListener());
		
		NettoyeurLibre.setFont(new Font("SansSerif", Font.BOLD, 12));
		NettoyeurLibre.setBackground(Color.CYAN);
		NettoyeurLibre.setAlignmentX(0.5f);
		EastButtonpanel.add(NettoyeurLibre);
		NettoyeurLibre.addActionListener(new NettoyeurLibreListener(M));
					
		QuitterEast.setFont(new Font("SansSerif", Font.BOLD, 12));
		QuitterEast.setBackground(Color.CYAN);
		QuitterEast.setAlignmentX(0.5f);
		QuitterEast.addActionListener(new QuitterListener());
		EastButtonpanel.add(QuitterEast);	
		
		/******************************************************* Panel de CENTRE *******************************************************/
				
		JPanel Centerpanel = new JPanel();		
		Centerpanel.setLayout(new GridLayout(10, 10));	    
		
		for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10; j++) {
            	TabButton[i][j] = new JButton();
            	TabButton[i][j].setPreferredSize(new Dimension(100, 100));            	           	
            	Centerpanel.add(TabButton[i][j]); } }	
		
		/******************************************************* Panel Principal **************************************************************/
		
		JPanel PrincipalWindow = new JPanel();
		frame.getContentPane().add(PrincipalWindow, "PrincipalWindow");
		PrincipalWindow.setLayout(new BorderLayout(0, 0));
		
		/*********************************************** Rajout des panel au panel Principal **************************************************/
		
		PrincipalWindow.add(Northpanel,BorderLayout.NORTH);	
		PrincipalWindow.add(Southpanel,BorderLayout.SOUTH);
		PrincipalWindow.add(Westpanel, BorderLayout.WEST);
		PrincipalWindow.add(Eastpanel, BorderLayout.EAST);
		PrincipalWindow.add(Centerpanel,BorderLayout.CENTER);	
		
	}
	
	/******************************************************* Classes Listener des bouton *******************************************************/
	
	class QuitterListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == QuitterEast || e.getSource() == QuitterWest || e.getSource() == QuitterNorth)
				System.exit(-1);
		}			
	}
	
	class ActualiserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Actualiser) 
				for (int i = 0; i < 10 ; i++) {
					for (int j = 0; j < 10 ; j++) {
						TabButton[i][j].setBackground(null);}}
	}}
		
	class PolluerListener extends RobotPollueur implements ActionListener{
		public PolluerListener(Monde m) {super(m);}
		
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Polluer)   
			RP = new RobotPollueur(M);
			try {
				RP.parcourir(M);
			} catch (ErrRobot e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			for (int i = 0; i < 10 ; i++) {
	            for (int j = 0; j < 10; j++) {
	            	if(M.test_PG(i, j))
	            		TabButton[i][j].setBackground(Color.BLACK);	
	            		
			}}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}
		
	}
	
	class PolluerLibreListener extends RobotpollueurLibre implements ActionListener{
		public PolluerLibreListener(Monde m) {super(m);}

	public void actionPerformed(ActionEvent e) {
		int Nbr = Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer le nombre de case à polluer", "Choix"));
		if(e.getSource() == PollueurLibre)   
			RpL = new RobotpollueurLibre(M);			
			try {
				RpL.parcourir(Nbr,M);
			} catch (ErrRobot e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int i = 0; i < 10 ; i++) {
	            for (int j = 0; j < 10; j++) {
	            	if(M.test_PG(i, j))
	            		TabButton[i][j].setBackground(Color.BLACK);
			} }NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());
	
}}	

	class PollueurTDListener extends RobotpollueurToutDroit implements ActionListener{
		public PollueurTDListener(int colDepart, Monde M) {super(colDepart, M);}
			public void actionPerformed(ActionEvent e) {
				int ColDepart = Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));
				if(e.getSource() == PollueurDroit)
						if(ColDepart< 10 || ColDepart>0) {
							RpTD = new RobotpollueurToutDroit(ColDepart, M);
							try {
								RpTD.parcourir();
							} catch (ErrRobot e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for(int i=0; i< 10; i++)							
								TabButton[i][ColDepart].setBackground(Color.BLACK);
        }NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}
	
	class PolluerSauteursListener extends RobotpollueurSauteurs implements ActionListener{
		public PolluerSauteursListener(Monde m) {super(m);}

	public void actionPerformed(ActionEvent e) {
		int ColDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));
		int LigDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la ligne de départ", "Choix"));
		int Saut 		= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer le Saut", "Choix"));
		if(e.getSource() == PollueurSauteur)   
			RpS = new RobotpollueurSauteurs(M);			
			try {
				RpS.parcourir(LigDepart ,ColDepart, Saut, M);
			} catch (ErrRobot e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			for (int i = 0; i < 10 ; i++) {
	            for (int j = 0; j < 10; j++) {
	            	if(M.test_PG(i, j))
	            		TabButton[i][j].setBackground(Color.BLACK);
			} }NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());
	
}}	
	
	class NettoyerListener extends RobotNettoyeur implements ActionListener{
		public NettoyerListener(Monde m) {super(m);}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Nettoyer)   
				RN = new RobotNettoyeur(M);
				try {
					RN.parcourir(M);
				} catch (ErrRobot e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < 10 ; i++) {
		            for (int j = 0; j < 10; j++) {
		            	if(!M.test_PG(i, j))
		            		TabButton[i][j].setBackground(Color.GREEN);
				}}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}				
	}
	
	class NettoyeurLibreListener extends RobotNettoyeurLibre implements ActionListener{
		public NettoyeurLibreListener(Monde m) {super(m);}

	public void actionPerformed(ActionEvent e) {
		int Nbr = Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer le nombre de case à nettoyer", "Choix"));
		if(e.getSource() == NettoyeurLibre)   
	        RNL = new RobotNettoyeurLibre(M);
	        try {
				RNL.parcourir(Nbr,M);
			} catch (ErrRobot e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int i = 0; i < 10 ; i++) {
	            for (int j = 0; j < 10; j++) {
	            	if(!M.test_PG(i, j))
	            		TabButton[i][j].setBackground(Color.GREEN);
			} }NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());
	
}}
	
	class NettoyeurStandardListener extends RobotNettoyeurStandard implements ActionListener{
		public NettoyeurStandardListener(int colDepart, Monde M) {super(colDepart, M);}
			public void actionPerformed(ActionEvent e) {
				int ColDepart = Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));
				if(e.getSource() == NettoyeurStandard)					
						if(ColDepart< 10 || ColDepart>0) {
					        RNS = new RobotNettoyeurStandard(ColDepart, M);
					        try {
								RNS.parcourir();
							} catch (ErrRobot e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for(int i=0; i< 10; i++)							
								TabButton[i][ColDepart].setBackground(Color.GREEN);
        }NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}

	class NettoyeurSmartListener extends RobotNettoyeurSmart implements ActionListener{
		public NettoyeurSmartListener(Monde m) {super(m);}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == NettoyeurSmart)   
	        RNSm = new RobotNettoyeurSmart(M);
	        try {
				RNSm.parcourir(M);
			} catch (ErrRobot e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();				
			}
			for (int i = 0; i < 10 ; i++) {
	            for (int j = 0; j < 10; j++) {
	            	if(!M.test_PG(i, j))
	            		TabButton[i][j].setBackground(Color.GREEN);
			} }NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());
	
}}
	
	class WestTopbuttonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(ind_poll==0) {
				LigDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la ligne de départ", "Choix"));
			 	ColDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));
			if(e.getSource() == WestTopArrowbutton)				
				if((LigDepart < 10 || LigDepart >0) && (ColDepart< 10 ||  ColDepart>0))
				{	try {
					M.insrt_PG(LigDepart, ColDepart);
				} catch (ErrRobot e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					TabButton[LigDepart][ColDepart].setBackground(Color.BLACK);
			            			ind_poll=1;
				}}
				else
				{
					LigDepart--;
					try {
						M.insrt_PG(LigDepart, ColDepart);
					} catch (ErrRobot e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			TabButton[LigDepart][ColDepart].setBackground(Color.BLACK);
				}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}
	
	class WestBottombuttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(ind_poll==0) {
				LigDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la ligne de départ", "Choix"));
			 	ColDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));
			if(e.getSource() == WestBottomArrowbutton)
				if((LigDepart < 10 || LigDepart >0) && (ColDepart< 10 ||  ColDepart>0))
				{	try {
					M.insrt_PG(LigDepart, ColDepart);
				} catch (ErrRobot e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					TabButton[LigDepart][ColDepart].setBackground(Color.BLACK);
			            			ind_poll=1;
				}}
				else
				{
					LigDepart++;
					try {
						M.insrt_PG(LigDepart, ColDepart);
					} catch (ErrRobot e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			TabButton[LigDepart][ColDepart].setBackground(Color.BLACK);
				}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}				
	
	class WestLeftbuttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(ind_poll==0) {
				LigDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la ligne de départ", "Choix"));
			 	ColDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));
			if(e.getSource() == WestLeftArrowbutton)
				if((LigDepart < 10 || LigDepart >0) && (ColDepart< 10 ||  ColDepart>0))
				{	try {
					M.insrt_PG(LigDepart, ColDepart);
				} catch (ErrRobot e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					TabButton[LigDepart][ColDepart].setBackground(Color.BLACK);
			            			ind_poll=1;
				}}
				else
				{
					ColDepart--;
					try {
						M.insrt_PG(LigDepart, ColDepart);
					} catch (ErrRobot e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			TabButton[LigDepart][ColDepart].setBackground(Color.BLACK);
				}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}
	
	class WestRightbuttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(ind_poll==0) {
				LigDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la ligne de départ", "Choix"));
			 	ColDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));			
			if(e.getSource() == WestRightArrowbutton)
				if((LigDepart < 10 || LigDepart >0) && (ColDepart< 10 ||  ColDepart>0))
				{	try {
					M.insrt_PG(LigDepart, ColDepart);
				} catch (ErrRobot e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					TabButton[LigDepart][ColDepart].setBackground(Color.BLACK);
			            			ind_poll=1;
				}}
				else
				{
					ColDepart++;
					try {
						M.insrt_PG(LigDepart, ColDepart);
					} catch (ErrRobot e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			TabButton[LigDepart][ColDepart].setBackground(Color.BLACK);
				}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}	
	
	class EastTopbuttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(ind_nett==0) {
				LigDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la ligne de départ", "Choix"));
			 	ColDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));
			if(e.getSource() == EastTopArrowButton)
				if((LigDepart < 10 || LigDepart >0) && (ColDepart< 10 ||  ColDepart>0))
				{	try {
					M.get_PG(LigDepart, ColDepart);
				} catch (ErrRobot e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					TabButton[LigDepart][ColDepart].setBackground(Color.GREEN);
			            			ind_nett=1;
				}}
				else
				{
					LigDepart--;
					try {
						M.get_PG(LigDepart, ColDepart);
					} catch (ErrRobot e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			TabButton[LigDepart][ColDepart].setBackground(Color.GREEN);
				}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}
	
	class EastBottombuttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e)  {
			if(ind_nett==0) {
				LigDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la ligne de départ", "Choix"));
			 	ColDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));
			if(e.getSource() == EastBottomArrowButton)
				if((LigDepart < 10 || LigDepart >0) && (ColDepart< 10 ||  ColDepart>0))
				{	try {
					M.get_PG(LigDepart, ColDepart);
				} catch (ErrRobot e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					TabButton[LigDepart][ColDepart].setBackground(Color.GREEN);
			            			ind_nett=1;
				}}
				else
				{
					LigDepart++;
					try {
						M.get_PG(LigDepart, ColDepart);
					} catch (ErrRobot e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			TabButton[LigDepart][ColDepart].setBackground(Color.GREEN);
				}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}
	
	class EastLeftbuttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(ind_nett==0) {
				LigDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la ligne de départ", "Choix"));
			 	ColDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));			
			if(e.getSource() == EastLeftArrowButton)
				if((LigDepart < 10 || LigDepart >0) && (ColDepart< 10 ||  ColDepart>0))
				{	try {
					M.get_PG(LigDepart, ColDepart);
				} catch (ErrRobot e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					TabButton[LigDepart][ColDepart].setBackground(Color.GREEN);
			            			ind_nett=1;
				}}
				else
				{
					ColDepart--;
					try {
						M.get_PG(LigDepart, ColDepart);
					} catch (ErrRobot e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			TabButton[LigDepart][ColDepart].setBackground(Color.GREEN);
				}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}
	
	class EastRightbuttonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(ind_nett==0) {
				LigDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la ligne de départ", "Choix"));
			 	ColDepart 	= Integer.parseInt(JOptionPane.showInputDialog(null,"Veuillez rentrer la Colonne de départ", "Choix"));
			if(e.getSource() == EastRightArrowButton)
				if((LigDepart < 10 || LigDepart >0) && (ColDepart< 10 ||  ColDepart>0))
				{	try {
					M.get_PG(LigDepart, ColDepart);
				} catch (ErrRobot e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					TabButton[LigDepart][ColDepart].setBackground(Color.GREEN);
			            			ind_nett=1;
				}}
				else
				{
					ColDepart++;
					try {
						M.get_PG(LigDepart, ColDepart);
					} catch (ErrRobot e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			TabButton[LigDepart][ColDepart].setBackground(Color.GREEN);
				}NbrPG.setText("Nombre de Papier Gras : " + M.compt_PG());}}
	
	/****************************************************** Launch the application *****************************************************/
	
	public static void main(String[] args) {

		try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} 
		catch (Throwable e) {
				e.printStackTrace();
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						InterfaceGraphique window = new InterfaceGraphique();
						window.frame.setVisible(true);
					} 
				catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
	}
	
	}























		


