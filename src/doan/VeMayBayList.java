package doan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public  class VeMayBayList{
    private static int nr;
    public  VeMayBay[] rl;
    public VeMayBayList(){
           nr=0;
           rl=new VeMayBay[nr];
    }
    public VeMayBayList(VeMayBay[] rl, int nr){
        this.rl=rl;
        VeMayBayList.nr=nr;
    }
    
    public VeMayBayList(VeMayBay l){
        rl=l.rl;
        nr=l.nr;
    }

    public void setVeMayBayList(VeMayBay[] rl){
        this.rl=rl;
    }
    
    public int getNr(){
        return nr;
    }
    public void setNr(int nr){
        this.nr=nr;
    }
    public VeMayBay[] getList() throws IOException
            {
                readFile();
                return rl;
            }
    public void menu() throws IOException, ParseException {
        Scanner sc=new Scanner(System.in);
        int choose;
        do{
            System.out.println("\n========   MENU  =========\n");
            System.out.println("1.Xuat ds ve may bay");
            System.out.println("2.Them ve may bay");
            System.out.println("0.Exit");
            System.out.println("You want choose number ? ");
            choose=sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 0:
                    break;
                case 1:
                    readFile();
                    output();
                    System.out.println();
                    break;
                case 2:
                    Thems();
                    System.out.println();
                    break;
            }
        }while (choose>0);
    }
    public void input() throws IOException, ParseException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of rooms: ");
        nr = sc.nextInt();
        sc.nextLine();
        rl = new VeMayBay[nr];
        for (int i = 0; i < nr; i++){
            int choose;      
            System.out.println("Chon loai ve:  ");
            System.out.println("1.Ve thuong");
            System.out.println("2.Ve thuong gia");
            System.out.println("Choose number: ");
            choose=sc.nextInt();
            switch (choose){
                case 1:
                    System.out.println("VE THUONG");
                    rl[i]=new VeThuong();
                    rl[i].nhap();
                    for(int j = 0; j < i; j++){
                        if (rl[j].getMaVe().equals(rl[i].getMaVe())){ 
                            System.out.println("This ID already exists, please re-enter !!!");
                            rl[i].nhap();
                        }
                    }
                    break;
                case 2:
                    System.out.println("VE THUONG GIA");
                    rl[i] =new VeThuongGia();
                    rl[i].nhap();
                    for(int j = 0; j < i; j++){
                        if (rl[j].getMaVe().equals(rl[i].getMaVe())){ 
                            System.out.println("This ID already exists, please re-enter !!!");
                            rl[i].nhap();
                        }
                    }
                    break;
                default: break;
            }
        }
        writeFile();
    }
    public void output() throws IOException{
        readFile();
        for (int i=0;i<rl.length;i++) {
            rl[i].xuat();
            System.out.println("-------------------------------------");
        }
    }
    public void Thems() throws IOException, ParseException {
        Scanner sc=new Scanner(System.in);
        int num;
        System.out.println("Nhap so luong muon them:  ");
        num=sc.nextInt();
        sc.nextLine();
        for (int i=0;i<num;i++){
            Them();
        }
    }
    public void Them() throws IOException, ParseException{
        readFile();
        Scanner sc=new Scanner(System.in);
        System.out.println("Chon loai ve ");
        System.out.println("1.Ve thuong");
        System.out.println("2.Ve thuong gia");
        System.out.println("Choose number: ");
        int choose=sc.nextInt();
        rl=Arrays.copyOf(rl, nr+1);
        switch(choose){
            case 1:
                rl[nr]=new VeThuong();
                rl[nr].nhap();
                for(int j = 0; j < nr; j++){
                        if (rl[j].getMaVe().equals(rl[nr].getMaVe())){ 
                            System.out.println("This ID already exists, please re-enter !!!");
                            rl[nr].nhap();
                        }
                    }
                nr++;
                System.out.println("Add successfully");
                writeFile();
                break;
            case 2:
                rl[nr]=new VeThuongGia();
                rl[nr].nhap();
                for(int j = 0; j < nr; j++){
                        if (rl[j].getMaVe().equals(rl[nr].getMaVe())){ 
                            System.out.println("This ID already exists, please re-enter !!!");
                            rl[nr].nhap();
                        }
                    }
                nr++;
                System.out.println("Add successfully");
                writeFile();
                break;
            default:
                System.out.println("Choose again");
        }
    }
    public void writeFile(){
        try{
            FileWriter fw = new FileWriter("VeMayBayList.txtiet");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i=0;i<rl.length;i++){
                bw.write(rl[i].toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        }catch(IOException e){
        }
    }
    public void readFile() throws IOException{
        int i=0;
        FileReader fr = null;
        BufferedReader br = null;
        rl=new VeMayBay[1];
        try{
            fr = new FileReader("VeMayBayList.txtiet");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                String t[] = line.split(";");
                i++;
                rl=Arrays.copyOf(rl, i);
                if ("RT".equals(t[7])){
                 rl[i-1]= new VeThuong(t[0],t[1],t[2],t[3],Integer.parseInt(t[4]),
                            t[5],Integer.parseInt(t[6]),t[8]);
                }
                else {
                    rl[i-1]=new VeThuongGia(t[0],t[1],t[2],t[3],Integer.parseInt(t[4]),
                            t[5],Integer.parseInt(t[6]),t[8]);
                }
                line = br.readLine();
            }
            nr=i;
        }catch(Exception e){
        }finally{
          //  br.close();
            //fr.close();
        }
    }
}
