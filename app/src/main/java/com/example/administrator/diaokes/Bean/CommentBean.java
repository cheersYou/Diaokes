package com.example.administrator.diaokes.Bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/19.
 */

public class CommentBean {
    /*
    private int code;
    private String message;
    private Data data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }

    public class Data {

        private int total;
        private List<CommentDetailBean> list;
        public void setTotal(int total) {
            this.total = total;
        }
        public int getTotal() {
            return total;
        }

        public void setList(List<CommentDetailBean> list) {
            this.list = list;
        }
        public List<CommentDetailBean> getList() {
            return list;
        }

    }*/

    String count;
    String message;
    List<CommentDetailBean> lists;
    public CommentBean(String count,String message) {
        this.count = count;
        this.message = message;
    }

    public List<CommentDetailBean> getList(){
        return lists;
    }

    public void setList(List<CommentDetailBean> lists) {
        this.lists = lists;
    }

    public void setCount(String count){
        this.count = count;
    }

    public String getCount(){
        return count;
    }



}
