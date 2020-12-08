package me.border.multigamescore.communication.request.client;

import me.border.multigamescore.communication.security.AsymmetricEncryptor;

import java.security.PublicKey;

public class ClientRequestBuilder {

    private PublicKey key;

    public KeyRequest createKeyRequest(){
        return new KeyRequest();
    }

    public LoginRequest createLoginRequest(String username, String password){
        String encryptedUsername = AsymmetricEncryptor.encrypt(key, username);
        String encryptedPassword = AsymmetricEncryptor.encrypt(key, password);

        return new LoginRequest(encryptedUsername, encryptedPassword);
    }

    public void setKey(PublicKey key) {
        this.key = key;
    }
}
