import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Properties;

import static org.junit.Assert.fail;

/**
 * Created by Mephalay on 11/12/2016.
 */
@RunWith(JMockit.class)
public class TestAll {

    @Test
    public void readInnerDefaultProps() {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getClassLoader().getResourceAsStream("defaultProps.properties"));
            System.out.println();
            System.out.println(properties.getProperty("targetFolder"));
            System.out.println(properties.getProperty("backupFolders"));
        } catch (Throwable t) {
            t.printStackTrace();
            fail();
        }
    }

}
