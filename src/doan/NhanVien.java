/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class NhanVien {
    private String MaNV;
    private String Ho, Ten;
    private String SDT;
    private String DC,GT,NS;
    private int Luong;
    NhanVien(){}
    NhanVien(String ma,String ho,String ten,String sdt,String dc,int luong,String ns, String gt)
    {this.MaNV=ma;this.Ho=ho;this.Ten=ten;this.SDT=sdt;this.DC=dc;this.GT=gt;this.NS=ns;this.Luong=luong;}
    NhanVien(NhanVien kh)
    {this.MaNV=kh.MaNV;this.Ho=kh.Ho;this.Ten=kh.Ten;this.SDT=kh.SDT;this.DC=kh.DC;this.GT=kh.GT;this.NS=kh.NS;this.Luong=kh.Luong;}
    
    String getMaNV() {return MaNV;}
    void setMaNV(String MaNV) {this.MaNV=MaNV;}
    String getHo() {return Ho;}
    void setHo(String Ho) {this.Ho=Ho;}
    String getTen() {return Ten;}
    void setTen(String Ten) {this.Ten=Ten;}
    String getDC() {return DC;}
    void setDC(String DC) {this.DC=DC;}
    String getGT() {return GT;}
    void setGT(String GT) {this.GT=GT;}
    String getNS() {return NS;}
    void setNS(String NS) {this.NS=NS;}
    String getSDT() {return SDT;}
    void setSDT(String SDT) {this.SDT=SDT;}
    int getLuong() {return Luong;}
    void setLuong(int Luong) {this.Luong=Luong;}
    
    void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Moi ban nhap Ma Nhan Vien:");
        MaNV = in.nextLine();
        System.out.println("Moi ban nhap Ho:");
        Ho = in.nextLine();
        System.out.println("Moi ban nhap Ten:");
        Ten = in.nextLine();
        System.out.println("Moi ban nhap SDT:");
        SDT = in.nextLine();
        System.out.println("Moi ban nhap Dia chi:");
        DC = in.nextLine();
        nhapLuong();
        System.out.println("Moi ban nhap Ngay sinh:");
        NS = in.nextLine();
        System.out.println("Moi ban nhap Gioi tinh:");
        GT = in.nextLine();
        if(checkNullSpace()) nhap();
    }
    void nhapLuong(){
        Scanner in = new Scanner(System.in);        
        try{
            System.out.println("Moi ban nhap Luong:");
            Luong = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            nhapLuong();
        }
    }
    Boolean checkNullSpace()
    {
        if(MaNV.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(Ho.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(Ten.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(DC.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(GT.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(NS.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(SDT.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        return false;
    }
    void xuat(){
        System.out.println("Ma NV: "+MaNV);
        System.out.println("Ho: "+Ho);
        System.out.println("Ten: "+Ten);
        System.out.println("Dia Chi: "+DC);
        System.out.println("Gioi tinh: "+GT);
        System.out.println("Ngay sinh: "+NS);
        System.out.println("SDT: "+SDT);
        System.out.println("Luong: "+Luong);
        System.out.println("-------------------------");
    }
    public void Writefile()
    {
        try
        {
            FileWriter fw = new FileWriter("NhanVienList.txtiet",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toString());
            bw.newLine();
            bw.close();
            fw.close();
        }catch(IOException e){}
    }
    
    @Override
    public String toString()
    {
        return MaNV+";"+Ho+";"+Ten+";"+SDT+";"+DC+";"+Luong+";"+NS+";"+GT;
    }
}


