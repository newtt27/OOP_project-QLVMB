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
public class ThongKeVeThuongGia implements ThongKe{
    VeThuongGia[] dsvtg;
    int n;
    int getN() throws IOException {print();return this.n;}
    @Override
    public void print() throws IOException
    {
        VeThuongGiaList a = new VeThuongGiaList();
        dsvtg = a.getList();
        //Tongve
        int count = 0;
        if(dsvtg!=null)
        {
            for(int i = 0; i<dsvtg.length; i++)
            {
                if(dsvtg[i].getMaVe()!=null)
                {
                    count++;
                }   
            }
            n=count;
            System.out.println("So ve thuong: "+count);
        }
        else System.out.println("Chua co ds ve thuong");
    }
}
