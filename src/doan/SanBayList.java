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
public class SanBayList 
{
    private SanBay[] SanBayList;
    int n;
    public SanBayList(){}
    public SanBayList(SanBay[] SanBayList, int n)
    {
        this.SanBayList = SanBayList;
        this.n = n;
    }
    public SanBayList(SanBayList sbl)
    {
        SanBayList = sbl.SanBayList;
        n = sbl.n;
    }
    
    //Get,set
    public SanBay[] getSanBayList()
    {
        return this.SanBayList;
    }
    public void setSanBayList(SanBay[] SanBayList)
    {
        this.SanBayList = SanBayList;
    }
    public void setn(int n)
    {
        this.n = n;
    }
    public int n(int n)
    {
        return n;
    }
    public SanBay[] getList() throws IOException
    {
        readFile();
        return SanBayList;
    }
    //============================MENU========================//
    public void Menu() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU SAN BAY   ===========");
        System.out.println("1.Nhap mot danh sach san bay");
        System.out.println("2.Xuat danh sach san bay");
        System.out.println("3.Them san bay");
        System.out.println("4.Xoa san bay");
        System.out.println("5.Sua san bay");
        System.out.println("6.Tim theo ma san bay");  
        System.out.println("7.Tim theo ten san bay");
        System.out.println("0.Ket thuc");
        System.out.println("Hay nhap lua chon cua ban: ");
        int choose = 0;
        try{
            choose = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            Menu();
        }
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
                ThemSB();
                Menu();
                System.out.println();
                break;
            case 4:
                XoaSB();
                Menu();
                System.out.println();
                break;
            case 5:
                SuaSB();
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
            default:
                System.out.println("Thong tin khong hop le!! Hay nhap lai!");
                Menu();
                break;
            
        }
    }
    //-------------------------------NHAP----------------------------//
    public void Nhap() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so luong san bay: ");
        n = in.nextInt();
        if(n < 0)
        {
            System.out.println("Không hợp lệ, xin nhập lại");
            Nhap();
        }
        SanBayList = new SanBay[n];
        for(int i = 0; i<n; i++)
        {
            SanBayList[i] = new SanBay();
            SanBayList[i].nhap();
            if(i>0)
            {
                for(int j = 0; j<i; j++)
                {
                    if(SanBayList[j].getMaSB().equals(SanBayList[i].getMaSB()))
                    {
                        System.out.println("Dia diem nay da co, xin hay nhap lai !!");
                        SanBayList[i].nhap();
                    }
                }
            }
        }writeFile();
    }
    //-------------------------------XUAT--------------------------//
    public void Xuat() throws IOException
    {
        readFile();
        for(int i=0; i<SanBayList.length; i++){
            try
            {
                SanBayList[i].xuat();
            } 
            catch (NullPointerException e)
            {
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                SanBayList[i].nhap();
            }
        }
    }
        //------------------THEM--------------------//
    public void Them() throws IOException
    {
        readFile();
        int num = SanBayList.length;
        SanBayList = Arrays.copyOf(SanBayList,num+1);
        SanBayList[num] = new SanBay();
        SanBayList[num].nhap();
        num++;
        writeFile();
    }
    public void ThemSB() throws IOException
    {
        readFile();
        int add = 0;
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.println("Them bao nhieu san bay: ");
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
                    ThemSB();
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
        System.out.println("Nhap san bay can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=SanBayList.length && !SanBayList[i-1].getMaSB().equals(ma))
        {
            dem++;  
            i++;
        } 
        if(i > SanBayList.length)
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
            while(dem<SanBayList.length-1)
            {
                SanBayList[dem]=SanBayList[dem+1]; 
                dem++;
            }
            SanBayList = Arrays.copyOf(SanBayList, SanBayList.length-1);
            writeFile();
        }
    }

    public void XoaSB() throws IOException
    {
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("Nhap so luong san bay muon xoa: ");
        int num = in.nextInt();
        if(num<=0 || num>SanBayList.length)
        {
            System.out.println("Không hợp lệ !!\n1 Nhập lại \n2 Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1 ->
                {
                    XoaSB();
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
        readFile();
        Scanner in= new Scanner(System.in);
        String ma = in.nextLine();
        for(int i = 0; i<SanBayList.length; i++)
        {
            if(SanBayList[i].getMaSB().equals(ma))
            {
                SanBayList[i].nhap();
            }
        }
        writeFile();
    }
    public void SuaSB() throws IOException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhap so luong san bay can sua thong tin: ");
        int sl = Integer.parseInt(in.nextLine());
        if(sl <=0 || sl > SanBayList.length)
        {
            System.out.println("Không hợp lệ !!\n1 1.Nhập lại \n2 2.Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    SuaSB();
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
    SanBay[] Timtheoma() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        SanBay[] findList = new SanBay[1];
        int i,j=0;
        for(i=0; i<SanBayList.length; i++)
        {
            if(SanBayList[i].getMaSB().equals(ma))
            {
                findList[j] = SanBayList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new SanBay();
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
    SanBay[] Timtheoten() throws IOException
    {
        readFile();
        System.out.println("Nhap ten can tim: ");
        Scanner in = new Scanner(System.in);
        String ten = in.nextLine();
        SanBay[] findList = new SanBay[1];
        int i,j=0;
        for(i=0; i<SanBayList.length; i++)
        {
            if(SanBayList[i].getTenSB().equals(ten))
            {
                findList[j] = SanBayList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new SanBay();
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
            FileWriter fw = new FileWriter("SanBayList.txtiet");
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
        SanBayList = new SanBay[1];
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader("SanBayList.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                String tmp[] = line.split(";");
                String MaSB = tmp[0];
                String TenSB = tmp[1];
                i++;
                SanBayList = Arrays.copyOf(SanBayList, i);
                SanBayList[i-1] = new SanBay(MaSB, TenSB);
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
        for(int i = 0;i<SanBayList.length; i++){
           s += SanBayList[i].toString()+"\n";
        }
        return s;
    }
}
