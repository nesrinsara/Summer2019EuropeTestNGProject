package com.cybertek.tests.day17_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    @Test
    public void readExcelFile(){
        //create an object from ExcelUtil(accepts two argument)
        ExcelUtil qa3short=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
        //how many rows
        System.out.println("Row count :"+qa3short.rowCount());
        //how many columns
        System.out.println("Column count: "+ qa3short.columnCount());

        System.out.println("Column names: "+qa3short.getColumnsNames());

        List<Map<String, String>> dataList = qa3short.getDataList();


        for (Map<String,String> onerow: dataList) {
           System.out.println(onerow);
       }
        //get all data in 2d array
        String [][] dataArray=qa3short.getDataArray();
        //print array
        System.out.println(Arrays.deepToString(dataArray));


    }

}
