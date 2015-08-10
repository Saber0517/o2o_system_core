package com.oocl.jyhon.dao;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by WhiteSaber on 15/8/9.
 */
public interface UploadFileEntityDao {

    int insert(InputStream inputStream, String fileName);

    byte[] getFileByByte(String fileName);

    InputStream getFile(String fileName);
}
