import java.util.*;

public class HelloWorld{

     public static void main(String []args){
        Scanner file = new Scanner(System.in);

        //ArrayList<String> list = new ArrayList<String>();

        int total = 0;
        while(file.hasNext())
        {
            ArrayList<String> list = new ArrayList<String>();
            String line = "";
            do{
                if(file.hasNext())
                {
                    line = file.nextLine();
                }
                else
                {
                    break;
                }
                Scanner scanner = new Scanner(line);
                while(scanner.hasNext())
                {
                    list.add(scanner.next());
                }
            }while(line.length() > 0);
            //System.out.println(list);
            int byr = 0;
            int iyr = 0;
            int eyr = 0;
            int hgt = 0;
            int hcl = 0;
            int ecl = 0;
            int pid = 0;


            for(int i = 0; i < list.size(); i++)
            {

                if(list.get(i).contains("byr"))
                {
                    String byearStr = list.get(i).substring(4,list.get(i).length());
                    int byear = Integer.parseInt(byearStr);
                    if(byear >= 1920 && byear <= 2002)
                    {
                        byr = 1;
                    }
                }
                if(list.get(i).contains("iyr"))
                {
                    String iyearStr = list.get(i).substring(4,list.get(i).length());
                    int iyear = Integer.parseInt(iyearStr);
                    if(iyear >= 2010 && iyear <= 2020)
                    {
                        iyr = 1;
                    }
                }
                if(list.get(i).contains("eyr"))
                {
                    String eyearStr = list.get(i).substring(4,list.get(i).length());
                    int eyear = Integer.parseInt(eyearStr);
                    if(eyear >= 2020 && eyear <= 2030)
                    {
                        eyr = 1;
                    }
                }
                if(list.get(i).contains("hgt"))
                {
                    String hgtStr = list.get(i).substring(4,list.get(i).length());
                    int valid = 1;
                    if(hgtStr.length() < 3)
                    {
                        valid = 0;
                    }
                    String unit = hgtStr.substring(hgtStr.length() - 2, hgtStr.length());
                    String num = hgtStr.substring(0, hgtStr.length() - 2);
                    int numHgt = 0;
                    if(num.length() == 0)
                    {
                        valid = 0;
                    }
                    else
                    {
                        numHgt = Integer.parseInt(num);
                    }
                    if(valid == 1 && unit.equals("cm") && numHgt >= 150 && numHgt <= 193)
                    {
                        hgt = 1;
                    }
                    else if(valid == 1 && unit.equals("in") && numHgt >= 59 && numHgt <= 76)
                    {
                        hgt = 1;
                    }
                }
                if(list.get(i).contains("hcl"))
                {
                    String hcolorStr = list.get(i).substring(4,list.get(i).length());
                    int valid = 1;
                    for(int j = 1; j < hcolorStr.length(); j++)
                    {
                        if(!((hcolorStr.charAt(j) >= 48 && hcolorStr.charAt(j) <= 57) || (hcolorStr.charAt(j) >= 97 && hcolorStr.charAt(j) <= 102)))
                        {
                            valid = 0;
                        }
                    }
                    if(hcolorStr.length() == 7 && valid == 1 && hcolorStr.charAt(0) == '#')
                    {
                        hcl = 1;
                    }
                }
                if(list.get(i).contains("ecl"))
                {
                    String ecolorStr = list.get(i).substring(4,list.get(i).length()); //amb blu brn gry grn hzl oth
                    if(ecolorStr.equals("amb") || ecolorStr.equals("blu") || ecolorStr.equals("brn") || ecolorStr.equals("gry") || ecolorStr.equals("grn") || ecolorStr.equals("hzl") || ecolorStr.equals("oth"))
                    {
                        ecl = 1;
                    }
                }
                if(list.get(i).contains("pid"))
                {

                    String pidStr = list.get(i).substring(4,list.get(i).length());
                    int valid = 1;
                    for(int j = 0; j < pidStr.length(); j++)
                    {
                        if(pidStr.charAt(j) < 48 || pidStr.charAt(j) > 57)
                        {
                            valid = 0;
                        }
                    }
                    if(pidStr.length() == 9 && valid == 1)
                    {
                        pid = 1;
                    }
                }
            }
            if(byr + iyr + eyr + hgt + hcl + ecl + pid == 7)
            {
                total = total + 1;
            }
            //System.out.println(byr + " " + iyr + " " + eyr + " " + hgt + " " + hcl + " " + ecl + " " + pid);
        }
        System.out.println(total);


     }
}
