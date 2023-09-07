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
public class KH_Ve {
    private String MaKH;
    private String MaVe;
    private int KhuyenMai;
    private int GiaVe;
    private String NgayMua;
    
    
    KH_Ve(){}
    KH_Ve(String MaKH, String MaVe, int KhuyenMai,int GiaVe,  String NgayMua)
    {this.MaKH=MaKH;this.MaVe=MaVe;this.KhuyenMai=KhuyenMai;this.GiaVe=GiaVe;this.NgayMua=NgayMua;}
    KH_Ve(KH_Ve khv)
    {this.MaKH=khv.MaKH;this.MaVe=khv.MaVe;this.KhuyenMai=khv.KhuyenMai;this.GiaVe=khv.GiaVe;this.NgayMua=khv.NgayMua;}
    
    String getMaKH() {return MaKH;}
    void setMaKH(String MaKH) {this.MaKH=MaKH;}
    String getMaVe() {return MaVe;}
    void setMaVe(String MaVe) {this.MaVe=MaVe;}
    String getNgayMua() {return NgayMua;}
    void setNgayMua(String NgayMua) {this.NgayMua=NgayMua;}
    float getKhuyenMai() {return KhuyenMai;}
    void setKhuyenMai(int KhuyenMai) {this.KhuyenMai=KhuyenMai;}
    int getGiaVe() {return GiaVe;}
    void setGiaVe(int GiaVe) {this.GiaVe=GiaVe;}
    
    void nhap() throws IOException, ParseException{
        Scanner in = new Scanner(System.in);
        System.out.println("Moi ban nhap Ma Khach Hang:");
        MaKH = String.format("KH%02d",VeMayBay.nhapMaSo());
        System.out.println("Moi ban nhap Ma Ve!"); 
        nhapLoaiVe();
        MaVe = String.format("%s%02d",MaVe,VeMayBay.nhapMaSo());
        System.out.println("Moi ban nhap Ngay Mua:");
        NgayMua = in.nextLine();
        System.out.println("Nhap Khuyen Mai: ");
        KhuyenMai = in.nextInt();
        if(checkNullSpace()) nhap();
        writeFile();

    }
    void nhapLoaiVe() throws IOException, ParseException{
        Scanner in = new Scanner(System.in);
        System.out.println("Hay chon loai ve:\n1.Hang thuong\n2.Hang thuong gia\n");
            try{
                int temp = Integer.parseInt(in.nextLine());
                switch(temp) {
                case 1: MaVe = "RT"; GiaVe = VeMayBay.GiaVeThuong; break;//Regular ticket break;
                case 2: MaVe = "VT"; GiaVe = VeMayBay.GiaVeVip; break;//Vip ticket break;
                default: System.out.println("Vui long chon 1 hoac 2!"); nhapLoaiVe(); break;
                
                }
            }   catch(NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen");
                nhapLoaiVe();
            }
    }
    Boolean checkNullSpace()
    {
        if(MaKH.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(MaVe.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(NgayMua.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        return false;
    }
    void xuat(){
        System.out.println("Ma KH: "+MaKH);
        System.out.println("Ma Ve: "+MaVe);
        System.out.println("Ngay Mua: "+NgayMua);
        System.out.println("Khuyen Mai: "+KhuyenMai);
        System.out.println("Gia Ve: "+GiaVe);
        System.out.println("----------------------------");
    }
    public void writeFile()
    {
        try
        {
            FileWriter fw = new FileWriter("KH_Ve.txtiet",true);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write(toString());
            bf.newLine();
            bf.close();
            fw.close();
        }catch(IOException e){}
    }
    @Override
    public String toString()
    {
        return MaKH+";"+MaVe+";"+KhuyenMai+";"+GiaVe+";"+NgayMua;
    }
}
