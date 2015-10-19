package is202.swingutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



/**
 * This class provides a simple interface to using properties
 * for various settings. The class is a singleton. Call getInstance()
 * to get the single instance.
 *
 * The PropertyManager handles named sets of properties. To get
 * a property value two keys are needed: The property set name, and
 * the property name. The intention is to allow application writers
 * to use more than one file for settings
 *
 * If only the value of a single proerty is needed, call getProperty()
 * to get the value without getting the property manger first.
 *
 * @author evenal
 */
public class PropertyManager
{

    // the single instance
    private static final PropertyManager instance = new PropertyManager();

    // mapping from
    private Map<String, Properties> propMap;

    private PropertyManager() {
        propMap = new HashMap();
    }

    /**
     * Get the single instance
     */
    public static PropertyManager getInstance() {
        System.out.println("returning " + instance);
        return instance;
    }

    /**
     * convenience method, quick, no-exception lookup of property
     */
    public static String getProperty(String set, String name) {
        if (instance == null) {
            return null;
        }
        Properties props = instance.propMap.get(set);
        return props.getProperty(name);
    }

    /**
     * Get properties. Read properties from file if necessary,
     * and add them to the cache.
     *
     * @param name Property list name, used the key to retrieve
     *             properties from the cache, and to construct the filename.
     *
     * @throws IOException if file reading fails for any reason.
     */
    public Properties getProperties(String name) throws IOException {
        Properties props = propMap.get(name);
        if (null == props) {
            Properties defaults = loadDefaults(name);
            props = loadUserProps(name, defaults);
            propMap.put(name, props);
        }
        return props;
    }

    /**
     * Attempt to load language specific settings
     *
     * @param category
     * @param language
     *
     * @return
     *
     * @throws IOException
     */
    public Properties getProperties(String category, String language) throws IOException {
        Properties props = getProperties(category + "_" + language);
        if (null == props) {
            props = getProperties(category);
        }
        System.out.println("return " + props);
        return props;
    }

    public Properties getLocalizedProperties(String name) throws IOException {
        String lang = getProperties("prefs").getProperty("lang");
        return getProperties(name, lang);
    }

    private Properties loadUserProps(String category, Properties defaults) throws IOException {
        Properties props = new Properties(defaults);
        String home = System.getProperty("user.home");
        File path = new File(home, "ca");
        File propFile = new File(path, category
                + ".properties");

        if (propFile.canRead()) {
            try (InputStream in = new FileInputStream(propFile)) {
                props.load(in);
            }
        }
        return props;
    }

    private Properties loadDefaults(String basename) throws IOException {
        Properties props = new Properties();
        String name = basename + ".properties";
        try (InputStream in
                = this.getClass().getResourceAsStream("/" + name)) {
            if (null != in) {
                props.load(in);
            }
        }
        catch (IOException e) {
            return null;
        }
        return props;
    }

    public void saveProperties(String category, Properties props) throws IOException {
        String home = System.getProperty("user.home");
        File path = new File(home, "ca");
        File propFile = new File(path, category + ".properties");
        FileOutputStream out = new FileOutputStream(propFile);
        props.store(out, "");
    }
}
