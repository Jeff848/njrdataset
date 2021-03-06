/*
Copyright (c) 2007-2009, Yusuke Yamamoto
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the Yusuke Yamamoto nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY Yusuke Yamamoto ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Yusuke Yamamoto BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package com.sohu.t.api.sdk;

import com.sohu.t.api.sdk.data.*;
import com.sohu.t.api.sdk.http.*;
import com.sohu.t.api.sdk.json.JSONArray;
import com.sohu.t.api.sdk.json.JSONException;
import com.sohu.t.api.sdk.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author chenxj
 */
public class TBlog extends TBlogSupport {

    private String baseURL = "http://api.t.sohu.com/";

    private String redirectURL;

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public TBlog() {
        this(OAuthVersion.V1);
    }

    public TBlog(OAuthVersion version) {

        super();
        format.setTimeZone(TimeZone.getTimeZone("GMT"));

        if (version == OAuthVersion.V2) {
            this.baseURL = "https://api.t.sohu.com/";
            this.http.setHttps(true);
        }
    }

    public void setOAuth2AccessToken(String token) {
        http.setOAuth2AccessToken(token);
    }

    public void setToken(String token, String tokenSecret) {
        http.setToken(token, tokenSecret);
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getBaseURL() {
        return this.baseURL;
    }

    public synchronized void setOAuthConsumer(String consumerKey, String consumerSecret) {
        this.http.setOAuthConsumer(consumerKey, consumerSecret);
    }

    public RequestToken getOAuthRequestToken() throws TBlogException {
        return http.getOAuthRequestToken();
    }

    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken) throws TBlogException {
        return http.getOAuthAccessToken(requestToken);
    }

    public synchronized AccessToken getOAuthAccessToken(String token, String tokenSecret) throws TBlogException {
        AccessToken accessToken = http.getOAuthAccessToken(token, tokenSecret);
        setUserId(accessToken.getScreenName());
        return accessToken;
    }

    public AccessToken getXAuthAccessToken(String passport, String password) throws TBlogException {
        return this.http.getXAuthAccessToken(passport, password, false);
    }

    public AccessToken getXAuthAccessToken(String passport, String password, boolean isMD5) throws TBlogException {
        return this.http.getXAuthAccessToken(passport, password, isMD5);
    }

    public String getOAuth2AuthorizeURL() throws TBlogException {
        return this.http.getOAuth2AuthorizeURL(redirectURL);
    }

    public String getOAuth2AuthorizeTokenURL() throws TBlogException {
        return this.http.getOAuth2AuthorizeTokenURL(redirectURL);
    }

    public OAuth2AccessToken getOAuth2AccessTokenByCode(String code) throws TBlogException {
        return this.http.getOAuth2AccessTokenByCode(code, redirectURL);
    }

    public OAuth2AccessToken getOAuth2AccessTokenByRefreshToken(String refreshToken) throws TBlogException {
        return this.http.getOAuth2AccessTokenByRefreshToken(refreshToken);
    }

    public OAuth2AccessToken getOAuth2AccessTokenByPassword(String username, String password) throws TBlogException {
        return this.http.getOAuth2AccessTokenByPassword(username, password);
    }

    //SDK request method wrapper begin

    /**
     * ???????????????????????????????????????
     *
     * @return
     * @throws TBlogException
     */
    public List<Status> getHomeTimeline() throws TBlogException {
        return Status.constructStatuses(get(getBaseURL() + "statuses/friends_timeline.json", true));
    }


    /**
     * ?????????????????????????????????(????????????)
     *
     * @return
     * @throws TBlogException
     */
    public List<Status> getPublicTimeline() throws TBlogException {
        return Status.constructStatuses(get(getBaseURL() + "statuses/public_timeline.json", false));
    }


    /**
     * ????????????????????????
     *
     * @return
     * @throws TBlogException
     */
    public List<Status> getMyTweets() throws TBlogException {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline.json", true));
    }


    /**
     * ?????????????????????????????????
     *
     * @param userId ??????id
     * @return
     * @throws TBlogException
     */
    public List<Status> getUserTimeline(long userId) throws TBlogException {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline/" + String.valueOf(userId) + ".json", true));
    }

    /**
     * ?????????????????????????????????
     *
     * @param screenName ????????????
     * @return
     * @throws TBlogException
     */
    public List<Status> getUserTimeline(String screenName) throws TBlogException {
        return Status.constructStatuses(get(getBaseURL() + "statuses/user_timeline/" + screenName + ".json", true));
    }

    /**
     * ??????@???????????????????????????????????????
     *
     * @return
     * @throws TBlogException
     */
    public List<Status> getMentions() throws TBlogException {
        return Status.constructStatuses(get(getBaseURL() + "statuses/mentions_timeline.json", true));
    }


    /**
     * ?????????????????????????????????
     *
     * @param id ??????id
     * @return
     * @throws TBlogException
     */
    public List<Status> getComments(long id) throws TBlogException {
        return Status.constructStatuses(get(getBaseURL() + "statuses/comments/" + String.valueOf(id) + ".json", true));
    }


    /**
     * ???????????????????????????
     *
     * @return
     * @throws TBlogException
     */
    public List<Status> getCommentsToMe() throws TBlogException {
        JSONObject json = get(getBaseURL() + "statuses/comments_timeline.json", true).asJSONObject();
        JSONArray commentsJsonArray = null;
        try {
            commentsJsonArray = json.getJSONArray("comments");
        } catch (JSONException je) {

        }
        return Status.constructStatuses(commentsJsonArray);
    }

    /**
     * ?????????????????????????????????
     *
     * @return
     * @throws TBlogException
     */
    public Status show(long statusId) throws TBlogException {
        return new Status(http.get(getBaseURL() + "statuses/show/" + String.valueOf(statusId) + ".json", true));
    }


    /**
     * ??????????????????
     *
     * @param status ???????????????????????????163?????????
     * @return
     * @throws TBlogException
     */
    public Status updateStatus(String status) throws TBlogException {
        return new Status(http.post(getBaseURL() + "statuses/update.json", new PostParameter[]{new PostParameter("status", status)}, true));
    }


    /**
     * ????????????????????????
     *
     * @param status ???????????????????????????163?????????
     * @return
     * @throws TBlogException
     */
    public String uploadStatus(String status, File file) throws TBlogException {
        JSONObject json = http.multPartURL("pic", getBaseURL() + "statuses/upload.json", new PostParameter[]{new PostParameter("status", status)},
                file, true).asJSONObject();
        return json.toString();
    }

    /**
     * ?????????????????????????????????????????????????????????
     *
     * @param statusId ??????????????????????????????ID
     * @return
     * @throws TBlogException
     */
    public Status destroy(long statusId) throws TBlogException {
        return new Status(http.post(getBaseURL() + "statuses/destroy/" + String.valueOf(statusId) + ".json", true));
    }

    /**
     * ??????????????????
     *
     * @param id     ??????ID
     * @param status ????????????
     * @return
     * @throws TBlogException
     */
    public Status retweet(long id, String status) throws TBlogException {
        JSONObject json = http.post(getBaseURL() + "statuses/transmit/" + String.valueOf(id) + ".json",
                new PostParameter[]{new PostParameter("status", status)}, true).asJSONObject();
        try {
            if (!json.isNull("retweeted_status")) {
                return new Status(json.getJSONObject("retweeted_status"));
            } else {
                return null;
            }
        } catch (JSONException e) {
            throw new TBlogException(e);
        }
    }


    /**
     * ??????????????????
     *
     * @param id      ??????????????????id
     * @param comment ????????????
     * @return
     * @throws TBlogException
     */
    public Status reply(long id, String comment) throws TBlogException, JSONException {
        PostParameter[] params = new PostParameter[]{
                new PostParameter("id", String.valueOf(id)),
                new PostParameter("comment", comment),
        };
        return new Status(http.post(getBaseURL() + "statuses/comment.json", params, true));
    }


    /**
     * ??????????????????
     *
     * @param id ???????????????id
     * @return
     * @throws TBlogException
     */
    public Status destroyReply(long id) throws TBlogException, JSONException {

        return new Status(http.post(getBaseURL() + "statuses/comment_destroy/" + String.valueOf(id) + ".json", true));
    }


    /**
     * ????????????id?????????????????????????????????????????????
     *
     * @return
     * @throw TBlogException
     */
    public Counts getMsgCounts(long msgId) throws TBlogException {
        return new Counts(http.get(getBaseURL() + "statuses/counts/" + msgId + ".json", true));
    }

    /**
     * ????????????
     * ????????????id?????????????????????????????????????????????
     *
     * @return
     * @throw TBlogException
     */
    public List<Counts> getBatchMsgCounts(String... msgIds) throws TBlogException {
        StringBuffer sb = new StringBuffer();
        for (String id : msgIds) {
            sb.append(id).append(",");
        }
        String msgs = "";
        if (sb != null && ",".equals(sb.substring(sb.length() - 1))) {
            msgs = sb.substring(0, sb.length() - 1);
        }

        return Counts.constructStatuses(http.get(getBaseURL() + "statuses/counts.json?ids=" + msgs, true));
    }

    /**
     * ?????????????????????????????????????????????????????????????????????@???????????????????????????????????????????????????????????????????????????
     *
     * @return
     * @throws TBlogException
     */
    public NewCounts getNewCounts() throws TBlogException {
        return new NewCounts(http.get(getBaseURL() + "statuses/check.json", true));
    }

    /**
     * ????????????
     *
     * @return
     * @throws TBlogException
     */
    public Status uploadVideo(String videoUrl) throws TBlogException {
        PostParameter[] params = new PostParameter[]{
                new PostParameter("videoUrl", videoUrl),
        };
        return new Status(http.post(getBaseURL() + "statuses/video.json", params, true));
    }


    /**
     * ??????????????????
     *
     * @return
     * @throws TBlogException
     */
    public User showUser() throws TBlogException {
        return new User(http.get(getBaseURL() + "users/show.json", true));

    }

    /**
     * ??????????????????
     *
     * @param userId
     * @return
     * @throws TBlogException
     */
    public User showUser(long userId) throws TBlogException {
        return new User(http.get(getBaseURL() + "users/show/" + String.valueOf(userId) + ".json", true));

    }

    /**
     * ??????????????????
     *
     * @param screenName
     * @return
     * @throws TBlogException
     */
    public User showUser(String screenName) throws TBlogException {
        return new User(http.get(getBaseURL() + "users/show/" + screenName + ".json", true));
    }


    /**
     * ????????????a??????????????????b
     *
     * @param uidA
     * @param uidB
     * @return
     */
    public JSONObject isFollowing(long uidA, long uidB) throws TBlogException {
        return http.get(getBaseURL() + "friendships/exists.json?user_a=" +
                String.valueOf(uidA) + "&user_b=" + String.valueOf(uidB), true).asJSONObject();
    }

    /**
     * ????????????a??????????????????b
     *
     * @param ScreenNameA
     * @param ScreenNameB
     * @return
     */
    public JSONObject isFollowing(String ScreenNameA, String ScreenNameB) throws TBlogException {
        return http.get(getBaseURL() + "friendships/exists.json?screen_name_a=" +
                ScreenNameA + "&screen_name_b=" + ScreenNameB, true).asJSONObject();
    }

    /**
     * ???????????????????????????
     *
     * @param sourceUid
     * @param targetUid
     * @return
     */
    public JSONObject showRelationShip(long sourceUid, long targetUid) throws TBlogException {
        return http.get(getBaseURL() + "friendships/show.json?source_id=" + sourceUid +
                "&target_id=" + targetUid, true).asJSONObject();
    }

    /**
     * ???????????????????????????
     *
     * @param sourceScreenName
     * @param targetScreenName
     * @return
     */
    public JSONObject showRelationShip(String sourceScreenName, String targetScreenName) throws TBlogException {
        return http.get(getBaseURL() + "friendships/show.json?source_screen_name=" + sourceScreenName +
                "&target_screen_name=" + targetScreenName, true).asJSONObject();
    }

    /**
     * ????????????
     *
     * @param uid
     * @return
     */
    public User addFollow(long uid) throws TBlogException {
        return new User(http.post(getBaseURL() + "friendships/create/" + String.valueOf(uid) + ".json", true));
    }

    /**
     * ????????????
     *
     * @param screenName
     * @return
     */
    public User addFollow(String screenName) throws TBlogException {
        return new User(http.post(getBaseURL() + "friendships/create/" + screenName + ".json", true));
    }

    /**
     * ????????????
     *
     * @param uid
     * @return
     */
    public User cancelFollow(long uid) throws TBlogException {
        return new User(http.post(getBaseURL() + "friendships/destroy/" + String.valueOf(uid) + ".json", true));
    }

    /**
     * ????????????
     *
     * @param screenName
     * @return
     */
    public User cancelFollow(String screenName) throws TBlogException {
        return new User(http.post(getBaseURL() + "friendships/destroy/" + screenName + ".json", true));
    }

    /**
     * ??????????????????
     *
     * @param
     * @return
     */
    public List<User> getFriendsList(long userId) throws TBlogException {
        return User.constructUsers(http.get(getBaseURL() + "statuses/friends/" + String.valueOf(userId) + ".json", true).asJSONArray());
    }

    /**
     * ??????????????????
     *
     * @param userId
     * @return
     */
    public List<User> getFollowsList(long userId) throws TBlogException {
        return User.constructUsers(http.get(getBaseURL() + "statuses/followers/" + String.valueOf(userId) + ".json", true).asJSONArray());
    }

    /**
     * ????????????????????????
     *
     * @return
     */
    public List<Message> getRecieveDirectMessages() throws TBlogException {
        return Message.constructMessages(http.get(getBaseURL() + "direct_messages.json", true));
    }

    /**
     * ????????????????????????
     *
     * @return
     */
    public List<Message> getSendDirectMessages() throws TBlogException {
        return Message.constructMessages(http.get(getBaseURL() + "direct_messages/sent.json", true));
    }

    /**
     * ?????????
     *
     * @return
     */
    public Message sendDirectMessage(String userId, String text) throws TBlogException {
        PostParameter[] params = new PostParameter[]{
                new PostParameter("user", userId),
                new PostParameter("text", text)
        };
        return new Message(http.post(getBaseURL() + "direct_messages/new.json", params, true));
    }


    /**
     * ????????????
     *
     * @param mailId
     * @param type   in:????????? out:?????????
     * @return
     */
    public JSONObject destroyDirectMessage(long mailId, String type) throws TBlogException {
        return (http.post(getBaseURL() + "direct_messages/destroy/" + mailId + ".json?type=" + type, true)).asJSONObject();

    }


    /**
     * ???????????????????????????
     *
     * @return
     * @throws TBlogException
     */
    public List<Status> getFavorites() throws TBlogException {
        return Status.constructStatuses(get(getBaseURL() + "favourites.json", true));
    }

    /**
     * ????????????
     *
     * @param msgId ??????????????????ID
     * @return
     * @throws TBlogException
     */
    public Status createFavorite(long msgId) throws TBlogException {
        return new Status(http.post(getBaseURL() + "favourites/create/" + String.valueOf(msgId) + ".json", true));
    }

    /**
     * ???????????????????????????
     *
     * @param id ????????????????????????ID
     * @return
     * @throws TBlogException
     */
    public Status destroyFavorite(long id) throws TBlogException {
        return new Status(http.post(getBaseURL() + "favourites/destroy/" + String.valueOf(id) + ".json", true));
    }

    /**
     * ????????????????????????????????????????????????????????????
     *
     * @return
     * @throws TBlogException
     */
    public User verifyCredentials() throws TBlogException {
        return new User(get(getBaseURL() + "account/verify_credentials.json", true));
    }

    /**
     * ????????????
     *
     * @param file ???????????? jpg, gif, png
     * @return
     * @throws TBlogException
     */
    public User updateProfileImage(File file) throws TBlogException {
        Response res = http.multPartURL("image", getBaseURL() + "account/update_profile_image.json", new PostParameter[0], file, true);
        return new User(res);
    }


    /**
     * ??????????????????
     * ????????????????????????????????????????????????
     *
     * @param nickName    ??????
     * @param email       ??????
     * @param gender      ?????? 0?????????1??????
     * @param description ????????????
     * @throws
     */
    public User updateProfile(String nickName, String email, String gender, String description) throws TBlogException {
        PostParameter[] params = new PostParameter[]{
                new PostParameter("nick_name", nickName),
                new PostParameter("email", email),
                new PostParameter("gender", gender),
                new PostParameter("description", description),
        };

        return new User(http.post(getBaseURL() + "account/update_profile.json", params, true));
    }


    /**
     * ???????????????????????????
     *
     * @param shortDomain ?????????
     * @return
     * @throws
     */
    public User updateProfileDomain(String shortDomain) throws TBlogException {
        PostParameter[] params = new PostParameter[]{
                new PostParameter("short_domain", shortDomain)
        };
        return new User(http.post(getBaseURL() + "account/update_profile_domain.json", params, true));

    }

    /**
     * ????????????????????????
     *
     * @return
     * @throws
     */
    public RateLimitStatus getRateLimitStatus() throws TBlogException {
        return new RateLimitStatus(get(getBaseURL() + "account/rate_limit_status.json", true));
    }

    /**
     * ????????????
     *
     * @return
     * @throws
     */
    public List<User> searchUsers(String query) throws TBlogException {
        return User.constructUsers(get(getBaseURL() + "users/search.json?q=" + query, true).asJSONArray());
    }


    /**
     * ???????????? ??????Search?????????
     *
     * @return
     * @throws
     */
    public List<Search> searchTweets(String query) throws TBlogException, JSONException {
        JSONObject result = get(getBaseURL() + "search.json?q=" + query, true).asJSONObject();
        JSONArray searches = result.getJSONArray("results");
        return Search.constructSearches(searches);
    }


    /**
     * ???????????? ??????Status?????????
     *
     * @return
     * @throws
     */
    public List<Status> searchTweetsStatus(String query) throws TBlogException, JSONException {
        JSONObject result = get(getBaseURL() + "statuses/search.json?q=" + query, true).asJSONObject();
        JSONArray statuses = result.getJSONArray("statuses");
        return Status.constructStatuses(statuses);
    }


    // request wrapper end

    private SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);

    private Response get(String url, boolean authenticated) throws TBlogException {
        return http.get(url, authenticated);
    }


}
