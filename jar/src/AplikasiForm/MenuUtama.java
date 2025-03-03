
package AplikasiForm;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import method.sumbKematian.ControlDuka;
import method.sumbKematian.DataDuka;
import method.sumbPenguburan.ControlKubur;
import method.sumbPenguburan.DataKubur;
import method.sumbnikah.ControlNikah;
import method.sumbnikah.DataNikah;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class MenuUtama extends javax.swing.JFrame {

    public int jmlRupiah;
    String tglNikah;
    String tglDibuat;
    String tglMeninggal;
    
    int x = 0;
    private DefaultTableModel model;
        ControlNikah CN = new ControlNikah();
        DataNikah DN = new DataNikah();
        List<DataNikah> ListDataNikah = new ArrayList<DataNikah>();
        
        ControlDuka CD = new ControlDuka();
        DataDuka DD = new DataDuka();
        List<DataDuka> ListDataDuka = new ArrayList<DataDuka>();
        
        ControlKubur CK = new ControlKubur();
        DataKubur DK = new DataKubur();
        List<DataKubur> ListDataKubur = new ArrayList<DataKubur>();
        
        Color c1 = new Color(0,204,204);
        Color c2 = new Color(47,71,106);
        

                
     private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Users-icon.png")));
    }
     
    
    public MenuUtama() {
        initComponents();
        logoutPanel.setVisible(false);
        setIcon();
    }
    
    private void bersihkanNikah(){
        txtCabang.setSelectedIndex(0);
        txtNik.setText("");
        txtNama.setText("");
        txtJc.setSelectedIndex(0);
        txtNorek.setText("");
        txtJmlrupiah.setText("");
        txtTglnikah.setDate(null);
        txtTgldibuat.setDate(null);
    }
    
        private void buatTableNikah(){
        model = new DefaultTableModel();
        model.addColumn("CABANG");
        model.addColumn("NIK");
        model.addColumn("NAMA");
        model.addColumn("JC");
        model.addColumn("NO. REK.");
        model.addColumn("JML Rp.");
        model.addColumn("TGL NIKAH");
        model.addColumn("TGL DIBUAT");
        tabelData2.setModel(model);
    }
    
    private void showTableNikah1(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ListDataNikah.clear();
        ListDataNikah = CN.tampil();
            for (x=0; x<ListDataNikah.size(); x++){
            Object[] data = new Object[8];
            data[0]=ListDataNikah.get(x).getCabang();
            data[1]=ListDataNikah.get(x).getNik();
            data[2]=ListDataNikah.get(x).getNama();
            data[3]=ListDataNikah.get(x).getJc();
            data[4]=ListDataNikah.get(x).getNorek();
            data[5]=ListDataNikah.get(x).getJml();
            data[6]=ListDataNikah.get(x).getTgl_nikah();
            data[7]=ListDataNikah.get(x).getTgl_dibuat();
            model.addRow(data);
        }
    }
    
    private void showtableNikah2(){
        DefaultTableModel dataModel = (DefaultTableModel) tabelData1.getModel();
        List list = new ArrayList<>();
        tabelData1.setAutoCreateColumnsFromModel(true);
        list.add(txtCabang.getSelectedItem());
        list.add(txtNik.getText());
        list.add(txtNama.getText());
        list.add(txtJc.getSelectedItem());
        list.add(txtNorek.getText());
        list.add(txtJmlrupiah.getText());
        list.add(tglNikah);
        list.add(tglDibuat);
        dataModel.addRow(list.toArray());
    }
    
   
    private void bersihkanDuka(){
        txtCabang1.setSelectedIndex(0);
        txtNik1.setText("");
        txtNama1.setText("");
        txtJc1.setSelectedIndex(0);
        txtNorek1.setText("");
        txtJmlrupiah1.setText("");
        txtTglmeninggal.setDate(null);
        txtTgldibuat1.setDate(null);
    }
    
        private void buatTableDuka(){
        model = new DefaultTableModel();
        model.addColumn("CABANG");
        model.addColumn("NIK");
        model.addColumn("NAMA");
        model.addColumn("JC");
        model.addColumn("NO. REK.");
        model.addColumn("JML Rp.");
        model.addColumn("TGL MENINGGAL");
        model.addColumn("TGL DIBUAT");
        tabelData4.setModel(model);
    }
    
    private void showTableDuka1(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ListDataDuka.clear();
        ListDataDuka = CD.tampil();
            for (x=0; x<ListDataDuka.size(); x++){
            Object[] data = new Object[8];
            data[0]=ListDataDuka.get(x).getCabang1();
            data[1]=ListDataDuka.get(x).getNik1();
            data[2]=ListDataDuka.get(x).getNama1();
            data[3]=ListDataDuka.get(x).getJc1();
            data[4]=ListDataDuka.get(x).getNorek1();
            data[5]=ListDataDuka.get(x).getJml1();
            data[6]=ListDataDuka.get(x).getTgl_meninggal();
            data[7]=ListDataDuka.get(x).getTgl_dibuat1();
            model.addRow(data);
        }
    }
    
    private void showTableDuka2(){
        DefaultTableModel dataModel = (DefaultTableModel) tabelData3.getModel();
        List list = new ArrayList<>();
        tabelData3.setAutoCreateColumnsFromModel(true);
        list.add(txtCabang1.getSelectedItem());
        list.add(txtNik1.getText());
        list.add(txtNama1.getText());
        list.add(txtJc1.getSelectedItem());
        list.add(txtNorek1.getText());
        list.add(txtJmlrupiah1.getText());
        list.add(tglMeninggal);
        list.add(tglDibuat);
        dataModel.addRow(list.toArray());
    }

     private void buatTableKubur(){
        model = new DefaultTableModel();
        model.addColumn("CABANG");
        model.addColumn("NIK");
        model.addColumn("NAMA");
        model.addColumn("JC");
        model.addColumn("NO. REK.");
        model.addColumn("JML Rp.");
        model.addColumn("TGL MENINGGAL");
        model.addColumn("TGL DIBUAT");
        tabelData5.setModel(model);
    }
     
         private void showTableKubur1(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ListDataKubur.clear();
        ListDataKubur = CK.tampil();
            for (x=0; x<ListDataKubur.size(); x++){
            Object[] data = new Object[8];
            data[0]=ListDataKubur.get(x).getCabang2();
            data[1]=ListDataKubur.get(x).getNik2();
            data[2]=ListDataKubur.get(x).getNama2();
            data[3]=ListDataKubur.get(x).getJc2();
            data[4]=ListDataKubur.get(x).getNorek2();
            data[5]=ListDataKubur.get(x).getJml2();
            data[6]=ListDataKubur.get(x).getTgl_meninggal();
            data[7]=ListDataKubur.get(x).getTgl_dibuat2();
            model.addRow(data);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        panelMenuHome = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        panelMenuData = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        LabelSubmenu = new javax.swing.JLabel();
        mainPanel = new keeptoo.KGradientPanel();
        homePanel = new keeptoo.KGradientPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        logoutPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        inputPanel = new keeptoo.KGradientPanel();
        jLabel12 = new javax.swing.JLabel();
        panelInputNikah = new javax.swing.JPanel();
        labelSumbangan1 = new javax.swing.JLabel();
        labelNikah = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelInputKematian = new javax.swing.JPanel();
        labelKematian = new javax.swing.JLabel();
        labelSumbangan2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panelInputPenguburan = new javax.swing.JPanel();
        labelSumbangan3 = new javax.swing.JLabel();
        labelPenguburan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataSumbNikah = new keeptoo.KGradientPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelData2 = new javax.swing.JTable();
        jLabel84 = new javax.swing.JLabel();
        penutupParam = new keeptoo.KGradientPanel();
        btnHapusDataNikah = new javax.swing.JButton();
        btnTambahDataNikah = new javax.swing.JButton();
        txtCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtParamNikah1 = new javax.swing.JTextField();
        btnKembaliSumbNikah1 = new javax.swing.JButton();
        sumbnikahPanel = new keeptoo.KGradientPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtNik = new javax.swing.JTextField();
        txtJmlrupiah = new javax.swing.JTextField();
        txtNorek = new javax.swing.JTextField();
        txtJc = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelData1 = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        txtTglnikah = new com.toedter.calendar.JDateChooser();
        txtTgldibuat = new com.toedter.calendar.JDateChooser();
        jLabel86 = new javax.swing.JLabel();
        txtCabang = new javax.swing.JComboBox();
        btnPrintSumbNikah = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtParamNikah2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnKembaliSumbNikah = new javax.swing.JButton();
        dataSumbKematian = new keeptoo.KGradientPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelData4 = new javax.swing.JTable();
        penutupParam1 = new keeptoo.KGradientPanel();
        jLabel85 = new javax.swing.JLabel();
        btnHapusDataNikah1 = new javax.swing.JButton();
        btnTambahDataNikah1 = new javax.swing.JButton();
        txtCari1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtParamNikah4 = new javax.swing.JTextField();
        btnKembaliSumbNikah3 = new javax.swing.JButton();
        sumbKematianPanel = new keeptoo.KGradientPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtNama1 = new javax.swing.JTextField();
        txtNik1 = new javax.swing.JTextField();
        txtJmlrupiah1 = new javax.swing.JTextField();
        txtNorek1 = new javax.swing.JTextField();
        txtJc1 = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelData3 = new javax.swing.JTable();
        btnSimpan1 = new javax.swing.JButton();
        txtTglmeninggal = new com.toedter.calendar.JDateChooser();
        txtTgldibuat1 = new com.toedter.calendar.JDateChooser();
        jLabel87 = new javax.swing.JLabel();
        txtCabang1 = new javax.swing.JComboBox();
        btnPrintSumbNikah1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtParamDuka2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnKembaliSumbNikah2 = new javax.swing.JButton();
        dataSumbPenguburan = new keeptoo.KGradientPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelData5 = new javax.swing.JTable();
        penutupParam2 = new keeptoo.KGradientPanel();
        jLabel88 = new javax.swing.JLabel();
        btnHapusDataNikah2 = new javax.swing.JButton();
        txtCari2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtParamNikah5 = new javax.swing.JTextField();
        btnKembaliSumbNikah4 = new javax.swing.JButton();
        btnPrintSumbNikah2 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI FORM SUMBANGAN");
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 204, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 255, 204));
        kGradientPanel1.setName("Aplikasi Form Bukti"); // NOI18N
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        kGradientPanel3.setkEndColor(new java.awt.Color(47, 71, 106));
        kGradientPanel3.setkStartColor(new java.awt.Color(47, 71, 106));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hi, Personalia");

        panelMenuHome.setBackground(new java.awt.Color(0, 204, 204));
        panelMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMenuHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelMenuHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelMenuHomeMouseExited(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Home-icon_4.png"))); // NOI18N
        jLabel7.setText(" Home");

        javax.swing.GroupLayout panelMenuHomeLayout = new javax.swing.GroupLayout(panelMenuHome);
        panelMenuHome.setLayout(panelMenuHomeLayout);
        panelMenuHomeLayout.setHorizontalGroup(
            panelMenuHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuHomeLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuHomeLayout.setVerticalGroup(
            panelMenuHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMenuData.setBackground(new java.awt.Color(0, 204, 204));
        panelMenuData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMenuDataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelMenuDataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelMenuDataMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Add-icon.png"))); // NOI18N
        jLabel8.setText(" Kelola Data");

        javax.swing.GroupLayout panelMenuDataLayout = new javax.swing.GroupLayout(panelMenuData);
        panelMenuData.setLayout(panelMenuDataLayout);
        panelMenuDataLayout.setHorizontalGroup(
            panelMenuDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuDataLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuDataLayout.setVerticalGroup(
            panelMenuDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Users-icon.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenuHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMenuData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel13)))
                .addGap(43, 43, 43))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(panelMenuHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelMenuData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );

        kGradientPanel1.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 510));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkGradientFocus(1000);
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kGradientPanel2MouseDragged(evt);
            }
        });
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelSubmenu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        LabelSubmenu.setForeground(new java.awt.Color(0, 0, 102));
        LabelSubmenu.setText("   =");
        LabelSubmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelSubmenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelSubmenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabelSubmenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LabelSubmenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LabelSubmenuMouseReleased(evt);
            }
        });
        kGradientPanel2.add(LabelSubmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 40, 50));

        kGradientPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 0, 720, 40));

        mainPanel.setkEndColor(new java.awt.Color(204, 255, 204));
        mainPanel.setkStartColor(new java.awt.Color(153, 255, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        homePanel.setkEndColor(new java.awt.Color(245, 245, 245));
        homePanel.setkGradientFocus(1000);
        homePanel.setkStartColor(new java.awt.Color(245, 245, 245));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 102));
        jLabel15.setText("@Copyright2020");

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 102));
        jLabel16.setText("Home");

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText("Mitra Usaha Terpercaya");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/indogrosir.jpeg"))); // NOI18N

        logoutPanel.setBackground(new java.awt.Color(255, 255, 255));
        logoutPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutPanelMouseExited(evt);
            }
        });
        logoutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Login-icon.png"))); // NOI18N
        jLabel9.setText("Logout");
        logoutPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel29)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(20, 20, 20))
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel16))
                    .addComponent(logoutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        mainPanel.add(homePanel, "card3");

        inputPanel.setkEndColor(new java.awt.Color(245, 245, 245));
        inputPanel.setkGradientFocus(1000);
        inputPanel.setkStartColor(new java.awt.Color(245, 245, 245));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("INPUT");

        panelInputNikah.setBackground(new java.awt.Color(255, 255, 255));
        panelInputNikah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelInputNikahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelInputNikahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelInputNikahMouseExited(evt);
            }
        });
        panelInputNikah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelInputNikahKeyPressed(evt);
            }
        });
        panelInputNikah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSumbangan1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelSumbangan1.setForeground(new java.awt.Color(51, 51, 51));
        labelSumbangan1.setText("Data Sumbangan");
        panelInputNikah.add(labelSumbangan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        labelNikah.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelNikah.setForeground(new java.awt.Color(51, 51, 51));
        labelNikah.setText("Nikah");
        panelInputNikah.add(labelNikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/compose-icon.png"))); // NOI18N
        panelInputNikah.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 100, -1));

        panelInputKematian.setBackground(new java.awt.Color(255, 255, 255));
        panelInputKematian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelInputKematianMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelInputKematianMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelInputKematianMouseExited(evt);
            }
        });
        panelInputKematian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelKematian.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelKematian.setForeground(new java.awt.Color(51, 51, 51));
        labelKematian.setText("Duka");
        panelInputKematian.add(labelKematian, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 154, -1, -1));

        labelSumbangan2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelSumbangan2.setForeground(new java.awt.Color(51, 51, 51));
        labelSumbangan2.setText("Data Sumbangan");
        panelInputKematian.add(labelSumbangan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/compose-icon.png"))); // NOI18N
        panelInputKematian.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, -1));

        panelInputPenguburan.setBackground(new java.awt.Color(255, 255, 255));
        panelInputPenguburan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelInputPenguburanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelInputPenguburanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelInputPenguburanMouseExited(evt);
            }
        });
        panelInputPenguburan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelSumbangan3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelSumbangan3.setForeground(new java.awt.Color(51, 51, 51));
        labelSumbangan3.setText("Data Sumbangan");
        panelInputPenguburan.add(labelSumbangan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        labelPenguburan.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        labelPenguburan.setForeground(new java.awt.Color(51, 51, 51));
        labelPenguburan.setText("Biaya Penguburan");
        panelInputPenguburan.add(labelPenguburan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/compose-icon.png"))); // NOI18N
        panelInputPenguburan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 100, -1));

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(panelInputNikah, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(panelInputKematian, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(panelInputPenguburan, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(47, 47, 47)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInputPenguburan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInputNikah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInputKematian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(194, 194, 194))
        );

        mainPanel.add(inputPanel, "card2");

        dataSumbNikah.setkEndColor(new java.awt.Color(245, 245, 245));
        dataSumbNikah.setkGradientFocus(1000);
        dataSumbNikah.setkStartColor(new java.awt.Color(245, 245, 245));
        dataSumbNikah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelData2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CABANG", "NIK", "NAMA", "JC", "NO. REK.", "JML Rp.", "TGL NIKAH", "TGL DIBUAT"
            }
        ));
        tabelData2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelData2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelData2);

        dataSumbNikah.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 80, 658, 250));

        jLabel84.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 0, 102));
        jLabel84.setText("DATA SUMBANGAN NIKAH");
        dataSumbNikah.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 37, -1, -1));

        penutupParam.setkEndColor(new java.awt.Color(245, 245, 245));
        penutupParam.setkGradientFocus(1000);
        penutupParam.setkStartColor(new java.awt.Color(245, 245, 245));
        penutupParam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        dataSumbNikah.add(penutupParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 700, 310));

        btnHapusDataNikah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/delete-icon.png"))); // NOI18N
        btnHapusDataNikah.setText(" Hapus Data");
        btnHapusDataNikah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusDataNikahActionPerformed(evt);
            }
        });
        dataSumbNikah.add(btnHapusDataNikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 130, 40));

        btnTambahDataNikah.setIcon(new javax.swing.ImageIcon("D:\\Library & Project Java\\icon\\add-icon.png")); // NOI18N
        btnTambahDataNikah.setText(" Tambah Data");
        btnTambahDataNikah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataNikahActionPerformed(evt);
            }
        });
        dataSumbNikah.add(btnTambahDataNikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 140, 40));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        dataSumbNikah.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 120, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("CARI DATA :");
        dataSumbNikah.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, 30));

        txtParamNikah1.setEditable(false);
        txtParamNikah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParamNikah1ActionPerformed(evt);
            }
        });
        dataSumbNikah.add(txtParamNikah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 40, -1));

        btnKembaliSumbNikah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Go-back-icon.png"))); // NOI18N
        btnKembaliSumbNikah1.setText(" Kembali");
        btnKembaliSumbNikah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliSumbNikah1ActionPerformed(evt);
            }
        });
        dataSumbNikah.add(btnKembaliSumbNikah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 110, 40));

        mainPanel.add(dataSumbNikah, "card10");

        sumbnikahPanel.setkEndColor(new java.awt.Color(245, 245, 245));
        sumbnikahPanel.setkStartColor(new java.awt.Color(245, 245, 245));
        sumbnikahPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        sumbnikahPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 34, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 102));
        jLabel36.setText("Nama");
        sumbnikahPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 102));
        jLabel37.setText("Nik");
        sumbnikahPanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 102));
        jLabel38.setText("Job Class");
        sumbnikahPanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 102));
        jLabel39.setText("Jumlah Rp.");
        sumbnikahPanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 102));
        jLabel40.setText("Tanggal Nikah");
        sumbnikahPanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 102));
        jLabel41.setText("No. Rek");
        sumbnikahPanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 80, -1));

        jLabel43.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 102));
        jLabel43.setText("Tanggal dibuat");
        sumbnikahPanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 140, -1));

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        sumbnikahPanel.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 140, -1));

        txtNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNikActionPerformed(evt);
            }
        });
        sumbnikahPanel.add(txtNik, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 140, -1));

        txtJmlrupiah.setEditable(false);
        txtJmlrupiah.setBackground(new java.awt.Color(204, 204, 204));
        txtJmlrupiah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJmlrupiahActionPerformed(evt);
            }
        });
        sumbnikahPanel.add(txtJmlrupiah, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 140, -1));

        txtNorek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNorekActionPerformed(evt);
            }
        });
        sumbnikahPanel.add(txtNorek, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 140, -1));

        txtJc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "A1", "A2", "A3", "B1", "B2", "B3" }));
        txtJc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJcActionPerformed(evt);
            }
        });
        sumbnikahPanel.add(txtJc, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 60, -1));

        tabelData1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CABANG", "NIK", "NAMA", "JC", "NO. REK.", "JML Rp.", "TGL NIKAH", "TGL DIBUAT"
            }
        ));
        tabelData1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelData1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelData1);

        sumbnikahPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 680, 100));

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Save-icon.png"))); // NOI18N
        btnSimpan.setText(" Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        sumbnikahPanel.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 110, 40));

        txtTglnikah.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTglnikahPropertyChange(evt);
            }
        });
        sumbnikahPanel.add(txtTglnikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 140, -1));

        txtTgldibuat.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTgldibuatPropertyChange(evt);
            }
        });
        sumbnikahPanel.add(txtTgldibuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 140, -1));

        jLabel86.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 102));
        jLabel86.setText("Cabang");
        sumbnikahPanel.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        txtCabang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "KMY", "TGR", "CPG", "BKS", "KRW", "CPT", "BGR", "BDG", "SMG", "YOG", "SLO", "MLG", "SBY", "BMS", "PLG", "PKU", "BDL", "MDN", "PTK", "SMD", "JBI", "MKS", "KRI", "MDO", "AMB" }));
        sumbnikahPanel.add(txtCabang, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 60, -1));

        btnPrintSumbNikah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Printer-green-icon.png"))); // NOI18N
        btnPrintSumbNikah.setText(" Print");
        btnPrintSumbNikah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintSumbNikahActionPerformed(evt);
            }
        });
        sumbnikahPanel.add(btnPrintSumbNikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 110, 40));

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        txtParamNikah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParamNikah2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParamNikah2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtParamNikah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        sumbnikahPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 50, 40));

        btnKembaliSumbNikah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Go-back-icon.png"))); // NOI18N
        btnKembaliSumbNikah.setText(" Kembali");
        btnKembaliSumbNikah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliSumbNikahActionPerformed(evt);
            }
        });
        sumbnikahPanel.add(btnKembaliSumbNikah, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 110, 40));

        mainPanel.add(sumbnikahPanel, "card6");

        dataSumbKematian.setkEndColor(new java.awt.Color(245, 245, 245));
        dataSumbKematian.setkGradientFocus(1000);
        dataSumbKematian.setkStartColor(new java.awt.Color(245, 245, 245));
        dataSumbKematian.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelData4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CABANG", "NIK", "NAMA", "JC", "NO. REK.", "JML Rp.", "TGL MENINGGAL", "TGL DIBUAT"
            }
        ));
        tabelData4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelData4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelData4);

        dataSumbKematian.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 80, 658, 250));

        penutupParam1.setkEndColor(new java.awt.Color(245, 245, 245));
        penutupParam1.setkGradientFocus(1000);
        penutupParam1.setkStartColor(new java.awt.Color(245, 245, 245));
        penutupParam1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 102));
        jLabel85.setText("DATA SUMBANGAN DUKA");
        penutupParam1.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        dataSumbKematian.add(penutupParam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 700, 310));

        btnHapusDataNikah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/delete-icon.png"))); // NOI18N
        btnHapusDataNikah1.setText(" Hapus Data");
        btnHapusDataNikah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusDataNikah1ActionPerformed(evt);
            }
        });
        dataSumbKematian.add(btnHapusDataNikah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 130, 40));

        btnTambahDataNikah1.setIcon(new javax.swing.ImageIcon("D:\\Library & Project Java\\icon\\add-icon.png")); // NOI18N
        btnTambahDataNikah1.setText(" Tambah Data");
        btnTambahDataNikah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahDataNikah1ActionPerformed(evt);
            }
        });
        dataSumbKematian.add(btnTambahDataNikah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 140, 40));

        txtCari1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCari1KeyReleased(evt);
            }
        });
        dataSumbKematian.add(txtCari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 120, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("CARI DATA :");
        dataSumbKematian.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, 30));

        txtParamNikah4.setEditable(false);
        txtParamNikah4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParamNikah4ActionPerformed(evt);
            }
        });
        dataSumbKematian.add(txtParamNikah4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 40, -1));

        btnKembaliSumbNikah3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Go-back-icon.png"))); // NOI18N
        btnKembaliSumbNikah3.setText(" Kembali");
        btnKembaliSumbNikah3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliSumbNikah3ActionPerformed(evt);
            }
        });
        dataSumbKematian.add(btnKembaliSumbNikah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 110, 40));

        mainPanel.add(dataSumbKematian, "card10");

        sumbKematianPanel.setkEndColor(new java.awt.Color(245, 245, 245));
        sumbKematianPanel.setkStartColor(new java.awt.Color(245, 245, 245));
        sumbKematianPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        sumbKematianPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 34, -1, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 102));
        jLabel50.setText("Nama");
        sumbKematianPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 102));
        jLabel51.setText("Nik");
        sumbKematianPanel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel52.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 102));
        jLabel52.setText("Job Class");
        sumbKematianPanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel63.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 102));
        jLabel63.setText("Jumlah Rp.");
        sumbKematianPanel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel64.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 0, 102));
        jLabel64.setText("Tanggal Meninggal");
        sumbKematianPanel.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jLabel65.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 102));
        jLabel65.setText("No. Rek");
        sumbKematianPanel.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 80, -1));

        jLabel66.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 102));
        jLabel66.setText("Tanggal Dibuat");
        sumbKematianPanel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 140, -1));

        txtNama1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNama1ActionPerformed(evt);
            }
        });
        sumbKematianPanel.add(txtNama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 140, -1));

        txtNik1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNik1ActionPerformed(evt);
            }
        });
        sumbKematianPanel.add(txtNik1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 140, -1));

        txtJmlrupiah1.setEditable(false);
        txtJmlrupiah1.setBackground(new java.awt.Color(204, 204, 204));
        txtJmlrupiah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJmlrupiah1ActionPerformed(evt);
            }
        });
        sumbKematianPanel.add(txtJmlrupiah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 140, -1));

        txtNorek1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNorek1ActionPerformed(evt);
            }
        });
        sumbKematianPanel.add(txtNorek1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 140, -1));

        txtJc1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "A1", "A2", "A3", "B1", "B2", "B3" }));
        txtJc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJc1ActionPerformed(evt);
            }
        });
        sumbKematianPanel.add(txtJc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 60, -1));

        tabelData3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CABANG", "NIK", "NAMA", "JC", "NO. REK.", "JML Rp.", "TGL MENINGGAL", "TGL DIBUAT"
            }
        ));
        tabelData3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelData3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelData3);

        sumbKematianPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 680, 100));

        btnSimpan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Save-icon.png"))); // NOI18N
        btnSimpan1.setText(" Simpan");
        btnSimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpan1ActionPerformed(evt);
            }
        });
        sumbKematianPanel.add(btnSimpan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 110, 40));

        txtTglmeninggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTglmeninggalPropertyChange(evt);
            }
        });
        sumbKematianPanel.add(txtTglmeninggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 140, -1));

        txtTgldibuat1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTgldibuat1PropertyChange(evt);
            }
        });
        sumbKematianPanel.add(txtTgldibuat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 140, -1));

        jLabel87.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 102));
        jLabel87.setText("Cabang");
        sumbKematianPanel.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        txtCabang1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "KMY", "TGR", "CPG", "BKS", "KRW", "CPT", "BGR", "BDG", "SMG", "YOG", "SLO", "MLG", "SBY", "BMS", "PLG", "PKU", "BDL", "MDN", "PTK", "SMD", "JBI", "MKS", "KRI", "MDO", "AMB" }));
        sumbKematianPanel.add(txtCabang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 60, -1));

        btnPrintSumbNikah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Printer-green-icon.png"))); // NOI18N
        btnPrintSumbNikah1.setText(" Print");
        btnPrintSumbNikah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintSumbNikah1ActionPerformed(evt);
            }
        });
        sumbKematianPanel.add(btnPrintSumbNikah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 400, 110, 40));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));

        txtParamDuka2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParamDuka2ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtParamDuka2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtParamDuka2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sumbKematianPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 50, 40));

        btnKembaliSumbNikah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Go-back-icon.png"))); // NOI18N
        btnKembaliSumbNikah2.setText(" Kembali");
        btnKembaliSumbNikah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliSumbNikah2ActionPerformed(evt);
            }
        });
        sumbKematianPanel.add(btnKembaliSumbNikah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 110, 40));

        mainPanel.add(sumbKematianPanel, "card6");

        dataSumbPenguburan.setkEndColor(new java.awt.Color(245, 245, 245));
        dataSumbPenguburan.setkGradientFocus(1000);
        dataSumbPenguburan.setkStartColor(new java.awt.Color(245, 245, 245));
        dataSumbPenguburan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelData5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CABANG", "NIK", "NAMA", "JC", "NO. REK.", "JML Rp.", "TGL MENINGGAL", "TGL DIBUAT"
            }
        ));
        tabelData5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelData5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelData5);

        dataSumbPenguburan.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 80, 658, 250));

        penutupParam2.setkEndColor(new java.awt.Color(245, 245, 245));
        penutupParam2.setkGradientFocus(1000);
        penutupParam2.setkStartColor(new java.awt.Color(245, 245, 245));
        penutupParam2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 0, 102));
        jLabel88.setText("DATA SUMBANGAN BIAYA PENGUBURAN");
        penutupParam2.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        dataSumbPenguburan.add(penutupParam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 700, 310));

        btnHapusDataNikah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/delete-icon.png"))); // NOI18N
        btnHapusDataNikah2.setText(" Hapus Data");
        btnHapusDataNikah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusDataNikah2ActionPerformed(evt);
            }
        });
        dataSumbPenguburan.add(btnHapusDataNikah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 140, 40));

        txtCari2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCari2KeyReleased(evt);
            }
        });
        dataSumbPenguburan.add(txtCari2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 120, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("CARI DATA :");
        dataSumbPenguburan.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, -1, 30));

        txtParamNikah5.setEditable(false);
        txtParamNikah5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtParamNikah5ActionPerformed(evt);
            }
        });
        dataSumbPenguburan.add(txtParamNikah5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 40, -1));

        btnKembaliSumbNikah4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Go-back-icon.png"))); // NOI18N
        btnKembaliSumbNikah4.setText(" Kembali");
        btnKembaliSumbNikah4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliSumbNikah4ActionPerformed(evt);
            }
        });
        dataSumbPenguburan.add(btnKembaliSumbNikah4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 120, 40));

        btnPrintSumbNikah2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AplikasiForm/Printer-green-icon.png"))); // NOI18N
        btnPrintSumbNikah2.setText(" Print Data");
        btnPrintSumbNikah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintSumbNikah2ActionPerformed(evt);
            }
        });
        dataSumbPenguburan.add(btnPrintSumbNikah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 130, 40));

        mainPanel.add(dataSumbPenguburan, "card10");

        kGradientPanel1.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 720, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelMenuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuHomeMouseClicked
        // TODO add your handling code here:
        LabelSubmenu.setVisible(true);
        //remove all
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(homePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_panelMenuHomeMouseClicked

    private void panelMenuDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuDataMouseClicked
        // TODO add your handling code here:
        LabelSubmenu.setVisible(false);
        //remove all
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(inputPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_panelMenuDataMouseClicked


    private void LabelSubmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSubmenuMouseClicked
        // TODO add your handling code here:
        logoutPanel.setVisible(true);
        
    }//GEN-LAST:event_LabelSubmenuMouseClicked

    private void kGradientPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel2MouseDragged
        // TODO add your handling code here:
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();
        
        this.setLocation(kordinatX, kordinatY);
        
    }//GEN-LAST:event_kGradientPanel2MouseDragged

    private void txtJcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJcActionPerformed
        // TODO add your handling code here:\
        if (txtJc.getSelectedIndex()==1){
            jmlRupiah = 500000 ;
        }
        else if(txtJc.getSelectedIndex()==2){
            jmlRupiah = 500000 ;
        }
        else if (txtJc.getSelectedIndex()==3){
            jmlRupiah = 500000 ;
        }
        else{
            jmlRupiah = 750000 ;
        }

        txtJmlrupiah.setText(String.valueOf(jmlRupiah));
    }//GEN-LAST:event_txtJcActionPerformed

    private void txtNorekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNorekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNorekActionPerformed

    private void txtJmlrupiahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJmlrupiahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJmlrupiahActionPerformed

    private void txtNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNikActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if( txtCabang.getSelectedItem().equals("") || txtNik.getText().isEmpty() || txtNama.getText().isEmpty() || txtJc.getSelectedItem().equals("")
            || txtNorek.getText().isEmpty() || txtJmlrupiah.getText().isEmpty() || txtTglnikah.getDateFormatString().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data Harus Lengkap", "Aplikasi Form",JOptionPane.INFORMATION_MESSAGE);
        }else {  
                    DN.setCabang(txtCabang.getSelectedItem().toString());
                    DN.setNik(Integer.parseInt(txtNik.getText()));
                    DN.setNama(txtNama.getText());
                    DN.setJc(txtJc.getSelectedItem().toString());
                    DN.setNorek(Integer.parseInt(txtNorek.getText()));
                    DN.setJml(Integer.parseInt(txtJmlrupiah.getText()));
                    DN.setTgl_nikah(tglNikah);
                    DN.setTgl_dibuat(tglDibuat);
               if(CN.tambahdata(DN)==1){
                    JOptionPane.showMessageDialog(null, "Data Telah Di Simpan", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
                    showtableNikah2();
                    //buatTable();
                    //showTable();
                }else {
                    JOptionPane.showMessageDialog(null, "Data Gagal Di Simpan", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
                }
               bersihkanNikah();
//            if(btnTambah.getText().equalsIgnoreCase("Batal")){
//                if(cb.tambahbarang(DB)==1){
//                    JOptionPane.showMessageDialog(null, "Data Telah Di Simpan", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
//                    buatTable();
//                    showTable();
//                }else {
//                    JOptionPane.showMessageDialog(null, "Data Gagal Di Simpan", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//            if(btnEdit.getText().equalsIgnoreCase("Batal")){
//                if(cb.editBarang(DB)==1){
//                    JOptionPane.showMessageDialog(null, "Data Telah Di Rubah", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
//                    buatTable();
//                    showTable();
//                }else{
//                    JOptionPane.showMessageDialog(null, "Data Gagal Di Rubah", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
            
//            siapIsi(false);
//            btnTambah.setText("Tambah");
//            btnEdit.setText("Edit");
//            btnNormal();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtTglnikahPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTglnikahPropertyChange
        // TODO add your handling code here:
        if (txtTglnikah.getDate() !=null) {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           tglNikah = sdf.format(txtTglnikah.getDate());
        }
    }//GEN-LAST:event_txtTglnikahPropertyChange

    private void txtTgldibuatPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTgldibuatPropertyChange
        // TODO add your handling code here:
        if (txtTgldibuat.getDate() !=null) {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           tglDibuat = sdf.format(txtTgldibuat.getDate());
        }
    }//GEN-LAST:event_txtTgldibuatPropertyChange

    private void tabelData1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelData1MouseClicked
        // TODO add your handling code here:
        int baris = tabelData1.getSelectedRow();
        txtParamNikah2.setText(tabelData1.getModel().getValueAt(baris,1).toString());
    }//GEN-LAST:event_tabelData1MouseClicked

    private void tabelData2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelData2MouseClicked
        // TODO add your handling code here:
        int baris = tabelData2.getSelectedRow();
        txtParamNikah1.setText(tabelData2.getModel().getValueAt(baris,1).toString());
    }//GEN-LAST:event_tabelData2MouseClicked

    private void btnPrintSumbNikahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintSumbNikahActionPerformed
        // TODO add your handling code here:
        java.sql.Connection con = null;
        try{
            
            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);
            
            String url = "jdbc:mysql://localhost/sumbangan";
            String user = "root";
            String pass = "";
            
            con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            if(txtParamNikah2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Pada Tabel", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{
            
                String report = ("src\\AplikasiForm\\form1.jrxml");
               
                
                HashMap hash = new HashMap();
                //mengambil parameter dari ireport
                hash.put("nik", txtParamNikah2.getText());
                JasperReport JRpt = JasperCompileManager.compileReport(report);
                JasperPrint JPrint = JasperFillManager.fillReport(JRpt,hash,con);
                JasperViewer.viewReport(JPrint,false);
            }catch(Exception reportException){
                System.out.println("Tidak Bisa Di Cetak : " + reportException);
            }
            }
            
            
            
        }catch (Exception e){
            System.out.println(e);
        }
       
    }//GEN-LAST:event_btnPrintSumbNikahActionPerformed

    private void txtParamNikah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParamNikah1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParamNikah1ActionPerformed

    private void btnTambahDataNikahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataNikahActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
         
        //add panel
        mainPanel.add(sumbnikahPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        buatTableNikah();
        showTableNikah1();
        
    }//GEN-LAST:event_btnTambahDataNikahActionPerformed

    private void btnHapusDataNikahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusDataNikahActionPerformed
        // TODO add your handling code here:
        
        if(txtParamNikah1.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Pada Tabel", "Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            DN.setNik(Integer.parseInt(txtParamNikah1.getText()));
            int pesan = JOptionPane.showConfirmDialog(null, "Data Akan Dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          if(pesan==0){
                if(CN.hapusdata(DN)==1){
                    JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
                    buatTableNikah();
                    showTableNikah1();
                }else{
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }
        }
        }
    }//GEN-LAST:event_btnHapusDataNikahActionPerformed

    private void btnKembaliSumbNikahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliSumbNikahActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
         
        //add panel
        mainPanel.add(dataSumbNikah);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        buatTableNikah();
        showTableNikah1();
    }//GEN-LAST:event_btnKembaliSumbNikahActionPerformed

    private void txtParamNikah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParamNikah2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParamNikah2ActionPerformed

    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked
        // TODO add your handling code here:
        this.dispose();
        Login lg = new Login();
            lg.setVisible(true);
    }//GEN-LAST:event_logoutPanelMouseClicked

    private void LabelSubmenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSubmenuMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_LabelSubmenuMousePressed

    private void LabelSubmenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSubmenuMouseEntered
        // TODO add your handling code here:
        logoutPanel.setVisible(true);
    }//GEN-LAST:event_LabelSubmenuMouseEntered

    private void LabelSubmenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSubmenuMouseExited
        // TODO add your handling code here:
        logoutPanel.setVisible(false);
    }//GEN-LAST:event_LabelSubmenuMouseExited

    private void LabelSubmenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelSubmenuMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_LabelSubmenuMouseReleased

    private void logoutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseEntered
        // TODO add your handling code here:
        logoutPanel.setVisible(true);
    }//GEN-LAST:event_logoutPanelMouseEntered

    private void logoutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseExited
        // TODO add your handling code here:
        logoutPanel.setVisible(false);
    }//GEN-LAST:event_logoutPanelMouseExited

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        String cari = null;
        cari = txtCari.getText();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ListDataNikah.clear();
        ListDataNikah = CN.cariData(cari);
        for (x=0; x<ListDataNikah.size(); x++){
            Object[] data = new Object[8];
            data[0]=ListDataNikah.get(x).getCabang();
            data[1]=ListDataNikah.get(x).getNik();
            data[2]=ListDataNikah.get(x).getNama();
            data[3]=ListDataNikah.get(x).getJc();
            data[4]=ListDataNikah.get(x).getNorek();
            data[5]=ListDataNikah.get(x).getJml();
            data[6]=ListDataNikah.get(x).getTgl_nikah();
            data[7]=ListDataNikah.get(x).getTgl_dibuat();
            model.addRow(data);
        }
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnKembaliSumbNikah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliSumbNikah1ActionPerformed
        // TODO add your handling code here:
        //remove all
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        //add panel
        mainPanel.add(inputPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnKembaliSumbNikah1ActionPerformed

    private void panelMenuHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuHomeMouseEntered
        // TODO add your handling code here:
        panelMenuHome.setBackground(Color.red);
    }//GEN-LAST:event_panelMenuHomeMouseEntered

    private void panelMenuHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuHomeMouseExited
        // TODO add your handling code here:
         panelMenuHome.setBackground(c1);
    }//GEN-LAST:event_panelMenuHomeMouseExited

    private void panelMenuDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuDataMouseEntered
        // TODO add your handling code here:
        panelMenuData.setBackground(Color.red);
    }//GEN-LAST:event_panelMenuDataMouseEntered

    private void panelMenuDataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMenuDataMouseExited
        // TODO add your handling code here:
        panelMenuData.setBackground(c1);
    }//GEN-LAST:event_panelMenuDataMouseExited

    private void panelInputNikahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelInputNikahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelInputNikahKeyPressed

    private void panelInputNikahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInputNikahMouseClicked
        // TODO add your handling code here:
         mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
         
        //add panel
        mainPanel.add(dataSumbNikah);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        buatTableNikah();
        showTableNikah1();
    }//GEN-LAST:event_panelInputNikahMouseClicked

    private void panelInputKematianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInputKematianMouseClicked
        // TODO add your handling code here:
        // TODO add yo//remove panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(dataSumbKematian);
        mainPanel.repaint();
        mainPanel.revalidate();

        buatTableDuka();
        showTableDuka1();
    }//GEN-LAST:event_panelInputKematianMouseClicked

    private void panelInputPenguburanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInputPenguburanMouseClicked
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(dataSumbPenguburan);
        mainPanel.repaint();
        mainPanel.revalidate();

        buatTableKubur();
        showTableKubur1();
        
    }//GEN-LAST:event_panelInputPenguburanMouseClicked

    private void panelInputNikahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInputNikahMouseEntered
        // TODO add your handling code here:
        panelInputNikah.setBackground(c2);
        labelSumbangan1.setForeground(Color.white);
        labelNikah.setForeground(Color.white);
    }//GEN-LAST:event_panelInputNikahMouseEntered

    private void panelInputNikahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInputNikahMouseExited
        // TODO add your handling code here:
        panelInputNikah.setBackground(Color.white);
        labelSumbangan1.setForeground(Color.darkGray);
        labelNikah.setForeground(Color.darkGray);
    }//GEN-LAST:event_panelInputNikahMouseExited

    private void panelInputKematianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInputKematianMouseEntered
        // TODO add your handling code here:
        panelInputKematian.setBackground(c2);
        labelSumbangan2.setForeground(Color.white);
        labelKematian.setForeground(Color.white);
    }//GEN-LAST:event_panelInputKematianMouseEntered

    private void panelInputKematianMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInputKematianMouseExited
        // TODO add your handling code here:
        panelInputKematian.setBackground(Color.white);
        labelSumbangan2.setForeground(Color.darkGray);
        labelKematian.setForeground(Color.darkGray);
    }//GEN-LAST:event_panelInputKematianMouseExited

    private void panelInputPenguburanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInputPenguburanMouseEntered
        // TODO add your handling code here:
        panelInputPenguburan.setBackground(c2);
        labelSumbangan3.setForeground(Color.white);
        labelPenguburan.setForeground(Color.white);
    }//GEN-LAST:event_panelInputPenguburanMouseEntered

    private void panelInputPenguburanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelInputPenguburanMouseExited
        // TODO add your handling code here:
        panelInputPenguburan.setBackground(Color.white);
        labelSumbangan3.setForeground(Color.darkGray);
        labelPenguburan.setForeground(Color.darkGray);
    }//GEN-LAST:event_panelInputPenguburanMouseExited

    private void txtNama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNama1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNama1ActionPerformed

    private void txtNik1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNik1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNik1ActionPerformed

    private void txtJmlrupiah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJmlrupiah1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJmlrupiah1ActionPerformed

    private void txtNorek1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNorek1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNorek1ActionPerformed

    private void txtJc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJc1ActionPerformed
        // TODO add your handling code here:\
        if (txtJc1.getSelectedIndex()==1){
            jmlRupiah = 500000 ;
        }
        else if(txtJc1.getSelectedIndex()==2){
            jmlRupiah = 500000 ;
        }
        else if (txtJc1.getSelectedIndex()==3){
            jmlRupiah = 500000 ;
        }
        else{
            jmlRupiah = 750000 ;
        }

        txtJmlrupiah1.setText(String.valueOf(jmlRupiah));
    }//GEN-LAST:event_txtJc1ActionPerformed

    private void tabelData3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelData3MouseClicked
        // TODO add your handling code here:
        int baris = tabelData3.getSelectedRow();
        txtParamDuka2.setText(tabelData3.getModel().getValueAt(baris,1).toString());
    }//GEN-LAST:event_tabelData3MouseClicked

    private void btnSimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpan1ActionPerformed
        // TODO add your handling code here:
        if( txtCabang1.getSelectedItem().equals("") || txtNik1.getText().isEmpty() || txtNama1.getText().isEmpty() || txtJc1.getSelectedItem().equals("")
            || txtNorek1.getText().isEmpty() || txtJmlrupiah1.getText().isEmpty() || txtTglmeninggal.getDateFormatString().isEmpty()|| txtTgldibuat1.getDateFormatString().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data Harus Lengkap", "Aplikasi Form",JOptionPane.INFORMATION_MESSAGE);
        }else {
            DD.setCabang1(txtCabang1.getSelectedItem().toString());
            DD.setNik1(Integer.parseInt(txtNik1.getText()));
            DD.setNama1(txtNama1.getText());
            DD.setJc1(txtJc1.getSelectedItem().toString());
            DD.setNorek1(Integer.parseInt(txtNorek1.getText()));
            DD.setJml1(Integer.parseInt(txtJmlrupiah1.getText()));
            DD.setTgl_meninggal(tglMeninggal);
            DD.setTgl_dibuat1(tglDibuat);
            if(CD.tambahdata(DD)==1){
                JOptionPane.showMessageDialog(null, "Data Telah Di Simpan", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
                showTableDuka2();
                //buatTable();
                //showTable();
            }else {
                JOptionPane.showMessageDialog(null, "Data Gagal Di Simpan", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
            }
            bersihkanDuka();
            //            if(btnTambah.getText().equalsIgnoreCase("Batal")){
                //                if(cb.tambahbarang(DB)==1){
                    //                    JOptionPane.showMessageDialog(null, "Data Telah Di Simpan", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
                    //                    buatTable();
                    //                    showTable();
                    //                }else {
                    //                    JOptionPane.showMessageDialog(null, "Data Gagal Di Simpan", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
                    //                }
                //            }
            //            if(btnEdit.getText().equalsIgnoreCase("Batal")){
                //                if(cb.editBarang(DB)==1){
                    //                    JOptionPane.showMessageDialog(null, "Data Telah Di Rubah", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
                    //                    buatTable();
                    //                    showTable();
                    //                }else{
                    //                    JOptionPane.showMessageDialog(null, "Data Gagal Di Rubah", "Aplikasi Penjualan",JOptionPane.INFORMATION_MESSAGE);
                    //                }
                //            }

            //            siapIsi(false);
            //            btnTambah.setText("Tambah");
            //            btnEdit.setText("Edit");
            //            btnNormal();
        }
    }//GEN-LAST:event_btnSimpan1ActionPerformed

    private void txtTglmeninggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTglmeninggalPropertyChange
        // TODO add your handling code here:
        if (txtTglmeninggal.getDate() !=null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tglMeninggal = sdf.format(txtTglmeninggal.getDate());
        }
    }//GEN-LAST:event_txtTglmeninggalPropertyChange

    private void txtTgldibuat1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTgldibuat1PropertyChange
        // TODO add your handling code here:
        if (txtTgldibuat1.getDate() !=null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tglDibuat = sdf.format(txtTgldibuat1.getDate());
        }
    }//GEN-LAST:event_txtTgldibuat1PropertyChange

    private void btnPrintSumbNikah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintSumbNikah1ActionPerformed
        // TODO add your handling code here:
        java.sql.Connection con = null;
        try{

            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);

            String url = "jdbc:mysql://localhost/sumbangan";
            String user = "root";
            String pass = "";

            con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            if(txtParamDuka2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Pada Tabel", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{

                    String report = ("src\\AplikasiForm\\form2.jrxml");

                    HashMap hash = new HashMap();
                    //mengambil parameter dari ireport
                    hash.put("nik", txtParamDuka2.getText());
                    JasperReport JRpt = JasperCompileManager.compileReport(report);
                    JasperPrint JPrint = JasperFillManager.fillReport(JRpt,hash,con);
                    JasperViewer.viewReport(JPrint,false);
                }catch(Exception reportException){
                    System.out.println("Tidak Bisa Di Cetak : " + reportException);
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_btnPrintSumbNikah1ActionPerformed

    private void txtParamDuka2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParamDuka2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParamDuka2ActionPerformed

    private void btnKembaliSumbNikah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliSumbNikah2ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(dataSumbKematian);
        mainPanel.repaint();
        mainPanel.revalidate();

        buatTableNikah();
        showTableNikah1();
    }//GEN-LAST:event_btnKembaliSumbNikah2ActionPerformed

    private void tabelData4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelData4MouseClicked
        // TODO add your handling code here:
        int baris = tabelData4.getSelectedRow();
        txtParamNikah4.setText(tabelData4.getModel().getValueAt(baris,1).toString());
    }//GEN-LAST:event_tabelData4MouseClicked

    private void btnHapusDataNikah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusDataNikah1ActionPerformed
        // TODO add your handling code here:

        if(txtParamNikah4.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Pada Tabel", "Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            DD.setNik1(Integer.parseInt(txtParamNikah4.getText()));
            int pesan = JOptionPane.showConfirmDialog(null, "Data Akan Dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(pesan==0){
                if(CD.hapusdata(DD)==1){
                    JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
                    buatTableDuka();
                    showTableDuka1();
                }else{
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
                }
            }
        }
    }//GEN-LAST:event_btnHapusDataNikah1ActionPerformed

    private void btnTambahDataNikah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahDataNikah1ActionPerformed
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(sumbKematianPanel);
        mainPanel.repaint();
        mainPanel.revalidate();

        buatTableDuka();
        showTableDuka1();

    }//GEN-LAST:event_btnTambahDataNikah1ActionPerformed

    private void txtCari1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCari1KeyReleased
        // TODO add your handling code here:
        String cari = null;
        cari = txtCari1.getText();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ListDataDuka.clear();
        ListDataDuka = CD.cariData(cari);
        for (x=0; x<ListDataDuka.size(); x++){
            Object[] data = new Object[8];
            data[0]=ListDataDuka.get(x).getCabang1();
            data[1]=ListDataDuka.get(x).getNik1();
            data[2]=ListDataDuka.get(x).getNama1();
            data[3]=ListDataDuka.get(x).getJc1();
            data[4]=ListDataDuka.get(x).getNorek1();
            data[5]=ListDataDuka.get(x).getJml1();
            data[6]=ListDataDuka.get(x).getTgl_meninggal();
            data[7]=ListDataDuka.get(x).getTgl_dibuat1();
            model.addRow(data);
        }
    }//GEN-LAST:event_txtCari1KeyReleased

    private void txtParamNikah4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParamNikah4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParamNikah4ActionPerformed

    private void btnKembaliSumbNikah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliSumbNikah3ActionPerformed
        // TODO add your handling code here:
        //remove all
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(inputPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnKembaliSumbNikah3ActionPerformed

    private void tabelData5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelData5MouseClicked
        // TODO add your handling code here:
        int baris = tabelData5.getSelectedRow();
        txtParamNikah5.setText(tabelData5.getModel().getValueAt(baris,1).toString());
    }//GEN-LAST:event_tabelData5MouseClicked

    private void btnHapusDataNikah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusDataNikah2ActionPerformed
        // TODO add your handling code here:

        if(txtParamNikah5.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Pada Tabel", "Informasi",JOptionPane.INFORMATION_MESSAGE);
        }else{
            DK.setNik2(Integer.parseInt(txtParamNikah5.getText()));
            int pesan = JOptionPane.showConfirmDialog(null, "Data Akan Dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(pesan==0){
                if(CK.hapusdata(DK)==1){
                    JOptionPane.showMessageDialog(null, "Data Telah Dihapus");
                    buatTableKubur();
                    showTableKubur1();
                }else{
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
                }
            }
        }
    }//GEN-LAST:event_btnHapusDataNikah2ActionPerformed

    private void txtCari2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCari2KeyReleased
        // TODO add your handling code here:
        String cari = null;
        cari = txtCari2.getText();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ListDataKubur.clear();
        ListDataKubur = CK.cariData(cari);
        for (x=0; x<ListDataKubur.size(); x++){
            Object[] data = new Object[8];
            data[0]=ListDataKubur.get(x).getCabang2();
            data[1]=ListDataKubur.get(x).getNik2();
            data[2]=ListDataKubur.get(x).getNama2();
            data[3]=ListDataKubur.get(x).getJc2();
            data[4]=ListDataKubur.get(x).getNorek2();
            data[5]=ListDataKubur.get(x).getJml2();
            data[6]=ListDataKubur.get(x).getTgl_meninggal();
            data[7]=ListDataKubur.get(x).getTgl_dibuat2();
            model.addRow(data);
        }
    }//GEN-LAST:event_txtCari2KeyReleased

    private void txtParamNikah5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtParamNikah5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtParamNikah5ActionPerformed

    private void btnKembaliSumbNikah4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliSumbNikah4ActionPerformed
        // TODO add your handling code here:
        //remove all
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        //add panel
        mainPanel.add(inputPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnKembaliSumbNikah4ActionPerformed

    private void btnPrintSumbNikah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintSumbNikah2ActionPerformed
        // TODO add your handling code here:
        java.sql.Connection con = null;
        try{

            String jdbcDriver = "com.mysql.jdbc.Driver";
            Class.forName(jdbcDriver);

            String url = "jdbc:mysql://localhost/sumbangan";
            String user = "root";
            String pass = "";

            con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();
            if(txtParamNikah5.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Silahkan Pilih Data Pada Tabel", "Informasi",JOptionPane.INFORMATION_MESSAGE);
            }else{
                try{

                    String report = ("src\\AplikasiForm\\form3.jrxml");

                    HashMap hash = new HashMap();
                    //mengambil parameter dari ireport
                    hash.put("nik", txtParamNikah5.getText());
                    JasperReport JRpt = JasperCompileManager.compileReport(report);
                    JasperPrint JPrint = JasperFillManager.fillReport(JRpt,hash,con);
                    JasperViewer.viewReport(JPrint,false);
                }catch(Exception reportException){
                    System.out.println("Tidak Bisa Di Cetak : " + reportException);
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btnPrintSumbNikah2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSubmenu;
    private javax.swing.JButton btnHapusDataNikah;
    private javax.swing.JButton btnHapusDataNikah1;
    private javax.swing.JButton btnHapusDataNikah2;
    private javax.swing.JButton btnKembaliSumbNikah;
    private javax.swing.JButton btnKembaliSumbNikah1;
    private javax.swing.JButton btnKembaliSumbNikah2;
    private javax.swing.JButton btnKembaliSumbNikah3;
    private javax.swing.JButton btnKembaliSumbNikah4;
    private javax.swing.JButton btnPrintSumbNikah;
    private javax.swing.JButton btnPrintSumbNikah1;
    private javax.swing.JButton btnPrintSumbNikah2;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSimpan1;
    private javax.swing.JButton btnTambahDataNikah;
    private javax.swing.JButton btnTambahDataNikah1;
    private keeptoo.KGradientPanel dataSumbKematian;
    private keeptoo.KGradientPanel dataSumbNikah;
    private keeptoo.KGradientPanel dataSumbPenguburan;
    private keeptoo.KGradientPanel homePanel;
    private keeptoo.KGradientPanel inputPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel labelKematian;
    private javax.swing.JLabel labelNikah;
    private javax.swing.JLabel labelPenguburan;
    private javax.swing.JLabel labelSumbangan1;
    private javax.swing.JLabel labelSumbangan2;
    private javax.swing.JLabel labelSumbangan3;
    private javax.swing.JPanel logoutPanel;
    private keeptoo.KGradientPanel mainPanel;
    private javax.swing.JPanel panelInputKematian;
    private javax.swing.JPanel panelInputNikah;
    private javax.swing.JPanel panelInputPenguburan;
    private javax.swing.JPanel panelMenuData;
    private javax.swing.JPanel panelMenuHome;
    private keeptoo.KGradientPanel penutupParam;
    private keeptoo.KGradientPanel penutupParam1;
    private keeptoo.KGradientPanel penutupParam2;
    private keeptoo.KGradientPanel sumbKematianPanel;
    private keeptoo.KGradientPanel sumbnikahPanel;
    private javax.swing.JTable tabelData1;
    private javax.swing.JTable tabelData2;
    private javax.swing.JTable tabelData3;
    private javax.swing.JTable tabelData4;
    private javax.swing.JTable tabelData5;
    private javax.swing.JComboBox txtCabang;
    private javax.swing.JComboBox txtCabang1;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCari1;
    private javax.swing.JTextField txtCari2;
    private javax.swing.JComboBox txtJc;
    private javax.swing.JComboBox txtJc1;
    private javax.swing.JTextField txtJmlrupiah;
    private javax.swing.JTextField txtJmlrupiah1;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNama1;
    private javax.swing.JTextField txtNik;
    private javax.swing.JTextField txtNik1;
    private javax.swing.JTextField txtNorek;
    private javax.swing.JTextField txtNorek1;
    private javax.swing.JTextField txtParamDuka2;
    private javax.swing.JTextField txtParamNikah1;
    private javax.swing.JTextField txtParamNikah2;
    private javax.swing.JTextField txtParamNikah4;
    private javax.swing.JTextField txtParamNikah5;
    private com.toedter.calendar.JDateChooser txtTgldibuat;
    private com.toedter.calendar.JDateChooser txtTgldibuat1;
    private com.toedter.calendar.JDateChooser txtTglmeninggal;
    private com.toedter.calendar.JDateChooser txtTglnikah;
    // End of variables declaration//GEN-END:variables
}
