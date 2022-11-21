/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.NhanVien;
import ViewModels.NSX;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public interface INSXReponsitory {
    ArrayList<NSX> getAllNsx();
     NSX mappingNSX(ResultSet rs);
}
