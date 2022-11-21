/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevices.implService;

import DomainModels.NhanVien;
import Repositories.INSXReponsitory;
import Repositories.INhanVienRepository;
import Repositories.implRepo.NSXReponsitory;
import Repositories.implRepo.NhanVienRepository;
import Sevices.INSXService;
import ViewModels.NSX;
import ViewModels.QLNhanVien;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class NSXService implements INSXService{
   private ArrayList<NSX> lstQLNSX;
    private INSXReponsitory iNSXReponsitory;  

    public NSXService() {
         lstQLNSX = new ArrayList<>();
        iNSXReponsitory = new NSXReponsitory();
    }
    

    @Override
    public ArrayList<NSX> fillListNSX() {
       ArrayList<NSX> lst = new ArrayList<>();
        ArrayList<NSX> lstNSX = iNSXReponsitory.getAllNsx();
        for (NSX nv : lstNSX) {
            NSX qlnv = new NSX();
            qlnv.setMaNSX(nv.getMaNSX());
            qlnv.setTenNSX(nv.getTenNSX());
            

            lst.add(qlnv);
        }
        return lst; 
}
}
