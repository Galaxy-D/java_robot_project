package Modele;

public class Monde
{
    int nbL;
    int nbC;
    boolean[][] Mat;

    public Monde(int nbl, int nbc)
    {
        this.nbL = nbl;
        this.nbC = nbc;  

        Mat = new boolean[nbl][nbc];

        for(int i=0; i<nbl; i++)
        {
            for(int j=0; j<nbc; j++)
            {
                Mat[i][j] = false;
            }
        }
       
    }

    public void insrt_PG(int i, int j) throws ErrRobot
    {
        if((i<nbL || i>0) && (j<nbC || j>0)) //throw new ErrRobot();

            Mat[i][j] = true; 
  
    }

    public void get_PG(int i, int j) throws ErrRobot
    {
        if((i<nbL || i>0) && (j<nbC || j>0)) //throw new ErrRobot(); 
              
            Mat[i][j] = false;  
    }

    public boolean test_PG(int i, int j) 
    {
        return Mat[i][j]; 
    }

    public int compt_PG()
    {   
        int s=0;
        for(int i=0; i<this.nbL; i++)
        {
            for(int j=0; j<this.nbC; j++)
            {
                if(Mat[i][j])   
                    s = s+1;
            }
        }
        return s;
    }

    public void affiche_Mat()
    {
        for(int i=0; i<this.nbL; i++)
        {
            for(int j=0; j<this.nbC; j++)
            {
                System.out.print(Mat[i][j] + " ");
            }
            System.out.println("\n");
        }       

    } 
    
    public int getnbL(){return nbL;}
    public int getnbC(){return nbC;}

}