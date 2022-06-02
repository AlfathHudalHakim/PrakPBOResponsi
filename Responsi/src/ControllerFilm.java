/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author LENOVO
 */
public class ControllerFilm {

   ModelFilm modelContact;
    ViewFilm FilmView;
    public String data;

    public ControllerFilm(ModelFilm modelContact, ViewFilm FilmView) {
        this.modelContact = modelContact;
        this.FilmView = FilmView;
        
        
            if (modelContact.getBanyakData()!=0) {
            String dataFilm[][] = modelContact.readContact();
            FilmView.tabel.setModel((new JTable(dataFilm, FilmView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
             
         FilmView.butAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    double x=0,y=0,z=0;
                    try{
                 x=Double.parseDouble(FilmView.tfAlur.getText());
                 y=Double.parseDouble(FilmView.tfTokoh.getText());
                  z=Double.parseDouble(FilmView.tfAct.getText());
                  }
                  catch (Exception ex){
                      System.out.println(" ");
                  }
                if(FilmView.tfAct.getText().equals("") || FilmView.tfAlur.getText().equals("")|| FilmView.tfJudul.getText().equals("")|| FilmView.tfTokoh.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Inputan Harus Berisi Karakter");  
               
                }
               
                else if(x<0 || x>5 ||y<0 || y>5  ||z<0 || z>5){
                  JOptionPane.showMessageDialog(null,"Range (0-5)");
                }
                else{
                String Judul = FilmView.getJudul();
                double AlurFilm = Double.parseDouble(FilmView.getAlurFilm());
                double Tokoh = Double.parseDouble(FilmView.getPenokohan());
                double Act = Double.parseDouble(FilmView.getAkting());
                double Nilai = (AlurFilm+Tokoh+Act)/3;
                modelContact.insertData(Judul, AlurFilm, Tokoh, Act, Nilai);
         
                String dataFilm[][] = modelContact.readContact();
                FilmView.tabel.setModel((new JTable(dataFilm, FilmView.namaKolom)).getModel());
                }

            }
        });
         
          FilmView.butUpdt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String Judul = FilmView.getJudul();
                double AlurFilm = Double.parseDouble(FilmView.getAlurFilm());
                double Tokoh = Double.parseDouble(FilmView.getPenokohan());
                double Act = Double.parseDouble(FilmView.getAkting());
                double Nilai = (AlurFilm+Tokoh+Act)/3;
                modelContact.updateData(Judul, AlurFilm, Tokoh, Act, Nilai);

                String dataFilm[][] = modelContact.readContact();
                FilmView.tabel.setModel((new JTable(dataFilm, FilmView.namaKolom)).getModel());
            }
        });
         
          FilmView.butReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                FilmView.tfJudul.setText("");
                FilmView.tfAlur.setText("");
                FilmView.tfTokoh.setText("");
                FilmView.tfAct.setText("");
            }
        });
        
    
          FilmView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = FilmView.tabel.getSelectedRow();
                data = FilmView.tabel.getValueAt(baris, 0).toString();
                String dataUpdt[] = new String[4];
                dataUpdt[0] = FilmView.tabel.getValueAt(baris, 0).toString();
                dataUpdt[1] = FilmView.tabel.getValueAt(baris, 1).toString();
                System.out.println(data);
            }
           });
                  
          FilmView.butDelt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus Judul " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelContact.deleteContact(data);
                String dataFilm[][] = modelContact.readContact();
                FilmView.tabel.setModel((new JTable(dataFilm, FilmView.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });
    }
    
    


}