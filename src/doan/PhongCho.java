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
public class PhongCho {
    private String MaPC;
    private String TenPC;
    private String ViTriPC;

    PhongCho(){}
    PhongCho(String ma, String ten, String vt){this.MaPC=ma;this.TenPC=ten;this.ViTriPC=vt;}
    PhongCho(PhongCho pc){this.MaPC=pc.MaPC;this.TenPC=pc.TenPC;this.ViTriPC=pc.ViTriPC;}
    
    String getMaPC() {return MaPC;}
    void setMaPC(String MaPC) {this.MaPC=MaPC;}
    String getTenPC() {return TenPC;}
    void setTenPC(String TenPC) {this.TenPC=TenPC;}
    String getViTriPC() {return ViTriPC;}
    void setViTriPC(String ViTriPC) {this.ViTriPC=ViTriPC;}
    
    void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Moi ban nhap Ma Phong Cho:");
        MaPC = in.nextLine();
        System.out.println("Moi ban nhap Ten Phong Cho");
        TenPC = in.nextLine();
        System.out.println("Moi ban nhap Vi tri Phong Cho");
        ViTriPC = in.nextLine();
        if(checkNullSpace()) nhap();
    }
    void nhapLoaiVe(){
        Scanner in = new Scanner(System.in);
        System.out.println("Hay chon loai PC:\n1.Hang thuong\n2.Hang thuong gia\n");
            try{
                int temp = Integer.parseInt(in.nextLine());
                switch(temp) {
                case 1: MaPC = "PC01"; TenPC = "NOR"; ViTriPC = "1"; break;//Regular ticket break;
                case 2: MaPC = "PC02"; TenPC = "VIP"; ViTriPC = "2"; break;//Vip ticket break;
                default: System.out.println("Vui long chon 1 hoac 2!"); nhapLoaiVe(); break;
                
                }
            }   catch(NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen");
                nhapLoaiVe();
            }
    }
    Boolean checkNullSpace()
    {
        if(MaPC.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(TenPC.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(ViTriPC.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        return false;
    }
    void xuat(){
        System.out.println("Ma PC: "+MaPC);
        System.out.println("Ten PC: "+TenPC);
        System.out.println("Vi tri PC: "+ViTriPC);
    }    
    public void Writefile()
    {
        try
        {
            FileWriter fw = new FileWriter("PhongChoList.txtiet",true);
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
        return MaPC+";"+TenPC+";"+ViTriPC;
    }
}
