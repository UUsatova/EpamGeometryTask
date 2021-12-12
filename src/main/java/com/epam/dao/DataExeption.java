package com.epam.dao;

public class DataExeption extends Exception {

    public DataExeption(){
    super() ;
    }

    public DataExeption(Exception e){
        super(e) ;
    }

    public DataExeption(String message ,Exception e){
        super(message, e) ;
    }

}
