/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comp10152_Lab6;

/**
 * @author Jinkal Dudhat, 000762953
 * @author akash patel, 000761062
 */

public class ShotsRecord{
    public int xCor,yCor;
//  public String[] CellState = {"Empty","Hit","Miss"};
    public String CellState;
    public ShotsRecord Next;
    private ShotsRecord Head;
    private ShotsRecord Tail;
    
    /**
     * create an constructor for ShotsRecord
     */
    public ShotsRecord(){
        Head=null;
        Tail=null;
    }
    
    /**
     * insert method
     * @param x indicates - coordinates
     * @param y indicates y coordinates
     * @param State is used to give state of cell
     */
    public void insert(int x,int y,String State){
        ShotsRecord shotsptr=new ShotsRecord();
        shotsptr.xCor=x;
        shotsptr.yCor=y;
        shotsptr.Next=null;
        shotsptr.CellState=State;
        if(Head==null){
            Head=shotsptr;
            Tail=shotsptr;
        }else{
            Tail.Next=shotsptr;
            Tail=shotsptr;
        }
    }
    
    /**
     * this method returns cell state.
     * @param x is temp variable of x coordinates
     * @param y is temp variable of y coordinates
     * @return an empty
     */
    public String returnCellState(int x,int y){
        ShotsRecord temp=Head;
        while(temp!=null){
            if(temp.xCor==x && temp.yCor==y){
                return temp.CellState;
            }else{
                temp=temp.Next;
            }
        }
        return "Empty";
    }
}