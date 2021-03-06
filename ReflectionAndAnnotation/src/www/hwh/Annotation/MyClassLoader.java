package www.hwh.Annotation;

import java.io.*;

public class MyClassLoader extends ClassLoader {

    //类加载器名称
    private String name;
    //加载类的路径
    private String path = "D:/";
    private final String fileType = ".class";
    public MyClassLoader(String name){
        //让系统类加载器成为该 类加载器的父加载器
        super();
        this.name = name;
    }
    
  
    public MyClassLoader(ClassLoader parent, String name){
        //显示指定该类加载器的父加载器
        super(parent);
        this.name = name;
    }
    
  

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * 获取.class文件的字节数组
     * @param name
     * @return
     */
    private byte[] loaderClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        name = name.replace(".", "/");
        try {
            is = new FileInputStream(new File(path + name + fileType));
            int c = 0;
            while(-1 != (c = is.read())){
                baos.write(c);
            }
            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 获取Class对象
     */
    @Override
    public Class<?> findClass(String name){
        byte[] data = loaderClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //loader1的父加载器为系统类加载器
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("E:/");
        //loader2的父加载器为loader1
        MyClassLoader loader2 = new MyClassLoader("loader2");
        loader2.setPath("E:/");
        //loader3的父加载器为根类加载器
        MyClassLoader loader3 = new MyClassLoader(null, "loader3");
        loader3.setPath("E:/");
        
        Class clazz1 = loader1.loadClass("com.slovef.JavassistClass");
        Class clazz2 = loader2.loadClass("com.slovef.JavassistClass");
        Class clazz3 = loader3.loadClass("java.lang.String");
        Class clazz4 = loader1.loadClass("com.slovef.JavassistClass");
        
        System.out.println(clazz1.hashCode());
        System.out.println(clazz2.hashCode());
        System.out.println(clazz3.hashCode());
        System.out.println(clazz4.hashCode());
        System.out.println(clazz3.getClassLoader());
        System.out.println(clazz4.getClassLoader());
    }
}