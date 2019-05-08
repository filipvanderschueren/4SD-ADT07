package be.uantwerpen.fti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class InlezenGegevens {


    //private Map<Integer,Integer> m;
    //private Tabel tabel;
    //private LoonFreq lf;


    public InlezenGegevens() {

        //this.lf = new LoonFreq(Map<Integer,Integer>);
        //this.tabel = new Tabel(Map<Integer, lf>);
            }

    public void readData(String filename) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        Map<Integer, Map<Integer,Integer>> t = new TreeMap<Integer,Map<Integer,Integer>>();
        //Tabel tabel = new Tabel();


        String line = br.readLine();
        int linecounter = 1;

        try {
            while (! line.isEmpty()) {

                String[] split = line.split(" ");
                Integer leefTijd = Integer.parseInt(split[0]);
                Integer loon = Integer.parseInt(split[1]);

                //test your read-in values
                //System.out.println("leefTijd :" + leefTijd);
                //System.out.println("loon :" + loon);

                //LoonFreq Map telkens invoegen in Tabel
                //Map<Integer, Integer> tempLF = new TreeMap<Integer, Integer>();


                if (! t.containsKey(leefTijd))
                //indien deze leeftijd nog niet aanwezig, put met nieuwe Map(loon,1) onder deze leefTijd key
                { Map<Integer, Integer> tempLF = new TreeMap<Integer, Integer>();
                    tempLF.put(loon, 1);
                    t.put(leefTijd, tempLF);
                }
                    //en als de Key leefTijd al wel aanwezig is, check Key loon
                else
                    {   Map<Integer, Integer> tempLF = new TreeMap<Integer, Integer>();
                        tempLF = t.get(leefTijd);
                        if (! tempLF.containsKey(loon))
                        {   //nieuw element toevoegen
                            tempLF.put(loon, 1);
                            t.put(leefTijd, tempLF);
                        }
                        else
                        {   //Key loon al aanwezig, increment van de value
                            Integer tempFreq = tempLF.get(loon);

                                tempLF.put(loon, ++tempFreq);
                                t.put(leefTijd, tempLF);
                        }
                    }
                line = br.readLine();   //nextLine
                linecounter++;
            }

        }
        catch (Exception e) {
            System.out.println("end of File in exception");
        }
        finally {
            br.close();
        }
        System.out.println("Records readIn : " + linecounter );

        //gegevens van tabel t naar scherm sturen
        Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = t.entrySet();
        for (Map.Entry<Integer, Map<Integer, Integer>> e : entries )
            System.out.println("output: "+ e);
    }

}
