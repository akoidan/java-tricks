package reflection.clazz;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

class MyClassLoader extends ClassLoader {	
	private String jarName;
	private JarFile jar;
	private Map<String, Class> loaded = new HashMap<String, Class>();

    public MyClassLoader(String jarName) {
		super(MyClassLoader.class.getClassLoader());
		this.jarName = jarName;
		try {
			this.jar = new JarFile( jarName );
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}

	public Class<?> findClass(String name) throws ClassNotFoundException{
		
		Class c = loaded.get(name);
		if (c!=null)
			return c;
		
		try{
			return findSystemClass(name);
		}catch(Exception e){
			
		}
		
        byte[] b;
        try{
        	b = loadClassData(name);		
        	c=defineClass(name, b, 0, b.length);
        	loaded.put(name, c);
        }catch(Throwable e){
        	throw new ClassNotFoundException(e.getMessage());
        }
        return c;
    }

    private byte[] loadClassData(String name) throws ClassNotFoundException {		
		String entryName = name.replace('.', '/') + ".class";
		byte buf[]=new byte[0];
		try {			                        
            JarEntry entry = jar.getJarEntry(entryName);
            if (entry==null){
        		throw new ClassNotFoundException(name);                
            }
            InputStream input = jar.getInputStream( entry );
            int size = new Long(entry.getSize()).intValue();
            buf = new byte[size];
            int count = input.read(buf/*, 0, size*/);
            if (count < size)
            	throw new ClassNotFoundException("Error reading class '"+name+"' from :"+jarName);            
		} catch (IOException e1) {
			throw new ClassNotFoundException(e1.getMessage()); 
		}
		return buf;
    }
}