package com.blueocn.api.kong.client.impl;

import com.blueocn.api.kong.client.OAuth2Client;
import com.blueocn.api.kong.connector.Connector;
import com.blueocn.api.kong.connector.consumers.OAuth2Connector;
import com.blueocn.api.kong.model.consumers.OAuth2;
import com.blueocn.api.kong.model.consumers.OAuth2s;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Title: OAuth2ClientImpl
 * Description:
 *
 * @author Yufan
 * @version 1.0.0
 * @since 2016-03-01 18:15
 */
@Component
public class OAuth2ClientImpl implements OAuth2Client {

    @Autowired
    private Connector connector;

    private OAuth2Connector oAuth2Connector;

    @PostConstruct
    private void init() {
        oAuth2Connector = connector.create(OAuth2Connector.class);
    }

    @Override
    public OAuth2 add(String consumerId, OAuth2 oAuth2) throws IOException {
        Call<OAuth2> call = oAuth2Connector.add(consumerId, oAuth2);
        Response<OAuth2> response = call.execute();
        if (response.isSuccess()) {
            return response.body();
        }
        return null;
    }

    @Override
    public OAuth2s query(String consumerId, OAuth2 oAuth2) throws IOException {
        Call<OAuth2s> call = oAuth2Connector.query(consumerId, oAuth2 == null ? null : oAuth2.toMap());
        Response<OAuth2s> response = call.execute();
        if (response.isSuccess()) {
            return response.body();
        }
        return null;
    }

    @Override
    public OAuth2 queryOne(String consumerId, String oauth2Id) throws IOException {
        Call<OAuth2> call = oAuth2Connector.queryOne(consumerId, oauth2Id);
        Response<OAuth2> response = call.execute();
        if (response.isSuccess()) {
            return response.body();
        }
        return null;
    }

    @Override
    public OAuth2 update(String consumerId, String oauth2Id, OAuth2 oAuth2) throws IOException {
        Call<OAuth2> call = oAuth2Connector.update(consumerId, oauth2Id, oAuth2);
        Response<OAuth2> response = call.execute();
        if (response.isSuccess()) {
            return response.body();
        }
        return null;
    }

    @Override
    public void delete(String consumerId, String oauth2Id) throws IOException {
        oAuth2Connector.delete(consumerId, oauth2Id).execute();
    }
}