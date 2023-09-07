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
public class VeThuong extends VeMayBay {
    private String Xemphim;
    VeThuong(){}
    VeThuong(String MaVe,String MaCB,String NgayDi,String GioLenMayBay, int CuaVoMayBay,String STTGhe, int GiaVe,String Xemphim)
    {super(MaVe,MaCB,NgayDi,GioLenMayBay,CuaVoMayBay,STTGhe,GiaVe);
    this.Xemphim= Xemphim;}
    VeThuong(VeThuong vt){super((VeMayBay)vt);}
    String getXemphim() {return Xemphim;}
    void setXemphim(String Xemphim) {this.Xemphim=Xemphim;}
    

    @Override
    void nhap() throws IOException, ParseException{
        Scanner in = new Scanner(System.in);      
        System.out.println("Moi ban nhap Ve!");
        super.setMaVe(String.format("RT%02d",nhapMaSo())); 
        System.out.println("Moi ban nhap Ma Chuyen Bay!");
        super.setMaCB(String.format("CB%02d",nhapMaSo()));
        super.NgayDi();
        super.GioLenMayBay();
        super.setGiaVe(VeMayBay.GiaVeThuong);
        System.out.println("Moi ban nhap STT Ghe! ");
        super.setSTTGhe(String.format("NOR%02d",nhapMaSo()));
        if(checkNullSpace()) nhap();
        nhapCuaVoMayBay();
        chonphim();
        System.out.println("");
    }
    public void chonphim()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Chon loai phim muon xem: " );
        System.out.println("1.Hanh Dong ");
        System.out.println("2.Lang Man ");
        int choose=0;
        switch(choose)
        {
            case 1: Xemphim = "HanhDong";
            break;
            case 2: Xemphim="LangMan";
            break;
            default:break;
        }
    }
    @Override
    void xuat(){
        super.xuat();
        System.out.println("----------------------------");
    }
    public void writeFile()
    {
        try
        {
            FileWriter fw = new FileWriter("VeMayBayList.txtiet",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(toString());
            bw.newLine();
            bw.close();
            fw.close();
        }catch(IOException e){}
    }
    
    @Override
    public String toString()
    {
        return super.toString()+";"+"RT"+Xemphim;
    }
}
