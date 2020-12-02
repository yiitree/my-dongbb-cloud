package javaclient;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

/**
 * 连接apollo的测试
 */
public class ApolloConfigTest {

    /**
     * 获取apollo的test.enabled属性字段
     * @param args
     */
	public static void main(String[] args) {
		Config config = ConfigService.getAppConfig();
		String someKey = "test.enabled";
		String value = config.getProperty(someKey, null);
		System.out.println("test.enabled: " + value);
	}
}
