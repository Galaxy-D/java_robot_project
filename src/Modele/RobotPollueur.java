package Modele;

public class RobotPollueur extends Robot
{
    Monde m;

    public RobotPollueur(Monde m) { super(m); }

    public void parcourir(){};

    public void parcourir(Monde m) throws ErrRobot
    {       
        for(int i=0; i<m.nbL; i++)
        {
            for(int j=0; j<m.nbC; j++)
            {
                m.insrt_PG(i, j);
            }
        }

        m.affiche_Mat(); 
    };

}
