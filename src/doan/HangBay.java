/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author hllo
 */
public class HangBay 
{
    private String MaHang;
    private String TenHang;
    public HangBay(){}
    public HangBay(String MaHang, String TenHang)
    {
        this.MaHang = MaHang;
        this.TenHang = TenHang;
    }
    public HangBay (HangBay hb)
    {
        MaHang = hb.MaHang;
        TenHang = hb.TenHang;
    }

    /////Get, set
    
    public String getTenHang()
    {
        return TenHang;
    }
    public void setTenHang(String tenhang)
    {
        this.TenHang = tenhang;
    }
    public String getMaHang()
    {
        return MaHang;
    }
    public void setMaHang(String mahang)
    {
        this.MaHang = mahang;
    }
    
////Nhap, xuat
    public void nhap()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("Ten Hang Bay: ");
        TenHang = in.nextLine();
        System.out.println("Ma Hang Bay: ");
        MaHang = in.nextLine();
        System.out.println("===============================");
        Writefile();
    }
    public void xuat()
    {
        System.out.println("===============================");
        System.out.println("Day la Hang Bay: "+TenHang+"\n"+"Ma la: "+MaHang);
        System.out.println("===============================");
    }
    
    public void Writefile()
    {
        try
        {
            FileWriter f = new FileWriter("HangBay.txtiet",true);
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
        return MaHang+";"+TenHang;
    }
}
