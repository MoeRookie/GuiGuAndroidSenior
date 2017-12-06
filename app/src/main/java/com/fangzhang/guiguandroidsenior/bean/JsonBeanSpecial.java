package com.fangzhang.guiguandroidsenior.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 */

public class JsonBeanSpecial {
    private int code;
    private List<FilmBean> filmBeanList;

    public JsonBeanSpecial(int code, List<FilmBean> filmBeanList) {
        this.code = code;
        this.filmBeanList = filmBeanList;
    }

    public JsonBeanSpecial() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<FilmBean> getFilmBeanList() {
        return filmBeanList;
    }

    public void setFilmBeanList(List<FilmBean> filmBeanList) {
        this.filmBeanList = filmBeanList;
    }

    public static class FilmBean{
        private String aid;
        private String author;
        private int coins;
        private String copyright;
        private String create;

        public FilmBean(String aid, String author, int coins, String copyright, String create) {
            this.aid = aid;
            this.author = author;
            this.coins = coins;
            this.copyright = copyright;
            this.create = create;
        }

        public FilmBean() {
        }

        public String getAid() {
            return aid;
        }

        public void setAid(String aid) {
            this.aid = aid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getCoins() {
            return coins;
        }

        public void setCoins(int coins) {
            this.coins = coins;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCreate() {
            return create;
        }

        public void setCreate(String create) {
            this.create = create;
        }

        @Override
        public String toString() {
            return "FilmBean{" +
                    "aid='" + aid + '\'' +
                    ", author='" + author + '\'' +
                    ", coins=" + coins +
                    ", copyright='" + copyright + '\'' +
                    ", create='" + create + '\'' +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "JsonBeanSpecial{" +
                "code=" + code +
                ", filmBeanList=" + filmBeanList +
                '}';
    }
}
