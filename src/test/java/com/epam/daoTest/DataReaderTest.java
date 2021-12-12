package com.epam.daoTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.epam.dao.DataExeption;
import com.epam.dao.DataReader;

import org.junit.Test;



public class DataReaderTest {

    @Test
    public void testReadShouldReadInformationFromFileWithOneLine() throws DataExeption{
        //given
        String fileName = "src/test/java/com/epam/resources/OneLine.txt";
        DataReader dataReader = new DataReader();
        List<String> expected = new ArrayList<>(Arrays.asList("0.0 0.0 0.0 1.0 0.0 0.0 1.0 0.0 0.0 1.0 0.0 0.0 "));
        
        //when
        List<String> actual = dataReader.read(fileName);

        //then
        assertEquals(expected, actual);

    }

    @Test
    public void testReadShouldReadInformationFromFileWithSeveralLines() throws DataExeption{
        //given
        String fileName = "src/test/java/com/epam/resources/SeveralLines.txt";
        DataReader dataReader = new DataReader();
        List<String> expected = new ArrayList<>(Arrays.asList("я к вам пишу","чего же боле?","1.0.0.0.0.0.0" ));
        //when
        List<String> actual = dataReader.read(fileName);
        // then
        assertEquals(expected, actual);

    }

    @Test(expected=com.epam.dao.DataExeption.class)
    public void testReadShouldThrowDataExeptionWhenFileNotFound() throws DataExeption {
        //given
        String fileName = "notFoundFile";
        DataReader dataReader = new DataReader();
        //then
        dataReader.read(fileName);


    }
    

    
}
