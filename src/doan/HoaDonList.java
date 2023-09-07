/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hllo
 */
public class HoaDonList 
{
    private HoaDon[] HoaDonList;
    int n;
    public HoaDonList(){}
    public HoaDonList(HoaDon[] HoaDonList, int n)
    {
        this.HoaDonList = HoaDonList;
        this.n = n;
    }
    public HoaDonList(HoaDonList hdl)
    {
        HoaDonList = hdl.HoaDonList;
        n = hdl.n;
    }
    //Get,set
    public HoaDon[] getHoaDonList()
    {
        return this.HoaDonList;
    }
    public void setHoaDonList(HoaDon[] HoaDonList)
    {
        this.HoaDonList = HoaDonList;
    }
    public void setn(int n)
    {
        this.n = n;
    }
    public int n(int n)
    {
        return n;
    }
    public HoaDon[] getList() throws IOException
    {
        readFile();
        return HoaDonList;
    }
    public void Menu() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU HOA DON   ===========");
        System.out.println("1.Nhap mot danh sach hoa don");
        System.out.println("2.Xuat danh sach hoa don");
        System.out.println("3.Them hoa don");
        System.out.println("4.Xoa theo ma");
        System.out.println("5.Sua theo ma");
        System.out.println("6.Tim theo ma hoa don");  
        System.out.println("7.Tim theo ma nhan vien");
        System.out.println("8.Tim theo ma khach hang");
        System.out.println("9.Tim theo ngay xuat"); 
        System.out.println("0.Ket thuc");
        System.out.println("Hay nhap lua chon cua ban: ");
        int choose = in.nextInt();
        in.nextLine();
        switch (choose){
            case 0: break;
            case 1:
                Nhap();
                Menu();
                System.out.println();
                break;
            case 2:
                Xuat();
                Menu();
                System.out.println();
                break;
            case 3:
                ThemHD();
                Menu();
                System.out.println();
                break;
            case 4:
                XoaHD();
                Menu();
                System.out.println();
                break;
            case 5:
                SuaHD();
                Menu();
                System.out.println();
                break;
            case 6:
                TimtheomaHD();
                Menu();
                System.out.println();
                break;
            case 7:
                TimtheomaNV();
                Menu();
                System.out.println();
                break;
            case 8:
                TimtheomaKH();
                Menu();
                System.out.println();
                break;
            case 9:
                Timtheongayxuat();
                Menu();
                System.out.println();
                break;
        }
    }
    //-------------------------------NHAP----------------------------//
    public void Nhap() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập số hóa đơn: ");
        n = in.nextInt();
        if(n < 0)
        {
            System.out.println("Không hợp lệ, xin nhập lại");
            Nhap();
        }
        HoaDonList = new HoaDon[n];
        for(int i = 0; i<n; i++)
        {
            HoaDonList[i] = new HoaDon();
            HoaDonList[i].nhap();
            if(i>0)
            {
                for(int j = 0; j<i; j++)
                {
                    if(HoaDonList[j].getMaNV().equals(HoaDonList[i].getMaNV()))
                    {
                        System.out.println("Mã hóa đơn này đã có, hãy nhập lại");
                        HoaDonList[i].nhap();
                    }
                }
            }
        }writeFile();
    }
    //-------------------------------XUAT--------------------------//
    public void Xuat() throws IOException
    {
        readFile();
        for(int i=0; i<HoaDonList.length; i++){
            try
            {
                HoaDonList[i].xuat();
            } 
            catch (NullPointerException e)
            {
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                HoaDonList[i].nhap();
            }
        }
    }
        //------------------THEM--------------------//
    public void Them() throws IOException
    {
        readFile();
        int num = HoaDonList.length;
        HoaDonList = Arrays.copyOf(HoaDonList,num+1);
        HoaDonList[num] = new HoaDon();
        HoaDonList[num].nhap();
        for(int j=0; j<n; j++)
        {       
            while (HoaDonList[j].getMaHD().equals(HoaDonList[n].getMaHD()))
            { 
                    System.out.println("Ma CB da ton tai, hay nhap lai!!!");
                    HoaDonList[n].nhap();                             
            }
        }
        num++;
        writeFile();
    }
    public void ThemHD() throws IOException
    {
        readFile();
        int add = 0;
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.println("Them bao nhieu hoa don: ");
            add = Integer.parseInt(in.nextLine());
        }
        catch(NumberFormatException e) 
        {
            System.out.println("Vui long nhap so nguyen");
            Them();
        }
        if( add <= 0)
        {
            System.out.println("Không hợp lệ!!!\n1 Nhập lại\n2Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    ThemHD();
                    break;
                default : break;
            }
        }
        else
        {
            for(int i = 0; i<add; i++)
            {
                Them();
            }
        }
        writeFile();
        System.out.println("Thêm thành công");
    }
    //----------------------------XOA------------------------//
    public void Xoa() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ma can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=HoaDonList.length && !HoaDonList[i-1].getMaHD().equals(ma))
        {
            dem++;  
            i++;
        } 
        if(i > HoaDonList.length)
        {
            System.out.println("Khong tim thay !!\n1 Nhap lai\n2 Thoat");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                     Xoa();
                     break;
                default : break;
            }
        }
        else
        {
            while(dem<HoaDonList.length-1)
            {
                HoaDonList[dem]=HoaDonList[dem+1]; 
                dem++;
            }
            HoaDonList = Arrays.copyOf(HoaDonList, HoaDonList.length-1);
            writeFile();
        }
    }

    public void XoaHD() throws IOException
    {
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("Nhap so hoa don muon xoa: ");
        int num = in.nextInt();
        if(num<=0 || num>HoaDonList.length)
        {
            System.out.println("Không hợp lệ !!\n1 Nhập lại \n2 Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1 ->
                {
                    XoaHD();
                }
                case 2 ->
                {
                    break;
                }
            }
        }else
            for(int i=0; i<num; i++)
            { Xoa();}
        writeFile();
    }
    //------------------------SUA---------------------------//
    public void Sua() throws IOException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        String ma = in.nextLine();
        for(int i = 0; i<HoaDonList.length; i++)
        {
            if(HoaDonList[i].getMaHD().equals(ma))
            {
                HoaDonList[i].nhap();
            }
        }
        writeFile();
    }
    public void SuaHD() throws IOException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhap so luong can sua: ");
        int sl = Integer.parseInt(in.nextLine());
        if(sl <=0 || sl > HoaDonList.length)
        {
            System.out.println("Không hợp lệ !!\n1 1.Nhập lại \n2 2.Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    SuaHD();
                    break;
                default : break;
                     
            }   
        }
        else
        {
            for(int i=0; i<sl;i++)
                Sua();
        }
        writeFile();
    }
    //-------------------------TIM KIEM-----------------------//
    HoaDon[] TimtheomaHD() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        HoaDon[] findList = new HoaDon[1];
        int i,j=0;
        for(i=0; i<HoaDonList.length; i++)
        {
            if(HoaDonList[i].getMaHD().equals(ma))
            {
                findList[j] = HoaDonList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new HoaDon();
                findList[j].xuat();
                j++;
            }
        }
        if (findList[0]==null)
        {
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1: 
                    TimtheomaHD();
                    break;
                default: return findList;    
            }
        }
        return findList;
    }
    HoaDon[] TimtheomaNV() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        HoaDon[] findList = new HoaDon[1];
        int i,j=0;
        for(i=0; i<HoaDonList.length; i++)
        {
            if(HoaDonList[i].getMaNV().equals(ma))
            {
                findList[j] = HoaDonList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new HoaDon();
                findList[j].xuat();
                j++;
            }
        }
        if (findList[0]==null)
        {
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1: 
                    TimtheomaNV();
                    break;
                default: return findList;    
            }
        }
        return findList;
    }
    HoaDon[] TimtheomaKH() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        HoaDon[] findList = new HoaDon[1];
        int i,j=0;
        for(i=0; i<HoaDonList.length; i++)
        {
            if(HoaDonList[i].getMaKH().equals(ma))
            {
                findList[j] = HoaDonList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new HoaDon();
                findList[j].xuat();
                j++;
            }
        }
        if (findList[0]==null)
        {
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1: 
                    TimtheomaKH();
                    break;
                default: return findList;    
            }
        }
        return findList;
    }
    HoaDon[] Timtheongayxuat() throws IOException
    {
        readFile();
        System.out.println("Nhap ngay can tim: ");
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        HoaDon[] findList = new HoaDon[1];
        int i,j=0;
        for(i=0; i<HoaDonList.length; i++)
        {
            if(HoaDonList[i].getNgayxuat().equals(date))
            {
                findList[j] = HoaDonList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new HoaDon();
                findList[j].xuat();
                j++;
            }
        }
        if (findList[0]==null)
        {
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1: 
                    Timtheongayxuat();
                    break;
                default: return findList;    
            }
        }
        return findList;
    }
    //----------------------GHI FILE----------------------//
    public void writeFile()
    {
        try{
            FileWriter fw = new FileWriter("HoaDon.txtiet");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toString());
            bw.close();
            fw.close();
        }catch(Exception e){}
    }
    
    //--------------------DOC FILE------------------//
    public void readFile() throws IOException
    {
        int i = 0;
        HoaDonList = new HoaDon[1];
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader("HoaDon.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                String tmp[] = line.split(";");
                String MaHD = tmp[0];
                String MaNV = tmp[1];
                String MaKH = tmp[2];
                String Ngayxuat = tmp[3];
                Long Tong = Long.parseLong(tmp[4]);
                i++;
                HoaDonList = Arrays.copyOf(HoaDonList, i);
                HoaDonList[i-1] = new HoaDon(MaHD, MaNV, MaKH, Ngayxuat, Tong);
                line = br.readLine();
            }
    }catch(Exception e){}
    finally
        {
            br.close();
            fr.close();
        }
    }
    @Override
    public String toString() 
    {
        String s = "";
        for(int i = 0;i<HoaDonList.length; i++){
           s += HoaDonList[i].toString()+"\n";
        }
        return s;
    }
    
}
