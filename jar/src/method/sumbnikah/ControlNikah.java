

package method.sumbnikah;

import method.sumbnikah.DataNikah;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControlNikah {
    Connection con = null;
    ResultSet rs = null;
    Statement st = null;
    String sql = null; 
    
    public ControlNikah(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sumbangan","root",""); //url database
            st = con.createStatement();
            }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "koneksi Database Gagal, terjadi kesalahan pada : \n"+e);
           }
}
    public List tampil(){
        List LogDatanikah = new ArrayList();
        sql = "select cabang, nik, nama, jc, norek, jml, tgl_nikah, tgl_dibuat from data_nikah order by nama asc";
            try{
            rs = st.executeQuery(sql);
                while (rs.next()){
                    DataNikah DN = new DataNikah(); 
                    DN.setCabang(rs.getString("cabang"));
                    DN.setNik(rs.getInt("nik"));
                    DN.setNama(rs.getString("nama"));
                    DN.setJc(rs.getString("jc"));
                    DN.setNorek(rs.getInt("norek"));
                    DN.setJml(rs.getInt("jml"));
                    DN.setTgl_nikah(rs.getString("tgl_nikah"));
                    DN.setTgl_dibuat(rs.getString("tgl_dibuat"));
                    LogDatanikah.add(DN); 
                }
            }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Pada saat Tampil terjadi kesalahan pada : \n"+e);
           }
        return LogDatanikah; 
}
    
//        public List tampil1(){
//        List LogDatanikah = new ArrayList();
//        sql = "select nik, nama, jc, norek, jml, tgl_nikah, tgl_dibuat from data_nikah order by nama asc";
//            try{
//            rs = st.executeQuery(sql);
//                while (rs.next()){
//                    DataNikah DN = new DataNikah();   
//                    DN.setNik(rs.getInt("nik"));
//                    DN.setNama(rs.getString("nama"));
//                    DN.setJc(rs.getString("jc"));
//                    DN.setNorek(rs.getInt("norek"));
//                    DN.setJml(rs.getInt("jml"));
//                    DN.setTgl_nikah(rs.getString("tgl_nikah"));
//                    DN.setTgl_dibuat(rs.getString("tgl_dibuat"));
//                    LogDatanikah.add(DN); 
//                }
//            }catch (Exception e){
//            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada : \n"+e);
//           }
//        return LogBarang; 
//}
    
    public int tambahdata(DataNikah e){
        sql = "insert into data_nikah (cabang, nik, nama, jc, norek, jml, tgl_nikah, tgl_dibuat) values('"+e.getCabang()+"','"+e.getNik()+"','"+
                e.getNama()+"','"+e.getJc()+"','"+e.getNorek()+"','"+e.getJml()+"','"+e.getTgl_nikah()+"','"+e.getTgl_dibuat()+"')";
        int hasil = 0;
        try{
            hasil = st.executeUpdate(sql);
        } catch ( Exception a) {
          JOptionPane.showMessageDialog(null, "Pada saat Tambah Data terjadi kesalahan pada : \n"+a);
        }
        return hasil;
    }
    
//   public int editBarang(DataBarang e){
//        sql = "update data_nikah set nik='"+e.getNik()+"',nama='"+e.getNama()+"',jc='"+e.getJc()
//                +"',harga='"+e.getHarga()+"',stok='"+e.getStok()+"',tgl_kadaluarsa='"+e.getTglkadaluarsa()+"'where kode_barang='"+e.getKdbarang()+"'";
//        int hasil = 0;
//        try{
//            hasil = st.executeUpdate(sql);
//        }catch (Exception a){
//        JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada : \n"+a);
//        }
//        return hasil;
//}  
   
   public List cariData(String cari){
       List LogDatanikah = new ArrayList();
       sql = "select cabang, nik, nama, jc, norek, jml, tgl_nikah, tgl_dibuat from data_nikah where nik "
               + "like '%"+cari+"%' or nama like '%"+cari+"%'";
       try{
           rs = st.executeQuery(sql);
           while (rs.next()){
           DataNikah DN = new DataNikah();
            DN.setCabang(rs.getString("cabang"));
            DN.setNik(rs.getInt("nik"));
            DN.setNama(rs.getString("nama"));
            DN.setJc(rs.getString("jc"));
            DN.setNorek(rs.getInt("norek"));
            DN.setJml(rs.getInt("jml"));
            DN.setTgl_nikah(rs.getString("tgl_nikah"));
            DN.setTgl_dibuat(rs.getString("tgl_dibuat"));
            LogDatanikah.add(DN); 
           }
       }catch(Exception a){
       JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada : \n"+a);
       }
        return LogDatanikah;
   }
   
   public int hapusdata(DataNikah e){
       sql = "delete from data_nikah where nik='"+e.getNik()+"'";
       int hasil = 0;
       try{
           hasil = st.executeUpdate(sql);
       }catch (Exception a){
       JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada : \n"+a);
       }
       return hasil;
   }
   
   
}