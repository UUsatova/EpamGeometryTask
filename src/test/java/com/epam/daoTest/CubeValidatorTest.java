package com.epam.daoTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.epam.dao.CubeValidator;

import org.junit.Test;


public class CubeValidatorTest {

    @Test
    public void testIsCubeShouldReturnTrueOnCurrectData(){
        //given
        CubeValidator cubeValidator = new CubeValidator();
        //then
        assertTrue( cubeValidator.isCube("0.0 0.0 0.0 1.0 0.0 0.0 -1.0 0.0 0.0 1.0 0.0 0.0 "));

    }

    @Test
    public void testIsCubeShouldReturnFalseOnIncurrectData(){
        //given
        CubeValidator cubeValidator = new CubeValidator();
        // then
        assertFalse( cubeValidator.isCube("1.0 0.0 0.0 1.z 0.0 0.0 1.0 0.0 0.0 "));

    }
    
}
