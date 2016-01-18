package nikhil.ayush.aditi.assgt0_final1;

import java.lang.String;import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isDigit;

/**
 * Created by Ayush on 17-01-2016.
 */
public class Check_constraints
{
    public boolean teamname(String teamname)
    {  for(int i=0;i<teamname.length();i++)
    {if(!isAlphabetic(teamname.charAt(i)))
    {return false;
    }

    }
        return true;
    }
    public boolean NAME(String name)
    {for(int i=0;i<name.length();i++)
    {if(!isAlphabetic(name.charAt(i)))
    {return false;
    }
    }
        return true;
    }
    public boolean EntryNo(String entryno)
    {int l=entryno.length();
        if(l!=11)
            return false;
        if(entryno.charAt(0)!='2'||entryno.charAt(1)!='0'||entryno.charAt(2)!='1')
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
    public boolean Diff_EntryNo(String entry1,String entry2,String entry3,boolean b)
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
