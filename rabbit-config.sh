printf "############# Configurando RabbitMQ #############"

printf "\n### Declarando Exchanges ###\n"

sudo docker exec -it rabbitmq rabbitmqadmin declare exchange name=person.data.request type=direct -u user -p user
sudo docker exec -it rabbitmq rabbitmqadmin declare exchange name=card.data.request type=direct -u user -p user

sudo docker exec -it rabbitmq rabbitmqadmin declare exchange name=person.data.response type=direct -u user -p user
sudo docker exec -it rabbitmq rabbitmqadmin declare exchange name=card.data.response type=direct -u user -p user

printf "\n### Declarando Queues ###\n"
sudo docker exec -it rabbitmq rabbitmqadmin declare queue name=person.data.request.queue durable=true -u user -p user
sudo docker exec -it rabbitmq rabbitmqadmin declare queue name=person.data.response.queue durable=true -u user -p user

sudo docker exec -it rabbitmq rabbitmqadmin declare queue name=card.data.request.queue durable=true -u user -p user
sudo docker exec -it rabbitmq rabbitmqadmin declare queue name=card.data.response.queue durable=true -u user -p user

printf "\n### Declarando Binding ###\n"
sudo docker exec -it rabbitmq rabbitmqadmin declare binding source=person.data.request destination=person.data.request.queue routing_key=person.data.request.routing.key -u user -p user
sudo docker exec -it rabbitmq rabbitmqadmin declare binding source=person.data.response destination=person.data.response.queue routing_key=person.data.response.routing.key -u user -p user

sudo docker exec -it rabbitmq rabbitmqadmin declare binding source=card.data.request destination=card.data.request.queue routing_key=card.data.request.routing.key -u user -p user
sudo docker exec -it rabbitmq rabbitmqadmin declare binding source=card.data.response destination=card.data.response.queue routing_key=card.data.response.routing.key -u user -p user