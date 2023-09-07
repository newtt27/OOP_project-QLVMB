package doan;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class Menu 
{
    public static void Menu() throws IOException, ParseException{
        Scanner in =new Scanner(System.in);
        int choose;
        do {
            System.out.println("Ban la ai? ");
            System.out.println("1.Quan tri vien");
            System.out.println("0.Exit");
            choose=in.nextInt();
            switch(choose){
                case 1: {
                    showStaffMenu();
                    break;
                }
                case 0: break;
                default: System.out.println("Invalid selection! Please choose again !!");
            }
        } while (choose!=0);
    }
    public static void showStaffMenu() throws IOException, ParseException{
        Scanner in =new Scanner(System.in);
        int choose;
            System.out.println("                       +-----------------------STAFF MENU----------------------+");
            System.out.println("                       |          1. Quan ly Nhan Vien                         |");
            System.out.println("                       |          2. Quan ly Khach Hang                        |");
            System.out.println("                       |          3. Quan ly Chuyen Bay                        |");
            System.out.println("                       |          4. Quan ly Ve May Bay                        |");
            System.out.println("                       |          5. Quan ly Ve cua Khach Hang                 |");
            System.out.println("                       |          6. Quan ly Hoa Don                           |");
            System.out.println("                       |          7. Quan ly Chi tiet Hoa Don                  |");
            System.out.println("                       |          8. Quan ly Hanh Ly Ky Gui                    |");
            System.out.println("                       |          9. Quan ly Dia Diem                          |");
            System.out.println("                       |         10. Quan ly Phong Cho                         |");
            System.out.println("                       |         11. Quan ly San Bay                           |");
            System.out.println("                       |         12. Quan ly May Bay                           |");
            System.out.println("                       |         13. Quan ly Hang Bay                          |");
            System.out.println("                       |         14. Thong Ke                                  |");
            System.out.println("                       |          0. Exit                                      |");
            System.out.println("                       +-------------------------------------------------------+");
            System.out.println("Enter number:");
            choose=in.nextInt();
            in.nextLine();
            switch(choose){
                case 1: 
                    System.out.println("----Quan ly Nhan Vien----");
                    NhanVienList nvl=new NhanVienList();
                    nvl.Menu();
                    showStaffMenu();
                    break;
                case 2:
                    System.out.println("----Quan ly Khach Hang----");
                    KhachHangList khl=new KhachHangList();
                    khl.menu();
                    showStaffMenu();
                    break;
                case 3:
                    System.out.println("----Quan ly Chuyen Bay----");
                    ChuyenBayList cbl =new ChuyenBayList();
                    cbl.menu();
                    showStaffMenu();
                    break;
                case 4:
                    System.out.println("----Quan ly Ve May Bay ----");
                    VeMayBayList vmb=new VeMayBayList();
                    vmb.menu();
                    showStaffMenu();
                    break;
                case 5:
                    System.out.println("----Quan ly Ve cua Khach Hang----");
                    KH_VeList khvl =new KH_VeList();
                    khvl.Menu();
                    showStaffMenu();
                    break;
                case 6:
                    System.out.println("----Quan ly Hoa Don----");
                    HoaDonList hdl=new HoaDonList();
                    hdl.Menu();
                    showStaffMenu();
                    break;
                case 7:
                    System.out.println("----Quan ly Chi tiet Hoa Don ----");
                    CTHoaDonList cthdl=new CTHoaDonList();
                    cthdl.Menu();
                    showStaffMenu();
                    break;
                case 8:
                    System.out.println("----Quan ly Hanh Ly Ky Gui ----");
                    HanhLyKyGuiList hlkgl=new HanhLyKyGuiList();
                    hlkgl.menuGuest();
                    showStaffMenu();
                    break;
                case 9:
                    System.out.println("----Quan ly Dia Diem-----");
                    DiaDiemList ddl=new DiaDiemList();
                    ddl.Menu();
                    showStaffMenu();
                    break;
                case 10:
                    System.out.println("----Quan ly Phong Cho-----");
                    PhongChoList pcl=new PhongChoList();
                    pcl.Menu();
                    showStaffMenu();
                    break;
                case 11:
                    System.out.println("----Quan ly San Bay-----");
                    SanBayList sbl=new SanBayList();
                    sbl.Menu();
                    showStaffMenu();
                    break;
                case 12:
                    System.out.println("----Quan ly May Bay-----");
                    MayBayList mbl=new MayBayList();
                    mbl.Menu();
                    showStaffMenu();
                    break;
                case 13:
                    System.out.println("----Quan ly Hang Bay-----");
                    HangBayList hbl=new HangBayList();
                    hbl.Menu();
                    showStaffMenu();
                    break;
                case 14:
                    System.out.println("----Thong Ke-----");
                    ThongKeMenu.menu();
                    showStaffMenu();
                    break;
                case 0: break;
                default: System.out.println("Invalid selection! Please choose again !!");
            }
    }
}