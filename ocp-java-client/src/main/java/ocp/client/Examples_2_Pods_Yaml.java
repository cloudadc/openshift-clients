package ocp.client;

import static ocp.client.AdaptClient.*;

import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.PodStatus;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.openshift.client.OpenShiftClient;

public class Examples_2_Pods_Yaml {

    public static void main(String[] args) {


        OpenShiftClient client = get();
        
        MixedOperation<Pod, PodList, DoneablePod, PodResource<Pod, DoneablePod>> operation = client.pods();
        PodList pods = operation.list();
        pods.getItems().forEach(pod -> {
            PodStatus status = pod.getStatus();
            ObjectMeta meta = pod.getMetadata();
            PodSpec spec = pod.getSpec();
            promp("apiVersion", pod.getApiVersion());
            promp("kind", pod.getKind());
            promp("metadata", "");
            promp("  annotations", meta.getAnnotations());
            promp("  creationTimestamp", meta.getCreationTimestamp());
            promp("  generateName", meta.getGenerateName());
            promp("  labels", meta.getLabels());
            promp("  name", meta.getName());
            promp("  namespace", meta.getNamespace());
            promp("  resourceVersion", meta.getResourceVersion());
            promp("  selfLink", meta.getSelfLink());
            promp("  uid", meta.getUid());
            promp("spec", "");
            promp("  containers", spec.getContainers());
            promp("  dnsPolicy", spec.getDnsPolicy());
            promp("  nodeName", spec.getNodeName());
            promp("  nodeSelector", spec.getNodeSelector());
            promp("  volumes", spec.getVolumes());
            promp("  serviceAccount", spec.getServiceAccount());
            promp("  securityContext", spec.getSecurityContext());
            promp("  serviceAccountName", spec.getServiceAccountName());
            promp("status", "");
            promp("  conditions", status.getConditions());
            promp("  containerStatuses", status.getContainerStatuses());
            promp("hostIP", status.getHostIP());
            promp("phase", status.getPhase());
            promp("podIP", status.getPodIP());
            promp("startTime", status.getStartTime());
        
            log();
        });

        client.close();
    }

}
