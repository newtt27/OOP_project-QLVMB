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
public class PhongChoList 
{
    private PhongCho[] PhongChoList;
    int n;
    public PhongChoList(){}
    public PhongChoList(PhongCho[] PhongChoList, int n)
    {
        this.PhongChoList = PhongChoList;
        this.n = n;
    }
    public PhongChoList(PhongChoList sbl)
    {
        PhongChoList = sbl.PhongChoList;
        n = sbl.n;
    }
    
    //Get,set
    public PhongCho[] getPhongChoList()
    {
        return this.PhongChoList;
    }
    public void setPhongChoList(PhongCho[] PhongChoList)
    {
        this.PhongChoList = PhongChoList;
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
        System.out.println("\n==========   MENU PHONG CHO   ===========");
        System.out.println("1.Nhap mot danh sach Phong Cho");
        System.out.println("2.Xuat danh sach Phong Cho");
        System.out.println("3.Them Phong Cho");
        System.out.println("4.Xoa Phong Cho");
        System.out.println("5.Sua Phong Cho");
        System.out.println("6.Tim theo ma Phong Cho");  
        System.out.println("7.Tim theo ten Phong Cho");
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
                ThemPC();
                Menu();
                System.out.println();
                break;
            case 4:
                XoaPC();
                Menu();
                System.out.println();
                break;
            case 5:
                SuaPC();
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
        try{
        System.out.println("Nhap so luong Phong Cho: ");
        n = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e){
            System.out.println("Vui long nhap so nguyen! ");
            Nhap();
        }
        if(n < 0)
        {
            System.out.println("Không hợp lệ, xin nhập lại");
            Nhap();
        }
        PhongChoList = new PhongCho[n];
        for(int i = 0; i<n; i++)
        {
            PhongChoList[i] = new PhongCho();
            PhongChoList[i].nhap();
            for(int j = 0; j<i; j++)
            {
                if(PhongChoList[j].getMaPC().equals(PhongChoList[i].getMaPC()))
                {
                    System.out.println("Phong cho da ton tai, xin hay nhap lai !!");
                    PhongChoList[i].nhap();
                }
            }
            
        }writeFile();
    }
    //-------------------------------XUAT--------------------------//
    public void Xuat() throws IOException
    {
        readFile();
        for(int i=0; i<PhongChoList.length; i++){
            try
            {
                PhongChoList[i].xuat();
            } 
            catch (NullPointerException e)
            {
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                PhongChoList[i].nhap();
            }
        }
    }
        //------------------THEM--------------------//
    public void Them() throws IOException
    {
        readFile();
        int num = PhongChoList.length;
        PhongChoList = Arrays.copyOf(PhongChoList,num+1);
        PhongChoList[num] = new PhongCho();
        PhongChoList[num].nhap();
        num++;
        writeFile();
    }
    public void ThemPC() throws IOException
    {
        readFile();
        int add = 0;
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.println("Them bao nhieu Phong Cho: ");
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
                    ThemPC();
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
        System.out.println("Nhap Phong Cho can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=PhongChoList.length && !PhongChoList[i-1].getMaPC().equals(ma))
        {
            dem++;  
            i++;
        } 
        if(i > PhongChoList.length)
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
            while(dem<PhongChoList.length-1)
            {
                PhongChoList[dem]=PhongChoList[dem+1]; 
                dem++;
            }
            PhongChoList = Arrays.copyOf(PhongChoList, PhongChoList.length-1);
            writeFile();
        }
    }

    public void XoaPC() throws IOException
    {
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("Nhap so luong dia diem muon xoa: ");
        int num = in.nextInt();
        if(num<=0 || num>PhongChoList.length)
        {
            System.out.println("Không hợp lệ !!\n1 Nhập lại \n2 Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1 ->
                {
                    XoaPC();
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
        for(int i = 0; i<PhongChoList.length; i++)
        {
            if(PhongChoList[i].getMaPC().equals(ma))
            {
                PhongChoList[i].nhap();
            }
        }
        writeFile();
    }
    public void SuaPC() throws IOException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhap so luong Phong Cho can sua: ");
        int sl = Integer.parseInt(in.nextLine());
        if(sl <=0 || sl > PhongChoList.length)
        {
            System.out.println("Không hợp lệ !!\n1 1.Nhập lại \n2 2.Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    SuaPC();
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
    PhongCho[] Timtheoma() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        PhongCho[] findList = new PhongCho[1];
        int i,j=0;
        for(i=0; i<PhongChoList.length; i++)
        {
            if(PhongChoList[i].getMaPC().equals(ma))
            {
                findList[j] = PhongChoList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new PhongCho();
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
    PhongCho[] Timtheoten() throws IOException
    {
        readFile();
        System.out.println("Nhap ten can tim: ");
        Scanner in = new Scanner(System.in);
        String ten = in.nextLine();
        PhongCho[] findList = new PhongCho[1];
        int i,j=0;
        for(i=0; i<PhongChoList.length; i++)
        {
            if(PhongChoList[i].getTenPC().equals(ten))
            {
                findList[j] = PhongChoList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new PhongCho();
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
            FileWriter fw = new FileWriter("PhongChoList.txtiet");
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
        PhongChoList = new PhongCho[1];
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader("PhongChoList.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                String temp[] = line.split(";");
                String MaPC = temp[0];
                String TenPC = temp[1];
                String ViTriPC = temp[2];
                i++;
                PhongChoList = Arrays.copyOf(PhongChoList, i);
                PhongChoList[i-1] = new PhongCho(MaPC, TenPC,ViTriPC);
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
        for(int i = 0;i<PhongChoList.length; i++){
           s += PhongChoList[i].toString()+"\n";
        }
        return s;
    }
}
