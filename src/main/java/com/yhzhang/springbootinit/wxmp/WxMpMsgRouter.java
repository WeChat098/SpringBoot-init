package com.yhzhang.springbootinit.wxmp;

import javax.annotation.Resource;
import me.chanjar.weixin.common.api.WxConsts.EventType;
import me.chanjar.weixin.common.api.WxConsts.XmlMsgType;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yhzhang.springbootinit.wxmp.handler.EventHandler;
import com.yhzhang.springbootinit.wxmp.handler.MessageHandler;
import com.yhzhang.springbootinit.wxmp.handler.SubscribeHandler;

/**
 * 微信公众号路由
 *
 * @author <a href="https://github.com/WeChat098">程序员yhzhang</a>
 * 
 */
@Configuration
public class WxMpMsgRouter {

        @Resource
        private WxMpService wxMpService;

        @Resource
        private EventHandler eventHandler;

        @Resource
        private MessageHandler messageHandler;

        @Resource
        private SubscribeHandler subscribeHandler;

        @Bean
        public WxMpMessageRouter getWxMsgRouter() {
                WxMpMessageRouter router = new WxMpMessageRouter(wxMpService);
                // 消息
                router.rule()
                                .async(false)
                                .msgType(XmlMsgType.TEXT)
                                .handler(messageHandler)
                                .end();
                // 关注
                router.rule()
                                .async(false)
                                .msgType(XmlMsgType.EVENT)
                                .event(EventType.SUBSCRIBE)
                                .handler(subscribeHandler)
                                .end();
                // 点击按钮
                router.rule()
                                .async(false)
                                .msgType(XmlMsgType.EVENT)
                                .event(EventType.CLICK)
                                .eventKey(WxMpConstant.CLICK_MENU_KEY)
                                .handler(eventHandler)
                                .end();
                return router;
        }
}
