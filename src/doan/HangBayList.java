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
public class HangBayList 
{
    private HangBay[] HangBayList;
    int n;
    public HangBayList(){}
    public HangBayList(HangBay[] HangBayList, int n)
    {
        this.HangBayList = HangBayList;
        this.n = n;
    }
    public HangBayList(HangBayList hbl)
    {
        HangBayList = hbl.HangBayList;
        n = hbl.n;
    }
    
    //Get,set
    public HangBay[] getHangBayList()
    {
        return this.HangBayList;
    }
    public void setHangBayList(HangBay[] HangBayList)
    {
        this.HangBayList = HangBayList;
    }
    public void setn(int n)
    {
        this.n = n;
    }
    public int n(int n)
    {
        return n;
    }
    //============================MENU========================//
    public void Menu() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU HANG BAY   ===========");
        System.out.println("1.Nhap mot danh sach hang bay");
        System.out.println("2.Xuat danh sach hang bay");
        System.out.println("3.Them hang bay");
        System.out.println("4.Xoa hang bay");
        System.out.println("5.Sua hang bay");
        System.out.println("6.Tim theo ma hang bay");  
        System.out.println("7.Tim theo ten hang bay");
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
                ThemHB();
                Menu();
                System.out.println();
                break;
            case 4:
                XoaHB();
                Menu();
                System.out.println();
                break;
            case 5:
                SuaHB();
                Menu();
                System.out.println();
                break;
            case 6:
                Timtheoma();
                Menu();
                System.out.println();
                break;
            case 7:
                Timtheoten();
                Menu();
                System.out.println();
                break;
            
        }
    }
    //-------------------------------NHAP----------------------------//
    public void Nhap() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so luong hang bay: ");
        n = in.nextInt();
        if(n < 0)
        {
            System.out.println("Không hợp lệ, xin nhập lại");
            Nhap();
        }
        HangBayList = new HangBay[n];
        for(int i = 0; i<n; i++)
        {
            HangBayList[i] = new HangBay();
            HangBayList[i].nhap();
            if(i>0)
            {
                for(int j = 0; j<i; j++)
                {
                    if(HangBayList[j].getMaHang().equals(HangBayList[i].getMaHang()))
                    {
                        System.out.println("Dia diem nay da co, xin hay nhap lai !!");
                        HangBayList[i].nhap();
                    }
                }
            }
        }writeFile();
    }
    //-------------------------------XUAT--------------------------//
    public void Xuat() throws IOException
    {
        readFile();
        for(int i=0; i<HangBayList.length; i++){
            try
            {
                HangBayList[i].xuat();
            } 
            catch (NullPointerException e)
            {
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                HangBayList[i].nhap();
            }
        }
    }
        //------------------THEM--------------------//
    public void Them()
    {
        int num = HangBayList.length;
        HangBayList = Arrays.copyOf(HangBayList,num+1);
        HangBayList[num] = new HangBay();
        HangBayList[num].nhap();
        num++;
        writeFile();
    }
    public void ThemHB() throws IOException
    {
        readFile();
        int add = 0;
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.println("Them bao nhieu hang bay: ");
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
                    ThemHB();
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
    public void Xoa()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ma hang bay can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=HangBayList.length && !HangBayList[i-1].getMaHang().equals(ma))
        {
            dem++;  
            i++;
        } 
        if(i > HangBayList.length)
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
            while(dem<HangBayList.length-1)
            {
                HangBayList[dem]=HangBayList[dem+1]; 
                dem++;
            }
            HangBayList = Arrays.copyOf(HangBayList, HangBayList.length-1);
            writeFile();
        }
    }

    public void XoaHB() throws IOException
    {
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("Nhap so luong hang bay muon xoa: ");
        int num = in.nextInt();
        if(num<=0 || num>HangBayList.length)
        {
            System.out.println("Không hợp lệ !!\n1 Nhập lại \n2 Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1 ->
                {
                    XoaHB();
                }
                case 2 ->
                {
                    System.out.println("Đã thoát !!");
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
        Scanner in= new Scanner(System.in);
        String ma = in.nextLine();
        for(int i = 0; i<HangBayList.length; i++)
        {
            if(HangBayList[i].getMaHang().equals(ma))
            {
                HangBayList[i].nhap();
            }
        }
        writeFile();
    }
    public void SuaHB() throws IOException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhap so luong dia diem can sua: ");
        int sl = Integer.parseInt(in.nextLine());
        if(sl <=0 || sl > HangBayList.length)
        {
            System.out.println("Không hợp lệ !!\n1 1.Nhập lại \n2 2.Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    SuaHB();
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
    HangBay[] Timtheoma() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        HangBay[] findList = new HangBay[1];
        int i,j=0;
        for(i=0; i<HangBayList.length; i++)
        {
            if(HangBayList[i].getMaHang().equals(ma))
            {
                findList[j] = HangBayList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new HangBay();
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
                    Timtheoma();
                    break;
                default: return findList;    
            }
        }
        return findList;
    }
    HangBay[] Timtheoten() throws IOException
    {
        readFile();
        System.out.println("Nhap ten can tim: ");
        Scanner in = new Scanner(System.in);
        String ten = in.nextLine();
        HangBay[] findList = new HangBay[1];
        int i,j=0;
        for(i=0; i<HangBayList.length; i++)
        {
            if(HangBayList[i].getTenHang().equals(ten))
            {
                findList[j] = HangBayList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new HangBay();
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
                    Timtheoten();
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
            FileWriter fw = new FileWriter("HangBay.txtiet");
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
        HangBayList = new HangBay[1];
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader("HangBay.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                String tmp[] = line.split(";");
                String MaHang = tmp[0];
                String TenHang = tmp[1];
                i++;
                HangBayList = Arrays.copyOf(HangBayList, i);
                HangBayList[i-1] = new HangBay(MaHang, TenHang);
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
        for(int i = 0;i<HangBayList.length; i++){
           s += HangBayList[i].toString()+"\n";
        }
        return s;
    }
    
    public HangBay TimtheomaHB() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ma hang bay can tim: ");
        String ma = in.nextLine();
        HangBay x = new HangBay();
        for(int i = 0; i<HangBayList.length; i++)
        {
            if(HangBayList[i].getMaHang().equals(ma))
            {
                x=HangBayList[i];
                x.xuat();
            }
        }
        if(x==null)
        {
            System.out.println("Ma kh ton tai !!");
        }
        return x;
    }
    
}
