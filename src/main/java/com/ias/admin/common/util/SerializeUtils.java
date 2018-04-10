package com.ias.admin.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class SerializeUtils {

    private static Logger logger = LoggerFactory.getLogger(SerializeUtils.class);

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object deserialize(byte[] bytes) {
        Object result = null;

        if (isEmpty(bytes)) {
            return null;
        }

        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    result = objectInputStream.readObject();
                } catch (ClassNotFoundException ex) {
                    throw new Exception("Failed to deserialize object type", ex);
                }
            } catch (Throwable ex) {
                throw new Exception("Failed to deserialize", ex);
            }
        } catch (Exception e) {
            logger.error("Failed to deserialize", e);
        }
        return result;
    }

    public static boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }


    /**
     * 序列化
     * @param object
     * @return
     */
    public static byte[] serialize(Object object){
        byte[] result = null;

        if(object == null){
            return new byte[0];
        }

        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
            try{
                if(!(object instanceof Serializable)){
                    throw new IllegalArgumentException(SerializeUtils.class.getSimpleName() + "requires a Serializable payload" +
                            "but received an object of type [" + object.getClass().getName() + "]");
                }
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(object);
                objectOutputStream.flush();
                result = byteArrayOutputStream.toByteArray();
            }catch(Throwable t){
                throw new Exception("Failed to serialize", t);
            }
        }catch (Exception e){
            logger.error("Failed to serialize", e);
        }
        return result;
    }


}
