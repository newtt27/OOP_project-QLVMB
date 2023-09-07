/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class KhachHang {
    private String MaKH;
    private String Ho;
    private String Ten;
    private String SDT;
    private String DC;
    private String GT;
    private String NS;
    KhachHang(){}
    KhachHang(String MaKH,String Ho,String Ten,String SDT, String DC,String GT,String NS)
    {this.MaKH=MaKH;this.Ho=Ho;this.Ten=Ten;this.SDT=SDT;this.DC=DC;this.GT=GT;this.NS=NS;}
    KhachHang(KhachHang kh)
    {this.MaKH=kh.MaKH;this.Ho=kh.Ho;this.Ten=kh.Ten;this.SDT=kh.SDT;this.DC=kh.DC;this.GT=kh.GT;this.NS=kh.NS;}
    
    String getMaKH() {return MaKH;}
    void setMaKH(String MaKH) {this.MaKH=MaKH;}
    String getHo() {return Ho;}
    void setHo(String Ho) {this.Ho=Ho;}
    String getTen() {return Ten;}
    void setTen(String Ten) {this.Ten=Ten;}
    String getSDT() {return SDT;}
    void setSDT(String SDT) {this.SDT=SDT;}
    String getDC() {return DC;}
    void setDC(String DC) {this.DC=DC;}
    String getGT() {return GT;}
    void setGT(String GT) {this.GT=GT;}
    String getNS() {return NS;}
    void setNS(String NS) {this.NS=NS;}
    
    void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Moi ban nhap Ma Khach Hang:");
        MaKH = in.nextLine();
        System.out.println("Moi ban nhap Ho:");
        Ho = in.nextLine();
        System.out.println("Moi ban nhap Ten:");
        Ten = in.nextLine();
        System.out.println("Moi ban nhap SDT:");
        SDT = in.nextLine();
        System.out.println("Moi ban nhap Dia chi:");
        DC = in.nextLine();
        System.out.println("Moi ban nhap Gioi tinh:");
        GT = in.nextLine();
        System.out.println("Moi ban nhap Ngay Sinh:");
        NS = in.nextLine();
        if(checkNullSpace()) nhap();
    }
    Boolean checkNullSpace()
    {
        if(MaKH.trim().length()==0){
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
        if(SDT.trim().length()==0){
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
        return false;
    }
    void xuat(){
        System.out.println("Ma KH: "+MaKH);
        System.out.println("Ho: "+Ho);
        System.out.println("Ten: "+Ten);
        System.out.println("SDT: "+SDT);
        System.out.println("Dia chi: "+DC);
        System.out.println("Gioi tinh: "+GT);
        System.out.println("Ngay sinh"+NS);
        System.out.println("------------------------");
    }
    public void writeFile(){
        try{
            FileWriter fw = new FileWriter("KhachHangList.txtiet",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e){
        }
    }
    @Override
    public String toString()
    {
        return MaKH+";"+Ho+";"+Ten+";"+SDT+";"+DC+";"+GT+";"+NS;
    }
}
