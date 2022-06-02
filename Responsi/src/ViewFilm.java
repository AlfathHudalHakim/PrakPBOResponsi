
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class ViewFilm extends JFrame{
    JLabel lJudul = new JLabel("Judul Film");
    JLabel lAlur = new JLabel("Nilai Alur Film (0-5)");
    JLabel lTokoh = new JLabel("Nilai Penokohan (0-5)");
    JLabel lAct = new JLabel("Nilai Akting (0-5)");
    
    public JTextField tfJudul = new JTextField();
    public JTextField tfAlur = new JTextField();
    public JTextField tfTokoh = new JTextField();
    public JTextField tfAct=  new JTextField();
    
    public JButton butAdd = new JButton("Add");
    public JButton butUpdt = new JButton("Update");
    public JButton butDelt = new JButton("Delete");
    public JButton butReset = new JButton("Reset");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Judul Film", "Alur Film", "Penokohan", "Akting", "Nilai Rating"};

    public ViewFilm() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Film");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,400);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lJudul);
        lJudul.setBounds(510, 30, 160, 30);
        add(tfJudul);
        tfJudul.setBounds(510, 55, 160, 30);
        
        add(lAlur);
        lAlur.setBounds(510, 80, 160, 30);
        add(tfAlur);
        tfAlur.setBounds(510, 105, 160, 30);
        
        add(lTokoh);
        lTokoh.setBounds(510, 130, 160, 30);
        add(tfTokoh);
        tfTokoh.setBounds(510, 155, 160, 30);
        
        add(lAct);
        lAct.setBounds(510, 180, 160, 30);
        add(tfAct);
        tfAct.setBounds(510, 205, 160, 30);
        
        add(butAdd);
        butAdd.setBounds(540, 250, 90, 30);
        
        add(butUpdt);
        butUpdt.setBounds(540, 290, 90, 30);
        
        add(butDelt);
        butDelt.setBounds(280, 330, 90, 30);
        
        add(butReset);
        butReset.setBounds(180, 330, 90, 30);
    }
    
    public String getJudul(){
        return tfJudul.getText();
    }
    
    public String getAlurFilm(){
        return tfAlur.getText();
    }
    
    public String getPenokohan(){
        return tfTokoh.getText();
    }
    
    public String getAkting(){
        return tfAct.getText();
    }
}

