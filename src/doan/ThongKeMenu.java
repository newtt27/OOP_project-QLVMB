package doan;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class ThongKeMenu {
    public static void menu() throws IOException, ParseException { 
        Scanner in =new Scanner(System.in);
        int choose=0;
        do {
            System.out.println("                       +-------------------MENU THONG KE-----------------------+");
            System.out.println("                       |          1. Thong ke Ve Thuong                        |");
            System.out.println("                       |          2. Thong ke Ve Thuong  Gia                   |");
            System.out.println("                       |          3. Thong ke Chuyen Bay                       |");
            System.out.println("                       |          4. Thong ke Nhan Vien                        |");
            System.out.println("                       |          5. Thong ke Khach Hang                       |");
            System.out.println("                       |          0. Exit                                      |");
            System.out.println("                       +-------------------------------------------------------+");
            System.out.println("Enter number:");
            choose=in.nextInt();
            in.nextLine();
            switch(choose){
                case 1: 
                    ThongKeVeThuong tkvt=new ThongKeVeThuong();
                    tkvt.print();
                    menu();
                    break;
                case 2:
                    ThongKeVeThuongGia tkvtg=new ThongKeVeThuongGia();
                    tkvtg.print();
                    menu();
                    break;
                case 3:
                    ThongKeChuyenBay tkcb=new ThongKeChuyenBay();
                    tkcb.print();
                    menu();
                    break;
                case 4:
                    ThongKeNhanVien tknv=new ThongKeNhanVien();
                    tknv.print();
                    menu();
                    break;
                case 5:
                    ThongKeKhachHang tkkh=new ThongKeKhachHang();
                    tkkh.print();
                    menu();
                    break;
                case 0: break;
                default: System.out.println("Invalid selection! Please choose again !!");
            }
        } while (choose!=0);
    }
    }