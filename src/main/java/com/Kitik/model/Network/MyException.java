package com.Kitik.model.Network;

public class MyException extends Exception {
    public String InvalidCountOfClients() {
        return "Invalid count of Clients. Client < 0";

    }
}
