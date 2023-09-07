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
public class HanhLyKyGui {
    private String MaHLKG;
    private String MaKH;
    private String MaCB, MaVe;
    private float Kl;
    HanhLyKyGui(){}
    HanhLyKyGui(String MaHLKG,String MaKH,String MaCB,String MaVe, float Kl)
    {this.MaHLKG=MaHLKG;this.MaKH=MaKH;this.MaCB=MaCB;this.MaVe=MaVe;this.Kl=Kl;}
    HanhLyKyGui(HanhLyKyGui hl)
    {this.MaHLKG=hl.MaHLKG;this.MaKH=hl.MaKH;this.MaCB=hl.MaCB;this.MaVe=hl.MaVe;this.Kl=hl.Kl;}
    
    String getMaHLKG() {return MaHLKG;}
    void setMaHLKG(String MaHLKG) {this.MaHLKG=MaHLKG;}
    String getMaKH() {return MaKH;}
    void setMaKH(String MaKH) {this.MaKH=MaKH;}
    String getMaCB() {return MaCB;}
    void setMaCB(String MaCB) {this.MaCB=MaCB;}
    String getMaVe() {return MaVe;}
    void setMaVe(String MaVe) {this.MaVe=MaVe;}
    float getKl() {return Kl;}
    void setKl(float Kl) {this.Kl=Kl;}
    
    void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Moi ban nhap Ma Hanh Ly:");
        MaHLKG = in.nextLine();
        System.out.println("Moi ban nhap Ma Khach Hang:");
        MaKH = in.nextLine();
        System.out.println("Moi ban nhap Ma Chuyen Bay:");
        MaCB = in.nextLine();
        System.out.println("Moi ban nhap Ma Ve:");
        MaVe = in.nextLine();
        nhapKl();
        System.out.println("");
        if (checkNullSpace()) nhap();
        writeFile();
    }
    void nhapKl(){
        Scanner in = new Scanner(System.in);        
        try{
            System.out.println("Moi ban nhap Khoi luong:");
            Kl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            nhapKl();
        }
    }
    Boolean checkNullSpace()
    {
        if(MaHLKG.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(MaKH.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(MaCB.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(MaVe.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        
        return false;
    }
    void xuat(){
        System.out.println("Ma HLKG: "+MaHLKG);
        System.out.println("Ma Khach Hang: "+MaKH);
        System.out.println("Ma Chuyen Bay: "+MaCB);
        System.out.println("Ma ve: "+MaVe);
        System.out.println("Khoi luong: "+Kl);
    }    
    public void writeFile()
    {
        try
        {
            FileWriter fw = new FileWriter("HanhLyKyGuiList.txtiet",true);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write(toString());
            bf.newLine();
            bf.close();
            fw.close();
        }catch(IOException e){}
    }

    @Override
    public String toString() {
        return MaHLKG+";"+MaKH+";"+MaCB+";"+MaVe+";"+Kl;
    }
}