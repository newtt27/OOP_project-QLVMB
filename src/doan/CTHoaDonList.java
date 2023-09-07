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
public class CTHoaDonList 
{
    private CTHoaDon[] CTHoaDonList;
    int n;
    public CTHoaDonList(){}
    public CTHoaDonList(CTHoaDon[] CTHoaDonList, int n)
    {
        this.CTHoaDonList = CTHoaDonList;
        this.n = n;
    }
    public CTHoaDonList(CTHoaDonList ct)
    {
        CTHoaDonList = ct.CTHoaDonList;
        n = ct.n;
    }
    
    //Get,set
    public CTHoaDon[] getCTHoaDonList()
    {
        return this.CTHoaDonList;
    }
    public void setCTHoaDonList(CTHoaDon[] CTHoaDonList)
    {
        this.CTHoaDonList = CTHoaDonList;
    }
    public void setn(int n)
    {
        this.n = n;
    }
    public int n(int n)
    {
        return n;
    }
    public CTHoaDon[] getlist() throws IOException
    {
        readFile();
        return CTHoaDonList;
    }
    //===============================MENU================================//
    public void Menu() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU    ===========");
        System.out.println("1.Nhap mot danh sach chi tiet hoa don");
        System.out.println("2.Xuat danh sach");
        System.out.println("3.Them danh sach");
        System.out.println("4.Xoa theo ma");
        System.out.println("5.Sua theo ma");
        System.out.println("6.Tim theo ma hoa don");  
        System.out.println("7.Tim theo ma ve");
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
                ThemCTHD();
                Menu();
                System.out.println();
                break;
            case 4:
                XoaCTHD();
                Menu();
                System.out.println();
                break;
            case 5:
                SuaCTHD();
                Menu();
                System.out.println();
                break;
            case 6:
                TimtheomaHD();
                Menu();
                System.out.println();
                break;
            case 7:
                TimtheomaVE();
                Menu();
                System.out.println();
                break;
        }
    }
    //-------------------------------NHAP----------------------------//
    public void Nhap() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so danh sach:  ");
        n = in.nextInt();
        if(n < 0)
        {
            System.out.println("Không hợp lệ, xin nhập lại");
            Nhap();
        }
        CTHoaDonList = new CTHoaDon[n];
        for(int i = 0; i<n; i++)
        {
            CTHoaDonList[i] = new CTHoaDon();
            CTHoaDonList[i].nhap();
        }writeFile();
    }
    //-------------------------------XUAT--------------------------//
    public void Xuat() throws IOException
    {
        readFile();
        for(int i=0; i<CTHoaDonList.length; i++){
            try
            {
                CTHoaDonList[i].xuat();
            } 
            catch (NullPointerException e)
            {
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                CTHoaDonList[i].nhap();
            }
        }
    }
        //------------------THEM--------------------//
    public void Them() throws IOException
    {
        readFile();
        int num = CTHoaDonList.length;
        CTHoaDonList = Arrays.copyOf(CTHoaDonList,num+1);
        CTHoaDonList[num] = new CTHoaDon();
        CTHoaDonList[num].nhap();
        num++;
        writeFile();
    }
    public void ThemCTHD() throws IOException
    {
        readFile();
        int add = 0;
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.println("Them bao nhieu chi tiet: ");
            add = Integer.parseInt(in.nextLine());
        }
        catch(NumberFormatException e) 
        {
            System.out.println("Vui long nhap so nguyen");
            ThemCTHD();
        }
        if( add <= 0)
        {
            System.out.println("Không hợp lệ!!!\n1 Nhập lại\n2Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    ThemCTHD();
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
    //------------------------XOA---------------------------//
    public void Xoa() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ma hoa don can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=CTHoaDonList.length && !CTHoaDonList[i-1].getMaHD().equals(ma))
        {
            dem++;  
            i++;
        } 
        if(i > CTHoaDonList.length)
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
            while(dem<CTHoaDonList.length-1)
            {
                CTHoaDonList[dem]=CTHoaDonList[dem+1]; 
                dem++;
            }
            CTHoaDonList = Arrays.copyOf(CTHoaDonList, CTHoaDonList.length-1);
            writeFile();
        }
    }
    public void XoaCTHD() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("Nhap so danh sach muon xoa: ");
        int num = in.nextInt();
        if(num<=0 || num>CTHoaDonList.length)
        {
            System.out.println("Không hợp lệ !!\n1 Nhập lại \n2 Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1 ->
                {
                    XoaCTHD();
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
        for(int i = 0; i<CTHoaDonList.length; i++)
        {
            if(CTHoaDonList[i].getMaHD().equals(ma))
            {
                CTHoaDonList[i].nhap();
            }
        }
        writeFile();
    }
    public void SuaCTHD() throws IOException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhap so luong can sua: ");
        int sl = Integer.parseInt(in.nextLine());
        if(sl <=0 || sl > CTHoaDonList.length)
        {
            System.out.println("Không hợp lệ !!\n1 1.Nhập lại \n2 2.Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    SuaCTHD();
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
    CTHoaDon[] TimtheomaHD() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        CTHoaDon[] findList = new CTHoaDon[1];
        int i,j=0;
        for(i=0; i<CTHoaDonList.length; i++)
        {
            if(CTHoaDonList[i].getMaHD().equals(ma))
            {
                findList[j] = CTHoaDonList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new CTHoaDon();
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
    CTHoaDon[] TimtheomaVE() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        CTHoaDon[] findList = new CTHoaDon[1];
        int i,j=0;
        for(i=0; i<CTHoaDonList.length; i++)
        {
            if(CTHoaDonList[i].getMaVe().equals(ma))
            {
                findList[j] = CTHoaDonList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new CTHoaDon();
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
                    TimtheomaVE();
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
            FileWriter fw = new FileWriter("CTHD.txtiet");
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
        CTHoaDonList = new CTHoaDon[1];
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader("CTHD.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                String tmp[] = line.split(";");
                String MaHD = tmp[0];
                String MaVe = tmp[1];
                int Sluong = Integer.parseInt(tmp[2]);
                Long Thanhtien = Long.parseLong(tmp[3]);
                i++;
                CTHoaDonList = Arrays.copyOf(CTHoaDonList, i);
                CTHoaDonList[i-1] = new CTHoaDon(MaHD, MaVe, Sluong, Thanhtien);
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
        for(int i = 0;i<CTHoaDonList.length; i++){
           s += CTHoaDonList[i].toString()+"\n";
        }
        return s;
    }
}
