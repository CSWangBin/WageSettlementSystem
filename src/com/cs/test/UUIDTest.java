package com.cs.test;

import com.cs.bean.SAdmin;
import com.cs.commom.UUIDGenerator;
import org.junit.Test;

/**
 * Created by 举 on 2016/12/8.
 */
public class UUIDTest {
    @Test
    public void testUUid() {
        UUIDGenerator uu = new UUIDGenerator();

        System.out.println(uu.generate().toString());

        SAdmin sAdmin = new SAdmin();
        sAdmin.setId(uu.generate().toString());
        sAdmin.setName("aa");
    }
}
