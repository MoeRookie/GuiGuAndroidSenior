package com.fangzhang.guiguandroidsenior.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6.
 */

public class JsonBeanComplex {

    /**
     * data : {"count":5,"items":[{"id":45,"title":"坚果"},{"id":132,"title":"炒货"},{"id":166,"title":"蜜饯"},{"id":195,"title":"果脯"},{"id":196,"title":"礼盒"}]}
     * rs_code : 1000
     * rs_msg : success
     */

    private DataBean data;
    private String rs_code;
    private String rs_msg;

    public JsonBeanComplex(DataBean data, String rs_code, String rs_msg) {
        this.data = data;
        this.rs_code = rs_code;
        this.rs_msg = rs_msg;
    }

    public JsonBeanComplex() {
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getRs_code() {
        return rs_code;
    }

    public void setRs_code(String rs_code) {
        this.rs_code = rs_code;
    }

    public String getRs_msg() {
        return rs_msg;
    }

    public void setRs_msg(String rs_msg) {
        this.rs_msg = rs_msg;
    }

    public static class DataBean {
        /**
         * count : 5
         * items : [{"id":45,"title":"坚果"},{"id":132,"title":"炒货"},{"id":166,"title":"蜜饯"},{"id":195,"title":"果脯"},{"id":196,"title":"礼盒"}]
         */

        private int count;
        private List<ItemsBean> items;

        public DataBean(int count, List<ItemsBean> items) {
            this.count = count;
            this.items = items;
        }

        public DataBean() {
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * id : 45
             * title : 坚果
             */

            private int id;
            private String title;

            public ItemsBean(int id, String title) {
                this.id = id;
                this.title = title;
            }

            public ItemsBean() {
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            @Override
            public String toString() {
                return "ItemsBean{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "count=" + count +
                    ", items=" + items +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "JsonBeanComplex{" +
                "data=" + data +
                ", rs_code='" + rs_code + '\'' +
                ", rs_msg='" + rs_msg + '\'' +
                '}';
    }
}
