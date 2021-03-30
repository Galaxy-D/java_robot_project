package Modele;

public abstract class Robot 
{
    int posx;
    int posy;
    Monde m;

    public Robot(int x, int y, Monde M) 
    {
        this.posx = x;
        this.posy = y;
        this.m = M;          
    }

    public Robot(Monde M) 
    {             
        this.posx = (int) (Math.random()*10);
        this.posy = (int) (Math.random()*10);
        this.m = M;
    }

    public void deplacer(int i, int j) //throws ErrRobot
    {
        if((i<m.nbL || i>0) && (j<m.nbC || j>0)) //throw new ErrRobot();

            this.posx =  i;
            this.posy =  j;        
    }

    public int getx(){ return posx;}
    public int gety(){ return posy;}

    public abstract void parcourir() throws ErrRobot;   
}