import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;


public class Gui extends JFrame implements ActionListener{
	
	JFrame vis, rim;

	JLabel insNum, insNum2, l, titolo, titolo2, titolo3, risposta;
	
	JTextArea numero, numero2, array, print;
	
	JButton aggiungi, rimuovi, visualizza, aggiungi2;
	
	ArrayList<Integer> arr;
	
	JScrollPane s;
	
	Font font1, font2, font3;
	Color sfondo, tit, area;
	Gui(){
		font1= new Font("Bodoni MT", Font.PLAIN, 17);
		font2= new Font("Bodoni MT", Font.BOLD, 25);
		font3= new Font("Bodoni MT", Font.BOLD, 17);
		
		sfondo= new Color(179, 236, 255);
		tit= new Color(0, 115, 153);
		area= new Color(0, 172, 230);
		
		arr= new ArrayList<Integer>();
		
		//FRAME INIZIALE
		titolo= new JLabel("ARRAYLIST GUI");
		titolo.setBounds(195, 20, 200, 50);
		titolo.setFont(font2);
		titolo.setForeground(tit);
		this.add(titolo);
		
		insNum= new JLabel("Inserisci un numero: ");
		insNum.setBounds(30, 140, 200, 50);
		insNum.setFont(font1);
		insNum.setForeground(tit);
		this.add(insNum);
		
		numero= new JTextArea();
		numero.setBounds(190, 155, 200, 25);
		numero.setFont(font3);
		numero.setBackground(tit);
		numero.setForeground(sfondo);
		this.add(numero);
		
		aggiungi= new JButton("Aggiungi");
		aggiungi.setBounds(412, 82, 150, 50);
		aggiungi.setFont(font3);
		aggiungi.setBackground(tit);
		aggiungi.setForeground(sfondo);
		this.add(aggiungi);
		
		rimuovi= new JButton("Rimuovi");
		rimuovi.setBounds(412, 142, 150, 50);
		rimuovi.setFont(font3);
		rimuovi.setBackground(tit);
		rimuovi.setForeground(sfondo);
		this.add(rimuovi);
		
		visualizza= new JButton("Visualizza");
		visualizza.setBounds(412, 202, 150, 50);
		visualizza.setFont(font3);
		visualizza.setBackground(tit);
		visualizza.setForeground(sfondo);
		this.add(visualizza);
		
		aggiungi.addActionListener(this);
		rimuovi.addActionListener(this);
		visualizza.addActionListener(this);
		
		//FRAME VISUALIZZA
		vis= new JFrame();
		vis.getContentPane().setBackground(sfondo);
		vis.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		vis.setResizable(false);
		vis.setSize(600, 325);
		vis.setVisible(false);
		vis.setTitle("VISUALIZZA");
		vis.setLocation(600, 0);
		
		titolo2= new JLabel("VISUALIZZA ARRAYLIST");
		titolo2.setBounds(145, 20, 300, 50);
		titolo2.setFont(font2);
		titolo2.setForeground(tit);
		vis.add(titolo2);
		
		
		
		array= new JTextArea();
		array.setFont(font3);
		array.setBackground(tit);
		array.setForeground(sfondo);
		array.setEditable(false);
		vis.add(array);
		
		s= new JScrollPane(array);
		s.setBounds(92, 92, 400, 150);
		vis.add(s);
		
		l= new JLabel();
		vis.add(l);
		
		//FRAME RIMUOVI
		rim= new JFrame();
		rim.getContentPane().setBackground(sfondo);
		rim.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		rim.setResizable(false);
		rim.setSize(600, 325);
		rim.setVisible(false);
		rim.setTitle("RIMUOVI");
		rim.setLocation(1200, 0);
		
		titolo3= new JLabel("RIMUOVI ELEMENTO ARRAYLIST");
		titolo3.setBounds(90, 20, 425, 50);
		titolo3.setFont(font2);
		titolo3.setForeground(tit);
		rim.add(titolo3);
		
		
		insNum2= new JLabel("Inserisci un numero: ");
		insNum2.setBounds(30, 140, 200, 50);
		insNum2.setFont(font1);
		insNum2.setForeground(tit);
		rim.add(insNum2);
		
		numero2= new JTextArea();
		numero2.setBounds(190, 155, 200, 25);
		numero2.setFont(font3);
		numero2.setBackground(tit);
		numero2.setForeground(sfondo);
		rim.add(numero2);
		
		aggiungi2= new JButton("Rimuovi");
		aggiungi2.setBounds(412, 142, 150, 50);
		aggiungi2.setFont(font3);
		aggiungi2.setBackground(tit);
		aggiungi2.setForeground(sfondo);
		rim.add(aggiungi2);
		aggiungi2.addActionListener(this);
		
		risposta= new JLabel("Risposta:");
		risposta.setBounds(115, 220, 100, 25);
		risposta.setFont(font1);
		risposta.setForeground(tit);
		rim.add(risposta);
		
		print= new JTextArea();
		print.setBounds(190, 220, 350, 25);
		print.setFont(font3);
		print.setBackground(tit);
		print.setForeground(sfondo);
		print.setEditable(false);
		rim.add(print);
		
		l= new JLabel();
		rim.add(l);
		
		//PRIMO FRAME
		l= new JLabel();
		this.add(l);
		
		this.setTitle("VERIFICA ARRAYLIST GUI");
		this.getContentPane().setBackground(sfondo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600, 325);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== aggiungi) {
			arr.add(Integer.parseInt(numero.getText()));
			if(arr.size() > 1) {
				int cont= 0;
				for(int i=arr.size()-1; i > 0; i--) {
					for(int j= i-1; j > -1; j--) {				
						if(arr.get(i) < arr.get(j)) {
							cont= arr.get(i);
							arr.set(i, arr.get(j));
							arr.set(j, cont);
						}
					}
				}
			}
			numero.setText("");
		}
		if(e.getSource() == visualizza) {
			vis.setVisible(true);
			String risp= "";
			for(int k= 0; k < arr.size(); k++) {
				risp= risp + arr.get(k) + "\n";
			}
			array.setText(risp);
		}
		if(e.getSource() == rimuovi) {
			rim.setVisible(true);
		}
		if(e.getSource() == aggiungi2) {
			int cont= Integer.parseInt(numero2.getText()), temp= 0;
			for(int i= 0; i < arr.size(); i++) {
				if(cont== arr.get(i)) {
					arr.remove(i);
					temp++;
				}
			}
			if(temp != 0)
				print.setText("Numero rimosso correttamente");
			else
				print.setText("Il numero inserito non è presente nell'arraylist");
				
		}
	}
	
}
