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
public class MayBayList 
{
    private MayBay[] MayBayList;
    int n;
    public MayBayList(){}
    public MayBayList(MayBay[] MayBayList, int n)
    {
        this.MayBayList = MayBayList;
        this.n = n;
    }
    public MayBayList(MayBayList mbl)
    {
        MayBayList = mbl.MayBayList;
        n = mbl.n;
    }
    //Get,set
    public MayBay[] getList() throws IOException
    {
        readFile();
        return this.MayBayList;
    }
    public void setMayBayList(MayBay[] MayBayList)
    {
        this.MayBayList = MayBayList;
    }
    public void setn(int n)
    {
        this.n = n;
    }
    public int n(int n)
    {
        return n;
    }
    public void Menu() throws IOException, ParseException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU MAY BAY   ===========");
        System.out.println("1.Nhap mot danh sach May Bay");
        System.out.println("2.Xuat danh sach May Bay");
        System.out.println("3.Them May Bay");
        System.out.println("4.Xoa theo ma");
        System.out.println("5.Sua theo ma");
        System.out.println("6.Tim theo ma May Bay");  
        System.out.println("7.Tim theo ten May Bay");
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
                themN();
                Menu();
                System.out.println();
                break;
            case 4:
                XoaMB();
                Menu();
                System.out.println();
                break;
            case 5:
                SuaHD();
                Menu();
                System.out.println();
                break;
            case 6:
                TimtheomaMB();
                Menu();
                System.out.println();
                break;
            case 7:
                TimtheotenMB();
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
        System.out.println("Nhap so luong May Bay: ");
        n = in.nextInt();
        if(n < 0)
        {
            System.out.println("Vui long nhap lai! Thong tin khong hop le!");
            Nhap();
        }
        MayBayList = new MayBay[n];
        for(int i = 0; i<n; i++)
        {
            MayBayList[i] = new MayBay();
            MayBayList[i].nhap();
            if(i>0)
            {
                for(int j = 0; j<i; j++)
                {
                    if(MayBayList[j].getMaMB().equals(MayBayList[i].getMaMB()))
                    {
                        System.out.println("Mã hóa đơn này đã có, hãy nhập lại");
                        MayBayList[i].nhap();
                    }
                }
            }
        }writeFile();
    }
    //-------------------------------XUAT--------------------------//
    public void Xuat() throws IOException
    {
        readFile();
        for(int i=0; i<MayBayList.length; i++){
            try
            {
                MayBayList[i].xuat();
            } 
            catch (NullPointerException e)
            {
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                MayBayList[i].nhap();
            }
        }
    }
        //------------------THEM--------------------//
    public void them() throws IOException
    {
        readFile();
        int num = MayBayList.length;
        MayBayList = Arrays.copyOf(MayBayList,num+1);
        MayBayList[num] = new MayBay();
        MayBayList[num].nhap();
        num++;
        writeFile();
    }
    void themN() throws IOException, ParseException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap so luong ban muon them: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            themN();
        }
        if (sl <=0){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    themN();
                    break;
                default: break;
            }
        } else{
            for(int i = 0; i < sl; i++){
                them();
            }
        }
        writeFile();
    }
    //----------------------------XOA------------------------//
    public void Xoa()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ma can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=MayBayList.length && !MayBayList[i-1].getMaMB().equals(ma))
        {
            dem++;  
            i++;
        } 
        if(i > MayBayList.length)
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
            while(dem<MayBayList.length-1)
            {
                MayBayList[dem]=MayBayList[dem+1]; 
                dem++;
            }
            MayBayList = Arrays.copyOf(MayBayList, MayBayList.length-1);
            writeFile();
        }
    }

    public void XoaMB() throws IOException
    {
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("Nhap so May Bay muon xoa: ");
        int num = in.nextInt();
        if(num<=0 || num>MayBayList.length)
        {
            System.out.println("Không hợp lệ !!\n1 Nhập lại \n2 Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1 ->
                {
                    XoaMB();
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
        for(int i = 0; i<MayBayList.length; i++)
        {
            if(MayBayList[i].getMaMB().equals(ma))
            {
                MayBayList[i].nhap();
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
        if(sl <=0 || sl > MayBayList.length)
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
    MayBay TimtheomaMB() throws IOException
    {
        readFile();
        System.out.println("Nhap ma MB can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        MayBay x = new MayBay();
        int i=0; 
        while(i<MayBayList.length)
        {
            if(MayBayList[i].getMaMB().equals(ma))
            {
                x=MayBayList[i];
                x.xuat();
            }
            i++;
        }
        if(x==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    TimtheomaMB();
                    break;
                default: break;
            }
        }
        return x;
    }
    MayBay TimtheotenMB() throws IOException
    {
        readFile();
        System.out.println("Nhap ten MB can tim");
        Scanner in = new Scanner(System.in);
        String ten = in.nextLine();
        MayBay x = new MayBay();
        int i=0; 
        while(i<MayBayList.length)
        {
            if(MayBayList[i].getTenMB().equals(ten))
            {
                x=MayBayList[i];
                x.xuat();
            }
            i++;
        }
        if(x==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    TimtheomaMB();
                    break;
                default: break;
            }
        }
        return x;
    }
    //----------------------GHI FILE----------------------//
    public void writeFile()
    {
        try{
            FileWriter fw = new FileWriter("MayBayList.txtiet");
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
        MayBayList = new MayBay[1];
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader("MayBayList.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                String temp[] = line.split(";");
                String MaMB = temp[0];
                String TenMB = temp[1];
                int SoGhe = Integer.parseInt(temp[2]);
                i++;
                MayBayList = Arrays.copyOf(MayBayList, i);
                MayBayList[i-1] = new MayBay(MaMB, TenMB,SoGhe);
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
        for(int i = 0;i<MayBayList.length; i++){
           s += MayBayList[i].toString()+"\n";
        }
        return s;
    }
    
}
