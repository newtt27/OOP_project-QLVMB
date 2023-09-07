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
public class ThongKeChuyenBay {
    ChuyenBay[] dscb;
    int n;
    int getN() throws IOException {print();return this.n;}
    public void print() throws IOException
    {
        ChuyenBayList a = new ChuyenBayList();
        dscb = a.getList();
        //Tongve
        int count = 0;
        if(dscb!=null)
        {
            for(int i = 0; i<dscb.length; i++)
            {
                if(dscb[i].getMaCB()!=null)
                {
                    count++;
                }   
            }
            n=count;
            System.out.println("So chuyen bay: "+count);
        }
        else System.out.println("Chua co ds CB");
    }
}
