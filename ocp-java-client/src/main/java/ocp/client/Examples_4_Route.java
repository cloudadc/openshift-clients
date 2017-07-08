package ocp.client;

import static ocp.client.AdaptClient.get;

import java.util.List;
import java.util.stream.Collectors;

import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.client.OpenShiftClient;

public class Examples_4_Route {

    public static void main(String[] args) {

        OpenShiftClient client = get();
        
        RouteList list = client.routes().list();
        list.getItems().forEach(r -> {
            System.out.println(r.getMetadata().getName() + ", " + r.getMetadata().getLabels() + "," + r.getSpec().getHost());
        });
        
        List<Route> result = list.getItems().stream().filter(r -> r.getMetadata().getName().equals("spring-boot-cxf-jaxrs")).collect(Collectors.toList());
        
        System.out.println(result.get(0).getSpec().getHost());
        
        result = list.getItems().stream().filter(r -> {
            return r.getMetadata().getLabels().get("type") != null && r.getMetadata().getLabels().get("type").equals("stocks-backend");
        }).collect(Collectors.toList());
        System.out.println(result.get(0).getSpec().getHost());
        
        
        client.close();
    }

}
    