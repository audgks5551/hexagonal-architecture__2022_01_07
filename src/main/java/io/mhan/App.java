package io.mhan;

import io.mhan.framework.input.RouterViewCLIAdapter;

public class App {

    public static void main(String... args) {
        var cli = new RouterViewCLIAdapter();
        var type = "CORE";
        System.out.println(cli.obtainRelatedRouters(type));
    }
}