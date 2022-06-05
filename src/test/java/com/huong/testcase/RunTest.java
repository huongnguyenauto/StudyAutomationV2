package com.huong.testcase;

import org.testng.annotations.Test;
import testobject.ObjectUtil;

public class RunTest {

    @Test
    public void testGetXpathDynamic(){
        System.out.println(ObjectUtil.getXpathDynamic("//span[normalize-space()='%s']/a[%d]", "Projects", 2));
    }

}
