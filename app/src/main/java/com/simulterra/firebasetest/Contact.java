package com.simulterra.firebasetest;

/**
 * Created by Gajanan on 07/12/2015.
 */
public class Contact
{

    //field names
    private static final String cnUId = "id";
    private static final String cnFullName = "name";
    private static final String cnUserName = "userName";
    private static final String cnEmail = "email";
    private static final String cnPhoneNumber = "phoneNumber";

    private static final String MODEL_NAME = "contact";

    private final String TAG = this.getClass().getSimpleName();

    private String id;
    private String authId;
    private String phoneNumber;
    private String fullName;
    private String userName;
    private String emailId;
    private String deviceId;
    private String registrationId;
    private String createdOn;
    private String updatedOn;

    private String password;

    public Contact() {}

    public Contact(String fullName, String userName, String emailId, String phoneNumber, String deviceId, String regId)
    {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.userName = userName;
        this.emailId = emailId;
        this.deviceId = deviceId;
        this.registrationId = regId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}
