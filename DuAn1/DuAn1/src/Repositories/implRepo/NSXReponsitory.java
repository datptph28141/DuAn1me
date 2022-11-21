/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories.implRepo;

import DomainModels.NhanVien;
import Repositories.INSXReponsitory;
import Utilities.DBConnection;
import ViewModels.NSX;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class NSXReponsitory implements INSXReponsitory{
      private ArrayList<NSX> lstNSX;
     
    java.sql.ResultSet rs = null;
    PreparedStatement pst = null;
    private DBConnection dbConnection;

    public NSXReponsitory() {
         lstNSX = new ArrayList<>();
        dbConnection = new DBConnection();
    }

  
    @Override
    public ArrayList<NSX> getAllNsx() {
         ArrayList<NSX> lst = new ArrayList<>();
        try {
            String sql = "Select * from NhaSx";
            ResultSet rs = dbConnection.executeQuery(sql);
            while (rs.next()) {
                NSX nsx = mappingNSX(rs);
                if (nsx != null) {
                    lst.add(nsx);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lst;

}
    public NSX mappingNSX(ResultSet rs) {
        if (rs != null) {
            try {
                String ma = rs.getString("MaNSX");
                String ten = rs.getString("TenNSX");
               

                return new NSX(ma, ten);
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienRepository.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }
//    public String add(NSX nsx) {
//        String select = " insert into NhaSx( MaNSX, TenNSX) values(?,?)";
//        lstNSX = new ArrayList<>();
//        try {
//           pst = DBConnection.openDbConnection().pre(select);
//           pst.setString(1, nsx.getMaNSX());
//           pst.setString(2, nsx.getTenNSX());
//          
//           pst.executeUpdate();
//           pst.close();
//           return "Them du lieu thanh cong";
//        } catch (SQLException ex) {
//            Logger.getLogger(NSXReponsitory.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "them that bai";
//    }
}

