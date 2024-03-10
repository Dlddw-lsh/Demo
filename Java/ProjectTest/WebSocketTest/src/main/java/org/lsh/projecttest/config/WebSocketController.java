package org.lsh.projecttest.config;

import com.alibaba.fastjson2.JSON;
import org.lsh.projecttest.entity.User;
import org.lsh.projecttest.mapper.UserMapper;
import org.lsh.projecttest.utils.SpringContextUtil;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@Controller
@ServerEndpoint("/websocket")
public class WebSocketController {

    @Resource
    UserMapper userMapper;

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        if (userMapper == null){
            this.userMapper = (UserMapper) SpringContextUtil.getBean("userMapper");
        }
        User user = userMapper.selectById(1);
        timeSchedule(user, 1000);
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        session.close();
    }

    public void timeSchedule(Object o, int times) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sendMessage(JSON.toJSONString(o));
            }
        };
        timer.schedule(task, 0, times);
    }


    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}