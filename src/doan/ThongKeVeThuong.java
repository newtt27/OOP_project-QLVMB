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
class ThongKeVeThuong implements ThongKe  {
    VeThuong[] dsvt;
    int n;
    int getN() throws IOException {print();return this.n;}
    @Override
    public void print() throws IOException
    {
        VeThuongList a = new VeThuongList();
        dsvt = a.getList();
        //Tongve
        int count = 0;
        if(dsvt!=null)
        {
            for(int i = 0; i<dsvt.length; i++)
            {
                if(dsvt[i].getMaVe()!=null)
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
