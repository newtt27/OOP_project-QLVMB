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
public class HoaDon 
{
    private String MaHD;
    private String MaNV;
    private String MaKH;
    private String Ngayxuat;
    private long Tong;
    private CTHoaDon[] CTHoaDonList;
    private KH_Ve[] KH_VeList;
    public HoaDon(){}
    public HoaDon(String MaHD, String MaNV, String MaKH, String Ngayxuat, long Tong)
    {
        this.MaHD = MaHD;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.Ngayxuat = Ngayxuat;
        this.Tong = Tong;
    }
    public HoaDon(HoaDon h)
    {
        MaHD = h.MaHD;
        MaNV = h.MaNV;
        MaKH = h.MaKH;
        Ngayxuat = h.Ngayxuat;
        Tong = h.Tong;
    }
    
    //Get,set
    public String getMaHD()
    {
        return MaHD;
    }
    public void setMaHD(String maHD)
    {
        this.MaHD = maHD;
    }
    public String getMaNV()
    {
        return MaNV;
    }
    public void setMaNV(String maNV)
    {
        this.MaNV = maNV;
    }
    public String getMaKH()
    {
        return MaKH;
    }
    public void setMaKH(String maKH)
    {
        this.MaKH = maKH;
    }
    public String getNgayxuat()
    {
        return Ngayxuat;
    }
    public void setNgayxuat(String ngayxuat)
    {
        this.Ngayxuat = ngayxuat;
    }
    public long getTong()
    {
        return Tong;
    }
    public void setTong(long tong)
    {
        this.Tong = tong;
    }
    
    //Nhap,xuat
    public void nhap() throws IOException
    {
        CTHoaDonList n = new CTHoaDonList();
        CTHoaDonList = n.getlist();
        KH_VeList a = new KH_VeList();
        KH_VeList = a.getList();
        Scanner in = new Scanner(System.in);
        System.out.println("============Nhập Hóa Đơn============");
        System.out.println("Nhập mã hóa đơn: ");
        MaHD = in.nextLine();
        System.out.println("Nhập mã nhân viên: ");
        MaNV = in.nextLine();
        System.out.println("Nhập mã khách hàng: ");
        MaKH = in.nextLine();
        System.out.println("Nhập ngày xuất hóa đơn: ");
        Ngayxuat = in.nextLine();
        if(checkNullSpace()) nhap();
        //Tinh KM
        double check = 0;
        double KM = 0;
        for(int i = 0; i<KH_VeList.length; i++)
        {
            if(KH_VeList[i].getMaKH().equals(MaKH))
            {
                check = KH_VeList[i].getKhuyenMai();
            }
            KM = check/100;
        }
        //Tinh tong cthd
        int []tong = new int[1];
        double tientru = 0;
        for(int i = 0; i<1; i++)
        {
            for(int j = 0 ; j < CTHoaDonList.length; j++)
            {
                if(CTHoaDonList[j].getMaHD().equals(MaHD))
                {
                    tientru = CTHoaDonList[j].getThanhtien()*KM;
                    tong[i] += CTHoaDonList[j].getThanhtien()-tientru;
                }
            }
            Tong += tong[i];
        }
    }
    public void xuat()
    {
        System.out.println("============Hóa Đơn============");
        System.out.println("Mã hóa đơn: "+MaHD);
        System.out.println("Mã nhân viên: "+MaNV);
        System.out.println("Mã khách hàng: "+MaKH);
        System.out.println("Ngày: "+Ngayxuat);
        System.out.println("Tong tien: "+Tong);
    }
    Boolean checkNullSpace()
    {
        if(MaHD.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(MaNV.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(MaKH.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(Ngayxuat.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        return false;
    }
    public void Writefile()
    {
        try
        {
            FileWriter f = new FileWriter("HoaDon.txt",true);
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
        return MaHD+";"+MaNV+";"+MaKH+";"+Ngayxuat+";"+Tong;
    }
}
