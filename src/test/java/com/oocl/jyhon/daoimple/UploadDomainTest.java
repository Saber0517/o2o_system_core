package com.oocl.jyhon.daoimple;

import com.oocl.jyhon.dao.UploadFileEntityDao;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by WhiteSaber on 15/8/9.
 */
public class UploadDomainTest {
    @Test
    public void testUploadImple() {
        String file = UUID.randomUUID().toString();
        byte[] bytes = file.getBytes();
        UploadFileEntityDao uploadFileEntityDao = new UploadFileEntityDaoImple();
        InputStream inputStream = new ByteInputStream(bytes,bytes.length);
        TestCase.assertEquals(uploadFileEntityDao.insert(inputStream, "testUUID"),1);
    }
}
