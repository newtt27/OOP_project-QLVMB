
package doan;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class VeMayBay {
    static int GiaVeThuong = 1000000;
    static int GiaVeVip = 2000000;
    private String MaVe;
    private String MaCB;
    private String NgayDi;
    private String GioLenMayBay;
    private int CuaVoMayBay;
    private String STTGhe;
    private int GiaVe;
    
    private ChuyenBay[] ChuyenBayList;
    VeMayBay[] rl;
    int nr;
    VeMayBay(){}
    VeMayBay(String MaVe,String MaCB,String NgayDi,String GioLenMayBay, int CuaVoMayBay,String STTGhe, int GiaVe)
    {this.MaVe=MaVe;this.MaCB=MaCB;this.NgayDi=NgayDi;this.GioLenMayBay=GioLenMayBay;this.CuaVoMayBay=CuaVoMayBay;this.STTGhe=STTGhe;this.GiaVe=GiaVe;}
    VeMayBay(VeMayBay vmb)
    {this.MaVe=vmb.MaVe;this.MaCB=vmb.MaCB;this.NgayDi=vmb.NgayDi;this.GioLenMayBay=vmb.GioLenMayBay;this.CuaVoMayBay=vmb.CuaVoMayBay;this.STTGhe=vmb.STTGhe;this.GiaVe=vmb.GiaVe;}
    
    String getMaVe() {return MaVe;}
    void setMaVe(String MaVe) {this.MaVe=MaVe;}
    String getMaCB() {return MaCB;}
    void setMaCB(String MaCB) {this.MaCB=MaCB;}
    String getNgayDi() {return NgayDi;}
    void setNgayDi(String NgayDi) {this.NgayDi=NgayDi;}
    String getGioLenMayBay() {return GioLenMayBay;}
    void setGioLenMayBay(String GioLenMayBay) {this.GioLenMayBay=GioLenMayBay;}
    int getCuaVoMayBay() {return CuaVoMayBay;}
    void setCuaVoMayBay(int CuaVoMayBay) {this.CuaVoMayBay=CuaVoMayBay;}
    String getSTTGhe() {return STTGhe;}
    void setSTTGhe(String STTGhe) {this.STTGhe=STTGhe;}
    int getGiaVe() {return GiaVe;}
    void setGiaVe(int GiaVe) {this.GiaVe=GiaVe;}
    
    void nhap() throws IOException, ParseException{
        Scanner in = new Scanner(System.in);   
        nhapLoaiVe();
        System.out.println("Moi ban nhap Ma Ve!");
        MaVe = String.format("%s%02d",MaVe,nhapMaSo()); 
        System.out.println("Moi ban nhap Ma Chuyen Bay!");
        MaCB = String.format("CB%02d",nhapMaSo());
        NgayDi();       
        GioLenMayBay();
        System.out.println("Moi ban nhap STT Ghe!");
        STTGhe = String.format("%s%02d",STTGhe,nhapMaSo()); 
        if(checkNullSpace()) nhap();
        nhapCuaVoMayBay();
        System.out.println("");
    }
    void nhapCuaVoMayBay(){
        Scanner in = new Scanner(System.in);        
        try{
            System.out.println("Moi ban nhap Cua vo may bay: ");
            CuaVoMayBay = Integer.parseInt(in.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen");
            nhapCuaVoMayBay();
        } 
    } 
    void nhapLoaiVe() throws IOException, ParseException{
        Scanner in = new Scanner(System.in);
        System.out.println("Hay chon loai ve:\n1.Hang thuong\n2.Hang thuong gia\n");
            try{
                int temp = Integer.parseInt(in.nextLine());
                switch(temp) {
                case 1: MaVe = "RT"; STTGhe = "NOR"; GiaVe = GiaVeThuong; break;//Regular ticket break;
                case 2: MaVe = "VT"; STTGhe = "VIP"; GiaVe = GiaVeVip; break;//Vip ticket break;
                default: System.out.println("Vui long chon 1 hoac 2!"); nhapLoaiVe(); break;
                
                }
            }   catch(NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen");
                nhapLoaiVe();
            }
    }
    static int nhapMaSo()
    {
        Scanner in = new Scanner(System.in); 
        int temp=0;
        try{     
                System.out.println("Moi ban nhap Ma So(0<n<100):");
                temp = Integer.parseInt(in.nextLine());
                if (temp>=100&&temp<0) nhapMaSo();
            } catch(NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen");
                nhapMaSo();
            }
        return temp;
    }
    public void NgayDi() throws IOException
    {
        ChuyenBayList n = new ChuyenBayList();
        ChuyenBayList = n.getList();
        if(ChuyenBayList!=null)
        {
            for(int i = 0; i<ChuyenBayList.length; i++)
            {
                if(ChuyenBayList[i].getMaCB().equals(MaCB))
                {
                    NgayDi = ChuyenBayList[i].getNgayDi();
                }
            }
        }
    }
    public void GioLenMayBay() throws IOException, ParseException
    {
        ChuyenBayList n = new ChuyenBayList();
        ChuyenBayList = n.getList();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String time = "00:30:00";
        for(int i = 0; i<ChuyenBayList.length; i++)
        {
            if(ChuyenBayList[i].getMaCB().equals(MaCB))
            {
                String Giodi = ChuyenBayList[i].getGioDi();
                Date date1 = format.parse(Giodi);
                Date date2 = format.parse(time);
                long difference = date1.getTime() - date2.getTime(); 
                long Gio = difference/(60* 60 * 1000) % 24;
                long Phut = difference/(60 * 1000) % 60;
                GioLenMayBay = Gio+":"+Phut+":"+"00";
            }
        }
    }
    Boolean checkNullSpace()
    {
        if(MaVe.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(MaCB.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(NgayDi.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(GioLenMayBay.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        if(STTGhe.trim().length()==0){
            System.out.println("Vui long khong bo qua viec nhap du lieu!");
            return true;
        }
        return false;
    }
    void xuat(){
        System.out.println("Ma Ve: "+MaVe);
        System.out.println("Ma Chuyen Bay: "+MaCB);
        System.out.println("Ngay di: "+NgayDi);
        System.out.println("Gio len may bay: "+GioLenMayBay);
        System.out.println("Cua vo may bay: "+CuaVoMayBay);
        System.out.println("STT ghe: "+STTGhe);
        System.out.println("Gia Ve: "+GiaVe);
        System.out.println("----------------------------");
    }  
    @Override
    public String toString()
    {
        return MaVe+";"+MaCB+";"+NgayDi+";"+GioLenMayBay+";"+CuaVoMayBay+";"+STTGhe+";"+GiaVe;
    }
}
//    public void menu() throws IOException, ParseException{ 
//        Scanner in = new Scanner(System.in);
//        System.out.println("\n==========   MENU VE MAY BAY   ===========");
//        System.out.println("1.Quan ly danh sach Ve Thuong");
//        System.out.println("2.Quan ly danh sach Ve Thuong Gia");
//        System.out.println("0.Ket thuc");
//        System.out.println("Hay nhap lua chon cua ban: ");
//        int choose = 0;
//        try{
//            choose = Integer.parseInt(in.nextLine());
//        } catch(NumberFormatException e) {
//            System.out.println("Vui long nhap so nguyen");
//            menu();
//        }
//        switch (choose){
//            case 0: break;         
//            case 1:
//                VeThuongList vtl = new VeThuongList();
//                vtl.menu();
//                menu();
//                System.out.println();
//                break;
//            case 2:
//                VeThuongGiaList vtgl = new VeThuongGiaList();
//                vtgl.menu();
//                menu();
//                System.out.println();
//                break;
//            default:
//                System.out.println("Thong tin khong hop le!! Hay nhap lai!");
//                menu();
//                break;
//        }
//    }
//}
