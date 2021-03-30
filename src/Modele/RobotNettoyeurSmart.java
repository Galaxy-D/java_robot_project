package Modele;

public class RobotNettoyeurSmart extends Robot
{
    Monde m;

    public RobotNettoyeurSmart(Monde M) { super(M); }

    public void parcourir(Monde m) throws ErrRobot 
    {
        for(int i=0; i<m.nbL; i++)
        {
            for(int j=0; j<m.nbC; j++)
            {
                if(m.test_PG(i, j))
                    
                    m.get_PG(i,j);  
            }      
        }
        m.affiche_Mat(); 
    } 
    public void parcourir(){};

}