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
 * @author Admin
 */
public class ChuyenBayList 
{
    ChuyenBay[] dscb;
    int n;
    ChuyenBayList(){}
    ChuyenBayList(int n, ChuyenBay[] kh){this.n=n;this.dscb=kh;}
    
    public ChuyenBay[] getList() throws IOException
    {
        readFile();
        return this.dscb;
    }
    public void setList(ChuyenBay[] ChuyenBayList)
    {
        this.dscb = ChuyenBayList;
    }
    void nhap() throws IOException, ParseException
    {
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Nhap so luong Chuyen bay: ");
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
        dscb = new ChuyenBay[n];
        for(int i=0; i<n; i++)
        {
            dscb[i] = new ChuyenBay();
            dscb[i].nhap();
            System.out.println("\n//////////////");
            if(i > 0){
                for(int j = 0; j < i; j++){
                    if (dscb[j].getMaCB().equals(dscb[i].getMaCB())){ 
                        System.out.println("Ma CB da ton tai, hay nhap lai!!!");
                        dscb[i].nhap();
                    }
                }
            }
        }
        writeFile();
    }
    void xuat() throws IOException, ParseException
    {
        readFile();

        for(int i=0; i<dscb.length; i++){
            try{
                dscb[i].xuat();
            } catch (NullPointerException e){
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                dscb[i].nhap();
            }
        }
    }
    void them() throws IOException, ParseException 
    {
        readFile();
        n=dscb.length;
        dscb = Arrays.copyOf(dscb,n+1);
        dscb[n] = new ChuyenBay();
        dscb[n].nhap();
        for(int j=0; j<n; j++)
        {       
            while (dscb[j].getMaCB().equals(dscb[n].getMaCB()))
            { 
                    System.out.println("Ma CB da ton tai, hay nhap lai!!!");
                    dscb[n].nhap();                             
            }
        }
        n++;
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
                    them();
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
    ChuyenBay timkiemMaCB() throws IOException
    {
        readFile();
        System.out.println("Nhap ma CB can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        ChuyenBay x = new ChuyenBay();
        int i=0; 
        while(i<dscb.length)
        {
            if(dscb[i].getMaCB().equals(ma))
            {
                x=dscb[i];
                x.xuat();
            }
            i++;
        }
        if(x==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                    timkiemMaCB();
                    break;
                default: break;
            }
        }
        return x;
    }
    
    void suaMa() throws IOException, ParseException 
    {
        readFile();
        System.out.println("Nhap Ma CB can sua: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        int i;
        for (i=0; i<dscb.length; i++)
             if (dscb[i].getMaCB().equals(ma)) dscb[i].nhap();
        if (i == dscb.length){
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
    void suaNMa() throws IOException, ParseException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap so luong ban muon them: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            suaNMa();
        }
        if (sl > dscb.length || sl <=0){
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
        System.out.println("Nhap Ma CB can xoa: ");
        String ma = in.nextLine();
        int dem=0;
        int i=1;
        while(i<=dscb.length && !dscb[i-1].getMaCB().equals(ma))
        {
            dem++;  //den vi tri can xoa
            i++;
        }   
        if(i>dscb.length)
        {

            System.out.printf("Ma CB khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = in.nextInt();
            switch(choose){
                case 1: 
                   xoaMa();
                    break;
                default: break;
            }
        }
        else{
            while(dem<dscb.length-1)
            {
                dscb[dem]=dscb[dem+1]; //don` hang
                dem++;
            }
            dscb = Arrays.copyOf(dscb, dscb.length-1);
            writeFile();
        }
    }
    void xoaNMa() throws IOException
    {
        readFile();
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap so luong ban muon xoa: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            xoaNMa();
        }
        if (sl > dscb.length || sl <=0){
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
        FileWriter fw = new FileWriter("ChuyenBayList.txtiet");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toString());
        bw.close();
        fw.close();
        } catch (Exception e) {}
    }    
    @Override
    public String toString() {
        String s = "";
        for(int i = 0;i<dscb.length; i++){
           s += dscb[i].toString()+"\n";
        }
        return s;
    }
    public void readFile() throws IOException{
        int i = 0;
        dscb = new ChuyenBay[1];
        FileReader fr = null;
        BufferedReader br = null;
        try {
        fr = new FileReader("ChuyenBayList.txtiet");
        br = new BufferedReader(fr);
        String line = br.readLine();
        while(line != null){
            String temp[] = line.split(";");
            String MaCB = temp[0];
            String MaMB = temp[1];
            String NoiDi = temp[2];
            String NoiDen = temp[3];
            String NgayDi = temp[4];
            String NgayDen = temp[5];
            String GioDi = temp[6];
            String GioDen = temp[7];
            int SoGheTong = Integer.parseInt(temp[8]);
            int SoGheConLai = Integer.parseInt(temp[9]);
            String SanBayCatCanh = temp[10];
            String SanBayHaCanh = temp[11];
            i++; 
            dscb = Arrays.copyOf(dscb,i); 
            dscb[i-1] = new ChuyenBay(MaCB,MaMB,NoiDi,NoiDen,NgayDi,NgayDen,GioDi,GioDen,SoGheTong,SoGheConLai,SanBayCatCanh,SanBayHaCanh);       
            line = br.readLine();
            }
        }
        catch(Exception e){}
        finally{
        br.close();
        fr.close();
        }
        }
    public void menu() throws IOException, ParseException{ 
        Scanner in = new Scanner(System.in);
        System.out.println("\n==========   MENU FOR CHUYEN BAY   ===========");
        System.out.println("1.Nhap mot danh sach Chuyen Bay");
        System.out.println("2.Xuat danh sach Chuyen Bay");
        System.out.println("3.Them Chuyen Bay");
        System.out.println("4.Xoa Chuyen Bay theo Ma CB");
        System.out.println("5.Sua Chuyen Bay theo Ma CB");
        System.out.println("6.Tim Chuyen Bay theo Ma CB"); 
        System.out.println("0.Ket thuc");
        System.out.println("Hay nhap lua chon cua ban: ");
        int choose = 0;
        try{
            choose = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            menu();
        }
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
                timkiemMaCB();
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

