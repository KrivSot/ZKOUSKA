package models.gui;

import models.FileOperation.CVSFileOperation;
import models.models.Penize;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class gui extends JFrame {

    JTable jt;
    JButton btnSave;
    int Hodnota;ArrayList<Integer> pocetKs = new ArrayList<>();
    models.FileOperation.CVSFileOperation cvs = new CVSFileOperation();
    String column[]= {"Typ platidla","Nominalni hodnota","pocet ks"};
    Penize penize = new Penize();
    public gui(int width, int height) {
        super("Project PRO2");
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initGui();
        setVisible(true);
    }


    public void initGui(){
        JPanel panelMain = new JPanel(new BorderLayout());
        panelMain.add(initEntryPanel(), BorderLayout.NORTH);
        panelMain.add(initTablePanel(),BorderLayout.CENTER);
        add(panelMain);
    }

    public JPanel initEntryPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JTextField txtArea = new JTextField("",30);
        JButton btnSend = new JButton("Zpracovat");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hodnota = Integer.parseInt(txtArea.getText());
                UploadToTable();
            }
        });

        btnSave = new JButton("Výčetka");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cvs.Save(pocetKs);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnSave.setEnabled(false);
        panel.add(txtArea);
        panel.add(btnSend);
        panel.add(btnSave);
        return panel;
    }

    public JPanel initTablePanel()
    {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        DefaultTableModel model = new DefaultTableModel(column, 0);
        jt=new JTable(model);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        panel.add(sp);

        return panel;
    }

    public void UploadToTable()
    {
        DefaultTableModel tableModel = new DefaultTableModel(column,0);
        int indexPenize = 0; int pocetKS = 0;int index = 0;
        while(this.Hodnota > 0 && indexPenize < 12 && index < 12) {
            pocetKS = 0;
            while (Hodnota >= penize.getHodnota().get(indexPenize)) {
                this.Hodnota = Hodnota - penize.getHodnota().get(indexPenize);
                pocetKS++;
            }
            if(pocetKS > 0) {
                tableModel.insertRow(index, new Object[]{penize.getTyp().get(indexPenize), penize.getHodnota().get(indexPenize), pocetKS});
                index++;
            }
            indexPenize++;
            pocetKs.add(pocetKS);
        }
        jt.setModel(tableModel);
        btnSave.setEnabled(true);
    }
}
