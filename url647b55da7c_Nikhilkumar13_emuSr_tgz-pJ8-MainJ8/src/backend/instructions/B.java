/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.instructions;

import frontend.FrontEnd;
import java.awt.Color;
import java.io.IOException;

/**
 *
 * @author nikhil
 */
public class B implements InsInterface2
{

    @Override
    public void execute(String ins, String token2)
      {
        
       
        if(token2.startsWith("."))
       {
           execb(token2);
        }
       else {
                 FrontEnd.appendToPane(FrontEnd.statuswindow,"ERROR(" + backend.ScanFile.current_line + "): Label "+ token2+" Must Start With ."+"\n",Color.RED);

            frontend.FrontEnd.exceptionraised++;
            
        }

       

      }

    private void execb(String token2) // B{cond} label
      {
        //System.out.print(":)) i came here in B :" + token2);
       
        try
        {
            token2 = token2.trim().substring(1);

            Long lno = null;
            try
            {

                lno = (Long) backend.FirstPass.branchtable.get(token2.toUpperCase());
               // System.out.println("lno in b");
                //System.out.println(lno);
               // cnvrt(lno);
                //System.out.print(lno);
            } catch (Exception e)
            {
                 FrontEnd.appendToPane(FrontEnd.statuswindow,"ERROR:" + backend.ScanFile.current_line + " Label " + token2 + " Not Found In The Program."+"\n",Color.RED);
//                frontend.FrontEnd.statuswindow.append("ERROR in line " + backend.ScanFile.current_line + " Label " + token2 + " not found in the program.");
                //frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
                frontend.FrontEnd.exceptionraised++;
                return;
            }
            if(lno==null)
            {
                 FrontEnd.appendToPane(FrontEnd.statuswindow,"ERROR:" + backend.ScanFile.current_line + " Label " + token2 + " Not Found In The Program."+"\n",Color.RED);

                frontend.FrontEnd.exceptionraised++;
                return;
                
            }
            if (lno >= 0)
            {
                //System.out.println(" \n Excuting b " +"\n" + backend.StepRun.initial_pos + " lno->" +lno);

                backend.ScanFile.br.seek(lno);

                backend.ScanFile.pos = lno;
                backend.StepRun.callbbeq = true;
                // backend.StepRun.initial_pos=lno.intValue();
                // //System.out.println("TESTING\n");
            }
            
//            else if (lno == -1)
//            {
//                //printf statement
//                linkregister = backend.ScanFile.br.getFilePointer();
//                backend.ScanFile.br.seek(backend.Register.r[0].b);
//                String tmp = backend.ScanFile.br.readLine();
//
//                String strline = backend.ScanFile.br.readLine();
//                strline = strline.trim();
//                System.err.println("branchd to " + strline);
//                if (strline.startsWith(".ascii"))
//                {
//                    strline = strline.substring(6);
//
//                    backend.ohandling.printhandle(strline);
//                }
//                backend.ScanFile.br.seek(linkregister);
//            } 
//            else if (lno == -3)
//            {
//                backend.Register.r[0].b = backend.Register.r[0].b % backend.Register.r[1].b;
//
//            }
        } catch (IOException ex)
        {
//            FrontEnd.appendToPane(FrontEnd.statuswindow,"",Color.RED);
            FrontEnd.appendToPane(FrontEnd.statuswindow,"ERROR in line " + backend.ScanFile.current_line + ": Unable To Branch To Label "+token2+"\n",Color.RED);
//            frontend.FrontEnd.statuswindow.append("ERROR in line " + backend.ScanFile.current_line + ": Unable to branch to that location.");
            //frontend.FrontEnd.statuswindow.setCaretPosition(frontend.FrontEnd.statuswindow.getText().length());
            frontend.FrontEnd.exceptionraised++;
            return;
        }
       
       

      }

   
}
