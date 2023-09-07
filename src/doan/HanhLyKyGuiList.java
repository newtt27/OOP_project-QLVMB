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
 * @author Admin
 */
public class HanhLyKyGuiList {
    HanhLyKyGui[] dshlkg = new HanhLyKyGui[1];
    int n;
    HanhLyKyGuiList(){}
    HanhLyKyGuiList(int n, HanhLyKyGui[] kh){this.n=n;this.dshlkg=kh;}
    void nhap() throws IOException
    {
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Nhap so luong Hanh ly ky gui: ");
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
        dshlkg = new HanhLyKyGui[n];
        for(int i=0; i<n; i++)
        {
            dshlkg[i] = new HanhLyKyGui();
            dshlkg[i].nhap();
            System.out.println("\n//////////////\n");
            if(i > 0){
                for(int j = 0; j < i; j++){
                    if (dshlkg[j].getMaHLKG().equals(dshlkg[i].getMaHLKG())){ 
                        System.out.println("Ma HLKG da ton tai, hay nhap lai!!!");
                        dshlkg[i].nhap();
                    }
                }
            }
        }
        writeFile();
    }
    void xuat() throws IOException
    {
        readFile();

        for(int i=0; i<dshlkg.length; i++){
            try{
                dshlkg[i].xuat();
            } catch (NullPointerException e){
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                dshlkg[i].nhap();
            }
        }
    }
    void them() throws IOException 
    {
        readFile();
        n=dshlkg.length;
        dshlkg = Arrays.copyOf(dshlkg,n+1);
        dshlkg[n] = new HanhLyKyGui();
        dshlkg[n].nhap();
        n++;
        dshlkg[n].writeFile();
    }
    void themN() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap ban muon them: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            themN();
        }
        if ( sl > dshlkg.length || sl <=0){
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
    HanhLyKyGui timkiemMaHLKG() throws IOException
    {
        readFile();
        System.out.println("Nhap ma HLKG can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        HanhLyKyGui x = new HanhLyKyGui();
        int i=0; 
        while(i<dshlkg.length)
        {
            if(dshlkg[i].getMaHLKG().equals(ma))
            {
                x=dshlkg[i];
                x.xuat();
            }
            i++;
        }
        if(x==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    timkiemMaHLKG();
                    break;
                default: break;
            }
        }
        return x;
    }
    HanhLyKyGui timkiemMaKH() throws IOException
    {
        readFile();
        System.out.println("Nhap Ma Khach Hang can tim: ");
        Scanner in = new Scanner(System.in);
        String MaKH = in.nextLine();
        HanhLyKyGui x = new HanhLyKyGui();
        int i=0; 
        while(i<dshlkg.length )
        {
            if(dshlkg[i].getMaKH().equals(MaKH))
            {
                x=dshlkg[i];
                x.xuat();
            }
            i++;
        }if (x==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    timkiemMaKH();
                    break;
                default: return x;
            }
        }
        return x;
    }
    HanhLyKyGui[] timkiemMaVe() throws IOException
    {
        readFile();
        System.out.println("Nhap Ma Ve can tim: ");
        Scanner in = new Scanner(System.in);
        String MaVe = in.nextLine();
        HanhLyKyGui[] findList = new HanhLyKyGui[1];
        int i,j=0;
        for(i=0; i<dshlkg.length; i++)
        {
            if(dshlkg[i].getMaVe().equals(MaVe))
            {
                findList[j] = dshlkg[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new HanhLyKyGui();
                findList[j].xuat();
                j++;
            }
        }    
        if (findList[0]==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    timkiemMaVe();
                    break;
                default: return findList;
            }
        }
        return findList;
    }
    HanhLyKyGui[] timkiemMaCB() throws IOException
    {
        readFile();
        System.out.println("Nhap Ma Chuyen Bay can tim: ");
        Scanner in = new Scanner(System.in);
        String macb = in.nextLine();
        HanhLyKyGui[] findList = new HanhLyKyGui[1];
        int i,j=0;
        for(i=0; i<dshlkg.length; i++)
        {
            if(dshlkg[i].getMaCB().equals(macb))
            {
                findList[j] = dshlkg[i];
                findList = Arrays.copyOf(findList,j+2);
                findList[j+1]=new HanhLyKyGui();
                findList[j].xuat();
                j++;
            }
        }    
        if (findList[0]==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    timkiemMaCB();
                    break;
                default: return findList;
            }
        }
        return findList;
    }
    void suaMa() throws IOException 
    {
        readFile();
        System.out.println("Nhap Ma HLKG can sua: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        int i;
        for (i=0; i<dshlkg.length; i++)
             if (dshlkg[i].getMaHLKG().equals(ma)) dshlkg[i].nhap();
        if (i == dshlkg.length){
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
            System.out.println("Nhap ban muon them: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            suaNMa();
        }
        if (sl > dshlkg.length || sl <=0){
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
        System.out.println("Nhap Ma HLKG can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=dshlkg.length && !dshlkg[i-1].getMaHLKG().equals(ma))
        {
            dem++;  //den vi tri can xoa
            i++;
        }   
        if(i>dshlkg.length)
        {

            System.out.printf("Ma HLKG khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                   xoaMa();
                    break;
                default: break;
            }
        }
        else{
            while(dem<dshlkg.length-1)
            {
                dshlkg[dem]=dshlkg[dem+1]; //don` hang
                dem++;
            }
            dshlkg = Arrays.copyOf(dshlkg, dshlkg.length-1);
            writeFile();
        }
    }
    void xoaNMa() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap ban muon them: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            xoaNMa();
        }
        if (sl > dshlkg.length || sl <=0){
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
        FileWriter fw = new FileWriter("HanhLyKyGuiList.txtiet");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toString());
        bw.close();
        fw.close();
        } catch (Exception e) {}
    }    
    @Override
    public String toString() {
        String s = "";
        for(int i = 0;i<dshlkg.length; i++){
           s += dshlkg[i].toString()+"\n";
        }
        return s;
    }
    public void readFile() throws IOException
    {
        int i = 0;
        dshlkg = new HanhLyKyGui[1];
        FileReader fr = null;
        BufferedReader br = null;
        try {
        fr = new FileReader("HanhLyKyGuiList.txtiet");
        br = new BufferedReader(fr);
        String line = br.readLine();
        while(line != null){
            String temp[] = line.split(";");
            String mahlkg = temp[0];
            String makh = temp[1];
            String mave = temp[2];
            String macb = temp[3];
            float kl = Float.parseFloat(temp[4]);
            i++; 
            dshlkg = Arrays.copyOf(dshlkg,i); 
            dshlkg[i-1] = new HanhLyKyGui(mahlkg,makh,mave,macb,kl);       
            line = br.readLine();
            }
        }
        catch(Exception e){}
        finally{
        br.close();
        fr.close();
        }
        }
    public void menuGuest() throws IOException{ 
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU FOR LUGGAGE   ===========");
        System.out.println("1.Nhap mot danh sach hanh ly ky gui");
        System.out.println("2.Xuat danh sach hanh ly ky gui");
        System.out.println("3.Them hanh ly ky gui");
        System.out.println("4.Xoa hanh ly ky gui theo Ma HLKG");
        System.out.println("5.Sua hanh ly ky gui theo Ma HLKG");
        System.out.println("6.Tim hanh ly ky gui theo Ma HLKG");  
        System.out.println("7.Tim hanh ly ky gui theo Ma Khach Hang");
        System.out.println("8.Tim hanh ly ky gui theo Ma Ve");
        System.out.println("9.Tim hanh ly ky gui theo Ma Chuyen Bay"); 
        System.out.println("0.Ket thuc");
        System.out.println("Hay nhap lua chon cua ban: ");
        int choose = 0;
        try{
            choose = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            menuGuest();
        }
        switch (choose){
            case 0: break;
            case 1:
                nhap();
                menuGuest();
                System.out.println();
                break;
            case 2:
                xuat();
                menuGuest();
                System.out.println();
                break;
            case 3:
                themN();
                menuGuest();
                System.out.println();
                break;
            case 4:
                xoaNMa();
                menuGuest();
                System.out.println();
                break;
            case 5:
                suaNMa();
                menuGuest();
                System.out.println();
                break;
            case 6:
                timkiemMaHLKG();
                menuGuest();
                System.out.println();
                break;
            case 7:
                timkiemMaKH();
                menuGuest();
                System.out.println();
                break;
            case 8:
                timkiemMaVe();
                menuGuest();
                System.out.println();
                break;
            case 9:
                timkiemMaCB();
                menuGuest();
                System.out.println();
                break;
            default:
                System.out.println("Thong tin khong hop le!! Hay nhap lai!");
                menuGuest();
                break;
        }
    }
}

