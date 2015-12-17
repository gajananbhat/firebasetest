package com.simulterra.firebasetest;

/**
 * Created by Administrator on 08/12/2015.
 */
public interface IContactController {

    public void setContactListener(IContactListener contactListener);

    public void getContacts();

    public void updateContact(Contact contact);

}
