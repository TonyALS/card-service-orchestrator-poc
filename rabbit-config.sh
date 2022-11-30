echo "############# Configurando RabbitMQ #############"

echo "### Declarando Exchanges ###"

sudo docker exec -it rabbitmq rabbitmqadmin declare exchange name=person.data.request type=direct -u user -p user
sudo docker exec -it rabbitmq rabbitmqadmin declare exchange name=person.data.response type=direct -u user -p user

echo "\n### Declarando Queues ###"
sudo docker exec -it rabbitmq rabbitmqadmin declare queue name=person.data.request.queue durable=true -u user -p user
sudo docker exec -it rabbitmq rabbitmqadmin declare queue name=person.data.response.queue durable=true -u user -p user

echo "\n### Declarando Binding ###"
sudo docker exec -it rabbitmq rabbitmqadmin declare binding source=person.data.request destination=person.data.request.queue routing_key=person.data.request.routing.key -u user -p user
sudo docker exec -it rabbitmq rabbitmqadmin declare binding source=person.data.response destination=person.data.response.queue routing_key=person.data.response.routing.key -u user -p user
