## exposing a service of type load balancer

kubectl expose deployment hello-world --type=LoadBalancer --name=my-service


## example of a deployment yaml

apiVersion: apps/v1
kind: Deployment
metadata:
  name: vote
spec:
  replicas: 3
  selector:
    matchLabels:
      app: vote
  template:
    metadata:
      labels:
        app: vote
    spec:
      containers:
      - name: vote
        image: instavote/vote
        ports:
        - containerPort: 80
        volumeMounts:
        - mountPath: "/opt/conf"
          name: config
        env:
        - name: application_variable_name
          valueFrom:
             secretKeyRef:
                 name: secret-name
                 key: secret-key
      volumes:
      - name: config
        configMap: 
          name: secret-config  
        
# creating a secret

apiVersion: v1
kind: Secret
metadata:
  name: secret-name
data:
  mongo_url: value encoded in base64
  
  
# create a configMap
kubectl create configmap name --from-file=./


# externalize spring configuration to an external file

ENTRYPOINT ["java", "-jar", "/opt/kubernetes.jar", "--spring.config.location=file:/opt/conf/application.properties"]