package com.epam.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public List<String> read(String fileName) throws DataExeption{
        
        try {
            List<String> allDataFromFile = new ArrayList<>();
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while  (line != null){
                allDataFromFile.add(line);
                line = reader.readLine();
    
            }
            return allDataFromFile;
            
            
        } catch (FileNotFoundException e) {
            throw new DataExeption("file was not found ",e);
        } catch (IOException e) {
            throw new DataExeption("an I/O exception  has occurred",e);
        }
            
        }
       

    }

   
}
    

