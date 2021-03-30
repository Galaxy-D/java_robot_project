package Modele;

public class RobotpollueurLibre extends Robot
{
    Monde m;
    Robot R;

    public RobotpollueurLibre(Monde M) { super(M); }

    public void parcourir(int nbrPG, Monde m) throws ErrRobot
    {
        for(int k=0; k<nbrPG; k++)
        {
            int i = (int)(Math.random()*10);
            int j = (int)(Math.random()*10); 

            if((i<m.nbL || i>0) && (j<m.nbC || j>0))     
            {
                super.deplacer(i, j);
                m.insrt_PG(i,j);
            }   

        }
        m.affiche_Mat();   
    }

    public void parcourir(){}; 

}