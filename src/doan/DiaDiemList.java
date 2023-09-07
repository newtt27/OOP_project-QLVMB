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
public class DiaDiemList 
{
    private DiaDiem[] DiaDiemList;
    int n;
    public DiaDiemList(){}
    public DiaDiemList(DiaDiem[] DiaDiemList, int n)
    {
        this.DiaDiemList = DiaDiemList;
        this.n = n;
    }
    public DiaDiemList(DiaDiemList ddl)
    {
        DiaDiemList = ddl.DiaDiemList;
        n = ddl.n;
    }
    
    //Get,set
    public void setDiaDiemList(DiaDiem[] DiaDiemList)
    {
        this.DiaDiemList = DiaDiemList;
    }
    public void setn(int n)
    {
        this.n = n;
    }
    public int n(int n)
    {
        return n;
    }
    public DiaDiem[] getList() throws IOException
    {
        readFile();
        return DiaDiemList;
    }
    //============================MENU========================//
    public void Menu() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU DIA DIEM   ===========");
        System.out.println("1.Nhap mot danh sach dia diem");
        System.out.println("2.Xuat danh sach dia diem");
        System.out.println("3.Them dia diem");
        System.out.println("4.Xoa dia diem");
        System.out.println("5.Sua dia diem");
        System.out.println("6.Tim theo ten thanh pho");  
        System.out.println("7.Tim theo ten quoc gia");
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
                ThemDD();
                Menu();
                System.out.println();
                break;
            case 4:
                XoaDD();
                Menu();
                System.out.println();
                break;
            case 5:
                SuaDD();
                Menu();
                System.out.println();
                break;
            case 6:
                TimtheoTP();
                Menu();
                System.out.println();
                break;
            case 7:
                TimtheoQG();
                Menu();
                System.out.println();
                break;
            
        }
    }
    //-------------------------------NHAP----------------------------//
    public void Nhap() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so luong dia diem: ");
        n = in.nextInt();
        if(n < 0)
        {
            System.out.println("Không hợp lệ, xin nhập lại");
            Nhap();
        }
        DiaDiemList = new DiaDiem[n];
        for(int i = 0; i<n; i++)
        {
            DiaDiemList[i] = new DiaDiem();
            DiaDiemList[i].nhap();
            if(i>0)
            {
                for(int j = 0; j<i; j++)
                {
                    if(DiaDiemList[j].getTenTP().indexOf(DiaDiemList[i].getTenTP())!=-1)
                    {
                        System.out.println("Dia diem nay da co, xin hay nhap lai !!");
                        DiaDiemList[i].nhap();
                    }
                }
            }
        }writeFile();
    }
    //-------------------------------XUAT--------------------------//
    public void Xuat() throws IOException
    {
        readFile();
        for(int i=0; i<DiaDiemList.length; i++){
            try
            {
                DiaDiemList[i].xuat();
            } 
            catch (NullPointerException e)
            {
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                DiaDiemList[i].nhap();
            }
        }
    }
    
        //------------------THEM--------------------//
    public void Them()
    {
        int num = DiaDiemList.length;
        DiaDiemList = Arrays.copyOf(DiaDiemList,num+1);
        DiaDiemList[num] = new DiaDiem();
        DiaDiemList[num].nhap();
        num++;
        writeFile();
    }
    public void ThemDD() throws IOException
    {
        readFile();
        int add = 0;
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.println("Them bao nhieu dia diem: ");
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
                    ThemDD();
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
        System.out.println("Nhap dia diem can xoa: ");
        String ten = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=DiaDiemList.length && DiaDiemList[i-1].getTenTP().indexOf(ten)==-1)
        {
            dem++;  
            i++;
        } 
        if(i > DiaDiemList.length)
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
            while(dem<DiaDiemList.length-1)
            {
                DiaDiemList[dem]=DiaDiemList[dem+1]; 
                dem++;
            }
            DiaDiemList = Arrays.copyOf(DiaDiemList, DiaDiemList.length-1);
            writeFile();
        }
    }

    public void XoaDD() throws IOException
    {
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("Nhap so luong dia diem muon xoa: ");
        int num = in.nextInt();
        if(num<=0 || num>DiaDiemList.length)
        {
            System.out.println("Không hợp lệ !!\n1 Nhập lại \n2 Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1 ->
                {
                    XoaDD();
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
        String ten = in.nextLine();
        for(int i = 0; i<DiaDiemList.length; i++)
        {
            if(DiaDiemList[i].getTenTP().equals(ten))
            {
                DiaDiemList[i].nhap();
            }
        }
        writeFile();
    }
    public void SuaDD() throws IOException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhap so luong dia diem can sua: ");
        int sl = Integer.parseInt(in.nextLine());
        if(sl <=0 || sl > DiaDiemList.length)
        {
            System.out.println("Không hợp lệ !!\n1 1.Nhập lại \n2 2.Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    SuaDD();
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
    DiaDiem[] TimtheoTP() throws IOException
    {
        readFile();
        System.out.println("Nhap ten thanh pho can tim: ");
        Scanner in = new Scanner(System.in);
        String ten = in.nextLine();
        DiaDiem[] findList = new DiaDiem[1];
        int i,j=0;
        for(i=0; i<DiaDiemList.length; i++)
        {
            if(DiaDiemList[i].getTenTP().equals(ten))
            {
                findList[j] = DiaDiemList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new DiaDiem();
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
                    TimtheoTP();
                    break;
                default: return findList;    
            }
        }
        return findList;
    }
    DiaDiem[] TimtheoQG() throws IOException
    {
        readFile();
        System.out.println("Nhap ten quoc gia can tim: ");
        Scanner in = new Scanner(System.in);
        String ten = in.nextLine();
        DiaDiem[] findList = new DiaDiem[1];
        int i,j=0;
        for(i=0; i<DiaDiemList.length; i++)
        {
            if(DiaDiemList[i].getTenQG().equals(ten))
            {
                findList[j] = DiaDiemList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new DiaDiem();
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
                    TimtheoQG();
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
            FileWriter fw = new FileWriter("DiaDiemList.txtiet");
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
        DiaDiemList = new DiaDiem[1];
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader("DiaDiemList.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                String tmp[] = line.split(";");
                String TenTP = tmp[0];
                String TenQG = tmp[1];
                String TenSB = tmp[2];
                i++;
                DiaDiemList = Arrays.copyOf(DiaDiemList, i);
                DiaDiemList[i-1] = new DiaDiem(TenTP, TenQG, TenSB);
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
        for(int i = 0;i<DiaDiemList.length; i++){
           s += DiaDiemList[i].toString()+"\n";
        }
        return s;
    }
}
