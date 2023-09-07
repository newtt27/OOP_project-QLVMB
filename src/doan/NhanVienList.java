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
public class NhanVienList 
{
    private NhanVien[] NhanVienList;
    int n;
    public NhanVienList(){}
    public NhanVienList(NhanVien[] NhanVienList, int n)
    {
        this.NhanVienList = NhanVienList;
        this.n = n;
    }
    public NhanVienList(NhanVienList nvl)
    {
        NhanVienList = nvl.NhanVienList;
        n = nvl.n;
    }
    
    //Get,set
    public NhanVien[] getNhanVienList() throws IOException
    {
        readFile();
        return NhanVienList;
    }
    public void setNhanViennList(NhanVien[] NhanVienList)
    {
        this.NhanVienList = NhanVienList;
    }
    public void setn(int n)
    {
        this.n = n;
    }
    public int n(int n)
    {
        return n;
    }
    public NhanVien[] getList() throws IOException
    {
        readFile();
        return NhanVienList;
    }
    //---------------------Menu--------------//
    public void Menu() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU NHAN VIEN   ===========");
        System.out.println("1.Nhap mot danh sach nhan vien");
        System.out.println("2.Xuat danh sach nhan vien");
        System.out.println("3.Them nhan vien");
        System.out.println("4.Xoa theo ma");
        System.out.println("5.Sua theo ma");
        System.out.println("6.Tim theo ma");  
        System.out.println("7.Tim theo Ho");
        System.out.println("8.Tim theo Ten");
        System.out.println("9.Tim theo SDT"); 
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
                ThemNV();
                Menu();
                System.out.println();
                break;
            case 4:
                XoaNV();
                Menu();
                System.out.println();
                break;
            case 5:
                SuaNV();
                Menu();
                System.out.println();
                break;
            case 6:
                Timtheoma();
                Menu();
                System.out.println();
                break;
            case 7:
                Timtheoho();
                Menu();
                System.out.println();
                break;
            case 8:
                Timtheoten();
                Menu();
                System.out.println();
                break;
            case 9:
                TimtheoSDT();
                Menu();
                System.out.println();
                break;
            default:
                System.out.println("Thong tin khong hop le!! Hay nhap lai!");
                Menu();
                break;
        }
    }
    //Nhap file tu ban phim
    public void Nhap()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập số nhân viên: ");
        n = in.nextInt();
        if(n < 0)
        {
            System.out.println("Không hợp lệ, xin nhập lại");
            Nhap();
        }
        NhanVienList = new NhanVien[n];
        for(int i = 0; i<NhanVienList.length; i++)
        {
            NhanVienList[i] = new NhanVien();
            NhanVienList[i].nhap();
            if(i>0)
            {
                for(int j = 0; j<i; j++)
                {
                    if(NhanVienList[j].getMaNV().equals(NhanVienList[i].getMaNV()))
                    {
                        System.out.println("Mã nhân viên này đã có, hãy nhập lại");
                        NhanVienList[i].nhap();
                    }
                }
            }
        }writeFile();
    }
    //Doc file va Xuat ra man hinh
    public void Xuat() throws IOException
    {
        readFile();
        for(int i=0; i<NhanVienList.length; i++){
            try
            {
                NhanVienList[i].xuat();
            } 
            catch (NullPointerException e)
            {
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                NhanVienList[i].nhap();
            }
        }
    }
    
    //---------------------Them nhan vien---------------------------//
    public void Them() throws IOException
    {
        readFile();
        int n=NhanVienList.length;
        NhanVienList = Arrays.copyOf(NhanVienList,n+1);
        NhanVienList[n] = new NhanVien();
        NhanVienList[n].nhap();
        n++;
        writeFile();
    }
    public void ThemNV() throws IOException
    {
        readFile();
        int add = 0;
        Scanner in = new Scanner(System.in);
        try
        {
            System.out.println("Them bao nhieu nhan vien: ");
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
                    Them();
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
    
    //---------------------Xoa nhan vien---------------------------//
    public void Xoa() throws IOException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ma can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=NhanVienList.length && !NhanVienList[i-1].getMaNV().equals(ma))
        {
            dem++;  
            i++;
        } 
        if(i > NhanVienList.length)
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
            while(dem<NhanVienList.length-1)
            {
                NhanVienList[dem]=NhanVienList[dem+1]; 
                dem++;
            }
              NhanVienList = Arrays.copyOf(NhanVienList, NhanVienList.length-1);
              writeFile();
        }
    }


    public void XoaNV() throws IOException
    {
        Scanner in = new Scanner(System.in);
        readFile();
        System.out.println("Nhập số nhân viên muốn xóa: ");
        int num = in.nextInt();
        if(num<=0 || num>NhanVienList.length)
        {
            System.out.println("Không hợp lệ !!\n1 Nhập lại \n2 Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1 ->
                {
                    XoaNV();
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
    //-------------------------TIM KIEM-----------------------//
    NhanVien[] Timtheoten() throws IOException
    {
        readFile();
        System.out.println("Nhap ten can tim: ");
        Scanner in = new Scanner(System.in);
        String ten = in.nextLine();
        NhanVien[] findList = new NhanVien[1];
        int i,j=0;
        for(i=0; i<NhanVienList.length; i++)
        {
            if(NhanVienList[i].getTen().equals(ten))
            {
                findList[j] = NhanVienList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new NhanVien();
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
    NhanVien[] Timtheoho() throws IOException
    {
        readFile();
        System.out.println("Nhap ho can tim: ");
        Scanner in = new Scanner(System.in);
        String ho = in.nextLine();
        NhanVien[] findList = new NhanVien[1];
        int i,j=0;
        for(i=0; i<NhanVienList.length; i++)
        {
            if(NhanVienList[i].getHo().equals(ho))
            {
                findList[j] = NhanVienList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new NhanVien();
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
                    Timtheoho();
                    break;
                default: return findList;    
            }
        }
        return findList;
    }
    NhanVien[] Timtheoma() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        NhanVien[] findList = new NhanVien[1];
        int i,j=0;
        for(i=0; i<NhanVienList.length; i++)
        {
            if(NhanVienList[i].getMaNV().equals(ma))
            {
                findList[j] = NhanVienList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new NhanVien();
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
    NhanVien[] TimtheoSDT() throws IOException
    {
        readFile();
        System.out.println("Nhap SDT can tim: ");
        Scanner in = new Scanner(System.in);
        String sdt = in.nextLine();
        NhanVien[] findList = new NhanVien[1];
        int i,j=0;
        for(i=0; i<NhanVienList.length; i++)
        {
            if(NhanVienList[i].getSDT().equals(sdt))
            {
                findList[j] = NhanVienList[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new NhanVien();
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
                    TimtheoSDT();
                    break;
                default: return findList;    
            }
        }
        return findList;
    }
    //----------------------Sua---------------------------//
    public void Sua() throws IOException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        String ma = in.nextLine();
        for(int i = 0; i<NhanVienList.length; i++)
        {
            if(NhanVienList[i].getMaNV().equals(ma))
            {
                NhanVienList[i].nhap();
            }
        }
        writeFile();
    }
    public void SuaNV() throws IOException
    {
        readFile();
        Scanner in= new Scanner(System.in);
        System.out.println("Nhap so luong can sua: ");
        int sl = Integer.parseInt(in.nextLine());
        if(sl <=0 || sl > NhanVienList.length)
        {
            System.out.println("Không hợp lệ !!\n1 1.Nhập lại \n2 2.Thoát");
            int choose = in.nextInt();
            switch(choose)
            {
                case 1:
                    SuaNV();
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
    //----------------------GHI FILE----------------------//
    public void writeFile()
    {
        try{
            FileWriter fw = new FileWriter("NhanVienList.txtiet");
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
        NhanVienList = new NhanVien[1];
        FileReader fr = null;
        BufferedReader br = null;
        try
        {
            fr = new FileReader("NhanVienList.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null)
            {
                String temp[] = line.split(";");
                String ma = temp[0];
                String ho = temp[1];
                String ten = temp[2];
                String sdt = temp[3];
                String dc = temp[4];
                String gt = temp[7];
                String ns = temp[6];
                int luong = Integer.parseInt(temp[5]);
                i++;
                NhanVienList = Arrays.copyOf(NhanVienList, i);
                NhanVienList[i-1] = new NhanVien(ma,ho,ten,sdt,dc,luong,ns,gt);
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
        for(int i = 0;i<NhanVienList.length; i++)
        {
           s += NhanVienList[i].toString()+"\n";
        }
        return s;
    }
}
