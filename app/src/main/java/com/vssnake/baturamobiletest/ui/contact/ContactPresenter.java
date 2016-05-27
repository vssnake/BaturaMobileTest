package com.vssnake.baturamobiletest.ui.contact;

import com.vssnake.baturamobiletest.ui.BasePresenter;


/**
 * Created by Unai Correa on 2016 @vssnake.
 * Email : unai.correa@gmail.com
 */
public class ContactPresenter extends BasePresenter<ContactView> {


    public ContactPresenter(ContactView contactView) {
        super(contactView);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void onMapClicked(){
        if (getView() != null){
            getView().showMap();
        }
    }
}
