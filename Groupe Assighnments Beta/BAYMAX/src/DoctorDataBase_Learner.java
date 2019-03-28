import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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
public class DoctorDataBase_Learner 
{
    private final DoctorDataBase doctorDataBase;
    public DoctorDataBase_Learner(DoctorDataBase doctorDataBase)
    {
        this.doctorDataBase = doctorDataBase;
    }
    
    public void learn() throws IOException
    {
        //Diabetes_past_data_Learner                 a = new Diabetes_past_data_Learner(doctorDataBase.diabetes_past_data,11);
        CardiovascularDisease_past_data_Learner    c = new CardiovascularDisease_past_data_Learner(doctorDataBase.CardiovascularDisease_past_data,9);
        CongestiveHeartFailure_past_data_Learner   d = new CongestiveHeartFailure_past_data_Learner(doctorDataBase.CongestiveHeartFailure_past_data,10);
        CoronaryHeartDisease_past_data_Learner     e = new CoronaryHeartDisease_past_data_Learner(doctorDataBase.CoronaryHeartDisease_past_data,10);
        HardCoronaryHeartDisease_past_data_Learner b = new HardCoronaryHeartDisease_past_data_Learner(doctorDataBase.HardCoronaryHeartDisease_past_data,7);
        IntermittentClaudication_past_data_Learner g = new IntermittentClaudication_past_data_Learner(doctorDataBase.IntermittentClaudication_past_data,8);
        Stroke_past_data_Learner                   h = new Stroke_past_data_Learner(doctorDataBase.stroke_past_data,9);
    	AtrialFibrillation_past_data_Learner       i = new AtrialFibrillation_past_data_Learner(doctorDataBase.AtrialFibrillation_past_data,10);
    	

		//Getting the output stream of the file for writing
		File f = new File("C:\\wamp64\\www\\BAYMAX\\HypothesisParameters.txt");
		FileOutputStream fos = new FileOutputStream(f);
		PrintWriter pw = new PrintWriter(fos);


		//Writing the user input to the file
		pw.write(c.OutputString); pw.write("\n");System.out.println(c.OutputString);
		pw.write(d.OutputString); pw.write("\n");System.out.println(d.OutputString);
		pw.write(e.OutputString); pw.write("\n");System.out.println(e.OutputString);
		pw.write(b.OutputString); pw.write("\n");System.out.println(b.OutputString);
		pw.write(g.OutputString); pw.write("\n");System.out.println(g.OutputString);
		pw.write(h.OutputString); pw.write("\n");System.out.println(h.OutputString);
		pw.write(i.OutputString); pw.write("\n");System.out.println(i.OutputString);
		
		pw.flush();
		fos.close();
		pw.close();
    }
    
}
