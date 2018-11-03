kubectl expose deployment back-deployment --type=LoadBalancer --name=back-service
kubectl expose deployment front-deployment --type=LoadBalancer --name=front-service
kubectl expose deployment database-deployment --type=NodePort --name=database-service