package org.maslov.nback.controller.rest.v1;

public interface RestApiNamesV1 {

    String API_V1 = "/v1";

    String API_V1_AUTH = API_V1 + "/auth";

    String PUBLIC = "/public";
    String PRIVATE = "/private";
    String API_V1_PUBLIC = API_V1 + PUBLIC;

    String API_V1_PUBLIC_ABC = API_V1_PUBLIC + "/abc";
    String API_V1_PUBLIC_ALL = API_V1_PUBLIC + "/**";

    String API_V1_PRIVATE = API_V1 + PRIVATE;
    String API_V1_PRIVATE_ALL = API_V1_PRIVATE + "/**";
    String LOGIN = "/login";
    String API_V1_AUTH_LOGIN = API_V1_AUTH + LOGIN;

}
