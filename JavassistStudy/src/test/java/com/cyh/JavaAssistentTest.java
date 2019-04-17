package com.cyh;

import java.io.IOException;

import org.junit.Test;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/**
 * @author: yanhua.chen
 * @date: 2019/4/17 16:55
 */
public class JavaAssistentTest {

    @Test
    public void test01() throws IOException, CannotCompileException, NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.cyh.Rectangle");
        cc.setSuperclass(pool.get("com.cyh.Point"));
        cc.writeFile();

        byte[] b = cc.toBytecode();
        System.err.println(new String(b));
        Class clazz = cc.toClass();
        System.err.println(clazz);
    }

    @Test
    public void test02() throws CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();

        CtClass cc2 = pool.makeClass("com.cyh.Circle");

        CtMethod method = CtNewMethod.make("public Integer getInteger() { return null; }", cc2);
        cc2.addMethod(method);

        CtField field = new CtField(CtClass.intType, "age", cc2);
        cc2.addField(field);

        System.err.println(cc2.toClass().newInstance());
    }

    @Test
    public void test03() throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass point = pool.get("com.cyh.Point");
        CtMethod method = point.getDeclaredMethod("move");
        method.insertBefore("System.err.println($1);\n System.err.println($2);\n");
        point.writeFile();
    }

}
