package com.zbzl.until;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.ApplicationListener;

import java.net.InetAddress;
import java.net.UnknownHostException;


/****
 *获取ip地址
 */



public class ServerConfig implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
  private int serverPort;

  @Override
  public void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
    this.serverPort = event.getEmbeddedServletContainer().getPort();
  }
  public String getUrl() {
    InetAddress address = null;
    try {
      address = InetAddress.getLocalHost();
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    return "http://" + address.getHostAddress() ;
  }


}