package Modele;

public class RobotNettoyeurLibre extends Robot
{
    Monde m;

    public RobotNettoyeurLibre(Monde M) { super(M); }

    public void parcourir(int nbrCP, Monde m) throws ErrRobot 
    {
        for(int k=0; k<nbrCP; k++)
        {
            int i = (int)(Math.random()*10);
            int j = (int)(Math.random()*10); 

            if((i<m.nbL || i>0) && (j<m.nbC || j>0)) //throw new ErrRobot();       
            {
                super.deplacer(i, j);
                m.get_PG(i,j);
            } 
        }
        m.affiche_Mat();   
    }

    public void parcourir(){}; 

}