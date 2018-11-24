package help.Task;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPubSub;
@Slf4j
public class Subscribe extends JedisPubSub {
    public void onPSubscribe(String pattern, int subscribedChannels) {
        log.info("Subscribe-onPSubscribe>>>>>>>>>>>>>>>>>>>>>>>>"+pattern + "=" + subscribedChannels);
    }
    // 取得按表达式的方式订阅的消息后的处理
    public void onPMessage(String pattern, String channel, String message) {
        try {
            log.info(pattern + "=" + channel + "=" + message);
            //在这里写你相关的逻辑代码
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
