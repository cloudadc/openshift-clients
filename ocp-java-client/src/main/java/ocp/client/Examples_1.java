package ocp.client;

import static ocp.client.AdaptClient.*;


import io.fabric8.openshift.client.OpenShiftClient;

public class Examples_1 {

    public static void main(String[] args) {

        OpenShiftClient client = get();
        
        log(client.getMasterUrl());
        log(client.getApiVersion());
        log(client.getNamespace());
        log(client.getOpenshiftUrl());
        log(client.rootPaths());
        log();
        
        
        
        client.close();
    }

}
