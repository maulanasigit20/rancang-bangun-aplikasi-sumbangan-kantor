

package method.sumbKematian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ControlDuka {
    Connection con = null;
    ResultSet rs = null;
    Statement st = null;
    String sql = null; 
    
    public ControlDuka(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sumbangan","root",""); //url database
            st = con.createStatement();
            }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "koneksi Database Gagal, terjadi kesalahan pada : \n"+e);
           }
}
    public List tampil(){
        List LogDataDuka = new ArrayList();
        sql = "select cabang, nik, nama, jc, norek, jml, tgl_meninggal, tgl_dibuat from data_duka order by nama asc";
            try{
            rs = st.executeQuery(sql);
                while (rs.next()){
                    DataDuka DD = new DataDuka(); 
                    DD.setCabang1(rs.getString("cabang"));
                    DD.setNik1(rs.getInt("nik"));
                    DD.setNama1(rs.getString("nama"));
                    DD.setJc1(rs.getString("jc"));
                    DD.setNorek1(rs.getInt("norek"));
                    DD.setJml1(rs.getInt("jml"));
                    DD.setTgl_meninggal(rs.getString("tgl_meninggal"));
                    DD.setTgl_dibuat1(rs.getString("tgl_dibuat"));
                    LogDataDuka.add(DD); 
                }
            }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Pada saat Tampil terjadi kesalahan pada : \n"+e);
           }
        return LogDataDuka; 
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
    
    public int tambahdata(DataDuka e){
        sql = "insert into data_duka (cabang, nik, nama, jc, norek, jml, tgl_meninggal, tgl_dibuat) values('"+e.getCabang1()+"','"+e.getNik1()+"','"+
                e.getNama1()+"','"+e.getJc1()+"','"+e.getNorek1()+"','"+e.getJml1()+"','"+e.getTgl_meninggal()+"','"+e.getTgl_dibuat1()+"')";
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
       List LogDataduka = new ArrayList();
       sql = "select cabang, nik, nama, jc, norek, jml, tgl_meninggal, tgl_dibuat from data_duka where nik "
               + "like '%"+cari+"%' or nama like '%"+cari+"%'";
       try{
           rs = st.executeQuery(sql);
           while (rs.next()){
           DataDuka DD = new DataDuka();
            DD.setCabang1(rs.getString("cabang"));
            DD.setNik1(rs.getInt("nik"));
            DD.setNama1(rs.getString("nama"));
            DD.setJc1(rs.getString("jc"));
            DD.setNorek1(rs.getInt("norek"));
            DD.setJml1(rs.getInt("jml"));
            DD.setTgl_meninggal(rs.getString("tgl_meninggal"));
            DD.setTgl_dibuat1(rs.getString("tgl_dibuat"));
            LogDataduka.add(DD); 
           }
       }catch(Exception a){
       JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada : \n"+a);
       }
        return LogDataduka;
   }
   
   public int hapusdata(DataDuka e){
       sql = "delete from data_duka where nik='"+e.getNik1()+"'";
       int hasil = 0;
       try{
           hasil = st.executeUpdate(sql);
       }catch (Exception a){
       JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada : \n"+a);
       }
       return hasil;
   }
   
   
}