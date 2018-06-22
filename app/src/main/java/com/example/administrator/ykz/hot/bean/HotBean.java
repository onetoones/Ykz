package com.example.administrator.ykz.hot.bean;

import com.example.administrator.ykz.base.MyBean;

import java.util.List;

public class HotBean extends MyBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 24
         * comments : [{"cid":277,"content":"\"你好啊我开了\"","createTime":"2018-03-21T22:47:24","jid":null,"mvp":null,"nickname":"给大哥点点关注","praiseNum":0,"uid":12472,"wid":282},{"cid":278,"content":"\"你好啊我开了\"","createTime":"2018-03-21T22:47:27","jid":null,"mvp":null,"nickname":"给大哥点点关注","praiseNum":0,"uid":12472,"wid":282},{"cid":279,"content":"\"你好啊我开了\"","createTime":"2018-03-21T22:47:29","jid":null,"mvp":null,"nickname":"给大哥点点关注","praiseNum":0,"uid":12472,"wid":282},{"cid":281,"content":"%E4%BD%A0%E7%8C%9C","createTime":"2018-03-22T17:49:38","jid":null,"mvp":null,"nickname":"给大哥点点关注","praiseNum":0,"uid":12472,"wid":282},{"cid":282,"content":"你好 啊","createTime":"2018-03-22T17:55:49","jid":null,"mvp":null,"nickname":"给大哥点点关注","praiseNum":0,"uid":12472,"wid":282},{"cid":289,"content":"轻轻巧巧","createTime":"2018-03-23T19:03:38","jid":null,"mvp":null,"nickname":"给大哥点点关注","praiseNum":0,"uid":12472,"wid":282},{"cid":297,"content":"好6","createTime":"2018-03-24T16:44:59","jid":null,"mvp":null,"nickname":"你好","praiseNum":0,"uid":12377,"wid":282},{"cid":298,"content":"厉害","createTime":"2018-03-24T16:51:03","jid":null,"mvp":null,"nickname":"你好","praiseNum":0,"uid":12377,"wid":282},{"cid":299,"content":"你好厉害啊","createTime":"2018-03-24T16:51:39","jid":null,"mvp":null,"nickname":"你好","praiseNum":0,"uid":12377,"wid":282},{"cid":322,"content":"%E6%9D%A5%E4%BA%86","createTime":"2018-04-02T16:06:39","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":282},{"cid":326,"content":"%25E6%2588%2591%25E7%259A%2584","createTime":"2018-04-02T16:41:23","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":282},{"cid":336,"content":"\"很好\"","createTime":"2018-04-12T19:27:26","jid":null,"mvp":null,"nickname":"起名好难","praiseNum":0,"uid":10680,"wid":282},{"cid":392,"content":"啊啊啊","createTime":"2018-06-12T21:54:10","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":397,"content":"好好好","createTime":"2018-06-12T22:09:58","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":398,"content":"222","createTime":"2018-06-12T22:12:53","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":399,"content":"123","createTime":"2018-06-12T22:16:44","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":400,"content":"564","createTime":"2018-06-12T22:18:28","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":401,"content":"1","createTime":"2018-06-12T22:23:55","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":402,"content":"55","createTime":"2018-06-12T22:26:21","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":408,"content":"太郎","createTime":"2018-06-13T14:48:15","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":409,"content":"555","createTime":"2018-06-13T14:51:05","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":410,"content":"123","createTime":"2018-06-13T14:53:00","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282},{"cid":413,"content":"哥就是不一样","createTime":"2018-06-13T15:13:55","jid":null,"mvp":null,"nickname":"丿当年人","praiseNum":0,"uid":13900,"wid":282},{"cid":414,"content":"12","createTime":"2018-06-13T15:31:49","jid":null,"mvp":null,"nickname":null,"praiseNum":0,"uid":2845,"wid":282}]
         * cover : https://www.zhaoapi.cn/images/quarter/1517733899967video_cover_fucking.jpg
         * createTime : 2018-02-04T16:44:59
         * favoriteNum : 20
         * latitude : 39.95
         * localUri : null
         * longitude : 116.30
         * playNum : 1088
         * praiseNum : 16
         * uid : 3881
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1517574153932AndroidFightingIphone3.png","nickname":"我不是杨犊子","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1517733899967video_fucking_awesome.mp4
         * wid : 282
         * workDesc : 姑娘放开那个武器让我来
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<CommentsBean> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1517574153932AndroidFightingIphone3.png
             * nickname : 我不是杨犊子
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }

        public static class CommentsBean {
            /**
             * cid : 277
             * content : "你好啊我开了"
             * createTime : 2018-03-21T22:47:24
             * jid : null
             * mvp : null
             * nickname : 给大哥点点关注
             * praiseNum : 0
             * uid : 12472
             * wid : 282
             */

            private int cid;
            private String content;
            private String createTime;
            private Object jid;
            private Object mvp;
            private String nickname;
            private int praiseNum;
            private int uid;
            private int wid;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getJid() {
                return jid;
            }

            public void setJid(Object jid) {
                this.jid = jid;
            }

            public Object getMvp() {
                return mvp;
            }

            public void setMvp(Object mvp) {
                this.mvp = mvp;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }
        }
    }
}
