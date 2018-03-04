package com.dinesh.json_test;

/**
 * Created by gspl-dd on 6/2/18.
 */

public class Something {


    String name,imageurl,age;

    public Something(String name, String imageurl, String age) {

        this.name=name;
        this.imageurl=imageurl;
        this.age=age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
