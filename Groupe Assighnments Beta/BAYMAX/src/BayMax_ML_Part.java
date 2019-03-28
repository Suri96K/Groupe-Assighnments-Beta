import java.io.IOException;

/*
/ * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package baymax_ml_part;

/**
 *
 * @author Mabeesha
 */
public class BayMax_ML_Part 
{

    /**
     * @param args the command line arguments
     * @throws IOException 
     */

    
    public static void main(String[] args) throws IOException 
    {
        DoctorDataBase database = new DoctorDataBase();
        DoctorDataBase_Learner databaseLearner = new DoctorDataBase_Learner(database);
        databaseLearner.learn();
    }
    
}
