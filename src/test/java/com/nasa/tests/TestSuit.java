package com.nasa.tests;

import com.nasa.api.GetData_Asteroid_Base;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestSuit {

    GetData_Asteroid_Base getDataAsteroidBase = new GetData_Asteroid_Base();

    @Test (priority = 0, description = "Verify that the field object is not empty")
    public void VerifyFieldsNotNull() throws IOException {
        getDataAsteroidBase.getBaseData("433",
                "1900-01-01",
                "2100-01-01",
                "0.2");
        Assert.assertNotNull(getDataAsteroidBase.returnFields());
    }

    @Test (priority = 1, description = "Verify that the Data object is not empty")
    public void VerifyDataNotNull() throws IOException {

        Assert.assertNotNull(getDataAsteroidBase.returnData());
    }

    @Test (priority = 2, description = "Verify that the Signature object is not empty")
    public void VerifySignatureNotNull() throws IOException {
        Assert.assertNotNull(getDataAsteroidBase.returnSignature());
    }

    @Test (priority = 3, description = "Verify that the Count is not empty")
    public void VerifyCountNotNull() throws IOException {
        Assert.assertNotNull(getDataAsteroidBase.returnCount());
    }

    @Test (priority = 4, description = "Verify that the Count is not empty")
    public void VerifyCountNotNull2() throws IOException {

        getDataAsteroidBase.getBaseData("433",
                "1900-01-01",
                "2100-01-01",
                "0.2");
        getDataAsteroidBase.getAllData_Field_Mapping();
        System.out.println(getDataAsteroidBase.getFields_basedOnInput(1));

    }

    @Test (priority = 5, description = "Verify that all the filter values are available")
    public void VerifyFilterValuesNotNull() throws IOException {
        getDataAsteroidBase.getBaseData("433",
                "1900-01-01",
                "2100-01-01",
                "0.2");
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(0));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(1));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(2));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(3));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(4));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(5));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(6));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(7));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(8));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(9));
        Assert.assertNotNull(getDataAsteroidBase.getFields_basedOnInput(10));
    }

    @Test (priority = 6, description = "Verify that all the data array values are available")
    public void VerifyDataValuesNotNull() throws IOException {
        getDataAsteroidBase.getBaseData("433",
                "1900-01-01",
                "2100-01-01",
                "0.2");
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_des ());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_orbit_id());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_jd());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_cd());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_dist());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_dist_min());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_dist_max());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_v_rel());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_v_inf());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_t_sigma_f());
        Assert.assertNotNull(getDataAsteroidBase.return_DataOf_Field_h());
    }

    @Test (priority = 7, description = "Verify that all the status codes are working as expected")
    public void VerifyTheStatusCodes() throws IOException {
        getDataAsteroidBase.getData_WithStatusCode(200);

    }

}
