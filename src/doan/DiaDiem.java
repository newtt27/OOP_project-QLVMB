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
 * @author hllo
 */
public class DiaDiem 
{
    private String TenTP;
    private String TenQG;
    private String TenSB;
    public DiaDiem(){}
    public DiaDiem(String TenTP, String TenQG, String TenSB)
    {
        this.TenTP = TenTP;
        this.TenQG = TenQG;
        this.TenSB = TenSB;
    }
    public DiaDiem(DiaDiem dd)
    {
        TenTP = dd.TenTP;
        TenQG = dd.TenQG;
        TenSB = dd.TenSB;
    }
    
    //Get,set
    public String getTenTP()
    {
        return TenTP;
    }
    public void setTenTP(String tenTP)
    {
        this.TenTP = tenTP;
    }
    public String getTenQG()
    {
        return TenQG;
    }
    public void setTenQG(String tenQG)
    {
        this.TenQG = tenQG;
    }
    public void setTenSB(String TenSB)
    {
        this.TenSB = TenSB;
    }
    public String getTenSB()
    {
        return TenSB;
    }
    
    //Nhap,xuat
    public void nhap()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Nhap ten Thanh Pho: ");
        TenTP = in.nextLine();
        System.out.println("Nhap ten Quoc Gia: ");
        TenQG = in.nextLine();
        System.out.println("Nhap ma san bay: ");
        TenSB = in.nextLine();
        if(ChecknullSpace()) nhap();
        System.out.println("---------------------------");
    }
    Boolean ChecknullSpace()
    {
        if(TenTP.trim().length()==0)
        {    System.out.println("Vui long khong bo qua nhap du lieu");
            return true;}
        if(TenQG.trim().length()==0)
        {    System.out.println("Vui long khong bo qua nhap du lieu");
            return true;}
        if(TenSB.trim().length()==0)
        {    System.out.println("Vui long khong bo qua nhap du lieu");
            return true;}
        return false;
    }
    public void xuat()
    {
        System.out.println("");
        System.out.println("Quoc Gia: "+TenQG);
        System.out.println("Thanh Pho: "+TenTP);
        System.out.println("Ma San Bay: "+TenSB);
        System.out.println("------------------------");
    }
    public void Writefile()
    {
        try
        {
            FileWriter f = new FileWriter("DiaDiemList.txtiet",true);
            BufferedWriter bf = new BufferedWriter(f);
            bf.write(toString());
            bf.newLine();
            bf.close();
            f.close();
        }catch(IOException e){}
    }
    @Override
    public String toString()
    {
        return TenTP+";"+TenQG+";"+TenSB;
    }
}
