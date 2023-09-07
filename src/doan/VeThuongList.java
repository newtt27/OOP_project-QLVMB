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
 * @author admin
 */
public class VeThuongList {
    VeThuong[] dsvt = new VeThuong[1];
    int n;
    VeThuongList(){}
    VeThuongList(int n, VeThuong[] kh){this.n=n;this.dsvt=kh;}
    public VeThuong[] getList() throws IOException
    {
        readFile();
        return this.dsvt;
    }
    public void setList(VeThuong[] dsvt)
    {
        this.dsvt = dsvt;
    }
    void nhap() throws IOException, ParseException
    {
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Nhap so luong Ve Thuong: ");
            n = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            nhap();
        }
        if (n <= 0){
            System.out.println("Thong tin khong hop le, hay nhap lai!!!\n");
            nhap();
        }
        dsvt = Arrays.copyOf(dsvt, n);
        for(int i=0; i<n; i++)
        {
            dsvt[i] = new VeThuong();
            dsvt[i].nhap();
            System.out.println(""+i);
            for(int j=0; j<i; j++){       
                System.out.println(""+dsvt[j].getMaVe()+"va"+dsvt[i].getMaVe());
                while (dsvt[j].getMaVe().equals(dsvt[i].getMaVe())){ 
                        System.out.println("Ma Ve da ton tai, hay nhap lai!!!");
                        dsvt[i].nhap();                             
                    }
                while ( (dsvt[j].getSTTGhe().equals(dsvt[i].getSTTGhe())) && dsvt[j].getMaCB().equals(dsvt[i].getMaCB()) ){
                        System.out.println("So ghe trung, hay nhap lai!!!");
                        dsvt[i].nhap();
                    }
                System.out.println(""+j);
                System.out.println("*************************");
            }
            dsvt[i].xuat();
            System.out.println("\n//////////////\n");            
        }
        writeFile();
    }
    void xuat() throws IOException, ParseException
    {
        readFile();
        for(int i=0; i<dsvt.length; i++) {
            try{
                dsvt[i].xuat();            
            } catch (NullPointerException e){
                System.out.println("Thong tin khong ton tai. Moi ban nhap lai!");
                menu();
            }
        }
    }
    void them() throws IOException, ParseException 
    {
        readFile();
        n=dsvt.length;
        dsvt = Arrays.copyOf(dsvt,n+1);
        dsvt[n] = new VeThuong();
        dsvt[n].nhap();
        for(int j=0; j<n; j++)
        {       
            while (dsvt[j].getMaVe().equals(dsvt[n].getMaVe())){ 
                    System.out.println("Ma Ve da ton tai, hay nhap lai!!!");
                    dsvt[n].nhap();                             
                }
            while ( (dsvt[j].getSTTGhe().equals(dsvt[n].getSTTGhe())) && dsvt[j].getMaCB().equals(dsvt[n].getMaCB()) ){
                    System.out.println("So ghe trung, hay nhap lai!!!");
                    dsvt[n].nhap();
                }
            System.out.println("*************************");
        }
        dsvt[n].xuat();
        System.out.println("\n//////////////\n");
        dsvt[n].writeFile();
        n++;
    }
    void themN() throws IOException, ParseException
    {
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap so luong ban muon them: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            themN();
        }
        if (sl > dsvt.length || sl <=0){
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
    void suaMa() throws IOException, ParseException 
    {
        readFile();
        System.out.println("Nhap ma can sua: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        int i;
        for (i=0; i<dsvt.length; i++){
            if (dsvt[i].getMaVe().equals(ma)){
                dsvt[i].nhap(); break;
            }
        }
        if (i == dsvt.length){
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
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap so luong ban muon them: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            suaNMa();
        }
        if ( sl <=0){
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
        while(i<=dsvt.length && !dsvt[i-1].getMaVe().equals(ma))
        {
            dem++;  //den vi tri can xoa
            i++;
        }   
        if(i>dsvt.length)
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
            while(dem<dsvt.length-1)
            {
                dsvt[dem]=dsvt[dem+1]; //don` hang
                dem++;
            }
            dsvt = Arrays.copyOf(dsvt, dsvt.length-1);
            writeFile();
        }
    }
    void xoaNMa() throws IOException, ParseException
    {
        Scanner in = new Scanner(System.in);
        int sl=0;
        try{
            System.out.println("Nhap so luong ban muon them: ");
            sl = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            themN();
        }
        if (sl > dsvt.length || sl <=0){
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
    VeThuong timkiemMaVe() throws IOException
    {
        readFile();
        System.out.println("Nhap ma can tim: ");
        Scanner in = new Scanner(System.in);
        String ma = in.nextLine();
        VeThuong x = new VeThuong();
        int i=0; 
        while(i<dsvt.length)
        {
            if(dsvt[i].getMaVe().equals(ma))
            {
                x = dsvt[i];
                x.xuat();
            }
            i++;
        }
        if(x.getMaVe()==null){
            System.out.printf("Thong tin khong hop le!!!\n1.Nhap lai \n2.Ket thuc");
            int choose = Integer.parseInt(in.nextLine());
            switch(choose){
                case 1: 
                    timkiemMaVe();
                    break;
                default: break;
            }
        }
        return x;
    }
   
    void writeFile() throws IOException 
    {
        try {
        FileWriter fw = new FileWriter("VeThuongList.txtiet");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toString());
        bw.close();
        fw.close();
        } catch (Exception e) {}
    }    
    @Override
    public String toString() {
        String s = "";
        for(int i = 0;i<dsvt.length; i++){
            s += dsvt[i].toString() + "\n";
        }
        return s;
    }
    public void readFile() throws IOException{
        int i = 0;
        dsvt = new VeThuong[1];
        n = 0;
        FileReader fr = null;
        BufferedReader br = null;
        try {    
        fr = new FileReader("VeThuongList.txtiet");
        br = new BufferedReader(fr);
        String line = br.readLine(); 
        String tempstr="RT";
        while(line != null){
            String temp[] = line.split(";");
            String MaVe = temp[0];
            if(MaVe.indexOf(tempstr)!=-1){
            String MaCB = temp[1];
            String NgayDi = temp[2];
            String GioLenMayBay = temp[3];
            int CuaVoMayBay = Integer.parseInt(temp[4]);
            String STTGhe = temp[5];
            int GiaVe = Integer.parseInt(temp[6]);
            i++; 
            n++;
            dsvt = Arrays.copyOf(dsvt,i); 
            dsvt[i-1] = new VeThuong(MaVe,MaCB,NgayDi,GioLenMayBay,CuaVoMayBay,STTGhe,GiaVe);  
            }   
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
        System.out.println("\n==========   MENU VE THUONG   ===========");
        System.out.println("1.Nhap mot danh sach Ve Thuong");
        System.out.println("2.Xuat danh sach Ve Thuong");
        System.out.println("3.Them Ve Thuong");
        System.out.println("4.Xoa Ve Thuong theo Ma Ve Thuong");
        System.out.println("5.Sua Ve Thuong theo Ma Ve Thuong");
        System.out.println("6.Tim Ve Thuong theo Ma Ve Thuong");   
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
                timkiemMaVe();
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
