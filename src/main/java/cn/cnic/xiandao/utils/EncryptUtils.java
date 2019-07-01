package cn.cnic.xiandao.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncryptUtils {
    public static String encrypt(String str,String salt, String algorithmName, int hashIterations)
    {
        return new SimpleHash(algorithmName,str, ByteSource.Util.bytes(salt),hashIterations).toString();
    }
}
