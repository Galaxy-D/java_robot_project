package Modele;

public class RobotpollueurSauteurs extends Robot
{
    Monde m;

    public RobotpollueurSauteurs(Monde M) { super(M); }     

    public void parcourir(int i, int j, int saut, Monde m) throws ErrRobot 
    {
        if((i<m.nbL || i>0) && (j<m.nbC || j>0))  
        {
            for(int lig=i; lig<m.nbL; lig= lig+saut)
            {
                for(int col=j; col<m.nbC; col=col+saut)
                {
                    super.deplacer(lig, col);
                    m.insrt_PG(lig,col);
                } 
            }
        }
            
        m.affiche_Mat(); 
    }

    public void parcourir(){};   
}