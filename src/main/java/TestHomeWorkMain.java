import com.sun.org.apache.bcel.internal.Const;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.net.URLClassLoader;

public class TestHomeWorkMain {

    public static void main(String[] args) throws Exception{

        Class ch = URLClassLoader.newInstance(new URL[]{new File("C:\\Java\\java3-lesson7-externalClassFile")
                .toURL()}).loadClass("HomeWork");

        Object virtualHomeWork = ch.newInstance(); // Cоздаем экземляр класса с помощью рефлексии.

        Method[] methods = ch.getDeclaredMethods();

        for (Method o : methods) {
            System.out.println(o);
        }

        /** При запуске данного for получаем
         *
         * public static void HomeWork.main(java.lang.String[])
         * public static void HomeWork.diagonalOne()
         * public static void HomeWork.minMaxArray()
         * public static void HomeWork.multiplyArray()
         * public static void HomeWork.turnZeroToOne()
         * public static void HomeWork.addValueInArray()
         * public static void HomeWork.checkBalance(int[])
         *

         */

        Method testMethod = ch.getDeclaredMethod("minMaxArray");
        testMethod.invoke(virtualHomeWork);

        Method testMethod2 = ch.getDeclaredMethod("diagonalOne");
        testMethod2.invoke(virtualHomeWork);

//        Method testMethod3 = ch.getDeclaredMethod("main(java.lang.String[]");
//        testMethod3.invoke(virtualHomeWork);
        // Мэйн почему-то не запускается, почему?



    }
}
