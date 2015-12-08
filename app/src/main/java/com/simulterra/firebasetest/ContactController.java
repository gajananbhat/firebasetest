package com.simulterra.firebasetest;

/**
 * Created by Administrator on 08/12/2015.
 */
public interface ContactController {

    public void setContactListener(ContactListener contactListener);

    public void getContacts();

    public void updateContact(Contact contact);

}
