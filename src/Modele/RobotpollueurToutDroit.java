package Modele;

public class RobotpollueurToutDroit extends Robot
{
    int ColDepart;
    Monde m;
    
    public RobotpollueurToutDroit(int colDepart, Monde M)
    {  
        super(0, colDepart, M);
        this.ColDepart = colDepart;
        this.m = M;
    }

    public void parcourir() throws ErrRobot
    {       
        if(ColDepart<m.nbC || ColDepart>0) 
        {
            for(int i=0; i<m.nbL; i++)
                       
                m.insrt_PG(i, ColDepart); 
        }

        m.affiche_Mat();              
    }

}