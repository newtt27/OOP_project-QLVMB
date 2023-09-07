/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class ThongKeKhachHang {
    KhachHang[] dskh;
    int n;
    int getN() throws IOException {print();return this.n;}
    public void print() throws IOException
    {
        KhachHangList a = new KhachHangList();
        dskh = a.getList();
        //Tongve
        int count = 0;
        if(dskh!=null)
        {
            for(int i = 0; i<dskh.length; i++)
            {
                if(dskh[i].getMaKH()!=null)
                {
                    count++;
                }   
            }
            n=count;
            System.out.println("So khach hang: "+count);
        }
        else System.out.println("Chua co ds KH");
    }
}
