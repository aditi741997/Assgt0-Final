package nikhil.ayush.aditi.assgt0_final1;

import android.widget.TextView;

import java.lang.String;import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

/**
 * Created by Ayush on 17-01-2016.
 */
public class Check_constraints
{
    public boolean teamname(String teamname)// Checks if the teamName is not an empty String
    {  if(teamname.length()==0)
        return false;
        for(int i=0;i<teamname.length();i++)
        {if(!isAlphabetic(teamname.charAt(i)))
        {return false;
        }

        }
        return true;
    }
    public boolean NAME(String name)        //Checks for validity of name. Name should have only only alphabets
    {if(name.length()==0)
        return false;
        for(int i=0;i<name.length();i++)
        {if(!isAlphabetic(name.charAt(i)))
        {return false;
        }
        }
        return true;
    }
    public boolean EntryNo(String entryno,boolean b)   //Checks for Validity of Entry Number.Entry no. should be in IIT Delhi format.eg 2014cs10201
    {   if(b)
        return true;

        int l=entryno.length();
        if(l!=11)
            return false;
        if(entryno.charAt(0)!='2'||entryno.charAt(1)!='0')
            return false;
        if(!isAlphabetic(entryno.charAt(4))&&!isAlphabetic(entryno.charAt(5)))
            return false;
        for(int i=6;i<l;i++)
        {
            if(!isDigit(entryno.charAt(i)))
                return false;
        }
        return true;
    }
    public boolean Diff_EntryNo(String entry1,String entry2,String entry3,boolean b)//Checks if the all the Entry No entered are different
    {if(b) {
        if (entry1.equals(entry2) || entry1.equals(entry3) || entry2.equals(entry3))
            return false;
    }
    else
    { if (entry1.equals(entry2))
        return false;
    }
        return true;
    }
}
