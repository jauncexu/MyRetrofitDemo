package com.example.myretrofitdemo.bean;

import java.io.Serializable;
import java.util.List;

public class UserInfo {
    /**
     * coinInfo : {"coinCount":36662,"level":367,"nickname":"","rank":"3","userId":2,"username":"x**oyang"}
     * userInfo : {"admin":false,"chapterTops":[],"coinCount":36662,"collectIds":[],"email":"623565791@qq.com","icon":"","id":2,"nickname":"鸿洋","password":"","publicName":"鸿洋","token":"","type":0,"username":"xiaoyang"}
     */

    private CoinInfoBean coinInfo;
    private UserInfoBean userInfo;

    public CoinInfoBean getCoinInfo() {
        return coinInfo;
    }

    public void setCoinInfo(CoinInfoBean coinInfo) {
        this.coinInfo = coinInfo;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }


    public static class CoinInfoBean implements Serializable {
        /**
         * coinCount : 36662
         * level : 367
         * nickname :
         * rank : 3
         * userId : 2
         * username : x**oyang
         */

        private Integer coinCount;
        private Integer level;
        private String nickname;
        private String rank;
        private Integer userId;
        private String username;

        public Integer getCoinCount() {
            return coinCount;
        }

        public void setCoinCount(Integer coinCount) {
            this.coinCount = coinCount;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "CoinInfoBean{" +
                    "coinCount=" + coinCount +
                    ", level=" + level +
                    ", nickname='" + nickname + '\'' +
                    ", rank='" + rank + '\'' +
                    ", userId=" + userId +
                    ", username='" + username + '\'' +
                    '}';
        }
    }

    public static class UserInfoBean implements Serializable {
        /**
         * admin : false
         * chapterTops : []
         * coinCount : 36662
         * collectIds : []
         * email : 623565791@qq.com
         * icon :
         * id : 2
         * nickname : 鸿洋
         * password :
         * publicName : 鸿洋
         * token :
         * type : 0
         * username : xiaoyang
         */

        private Boolean admin;
        private Integer coinCount;
        private String email;
        private String icon;
        private Integer id;
        private String nickname;
        private String password;
        private String publicName;
        private String token;
        private Integer type;
        private String username;
        private List<?> chapterTops;
        private List<?> collectIds;

        public Boolean isAdmin() {
            return admin;
        }

        public void setAdmin(Boolean admin) {
            this.admin = admin;
        }

        public Integer getCoinCount() {
            return coinCount;
        }

        public void setCoinCount(Integer coinCount) {
            this.coinCount = coinCount;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPublicName() {
            return publicName;
        }

        public void setPublicName(String publicName) {
            this.publicName = publicName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<?> getChapterTops() {
            return chapterTops;
        }

        public void setChapterTops(List<?> chapterTops) {
            this.chapterTops = chapterTops;
        }

        public List<?> getCollectIds() {
            return collectIds;
        }

        public void setCollectIds(List<?> collectIds) {
            this.collectIds = collectIds;
        }

        @Override
        public String toString() {
            return "UserInfoBean{" +
                    "admin=" + admin +
                    ", coinCount=" + coinCount +
                    ", email='" + email + '\'' +
                    ", icon='" + icon + '\'' +
                    ", id=" + id +
                    ", nickname='" + nickname + '\'' +
                    ", password='" + password + '\'' +
                    ", publicName='" + publicName + '\'' +
                    ", token='" + token + '\'' +
                    ", type=" + type +
                    ", username='" + username + '\'' +
                    ", chapterTops=" + chapterTops +
                    ", collectIds=" + collectIds +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "coinInfo=" + coinInfo.toString() +
                ", userInfo=" + userInfo.toString() +
                '}';
    }
}
