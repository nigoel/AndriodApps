package com.example.nigoel.stayintouch;

/**
 * Created by nigoel on 12/17/2015.
 */
public class CardInfo {
    private String nickName;
    private String mobileNumber;
    private String officeNumber;
    private String designation;
    private String address;
    private String officeAddress;
    private String fbAddress;
    private String linkedInAddress;
    private String twitterHandle;

    public static CardInfo getNewCardInfo() {
        return new CardInfo();
    }
}
