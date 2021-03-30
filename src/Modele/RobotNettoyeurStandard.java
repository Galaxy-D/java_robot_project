package Modele;

public class RobotNettoyeurStandard extends Robot
{
    int ColDepart;
    Monde m;
    
    public RobotNettoyeurStandard(int colDepart, Monde M)
    {  
        super(0, colDepart, M);
        this.ColDepart = colDepart;
        this.m = M;
    }

    public void parcourir() throws ErrRobot 
    {       
        if(ColDepart<m.nbC || ColDepart>0) //throw new ErrRobot();
        {
            for(int i=0; i<m.nbL; i++)
                       
                m.get_PG(i, ColDepart); 
        }

        m.affiche_Mat();              
    }

}