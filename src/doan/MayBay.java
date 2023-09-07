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
public class MayBay {
    private String MaMB;
    private String TenMB;
    private int SoGhe;
    
    private KH_Ve[] KH_VeList;
    MayBay() {}
    MayBay(String MaMB, String TenMB, int SoGhe) {this.MaMB=MaMB;this.TenMB=TenMB;this.SoGhe=SoGhe;}
    MayBay(MayBay mb) {this.MaMB=mb.MaMB;this.TenMB=mb.TenMB;this.SoGhe=mb.SoGhe;}
    
    String getMaMB() {return MaMB;}
    void setMaMB(String MaMB) {this.MaMB=MaMB;}
    String getTenMB() {return TenMB;}
    void setTenMB(String TenMB) {this.TenMB=TenMB;}
    int getSoGhe() {return SoGhe;}
    void setSoGhe(int SoGhe) {this.SoGhe=SoGhe;}
    
    void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Moi ban nhap Ma May Bay!");
        MaMB = String.format("MB%02d",VeMayBay.nhapMaSo()); 
        System.out.println("Moi ban nhap Ten May Bay:");
        TenMB = in.nextLine();
        if(checkNullSpace()) nhap();
        nhapSoGhe();
        System.out.println("");
    }
    void nhapSoGhe(){
        Scanner in = new Scanner(System.in);        
        try{
            System.out.println("Moi ban nhap So luong ghe:");
            SoGhe = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            nhapSoGhe();
        }
    }
    Boolean checkNullSpace()
    {
        if(MaMB.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(TenMB.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        return false;
    }
    void xuat()
    {
        System.out.println("Ma MB: "+MaMB);
        System.out.println("Ten MB: "+TenMB);
        System.out.println("So ghe: "+SoGhe);
        System.out.println("--------------------");
    }
    public void Writefile()
    {
        try
        {
            FileWriter fw = new FileWriter("MayBayList.txtiet",true);
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
        return MaMB+";"+TenMB+";"+SoGhe;
    }
}
