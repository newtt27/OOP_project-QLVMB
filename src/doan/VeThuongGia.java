/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class VeThuongGia extends VeMayBay {
    private String MaPC="PC02";
    VeThuongGia(){}
    VeThuongGia(String MaVe,String MaCB,String NgayDi,String GioLenMayBay, int CuaVoMayBay,String STTGhe, int GiaVe,String MaPC)
    {super(MaVe,MaCB,NgayDi,GioLenMayBay,CuaVoMayBay,STTGhe,GiaVe);
    this.MaPC=MaPC;}
    VeThuongGia(VeThuongGia vtg){super((VeMayBay)vtg);}
    
    String getMaPC() {return MaPC;}
    void setMaPC(String MaPC) {this.MaPC=MaPC;}
    
    
    @Override
    void nhap() throws IOException, ParseException{
        Scanner in = new Scanner(System.in);      
        System.out.println("Moi ban nhap Ve!");
        super.setMaVe(String.format("VT%02d",nhapMaSo())); 
        System.out.println("Moi ban nhap Ma Chuyen Bay!");
        super.setMaCB(String.format("CB%02d",nhapMaSo()));
        super.NgayDi();
        super.GioLenMayBay();
        super.setGiaVe(VeMayBay.GiaVeThuong);
        System.out.println("Moi ban nhap STT Ghe! ");
        super.setSTTGhe(String.format("VIP%02d",nhapMaSo()));
        if(checkNullSpace()) nhap();
        nhapCuaVoMayBay();
        System.out.println("");
    }
    @Override
    Boolean checkNullSpace()
    {
        if(super.checkNullSpace()) return true;
        if(MaPC.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        return false;
    }
    @Override
    void xuat(){
        super.xuat();
        System.out.println("Ma PC: "+MaPC);
        System.out.println("----------------------------");
    }
    
    public void writeFile()  
    {
        try {
        FileWriter fw = new FileWriter("VeMayBayList.txtiet",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toString());
        bw.close();
        fw.close();
        } catch (IOException e) {}
    }
    
    @Override
    public String toString()
    {
        return super.toString()+";"+"VT"+";"+MaPC;
    }
}
