/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class ChuyenBay {
    private String MaCB;
    private String MaMB;
    private String NoiDi;
    private String NoiDen;
    private String NgayDi;
    private String NgayDen;
    private String GioDi;
    private String GioDen;
    private int SoGheTong;
    private int SoGheConLai;
    private String SanBayCatCanh;
    private String SanBayHaCanh;
    
    private MayBay[] MayBayList;
    private VeMayBay[] VeThuongList;
    private VeMayBay[] VeThuongGiaList;
    private DiaDiem[]   DiaDiemList;
    
    ChuyenBay(){}
    ChuyenBay(String MaCB, String MaMB, String NoiDi,String NoiDen,String NgayDi,String NgayDen,String GioDi,String GioDen,int SoGheTong,int SoGheConLai,
            String SanBayCatCanh,String SanBayHaCanh)
    {this.MaCB=MaCB;this.MaMB=MaMB;this.NoiDi=NoiDi;this.NoiDen=NoiDen;this.NgayDi=NgayDi;this.NgayDen=NgayDen;this.GioDi=GioDi;this.GioDen=GioDen;
    this.SoGheTong=SoGheTong;this.SoGheConLai=SoGheConLai;this.SanBayCatCanh=SanBayCatCanh;this.SanBayHaCanh=SanBayHaCanh;}
    ChuyenBay(ChuyenBay cb)
    {this.MaCB=cb.MaCB;this.MaMB=cb.MaMB;this.NoiDi=cb.NoiDi;this.NoiDen=cb.NoiDen;this.NgayDi=cb.NgayDi;this.NgayDen=cb.NgayDen;this.GioDi=cb.GioDi;this.GioDen=cb.GioDen;
    this.SoGheTong=cb.SoGheTong;this.SoGheConLai=cb.SoGheConLai;this.SanBayCatCanh=cb.SanBayCatCanh;this.SanBayHaCanh=cb.SanBayHaCanh;}
    
    String getMaCB() {return MaCB;}
    void setMaCB(String MaCB) {this.MaCB=MaCB;}
    String getMaMB() {return MaMB;}
    void setMaMB(String MaMB) {this.MaMB=MaMB;}
    String getNoiDi() {return NoiDi;}
    void setNoiDi(String NoiDi) {this.NoiDi=NoiDi;}
    String getNoiDen() {return NoiDen;}
    void setNoiDen(String NoiDen) {this.NoiDen=NoiDen;}
    String getNgayDi() {return NgayDi;}
    void setNgayDi(String NgayDi) {this.NgayDi=NgayDi;}
    String getNgayDen() {return NgayDen;}
    void setNgayDen(String NgayDen) {this.NgayDen=NgayDen;}
    String getGioDi() {return GioDi;}
    void setGioDi(String GioDi) {this.GioDi=GioDi;}
    String getGioDen() {return GioDen;}
    void setGioDen(String GioDen) {this.GioDen=GioDen;}
    String getSanBayCatCanh() {return SanBayCatCanh;}
    void setSanBayCatCanh(String SanBayCatCanh) {this.SanBayCatCanh=SanBayCatCanh;}
    String getSanBayHaCanh() {return SanBayHaCanh;}
    void setSanBayHaCanh(String SanBayHaCanh) {this.SanBayHaCanh=SanBayHaCanh;}
    int getSoGheTong() {return SoGheTong;}
    void setSoGheTong(int SoGheTong) {this.SoGheTong=SoGheTong;}
    int getSoGheConLai() {return SoGheConLai;}
    void setSoGheConLai(int SoGheConLai) {this.SoGheConLai=SoGheConLai;}
    
    void nhap() throws IOException, ParseException{
        Scanner in = new Scanner(System.in);
        System.out.println("Moi ban nhap Ma Chuyen Bay!");
        MaCB = String.format("CB%02d",VeMayBay.nhapMaSo());
        MayBayList mbl = new MayBayList();
        MayBayList = mbl.getList();
        VeThuongList vtl = new VeThuongList();
        VeThuongList = vtl.getList();
        VeThuongGiaList vtgl = new VeThuongGiaList();
        VeThuongGiaList = vtgl.getList();
        int count=0;
        
        if (VeThuongList!=null){            
            for(int j = 0; j < VeThuongList.length; j++)   {
                if(VeThuongList[j].getMaCB().equals(MaCB))
                    count++;
            }
        } else{
            System.out.println("Vui long nhap DS VeThuong");
            vtl.nhap();
            nhap();
        }
        if (VeThuongGiaList!=null){            
            for(int j = 0; j < VeThuongGiaList.length; j++)   {
                if(VeThuongGiaList[j].getMaCB().equals(MaCB))
                    count++;
            }
        } else{
            System.out.println("Vui long nhap DS VeThuong");
            vtgl.nhap();
            nhap();
        }
        if(MayBayList != null){
            System.out.println("Moi ban nhap Ma may bay!");
            MaMB = String.format("MB%02d",VeMayBay.nhapMaSo()); 
            for(int j = 0; j < MayBayList.length; j++)   {
                if(MayBayList[j].getMaMB().equals(MaMB)){
                    SoGheTong = MayBayList[j].getSoGhe();
                    SoGheConLai = SoGheTong - count;
                }
            }
        } else {
            System.out.println("Vui long nhap DS MAY BAY");
            mbl.Nhap();
            nhap();
        }
        System.out.println("Moi ban nhap Noi di:");
        NoiDi = in.nextLine();
        System.out.println("Moi ban nhap Noi den:");
        NoiDen = in.nextLine();
        System.out.println("Moi ban nhap Ngay di:");
        NgayDi = in.nextLine();
        System.out.println("Moi ban nhap Ngay den:");
        NgayDen= in.nextLine();
        GioDi=GioPhut();
        GioDen=GioPhut();
        DiaDiemList n = new DiaDiemList();
        DiaDiemList = n.getList();
        if(DiaDiemList!=null)
        {    
            for(int i = 0; i<DiaDiemList.length; i++)
            {
                if(DiaDiemList[i].getTenTP().equals(NoiDi))
                {SanBayCatCanh = DiaDiemList[i].getTenSB();}
                if(DiaDiemList[i].getTenTP().equals(NoiDen))
                {SanBayHaCanh = DiaDiemList[i].getTenSB();}

            }
        }
        if(checkNullSpace()) nhap();
        writeFile();
    }
    String GioPhut()
    {
        String Gio="";
        System.out.println("Moi ban nhap Thoi gian di:");
        Scanner in = new Scanner(System.in);   
        int h=0,m=0;
        try{
            System.out.println("Gio: ");
            h = Integer.parseInt(in.nextLine());
            if (h<0&&h>23){
                System.out.println("Vui long nhap lai gio(0-23h)!");
                GioPhut();
            }
            System.out.println("Phut: ");
            m = Integer.parseInt(in.nextLine());
            if (m<0&&h>23){
                System.out.println("Vui long nhap lai phut(0-59m)!");
                GioPhut();
            }
            
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            GioPhut();
        } 
        Gio = h+":"+m+":"+"00";
        return Gio;     
    }
    Boolean checkNullSpace()
    {
        if(MaCB.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(MaMB.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(NoiDi.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(NoiDen.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(NgayDi.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(NgayDen.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(GioDi.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(GioDen.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(SanBayCatCanh.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(SanBayHaCanh.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        return false;
    }

    void xuat() {
        System.out.println("Ma Chuyen Bay: "+MaCB);
        System.out.println("Ma May Bay: "+MaMB);
        System.out.println("Noi di: "+NoiDi);
        System.out.println("Noi den: "+NoiDen);
        System.out.println("Ngay di: "+NgayDi);
        System.out.println("Ngay den: "+NgayDen);
        System.out.println("Gio di: "+GioDi);
        System.out.println("Gio Den: "+GioDen);
        System.out.println("So ghe Tong: "+SoGheTong);
        System.out.println("So ghe Con lai: "+SoGheConLai);
        System.out.println("San bay cat canh: "+SanBayCatCanh);
        System.out.println("San bay ha canh: "+SanBayHaCanh);
        System.out.println("****************************");
    }
    public void writeFile(){
        try{
            FileWriter fw = new FileWriter("ChuyenBayList.txtiet",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toString());
            bw.newLine();
            bw.close();
            fw.close();
        } catch (Exception e){
        }
    }
    @Override
    public String toString(){
        return MaCB+";"+MaMB+";"+NoiDi+";"+NoiDen+";"+NgayDi+";"+NgayDen+";"+GioDi+";"+GioDen+";"+SoGheTong+";"+SoGheConLai+";"+SanBayCatCanh+";"+SanBayHaCanh;
    }
}

