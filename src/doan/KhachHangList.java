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
 * @author admin
 */
public class KhachHangList {
    KhachHang[] dskh = new KhachHang[1];
    int n;
    KhachHangList(){}
    KhachHangList(int n, KhachHang[] kh){this.n=n;this.dskh=kh;}
    public KhachHang[] getList() throws IOException
    {
        readFile();
        return dskh;
    }
    void nhap() throws IOException
    {
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Nhap so luong Khach Hang: ");
            n = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            nhap();
        }
        if (n <= 0){
            System.out.println("Thong tin khong hop le, hay nhap lai!!!\n");
            nhap();
            return;
        }
        dskh = new KhachHang[n];
        for(int i=0; i<n; i++)
        {
            dskh[i] = new KhachHang();
            dskh[i].nhap();
            System.out.println("\n//////////////");
            if(i > 0){
                for(int j = 0; j < i; j++){
                    if (dskh[j].getMaKH().equals(dskh[i].getMaKH())){ 
                        System.out.println("Ma Khach Hang da ton tai, hay nhap lai!!!");
                        dskh[i].nhap();
                    }
                }
            }
        }
        writeFile();
    }
    void xuat() throws IOException
    {
        readFile();
        //System.out.println(""+dskh.length);
        for(int i=0; i<dskh.length; i++) {
            try{
                dskh[i].xuat();
            } catch (NullPointerException e){
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                dskh[i].nhap();
            }
        }
    }
    void them() throws IOException 
    {
        readFile();
        n=dskh.length;
        dskh = Arrays.copyOf(dskh,n+1);
        dskh[n] = new KhachHang();
        dskh[n].nhap();
        n++;
        writeFile();
    }
    void themN() throws IOException
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
    KhachHang timkiemMa() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        KhachHang x = new KhachHang();
        int i=0; 
        while(i<dskh.length)
        {
            if(dskh[i].getMaKH().equals(ma))
            {
                x=dskh[i];
                x.xuat();
            }
            i++;
        }
        if(i>=dskh.length){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    timkiemMa();
                    break;
                default: break;
            }
        }
        return x;
    }
    KhachHang timkiemSDT() throws IOException
    {
        readFile();
        System.out.println("Nhap SDT can tim: ");
        Scanner in = new Scanner(System.in);
        String sdt = in.nextLine();
        KhachHang x = new KhachHang();
        int i=0; 
        while(i<dskh.length )
        {
            if(dskh[i].getSDT().equals(sdt))
            {
                x=dskh[i];
                x.xuat();
            }
            i++;
        }if (x==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    timkiemSDT();
                    break;
                default: return x;
            }
        }
        return x;
    }
    KhachHang[] timkiemHo() throws IOException
    {
        readFile();
        System.out.println("Nhap ho can tim: ");
        Scanner in = new Scanner(System.in);
        String ho = in.nextLine();
        KhachHang[] findList = new KhachHang[1];
        int i,j=0;
        for(i=0; i<dskh.length; i++)
        {
            if(dskh[i].getHo().equals(ho))
            {
                findList[j] = dskh[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new KhachHang();
                findList[j].xuat();
                j++;
            }
        }    
        if (findList[0]==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    timkiemHo();
                    break;
                default: return findList;
            }
        }
        return findList;
    }
    KhachHang[] timkiemTen() throws IOException
    {
        readFile();
        System.out.println("Nhap ten can tim: ");
        Scanner in = new Scanner(System.in);
        String ten = in.nextLine();
        KhachHang[] findList = new KhachHang[1];
        int i,j=0;
        for(i=0; i<dskh.length; i++)
        {
            if(dskh[i].getTen().equals(ten))
            {
                findList[j] = dskh[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new KhachHang();
                findList[j].xuat();
                j++;
            }
        }    
        if (findList[0]==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    timkiemTen();
                    break;
                default: return findList;
            }
        }
        return findList;
    }
    void suaMa() throws IOException 
    {
        readFile();
        System.out.println("Nhap ma can sua: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        int i;
        for (i=0; i<dskh.length; i++)
             if (dskh[i].getMaKH().equals(ma)) dskh[i].nhap();
        if (i == dskh.length){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    suaMa();
                    break;
                default: break;
            }
        }else   writeFile();
    }
    void suaNMa() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap so luong ban muon sua: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            themN();
        }
        if (sl > dskh.length || sl <=0){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    suaNMa();
                    break;
                default: break;
            }
        } else{
            for(int i = 0; i < sl; i++){
                suaMa();
            }
        }
        writeFile();
    }
    void xoaMa() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ma can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=dskh.length && !dskh[i-1].getMaKH().equals(ma))
        {
            dem++;  //den vi tri can xoa
            i++;
        }   
        if(i>dskh.length)
        {

            System.out.printf("Ma KH khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    xoaMa();
                    break;
                default: break;
            }
        }
        else {
            while(dem<dskh.length-1)
            {
                dskh[dem]=dskh[dem+1]; //don` hang
                dem++;
            }
            dskh = Arrays.copyOf(dskh, dskh.length-1);
            writeFile();
        }
    }
    void xoaNMa() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap so luong ban muon sua: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            themN();
        }
        if (sl > dskh.length || sl <=0){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    xoaNMa();
                    break;
                default: break;
            }
        } else{
            for(int i = 0; i < sl; i++){
                xoaMa();
            }
        }
    }
    void writeFile() throws IOException 
    {
        try {
        FileWriter fw = new FileWriter("KhachHangList.txtiet");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toString());
        bw.close();
        fw.close();
        } catch (Exception e) {}
    }    
    @Override
    public String toString() {
        String s = "";
        for(int i = 0;i<dskh.length; i++){
           s += dskh[i].toString()+"\n";
        }
        return s;
    }
    public void readFile() throws IOException{
        int i = 0;
        dskh = new KhachHang[1];
        FileReader fr = null;
        BufferedReader br = null;
        try {
        fr = new FileReader("KhachHangList.txtiet");
        br = new BufferedReader(fr);
        String line = br.readLine();
        while(line != null){
            String temp[] = line.split(";");
            String ma = temp[0];
            String ho = temp[1];
            String ten = temp[2];
            String sdt = temp[3];
            String dc = temp[4];
            String gt = temp[5];
            String ns = temp[6];
            i++; 
            dskh = Arrays.copyOf(dskh,i); 
            dskh[i-1] = new KhachHang(ma,ho,ten,sdt,dc,gt,ns);       
            line = br.readLine();
            }
        }
        catch(Exception e){}
        finally{
        br.close();
        fr.close();
        }
        }
    public void menu() throws IOException{ 
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU FOR GUEST   ===========");
        System.out.println("1.Nhap mot danh sach khach hang");
        System.out.println("2.Xuat danh sach khach hang");
        System.out.println("3.Them khach hang");
        System.out.println("4.Xoa khach hang theo Ma Khach Hang");
        System.out.println("5.Sua khach hang theo Ma Khach Hang");
        System.out.println("6.Tim khach hang theo Ma Khach Hang");  
        System.out.println("7.Tim khach hang theo Ho");
        System.out.println("8.Tim khach hang theo Ten");
        System.out.println("9.Tim khach hang theo SDT"); 
        System.out.println("0.Ket thuc");
        System.out.println("Hay nhap lua chon cua ban: ");
        int choose = in.nextInt();
        in.nextLine();
        switch (choose){
            case 0: break;
            case 1:
                nhap();
                menu();
                System.out.println();
                break;
            case 2:
                xuat();
                menu();
                System.out.println();
                break;
            case 3:
                themN();
                menu();
                System.out.println();
                break;
            case 4:
                xoaNMa();
                menu();
                System.out.println();
                break;
            case 5:
                suaNMa();
                menu();
                System.out.println();
                break;
            case 6:
                timkiemMa();
                menu();
                System.out.println();
                break;
            case 7:
                timkiemHo();
                menu();
                System.out.println();
                break;
            case 8:
                timkiemTen();
                menu();
                System.out.println();
                break;
            case 9:
                timkiemSDT();
                menu();
                System.out.println();
                break;
            default:
                System.out.println("Thong tin khong hop le!! Hay nhap lai!");
                menu();
                break;
        }
    }
}
