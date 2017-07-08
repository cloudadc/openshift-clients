package ocp.client;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;

public class AdaptClient {
    
    @SuppressWarnings("resource")
    public static OpenShiftClient get() {
//        Config config = new ConfigBuilder()
//                .withMasterUrl("https://master.na1.openshift.opentlc.com")
//                .withUsername("user")
//                .withPassword("password")
//                .build();
//        KubernetesClient client = new DefaultKubernetesClient(config);
//        
        KubernetesClient client = new DefaultKubernetesClient();
        OpenShiftClient oclient = client.adapt(OpenShiftClient.class);
        return oclient;
    }
    
    static void promp(String action, Object... items) {
        System.out.print(action + ": ");
        boolean comma = false;
        for(Object obj : items) {
            if(comma) {
                System.out.print(",  ");
            } else {
                comma = true;
            }
            System.out.print(obj);
        }
        System.out.println();
    }

    static void log(Object... items) {
        boolean comma = false;
        for(Object obj : items) {
            if(comma) {
                System.out.print(",  ");
            } else {
                comma = true;
            }
            System.out.print(obj);
        }
        System.out.println();
        
    }
    
    static void log() {
        System.out.println();
    }

}
