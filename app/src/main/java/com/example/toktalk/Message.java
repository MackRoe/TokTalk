package com.example.toktalk;

/** Created by MackRoe, March 15, 2021 **/

public class Message {

    private String content;

    public Message(){

    }
    public Message(String content){
        this.content= content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
