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
public class CTHoaDon 
{
    private String MaHD;
    private String MaVe;
    private int Sluong;
    private long Thanhtien;
    
    private KH_Ve[] KH_VeList;
    
    public CTHoaDon(){}
    public CTHoaDon(String MaHD, String MaVe,  int Sluong, long Thanhtien)
    {
        this.MaHD = MaHD;
        this.MaVe = MaVe;
        this.Sluong = Sluong;
        this.Thanhtien = Thanhtien;
    }
    public CTHoaDon(CTHoaDon c)
    {
        MaHD = c.MaHD;
        MaVe = c.MaVe;
        Sluong = c.Sluong;
        Thanhtien = c.Thanhtien;
    }
    
    //Get,set
    public String getMaHD()
    {
        return MaHD;
    }
    public void setMaHD(String mahd)
    {
        this.MaHD = mahd;
    }
    public String getMaVe()
    {
        return MaVe;
    }
    public void setMaVe(String mave)
    {
        this.MaVe = mave;
    }
    public int getSluong()
    {
        return Sluong;
    }
    public void setSluong(int sluong)
    {
        this.Sluong = sluong;
    }
    public long getThanhtien()
    {
        return Thanhtien;
    }
    public void setThanhtien(long thanhtien)
    {
        this.Thanhtien = thanhtien;
    }
    
    //Nhap, xuat
    public void nhap() throws IOException
    {
        KH_VeList n = new KH_VeList();
        KH_VeList = n.getList();
        Scanner in = new Scanner(System.in);
        System.out.println("============Nhập chi tiết============");
        System.out.println("Mã hóa đơn: ");
        MaHD = in.nextLine();
        int []tong = new int[1];
        for(int i = 0 ; i<1; i++)
        {
            System.out.println("Nhap ma ve: ");
            MaVe = new Scanner(System.in).nextLine();
            System.out.println("Nhap so luong ve: ");
            Sluong = new Scanner(System.in).nextInt();
            for(int j = 0; j < KH_VeList.length; j++)
            {
                if(KH_VeList[j].getMaVe().equals(MaVe))
                {
                    tong[i] += KH_VeList[j].getGiaVe()*Sluong;
                }
                Thanhtien = tong[i];
            }
        }
    }

    public void xuat()
    {
        System.out.println(" ");
        System.out.println("Ma Hoa Don: "+MaHD);
        System.out.println("Ma ve: "+MaVe);
        System.out.println("So luong: "+Sluong);
        System.out.println("Thanh tien: "+Thanhtien); 
        System.out.println("----------------------------------");
    }
    public void Writefile()
    {
        try
        {
            FileWriter f = new FileWriter("CTHoaDon.txtiet",true);
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
        return MaHD+";"+MaVe+";"+Sluong+";"+Thanhtien;
    }
}
