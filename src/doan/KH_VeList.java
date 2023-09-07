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
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hllo
 */
public class KH_VeList 
{
    private KH_Ve[] KH_VeList;
    int n;
    public KH_VeList(){}
    public KH_VeList(KH_Ve[] KH_VeList, int n)
    {
        this.KH_VeList = KH_VeList;
        this.n = n;
    }
    public KH_VeList(KH_VeList kvl)
    {
        KH_VeList = kvl.KH_VeList;
        n = kvl.n;
    }
    
    //Get,set
    public KH_Ve[] getList() throws IOException
    {
        readFile();
        return this.KH_VeList;
    }
    public void setList(KH_Ve[] KH_VeList)
    {
        this.KH_VeList = KH_VeList;
    }
    public void setn(int n)
    {
        this.n = n;
    }
    public int n(int n)
    {
        return n;
    }
    //===============================MENU================================//
    public void Menu() throws IOException, ParseException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU    ===========");
        System.out.println("1.Nhap mot danh sach kh_ve");
        System.out.println("2.Xuat danh sach");
        System.out.println("3.Them danh sach");
        System.out.println("4.Xoa theo ma");
        System.out.println("5.Sua theo ma");
        System.out.println("6.Tim theo ma khach hang");  
        System.out.println("7.Tim theo ma ve");
        System.out.println("8.Tim theo ngay mua");
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
                ThemKHV();
                Menu();
                System.out.println();
                break;
            case 4:
                XoaKHV();
                Menu();
                System.out.println();
                break;
            case 5:
                SuaKHV();
                Menu();
                System.out.println();
                break;
            case 6:
                TimtheomaKH();
                Menu();
                System.out.println();
                break;
            case 7:
                TimtheomaVE();
                Menu();
                System.out.println();
                break;
            case 8:
                Timtheongaymua();
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
    public void Nhap() throws IOException, ParseException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so danh sach:  ");
        n = in.nextInt();
        if(n < 0)
        {
            System.out.println("Không hợp lệ, xin nhập lại");
            Nhap();
        }
        KH_VeList = new KH_Ve[n];
        for(int i = 0; i<n; i++)
        {
            KH_VeList[i] = new KH_Ve();
            KH_VeList[i].nhap();
            if(i>0)
            {
                for(int j = 0; j<i; j++)
                {
                    if(KH_VeList[j].getMaKH().equals(KH_VeList[i].getMaKH()))
                    {
                        System.out.println("Mã hóa đơn này đã có, hãy nhập lại");
                        KH_VeList[i].nhap();
                    }
                }
            }
        }writeFile();
    }
    //-------------------------------XUAT--------------------------//
    public void Xuat() throws IOException, ParseException
    {
        readFile();
        for(int i=0; i<KH_VeList.length; i++){
            try
            {
                KH_VeList[i].xuat();
            } 
            catch (NullPointerException e)
            {
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                KH_VeList[i].nhap();
            }
        }
    }
        //------------------THEM--------------------//
    public void Them() throws IOException, ParseException
    {
        readFile();
        int num = KH_VeList.length;
        KH_VeList = Arrays.copyOf(KH_VeList,num+1);
        KH_VeList[num] = new KH_Ve();
        KH_VeList[num].nhap();
        num++;
        writeFile();
    }
    public void ThemKHV() throws IOException, ParseException
    {
        readFile();
        int add = 0;
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.println("Them bao nhieu kh_ve: ");
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
                    ThemKHV();
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
        System.out.println("Nhap ma can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=KH_VeList.length && !KH_VeList[i-1].getMaKH().equals(ma))
        {
            dem++;  
            i++;
        } 
        if(i > KH_VeList.length)
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
            while(dem<KH_VeList.length-1)
            {
                KH_VeList[dem]=KH_VeList[dem+1]; 
                dem++;
            }
            KH_VeList = Arrays.copyOf(KH_VeList, KH_VeList.length-1);
            writeFile();
        }
    }
    public void XoaKHV() throws IOException
    {
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("Nhap so danh sach muon xoa: ");
        int num = in.nextInt();
        if(num<=0 || num>KH_VeList.length)
        {
            System.out.println("Không hợp lệ !!\n1 Nhập lại \n2 Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1 ->
                {
                    XoaKHV();
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
    public void Sua() throws IOException, ParseException
    {
        Scanner in= new Scanner(System.in);
        String ma = in.nextLine();
        for(int i = 0; i<KH_VeList.length; i++)
        {
            if(KH_VeList[i].getMaKH().equals(ma))
            {
                KH_VeList[i].nhap();
            }
        }
        writeFile();
    }
    public void SuaKHV() throws IOException, ParseException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhap so luong can sua: ");
        int sl = Integer.parseInt(in.nextLine());
        if(sl <=0 || sl > KH_VeList.length)
        {
            System.out.println("Không hợp lệ !!\n1 1.Nhập lại \n2 2.Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    Sua();
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
    KH_Ve TimtheomaKH() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        KH_Ve findList = new KH_Ve();
        int i,j=0;
        for(i=0; i<KH_VeList.length; i++)
        {
            if(KH_VeList[i].getMaKH().equals(ma))
            {
                findList = KH_VeList[i];
                findList.xuat();
            }
        }
        if (findList==null)
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
    KH_Ve[] TimtheomaVE() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        KH_Ve[] findList = new KH_Ve[1];
        int i,j=0;
        for(i=0; i<KH_VeList.length; i++)
        {
            if(KH_VeList[i].getMaVe().equals(ma))
            {
                findList[j] = KH_VeList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new KH_Ve();
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

    KH_Ve[] Timtheongaymua() throws IOException
    {
        readFile();
        System.out.println("Nhap ngay can tim: ");
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();
        KH_Ve[] findList = new KH_Ve[1];
        int i,j=0;
        for(i=0; i<KH_VeList.length; i++)
        {
            if(KH_VeList[i].getNgayMua().equals(date))
            {
                findList[j] = KH_VeList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new KH_Ve();
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
                    Timtheongaymua();
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
            FileWriter fw = new FileWriter("KH_Ve.txtiet");
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
        KH_VeList = new KH_Ve[1];
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader("KH_Ve.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                String tmp[] = line.split(";");
                String MaKH = tmp[0];
                String MaVe = tmp[1];
                int KM = Integer.parseInt(tmp[2]);
                int GiaVe = Integer.parseInt(tmp[3]);
                String NgayMua = tmp[4];
                i++;
                KH_VeList = Arrays.copyOf(KH_VeList, i);
                KH_VeList[i-1] = new KH_Ve(MaKH, MaVe, KM ,GiaVe, NgayMua);
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
        for(int i = 0;i<KH_VeList.length; i++){
           s += KH_VeList[i].toString()+"\n";
        }
        return s;
    }
}
