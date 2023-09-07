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
public class SanBay {
    private String MaSB;
    private String TenSB;
    
    SanBay() {}
    SanBay(String ma, String ten) {this.MaSB=ma;this.TenSB=ten;}
    SanBay(SanBay sb) {this.MaSB=sb.MaSB;this.TenSB=sb.TenSB;}
    
    String getMaSB() {return MaSB;}
    void setMaSB(String MaSB) {this.MaSB=MaSB;}
    String getTenSB() {return TenSB;}
    void setTenSB(String TenSB) {this.TenSB=TenSB;}
    
    void nhap()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Moi ban nhap Ma San Bay:");
        MaSB = in.nextLine();
        System.out.println("Moi ban nhap Ten San Bay:");
        TenSB = in.nextLine();
        if(checkNullSpace()) nhap();
        
    }
    Boolean checkNullSpace()
    {
        if(MaSB.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(TenSB.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        return false;
    }

    void xuat(){
        System.out.println("Ma SB: "+MaSB);
        System.out.println("Ten SB: "+TenSB);
        System.out.println("------------------------");
    }
        public void Writefile()
    {
        try
        {
            FileWriter fw = new FileWriter("SanBayList.txtiet",true);
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
        return MaSB+";"+TenSB;
    }
}
