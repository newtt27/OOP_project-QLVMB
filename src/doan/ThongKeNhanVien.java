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
public class ThongKeNhanVien {
    NhanVien[] dsnv;
    int n;
    int getN() throws IOException {print();return this.n;}
    public void print() throws IOException
    {
        NhanVienList a = new NhanVienList();
        dsnv = a.getList();
        //Tongve
        int count = 0;
        if(dsnv!=null)
        {
            for(int i = 0; i<dsnv.length; i++)
            {
                if(dsnv[i].getMaNV()!=null)
                {
                    count++;
                }   
            }
            n=count;
            System.out.println("So nhan vien: "+count);
        }
        else System.out.println("Chua co ds NV");
    }
}
