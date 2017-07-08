package ocp.client;

import static ocp.client.AdaptClient.*;

import io.fabric8.kubernetes.api.model.ServiceList;

import io.fabric8.openshift.client.OpenShiftClient;

public class Examples_3_Services_Yaml {

    public static void main(String[] args) {

        OpenShiftClient client = get();
        
        ServiceList services = client.services().list();
        services.getItems().forEach(service -> {
            promp("apiVersion", service.getApiVersion());
            promp("kind", service.getKind());
            promp("metadata", service.getMetadata());
            promp("spec", service.getSpec());
            promp("  clusterIP", service.getSpec().getClusterIP());
            promp("  ports", service.getSpec().getPorts());
            promp("  selector", service.getSpec().getSelector() );
            promp("  sessionAffinity", service.getSpec().getSessionAffinity());
            promp("  type", service.getSpec().getType());
            promp("status", service.getStatus());
            log();
        });
        
        client.close();
    }

}
