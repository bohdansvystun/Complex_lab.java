package com.Kitik.model.Network;

import java.io.Serializable;
import java.util.List;

public class GetFromFile implements Serializable {

    private final List<MobileOperator> list;


    public final List<MobileOperator> getForFile() {
        return list;
    }

    public GetFromFile(List<MobileOperator> listParam) {
        this.list = listParam;
    }
}
