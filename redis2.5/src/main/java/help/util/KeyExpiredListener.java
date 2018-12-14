package help.util;

import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPubSub;
//@Service
public class KeyExpiredListener extends JedisPubSub {
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe "
                + pattern + " " + subscribedChannels);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {

        System.out.println("onPMessage pattern "
                + pattern + " " + channel + " " + message);
    }

}
